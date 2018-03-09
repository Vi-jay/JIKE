require.config({
    paths: {
        "routerConfig": "lib/routerConfig",
        "vue-router": "../vue-router",
        ZeroClipboard: "../../../ueditor/third-party/zeroclipboard/ZeroClipboard.min"//主要是加这句话

    }
});
require(['routerConfig', 'ZeroClipboard'], function (router, ZeroClipboard) {
    window['ZeroClipboard'] = ZeroClipboard;
    new Vue({
        router: router,
        el: "#app",
        data: {
            loading: false,
            //tabs
            editableTabsValue: 0,
            editableTabs: [],
            tabIndex: 2,
            isCollapse: true,
            leftDefaultOpen: [1],
            //    弹窗
            dialogVisible: false,
            leftActive: '1-1',
            isEditPage: false,
            leftToggle: true

        },
        created: function () {
            this.$nextTick(function () {
                document.querySelector("html").style.display = "";
            })
        },
        watch: {
            editableTabs: 'setUpEditor'
        },
        methods: {
            setUpEditor: function () {

                var that = this;
                setTimeout(function () {
                    setTimeout(function () {
                        var index = that.editableTabs.length - 1;
                        var domID = 'editor-' + that.editableTabs[index].timeStemp;
                        var ue = UE.getEditor(domID, {
                            allowDivTransToP: false,
                            zIndex:80
                        });
                        that.editableTabs[index].ue = ue;
                        ue.ready(function () {
                            ue.execCommand('cleardoc');
                            ue.execCommand("insertHtml", that.editableTabs[index].content);
                            that.leftToggle = false;
                        })
                    });
                });
            },
            topHandleSelect: function (key, keyPath) {
                switch (key) {
                    case "leftToggle":
                        this.leftToggle = !this.leftToggle;
                        break;
                    case "save":
                        this.checkSave();
                        break;
                }
            },
            checkSave: function () {
                if(this.editableTabs.length){
                this.dialogVisible = true;}else {
                    this.$message({
                        message:"请先打开编辑页面!",
                        type:"error"
                    })
                }
            },
            saveDoc: function () {
                this.dialogVisible = false;
                var that = this;
                var page = this.editableTabs.find(function (val) {
                    return val.name === that.editableTabsValue;
                });
                this.loading = true;

                axios.post(sy.basePath + 'editor/updatePage', {
                    page: page.ue.getAllHtml(),
                    id: page.id
                }).then(function (res) {
                    console.log(res.data.code);
                    if (+res.data.code === 200) {
                        that.$message({
                            message: '上传成功!',
                            type: 'success'
                        });
                    }
                    that.loading = false;
                }).catch(function (reason) {
                    that.$message({
                        message: '上传失败!',
                        type: 'error'
                    });
                    that.loading = false;
                })
            },
            mainModuleTap: function (tag) {
                switch (tag) {

                    case "case":
                        this.showCasePage();
                        break;
                    case "report":
                        this.showReportPage();
                        break;
                    default:
                        break;
                }
                if (tag !== "save") this.isEditPage = false;

            },
            showCasePage: function () {
                this.$router.push("/casePage");
            },showReportPage: function () {
                this.$router.push("/reportPage");
            },
            editPageModuleTap: function (path) {
                var that = this;
                this.loading = true;
                that.isEditPage = true;
                axios.get(sy.basePath + "editor/getHtml", {
                    params: {
                        pagedompath: path
                    }
                }).then(function (res) {
                    that.loading = false;
                    console.log(res.data);
                    var newTabName = ++that.tabIndex + '';
                    var tabConfig = {
                        title: res.data.pagename,
                        name: newTabName,
                        id: res.data.id,
                        timeStemp: Date.now(),
                        content: res.data.page
                    };
                    that.editableTabsValue = newTabName;
                    that.addTab(tabConfig);
                })

            },
            leftHandleSelect: function (key, keyPath) {
                var that = this;
                var lastIndex = keyPath.length - 1;
                that.leftActive = keyPath[lastIndex];
                var path = keyPath[lastIndex].replace(keyPath[0] + "-", "");
                if (keyPath.length === 1) {
                    that.mainModuleTap(keyPath[0]);
                } else {
                    that.editPageModuleTap(path);
                }

            },
            addTab: function (tabConfig) {
                this.editableTabs.push(tabConfig)

            },
            removeTab: function (targetName) {
                var tabs = this.editableTabs;
                var activeName = this.editableTabsValue;
                if (activeName === targetName) {
                    tabs.forEach(function (tab, index) {
                        if (tab.name === targetName) {
                            var nextTab = tabs[index + 1] || tabs[index - 1];
                            if (nextTab) {
                                activeName = nextTab.name;
                            }
                        }
                    });
                }

                this.editableTabsValue = activeName;
                this.editableTabs = tabs.filter(function (tab) {

                    return tab.name !== targetName
                });
            }
        }
    })
});
