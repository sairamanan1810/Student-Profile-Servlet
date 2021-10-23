function change_list(type){
    console.log("hii")
    var tag1=document.querySelector('.student')
    var tag2=document.querySelector('.faculty')
    var tag3=document.querySelector('.classes')
    var tag4=document.querySelector('.create_class_form')
    
    if(type=='student'){
        tag1.style.display='block';
        tag2.style.display='none';
        tag3.style.display='none';
    }
    else if(type=='faculty'){
        tag1.style.display='none';
        tag2.style.display='block';
        tag3.style.display='none';
    }
    else{
        tag4.style.display='none'
        tag1.style.display='none';
        tag2.style.display='none';
        tag3.style.display='block';   
    }

}
function display_create_form(){
    var tag1=document.querySelector('.create_class_form')
    tag1.style.display='block'
}