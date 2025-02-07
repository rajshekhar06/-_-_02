<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservation Confirmation</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Reservation Confirmation</h2>
        
        <p><strong>Reservation ID:</strong> <%= request.getAttribute("reservationId") %></p>
        <p><strong>Train Number:</strong> <%= request.getAttribute("trainNumber") %></p>
        <p><strong>Passenger Name:</strong> <%= request.getAttribute("passengerName") %></p>
        <p><strong>Passenger Age:</strong> <%= request.getAttribute("passengerAge") %></p>
        <p><strong>Seat Number:</strong> <%= request.getAttribute("seatNumber") %></p>
        <p><strong>Destination:</strong> <%= request.getAttribute("destination") %></p>
        <p><strong>Departure Date:</strong> <%= request.getAttribute("departureDate") %></p>
        
        <a href="reservation.jsp" class="btn">Book Another Ticket</a>
        <a href="logout.jsp" class="btn">Logout</a>
    </div>
</body>
</html>
