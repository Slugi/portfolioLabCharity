document.addEventListener("DOMContentLoaded", function () {

    const btn = document.querySelector("form");
    let pswd;
    let pswd2;
    const failedPswCheck = document.getElementById("failPswCheck");

    btn.addEventListener('submit', checkPasswords);

    function checkPasswords(event){
        pswd = document.getElementById("pswd");
        pswd2 = document.getElementById("pswd2");

        if(pswd.value !== pswd2.value){
            pswd.value = "";
            pswd2.value = "";
            event.preventDefault();
            failedPswCheck.style.display = "block";
            pswd.style.backgroundColor = "lightcoral";
            pswd2.style.backgroundColor = "lightcoral";
        }
    }
})