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
    <title>公司动态</title>
    <link href="${path}/resource/css/index_files/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/resource/css/index_files/font-awesome.min.css" rel="stylesheet">
    <link href="${path}/resource/css/case/responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/resource/css/case/case.css">
    <script src="${path}/resource/js/bootstrap.min.js"></script>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<style>
    #etw_topmenu .top-container-title {
        color: #fff;
        float: left;
        line-height: 35px;
        margin-left: 3px;
    }
</style>
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
                            <a class="navbar-brand" href="https://www.即客service.com/"><img
                                    src="${path}/resource/css/index_files/etw-logo-white.png" alt=""></a>
                        </div>
                        <div class="navbar-collapse collapse" id="topmenu" aria-expanded="false" style="height: 1px;">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="https://www.即客service.com/">即客首页</a></li>
                                <li><a href="https://www.即客service.com/marketing.html">即客产品介绍</a></li>
                                <li><a href="https://www.即客service.com/sevensetlayer_self.htm">关于即客</a></li>
                                <li><a href="https://www.即客service.com/ninesetlayer_self.htm">联系即客</a></li>
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
                <li><em class="top-container-title">我们用图像与声音记录历史， 把历史“碎片”变成一个公司历史文献， 献给那些逝去的岁月！</em></li>
            </ul>

        </div>
    </div>
</header>

<div class="clear">
</div>

<div class="content-wrapper" style="min-height: 100%;width: 100%;padding: 150px 0 15% 15%">
    <div class="col-sm-3">
        <div class="left">
            <div class="leftbar">
                <div id="news_icon"><a class="vdq" href="/etwspeak/report.html">公司快讯</a></div>
                <div id="etw_report_left" style="overflow: hidden; outline: none;" tabindex="5000">
                    <ul>
                        <c:forEach items="${reportList}" var="report">
                            <li><a href="#${report.id}">${reportTimes.get(report.id)}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div id="ascrail2000" class="nicescroll-rails"
                 style="width: 7px; z-index: auto; cursor: default; position: absolute; top: 106px; left: 175px; height: 280px; opacity: 0.5;">
                <div style="position: relative; top: 8px; float: right; width: 5px; height: 32px; background-color: rgb(0, 180, 255); border: 1px solid rgb(255, 255, 255); background-clip: padding-box; border-radius: 5px;"></div>
            </div>
            <div id="ascrail2000-hr" class="nicescroll-rails"
                 style="height: 7px; z-index: auto; top: 379px; left: 0px; position: absolute; cursor: default; display: none; width: 175px; opacity: 0.5;">
                <div style="position: relative; top: 0px; height: 5px; width: 182px; background-color: rgb(0, 180, 255); border: 1px solid rgb(255, 255, 255); background-clip: padding-box; border-radius: 5px;"></div>
            </div>
        </div>
    </div>
    <div class="col-sm-7">
        <div class="import-news-content">
            <h2 class="import-news"><em class="btn-left">重要新闻</em></h2>
            <%--重要新闻--%>
            <ul>
                <c:forEach items="${reportList}" var="report">
                    <c:if test="${report.state == 1}">
                        <li class="alletwnew" style="min-height: 150px">
                            <div class="published-date"><a id="${report.id}"></a>${reportTimes.get(report.id)}</div>
                            <div class="etw_question_con">
                                <iframe src="${path}/client/report/${report.id}" class="report-iframe"
                                        style="width: 100%;" frameborder="0"></iframe>
                            </div>
                        </li>
                    </c:if>
                </c:forEach>

            </ul>

            <h2 class="import-news-title">随时动态新闻</h2>
            <%--随时--%>
            <ul>
                <c:forEach items="${reportList}" var="report">
                    <c:if test="${report.state == 0}">
                        <li class="alletwnew" style="min-height: 150px">
                            <div class="published-date"><a id="${report.id}"></a>${reportTimes.get(report.id)}</div>
                            <div class="etw_question_con">
                                <iframe class="report-iframe" src="${path}/client/report/${report.id}"
                                        style="width: 100%;" frameborder="0"></iframe>
                            </div>
                        </li>
                    </c:if>
                </c:forEach>

            </ul>
        </div>

    </div>
    <div class="clear">
    </div>
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
                        <li><a  href="#">即客管理</a></li>
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
<script>
    (function () {
        var frames = document.querySelectorAll('.report-iframe');
        frames.forEach(function (el) {
            el.style.display = "none";
        });
        window.onload = function () {
            var frames = document.querySelectorAll('.report-iframe');
            frames.forEach(function (el) {
                setIframeHeight(el);
                el.style.display = "";
            });
        };


        $('#etw_report_left ul li a[href^="#"]').click(function (e) {
            e.preventDefault();
            console.log($(this.hash).offset().top);
            $('html, body').animate({scrollTop: $(this.hash).offset().top-200}, 400);
        });
    })();
</script>
</body>
</html>
