<%-- 
    Document   : results
    Created on : Nov 3, 2013, 4:26:15 PM
    Author     : jlombardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results Page</title>
    </head>
    <body>
    
    <h2>Results of your JPA Database Request</h2>
    <p><a href="index.jsp">Go Back Home</a></p>

    <c:if test="${fn:length(mfgs) > 0}">
        <table width="500" border="1" cellspacing="0" cellpadding="4">
            <tr style="background-color: black;">
                <th align="left" style="color:white;">Mfg. Name</th>
                <th align="left" style="color:white;">City</th>
                <th align="left" style="color:white;">State</th>
            </tr>
            <c:forEach var="mfg" items="${mfgs}" varStatus="rowCount">
                <c:choose>
                    <c:when test="${rowCount.count % 2 == 0}">
                        <tr style="background-color: white;">
                    </c:when>
                    <c:otherwise>
                        <tr style="background-color: #ccffff;">
                    </c:otherwise>
                </c:choose>
                <td align="left">${mfg.name}</td>
                <td align="left">${mfg.city}</td>
                <td align="left">${mfg.state}</td>
            </tr>
            </c:forEach>
        </table>
    </c:if>
    
    <c:if test="${fn:length(products) > 0}">
        <table width="500" border="1" cellspacing="0" cellpadding="4">
            <tr style="background-color: black;">
                <th align="left" style="color:white;">Product Name</th>
                <th align="left" style="color:white;">Price</th>
                <th align="left" style="color:white;">Manufacturer</th>
            </tr>
            <c:forEach var="p" items="${products}" varStatus="rowCount">
                <c:choose>
                    <c:when test="${rowCount.count % 2 == 0}">
                        <tr style="background-color: white;">
                    </c:when>
                    <c:otherwise>
                        <tr style="background-color: #ccffff;">
                    </c:otherwise>
                </c:choose>
                <td align="left">${p.description}</td>
                <td align="left">${p.purchaseCost}</td>
                <td align="left">${p.manufacturerId.name}</td>
            </tr>
            </c:forEach>
        </table>
    </c:if>
    
</body>
</html>
