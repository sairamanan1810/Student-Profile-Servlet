<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous" />
    <link href="https://fonts.googleapis.com/css?family=Montserrat|Raleway&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/index.css" />
    <link rel="stylesheet" href="css/view_prof.css"> 
    <link rel="stylesheet" href="css/dashboard.css"> 
    <link rel="stylesheet" href="css/errors.css">
<title>Faculty Details</title>
</head>
<body>
<section class="container">
<!-- Navbar -->
  <div>
    <nav class="navbar bg-first navbar-expand-sm fixed-top">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
          <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="./dashboard_details">
           <img src="assets/avatar.png" alt=""  class="d-inline-blocks">
              <p class="d-inline-block" style="font-size:x-large;color:#01a1ec;font-weight:bolder"><i class="bi bi-bookmark-fill"></i><strong>Amrita Student Profile</strong></p>
        </a>
        <div class="collapse navbar-collapse" id="Navbar">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="./profile_search?search=a"><span class="fa fa-users fa-lg"></span> Profiles</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="./dashboard_details"><span class="fa fa-user-circle-o fa-lg"></span> Dashboard</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="index.html"><span class="fa fa-sign-out fa-lg"></span> Logout</a>
            </li>
          </ul>
        </div>
     </nav>
  </div>
      <h1 class="text-center page-heading">Create Your Profile</h1>
      
      <small>* Required Fields</small>
      <div id="errors">
	      </div>
      <form class="form" action="faculty_details" onsubmit="return validate();" method="post">
           
            <div class="form-group">
                <input type="text" placeholder="Name" name="name" value="" required>
                <small class="form-text">Enter your Name</small>
            </div>
            
            
            <div class="form-group">
              <input type="email" placeholder="Email ID" name="email" value=${email} readonly/>
              <small class="form-text">Email ID</small>
            </div>
           
			<div class="form-group">
            <input type="text" placeholder="Department" name="Department" value="">
            <small class="form-text">Enter your Department</small>
          </div>
          
            
            <input type="Submit" class="btn btn-primary my-1">
            <a class="btn btn-light my-1" href="dashBoardInitial.jsp">Go Back</a>
        </form>
    </section>
</body>
<script>
    function validate(){
    	console.log("hello kid")
        var name = document.getElementsByName('name')[0].value;
        var course = document.getElementsByName('department')[0].value;
        var check = false;
        var errortag=document.getElementById('errors');
        errortag.innerHTML="";
  	    errortag.style.display='none';
        
        if (course === "" || course === null) {
        	console.log("hello kid here")
          var li=document.createElement('li');
          li.innerHTML = "Department cannot be empty";
          errortag.appendChild(li);
          check = true;
        }
        if (name === "" || name === null) {
        	console.log("hello kid here")
          var li=document.createElement('li');
          li.innerHTML = "Name cannot be empty";
          errortag.appendChild(li);
          check = true;
        }
        
        
        
        if (check === false) {
          alert('Profile Created Successfully');
          return true
        }
        errortag.style.display='block';
        return false;
      }
  </script>
</html>