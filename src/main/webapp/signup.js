function yesnoCheck() {
	console.log("hello")
    if (document.getElementById('yesCheck').checked) {
        document.getElementById('ifStudent').style.display = 'block';
    }
    else document.getElementById('ifStudent').style.display = 'none';
}

function rollnoCheck(Num){
	const re = /^[A-Z]+[A-Z]+.+[A-Z]+[A-Z]+.+[A-Z]+[0-9]+[A-Z]+[A-Z]+[A-Z]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]$/
  	return re.test(Num);
}

function CheckPassword(inputtxt) 
{ 
	var passw=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
	return passw.test(inputtxt)
}

function validate(){
	console.log("sai")
	var dict={}
	dict['Name']=document.getElementById('name').value
	dict['Email']=document.getElementById('email').value
	dict['Roll_Num']=document.getElementById('roll_no').value
	dict['is_Student']=document.getElementById('yesCheck').checked
	dict['is_Faculty']=document.getElementById('noCheck').checked
	dict['Password']=document.getElementById('pwd').value
	dict['Confirm Password']=document.getElementById('conf_pwd').value
	console.log(dict['is_Student'],dict['is_Faculty'])
	var t=false;
	
	var errortag=document.getElementById('errors');
	errortag.innerHTML=""
	errortag.style.display='none'
	console.log(dict)
	for(var key in dict){
		if(key=='is_Student' || key=='is_Faculty' || key=='Roll_Num'){
			continue;
		}
		if(dict[key]=="" || dict[key]==null){
			t=true
			var li=document.createElement('li')
			li.innerHTML=key+ " field is Required"
			errortag.appendChild(li)
		}
	}
	console.log()
	if(!dict['is_Student'] && !dict['is_Faculty']){
			t=true
			var li=document.createElement('li')
			li.innerHTML="Student/Faculty checkbox field is Required"
			errortag.appendChild(li)	
	}
	if(dict['is_Student']){
		if(!dict['Roll_Num']){
			t=true
			var li=document.createElement('li')
			li.innerHTML="Roll No. checkbox field is Required"
			errortag.appendChild(li)
		}
		else{
			 if (rollnoCheck(dict['Roll_Num'])) {
    		 }
    		 else{
    		 	t=true
    			var li=document.createElement('li')
				li.innerHTML="Enter a valid Roll Number"
				errortag.appendChild(li)
    		}
		}
	}
	console.log(!CheckPassword(dict['Password']),"dsfasfd")
	if (!CheckPassword(dict['Password'])) {
		t=true
		var li=document.createElement('li')
		li.innerHTML="Password should be between 6 to 20 characters which contain at least one numeric digit, one uppercase and one lowercase letter."
		errortag.appendChild(li)
	}
	
	if(dict['Password']==dict['Confirm Password']){
		
	}
	else{
		t=true
		var li=document.createElement('li')
		li.innerHTML="Confirm password doesn't match"
		errortag.appendChild(li)
	}
	
if(t){
	console.log(errortag)
	errortag.style.display='block'
	return false;
	
}
alert('Account created successfully');
}