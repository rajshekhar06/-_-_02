<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            color: #333;
            text-align: center;
            padding-top: 50px;
        }
        .error-message {
            background-color: #ffdddd;
            border: 1px solid #f5c2c2;
            color: #d8000c;
            padding: 20px;
            width: 50%;
            margin: 0 auto;
        }
    </style>
</head>
<body>

    <div class="error-message">
        <h2>Error</h2>
        <p>${error}</p>
    </div>

</body>
</html>
