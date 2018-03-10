'use strict';

define(function () {
    var page = {
        template: '<div id="case-app"     v-loading="loading">\n<aside class="case-top-side">\n<el-button type="primary" icon="el-icon-circle-plus-outline" @click="addReport">\u6DFB\u52A0\u8BB0\u5F55</el-button>\n<el-button type="warning" icon="el-icon-delete" @click="deleteSelections">\u5220\u9664\u9009\u4E2D</el-button>\n</aside>\n<el-table\nref="multipleTable"\n    tooltip-effect="dark"\n    :data="tableData"\n    border\n    @selection-change="selection=>dataSelection=selection"\n    :max-height="maxTableHeight"\n    style="width: 100%;min-height: 70%;">\n    <el-table-column \n      type="selection"\n      width="55">\n    </el-table-column> \n    <el-table-column\n      prop="date"\n      label="\u52A8\u6001\u65F6\u95F4" \n      width="280"\n      :formatter="dateFormatter"\n      >\n    </el-table-column>\n    \n    <el-table-column\n      prop="state"\n      label="\u6027\u8D28"\n      :formatter="stateFormatter"\n      width="280">\n    </el-table-column>\n    \n    <el-table-column\n      prop="reportText"\n      label="\u8D44\u8BAF\u6587\u672C"\n      >\n    </el-table-column>\n    <el-table-column\n      label="\u64CD\u4F5C"\n      fixed="right"\n      width="100">\n      <template slot-scope="scope">\n        <el-button @click="checkRow(scope.row,scope.$index)" type="text" size="small">\u67E5\u770B</el-button>\n        <el-button @click="editRow(scope.row,scope.$index)" type="text" size="small">\u7F16\u8F91</el-button>\n      </template>\n    </el-table-column>\n  </el-table>\n  <el-pagination\n      @current-change="changePageIndex"\n      :current-page="currentPage"\n      :page-sizes="[10, 20, 30, 40]"\n      :page-size="pageSize"\n      @size-change = "changePageSize"\n      style="text-align: center;margin-top: 20px"\n      layout="total, sizes, prev, pager, next, jumper"\n      :total="totalData">\n    </el-pagination>\n    \n    \n    <!--\u67E5\u770B\u884C\u5F39\u7A97-->\n    <el-dialog\n  title="\u67E5 \u770B"\n  :visible.sync="checkRowDialogVisible"\n  width="800"\n  center>\n  <div class="case-app-content" style="text-align: center">\n <iframe :src="getReportFrame(currentSelectRow.id)" ref="frame" frameborder="0" width="730" ></iframe>\n</div>\n  <span slot="footer" class="dialog-footer">\n    <el-button type="primary" @click="checkRowDialogVisible = false">\u786E \u5B9A</el-button>\n  </span>\n</el-dialog>\n\n\n\n<!--\u7F16\u8F91\u884C\u5F39\u7A97-->\n    <el-dialog\n  :title="isEditState?\'\u7F16 \u8F91\':\'\u6DFB \u52A0\'"\n  :visible.sync="editRowDialogVisible"\n  width="730"\n  center>\n  <div class="case-app-content">\n  <el-form ref="form" :model="dialogForm" label-width="80px">\n  <el-form-item label="\u52A8\u6001\u65E5\u671F">\n        <el-date-picker type="date" placeholder="\u9009\u62E9\u65E5\u671F" v-model="dialogForm.date" style="width: 100%;"></el-date-picker>\n  </el-form-item>\n  <el-form-item label="\u52A8\u6001\u6027\u8D28">\n    <label>\u968F\u65F6\u65B0\u95FB<input type="radio"  v-model="dialogForm.state" value="0"></label>\n    <label>\u91CD\u8981\u65B0\u95FB<input type="radio" v-model="dialogForm.state" value="1"></label>\n  </el-form-item>\n  <el-form-item label="\u52A8\u6001\u5185\u5BB9">\n    <script id="editor-dialog" name="editor-dialog-content" type="text/plain">\n                 \u8BF7\u5F00\u59CB\u4F60\u7684\u8868\u6F14\n    </script>\n  </el-form-item>\n</el-form>\n</div>\n  <span slot="footer" class="dialog-footer">\n    <el-button  @click="editRowDialogVisible = false">\u53D6 \u6D88</el-button>\n    <el-button type="primary" @click="isEditState?submitEditReport():submitAddReport()">\u786E \u5B9A</el-button>\n  </span>\n</el-dialog>\n\n  </div>',
        created: function created() {
            this.searchTableData(this.pageSize, this.currentPage);
        },
        methods: {
            getReportFrame: function getReportFrame(id) {
                return sy.basePath + 'client/report/' + id + '?' + Date.now();
            },
            stateFormatter: function stateFormatter(row, column, cellValue) {
                return !!+cellValue ? '重要新闻' : '随时动态';
            },
            dateFormatter: function dateFormatter(row, column, cellValue) {
                return utils.dateFormatter(new Date(cellValue), "yyyy-MM-dd hh:mm:ss");
            },
            searchTableData: function searchTableData(pageSize, pageNum) {
                var _this = this;

                this.loading = true;
                axios.post(sy.basePath + 'client/listReports', {
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
            addReport: function addReport() {
                this.editRowDialogVisible = true;
                this.isEditState = false;
                //初始化
                this.dialogForm = { date: "",
                    state: 0,
                    reportHtml: "",
                    reportText: "" };
                this.editor && this.editor.execCommand("cleardoc");
            },
            editRow: function editRow(row, index) {
                var _this2 = this;

                this.checkOrEditIndex = index;
                this.editRowDialogVisible = true;
                this.dialogForm = JSON.parse(JSON.stringify(this.currentSelectRow));
                this.isEditState = true;
                setTimeout(function (_) {
                    setTimeout(function (_) {
                        _this2.editor && _this2.editor.execCommand("cleardoc");
                        _this2.editor && _this2.editor.execCommand("insertHtml", _this2.currentSelectRow.reportHtml);
                    });
                });
            },
            checkRow: function checkRow(row, index) {
                var _this3 = this;

                //初始化查看弹窗的frame


                this.checkRowDialogVisible = true;
                this.checkOrEditIndex = index;
                this.$nextTick(function (_) {
                    var frame = _this3.$refs.frame;
                    frame.style.display = "none";
                    $(frame).load(function () {
                        setIframeHeight(frame);
                        frame.style.display = "";
                    });
                });
            },
            submitEditReport: function submitEditReport() {
                var _this4 = this;

                this.loading = true;

                axios.post(sy.basePath + 'client/updateReport', {
                    date: this.dialogForm.date,
                    id: this.dialogForm.id,
                    state: this.dialogForm.state,
                    reportHtml: this.editor.getAllHtml(),
                    reportText: this.editor.getContentTxt().replace(/<.*>|<\/.*>/g, "")
                }).then(function (res) {
                    if (+res.data.code === 200) {
                        _this4.$message({
                            message: "修改成功!",
                            type: "success"
                        });
                        _this4.searchTableData(_this4.pageSize, _this4.currentPage);
                    }
                    _this4.loading = false;
                }).catch(function (_) {
                    return _this4.loading = false;
                });
                this.editRowDialogVisible = false;
            },
            submitAddReport: function submitAddReport() {
                var _this5 = this;

                this.loading = true;
                axios.post(sy.basePath + 'client/addReport', {
                    date: this.dialogForm.date,
                    state: this.dialogForm.state,
                    reportHtml: this.editor.getAllHtml(),
                    reportText: this.editor.getContentTxt().replace(/<.*>|<\/.*>/g, "")
                }).then(function (res) {
                    if (+res.data.code === 200) {
                        _this5.$message({
                            message: "添加成功!",
                            type: "success"
                        });
                        _this5.searchTableData(_this5.pageSize, _this5.currentPage);
                    }
                    _this5.loading = false;
                }).catch(function (_) {
                    return _this5.loading = false;
                });
                this.editRowDialogVisible = false;
            },
            deleteSelections: function deleteSelections() {
                var _this6 = this;

                this.loading = true;
                axios.post(sy.basePath + 'client/deleteReports', this.dataSelection).then(function (res) {
                    if (+res.data.code === 200) {
                        _this6.$message({
                            message: "删除成功!",
                            type: "success"
                        });
                        _this6.searchTableData(_this6.pageSize, _this6.currentPage);
                    }
                    _this6.loading = false;
                }).catch(function (_) {
                    return _this6.loading = false;
                });
            }
        },

        data: function data() {
            return {
                dialogForm: {
                    date: "",
                    state: 0,
                    reportHtml: "",
                    reportText: ""
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
                initedEditor: false,
                editor: null,
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
        },
        watch: {
            editRowDialogVisible: function editRowDialogVisible(newVal, old) {
                var _this7 = this;

                if (newVal && !this.initedEditor) {
                    setTimeout(function () {
                        setTimeout(function () {
                            var domID = 'editor-dialog';
                            _this7.editor = UE.getEditor(domID, {
                                allowDivTransToP: false,
                                initialFrameHeight: 100
                            });
                            _this7.editor.ready(function (_) {
                                _this7.editor.execCommand("cleardoc");
                                _this7.editor.execCommand("insertHtml", _this7.currentSelectRow.reportHtml);
                            });
                        });
                    });
                } else if (newVal && this.initedEditor) {
                    this.editor.init();
                }
            }
        }
    };
    return page;
});
