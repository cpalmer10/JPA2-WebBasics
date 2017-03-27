<%-- 
    Document   : This is the configured error page. It is configured in web.xml
    Created on : Nov 3, 2013, 4:16:32 PM
    Author     : jlombardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="color:red;">ERROR!</h1>
        <!-- 
            Get the exception object and auto call its toString() method
        -->
        <p>${pageContext.errorData.throwable}</p>
    </body>
</html>
