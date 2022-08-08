package test;

import com.codeborne.selenide.Selenide;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pages.insider.CareersPage;
import pages.insider.InsiderMainPage;
import pages.insider.PositionsPage;
import pages.insider.QAPage;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class InsiderHomeworkTest {
    private static WebDriver driver;
    private static Actions act;
    private Map<String, Object> vars;
    static JavascriptExecutor js;

    @BeforeClass
    public static void setup() {
//        //определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
//        //создание экземпляра драйвера
//        driver = new ChromeDriver();
//        js = (JavascriptExecutor)driver;
//        //окно разворачивается на полный экран
//        driver.manage().window().maximize();
//        //задержка на выполнение теста = 10 сек.
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        //получение ссылки на страницу входа из файла настроек
//        driver.get(ConfProperties.getProperty("insiderpage"));
        Dimension dimension = new Dimension(1920, 1080);
        Selenide.open(ConfProperties.getProperty("insiderpage"));
        WebDriverRunner.getWebDriver().manage().window().setSize(dimension);
    }


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

        InsiderMainPage.goToMoreMenu();
        // 4 | click | css=.nav-item:nth-child(6) .dropdown-item:nth-child(1) > .col-12:nth-child(3) h5 |

        InsiderMainPage.goToCareersPage();
        // 5 | assertElementPresent | css=.elementor-element-0c06ebc .elementor-heading-title |
        CareersPage.checkCareersPage();
        CareersPage.clickAllTeamsButton();
        CareersPage.checkQAPlate();
        CareersPage.goToQAPage();

        // 13 | click | linkText=See all QA jobs |
        QAPage.goToOpenPositionsPage();

        PositionsPage.selectRegion();
        PositionsPage.selectIstanbul();
        // 14 | click | css=.select2-container--below b |
        // driver.findElement(By.cssSelector(".select2-container--below b")).click();
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
