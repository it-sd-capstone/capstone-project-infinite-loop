<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Register - Happenings</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/login-register.css">
</head>
<body class="page-register">
<main id="registerPage">
    <section class="welcome-section">
        <h1>Join Us</h1>
        <p>Create an account to start planning your Happenings.</p>
    </section>

    <section class="register-section">
        <h3>Create Account</h3>
        <form id="registerForm" method="POST" action="register">
            <input type="text" name="username" placeholder="Username" required>
            <input type="email" name="email" placeholder="Email Address" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="password" name="confirmPassword" placeholder="Confirm Password" required>

            <div class="categories">
                <p>Select your categories:</p>
                <label><input type="checkbox" name="categories" value="music"> Music & Art</label>
                <label><input type="checkbox" name="categories" value="sports"> Sports</label>
                <label><input type="checkbox" name="categories" value="food"> Food & Drink</label>
                <label><input type="checkbox" name="categories" value="outdoor"> Outdoor</label>
                <label><input type="checkbox" name="categories" value="technology"> Technology</label>
                <label><input type="checkbox" name="categories" value="community"> Community</label>
            </div>

            <button type="submit">Register</button>
            <p id="registerMessage"></p>
        </form>
        <p class="register-link">
            Already have an account? <a href="login.jsp">Log in</a>
        </p>
    </section>
</main>
</body>
</html>