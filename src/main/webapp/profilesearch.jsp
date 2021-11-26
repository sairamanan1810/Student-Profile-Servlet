<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
    integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous" />
  <link href="https://fonts.googleapis.com/css?family=Montserrat|Raleway&display=swap" rel="stylesheet" />
  <link rel="stylesheet" href="css/style.css" />
  <link rel="stylesheet" href="css/profilesearch.css" />
  <title>Profile Search</title>
</head>

<body>
  <nav class="navbar bg-first navbar-expand-sm fixed-top">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="./index.html">
       <img src="assets/avatar.png" alt=""  class="d-inline-blocks">
              <p class="d-inline-block" style="font-size:x-large;color:#01a1ec;font-weight:bolder"><i class="bi bi-bookmark-fill"></i><strong>Amrita Student Profile</strong></p>
    </a>
    <div class="collapse navbar-collapse" id="Navbar">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="./index.html"><span class="fa fa-home fa-lg"></span> Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./signup.html"><span class="fa fa-user-plus fa-lg"></span> Register</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./login.html"><span class="fa fa-sign-in fa-lg"></span> Login</a>
        </li>
      </ul>
    </div>
  </nav>

  <div class="container">
    <h1 class="text-center page-heading"><span class="fa fa-users fa-md"></span> SEARCH  PROFILES</h1>
    <h3></h3>
    <div class="search">
      <form class="profile-search" method="get" action="http://localhost:8080/Portal/profile_search">
        <input type="text" placeholder="Search.." name="search">
        <button type="submit"><i class="fa fa-search"></i></button>
      </form>
    </div>
    <div class="profiles">
      <c:forEach items="${st_list}" var="student">
        <div class="profile" style="padding:20px">
          <img src="${student.photo}" onerror="this.onerror=null; this.src='assets/profile.png'" alt="" class="round-img" height="200" width="200">
          <div>
            <h2>${student.name}</h2>
            <h6><span style="font-weight:bold">Roll no :</span> ${student.rollno}</h6>
            <h6><span style="font-weight:bold">Bio :</span> ${student.bio}</h6>
            <h6 class="my-1 mb-3"><span style="font-weight:bold">Location :</span> ${student.location}</h6>
            <a class="btn btn-second" href="get_view_profile_data?roll_no=${student.rollno}" style="background-color:#096894;">View Profile</a>
          </div>
          <ul>
            <c:forTokens items="${student.skill}" delims="," var="skill">
              <li class="text-second">
                <i class="fa fa-check" aria-hidden="true"></i> <c:out value="${skill}" />
              </li>
            </c:forTokens>
          </ul>
        </div>
      </c:forEach>
    </div>
  </div>

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