$("#button-register").click(function () {
    const name = $("#uniqueName").val();
    const email = $("#email").val();
    const password = $("#inputPassword").val();
    const confirmPassword = $("#inputPasswordConfirm").val();
    const user = {
        login: name,
        password: password,
        email: email,
        role: "USER",
        type: "PUBLIC"
    };
    if (password != confirmPassword){
        alert("Passwords are not the same!");
    }
    $.ajax({
        url: "http://localhost:8080/user",
        method: "post",
        data: JSON.stringify(user),
        contentType: "application/json",
        success: function () {
            window.location.href = "http://localhost:8080";
        }
    })
});