/**
 * 
 */
function validate(){
	console.log("sai")
	var roll_no=document.getElementById("roll_no").value;  
	var password=document.getElementById("pwd").value;  
	var t=false;
	var errortag=document.getElementById('errors');
	errortag.style.display='none'
	var rn=document.getElementById('error_rollno');
	rn.style.display='none'
	rn.innerHTML=""
	var pwd=document.getElementById('error_pwd')
	pwd.style.display='none'
	pwd.innerHTML=""
	
	if (roll_no==null || roll_no==""){  
	  
	rn.innerHTML="Roll Number Field Required"
	rn.style.display='block'
	t=true
	   
	}
	if(password==null || password==""){    
	  pwd.innerHTML="Password Field Required"
	  pwd.style.display='block'
	t=true
	  }
if(t){
	
	errortag.style.display='block'
	return false;
	
}
}