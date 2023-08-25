package org.sid.runner;

import org.junit.Test;
import com.intuit.karate.Results;
import com.intuit.karate.Runner.Builder;
import org.sid.reports.CustomExtentReport;

public class ParalleRunnerWithExtentReport {
    @Test
    public void executeKarateTest() {
        Builder aRunner = new Builder();
        aRunner.path("classpath:org/sid/feature");
        Results result = aRunner.parallel(5);
        // Extent Report
        CustomExtentReport extentReport = new CustomExtentReport()
                .withKarateResult(result)
                .withReportDir(result.getReportDir())
                .withReportTitle("Karate Test Execution Extent Report");
        extentReport.generateExtentReport();

    }
}
