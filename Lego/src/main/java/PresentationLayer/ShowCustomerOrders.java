/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderHouse;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hamad
 */

public class ShowCustomerOrders extends Command {
    
    public ShowCustomerOrders() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        User u = (User) request.getSession().getAttribute("user");
        String userId = u.getId();
        ArrayList<OrderHouse> orders = LogicFacade.showCustomerOrders(userId);

        HttpSession session = request.getSession();
        session.setAttribute("orderList", orders);
        
                
    return "showorders";
    }

}