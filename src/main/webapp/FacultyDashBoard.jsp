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
    <link rel="stylesheet" href="css/view_prof.css">
    <link rel="stylesheet" href="css/dashboard.css">  
    <title>Faculty DashBoard</title>
</head>
<body>
  <!-- Navbar -->
  <div>
    <nav class="navbar bg-first navbar-expand-sm fixed-top">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
          <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand">
          <img src="assets/avatar.png" alt=""  class="d-inline-blocks">
              <p class="d-inline-block" style="font-size:x-large;color:#01a1ec;font-weight:bolder"><i class="bi bi-bookmark-fill"></i><strong>Amrita Student Profile</strong></p>
        </a>
        <div class="collapse navbar-collapse" id="Navbar">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="./profile_search?search=a"><span class="fa fa-users fa-lg"></span> Profiles</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="./index.html"><span class="fa fa-sign-out fa-lg"></span> Logout</a>
            </li>
          </ul>
        </div>
     </nav>
  </div>
  <!-- Dashboard -->
    <section class="container">
      <h1 class="text-center page-heading">FACULTY DASHBOARD</h1>
      <p class="lead" style="fontWeight:'bolder';"><i class="fa fa-user" aria-hidden="true"></i> Welcome ${id}</p>
      <div class="dash-buttons">
        <a class="btn" href="list_students_ofA_faculty" style="background-color:#01a1ec"><i class="fa fa-id-card" aria-hidden="true"></i> Student's List</a>
      </div>
      
    <!-- Request List -->
    
    <p class="text-center" style="text-decoration:underline;font-size:x-large;font-weight:bold">Request for Internship Approval</p>
    <table class="table">
      <thead>
        <tr>
        	<th scope="col">#</th>
          	<th scope="col">Roll Number</th>
         	<th scope="col">Details</th>
          	<th>Accept/Reject</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach var="list" items="${request_intern_add}" varStatus="movieLoopCount">
				<tr>
					<td scope="row">${movieLoopCount.count}</td>     
						<td>${list[0]}</td>
						<td>
							<li><span style="font-weight:bold">Company Name: </span>${list[1]}</li>
							<li><span style="font-weight:bold">Duration </span>${list[2]}</li>
							<li><span style="font-weight:bold">Role: </span>${list[3]}</li>
							<li><span style="font-weight:bold">Description: </span>${list[4]}</li>
						</td>
					   
							<td>
							    <span>
							    	<button type="button" onclick="location.href='http://localhost:8080/Portal/approve_accomplishment?id=${list[5]}&status=Approved&type=intern'" class="btn btn-success accept_reject" style="padding:10px;background-color:green;color:white">Accept</button>
							    </span>
							    <span>
							    	<button type="button" onclick="location.href='http://localhost:8080/Portal/approve_accomplishment?id=${list[5]}&status=Rejected&type=intern'" class="btn btn-success accept_reject" style="padding:10px;background-color:red;color:white">Reject</button>
							    </span>
						    </td>
				</tr>        
		</c:forEach>
		</tbody>
		</table>
		<br>
		<p class="text-center" style="text-decoration:underline;font-size:x-large;font-weight:bold">Request for Project Approval</p>
		<table class="table">
	      <thead>
	        <tr>
	        	<th scope="col">#</th>
	          	<th scope="col">Roll Number</th>
	         	<th scope="col">Details</th>
	          	<th>Accept/Reject</th>
	        </tr>
	      </thead>
	      <tbody>
				<c:forEach var="list" items="${request_project_add}" varStatus="movieLoopCount">
						<tr>
							<td scope="row">${movieLoopCount.count}</td>     
								<td>${list[0]}</td>
								<td>
									<li><span style="font-weight:bold">Title: </span>${list[1]}</li>
									<li><span style="font-weight:bold">Duration </span>${list[2]}</li>
									<li><span style="font-weight:bold">Tools: </span>${list[3]}</li>
									<li><span style="font-weight:bold">Description: </span>${list[4]}</li>
								</td>
							   
							<td>
							    <span>
							    	<button type="button" onclick="location.href='http://localhost:8080/Portal/approve_accomplishment?id=${list[5]}&status=Approved&type=project'" class="btn btn-success accept_reject" style="padding:10px;background-color:green;color:white">Accept</button>
							    </span>
							    <span>
							    	<button type="button" onclick="location.href='http://localhost:8080/Portal/approve_accomplishment?id=${list[5]}&status=Rejected&type=project'" class="btn btn-success accept_reject" style="padding:10px;background-color: red;color:white">Reject</button>
							    </span>
						    </td>		
						</tr>        
				</c:forEach>
		</tbody>
		</table>
		<br>
		<p class="text-center" style="text-decoration:underline;font-size:x-large;font-weight:bold">Request for Journal Approval</p>
		<table class="table">
	      <thead>
	        <tr>
	        	<th scope="col">#</th>
	          	<th scope="col">Roll Number</th>
	         	<th scope="col">Details</th>
	          	<th>Accept/Reject</th>
	        </tr>
	      </thead>
	      <tbody>
			<c:forEach var="list" items="${request_journal_add}" varStatus="movieLoopCount">
					<tr>
						<td scope="row">${movieLoopCount.count}</td>     
							<td>${list[0]}</td>
							<td>
								
								<li><span style="font-weight:bold">Title: </span>${list[1]}</li>
								<li><span style="font-weight:bold">Duration </span>${list[2]}</li>
								<li><span style="font-weight:bold">Publication: </span>${list[3]}</li>
								<li><span style="font-weight:bold">Description: </span>${list[4]}</li>
								
							</td>
							<c:set var="identity" value="${list[5]}"></c:set>
						   
						    <td>
							    <span>
							    	<button type="button" onclick="location.href='http://localhost:8080/Portal/approve_accomplishment?id=${list[5]}&status=Approved&type=journal'" class="btn btn-success accept_reject" style="padding:10px;background-color:green;color:white">Accept</button>
							    </span>
							    <span>
							    	<button type="button" onclick="location.href='http://localhost:8080/Portal/approve_accomplishment?id=${list[5]}&status=Rejected&type=journal'" class="btn btn-success accept_reject" style="padding:10px;background-color: red;color:white">Reject</button>
							    </span>
						    </td>
	
					</tr>        
			</c:forEach>
	      </tbody>
    	</table>
    <div class="margin-2">
      <button class="btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Delete My Account</button>
    </div>
  </section>

</body>
</html>