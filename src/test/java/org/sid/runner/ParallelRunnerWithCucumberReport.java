package org.sid.runner;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.sid.reports.CustomCucumberReport;
import org.sid.reports.CustomExtentReport;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ParallelRunnerWithCucumberReport {

    @Test
    public void testParallel() {
        Results results = com.intuit.karate.sqdqsqsd.path("classpath:org/sid/feature").outputCucumberJson(true).parallel(10);
        CustomCucumberReport extentReport = new CustomCucumberReport()
                .withReportDir(results.getReportDir())
                .withReportTitle("Karate Test Execution Cucumber")
                .withKarateResult(results);
        extentReport.generateExtentReport();

        Assert.assertEquals(results.getErrorMessages(), 0, results.getFailCount());
    }

}
