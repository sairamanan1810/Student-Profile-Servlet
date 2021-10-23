function change_accomplishments(type){
    var tag1=document.querySelector('.projects')
    var tag2=document.querySelector('.internships')
    var tag3=document.querySelector('.journals')
    var tag5=document.querySelector('#interns_head')
    var tag4=document.querySelector('#project_head')
    var tag6=document.querySelector('#journal_head')
    if(type=='intern'){
        tag1.style.display='none'
        tag2.style.display='block'
        tag3.style.display='none'
        tag4.style.fontWeight='normal'
        tag5.style.fontWeight='bolder'
        tag6.style.fontWeight='normal'
        tag4.style.textDecoration='none'
        tag5.style.textDecoration='underline'
        tag6.style.textDecoration='none'
    }
    else if(type=='projects'){
        tag1.style.display='block'
        tag2.style.display='none'
        tag3.style.display='none'
        tag4.style.fontWeight='bolder'
        tag5.style.fontWeight='normal'
        tag6.style.fontWeight='normal'
        tag4.style.textDecoration='underline'
        tag5.style.textDecoration='none'
        tag6.style.textDecoration='normal'
    }
    else{
        tag1.style.display='none'
        tag2.style.display='none'
        tag3.style.display='block'
        tag4.style.fontWeight='normal'
        tag5.style.fontWeight='normal'
        tag6.style.fontWeight='bolder'
        tag4.style.textDecoration='none'
        tag5.style.textDecoration='none'
        tag6.style.textDecoration='underline'
    }

}