
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Search Result</title>
</head>
<body>
<div class="container">
    <h1>
        Search Result
    </h1>

    <div>
        <c:forEach var="contact" items="${contacts}">
<%--            <c:if test="${contact.getName()}" eq="${name}">--%>
            <c:if test="${contact.getName() eq name}">
            <div>

                    <p>${contact.getName()}</p>
                    <ul>
                        <c:forEach var="phone" items="${contact.getPhones()}">
                            <li>${phone}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
        </c:forEach>
    </div>


    <div>
        <a href="${pageContext.request.contextPath}/contacts/update">
            Add New Contact
        </a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/contacts">
            Go to NoteBook
        </a>
    </div>
</div>
</body>
</html>

