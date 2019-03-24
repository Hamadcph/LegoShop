<%-- 
    Document   : ShowOrders
    Created on : 24-03-2019, 17:17:52
    Author     : Hamad
--%>

<%@page import="FunctionLayer.OrderHouse"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>

        <h1>Your Previous Orders</h1>

        <%
            ArrayList<OrderHouse> orderList = (ArrayList) session.getAttribute("orderList");
            for (int i = 0; i < orderList.size(); i++) {
                out.println("<form name=\"ShowOrder\" action=\"FrontController\" method=\"POST\">\n"
                        + "<input type=\"hidden\" name=\"Command\" value=\"ShowOrder\">"
                        + "<input type=\"submit\" value=\"" + orderList.get(i).toString() + "\">"
                        + "<input type=\"hidden\" name=\"idOrder\" value=\"" + orderList.get(i).getIdOrder() + "\"><br>"
                );
            }
        %>
    </form>

</center>
</body>
</html>
