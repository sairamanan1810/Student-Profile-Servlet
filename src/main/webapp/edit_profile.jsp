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
    <title>Edit Profile</title>
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
              <a class="nav-link" href="View_profile.html"><span class="fa fa-users fa-lg"></span> Profiles</a>
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

  <!-- edit-profile -->
  <section class="container">
      <h1 class="text-center page-heading">Create Your Profile</h1>
      <p class="lead"><i class="fa fa-heart" aria-hidden="true"></i> Let's get some information about you</p>
      <small>* = Required Fields</small>
      <form class="form" action="update_profile" method="post">
            <div class="form-group">
              <input type="text" placeholder="Roll number" name="roll_no" value="${roll_no}" required>
              <small class="form-text">Enter your Roll Number</small>
            </div>
            
            <div class="form-group">
                <input type="text" placeholder="Name" name="name" value="${profile_name}" required>
                <small class="form-text">Enter your Name</small>
            </div>
            <div class="form-group">
                <input type="text" placeholder="Location" name="location" value="${profile_location}" required>
                <small class="form-text">City &amp; state suggested (eg. Boston, MA)</small>
            </div>
            <div class="form-group">
              <input type="text" placeholder="Photo" name="photo" value="${profile_photo}" required>
              <small class="form-text">Provide the link for your avatar photo</small>
          </div>
            <div class="form-group">
                <input type="text" placeholder="* Skills" name="skills" value="${profile_skillset}" required>
                <small class="form-text">Please use comma separated values (eg. HTML,CSS,JavaScript,PHP)</small>
            </div>
            <div class="form-group">
                <textarea placeholder="A short bio of yourself" name="bio"  required>${profile_bio}
                </textarea><small class="form-text">Tell us a little about yourself</small>
            </div>
            <div class="my-2">
                <button type="button" class="btn btn-light" onclick="socialMedia()">Add Social Network Links</button>
                <span>Optional</span>
            </div>
            <div class="social-media-buttons" style="display: none;">
            <div class="form-group">
              <i class="fa fa-github" aria-hidden="true"></i>
              <input type="text" placeholder="Github URL" name="github" />
            </div>
            <div class="form-group social-input">
              <i class="fa fa-envelope-o" aria-hidden="true"></i>
              <input type="text" placeholder="Email ID" name="email" />
            </div>
            <div class="form-group social-input">
              <i class="fa fa-linkedin-square" aria-hidden="true"></i>
              <input type="text" placeholder="Linkedin URL" name="linkedin" />
            </div>

            </div>
            <input type="submit" class="btn btn-primary my-1">
            <a class="btn btn-light my-1" href="./dashboard_details">Go Back</a>
        </form>
    </section>
  <script>

    function socialMedia() {
      var socialbtn = document.getElementsByClassName('social-media-buttons');
      if (socialbtn[0].style.display ===  'none') {
        socialbtn[0].style.display = 'block';
      } else {
        socialbtn[0].style.display = 'none';
      }
    }
  </script>
</body>
</html>