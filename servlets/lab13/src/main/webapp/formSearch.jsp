<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Update Contact</title>
</head>
<body>
<div class="container">
    <h1>Search Contact</h1>
    <div>
        <form action="${pageContext.request.contextPath}/contacts/search" method="POST">
            <div>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <label for="submit">

            </label>
            <button type="submit" id="submit">
                Submit
            </button>
        </form>
    </div>
</div>
</body>
</html>
