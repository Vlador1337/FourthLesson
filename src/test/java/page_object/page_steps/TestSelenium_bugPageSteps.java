package page_object.page_steps;

import com.codeborne.selenide.Condition;

import static page_object.page_elements.TestSelenium_bugPageElem.*;

public class TestSelenium_bugPageSteps {
    public static String getStatusTask() {
        return status.shouldBe(Condition.visible).text();
    }

    public static String getVersionsAffected(){
        return versionsAffected.shouldBe(Condition.visible).text();
    }
}
