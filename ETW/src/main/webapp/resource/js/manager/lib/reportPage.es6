define(function () {
    const page = {
        template: `<div id="case-app"     v-loading="loading">
<aside class="case-top-side">
<el-button type="primary" icon="el-icon-circle-plus-outline" @click="addReport">添加记录</el-button>
<el-button type="warning" icon="el-icon-delete" @click="deleteSelections">删除选中</el-button>
</aside>
<el-table
ref="multipleTable"
    tooltip-effect="dark"
    :data="tableData"
    border
    @selection-change="selection=>dataSelection=selection"
    :max-height="maxTableHeight"
    style="width: 100%;min-height: 70%;">
    <el-table-column 
      type="selection"
      width="55">
    </el-table-column> 
    <el-table-column
      prop="date"
      label="动态时间" 
      width="280"
      :formatter="dateFormatter"
      >
    </el-table-column>
    
    <el-table-column
      prop="state"
      label="性质"
      :formatter="stateFormatter"
      width="280">
    </el-table-column>
    
    <el-table-column
      prop="reportText"
      label="资讯文本"
      >
    </el-table-column>
    <el-table-column
      label="操作"
      fixed="right"
      width="100">
      <template slot-scope="scope">
        <el-button @click="checkRow(scope.row,scope.$index)" type="text" size="small">查看</el-button>
        <el-button @click="editRow(scope.row,scope.$index)" type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination
      @current-change="changePageIndex"
      :current-page="currentPage"
      :page-sizes="[10, 20, 30, 40]"
      :page-size="pageSize"
      @size-change = "changePageSize"
      style="text-align: center;margin-top: 20px"
      layout="total, sizes, prev, pager, next, jumper"
      :total="totalData">
    </el-pagination>
    
    
    <!--查看行弹窗-->
    <el-dialog
  title="查 看"
  :visible.sync="checkRowDialogVisible"
  width="800"
  center>
  <div class="case-app-content" style="text-align: center">
 <iframe :src="getReportFrame(currentSelectRow.id)" ref="frame" frameborder="0" width="730" ></iframe>
</div>
  <span slot="footer" class="dialog-footer">
    <el-button type="primary" @click="checkRowDialogVisible = false">确 定</el-button>
  </span>
</el-dialog>



<!--编辑行弹窗-->
    <el-dialog
  :title="isEditState?'编 辑':'添 加'"
  :visible.sync="editRowDialogVisible"
  width="730"
  center>
  <div class="case-app-content">
  <el-form ref="form" :model="dialogForm" label-width="80px">
  <el-form-item label="动态日期">
        <el-date-picker type="date" placeholder="选择日期" v-model="dialogForm.date" style="width: 100%;"></el-date-picker>
  </el-form-item>
  <el-form-item label="动态性质">
    <label>随时新闻<input type="radio"  v-model="dialogForm.state" value="0"></label>
    <label>重要新闻<input type="radio" v-model="dialogForm.state" value="1"></label>
  </el-form-item>
  <el-form-item label="动态内容">
    <script id="editor-dialog" name="editor-dialog-content" type="text/plain">
                 请开始你的表演
    </script>
  </el-form-item>
</el-form>
</div>
  <span slot="footer" class="dialog-footer">
    <el-button  @click="editRowDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="isEditState?submitEditReport():submitAddReport()">确 定</el-button>
  </span>
</el-dialog>

  </div>`,
        created: function () {
            this.searchTableData(this.pageSize, this.currentPage);
        },
        methods: {
            getReportFrame(id) {
                return `${sy.basePath}client/report/${id}?${Date.now()}`
            },
            stateFormatter(row, column, cellValue) {
                return !!+cellValue ? '重要新闻' : '随时动态';
            },
            dateFormatter(row, column, cellValue) {
                return utils.dateFormatter(new Date(cellValue), "yyyy-MM-dd hh:mm:ss");
            },
            searchTableData(pageSize, pageNum) {
                this.loading = true;
                axios.post(`${sy.basePath}client/listReports`, {
                    "pageNum": pageNum,
                    "pageSize": pageSize
                }).then(res => {
                    this.tableData = res.data.rows;
                    this.totalData = res.data.total;
                    this.loading = false;
                }).catch(reson => {
                    console.error(reson);
                    this.loading = false;
                });
            },
            changePageSize(size) {
                this.pageSize = size;
                this.searchTableData(this.pageSize, this.currentPage);
            },
            changePageIndex(pageNum) {
                this.currentPage = pageNum;
                this.searchTableData(this.pageSize, this.currentPage);
            },
            addReport() {
                this.editRowDialogVisible = true;
                this.isEditState = false;
                //初始化
                this.dialogForm = { date: "",
                    state: 0,
                    reportHtml: "",
                    reportText: "",};
                this.editor && this.editor.execCommand("cleardoc");
            },
            editRow(row, index) {
                this.checkOrEditIndex = index;
                this.editRowDialogVisible = true;
                this.dialogForm = JSON.parse(JSON.stringify(this.currentSelectRow));
                this.isEditState = true;
                setTimeout(_ => {
                    setTimeout(_ => {
                        this.editor && this.editor.execCommand("cleardoc");
                        this.editor && this.editor.execCommand("insertHtml", this.currentSelectRow.reportHtml);
                    })
                });
            },
            checkRow(row, index) {
                //初始化查看弹窗的frame


                this.checkRowDialogVisible = true;
                this.checkOrEditIndex = index;
                this.$nextTick(_=>{
                    const frame = this.$refs.frame;
                    frame.style.display ="none";
                    $(frame).load( () =>{
                        setIframeHeight(frame);
                        frame.style.display ="";
                    });
                })
            },
            submitEditReport() {
                this.loading = true;

                axios.post(`${sy.basePath}client/updateReport`, {
                    date: this.dialogForm.date,
                    id: this.dialogForm.id,
                    state: this.dialogForm.state,
                    reportHtml: this.editor.getAllHtml(),
                    reportText: this.editor.getPlainTxt(),
                }).then(res => {
                    if (+res.data.code === 200) {
                        this.$message({
                            message: "修改成功!",
                            type: "success"
                        });
                        this.searchTableData(this.pageSize, this.currentPage);
                    }
                    this.loading = false;
                }).catch(_ => this.loading = false);
                this.editRowDialogVisible = false;

            }, submitAddReport() {
                this.loading = true;
                axios.post(`${sy.basePath}client/addReport`, {
                    date: this.dialogForm.date,
                    state: this.dialogForm.state,
                    reportHtml: this.editor.getAllHtml(),
                    reportText: this.editor.getPlainTxt(),
                }).then(res => {
                    if (+res.data.code === 200) {
                        this.$message({
                            message: "添加成功!",
                            type: "success"
                        });
                        this.searchTableData(this.pageSize, this.currentPage);
                    }
                    this.loading = false;
                }).catch(_ => this.loading = false);
                this.editRowDialogVisible = false;

            },
            deleteSelections() {
                this.loading = true;
                axios.post(`${sy.basePath}client/deleteReports`, this.dataSelection).then(res => {
                    if (+res.data.code === 200) {
                        this.$message({
                            message: "删除成功!",
                            type: "success"
                        });
                        this.searchTableData(this.pageSize, this.currentPage);
                    }
                    this.loading = false;
                }).catch(_ => this.loading = false);
            }

        },

        data() {
            return {
                dialogForm: {
                    date: "",
                    state: 0,
                    reportHtml: "",
                    reportText: "",
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
                editRowDialogVisible: false,
            }
        },
        computed: {
            maxTableHeight() {
                const cptdHeight = window.innerHeight * 0.7;
                return cptdHeight > 400 ? cptdHeight : 500;
            },
            currentSelectRow() {
                const row = this.tableData[this.checkOrEditIndex];
                return row || {};
            }
        },
        watch: {
            editRowDialogVisible(newVal, old) {
                if (newVal && !this.initedEditor) {
                    setTimeout(() => {
                        setTimeout(() => {
                            const domID = 'editor-dialog';
                            this.editor = UE.getEditor(domID, {
                                allowDivTransToP: false,
                                initialFrameHeight:100
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