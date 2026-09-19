const modelButtons = 
document.querySelectorAll(".model-button");

modelButtons.forEach(function (button){
    button.addEventListener("click" , function(){
        modelButtons.forEach(function(btn){
            btn.classList.remove("active")
        });
        button.classList.add("active");
    });
});