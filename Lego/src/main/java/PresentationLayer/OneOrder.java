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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hamad
 */

public class OneOrder extends Command {

        public OneOrder() {
    }
      @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int idOrder = Integer.parseInt(request.getParameter("idOrder"));
            
        OrderHouse OneOrder = LogicFacade.showSingleOrder(idOrder);

        Bricks bricks = Calculator.build(OneOrder.getLength(), OneOrder.getHeight(), OneOrder.getWidth());
        
        request.getSession().setAttribute("idOrder", idOrder);
        request.getSession().setAttribute("length", String.valueOf(OneOrder.getLength()));
        request.getSession().setAttribute("height", String.valueOf(OneOrder.getHeight()));
        request.getSession().setAttribute("width", String.valueOf(OneOrder.getWidth()));
        request.getSession().setAttribute("bricks", bricks);

        return "orderpage";
    }
}