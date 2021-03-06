package com.base.dao.pojo;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * 实体类对应的数据表为：  e_report
 * @author XiaChengwei
 * @date 2018-03-12 01:05:06
 */
@ApiModel(value ="")
public class ReportWithBLOBs extends Report {
    @ApiModelProperty(value = "")
    private String reportHtml;

    @ApiModelProperty(value = "")
    private String reportText;

    public String getReportHtml() {
        return reportHtml;
    }

    public void setReportHtml(String reportHtml) {
        this.reportHtml = reportHtml == null ? null : reportHtml.trim();
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText == null ? null : reportText.trim();
    }
}