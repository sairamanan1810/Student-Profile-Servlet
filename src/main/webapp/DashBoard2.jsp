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
    <title>View Profile</title>
</head>
<body>
  <!-- Navbar -->
  <div>
    <nav class="navbar bg-first navbar-expand-sm fixed-top">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
          <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="DashBoard.html">
          <img src="assets/amrita-logo.jpg" alt="" width="40" height="40" class="d-inline-blocks">
          <h1 class="d-inline-block align-middle ml-2"><strong>ASP</strong></h1>
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
  <!-- Dashboard -->
    <section class="container">
      <h1 class="large text-primary">Dashboard</h1>
      <p class="lead"><i class="fa fa-user" aria-hidden="true"></i> Welcome ${name}</p>
      <div class="dash-buttons">
        <a class="btn" href="view_profile.html"><i class="fa fa-eye" aria-hidden="true"></i> View Profiles</a>
        <a class="btn" href="edit-profile.html"><i class="fa fa-id-card" aria-hidden="true"></i> Edit Profile</a>
        <a class="btn" href="add-education.html"><i class="fa fa-graduation-cap" aria-hidden="true"></i> Add Education</a>
        <a class="btn" href="add-experience.html"><i class="fa fa-briefcase" aria-hidden="true"></i> Add Accomplishment</a>
        
      </div>
      <!-- Education -->
    <h2 class="margin-2">Education</h2>
    <table class="table">
      <thead>
        <tr>
          <th>School</th>
          <th class="hide-sm">Degree</th>
          <th class="hide-sm">Field Of Study</th>
          <th>Years</th>
          <!-- <th></th> -->
        </tr>
      </thead>
      <tbody></tbody>
    </table>
      <!-- Experience -->
    <h2 class="margin-2">Accomplishments</h2>
    <table class="table">
      <thead>
        <tr>
          <th>Company/Title</th>
          <th class="hide-sm">Description</th>
          <th class="hide-sm">Type</th>
          <th>Duration</th>
          <!-- <th></th> -->
        </tr>
      </thead>
      <tbody></tbody>
    </table>
    
    <div class="margin-2">
      <button class="btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Delete My Account</button>
    </div>
  </section>

</body>
</html>