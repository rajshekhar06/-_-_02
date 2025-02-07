<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Train Ticket Reservation</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <!-- Display username -->
        <div class="welcome">
            <p>Welcome, <b><%= (String) session.getAttribute("username") %></b></p>
        </div>

        <h2><i class="fas fa-train"></i> Train Ticket Reservation</h2>

        <!-- Reservation Form -->
        <form action="reserve" method="post">
            <label for="reservationId">Reservation ID:</label>
            <input type="text" id="reservationId" name="reservationId" value="<%= java.util.UUID.randomUUID().toString() %>" readonly>
            
            <label for="trainNumber">Train Number:</label>
            <input type="text" id="trainNumber" name="trainNumber" placeholder="Enter train number" required>
            
            <label for="departureDate">Departure Date:</label>
            <input type="date" id="departureDate" name="departureDate" required>
            
            <label for="destination">Destination:</label>
            <input type="text" id="destination" name="destination" placeholder="Enter destination" required>
            
            <label for="passengerName">Passenger Name:</label>
            <input type="text" id="passengerName" name="passengerName" placeholder="Enter passenger name" required>
            
            <label for="passengerAge">Passenger Age:</label>
            <input type="number" id="passengerAge" name="passengerAge" placeholder="Enter passenger age" required>
            
            <label for="seatNumber">Seat Number:</label>
            <input type="text" id="seatNumber" name="seatNumber" placeholder="Enter seat number" required>
            
            <button type="submit" class="btn"><i class="fas fa-ticket-alt"></i> Book Ticket</button>
        </form>
    </div>
</body>
</html>
