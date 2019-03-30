$.ajax({
    method: "post",
    url: "http://localhost:8080/login",
    success: function () {
        $("#form-login").hide();
        $("#user").show();
        $("#div-register").hide();
    },
    error: function () {
        firstPage();
    }
});
$("#button-form-register").click(function () {
    console.log('register');
    $("#form-login").hide();
    $("#user").hide();
    $("#div-register").show();
});
$("#button-register").click(function () {
    if ($("#email:valid").length === 0) {
        console.log("invalid form");
        return;
    }
    const name = $("#uniqueName").val();
    const email = $("#email").val();
    const password = $("#inputPassword").val();
    const confirmPassword = $("#inputPasswordConfirm").val();
    const user = {
        login: name,
        password: password,
        email: email
    };
    if (password !== confirmPassword){
        alert("Passwords are not the same!");
        return;
    }
    $.ajax({
        url: "http://localhost:8080/registration",
        method: "post",
        data: JSON.stringify(user),
        contentType: "application/json",
        success: function () {
            alert("Możesz się już zalogować");
            $("#form-login").show();
            $("#user").hide();
            $("#div-register").hide();
        },
        error: function () {
            alert("Błędne dane formularza");
        }
    })
});

$("#button-zaloguj").click(function () {
    const login = $("#loginToLog").val();
    const password = $("#passwordToLog").val();
    $.ajax({
        url: "http://localhost:8080/login",
        method: "post",
        headers: {
            "Authorization": "Basic " +  btoa(login + ":" + password)
        },
        success: function () {
            alert("Zostałeś zalogowany");
            $("#form-login").hide();
            $("#user").show();
            $("#div-register").hide();
        },
        error: function () {
            alert("Błędne hasło lub login");
            firstPage();
        }
    })
});

$("#button-logout").click(function () {
    $.ajax({
        method: "get",
        url: "http://localhost:8080/logout",
        success: function () {
            alert("Wylogowano!");
            firstPage();
            $("#form-login").show();
        }
    });
});

$("#div-posts").click(function () {
    
});

function firstPage() {
    $("#div-register").hide();
    $("#user").hide();
}
function allPosts(posts) {

}