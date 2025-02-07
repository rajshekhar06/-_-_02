<table>
    <thead>
        <tr>
            <th>Reservation ID</th>
            <th>Train Number</th>
            <th>Departure Date</th>
            <th>Destination</th>
            <th>Passenger Name</th>
            <th>Passenger Age</th>
            <th>Seat Number</th>
        </tr>
    </thead>
    <tbody>
        <% 
            List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
            if (tickets != null) {
                for (Ticket ticket : tickets) {
        %>
        <tr>
            <td><%= ticket.getReservationId() %></td>
            <td><%= ticket.getTrainNumber() %></td>
            <td><%= ticket.getDepartureDate() %></td>
            <td><%= ticket.getDestination() %></td>
            <td><%= ticket.getPassengerName() %></td>
            <td><%= ticket.getPassengerAge() %></td>
            <td><%= ticket.getSeatNumber() %></td>
        </tr>
        <% 
                }
            } 
        %>
    </tbody>
</table>

<form action="logout.jsp" method="post">
    <button type="submit" class="btn logout"><i class="fas fa-sign-out-alt"></i> Logout</button>
</form>
