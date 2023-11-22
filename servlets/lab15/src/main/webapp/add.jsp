<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Update Contact</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="m-6 bg-stone-300">
<div class="block max-w-sm p-6 bg-white border border-gray-200 rounded-lg shadow  dark:bg-blue-400 dark:border-blue-300 ">
    <h1 class="text-center">New advertisement</h1>

    <div>
        <form action="${pageContext.request.contextPath}/add" method="POST">
            <div>
                <label for="title">Post title</label>
                <input type="text" id="title" name="title" placeholder="Enter post title" required>
            </div>
<%--            <div>--%>
<%--                <label for="image">Image URL (optional)</label>--%>
<%--                <input type="url" id="image" name="image" placeholder="https://link.to/your/image.jpg">--%>
<%--            </div>--%>
            <br>
            <div>
                <label for="desc">Your message</label>
                <textarea id="desc" name="desc" rows="4" placeholder="Write your offers here..."></textarea>
            </div>
            <button type="submit">Post</button>
        </form>
    </div>
</div>
</body>
</html>
