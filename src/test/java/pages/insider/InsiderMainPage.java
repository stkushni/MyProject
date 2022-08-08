package pages.insider;

import base.PageBase;
import org.openqa.selenium.By;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.get;

public class InsiderMainPage extends PageBase {
    private static final By MORE = get("header.more");
    private static final By CAREERS = get("header.careers");
    private static final By ACCEPT_COOKIES = get("header.acceptCookies");

    public static void goToMoreMenu() {
        $(ACCEPT_COOKIES).shouldBe(visible);
        $(ACCEPT_COOKIES).click();
        $(MORE).shouldBe(visible);
        $(MORE).click();
    }

    public static void goToCareersPage() {
        $(CAREERS).shouldBe(visible);
        $(CAREERS).click();
    }
}
