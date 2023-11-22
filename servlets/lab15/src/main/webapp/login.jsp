<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Update Contact</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="m-6 bg-stone-300">
<div class="container mx-auto max-w-xl p-4 ">
  <h1 class="text-3xl font-bold my-4 text-center">Login</h1>

  <div class="rounded-lg shadow-md p-4 mt-8 bg-stone-200">
    <form action="${pageContext.request.contextPath}/login" method="POST">
      <div class="grid gap-6 mb-6 md:grid-cols-2">
        <div>
          <label for="username" class="block mb-2 text-sm font-medium">
            Username
          </label>
          <input type="text" id="username" name="username"
                 class="bg-gray-50 border border-gray-500 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                 placeholder="Enter username" required>
        </div>
        <div>
          <label for="password" class="block mb-2 text-sm font-medium">
            Password
          </label>
          <input type="password" id="password" name="password"
                 class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                 placeholder="•••••••••" required>
        </div>
      </div>
      <button type="submit"
              class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center">
        Login now!
      </button>
    </form>
  </div>

</div>
</body>
</html>
