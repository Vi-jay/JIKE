package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/resource/base/include.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE8\" content=\"ie=edge\"/>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/vue.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/axios.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/css/reset.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://unpkg.com/element-ui/lib/theme-chalk/index.css\">\r\n");
      out.write("<!-- 引入组件库 -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/elementUI.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/utils.js\"></script>\r\n");
      out.write("<script src=\"http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    var sy = sy || {};\r\n");
      out.write("    sy.contextPath = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("    sy.basePath = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.scheme}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("' + \"://\" + '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.serverName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("' + \":\" + \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.serverPort}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" + \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" + \"/\";\r\n");
      out.write("    function setIframeHeight(iframe) {\r\n");
      out.write("        if (iframe) {\r\n");
      out.write("            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;\r\n");
      out.write("            if (iframeWin.document.body) {\r\n");
      out.write("                iframe.height = iframeWin.document.documentElement.offsetHeight || iframeWin.document.body.offsetHeight;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    };\r\n");
      out.write("    // window.onload = function () {\r\n");
      out.write("    //     setIframeHeight(document.getElementById('ueditorContent'));\r\n");
      out.write("    // };\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/css/index.css\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>即客</title>\r\n");
      out.write("    <meta name=\"google-site-verification\" content=\"-RGsXxaAGFj240rFqfIf5c2mM_xerlDAomt32m3tPTI\">\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/css/index_files/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/css/index_files/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/css/index_files/custom.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        .qimo8 {\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("            width: 80%;\r\n");
      out.write("            float: left;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .qimo8 .qimo { /*width:99999999px;*/\r\n");
      out.write("            width: 8000%;\r\n");
      out.write("            height: 25px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .qimo8 .qimo div {\r\n");
      out.write("            float: left;\r\n");
      out.write("            margin-right: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        ul.list-unstyled li .spe_fir {\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            float: left;\r\n");
      out.write("            margin-right: 5px;\r\n");
      out.write("            font-size: 18px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<!--[if lt IE 8]>\r\n");
      out.write("<p class=\"alert alert-warning\">浏览器版本过低 您还在用十年前的浏览器！建议赶快升级您的IE浏览器版本或使用Chrome或火狐或Safari等高级浏览器</p>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-lg-12\">\r\n");
      out.write("                <nav class=\"navbar navbar-default\">\r\n");
      out.write("                    <div class=\"container-fluid\">\r\n");
      out.write("                        <div class=\"navbar-header\">\r\n");
      out.write("                            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\"\r\n");
      out.write("                                    data-target=\"#topmenu\" aria-expanded=\"false\">\r\n");
      out.write("                                <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                                <span class=\"icon-bar\"></span>\r\n");
      out.write("                                <span class=\"icon-bar\"></span>\r\n");
      out.write("                                <span class=\"icon-bar\"></span>\r\n");
      out.write("                            </button>\r\n");
      out.write("                            <a class=\"navbar-brand\" href=\"#\" title=\"ETW International USA, marketing solutions\"><img\r\n");
      out.write("                                    class=\"img-responsive\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/css/index_files/etw-logo-white.png\"\r\n");
      out.write("                                    width=\"178\" height=\"61\" alt=\"ETW International USA, marketing solutions\"></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"collapse navbar-collapse\" id=\"topmenu\">\r\n");
      out.write("                            <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                                <li><a href=\"#\">推新闻链接</a></li>\r\n");
      out.write("                                <li><a href=\"#\">推新闻链接</a></li>\r\n");
      out.write("                                <li>产品简解：\r\n");
      out.write("                                    <a  href=\"#\">基于云数据，为零售业提供营销、管理的SAAS</a>\r\n");
      out.write("                                    ，\r\n");
      out.write("                                    <a  href=\"#\">基于云数据，为零售业提供营销、管理的SAAS</a></li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</header>\r\n");
      out.write("<main>\r\n");
      out.write("    <div class=\"news-area-01\">\r\n");
      out.write("        <div class=\"video-wrap\">\r\n");
      out.write("            <video autoplay=\"\" muted=\"true\">\r\n");
      out.write("                <source src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/video/background.mp4\">\r\n");
      out.write("            </video>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"news-area-inner-wrap\">\r\n");
      out.write("            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/css/index_files/etwservice-header-area_etw-nochinese.png\" alt=\"\" class=\"img-responsive\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"news-area\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"col-md-5\">\r\n");
      out.write("                <div class=\"clearfix news-block\">\r\n");
      out.write("                    <div class=\"col-sm-5 col-xs-6\">\r\n");
      out.write("                        <a href=\"#\" ><img class=\"img-responsive\"\r\n");
      out.write("                                                         src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/css/index_files/1126-01.jpg\"\r\n");
      out.write("                                                         alt=\"\"><span>推新闻链接</span></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-sm-5 col-xs-6\">\r\n");
      out.write("                        <a href=\"#\" target=\"_blankf\"><img class=\"img-responsive\"\r\n");
      out.write("                                                          src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/css/index_files/2015080414160563201.jpg\"\r\n");
      out.write("                                                          alt=\"\"><span>推新闻链接</span></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-md-7 etw-top-wenzi\">\r\n");
      out.write("                <div class=\"clearfix news-block\">\r\n");
      out.write("                    <div class=\"col-sm-12\">\r\n");
      out.write("                        <ul class=\"list-unstyled topmenu\">\r\n");
      out.write("\r\n");
      out.write("                            <li><span class=\"etw-zidaxiao\">产品简解：<a href=\"#\"\r\n");
      out.write("                                                                   >基于云数据,为零售业提供营销、管理的SAAS</a></span>\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <!--  <div class=\"btn_pulse spe_fir\">特别通知：</div>\r\n");
      out.write("           <div id=\"demo\" class=\"qimo8\">\r\n");
      out.write("             <div class=\"qimo\">\r\n");
      out.write("               <div id=\"demo1\">\r\n");
      out.write("                 <a href=\"#\"  class=\"btn_pulse\">\r\n");
      out.write("           由于ETW不断发展壮大，原来使用9年的办公室（碧波路912弄）已不能满足公司人员数量的需求，现搬迁至原上海盛大游戏办公大楼，地址：上海市张江高科技园区碧波路690号1号楼4幢2层。\r\n");
      out.write("           </a>\r\n");
      out.write("               </div>\r\n");
      out.write("               <div id=\"demo2\">\r\n");
      out.write("                 <a href=\"#\"  class=\"btn_pulse\">\r\n");
      out.write("           由于ETW不断发展壮大，原来使用9年的办公室（碧波路912弄）已不能满足公司人员数量的需求，现搬迁至原上海盛大游戏办公大楼，地址：上海市张江高科技园区碧波路690号1号楼4幢2层。\r\n");
      out.write("           </a>\r\n");
      out.write("               </div>\r\n");
      out.write("             </div>\r\n");
      out.write("           </div> -->\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"etw-sections-wrap\">\r\n");
      out.write("                <div class=\"col-md-9\">\r\n");
      out.write("                    <div class=\"col-md-12 firsttitle clearfix\">\r\n");
      out.write("                        <div class=\"col-sm-12 col-md-5\">\r\n");
      out.write("                            <h4>信息覆盖下的空间就是市场</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- <div class=\"col-sm-12 col-md-7\">\r\n");
      out.write("                         <div id=\"cloudtv-bauma\">\r\n");
      out.write("                         <a href=\"#\"  class=\"newyear-btn my-cart-b etwcompanyvideo\">ETW 2018</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        </div> -->\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("                        <ul class=\"clearfix list-unstyled etw-sections\">\r\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client/case\"  title=\"\"><span class=\"icon\"><i\r\n");
      out.write("                                    class=\"fa fa-thumbs-o-up\"></i></span><span class=\"link-info\">客户效果验证</span></a></li>\r\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client/page/talking\"  title=\"\"><span class=\"icon\"><i class=\"fa fa-eye\"></i></span><span\r\n");
      out.write("                                    class=\"link-info\">即客视角</span></a></li>\r\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client/page/cloud\"  title=\"\"><span class=\"icon\"><i\r\n");
      out.write("                                    class=\"fa fa-cloud\"></i></span><span class=\"link-info\">即客云系统构造</span></a></li>\r\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client/page/marketing\"  title=\"\"><span class=\"icon\"><i\r\n");
      out.write("                                    class=\"fa fa-cubes\"></i></span><span class=\"link-info\">产品介绍</span></a></li>\r\n");
      out.write("                            <li><a class=\"tvwrap\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client/page/cloudTV\"  title=\"\"><span class=\"icon\"><span\r\n");
      out.write("                                    class=\"etwtv\"></span></span><span class=\"link-info\">即客云电视</span></a></li>\r\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client/page/thsetlayerSelf\"  title=\"\"><span class=\"icon\"><i\r\n");
      out.write("                                    class=\"fa fa-globe\"></i></span><span class=\"link-info\">选择即客理由</span></a></li>\r\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client/page/marketAnalysis\"  title=\"\"><span class=\"icon\"><i class=\"fa fa-bar-chart\"></i></span><span\r\n");
      out.write("                                    class=\"link-info\">市场分析</span></a></li>\r\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client/page/networkLayout\"  title=\"\"><span class=\"icon\"><i\r\n");
      out.write("                                    class=\"fa fa-certificate\"></i></span><span class=\"link-info\">网络布局</span></a></li>\r\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client/page/sevensetlayerSelf\"  title=\"\"><span class=\"icon\"><i class=\"fa fa-user-plus\"></i></span><span\r\n");
      out.write("                                    class=\"link-info\">关于即客</span></a></li>\r\n");
      out.write("                            <li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/client/report\"  title=\"\"><span class=\"icon\"><i\r\n");
      out.write("                                    class=\"fa fa-newspaper-o\"></i></span><span class=\"link-info\">公司动态</span></a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <p class=\"ads-info text-center\">即客所做的一切都能被证明，不能被证明的事物可以定义为假！</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-3\">\r\n");
      out.write("                <div class=\"info-panel\">\r\n");
      out.write("                    <div class=\"visit-info\">\r\n");
      out.write("                        <h4>即客大数据实况<span><a  href=\"#\">(点击查看)</a></span></h4>\r\n");
      out.write("                        <div class=\"visit-info-wrap\">\r\n");
      out.write("                            <div class=\"x_content\">\r\n");
      out.write("                                <table>\r\n");
      out.write("\r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>\r\n");
      out.write("                                            <table>\r\n");
      out.write("                                                <tbody>\r\n");
      out.write("                                                <tr>\r\n");
      out.write("                                                    <td>\r\n");
      out.write("                                                        <p><i class=\"fa fa-users\"></i>全球参与分享人数： <span id=\"renshu\"\r\n");
      out.write("                                                                                                      class=\"visitor_two visitor_two_01\">45,691,437</span>\r\n");
      out.write("                                                        </p>\r\n");
      out.write("                                                    </td>\r\n");
      out.write("\r\n");
      out.write("                                                </tr>\r\n");
      out.write("                                                <tr>\r\n");
      out.write("                                                    <td>\r\n");
      out.write("                                                        <p><i class=\"fa fa-signal\"></i>全球领取卡券人数： <span id=\"cishu\"\r\n");
      out.write("                                                                                                       class=\"visitor_two\">228,457,188</span>\r\n");
      out.write("                                                        </p>\r\n");
      out.write("                                                    </td>\r\n");
      out.write("                                                </tr>\r\n");
      out.write("                                                <tr>\r\n");
      out.write("                                                    <td>\r\n");
      out.write("                                                        <p><i class=\"fa fa-user\"></i>全球核销卡券人数：<span id=\"avg\"\r\n");
      out.write("                                                                                                    class=\"visitor_two visitor_two_02\">5.00</span>次\r\n");
      out.write("                                                        </p>\r\n");
      out.write("                                                    </td>\r\n");
      out.write("                                                </tr>\r\n");
      out.write("                                                <tr>\r\n");
      out.write("                                                    <td>\r\n");
      out.write("                                                        <p class=\"red\">结论：每一个参与到产品中的人都是利益共同体</p>\r\n");
      out.write("                                                    </td>\r\n");
      out.write("                                                </tr>\r\n");
      out.write("\r\n");
      out.write("                                                </tbody>\r\n");
      out.write("                                            </table>\r\n");
      out.write("                                        </td>\r\n");
      out.write("\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    </tbody>\r\n");
      out.write("                                </table>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"login-panel\">\r\n");
      out.write("                        <h4>商户/代理商登录</h4>\r\n");
      out.write("                        <div class=\"login-form-wrap\">\r\n");
      out.write("                            <form class=\"form-horizontal\">\r\n");
      out.write("                                <div class=\"logininfo\">\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label class=\"col-sm-2 col-md-4 control-label\">用户名</label>\r\n");
      out.write("                                        <div class=\"col-sm-8\">\r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\"\r\n");
      out.write("                                                   placeholder=\"用户名\" required=\"\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label class=\"col-sm-2 col-md-4 control-label\">密　码</label>\r\n");
      out.write("                                        <div class=\"col-sm-8\">\r\n");
      out.write("                                            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\"\r\n");
      out.write("                                                   placeholder=\"密码\" required=\"\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <div class=\"col-sm-offset-2 col-md-offset-4 col-sm-8\">\r\n");
      out.write("                                            <input type=\"button\" class=\"btn btn-default btnlogininfo\" value=\"登录\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("\r\n");
      out.write("                            <form class=\"form-horizontal\">\r\n");
      out.write("                                <div class=\"logincode\" style=\"display:none;\">\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label class=\"col-sm-2 col-md-4 control-label\">手机号码</label>\r\n");
      out.write("                                        <div class=\"col-sm-8\">\r\n");
      out.write("                                            <input type=\"text\"\r\n");
      out.write("                                                   style=\"width:90px; float:left;padding:6px; font-size:12px;\"\r\n");
      out.write("                                                   class=\"form-control\" id=\"tel\" name=\"tel\" placeholder=\"手机号码\"\r\n");
      out.write("                                                   readonly=\"\"><span class=\"btn btn-default btntelsend\"\r\n");
      out.write("                                                                     style=\"padding:6px 5px;\">发送</span>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label class=\"col-sm-2 col-md-4 control-label\">验证码</label>\r\n");
      out.write("                                        <div class=\"col-sm-8\">\r\n");
      out.write("                                            <input type=\"text\" style=\"width:70px; float:left;font-size:12px;\"\r\n");
      out.write("                                                   class=\"form-control\" id=\"code\" name=\"code\" placeholder=\"验证码\"\r\n");
      out.write("                                                   required=\"\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <div class=\"col-sm-offset-4 col-sm-8\">\r\n");
      out.write("                                            <input type=\"button\" class=\"btn btn-default btnlogincode\" value=\"登录\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("\r\n");
      out.write("                            <span class=\"visitor_two logintips etw-service-call\"></span>\r\n");
      out.write("                            <div class=\"etw-service-call\"><i class=\"fa fa-phone\"> </i> 客服直线：400-100-6660</div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</main>\r\n");
      out.write("<footer>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"col-lg-12\">\r\n");
      out.write("            <a href=\"#\" >联系我们</a>\r\n");
      out.write("\r\n");
      out.write("            <span class=\"copyright\">中悦相关信息</span>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("path");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}
