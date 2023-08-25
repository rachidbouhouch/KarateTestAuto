package org.sid.reports;

import com.aventstack.extentreports.ExtentReports;
import com.intuit.karate.Results;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomCucumberReport {
    private String reportDir;
    private String reportTitle = "Karate Test Execution Cucumber Report";
    private Results testResults;


    public CustomCucumberReport withReportDir(String reportDir) {
        this.reportDir = reportDir;
        return this;
    }

    public CustomCucumberReport withKarateResult(Results testResults) {
        this.testResults = testResults;
        return this;
    }

    public CustomCucumberReport withReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
        return this;
    }
    public void generateExtentReport() {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(reportDir), new String[]{"json"}, true);
        List jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "KarateBaseFramework");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}

