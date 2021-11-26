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
    <title>Add Education</title>
    <link rel="stylesheet" href="signup.css"/>
</head>
<body>
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
              <a class="nav-link" href="logout"><span class="fa fa-sign-out fa-lg"></span> Logout</a>
            </li>
          </ul>
        </div>
     </nav>
  </div>
  <!-- Add Education -->
    <section class="container" style="margin-top:0rem">
        <h1 class="text-center page-heading">Add Your Education</h1>
        <p class="lead"><i class="fa fa-code" aria-hidden="true"></i> Add any school, bootcamp, etc that you have attended</p>
        <div id="errors">
	      </div>
        <form class="form" onsubmit="return validate();" method="get" action="">
          <div class="form-group">
            <input type="text" placeholder="course" name="course" value="${course}">
            <small class="form-text">Enter your field of study</small>
          </div>
          <div class="form-group">
            <input type="number" min="1900" max="2021" step="1" value="${jyear}" style="width: 75px;" name='start'/>
            <small class="form-text">Enter the Joining year of your graduation</small>
          </div>
          <div class="form-group">
            <input type="number" min="1900" max="2025" step="1" value="${eyear}" style="width: 75px;" name="end"/>
            <small class="form-text">Enter the Passing out year of your graduation</small>
          </div>
          <div class="form-group">
            <select name="status" value = "${section}">
              <option value="A">A</option>
              <option value="B">B</option>
              <option value="C">C</option>
              <option value="D">D</option>
              <option value="E">E</option>
            </select>
            <small class="form-text">Enter your section</small>
          </div>
            <div class="form-group">
                <textarea name="description" cols="30" rows="5" placeholder="Description"></textarea>
            </div>
            <input type="submit" class="btn btn-primary my-1">
            <a class="btn my-1" href="./dashboard_details">Go Back</a>
        </form>
    </section>
  <script>
    function validate(){
      var photo = document.getElementsByName('description');
      var course = document.getElementsByName('course')[0].value;
      var check = false;
      var errortag=document.getElementById('errors');
      errortag.innerHTML="";
	    errortag.style.display='none';
      var txt = photo[0].value;
      if (course === "") {
        var li=document.createElement('li');
        li.innerHTML = "Course cannot be empty";
        errortag.appendChild(li);
        check = true;
      }
      if (txt.length < 10) {
        var li=document.createElement('li');
        li.innerHTML = "Description should be minimum of 10 characters";
        errortag.appendChild(li);
        check = true;
      }
      var st = document.getElementsByName('start')[0].value;
      var en = document.getElementsByName('end')[0].value;
      
      if (en < st) {
        var li=document.createElement('li');
        li.innerHTML = "Passing out year cannot be before than joining year";
        errortag.appendChild(li);
        check = true;
      }
      if ( en - st > 5) {
        var li=document.createElement('li');
        li.innerHTML = "Difference between joining and passing out year is maximum 5";
        errortag.appendChild(li);
        check = true;
      } 
      if (check === false) {
        alert('Added Education Successfully');
        return true
      }
      errortag.style.display='block';
      return false;
    }
  </script>
</body>
</html>