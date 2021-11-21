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
    <link rel="stylesheet" href="css/view_prof.css">
    <title>View Profile</title>
</head>
<body>
  <!-- Navbar -->
  <div style="display:block">
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
              <a class="nav-link" href="./profilesearch.html"><span class="fa fa-users fa-lg"></span> Profiles</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="./index.html"><span class="fa fa-home fa-lg"></span> Home</a>
            </li>
            
          </ul>
        </div>
     </nav>
  </div>
  <!-- About -->
      <div class="about">
        <center><img class="img-fluid rounded-circle" width="200vh" height="300vh" alt="Nothing" src="assets/profile.png"></center>
        <center><p id="name" style="font-weight: bold;color:white;font-size: 7vh;">${profile_name}</p></center>
        <center><p id="status" style="color:white;font-size: xx-large;">STUDENT</p></center>
        <center><p id="city"  style="color:white;font-size: medium;">${profile_location}</p></center>
        <center><div id="urls">
          <a href=${profile_gmail}><i class="fa fa-google" style="font-size:4vh;cursor:pointer"></i></a>&nbsp
          <a href=${profile_linkedin}><i class="fa fa-linkedin-square" style="font-size:4vh;cursor:pointer"></i></a>&nbsp
          <a href=${profile_github}><i class="fa fa-facebook-square" style="font-size:4vh;cursor:pointer"></a></i>
        </p></center>
      </div>
      <br>
<!-- Skill Set -->
      <div class="skill_set">
        <div>
         <center> <p style="font-weight:bolder;color:rgb(221, 155, 32);font-size: large;">About ${profile_name}</p></center>
         <center><p style="font-size: medium;">${profile_bio}</p></center>
        </div>
        <hr>
        <div>
          <center><p style="font-weight:bolder;color:rgb(221, 155, 32);font-size: large;">Skill Set</p></center>
          <div style="display:flex;">
          		<c:forEach var="skill" items="${profile_skillset}">
					            
				 <p inline style="margin-right:2vh ;"><i class="fa fa-bookmark" size="3vh"></i> ${skill}</p>
					                
				 </c:forEach>
          </div>  
        </div>
      </div>
      <br>
<!-- Experience -->
      <div class="row gx-5 experience">
        <div class="col-3 border">
          <div class="p-3" style="font-weight:bolder;color:rgb(221, 155, 32);font-size: x-large;text-decoration: underline;">Experience</div>
          
        </div>
        <div class="col-9 border">
          <div class="p-3" >
            <p style="font-weight:bolder;color:rgb(221, 155, 32);font-size: x-large;">Education</p>
            <p id="college_name" style="font-weight: bold;">Amrita Vishwa Vidyapeetham</p>
            <p id="duration">${profile_duration}</p>
            <p id="degree"><span style="font-weight: bold;">Degree: </span>B TECH</p>
            <p id="field"><span style="font-weight: bold;">Field Of Study: </span>${profile_dept}</p>
          </div>
        </div>
      </div>
      <br>
<!-- Accomplishments -->
      <div class="row accomplishments">
        <div class="row nav_in">
          <div class="col-6" style="font-size: xx-large;font-weight: bolder;color:rgb(221, 155, 32);">Accomplishments</div>
          <div class="col-2"><a onclick="change_accomplishments('intern')" id="interns_head">Internships</a></div>
          <div class="col-2"><a onclick="change_accomplishments('projects')" id="project_head">Projects</a></div>
          <div class="col-2"><a onclick="change_accomplishments('journals')" id="journal_head">Journals</a></div>
        </div>
      </div>
      <br>
      <!-- Interns -->
      <div class="internships"> 
        <center><h3 style="font-weight: bolder;text-decoration: underline;">INTERNSHIPS</h3></center>
        <br>
        <div class="intern_component">
        		<c:forEach var="list" items="${interns}" varStatus="interncount">
        			<center><h5 style="font-weight: bolder;text-decoration: underline;color:rgb(221, 155, 32);">Internship ${interncount.count}</h5></center>
					 <c:forEach var="details" items="${list}" varStatus="movieLoopCount">
					     <c:if test="${movieLoopCount.count == 1}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Company Name</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;">${details}</p>
					     </div> 
					     </c:if>
					     <c:if test="${movieLoopCount.count == 2}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Duration</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;">${details}</p>
					     </div>
					     </c:if>
					     <c:if test="${movieLoopCount.count ==3}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Project Title</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;">${details}</p>
					     </div>
					     </c:if>
					     <c:if test="${movieLoopCount.count ==4}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Description</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;">${details}</p>
					     </div>
					     </c:if>
					     
					                
					 </c:forEach> 
					
				 </c:forEach>
        </div>
      </div>
      <!-- Projects -->
      <div class="projects"> 
        <center><h3 style="font-weight: bolder;text-decoration: underline;">PROJECTS</h3></center>
        <br>
        <div class="intern_component">
            <c:forEach var="list" items="${projects}" varStatus="projectcount">
        			<center><h5 style="font-weight: bolder;text-decoration: underline;color:rgb(221, 155, 32);">Project ${projectcount.count}</h5></center>
					 <c:forEach var="details" items="${list}" varStatus="movieLoopCount">
					     <c:if test="${movieLoopCount.count == 1}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Project Title</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;">${details}</p>
					     </div> 
					     </c:if>
					     <c:if test="${movieLoopCount.count == 2}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Tools</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;">${details}</p>
					     </div>
					     </c:if>
					     <c:if test="${movieLoopCount.count ==3}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Duration</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;">${details}</p>
					     </div>
					     </c:if>
					     <c:if test="${movieLoopCount.count ==4}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Description</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;">${details}</p>
					     </div>
					     </c:if>
					     
					                
					 </c:forEach> 
					
				 </c:forEach>
        </div>
      </div>
      <!-- Journals -->
      <div class="journals"> 
        <center><h3 style="font-weight: bolder;text-decoration: underline;">JOURNALS</h3></center>
        <br>
        <div class="intern_component">
        <c:forEach var="jou" items="${journals}" varStatus="journalcount">
        			<center><h5 style="font-weight: bolder;text-decoration: underline;color:rgb(221, 155, 32);">Journal ${journalcount.count}</h5></center>
					 <c:forEach var="index" items="${jou}" varStatus="movieLoopCount">
					     <c:if test="${movieLoopCount.count == 1}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Journal Title</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;"><span>${index}</span></p>
					     </div> 
					     </c:if>
					     <c:if test="${movieLoopCount.count == 2}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Duration</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;"><span>${index}</span></p>
					     </div> 
					     </c:if>
					     <c:if test="${movieLoopCount.count == 3}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Publication</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;"><span>${index}</span></p>
					     </div> 
					     </c:if>
					     <c:if test="${movieLoopCount.count == 4}">
					     <div class="row">
					         <p class="col-6" style="font-weight: bold;font-size: large;">Description</p>
					         <p class="col-6" style="font-weight: normal;font-size: medium;"><span>${index}</span></p>
					     </div> 
					     </c:if>
 					     
 				      </c:forEach>
					
				 </c:forEach>
            
        </div>
      </div>
      <br>
      <!-- JS -->
      <script src="js/view_profile.js"></script>
    <!-- jQuery first, then Popper.js, then Bootstrap JS. -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
    </script>
</body>
</html>