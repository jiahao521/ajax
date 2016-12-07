<%--
  Created by IntelliJ IDEA.
  User: jiahao0
  Date: 2016/12/5
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <button id="btn">load</button>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>


    <script>
        (function () {
            document.querySelector("#btn").onclick = function () {
                var xmlHttp = new XMLHttpRequest();
                xmlHttp.open("get","/user.xml");
                xmlHttp.onreadystatechange = function () {
                    if(xmlHttp.readyState == 4) {
                        if(xmlHttp.status == 200) {
                            //获取服务端返回的XML文档，并进行解析
                            var xmlDoc = xmlHttp.responseXML;
                            var userElements = xmlDoc.getElementsByTagName("user");

                            var tbody = document.querySelector("tbody");
                            for(var i = 0;i < userElements.length;i++) {
                                var userElement = userElements[i];
                                var id = userElement.getAttribute("id");
                                var name = userElement.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                                var address = userElement.getElementsByTagName("address")[0].childNodes[0].nodeValue;

                                //创建tr并添加到tbody中
                                var tr = document.createElement("tr");
                                var idTd = document.createElement("td");
                                var nameTd = document.createElement("td");
                                var addressTd = document.createElement("td");

                                var idNote = document.createTextNode(id);
                                var nameNode = document.createTextNode(name);
                                var addressNode = document.createTextNode(address);

                                idTd.appendChild(idNote);
                                nameTd.appendChild(nameNode);
                                addressTd.appendChild(addressNode);

                                tr.appendChild(idTd);
                                tr.appendChild(nameTd);
                                tr.appendChild(addressTd);

                                tbody.appendChild(tr);

                            }

                        } else {
                            alert("服务端错误" +　xmlHttp.status);
                        }
                    }
                };
                xmlHttp.send();
            };

        })();
    </script>
</body>
</html>
