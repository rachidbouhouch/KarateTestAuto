package org.sid.runner;

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
        Results results = com.intuit.karate.Runner.path("classpath:org/sid/feature").tags("@Valid").parallel(10);
        CustomCucumberReport extentReport = new CustomCucumberReport()
                .withReportDir(results.getReportDir())
                .withReportTitle("Karate Test Execution Cucumber Report")
                .withKarateResult(results);
        extentReport.generateExtentReport();

        Assert.assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }

}
