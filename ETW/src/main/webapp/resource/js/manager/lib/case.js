"use strict";

define(function () {
    var page = {
        template: "<div id=\"case-app\"     v-loading=\"loading\">\n<aside class=\"case-top-side\">\n<el-button type=\"primary\" icon=\"el-icon-circle-plus-outline\" @click=\"addCase\">\u6DFB\u52A0\u8BB0\u5F55</el-button>\n<el-button type=\"warning\" icon=\"el-icon-delete\" @click=\"deleteSelections\">\u5220\u9664\u9009\u4E2D</el-button>\n</aside>\n<el-table\nref=\"multipleTable\"\n    tooltip-effect=\"dark\"\n    :data=\"tableData\"\n    border\n    @selection-change=\"selection=>dataSelection=selection\"\n    :max-height=\"maxTableHeight\"\n    style=\"width: 100%;min-height: 70%;\">\n    <el-table-column \n      type=\"selection\"\n      width=\"55\">\n    </el-table-column>\n    <el-table-column\n      prop=\"name\"\n      label=\"\u540D\u79F0\" \n      width=\"280\">\n    </el-table-column>\n    \n    <el-table-column\n      prop=\"link\"\n      label=\"\u7F51\u9875\u94FE\u63A5\"\n      width=\"280\">\n    </el-table-column>\n    \n    <el-table-column\n      prop=\"icon\"\n      label=\"\u56FE\u6807\u94FE\u63A5\"\n      width=\"300\"\n      >\n    </el-table-column>\n    <el-table-column\n      prop=\"desc\"\n      label=\"\u63CF\u8FF0\u4FE1\u606F\"\n     width=\"300\"\n      >\n    </el-table-column>\n    <el-table-column\n      label=\"\u64CD\u4F5C\"\n      fixed=\"right\"\n      width=\"100\">\n      <template slot-scope=\"scope\">\n        <el-button @click=\"checkRow(scope.row,scope.$index)\" type=\"text\" size=\"small\">\u67E5\u770B</el-button>\n        <el-button @click=\"editRow(scope.row,scope.$index)\" type=\"text\" size=\"small\">\u7F16\u8F91</el-button>\n      </template>\n    </el-table-column>\n  </el-table>\n  <el-pagination\n      @current-change=\"changePageIndex\"\n      :current-page=\"currentPage\"\n      :page-sizes=\"[10, 20, 30, 40]\"\n      :page-size=\"pageSize\"\n      @size-change = \"changePageSize\"\n      style=\"text-align: center;margin-top: 20px\"\n      layout=\"total, sizes, prev, pager, next, jumper\"\n      :total=\"totalData\">\n    </el-pagination>\n    <!--\u67E5\u770B\u884C\u5F39\u7A97-->\n    <el-dialog\n  title=\"\u67E5 \u770B\"\n  :visible.sync=\"checkRowDialogVisible\"\n  width=\"30%\"\n  center>\n  <div class=\"case-app-content\">\n  <a :href=\"currentSelectRow.link\">\n                        <img :src=\"currentSelectRow.icon\" alt=\"\u5E7F\u4E1C\u5927\u65CF\u7CA4\u94ED\u96C6\u56E2\u80A1\u4EFD\u6709\u9650\u516C\u53F8\" class=\"card-icon\">\n                        </a> \n                        <p>\n  <a :href=\"currentSelectRow.link\" class=\"card-link\">{{currentSelectRow.name}}</a>\n                        <p class=\"card-desc\" v-html=\"markedNumberRed(currentSelectRow.desc)\"></p>\n                       </p>\n</div>\n  <span slot=\"footer\" class=\"dialog-footer\">\n    <el-button type=\"primary\" @click=\"checkRowDialogVisible = false\">\u786E \u5B9A</el-button>\n  </span>\n</el-dialog>\n\n\n\n<!--\u7F16\u8F91\u884C\u5F39\u7A97-->\n    <el-dialog\n  :title=\"isEditState?'\u7F16 \u8F91':'\u6DFB \u52A0'\"\n  :visible.sync=\"editRowDialogVisible\"\n  width=\"30%\"\n  center>\n  <div class=\"case-app-content\">\n  <el-form ref=\"form\" :model=\"dialogForm\" label-width=\"80px\">\n  <el-form-item label=\"\u516C\u53F8\u540D\u79F0\">\n    <el-input v-model=\"dialogForm.name\"></el-input>\n  </el-form-item>\n  <el-form-item label=\"\u516C\u53F8\u7F51\u5740\">\n    <el-input v-model=\"dialogForm.link\"></el-input>\n  </el-form-item>\n  <el-form-item label=\"\u6848\u4F8B\u63CF\u8FF0\">\n    <el-input v-model=\"dialogForm.desc\"></el-input>\n  </el-form-item>\n  <el-form-item label=\"\u516C\u53F8\u56FE\u6807\">\n    <el-input v-model=\"dialogForm.icon\"></el-input>\n  </el-form-item>\n  \n   \n</el-form>\n</div>\n  <span slot=\"footer\" class=\"dialog-footer\">\n    <el-button  @click=\"editRowDialogVisible = false\">\u53D6 \u6D88</el-button>\n    <el-button type=\"primary\" @click=\"isEditState?submitEditCase():submitAddCase()\">\u786E \u5B9A</el-button>\n  </span>\n</el-dialog>\n\n  </div>",
        created: function created() {
            this.searchTableData(this.pageSize, this.currentPage);
        },
        methods: {
            searchTableData: function searchTableData(pageSize, pageNum) {
                var _this = this;

                this.loading = true;
                axios.post(sy.basePath + "client/listCases", {
                    "pageNum": pageNum,
                    "pageSize": pageSize
                }).then(function (res) {
                    _this.tableData = res.data.rows;
                    _this.totalData = res.data.total;
                    _this.loading = false;
                }).catch(function (reson) {
                    console.error(reson);
                    _this.loading = false;
                });
            },
            changePageSize: function changePageSize(size) {
                this.pageSize = size;
                this.searchTableData(this.pageSize, this.currentPage);
            },
            changePageIndex: function changePageIndex(pageNum) {
                this.currentPage = pageNum;
                this.searchTableData(this.pageSize, this.currentPage);
            },
            addCase: function addCase() {
                this.editRowDialogVisible = true;
                this.isEditState = false;
                this.dialogForm = {
                    name: "",
                    link: "",
                    icon: "",
                    desc: ""
                };
            },
            editRow: function editRow(row, index) {
                this.checkOrEditIndex = index;
                this.editRowDialogVisible = true;
                this.dialogForm = JSON.parse(JSON.stringify(this.currentSelectRow));
                this.isEditState = true;
            },
            checkRow: function checkRow(row, index) {
                this.checkRowDialogVisible = true;
                this.checkOrEditIndex = index;
            },
            submitEditCase: function submitEditCase() {
                var _this2 = this;

                this.loading = true;
                axios.post(sy.basePath + "client/updateCase", this.dialogForm).then(function (res) {
                    if (+res.data.code === 200) {
                        _this2.$message({
                            message: "修改成功!",
                            type: "success"
                        });
                        _this2.searchTableData(_this2.pageSize, _this2.currentPage);
                    }
                    _this2.loading = false;
                }).catch(function (_) {
                    return _this2.loading = false;
                });
                this.editRowDialogVisible = false;
            },
            submitAddCase: function submitAddCase() {
                var _this3 = this;

                this.loading = true;
                axios.post(sy.basePath + "client/addCase", this.dialogForm).then(function (res) {
                    if (+res.data.code === 200) {
                        _this3.$message({
                            message: "添加成功!",
                            type: "success"
                        });
                        _this3.searchTableData(_this3.pageSize, _this3.currentPage);
                    }
                    _this3.loading = false;
                }).catch(function (_) {
                    return _this3.loading = false;
                });
                this.editRowDialogVisible = false;
            },
            deleteSelections: function deleteSelections() {
                var _this4 = this;

                this.loading = true;
                axios.post(sy.basePath + "client/deleteCases", this.dataSelection).then(function (res) {
                    if (+res.data.code === 200) {
                        _this4.$message({
                            message: "删除成功!",
                            type: "success"
                        });
                        _this4.searchTableData(_this4.pageSize, _this4.currentPage);
                    }
                    _this4.loading = false;
                }).catch(function (_) {
                    return _this4.loading = false;
                });
            },
            markedNumberRed: function markedNumberRed(str) {
                if (!str) return;
                var arr = [];
                for (var i = 0, len = str.length; i < len; i++) {
                    var char = parseInt(str[i]);

                    if (!isNaN(char)) {
                        //    数字
                        if (i > 0 && !isNaN(parseInt(str[i - 1]))) {
                            arr[arr.length - 1] = arr[arr.length - 1] + "" + char;
                        } else {
                            arr.push(char);
                        }
                    }
                }
                arr.forEach(function (num) {
                    str = str.replace(num + "", "<em class='mark-red'>" + num + "</em>");
                });
                return str;
            }
        },

        data: function data() {
            return {
                dialogForm: {
                    name: "",
                    link: "",
                    icon: "",
                    desc: ""
                },
                isEditState: false,
                dataSelection: [],
                loading: false,
                totalData: 0,
                pageSize: 10,
                currentPage: 1,
                tableData: [],
                checkOrEditIndex: 0,
                checkRowDialogVisible: false,
                editRowDialogVisible: false
            };
        },

        computed: {
            maxTableHeight: function maxTableHeight() {
                var cptdHeight = window.innerHeight * 0.7;
                return cptdHeight > 400 ? cptdHeight : 500;
            },
            currentSelectRow: function currentSelectRow() {
                var row = this.tableData[this.checkOrEditIndex];
                return row || {};
            }
        }
    };
    return page;
});
