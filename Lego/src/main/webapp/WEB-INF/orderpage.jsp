<%-- 
    Document   : orderpage
    Created on : 24-03-2019, 17:35:50
    Author     : Hamad
--%>

<%@page import="FunctionLayer.Bricks"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Order:</h1>

    <h3>Your Order:</h3>

    <table>
        <tr>
            <th>House Length</th>
            <th>Huse Width</th>
            <th>House Height</th> 
        </tr>
        <tr>
            <td>
                <%= session.getAttribute("length")%>
            </td>
            <td>
                <%= session.getAttribute("height")%>
            </td>
            <td>
                <%= session.getAttribute("width")%>
            </td>
        </tr>
    </table>
    <br>

    <h3>Your Bricks:</h3>
    <%
        Bricks bricks = (Bricks) session.getAttribute("bricks");
    %>

    <table>
        <tr>
            <th>Type</th>
            <th>Amount</th>
        </tr>
        <tr>
            <td>4x2</td>
            <td>
                <%= bricks.getFour()%>
            </td>
        </tr>
        <tr>
            <td>2x2</td>
            <td>
                <%= bricks.getTwo()%>
            </td>
        </tr>
        <tr>
            <td>1x2</td>
            <td>
                <%= bricks.getOne()%>
            </td>
        </tr>
    </table>

    <br>

</body>
</html>