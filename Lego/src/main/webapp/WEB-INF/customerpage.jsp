<%-- 
    Document   : customerpage
    Created on : 18-03-2019, 13:32:36
    Author     : Hamad
--%><%@page import="FunctionLayer.User"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=((User) session.getAttribute("user")).getEmail()%> </h1>
        You are now logged in as a customer of our wonderful site.
    </body>
    <table> 

        <tr>
            <td>
                <form name="TheHouse" action="FrontController" method="POST">
                    <input type="hidden" name="Command" value="TheHouse">
                    house length:<br>
                    <input type="text" name="houselength" value="13">
                    <br>
                    house width:<br>
                    <input type="text" name="housewidth" value="9">
                    <br>
                    house height:<br>
                    <input type="text" name="househeight" value="4">
                    <br>
                    <br>
                    <input type="submit" value="Submit">
                </form>

                <form name="ShowOrders" action="FrontController" method="POST">
                    <input type="hidden" name="Command" value="ShowOrders">
                    <input type="submit" value="Show Previous Orders">
                </form>
                <br>

                <br>
            </td>


        </tr>
    </table>
    <% String error = (String) request.getAttribute("error");
        if (error != null) {
            out.println("<H2>Error!!</h2>");
            out.println(error);
        }
    %>


</html>