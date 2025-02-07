package com.trainreservation.controller;

import com.trainreservation.dao.DatabaseConnection;
import com.trainreservation.model.Ticket;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM tickets WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            ArrayList<Ticket> tickets = new ArrayList<>();

            // Loop through the result set and create Ticket objects
            while (rs.next()) {
                Ticket ticket = new Ticket(
                    rs.getString("ticket_id"),
                    rs.getString("username"),
                    rs.getString("source"),
                    rs.getString("destination"),
                    rs.getDate("travel_date").toLocalDate(),
                    rs.getString("train_name"),
                    rs.getString("seat_type"),
                    rs.getInt("seat_count"),
                    rs.getDouble("total_amount")
                );
                tickets.add(ticket); // Add ticket to the list
            }

            // Set tickets as request attribute for displaying in JSP
            request.setAttribute("tickets", tickets);
            request.getRequestDispatcher("display.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error retrieving ticket details.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
