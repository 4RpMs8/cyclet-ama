const accountDrawer = document.getElementById("accountDrawer");
const accountClose = document.getElementById("accountClose");
const accountopen = document.getElementById("openAccount");
const accountOverlay = document.getElementById("accountOverlay");

accountClose.addEventListener("click" , function(){
    accountDrawer.classList.remove("active");
    accountOverlay.classList.remove("active");
});

accountopen.addEventListener("click" , function(){
    accountDrawer.classList.add("active");
    accountOverlay.classList.add("active");
});

accountOverlay.addEventListener("click" , function(){
    accountDrawer.classList.remove("active");
    accountOverlay.classList.remove("active");
});