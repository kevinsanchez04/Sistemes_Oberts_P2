package service;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import authn.Secured;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.Base64;
import java.util.LinkedList;
import model.entities.Article;
import model.entities.ArticleDTO;
import model.entities.ArticleGQ;
import model.entities.Customer;
import model.entities.ArticleIN;
import model.entities.Topic;

@Stateless
@Path("article")
public class ArticleFacadeRest extends AbstractFacade<Article> {

    @PersistenceContext(unitName = "Homework1PU")
    private EntityManager em;

    public ArticleFacadeRest() {
        super(Article.class);
    }
    
    // POST /rest/api/v1/article
    @POST
    @Secured
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createArticle(ArticleIN article){
        if(isTopicValid(article.getTopics()) && resumText(article)){
            Article art = new Article(article);
            art.setData(LocalDate.now());
            Customer cus = findName(article.getAutor());
            if(cus != null){
                art.setAutor(cus);
            }else{
                return Response.status(Response.Status.BAD_REQUEST).entity("There is something WRONG in the AUTOR").build();
            }
            cus.addArticle(art);
            super.create(art);
            return Response.status(Response.Status.CREATED).entity("The id of the article is == "+art.getId()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("There is something WRONG").build();
    }
    
    //GET /rest/api/v1/article
    //GET /rest/api/v1/article?topic=${topic}&author=${author}
    @GET 
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
    public Response getQuery(@QueryParam("topic") List<Topic> topic,@QueryParam("author") String customer) { 
        if (topic.size() > 2 ){
            return Response.status(Response.Status.BAD_REQUEST).entity("Ens has passat més de dos topics").build();
        }
        
        List<Article> articles = llistatArticles(topic,customer);
        List<ArticleGQ> mostra = new LinkedList<>();
        for(Article in : articles)
            mostra.add(new ArticleGQ(in));
         
        GenericEntity<List<ArticleGQ>> entity = new GenericEntity<List<ArticleGQ>>(mostra) {};
        return Response.ok(entity).build();
    }
    
    // GET /rest/api/v1/article/${id}
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getArticle(@PathParam("id") Long id,@HeaderParam("Authorization") String credencials){
        Article article = super.find(id);
        if (article == null) return Response.status(Response.Status.BAD_REQUEST).entity("El article introduit no es valid").build();
        if (article.isPrivacitat()){
            if (credencials == null) return Response.status(Response.Status.UNAUTHORIZED).build();
            // Decodificar credencials
            String[] userPass = validateCredentials(credencials);
            if (userPass.length != 2) return Response.status(Response.Status.UNAUTHORIZED).build();

            String username = userPass[0];
            String password = userPass[1];
            
            Customer aux = findName(username);
            if(aux == null || !(aux.getCredentials().getPassword()).equals(password)){
                return Response.status(Response.Status.FORBIDDEN).entity("La contrasenya es mal").build();
            }
        }
        article.incVis();
        GenericEntity<ArticleDTO> entity = new GenericEntity<ArticleDTO>(new ArticleDTO(article)) {}; 
        return Response.ok(entity).build(); 
    }
        
    // DELETE /rest/api/v1/article/${id}
    @DELETE
    @Secured
    @Path("{id}")
    public Response deleteArticle(@PathParam("id") Long id,@HeaderParam("Authorization") String credencials){
        // Decodificar la Base64
        String[] userPass = validateCredentials(credencials);
        if (userPass.length != 2)  return Response.status(Response.Status.UNAUTHORIZED).build();
        String username = userPass[0];
        
        Article articleBorrar = find(id);
        if (articleBorrar == null) return Response.status(Response.Status.BAD_REQUEST).entity("El article especificat no existeix").build();
        if (articleBorrar.getAutor().getUsername().equals(username)){
            articleBorrar.getAutor().removeArticle(articleBorrar);
            super.remove(articleBorrar);
            return Response.status(Response.Status.ACCEPTED).entity("Removed this article with id == "+id).build();
        }
        return Response.status(Response.Status.FORBIDDEN).build();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    private String[] validateCredentials(String credencials){
        String codificats = credencials.substring("Basic ".length()).trim();
        String credencialsReals = new String(Base64.getDecoder().decode(codificats));
        return credencialsReals.split(":");
    }
    
    public Customer findName(String username){
        String query = "Select c FROM Customer c WHERE c.credentials.username = :userName";
        try{
            return em.createQuery(query,Customer.class)
                    .setParameter("userName",username)
                    .getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
    public Customer findCustomer(Long id){
        return em.find(Customer.class, id);
    }
    
    private boolean isTopicValid(List<Topic> topics){
        return (topics.size() == 2) &&(topics.get(0) != null) && (topics.get(1) != null);
    }
    
    private boolean resumText(ArticleIN art){
       return (art.getResum().length() <= 20) && (art.getText().length() <= 500) ;
    }
    
    public List<Article> llistatArticles(List<Topic> topics, String customer) {
        String query = "SELECT a FROM Article a ";
        
        if( topics.size() >= 1 || customer != null){
            query += "WHERE ";
        }
        
        for(int i = 0;i< topics.size();i++){
            query += ":topic"+i+" MEMBER OF a.topics ";
            if(topics.size() == 2 && i==0 || customer != null) query += "AND ";
        }
  
        if(customer != null)  query += "a.autor.credentials.username= :autor ";
        
        TypedQuery<Article> resul = em.createQuery(query,Article.class);
       
        for( int i = 0;i< topics.size();i++){
            resul.setParameter("topic"+i+"",topics.get(i));
        }
        
        if(customer != null)  resul.setParameter("autor",customer);
        
        return resul.getResultList();
    }
    
}
