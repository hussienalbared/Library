
function changeImg(x){
    document.getElementById('imBook').src = x;
}

function toDo(){
        document.getElementById("signup").style.display="none";
        document.getElementById("user").style.display="inline";
    }
    function toDo2(){

        document.getElementById("lobot").style.display="none";
        document.getElementById("LogInContainer").style.display="block";
        document.getElementById("signup").style.display="none";
        document.getElementById("All").style.opacity=0.3;
    }
    function nothing(){

        document.getElementById("lobot").style.display="inline";
        document.getElementById("LogInContainer").style.display="none";
        document.getElementById("signup").style.display="inline";
        document.getElementById("All").style.opacity=1;
    }
    function borrowBook1(_I){
        document.getElementById("borroIsbn").value=_I;
        document.getElementById("BorrwoingInContainer").style.display="block";
        document.getElementById("All").style.opacity=0.3;
    }
    function boBookX(){
        document.getElementById("BorrwoingInContainer").style.display="none";
        document.getElementById("All").style.opacity=1;
    }
    function ExtendPeriodX(){
        document.getElementById("ExtendPeriodContainer").style.display="none";
        document.getElementById("All").style.opacity=1;
    }
    function InputContainer(x){
        if(x==1)
            document.getElementById("InputContainerISBN").style.display="block";
        else if(x==3)
            document.getElementById("InputContainerAuthor").style.display="block";
        if(x==2)
            document.getElementById("InputContainerYear").style.display="block";
        
        document.getElementById("All").style.opacity=0.3;
    }
    function InputContainerX(){
        document.getElementById("InputContainer").style.display="none";
        document.getElementById("All").style.opacity=1;
    }
    
    function popUpUpdateBookContainerX(){
        document.getElementById("popUpUpdateBookContainer").style.display="none";
        document.getElementById("All").style.opacity=1;
    }
//    function popUpUpdateBookContainer(){
////        document.getElementById("tb").value=t;
////        document.getElementById("_ISBN").value=_src;
//        document.getElementById("popUpUpdateBookContainer").style.display="block";
//        //document.getElementById("All").style.opacity=0.3;
//    }
    function popUpAddeBookContainerX(){
        document.getElementById("popUpAddeBookContainer").style.display="none";
        document.getElementById("All").style.opacity=1;
    }
    function popUpAddeBookContainer(){
        document.getElementById("popUpAddeBookContainer").style.display="block";
        document.getElementById("All").style.opacity=0.3;
    }