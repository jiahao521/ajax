<%--
  Created by IntelliJ IDEA.
  User: jiahao0
  Date: 2016/12/6
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <button id="btn">提交</button>
    <script>
        (function () {
            document.querySelector("#btn").onclick = function () {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.open("get","/res.xml");
                xmlhttp.send();
            };

        })();
    </script>
</body>
</html>
