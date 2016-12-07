<%--
  Created by IntelliJ IDEA.
  User: jiahao0
  Date: 2016/12/7
  Time: 16:01
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
<button id="btn">json</button>
<script>
    (function() {
        document.querySelector("#btn").onclick = function(){
            var xmlHttp = new XMLHttpRequest();

            xmlHttp.open("get","/data.json");
            xmlHttp.onreadystatechange = function() {
                if(xmlHttp.readyState == 4) {
                    if(xmlHttp.status == 200) {
                        //获取服务端返回的字符串
                        var result = xmlHttp.responseText;
                        alert(result.length);

                        //将字符串转换为JSON码
                        var json = JSON.parse(result);

                        for(var i = 0;i <json.length;i++) {
                            var user = json[i];

                            alert(user.id + " -> " + user.username + " -> " + user.address);
                        }
                    }
                }

            };
            xmlHttp.send();

        };


    })();


</script>
</body>
</html>
