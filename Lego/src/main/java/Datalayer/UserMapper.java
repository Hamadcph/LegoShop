/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datalayer;

import FunctionLayer.ProblemException;
import FunctionLayer.OrderHouse;
import FunctionLayer.User;
import FunctionLayer.LoginSampleException;
import Datalayer.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hamad
 */
public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            String id = ids.getString(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                String id = rs.getString("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void createOrder(int id, OrderHouse order) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO OrderHouse (user_id, length, height, width) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getHeight());
            ps.setInt(3, order.getWidth());

            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<OrderHouse> showCustomerOrders(String userId) throws LoginSampleException {
        ArrayList<OrderHouse> orders = new ArrayList();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT idOrder, length, height, width "
                    + "FROM `OrderHouse`"
                    + "WHERE user_id=?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, Integer.parseInt(userId));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idOrder = rs.getInt("idOrder");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                int width = rs.getInt("width");

                orders.add(new OrderHouse(idOrder, length, height, width));
            }
            return orders;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<OrderHouse> allOrders() throws LoginSampleException {
        ArrayList<OrderHouse> orders = new ArrayList();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT idOrder, length, height, width "
                    + "FROM `OrderHouse`;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idOrder = rs.getInt("idOrder");
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                int width = rs.getInt("width");
                OrderHouse house = new OrderHouse(idOrder, length, height, width);
                orders.add(house);

            }
            return orders;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static OrderHouse oneOrder(int orderId) throws LoginSampleException {

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT *"
                    + "FROM `OrderHouse`"
                    + "WHERE idOrder=?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, (orderId));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int length = rs.getInt("length");
                int height = rs.getInt("height");
                int width = rs.getInt("width");
                
                OrderHouse oneOrder = new OrderHouse(orderId, length, height, width);

                return oneOrder;
            } else {
                throw new LoginSampleException("we got a problem");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }

}
