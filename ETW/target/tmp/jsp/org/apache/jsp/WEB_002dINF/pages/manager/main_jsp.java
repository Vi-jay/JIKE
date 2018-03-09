package org.apache.jsp.WEB_002dINF.pages.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>即客后台管理系统</title>\n");
      out.write("    ");
      out.write('\n');
      out.write('\n');
      out.write('\n');
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE8\" content=\"ie=edge\"/>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/vue.js\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/axios.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/css/reset.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://unpkg.com/element-ui/lib/theme-chalk/index.css\">\n");
      out.write("<!-- 引入组件库 -->\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/elementUI.js\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/utils.js\"></script>\n");
      out.write("<script src=\"http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    var sy = sy || {};\n");
      out.write("    sy.contextPath = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\n");
      out.write("    sy.basePath = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.scheme}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("' + \"://\" + '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.serverName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("' + \":\" + \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.serverPort}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" + \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" + \"/\";\n");
      out.write("    function setIframeHeight(iframe) {\n");
      out.write("        if (iframe) {\n");
      out.write("            var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;\n");
      out.write("            if (iframeWin.document.body) {\n");
      out.write("                iframe.height = iframeWin.document.documentElement.offsetHeight || iframeWin.document.body.offsetHeight;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    };\n");
      out.write("    // window.onload = function () {\n");
      out.write("    //     setIframeHeight(document.getElementById('ueditorContent'));\n");
      out.write("    // };\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/require.js\" defer async=\"async\"\n");
      out.write("            data-main=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/js/manager/main\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${path}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resource/css/manager/main.css\">\n");
      out.write("    <style>\n");
      out.write("        .left-el-menu-vertical:not(.el-menu--collapse) {\n");
      out.write("            width: 200px;\n");
      out.write("            min-height: 400px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <script>\n");
      out.write("        ");
      out.write("\n");
      out.write("        document.querySelector(\"html\").style.display = \"none\";\n");
      out.write("\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("    <!-- 配置文件 -->\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ueditor/ueditor.config.js\"></script>\n");
      out.write("    <!-- 编辑器源码文件 -->\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ueditor/ueditor.all.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ueditor/lang/zh-cn/zh-cn.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/ueditor/toolsEx.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body >\n");
      out.write("<div id=\"app\">\n");
      out.write("    <div class=\"top-menu-pannel\">\n");
      out.write("        <el-menu\n");
      out.write("                :default-active=\"'4'\"\n");
      out.write("                class=\"el-menu-demo\"\n");
      out.write("                mode=\"horizontal\"\n");
      out.write("                @select=\"topHandleSelect\"\n");
      out.write("                background-color=\"#5A626A\"\n");
      out.write("                text-color=\"#fff\"\n");
      out.write("                active-text-color=\"#ffd04b\">\n");
      out.write("            <el-menu-item index=\"5\">退出系统</el-menu-item>\n");
      out.write("            <el-menu-item index=\"4\">处理中心</el-menu-item>\n");
      out.write("            <el-submenu index=\"3\">\n");
      out.write("                <template slot=\"title\">我的工作台</template>\n");
      out.write("                <el-menu-item index=\"2-1\">选项1</el-menu-item>\n");
      out.write("                <el-menu-item index=\"2-2\">选项2</el-menu-item>\n");
      out.write("                <el-menu-item index=\"2-3\">选项3</el-menu-item>\n");
      out.write("            </el-submenu>\n");
      out.write("            <el-menu-item index=\"2\" disabled>消息中心</el-menu-item>\n");
      out.write("            <el-menu-item index=\"1\"><a href=\"https://www.ele.me\" target=\"_blank\">关于我们</a></el-menu-item>\n");
      out.write("            <el-menu-item index=\"leftToggle\">{{!leftToggle?'显示':'隐藏'}}侧栏</el-menu-item>\n");
      out.write("\n");
      out.write("        </el-menu>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <el-collapse-transition>\n");
      out.write("\n");
      out.write("    <div class=\"left-menu-pannel\" @mouseenter=\"isCollapse = false\"\n");
      out.write("         @mouseleave=\"isCollapse = true\" v-show=\"leftToggle\">\n");
      out.write("        <el-menu style=\"height: 100%\"\n");
      out.write("                 :default-active=\"leftActive\"\n");
      out.write("                 :default-openeds=\"leftDefaultOpen\"\n");
      out.write("                 :collapse=\"isCollapse\"\n");
      out.write("                 class=\"left-el-menu-vertical\"\n");
      out.write("                 @select=\"leftHandleSelect\"\n");
      out.write("                 background-color=\"#545c64\"\n");
      out.write("                 text-color=\"#fff\"\n");
      out.write("                 :unique-opened=\"true\"\n");
      out.write("                 active-text-color=\"#ffd04b\">\n");
      out.write("            <el-submenu index=\"1\">\n");
      out.write("                <template slot=\"title\">\n");
      out.write("                    <i class=\"el-icon-location\"></i>\n");
      out.write("                    <span>页面编辑</span>\n");
      out.write("                </template>\n");
      out.write("                <el-menu-item-group>\n");
      out.write("                    <template slot=\"title\">主页入口</template>\n");
      out.write("                    <el-menu-item index=\"1-1\">即客视角</el-menu-item>\n");
      out.write("                    <el-menu-item index=\"1-2\">公司介绍</el-menu-item>\n");
      out.write("                    <el-menu-item index=\"1-3\">选择即客的理由</el-menu-item>\n");
      out.write("                    <el-menu-item index=\"1-4\">即客云系统构造</el-menu-item>\n");
      out.write("                    <el-menu-item index=\"1-5\">即客产品介绍</el-menu-item>\n");
      out.write("                    <el-menu-item index=\"1-6\">市场分析</el-menu-item>\n");
      out.write("                    <el-menu-item index=\"1-7\">网络布局</el-menu-item>\n");
      out.write("                    <el-menu-item index=\"1-8\">联系即客</el-menu-item>\n");
      out.write("                </el-menu-item-group>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </el-submenu>\n");
      out.write("            <el-menu-item index=\"case\">\n");
      out.write("                <i class=\"el-icon-menu\"></i>\n");
      out.write("                <span slot=\"title\">案例列表</span>\n");
      out.write("            </el-menu-item>\n");
      out.write("            <el-menu-item index=\"report\" >\n");
      out.write("                <i class=\"el-icon-document\"></i>\n");
      out.write("                <span slot=\"title\">公司资讯动态</span>\n");
      out.write("            </el-menu-item>\n");
      out.write("            <el-menu-item index=\"4\" disabled>\n");
      out.write("                <i class=\"el-icon-setting\"></i>\n");
      out.write("                <span slot=\"title\">设置</span>\n");
      out.write("            </el-menu-item>\n");
      out.write("            <el-menu-item index=\"save\">\n");
      out.write("                <i class=\"el-icon-upload\"></i>\n");
      out.write("                <span slot=\"title\">保存当前页</span>\n");
      out.write("            </el-menu-item>\n");
      out.write("        </el-menu>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    </el-collapse-transition>\n");
      out.write("\n");
      out.write("    <article style=\"width: 100% ;height:calc(100% - 65px);margin-top: 65px;\">\n");
      out.write("        <template v-if=\"!isEditPage\">\n");
      out.write("            <router-view></router-view>\n");
      out.write("        </template>\n");
      out.write("        <template v-else>\n");
      out.write("            ");
      out.write("\n");
      out.write("            <el-tabs v-model=\"editableTabsValue\" type=\"card\" closable @tab-remove=\"removeTab\">\n");
      out.write("                <el-tab-pane\n");
      out.write("                        v-for=\"(item, index) in editableTabs\"\n");
      out.write("                        :key=\"item.name\"\n");
      out.write("                        :label=\"item.title\"\n");
      out.write("                        :name=\"item.name\"\n");
      out.write("                        v-loading=\"loading\"\n");
      out.write("                >\n");
      out.write("                    <script :id=\"'editor-'+item.timeStemp\" :name=\"'content'+index\" type=\"text/plain\">\n");
      out.write("                 请开始你的表演\n");
      out.write("\n");
      out.write("                    </script>\n");
      out.write("                </el-tab-pane>\n");
      out.write("            </el-tabs>\n");
      out.write("        </template>\n");
      out.write("    </article>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    <el-dialog\n");
      out.write("            title=\"提示\"\n");
      out.write("            :visible.sync=\"dialogVisible\"\n");
      out.write("            width=\"30%\">\n");
      out.write("        <span>是否确定上传文章?</span>\n");
      out.write("        <span slot=\"footer\" class=\"dialog-footer\">\n");
      out.write("    <el-button @click=\"dialogVisible = false\">取 消</el-button>\n");
      out.write("    <el-button type=\"primary\" @click=\"saveDoc\">确 定</el-button>\n");
      out.write("  </span>\n");
      out.write("    </el-dialog>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
