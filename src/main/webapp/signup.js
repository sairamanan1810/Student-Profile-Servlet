function yesnoCheck() {
	console.log("hello")
    if (document.getElementById('yesCheck').checked) {
        document.getElementById('ifStudent').style.display = 'block';
    }
    else document.getElementById('ifStudent').style.display = 'none';
}

function validate(){
	console.log("sai")
	var dict={}
	dict['Name']=document.getElementById('name').value
	dict['Email']=document.getElementById('email').value
	dict['Roll No.']=document.getElementById('roll_no').value
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
		if(key=='is_Student' || key=="is_Faculty"){
			continue;
		}
		if(dict[key]=="" || dict[key]==null){
			t=true
			var li=document.createElement('li')
			li.innerHTML=key+ " field is Required"
			errortag.appendChild(li)
		}
	}
	console.log(dict['is_Student'],dict['is_Faculty'])
	if(!(!dict["is_faculty"] && !dict['is_Student'])){
			var li=document.createElement('li')
			li.innerHTML="Student/Faculty checkbox field is Required"
			errortag.appendChild(li)	
	}
if(t){
	console.log(errortag)
	errortag.style.display='block'
	return false;
	
}
}