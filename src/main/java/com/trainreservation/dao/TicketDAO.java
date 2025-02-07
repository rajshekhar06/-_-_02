package com.trainreservation.dao;

import com.trainreservation.model.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class TicketDAO {

    // Book a ticket
    public boolean bookTicket(Ticket ticket) {
        String query = "INSERT INTO tickets (ticket_id, username, source, destination, travel_date, train_name, seat_type, seat_count, total_amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            String ticketId = UUID.randomUUID().toString();  // Auto-generate unique ticket ID
            stmt.setString(1, ticketId);
            stmt.setString(2, ticket.getUsername());
            stmt.setString(3, ticket.getSource());
            stmt.setString(4, ticket.getDestination());
            stmt.setDate(5, java.sql.Date.valueOf(ticket.getTravelDate())); // Convert LocalDate to SQL Date
            stmt.setString(6, ticket.getTrainName());
            stmt.setString(7, ticket.getSeatType());
            stmt.setInt(8, ticket.getSeatCount());
            stmt.setDouble(9, ticket.getTotalAmount());
            int result = stmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get Ticket by Ticket ID
    public Ticket getTicketById(String ticketId) {
        String query = "SELECT * FROM tickets WHERE ticket_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, ticketId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Ticket(
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get all tickets for a user
    public Ticket[] getTicketsByUsername(String username) {
        String query = "SELECT * FROM tickets WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            // Count rows first
            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
            }
            Ticket[] tickets = new Ticket[rowCount];
            rs.beforeFirst();
            int index = 0;
            while (rs.next()) {
                tickets[index++] = new Ticket(
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
            }
            return tickets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Ticket[0];
    }
}
