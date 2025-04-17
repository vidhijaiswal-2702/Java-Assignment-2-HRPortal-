document.getElementById("loginForm").addEventListener("submit", async (e) => {
    e.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    try {
        const response = await fetch("http://localhost:8080/api/hr/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email, password })
        });

        if (response.ok) {
            const hr = await response.json();
            sessionStorage.setItem("hrUser", JSON.stringify(hr));
            window.location.href = "dashboard.html";
        } else {
            const errMsg = await response.text();
            document.getElementById("errorMsg").textContent = errMsg || "Invalid credentials!";
        }
    } catch (error) {
        console.error("Error during login:", error);
        document.getElementById("errorMsg").textContent = "Server not responding. Please try again later.";
    }
});
