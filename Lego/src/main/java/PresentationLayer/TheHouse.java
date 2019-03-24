/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Bricks;
import FunctionLayer.Calculator;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderHouse;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hamad
 */
public class TheHouse extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int houseLength;
        int houseHeight;
        int houseWidth;

        houseLength = Integer.parseInt(request.getParameter("houselength"));
        houseHeight = Integer.parseInt(request.getParameter("househeight"));
        houseWidth = Integer.parseInt(request.getParameter("housewidth"));

        OrderHouse houseOrder = new OrderHouse(10, houseLength, houseHeight, houseWidth);

        HttpSession session = request.getSession();
        session.setAttribute("length", houseLength);
        session.setAttribute("height", houseHeight);
        
        User u = (User) request.getSession().getAttribute("user");
        int userId = Integer.parseInt(u.getId());
        
        if (houseLength > 5 && houseWidth > 5 && houseHeight > 0) {
            Bricks bricks = Calculator.build(houseLength, houseWidth, houseHeight);
            request.getSession().setAttribute("bricks", bricks);
            LogicFacade.createOrder(userId, houseOrder);
            return "orderpage";
        
        } else {
            throw new LoginSampleException("not good");
        }
    }
}
