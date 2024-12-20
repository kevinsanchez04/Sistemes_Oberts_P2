<form action="${mvc.uri('/filter')}" method="GET" class="col pt-3">
    <h6>Select Topic</h6>
    <span class="d-block ms-4 mb-3">
      <span class="d-block">
        <input class="me-1" type="checkbox" id="HTML" name="topics" value="HTML">
        <label for="HTML" class="mb-0">HTML</label>
      </span>
      <span class="d-block">
        <input class="me-1" type="checkbox" id="CSS" name="topics" value="CSS">
        <label for="CSS" class="mb-0" >CSS</label>
      </span>
      <span class="d-block">
        <input class="me-1" type="checkbox" name="topics" value="Python">
        <label for="Python" class="mb-0">Python</label>
      </span>
      <span class="d-block">
        <input class="me-1" type="checkbox" name="topics" value="C">
        <label for="C" class="mb-0">C</label>
      </span>
      <span class="d-block">
        <input class="me-1" type="checkbox" name="topics" value="JavaScript">
        <label for="JavaScript" class="mb-0">JavaScript</label>
      </span>
      <span class="d-block">
        <input class="me-1" type="checkbox" name="topics" value="Java">
        <label for="Java" class="mb-0">Java</label>
      </span>
      <span class="d-block">
        <input class="me-1" type="checkbox" name="topics" value="Web_Programming">
        <label for="Web_Programming" class="mb-0">Web</label>
      </span>
    </span>
    <span class="d-flex justify-content-center align-items-center mt-2">
      <h6 class="mb-0 me-2" >Name of the author</h6> 
      <input type="text" name="author" value="NULL">
    </span>
    <span class="d-flex justify-content-center mt-3 mb-3">
      <input class="bg-dark text-white rounded rounded" type="submit" value="Submit">
    </span>
  </form>
