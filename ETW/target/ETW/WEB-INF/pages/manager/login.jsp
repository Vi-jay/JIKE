<%--
  Created by IntelliJ IDEA.
  User: adamvijay
  Date: 2018/3/5
  Time: 下午1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/resource/base/include.jsp" %>
    <link rel="stylesheet" href="${path}/resource/css/manager/login.css">
</head>
<body>
<div id="app">
    <div class="login">
        <h2 class="title">Login To JIKE</h2>
        <div class="content">
            <form action="${path}/manager/login" method="post">
                <div class="container">
                    <input class="input" name="username" id="txtFirstName" type="text" placeholder="Account:">
                    <span class="border"></span>
                </div>
                <br/>
                <div class="container">
                    <input class="input" name="password" id="txtLastName" type="password" placeholder="Password:">
                    <span class="border"></span>
                </div>
                <aside class="checkbox-wrap">
                    <label class="rmb-checkbox"><input class="checkbox"   type="radio" name="remember"><em
                            class="legend">Remember me</em></label>
                </aside>

                <c:if test="${message_login != null}">
                    <p class="error-message">${message_login}</p>
                </c:if>
                <button type="submit" class="submit-btn">Sign In</button>
            </form>
        </div>
    </div>
</div>
<script>
    new Vue({
        el: "#app",
        data: {
            message: "${message_login}" || "hello"
        }
    })
</script>

</body>
</html>
