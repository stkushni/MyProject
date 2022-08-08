package base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PageBase {

//    /**
//     * Скроллит страницу вниз до появления элемента каждую секунду.
//     * Если достигнут футер страницы и элемент не найден - выбрасывается exception.
//     */
//    public void scrollWhileElemNotFoundOnPage(String elementName) {
//        SelenideElement el = null;
//        do {
//            el = akitaScenario.getCurrentPage().getElement(elementName);
//            if (el.exists()) {
//                break;
//            }
//            executeJavaScript("return window.scrollBy(0, 250);");
//            sleep(1000);
//        } while (!atBottom());
//        assertThat("Элемент " + elementName + " не найден", el.isDisplayed());
//    }
}
