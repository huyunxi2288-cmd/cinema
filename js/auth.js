function requireAdmin() {
    if (localStorage.getItem("role") !== "admin") {
        alert("无权限访问");
        location.href = "../staff/login.html";
    }
}

function requireLogin() {
    if (!localStorage.getItem("role")) {
        location.href = "../staff/login.html";
    }
}

function logout() {
    localStorage.clear();
    location.href = "../staff/login.html";
}
