package pages.insider;

import base.PageBase;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.get;

public class CareersPage extends PageBase {
    private static final By OUR_STORY = get("careers.ourStory");
    private static final By FIND_YOUR_CALLING = get("careers.findYourCalling");
    private static final By OUR_LOCATIONS = get("careers.ourLocations");
    private static final By SEE_ALL_TEAMS = get("careers.seeAllTeams");
    private static final By QA_Plate = get("careers.QAPlate");

    public static void checkCareersPage() {
        checkOurStoryBlock();
        checkFindYourCallingBlock();
        checkOurLocations();
        checkSeeAllTeamsButton();
    }

    public static void checkQAPlate() {
        $(QA_Plate).shouldBe(visible);
    }

    public static void clickAllTeamsButton() {
        Selenide.Wait().until(ExpectedConditions.elementToBeClickable(SEE_ALL_TEAMS));
        $(SEE_ALL_TEAMS).click();
    }

    public static void goToQAPage() {
        Selenide.Wait().until(ExpectedConditions.elementToBeClickable(QA_Plate));
        $(QA_Plate).click();
    }

    private static void checkOurStoryBlock() {
        $(OUR_STORY).shouldBe(visible);
    }

    private static void checkFindYourCallingBlock() {
        $(FIND_YOUR_CALLING).shouldBe(visible);
    }

    private static void checkOurLocations() {
        $(OUR_LOCATIONS).shouldBe(visible);
    }

    private static void checkSeeAllTeamsButton() {
        $(SEE_ALL_TEAMS).shouldBe(visible);
    }

}