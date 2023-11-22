<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Address Book</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-stone-300">
<div class="p-6">
    <h1 class="m-6 text-2xl text-sky-700" >Posts</h1>

    <div class="">
        <c:forEach var="post" items="${posts}">
                <a href="#" class="p-4 block max-w-sm p-6 bg-white border border-gray-200 rounded-lg shadow hover:bg-gray-100 dark:bg-gray-800 dark:border-gray-700 dark:hover:bg-gray-700">
                    <h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">${post.getTitle()}</h5>
                    <p class="font-normal text-gray-700 dark:text-gray-400">${post.getDesc()}</p>
                </a>
                <br>
            </div>
        </c:forEach>
    </div>

    <c:if test="${login == true}">
        <div class="m-6" data-media="('max-width: 767px)">
            <a href="${pageContext.request.contextPath}/logout" class="inline-flex items-center px-3 py-2 text-sm font-medium text-center text-white bg-sky-700 rounded-lg hover:bg-sky-800 focus:ring-4 focus:outline-none focus:ring-green-300 dark:bg-sky-600 dark:hover:bg-sky-700 dark:focus:ring-sky-800">
                logout
                <svg class="rtl:rotate-180 w-3.5 h-3.5 ms-2" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                </svg>
            </a>
        </div>

        <div class="m-6" data-media="('max-width: 767px)">
            <a href="${pageContext.request.contextPath}/logout" class="inline-flex items-center px-3 py-2 text-sm font-medium text-center text-white bg-sky-700 rounded-lg hover:bg-sky-800 focus:ring-4 focus:outline-none focus:ring-green-300 dark:bg-sky-600 dark:hover:bg-sky-700 dark:focus:ring-sky-800">
                add post
                <svg class="rtl:rotate-180 w-3.5 h-3.5 ms-2" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                </svg>
            </a>
        </div>
    </c:if><c:if test="${login == false}">
        <div class="m-6">
            <a href="${pageContext.request.contextPath}/login" class="inline-flex items-center px-3 py-2 text-sm font-medium text-center text-white bg-sky-700 rounded-lg hover:bg-sky-800 focus:ring-4 focus:outline-none focus:ring-green-300 dark:bg-sky-600 dark:hover:bg-sky-700 dark:focus:ring-sky-800">
                login
                <svg class="rtl:rotate-180 w-3.5 h-3.5 ms-2" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9"/>
                </svg>
            </a>
        </div>
    </c:if>
    </div>

</div>
</body>
</html>


