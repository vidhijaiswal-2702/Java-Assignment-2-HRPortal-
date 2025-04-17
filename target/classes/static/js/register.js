document.getElementById("registerForm").addEventListener("submit", async (e) => {
    e.preventDefault();
  
    const name = document.getElementById("name").value;
    const email = document.getElementById("regEmail").value;
    const password = document.getElementById("regPassword").value;
  
    try {
      const response = await fetch("http://localhost:8080/api/hr/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, email, password }),
      });
  
      if (response.ok) {
        alert("Registration successful! Please login.");
        document.getElementById("registerForm").reset();
        document.getElementById("registerFormContainer").classList.remove("active");
        document.getElementById("loginFormContainer").classList.add("active");
      } else {
        document.getElementById("errorMsgRegister").textContent = "Registration failed!";
      }
    } catch (err) {
      document.getElementById("errorMsgRegister").textContent = "Server error!";
    }
  });
  