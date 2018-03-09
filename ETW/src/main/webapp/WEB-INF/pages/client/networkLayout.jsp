<%--
  Created by IntelliJ IDEA.
  User: adamvijay
  Date: 2018/3/8
  Time: 下午12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/resource/base/include.jsp" %>
    <title>公司介绍</title>
    <link href="${path}/resource/css/index_files/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/resource/css/index_files/font-awesome.min.css" rel="stylesheet">
    <link href="${path}/resource/css/case/responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/resource/css/case/case.css">
    <script src="${path}/resource/js/bootstrap.min.js"></script>
</head>
<script>
    window.onload = function () {
        setIframeHeight(document.getElementById('articleContent'));
    };
</script>
<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-lg-offset-1">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                    data-target="#topmenu" aria-expanded="false">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="${path}"><img
                                    src="${path}/resource/css/index_files/etw-logo-white.png" alt=""></a>
                        </div>
                        <div class="navbar-collapse collapse" id="topmenu" aria-expanded="false" style="height: 1px;">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="${path}">即客首页</a></li>
                                <li><a href="${path}/client/page/marketing">即客产品介绍</a></li>
                                <li><a href="${path}/client/page/sevensetlayerSelf">关于即客</a></li>
                                <li><a href="${path}/client/page/concat">联系即客</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <div id="etw_topmenu">
        <div class="container">
            <ul class="etw_submenu">
                <li class="mainsub">关于即客</li>
                <li><a href="${path}/client/page/sevensetlayerSelf">公司介绍</a></li>
                <li><a href="${path}/client/page/thsetlayerSelf">选择即客的理由</a></li>
                <li><a href="${path}/client/page/talking">即客视角</a></li>
                <li><a href="#" class="active">网络布局</a></li>
            </ul>
        </div>
    </div>
</header>

<div class="clear">
</div>

<div id="app" class="article-content-wrapper" v-loading="loading">
    <iframe src="${path}/editor/searchPage/7" frameborder="0" id="articleContent"
            style="width: 100%;overflow:hidden;transform: scale(0.9)"></iframe>
</div>

<footer>
    <div class="footer-wrap">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-3 col-lg-2 col-lg-offset-1"><h4>关于即客</h4>
                    <ul class="list-unstyled toggle-footer" style="">
                        <li><a href="${path}/client/page/sevensetlayerSelf">公司介绍</a></li>
                        <li><a href="${path}/client/page/thsetlayerSelf">选择即客的理由</a></li>
                        <li><a href="${path}/client/page/talking">即客视角</a></li>
                        <li><a href="${path}/client/report">公司动态</a></li>
                        <li><a href="${path}/client/page/marketAnalysis">国际市场分析</a></li>
                        <li><a href="${path}/client/page/networkLayout">网络布局</a></li>
                    </ul>
                </div>
                <div class="col-xs-12 col-sm-3 col-lg-2 col-lg-offset-1"><h4>即客产品介绍</h4>
                    <ul class="list-unstyled toggle-footer" style="">
                        <li><a href="${path}/client/page/sevensetlayerSelf">即客营销</a></li>
                        <li><a href="#">即客管理</a></li>
                        <li><a href="${path}/client/page/cloud">即客云数据</a></li>
                    </ul>
                </div>
                <div class="col-xs-12 col-sm-3 col-lg-2 col-lg-offset-1"><h4>客户相关</h4>
                    <ul class="list-unstyled toggle-footer" style="">
                        <li><a href="${path}/client/page/case">客户效果验证</a></li>
                        <li><a href="#">即客大数据实况</a></li>
                        <li>
                            <a href="#">申请使用即客云SASS系统</a>
                        </li>
                    </ul>
                </div>
                <div class="col-xs-12 col-sm-3 col-lg-2 col-lg-offset-1"><h4>联系即客</h4>
                    <ul class="list-unstyled toggle-footer" style="">
                        <li><a href="#">即客江苏</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="sub-footer-wrap">
        <div class="container">
            <div class="col-lg-12">
                <div id="footeretw">
                    Copyright © 2005 - 中悦相关信息
                </div>
            </div>
        </div>
    </div>
</footer>
<div class="clear">
</div>
<script src="${path}/resource/js/client/main.js"></script>

</body>
</html>
