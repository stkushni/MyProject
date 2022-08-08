package pages.insider;

import base.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.get;

public class QAPage extends PageBase {
    private static final By SEE_ALL_QA_JOBS = get("qa.seeAllQAJobs");

    public static void goToOpenPositionsPage () {
        $(SEE_ALL_QA_JOBS).shouldBe(visible);
        $(SEE_ALL_QA_JOBS).click();
    }
}
