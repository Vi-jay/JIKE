define(['lib/case','lib/reportPage', 'lib/aboutUs',"vue-router"], function (casePage,reportPage, aboutUs,VueRouter) {

// 1. 定义（路由）组件。
// 可以从其他文件 import 进来
// 2. 定义路由
// 每个路由应该映射一个组件。 其中"component" 可以是
// 通过 Vue.extend() 创建的组件构造器，
// 或者，只是一个组件配置对象。
// 我们晚点再讨论嵌套路由。

    var routes = [
        // {path: '/casePage/:id', component: casePage,props:true},
        {path: '/casePage', component: casePage},
        {path: '/reportPage', component: reportPage},
        {path: '/', component: aboutUs}
    ];

// 3. 创建 router 实例，然后传 `routes` 配置
// 你还可以传别的配置参数, 不过先这么简单着吧。
    var router = new VueRouter({
        routes: routes // （缩写）相当于 routes: routes
    });
    return router;
});