<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
 <body class="bg-dark">
    <div class="container">
    <%
		String msg ="";
		if(request.getAttribute("msg")!=null){
			msg = (String)request.getAttribute("msg");
	%>
	<div id="alert" class="alert alert-danger" role="alert"><%=msg %></div>
	<%} %>
      <div class="row">
        <div class="col-md-7 mx-auto">
          <div class="card shadow mt-3">
            <div class="card-header h3 text-center text-white bg-success">
              Add Employee
            </div>
            <form action="EmployeeAdd.do" method="post">
              <div class="card-body">
                <div class="form-group">
                  <label for="exampleInputName">Name</label>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputName1"
                    name="name"
                    aria-describedby="nameHelp"
                    placeholder="Enter name"
                    required
                  />
                </div>
                <div class="form-group">
                  <label for="exampleInputDob">DOB</label>
                  <input
                    type="date"
                    class="form-control"
                    id="exampleInputDob1" 
                    name="dob"
                    aria-describedby="dobHelp"
                    placeholder="Enter age"
                    required
                  />
                </div>
                <div class="form-group">
                  <label for="exampleInputGender">Gender</label>
                  <select name="gender" id="" class="form-control" required>
                      <option value="">Select Gender</option>
                      <option value="Male">Male</option>
                      <option value="Female">Female</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="exampleInputDepartment">Department</label>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputdepartment1" 
                    name="department"
                    aria-describedby="departmentHelp"
                    placeholder="Enter department"
                    required
                  />
                <div class="form-group">
                  <label for="exampleInputSalary">Salary</label>
                  <input
                    type="number"
                    class="form-control"
                    id="exampleInputSalary"
                    name="salary"
                    aria-describedby="salaryHelp"
                    placeholder="Enter salary"
                    min="0"
                    required
                  />
                </div>
              </div>
              <div class="card-footer">
                <div class="col-md-6 mx-auto">
                	<button type="submit" class="btn btn-primary btn-block btn-lg">Add</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
      <div class="row mt-3">
          <div class="col-md-12">
            <a href="EmployeeList.do" class="btn btn-warning btn-lg">View List</a>
          </div>
      </div>
    </div>
    
    <script type="text/javascript">
		var alert = document.getElementById("alert");
		setTimeout(() => {
			alert.remove();
		}, 5000);
	</script>
  </body>
</html>