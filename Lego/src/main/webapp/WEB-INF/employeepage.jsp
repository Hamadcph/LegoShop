<%-- 
    Document   : employeepage
    Created on : 18-03-2019, 13:33:03
    Author     : Hamad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        
        <h1>Hello <%=request.getParameter( "email")%> </h1>
        You are now logged in as a EMPLOYEE of LegoShop.
    </body>
</html>
