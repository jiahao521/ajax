<%--
  Created by IntelliJ IDEA.
  User: jiahao0
  Date: 2016/12/5
  Time: 11:06
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
    <form action=""></form>
    <input type="text" id="name">
    <button id="btn">提交</button>
    <div id="result"></div>

    <script>
        (function () {
            //创建XMLHttpRequest
            function creatXMLHttpRequest() {
                var XmlHttp = null;
                if(window.ActiveXObject) {
                    //IE
                    XmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                } else {
                    XmlHttp = new XMLHttpRequest();
                }
                return XmlHttp;
            }

            document.querySelector("#btn").onclick = function(){
                var name = document.querySelector("#name").value;
                //sendGet(name);
                sendPost(name);
            };

            function sendGet(name) {
                //1.获取Ajax引擎
                var XmlHttp = creatXMLHttpRequest();
                //2.指定请求方式（doPOST/doGET）和请求地址
                XmlHttp.open("get","ajax?name="+name);
                //3.发出请求
                XmlHttp.send();
            }
            function sendPost(name) {
                //1. 获取Ajax引擎
                var xmlHttp = creatXMLHttpRequest();
                //2. 指定请求方式(加enctype)和地址
                xmlHttp.open("post", "/ajax");
                xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
                //3.配置回掉函数
                xmlHttp.onreadystatechange = function () {
                    var state = xmlHttp.readyState;
                    if(state == 4) {
                        //获取HTTP状态码
                        var httpState = xmlHttp.status;
                        if(httpState == 200) {
                            //获取服务端返回的字符串
                            var result = xmlHttp.responseText;

                            var div = document.querySelector("#result");
                            if(result == "可以使用") {
                                div.innerText == "可以使用";
                            } else {
                                div.innerText == "不能使用";
                            }
                        } else {
                            alert("服务器错误" + httpState);
                        }
                    }
                };
                //4.发送请求
                xmlHttp.send("name :" + name);
            }

        })();

    </script>
</body>
</html>
