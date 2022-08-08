package pages.insider;

import base.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.get;

public class PositionsPage  extends PageBase {
    private static final By SELECT_REGION = get("positions.selectRegion");
    private static final By ISTANBUL_REGION = get("positions.Istanbul");

    public static void selectRegion () {
        $(SELECT_REGION).shouldBe(visible);
        $(SELECT_REGION).click();
    }

    public static void selectIstanbul () {
        $(ISTANBUL_REGION).shouldBe(visible);
        $(ISTANBUL_REGION).click();
    }
}
