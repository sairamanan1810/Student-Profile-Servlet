function showExperience(exp,text) {
    document.getElementById('internship-form').style.display = 'none';
    document.getElementById('project-form').style.display = 'none';
    document.getElementById('journal-form').style.display = 'none';
    document.getElementById(exp).style.display = 'block';
    document.getElementById('dropdownMenuButton').innerText=text;
  }
  function validate(type){
    if (type === 'journal') {
      var title = document.getElementsByName('journal_title')[0].value;
      var duration = document.getElementsByName('journal_duration')[0].value;
      var publication = document.getElementsByName('journal_publication')[0].value;
      var description = document.getElementsByName('journal_description')[0].value;
      var check = false;
      var errortag=document.getElementById('errors');
      errortag.innerHTML="";
      errortag.style.display='none';

      if (title === "") {
        var li=document.createElement('li');
        li.innerHTML = "Title cannot be empty";
        errortag.appendChild(li);
        check = true;
      }
      if (duration === "") {
        var li=document.createElement('li');
        li.innerHTML = "Duration cannot be empty";
        errortag.appendChild(li);
        check = true;
      }
      if (publication === "") {
        var li=document.createElement('li');
        li.innerHTML = "Publication cannot be empty";
        errortag.appendChild(li);
        check = true;
      }
      if (description.length < 10) {
        var li=document.createElement('li');
        li.innerHTML = "Description should be minimum of 10 characters";
        errortag.appendChild(li);
        check = true;
      }
    }
    if (type === 'project') {
        var title = document.getElementsByName('project_title')[0].value;
        var duration = document.getElementsByName('project_duration')[0].value;
        var tools = document.getElementsByName('project_tools')[0].value;
        var description = document.getElementsByName('project_description')[0].value;
        var check = false;
        var errortag=document.getElementById('errors');
        errortag.innerHTML="";
        errortag.style.display='none';
  
        if (title === "") {
          var li=document.createElement('li');
          li.innerHTML = "Title cannot be empty";
          errortag.appendChild(li);
          check = true;
        }
        if (duration === "") {
          var li=document.createElement('li');
          li.innerHTML = "Duration cannot be empty";
          errortag.appendChild(li);
          check = true;
        }
        if (tools === "") {
          var li=document.createElement('li');
          li.innerHTML = "Tools cannot be empty";
          errortag.appendChild(li);
          check = true;
        }
        if (description.length < 10) {
          var li=document.createElement('li');
          li.innerHTML = "Description should be minimum of 10 characters";
          errortag.appendChild(li);
          check = true;
        }
      }
      if (type === 'internship') {
        var title = document.getElementsByName('intern_title')[0].value;
        var duration = document.getElementsByName('intern_duration')[0].value;
        var company = document.getElementsByName('intern_company')[0].value;
        var description = document.getElementsByName('intern_description')[0].value;
        var check = false;
        var errortag=document.getElementById('errors');
        errortag.innerHTML="";
        errortag.style.display='none';
  
        if (title === "") {
          var li=document.createElement('li');
          li.innerHTML = "Title cannot be empty";
          errortag.appendChild(li);
          check = true;
        }
        if (duration === "") {
          var li=document.createElement('li');
          li.innerHTML = "Duration cannot be empty";
          errortag.appendChild(li);
          check = true;
        }
        if (company === "") {
          var li=document.createElement('li');
          li.innerHTML = "Company cannot be empty";
          errortag.appendChild(li);
          check = true;
        }
        if (description.length < 10) {
          var li=document.createElement('li');
          li.innerHTML = "Description should be minimum of 10 characters";
          errortag.appendChild(li);
          check = true;
        }
      }
    
    
    if (check === false) {
      return true
    }
    errortag.style.display='block';
    return false;
  }