<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Database SQL Load</title>
    </head>
    <style>
        .error {
            color: red;
        }
        pre {
            color: green;
        }
    </style>
    <body>
        <h2>Database SQL Load</h2>
        <%
            /* How to customize:
             * 1. Update the database name on dbname.
             * 2. Create the list of tables, under tablenames[].
             * 3. Create the list of table definition, under tables[].
             * 4. Create the data into the above table, under data[]. 
             * 
             * If there is any problem, it will exit at the very first error.
             */
            String dbname = "sob_grup_17";
            String schema = "ROOT";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            /* this will generate database if not exist */
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbname, "root", "root");
            Statement stmt = con.createStatement();
            
           String[] data = new String[]{
                // Article 1
                "INSERT INTO " + schema + ".CREDENTIALS VALUES (NEXT VALUE FOR CREDENTIALS_GEN, 'sob', 'sob')",
                "INSERT INTO " + schema + ".CUSTOMER (id, credentials, dataCreacio, description, profilePhoto) VALUES (NEXT VALUE FOR CUSTOMER_GEN, (SELECT MAX(id) FROM " + schema + ".CREDENTIALS), '2024-11-22', 'Hola breu descripció', 'https://okdiario.com/img/2024/08/13/get-635x358.jpg')",

                "INSERT INTO " + schema + ".ARTICLE (ID, autor_id, titol, data, resum, text, visualitzacions,imatge) "
                    + "VALUES (NEXT VALUE FOR ARTICLE_GEN, 1, 'NomArticle', '2024-11-12', 'Resum de 20 paraules', 'Tenim el seguent text que es de prova i nomes per veure que install jsp funciona a la perfeccio', 5000,'https://img.freepik.com/vector-gratis/ilustracion-almacenamiento-nube_53876-20605.jpg?w=2000')",
                "INSERT INTO " + schema + ".ARTICLE_TOPICS (article_id, topics) VALUES (1, 'CSS')",
                "INSERT INTO " + schema + ".ARTICLE_TOPICS (article_id, topics) VALUES (1, 'Python')",
                
                // ARTICLE 2
                "INSERT INTO " + schema + ".CREDENTIALS VALUES (NEXT VALUE FOR CREDENTIALS_GEN, 'kevin', 'kevin2004')",
                "INSERT INTO " + schema + ".CUSTOMER (id, credentials, dataCreacio, description, profilePhoto) VALUES (NEXT VALUE FOR CUSTOMER_GEN, (SELECT MAX(id) FROM " + schema + ".CREDENTIALS), '2024-11-22', 'Hola breu descripció', 'https://okdiario.com/img/2024/08/13/get-635x358.jpg')",
                "INSERT INTO " + schema + ".ARTICLE (ID, privacitat, titol, resum, text, data, imatge, autor_id, visualitzacions) "
                    + "VALUES (NEXT VALUE FOR ARTICLE_GEN, 1, 'Article 2', 'Resum ART 2', 'Text del Article numero 2', '2024-01-22', 'https://th.bing.com/th/id/R.ec3075b626306f0dc1ee583d558a608d?rik=8k1p%2bhUpP8wreA&pid=ImgRaw&r=0&sres=1&sresct=1', (SELECT MAX(id) FROM " + schema + ".CUSTOMER), 300)",
                "INSERT INTO " + schema + ".ARTICLE_TOPICS (article_id, topics) VALUES (2, 'HTML')",
                "INSERT INTO " + schema + ".ARTICLE_TOPICS (article_id, topics) VALUES (2, 'JavaScript')",

            };
            
            /* inserting data */
            /* you have to exclude the id autogenerated from the list of columns if you have use it. */
            for (String datum : data) {
                if (stmt.executeUpdate(datum)<=0) {
                    out.println("<span class='error'>Error inserting data: " + datum + "</span>");
                    return;
                }
                out.println("<pre> -> " + datum + "<pre>");
            }
        %>
        <button onclick="window.location='<%=request.getSession().getServletContext().getContextPath()%>'">Go home</button>
    </body>
</html>


