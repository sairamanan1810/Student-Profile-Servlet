<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous" />
    <link href="https://fonts.googleapis.com/css?family=Montserrat|Raleway&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/index.css" />
    <link rel="stylesheet" href="css/student_list.css"> 
    <!--  <link rel="stylesheet" href="css/admin_page.css"> -->
    <title>View Profile</title>
</head>
<body>
  <!-- Navbar -->
  <div>
    <nav class="navbar bg-first navbar-expand-sm fixed-top">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
          <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="index.html">
          <img src="assets/amrita-logo.jpg" alt="" width="40" height="40" class="d-inline-blocks">
          <h1 class="d-inline-block align-middle ml-2"><strong>Amrita Student Profile</strong></h1>
        </a>
        <div class="collapse navbar-collapse" id="Navbar">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="View_profile.html"><span class="fa fa-users fa-lg"></span> Profiles</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="DashBoard.html"><span class="fa fa-user-circle-o fa-lg"></span> Dashboard</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="index.html"><span class="fa fa-sign-out fa-lg"></span> Logout</a>
            </li>
          </ul>
        </div>
     </nav>
  </div>
  <div class="mx-auto" style="width:80%">
    <h2 class="text-center" style="color:rgb(221, 155, 32);">Students List</h2>
    <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Roll Number</th>
                        <th scope="col">Department</th>
                        <th scope="col">Section</th>
                        <th scope="col">Year Of Joining</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="list" items="${student_list}" varStatus="movieLoopCount">
					        <tr>
					            <th scope="row">${movieLoopCount.count}</th>     
					        
					        	<c:forEach var="details" items="${list}">
					            
					                <td>${details}</td>
					                
					            </c:forEach>
					         </tr>
					        
				    	</c:forEach>
                    </tbody>
                  </table>
            
         </div>
    
</body>
</html>