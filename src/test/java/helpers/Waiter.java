package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Waiter {
    private static final Duration DEFAULT_TIME_OUT = (Duration.ofSeconds(10));

    public static void waitForPageTitle(String title){getWaiter().until(ExpectedConditions.titleIs(title));}

    public static void waitForJquery() {
        getWaiter().until((ExpectedCondition) (webDriver) -> {
                    JavascriptExecutor js = (JavascriptExecutor) webDriver;
                    return (Boolean) js.executeScript("return jQuery.active == 0");
                });
    }

    public static void waitForPageToLoad() {
        Wait().until((ExpectedCondition) (webDriver) -> {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            boolean complete = ((String) js.executeScript("return document.readyState")).equalsIgnoreCase("complete");
            if (!complete) {
                sleep(1000);
            }
            return complete;
        });
    }

//    public static void waitForPollingToStart(final TrafficListener poller, final long millisec) {
//        getWaiter().until((ExpectedCondition) (webDriver) -> {return poller.isPolling(millisec);});
//    }
//
//    public static void waitForQuietPeriodOf(final TrafficListener poller, final long millisec) {
//        getWaiter().until((ExpectedCondition) (webDriver) -> {return poller.isQuiteFor(millisec);});
//    }
      private static WebDriverWait getWaiter(){return new WebDriverWait(getWebDriver(), DEFAULT_TIME_OUT);}
}