define(function () {
    const page = {
        template: `<div id="case-app"     v-loading="loading">
<aside class="case-top-side">
<el-button type="primary" icon="el-icon-circle-plus-outline" @click="addCase">添加记录</el-button>
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
      prop="name"
      label="名称" 
      width="280">
    </el-table-column>
    
    <el-table-column
      prop="link"
      label="网页链接"
      width="280">
    </el-table-column>
    
    <el-table-column
      prop="icon"
      label="图标链接"
      width="300"
      >
    </el-table-column>
    <el-table-column
      prop="desc"
      label="描述信息"
     width="300"
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
  width="30%"
  center>
  <div class="case-app-content">
  <a :href="currentSelectRow.link">
                        <img :src="currentSelectRow.icon" alt="广东大族粤铭集团股份有限公司" class="card-icon">
                        </a> 
                        <p>
  <a :href="currentSelectRow.link" class="card-link">{{currentSelectRow.name}}</a>
                        <p class="card-desc" v-html="markedNumberRed(currentSelectRow.desc)"></p>
                       </p>
</div>
  <span slot="footer" class="dialog-footer">
    <el-button type="primary" @click="checkRowDialogVisible = false">确 定</el-button>
  </span>
</el-dialog>



<!--编辑行弹窗-->
    <el-dialog
  :title="isEditState?'编 辑':'添 加'"
  :visible.sync="editRowDialogVisible"
  width="30%"
  center>
  <div class="case-app-content">
  <el-form ref="form" :model="dialogForm" label-width="80px">
  <el-form-item label="公司名称">
    <el-input v-model="dialogForm.name"></el-input>
  </el-form-item>
  <el-form-item label="公司网址">
    <el-input v-model="dialogForm.link"></el-input>
  </el-form-item>
  <el-form-item label="案例描述">
    <el-input v-model="dialogForm.desc"></el-input>
  </el-form-item>
  <el-form-item label="公司图标">
    <el-input v-model="dialogForm.icon"></el-input>
  </el-form-item>
  
   
</el-form>
</div>
  <span slot="footer" class="dialog-footer">
    <el-button  @click="editRowDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="isEditState?submitEditCase():submitAddCase()">确 定</el-button>
  </span>
</el-dialog>

  </div>`,
        created: function () {
            this.searchTableData(this.pageSize, this.currentPage);
        },
        methods: {
            searchTableData(pageSize, pageNum) {
                this.loading = true;
                axios.post(`${sy.basePath}client/listCases`, {
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
            addCase(){
                this.editRowDialogVisible = true;
                this.isEditState = false;
                this.dialogForm = {
                    name:"",
                    link:"",
                    icon:"",
                    desc:"",
                };
            },
            editRow(row, index) {
                this.checkOrEditIndex = index;
                this.editRowDialogVisible = true;
                this.dialogForm = JSON.parse(JSON.stringify(this.currentSelectRow));
                this.isEditState = true;
            },
            checkRow(row, index) {
                this.checkRowDialogVisible = true;
                this.checkOrEditIndex = index;
            },
            submitEditCase(){
                this.loading = true;
                axios.post(`${sy.basePath}client/updateCase`,this.dialogForm).then(res=>{
                    if(+res.data.code === 200){
                        this.$message({
                            message:"修改成功!",
                            type:"success"
                        });
                        this.searchTableData(this.pageSize, this.currentPage);
                    }
                    this.loading = false;
                }).catch(_=>this.loading = false);
                this.editRowDialogVisible = false;

            },submitAddCase(){
                this.loading = true;
                axios.post(`${sy.basePath}client/addCase`,this.dialogForm).then(res=>{
                    if(+res.data.code === 200){
                        this.$message({
                            message:"添加成功!",
                            type:"success"
                        });
                        this.searchTableData(this.pageSize, this.currentPage);
                    }
                    this.loading = false;
                }).catch(_=>this.loading = false);
                this.editRowDialogVisible = false;

            },
            deleteSelections(){
                this.loading = true;
                axios.post(`${sy.basePath}client/deleteCases`,this.dataSelection).then(res=>{
                    if(+res.data.code === 200){
                        this.$message({
                            message:"删除成功!",
                            type:"success"
                        });
                        this.searchTableData(this.pageSize, this.currentPage);
                    }
                    this.loading = false;
                }).catch(_=>this.loading = false);
            },
            markedNumberRed(str) {
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

        data() {
            return {
                dialogForm:{
                    name:"",
                    link:"",
                    icon:"",
                    desc:"",
                },
                isEditState:false,
                dataSelection:[],
                loading: false,
                totalData: 0,
                pageSize: 10,
                currentPage: 1,
                tableData: [],
                checkOrEditIndex: 0,
                checkRowDialogVisible: false,
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
        }
    };
    return page;
});