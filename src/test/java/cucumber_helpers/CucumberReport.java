package cucumber_helpers;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.IExecutionListener;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CucumberReport implements IExecutionListener {

    public boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    public void GenerateReport() {
        String path = createDirectoryWithDateTime();
        File reportOutputDirectory = new File(path);

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-reports/JsonReports.json");

        String buildNumber = "1";
        String projectName = "Automation Sample Project";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

    public String createDirectoryWithDateTime() {
        // Define the date and time format
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = dtf.format(now);

        // Define the directory path
        String directoryPath = "target/cucumber-reports/" + formattedDateTime;

        // Create the directory
        File directory = new File(directoryPath);
        directory.mkdirs();
        return directoryPath;
    }

    @Override
    public void onExecutionStart() {
        this. deleteDirectory(new File("target/cucumber-reports/JsonReports.json"));
    }

    @Override
    public void onExecutionFinish() {
        this.GenerateReport();
    }
}
