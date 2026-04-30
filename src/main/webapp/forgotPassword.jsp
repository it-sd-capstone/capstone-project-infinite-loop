<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Forgot Password - Happenings</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css" />
  <link rel="stylesheet" type="text/css" href="css/login-register.css" />
</head>
<body class="page-login">
<main id="loginPage">

  <section class="welcome-section">
    <h1>Happenings</h1>
    <p>Enter your email and we'll send you a reset link.</p>
  </section>

  <section class="login-section">
    <h3>Forgot Your Password?</h3>
    <form id="forgotForm" method="POST" action="forgotPassword">
      <input
              type="email"
              id="email"
              name="email"
              placeholder="Enter your email address"
              required
      />
      <button type="submit">Send Reset Link</button>
      <p id="resetMessage"></p>
    </form>
    <p class="register-link">
      Remembered it? <a href="login.jsp">Back to Login</a>
    </p>
  </section>

</main>
</body>
</html>