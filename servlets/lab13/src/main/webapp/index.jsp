<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <title>JSP - Hello World</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1><%= "Hello World!" %></h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Address Book</title>
</head>
<body>
<div class="container">
    <h1>
        Your Address Book
    </h1>

    <div>
        <c:forEach var="contact" items="${contacts}">
            <div>
                <p>${contact.getName()}</p>
                <ul>
                    <c:forEach var="phone" items="${contact.getPhones()}">
                        <li>${phone}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:forEach>
    </div>

    <div>
        <a href="${pageContext.request.contextPath}/contacts/update">
            Add New Contact
        </a>
    </div>
</div>
</body>
</html>

