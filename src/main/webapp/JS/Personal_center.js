//音乐播放控制
window.onload=function(){
    var audio = document.getElementById('BGmusic');

    document.addEventListener('visibilitychange',function(){
        if(document.visibilityState === "hidden")
        {
            audio.src='';
        }else{
            audio.src='../资源/重复时.mp3';
        }
    });
};


// Map_Change
// ---------------------------------------------------------------------------------------------------------------------------------------------------------
var Map = document.getElementById("Managerial_System_interface")

document.querySelectorAll('input[name="ChoiceMap"]').forEach(button => {
    button.addEventListener('checked', function () {
       Map.style.display = "none";
       Map = document.getElementById(this.value);
       Map.style.display = "block";
    });
});

// Member_Information_Management
// ---------------------------------------------------------------------------------------------------------------------------------------------------------
var Member_Information_Management_ResultArea = document.getElementById("Member_Information_Management_ResultArea");
var Member_Information_Submit =document.getElementById("Member_Information_Submit");
var M_xmlhttp = new  XMLHttpRequest();

Member_Information_Submit.onclick=function ()
{
    event.preventDefault();

    var M_typeInput = document.getElementById("Member_Information_Management_Form_type");
    var M_selectedValue = document.querySelector('input[name="Member_Information_Management"]:checked').value;
    M_typeInput.value = M_selectedValue;

    var M_form =document.getElementById("Member_Information_Management_Form");
    var M_formData = new FormData(M_form);
    var M_params =  new URLSearchParams(M_formData).toString();

    M_xmlhttp.open("POST","/Member-Servlet",true);
    M_xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    M_xmlhttp.send(M_params);
}

M_xmlhttp.onreadystatechange=function ()
{
    if(M_xmlhttp.readyState == 4 && M_xmlhttp.status == 200)
    {
        Member_Information_Management_ResultArea.innerHTML = M_xmlhttp.responseText;
    }
}

// Goods_Information_Management
// ---------------------------------------------------------------------------------------------------------------------------------------------------------
var Goods_Information_Management_ResultArea = document.getElementById("Goods_Information_Management_ResultArea");
var Goods_Information_Submit =document.getElementById("Goods_Information_Submit");
var G_xmlhttp = new  XMLHttpRequest();

Goods_Information_Submit.onclick=function ()
{
    event.preventDefault();

    var G_typeInput = document.getElementById("Goods_Information_Management_Form_type");
    var G_selectedValue = document.querySelector('input[name="Goods_Information_Management"]:checked').value;
    G_typeInput.value = G_selectedValue;

    var G_form =document.getElementById("Goods_Information_Management_Form");
    var G_formData = new FormData(G_form);
    var G_params =  new URLSearchParams(G_formData).toString();

    G_xmlhttp.open("POST","/Goods-Servlet",true);
    G_xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    G_xmlhttp.send(G_params);
}

G_xmlhttp.onreadystatechange=function ()
{
    if(G_xmlhttp.readyState == 4 && G_xmlhttp.status == 200)
    {
        Goods_Information_Management_ResultArea.innerHTML = G_xmlhttp.responseText;
    }
}

// Visitor_Information_Management
// ---------------------------------------------------------------------------------------------------------------------------------------------------------
var Visitor_Information_Management_ResultArea = document.getElementById("Visitor_Information_Management_ResultArea");
var Visitor_Information_Submit =document.getElementById("Visitor_Information_Submit");
var V_xmlhttp = new  XMLHttpRequest();

Visitor_Information_Submit.onclick=function ()
{
    event.preventDefault();

    var V_typeInput = document.getElementById("Visitor_Information_Management_Form_type");
    var V_selectedValue = document.querySelector('input[name="Visitor_Information_Management"]:checked').value;
    V_typeInput.value = V_selectedValue;

    var V_form =document.getElementById("Visitor_Information_Management_Form");
    var V_formData = new FormData(V_form);
    var V_params =  new URLSearchParams(V_formData).toString();

    V_xmlhttp.open("POST","/Visitor-Servlet",true);
    V_xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    V_xmlhttp.send(V_params);
}

V_xmlhttp.onreadystatechange=function ()
{
    if(V_xmlhttp.readyState == 4 && V_xmlhttp.status == 200)
    {
        Visitor_Information_Management_ResultArea.innerHTML = V_xmlhttp.responseText;
    }
}

// Visitor_Information_Management
// ---------------------------------------------------------------------------------------------------------------------------------------------------------
var Summary_Button = $("#Summary");

