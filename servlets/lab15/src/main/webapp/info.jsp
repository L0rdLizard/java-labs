<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Update Contact</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="m-6 bg-stone-300">
<div style="max-width: 40rem; margin: auto; padding: 2rem; background-color: #81b5e1; color: #1a202c; text-align: center;" class = "rounded-md">
    <h1 style="font-size: 1.875rem; font-weight: bold; margin-bottom: 1rem;">${status}</h1>
    <h3 style="font-size: 1.25rem; font-weight: bold; color: #2c2d31; margin-bottom: 1rem;">${message}</h3>
    <p style="text-align: center;">
        <a href="${pageContext.request.contextPath}/" style="color: #1a202c; text-decoration: underline; hover: #1a202c;">Homepage</a>
        ${" • "}
        <a href="${pageContext.request.contextPath}/add" style="color: #1a202c; text-decoration: underline; hover: #1a202c;">New post</a>
    </p>
</div>
</body>
</html>
