<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adamvijay
  Date: 2018/3/5
  Time: 下午1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/resource/base/include.jsp"></jsp:include>
</head>
<body>
<c:forEach var="user" items="${users}">
    <h3>${user.password}</h3>
</c:forEach>
${currUser}
</body>
</html>
