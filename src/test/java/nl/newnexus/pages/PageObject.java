package nl.newnexus.pages;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tester on 4/19/2017.
 */

    public class PageObject {
        protected WebDriver driver;

        public PageObject(WebDriver driver){
            this.driver = driver;

            if (this.driver == null  ) {
                System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
                this.driver = new ChromeDriver();
                this.driver.manage().timeouts()     .implicitlyWait(5, TimeUnit.SECONDS)
                        .pageLoadTimeout(30, TimeUnit.SECONDS)
                        .setScriptTimeout(30, TimeUnit.SECONDS);
                this.driver.manage().deleteAllCookies();
                PageFactory.initElements(this.driver, this);
            }
        }

        public void Stop(Scenario scenario) {

            if (driver != null) {
                try {
                    if (scenario.isFailed()) {
                        final byte[] screenshot = ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.BYTES);
                        scenario.embed(screenshot, "image/png");
                    }
                } finally {
                    driver.quit();
                }
            }

        }

    }
