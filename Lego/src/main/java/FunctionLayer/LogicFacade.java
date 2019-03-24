/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import Datalayer.UserMapper;
import java.util.ArrayList;

/**
 *
 * @author Hamad
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static void createOrder(int userId, OrderHouse order) throws LoginSampleException {
        UserMapper.createOrder(userId, order);
    }

    public static ArrayList<OrderHouse> showCustomerOrders(String userId) throws LoginSampleException {
        return UserMapper.showCustomerOrders(userId);
    }

    public static ArrayList<OrderHouse> showAllOrders() throws LoginSampleException {
        return UserMapper.allOrders();
    }

    public static OrderHouse showSingleOrder(int orderId) throws LoginSampleException {
        return UserMapper.oneOrder(orderId);

    }

}
