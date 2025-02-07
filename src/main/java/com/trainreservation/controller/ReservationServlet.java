package com.trainreservation.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ReservationServlet extends HttpServlet {

    // JDBC database connection settings
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "SYSTEM";
    private static final String DB_PASSWORD = "BCA5C";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data from the request
        String reservationId = request.getParameter("reservationId");
        String trainNumber = request.getParameter("trainNumber");
        String departureDate = request.getParameter("departureDate");
        String destination = request.getParameter("destination");
        String passengerName = request.getParameter("passengerName");
        int passengerAge = Integer.parseInt(request.getParameter("passengerAge"));
        String seatNumber = request.getParameter("seatNumber");

        // Retrieve username from the session
        HttpSession session = request.getSession(false);
        String username = (session != null) ? (String) session.getAttribute("username") : null;

        if (username == null) {
            // If the session is invalid or the user is not logged in, redirect to the login page
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection to the database
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                // SQL query to insert reservation data
                String query = "INSERT INTO reservations (reservation_id, username, train_number, departure_date, destination, passenger_name, passenger_age, seat_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, reservationId);
                    stmt.setString(2, username);
                    stmt.setString(3, trainNumber);
                    stmt.setDate(4, java.sql.Date.valueOf(departureDate));
                    stmt.setString(5, destination);
                    stmt.setString(6, passengerName);
                    stmt.setInt(7, passengerAge);
                    stmt.setString(8, seatNumber);

                    int rowsInserted = stmt.executeUpdate();

                    if (rowsInserted > 0) {
                        // Set reservation details in the request scope
                        request.setAttribute("reservationId", reservationId);
                        request.setAttribute("trainNumber", trainNumber);
                        request.setAttribute("departureDate", departureDate);
                        request.setAttribute("destination", destination);
                        request.setAttribute("passengerName", passengerName);
                        request.setAttribute("passengerAge", passengerAge);
                        request.setAttribute("seatNumber", seatNumber);
                    
                        // Forward the request to confirmation.jsp
                        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
                    } else {
                        request.setAttribute("error", "Failed to create reservation. Please try again.");
                        request.getRequestDispatcher("reservation.jsp").forward(request, response);
                    }
                    
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle database errors
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("reservation.jsp").forward(request, response);
        }
    }
}
