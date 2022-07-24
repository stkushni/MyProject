package test;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class InsiderHomeworkTest {
    private static WebDriver driver;
    private static Actions act;
    private Map<String, Object> vars;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        js = (JavascriptExecutor)driver;
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("insiderpage")); }


//    @Before
//    public void setUp() {
//        driver = new ChromeDriver();
//        js = (JavascriptExecutor) driver;
//        vars = new HashMap<String, Object>();
//    }

    @After
    public void tearDown() {
        driver.quit();
    }
    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }
    @Test
    public void insiderTest() {
        // Test name: InsiderTest
        // Step # | name | target | value
        // 3 | click | css=.nav-item:nth-child(6) > #mega-menu-1 > span |
        driver.findElement(By.cssSelector(".nav-item:nth-child(6) > #mega-menu-1 > span")).click();
                // 4 | click | css=.nav-item:nth-child(6) .dropdown-item:nth-child(1) > .col-12:nth-child(3) h5 |
        driver.findElement(By.cssSelector(".nav-item:nth-child(6) .dropdown-item:nth-child(1) > .col-12:nth-child(3) h5")).click();
        // 5 | assertElementPresent | css=.elementor-element-0c06ebc .elementor-heading-title |
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".elementor-element-0c06ebc .elementor-heading-title"));
            assert(elements.size() > 0);
        }
        // 6 | assertElementPresent | css=.mb-xl-5 > .category-title-media |
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".mb-xl-5 > .category-title-media"));
            assert(elements.size() > 0);
        }
        // 7 | assertElementPresent | css=.ml-0 |
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".ml-0"));
            assert(elements.size() > 0);
        }
        // 8 | assertElementPresent | linkText=See all teams |
        {
            List<WebElement> elements = driver.findElements(By.linkText("See all teams"));
            assert(elements.size() > 0);
        }
        // 9 | click | linkText=See all teams |
        //        driver.findElement(By.linkText("See all teams")).click();
        WebElement seeAllTeams = driver.findElement(By.linkText("See all teams"));
        js.executeScript("arguments[0].click();", seeAllTeams);
        // 10 | assertElementPresent | css=.job-item:nth-child(23) > .job-title .text-center |
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".job-item:nth-child(23) > .job-title .text-center"));
            assert(elements.size() > 0);
        }
        // 11 | click | css=.job-item:nth-child(23) > .job-title .text-center |
        WebElement QA = driver.findElement(By.cssSelector(".job-item:nth-child(23) > .job-title .text-center"));
        js.executeScript("arguments[0].click();", seeAllTeams);
        driver.findElement(By.cssSelector(".job-item:nth-child(23) > .job-title .text-center")).click();
        // 12 | click | css=.col-lg-7 > .justify-content-center |
        driver.findElement(By.cssSelector(".col-lg-7 > .justify-content-center")).click();
        // 13 | click | linkText=See all QA jobs |
        driver.findElement(By.linkText("See all QA jobs")).click();
        // 14 | click | css=.select2-container--below b |
        driver.findElement(By.cssSelector(".select2-container--below b")).click();
        // 15 | assertElementPresent | css=.position-list-item:nth-child(1) .position-department |
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".position-list-item:nth-child(1) .position-department"));
            assert(elements.size() > 0);
        }
        // 16 | assertElementPresent | linkText=Apply Now |
        {
            List<WebElement> elements = driver.findElements(By.linkText("Apply Now"));
            assert(elements.size() > 0);
        }
        // 17 | click | linkText=Apply Now |
        vars.put("window_handles", driver.getWindowHandles());
        // 18 | selectWindow | handle=${win8404} |
        driver.findElement(By.linkText("Apply Now")).click();
        // 19 | assertElementPresent | css=.section:nth-child(1) > div:nth-child(3) |
        vars.put("win8404", waitForWindow(2000));
        driver.switchTo().window(vars.get("win8404").toString());
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".section:nth-child(1) > div:nth-child(3)"));
            assert(elements.size() > 0);
        }
    }
}
