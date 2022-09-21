package page_object.page_steps;

import com.codeborne.selenide.Condition;

import static page_object.page_elements.AuthPageElem.*;
import static com.codeborne.selenide.Selenide.open;

public class AuthPageSteps {
    public static void openUrl(String url){
        open(url);
    }

    public static void auth(String login, String password){
        loginInput.shouldBe(Condition.visible).sendKeys(login);
        passInput.shouldBe(Condition.visible).sendKeys(password);
        logInButton.shouldBe(Condition.visible).click();
        profileLogo.shouldBe(Condition.visible);
    }
}
