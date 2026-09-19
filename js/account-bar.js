const accountDrawer = document.getElementById("accountDrawer");
const accountClose = document.getElementById("accountClose");
const accountopen = document.getElementById("openAccount")

accountClose.addEventListener("click" , function(){
    accountDrawer.classList.remove("active");
});

accountopen.addEventListener("click" , function(){
    accountDrawer.classList.add("active");
})
