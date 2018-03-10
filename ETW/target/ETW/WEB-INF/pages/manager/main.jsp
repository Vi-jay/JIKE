<%--
  Created by IntelliJ IDEA.
  User: adamvijay
  Date: 2018/3/6
  Time: 下午8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>即客后台管理系统</title>
    <%@ include file="/resource/base/include.jsp" %>
    <script src="${path}/resource/js/require.js" defer async="async"
            data-main="${path}/resource/js/manager/main"></script>
    <link rel="stylesheet" href="${path}/resource/css/manager/main.css">
    <link rel="stylesheet" href="${path}/resource/css/manager/aboutUs.css">
    <style>
        .left-el-menu-vertical:not(.el-menu--collapse) {
            width: 200px;
            min-height: 400px;
        }
    </style>
    <script>
        <%--防止vue客户端渲染导致reflow--%>
        document.querySelector("html").style.display = "none";


    </script>
    <!-- 配置文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor/toolsEx.js"></script>

</head>
<body >
<div id="app">
    <div class="top-menu-pannel">
        <el-menu
                :default-active="'4'"
                class="el-menu-demo"
                mode="horizontal"
                @select="topHandleSelect"
                background-color="#5A626A"
                text-color="#fff"
                active-text-color="#ffd04b">
            <el-menu-item index="layout"><a href="${path}/manager/logout">退出系统</a></el-menu-item>
            <el-menu-item index="1"><a href="${path}" target="_blank">关于我们</a></el-menu-item>
            <el-menu-item index="2" disabled>消息中心</el-menu-item>
            <el-menu-item index="4">处理中心</el-menu-item>
            <el-menu-item index="save">
                <span slot="title"><i class="el-icon-upload"></i>上传当前页</span>
            </el-menu-item>
            <el-menu-item index="leftToggle">{{!leftToggle?'显示':'隐藏'}}侧栏</el-menu-item>
        </el-menu>
    </div>

    <el-collapse-transition>

    <div class="left-menu-pannel" @mouseenter="isCollapse = false"
         @mouseleave="isCollapse = true" v-show="leftToggle">
        <el-menu style="height: 100%"
                 :default-active="leftActive"
                 :default-openeds="leftDefaultOpen"
                 :collapse="isCollapse"
                 class="left-el-menu-vertical"
                 @select="leftHandleSelect"
                 background-color="#545c64"
                 text-color="#fff"
                 :unique-opened="true"
                 active-text-color="#ffd04b">
            <el-submenu index="1">
                <template slot="title">
                    <i class="el-icon-location"></i>
                    <span>页面编辑</span>
                </template>
                <el-menu-item-group>
                    <template slot="title">主页入口</template>
                    <el-menu-item index="1-1">即客视角</el-menu-item>
                    <el-menu-item index="1-2">公司介绍</el-menu-item>
                    <el-menu-item index="1-3">选择即客的理由</el-menu-item>
                    <el-menu-item index="1-4">即客云系统构造</el-menu-item>
                    <el-menu-item index="1-5">即客产品介绍</el-menu-item>
                    <el-menu-item index="1-6">市场分析</el-menu-item>
                    <el-menu-item index="1-7">网络布局</el-menu-item>
                    <el-menu-item index="1-8">联系即客</el-menu-item>
                    <el-menu-item index="1-9">即客云电视</el-menu-item>
                </el-menu-item-group>


            </el-submenu>
            <el-menu-item index="case">
                <i class="el-icon-menu"></i>
                <span slot="title">案例列表</span>
            </el-menu-item>
            <el-menu-item index="report" >
                <i class="el-icon-document"></i>
                <span slot="title">公司资讯动态</span>
            </el-menu-item>
            <el-menu-item index="4" disabled>
                <i class="el-icon-setting"></i>
                <span slot="title">设置</span>
            </el-menu-item>

        </el-menu>
    </div>

    </el-collapse-transition>

    <article style="width: 100% ;height:calc(100% - 65px);margin-top: 61px;">
        <template v-if="!isEditPage">
            <router-view></router-view>
        </template>
        <template v-else>
            <%--tabs--%>
            <el-tabs v-model="editableTabsValue" type="card" closable @tab-remove="removeTab">
                <el-tab-pane
                        v-for="(item, index) in editableTabs"
                        :key="item.name"
                        :label="item.title"
                        :name="item.name"
                        v-loading="loading"
                        element-loading-text="拼命加载中"
                        element-loading-spinner="el-icon-loading"
                >
                    <script :id="'editor-'+item.timeStemp" :name="'content'+index" type="text/plain">
                 请开始你的表演

                    </script>
                </el-tab-pane>
            </el-tabs>
        </template>
    </article>

    <%--dialog--%>
    <el-dialog
            title="提示"
            :visible.sync="dialogVisible"
            width="30%">
        <span>是否确定上传文章?</span>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="saveDoc">确 定</el-button>
  </span>
    </el-dialog>
</div>
</body>
</html>
