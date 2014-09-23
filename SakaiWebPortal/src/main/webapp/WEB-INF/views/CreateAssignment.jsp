<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp">
<jsp:param value="a" name="a"/>
</jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<br>
<div class="panel panel-primary">
  <div class="panel-heading">Sections Assigned to Your</div>
  <div class="panel-body">
<form class="form-horizontal" action="createAssignment/${id }" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Title</label>
    <div class="col-sm-10">
      <input type="text" name="title" />
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Details</label>
    <div class="col-sm-10">
     <input type="text" name="details" />
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Open Date:</label>
    <div class="col-sm-10">
    <input type="text" name="openDate" />
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Due Date:</label>
    <div class="col-sm-10">
    <input type="text" class="datepicker" name="dueDate" />
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Grade Point:</label>
    <div class="col-sm-10">
    <input type="text" class="datepicker" name="gradePoint" />
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Upload assignment:</label>
    <div class="col-sm-10">
   <input type="text" name="assignments" />
    </div>
  </div>
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Submit </button>
    </div>
  </div>
</form>

</div>
</div>
</body>
</html>