<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2><i class="fas fa-user-plus"></i> User Registration</h2>
        
        <!-- Registration Form -->
        <form action="register" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" placeholder="Enter username" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter password" required>
            
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Re-enter password" required>
            
            <button type="submit" class="btn"><i class="fas fa-check"></i> Register</button>
        </form>

        <!-- Display error or success messages -->
        <c:if test="${not empty error}">
            <div style="color: red; text-align: center;">${error}</div>
        </c:if>

        <c:if test="${not empty message}">
            <div style="color: green; text-align: center;">${message}</div>
        </c:if>

        <!-- Link to login page if already registered -->
        <p>Already registered? <a href="login.jsp">Login here</a>.</p>
    </div>
</body>
</html>
