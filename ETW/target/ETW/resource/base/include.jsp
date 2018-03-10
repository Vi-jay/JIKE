<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adamvijay
  Date: 2018/3/5
  Time: 下午5:19
  To change this template use File | Settings | File Templates.
--%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
<script src="${path}/resource/js/vue.js"></script>
<script src="${path}/resource/js/axios.js"></script>
<link rel="stylesheet" href="${path}/resource/css/reset.css">
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<!-- 引入组件库 -->
<script src="${path}/resource/js/elementUI.js"></script>
<script src="${path}/resource/js/utils.js"></script>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

<script>
    var sy = sy || {};
    sy.contextPath = '${path}';
    sy.basePath = '${pageContext.request.scheme}' + "://" + '${pageContext.request.serverName}' + ":" + "${pageContext.request.serverPort}" + "${pageContext.request.contextPath}" + "/";
    function setIframeHeight(iframe) {
        if (iframe) {
            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
            if (iframeWin.document.body) {
                iframe.height = iframeWin.document.documentElement.offsetHeight || iframeWin.document.body.offsetHeight;
            }
        }
    };
    // window.onload = function () {
    //     setIframeHeight(document.getElementById('ueditorContent'));
    // };
</script>

