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
        <link rel="stylesheet" href="css/admin_page.css">
        <title>Admin Faculty Details</title>
    </head>
    <body>
      <!-- Navbar -->
      <div>
        <nav class="navbar navbar-expand-sm fixed-top">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
              <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="admin_page.html">
              <img src="assets/avatar.png" alt="" class="d-inline-blocks">
              <p class="d-inline-block" style="font-size:x-large;color:#01a1ec;font-weight:bolder"><i class="bi bi-bookmark-fill"></i><strong>Amrita Student Profile</strong></p>
            </a>
         </nav>
      </div>
      <div class="sideNav">
        <div class="container-fluid">
          <div class="row flex-nowrap">
              <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-first" style="opacity: 0.9;background-color:black">
                  <div class="d-flex p-4 flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
                      <ul class="nav nav-pills flex-column mb-sm-auto mb-0 lh-lg align-items-center justify-content-center align-items-sm-start" id="menu">
                          
                          <li class="p-4 nav-item mx-auto align-middle" style="width:90%">
                            <img class="sideNavA rounded-circle" src="assets/profile.png" alt="hugenerd" width="105" height="105" class=" align-middle"><br><br>
                          </li>
                          <li class="align-middle text-center" style="font-weight: bolder;font-size: larger;color:#01a1ec">
			                  ADMIN DASHBOARD
			               </li>
			               <br>
                          <li class="nav-item">
                            <a class="nav-link sideNavA" href="admin_student_table"><span class="fa fa-long-arrow-right fa-lg"></span> Student List</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link sideNavA"  href="admin_faculty_table"><span class="fa fa-long-arrow-right fa-lg"></span> Faculty List</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link sideNavA" href="admin_create_classform_faculty" ><span class="fa fa-long-arrow-right fa-lg"></span> ASP Classes</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link sideNavA" href="logout" ><span class="fa fa-sign-out fa-lg"></span> Logout</a>
                          </li>
                      </ul>
                      <hr>
                  </div>
              </div>
              <div class="col py-3 faculty" >
                <center><h3>FACULTY LIST</h3></center>
                <form action="faculty_table_filter" method="post">
                <div class="row mx-auto form">
                  <div class="col-6">
                    <select class="form-select form-select-lg mb-3" aria-label=".form-select-sm example" name="dept">
                      <option selected value="%">Department</option>
                      <option value="cse">CSE</option>
                      <option value="eee">EEE</option>
                      <option value="mee">MEE</option>
                    </select>
                  </div>
                  <div class="col-3">
                    <button type="submit" class="btn btn-outline-success">Submit</button>
                  </div>
                </div>
                </form>
                  <table class="table table-striped">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Department</th>
                        <th scope="col">Mail Id</th>
                      </tr>
                    </thead>
                    <tbody>
	                    <c:forEach var="list" items="${list_table}" varStatus="movieLoopCount">
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
              
      </div>
      </div>
      <script src="js/admin_page.js"></script>
    </body>
</html>