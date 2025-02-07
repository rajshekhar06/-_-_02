<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2><i class="fas fa-sign-in-alt"></i> User Login</h2>

        <!-- Login Form -->
        <form action="login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" placeholder="Enter username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter password" required>

            <button type="submit" class="btn"><i class="fas fa-check"></i> Login</button>
        </form>

        <!-- Display error messages -->
        <c:if test="${not empty error}">
            <div style="color: red; text-align: center;">${error}</div>
        </c:if>

        <!-- Link to registration page if not registered -->
        <p>Don't have an account? <a href="register.jsp">Register here</a>.</p>
    </div>
</body>
</html>
