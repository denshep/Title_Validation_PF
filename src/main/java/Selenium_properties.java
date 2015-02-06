import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by ds on 2/5/15.
 */
public class Selenium_properties {
    //public static void main(String[] args) throws FileNotFoundException, IOException {
    public static void main(String[] args) {
        String test_case_id = null;
        String url = null;
        String title_expected = null;

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("./src/main/resources/Test.properties"));

                test_case_id = properties.getProperty("test_case_id");
                url = properties.getProperty("url");
                title_expected = properties.getProperty("title_expected");
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriver driver = new FirefoxDriver(); // Version 1.3 :: Firefox

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String title_actual = driver.getTitle();

        if (title_expected.equals(title_actual)) {
            System.out.println("Test Case ID: \t\t" + test_case_id);
            System.out.println("URL: \t\t" + url);
            System.out.println("Title Expected: \t\t" + title_expected);
            System.out.println("Test Case Result: \t\t" + "PASSED");
        } else {
            System.out.println("Test Case ID: \t\t" + test_case_id);
            System.out.println("URL: \t\t" + url);
            System.out.println("Title Expected: \t\t" + title_expected);
            System.out.println("Test Case Result: \t\t" + "FAILED");
        }
        driver.quit();
    }
}
