package com.base.dao.pojo;

public class ReportWithBLOBs extends Report {
    private String reportHtml;

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