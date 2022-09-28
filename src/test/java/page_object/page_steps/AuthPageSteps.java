package page_object.page_steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static page_object.page_elements.AuthPageElem.*;
import static com.codeborne.selenide.Selenide.open;

public class AuthPageSteps {
    @Given("Пользователь перешел по ссылке {string}")
    public static void openUrl(String url){
        open(url);
    }
    @Then("Пользователь авторизовался введя логин {string} и пароль {string}")
    public static void auth(String login, String password){
        loginInput.shouldBe(Condition.visible).sendKeys(login);
        passInput.shouldBe(Condition.visible).sendKeys(password);
        logInButton.shouldBe(Condition.visible).click();
        profileLogo.shouldBe(Condition.visible);
    }
}
