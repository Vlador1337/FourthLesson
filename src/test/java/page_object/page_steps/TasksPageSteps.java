package page_object.page_steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static page_object.page_elements.JiraHeaderPageElem.*;
import static page_object.page_elements.TasksPageElem.*;
import static page_object.page_elements.TestSelenium_bugPageElem.*;

public class TasksPageSteps {
    @Then("Проверяем количество задач")
    public static void checkTasksNumber() {
        String number = tasksNumber.text();
        int tasksNumber = Integer.parseInt(number.substring(number.lastIndexOf(" ")).trim());
        Assertions.assertTrue(0 < tasksNumber);
    }

    @Then("Проверяем статус задачи")
    public static void checkChangeStatus() {
        tasksButton.shouldBe(visible).click();
        openTasksButton.shouldBe(visible).click();
        Assertions.assertEquals("ГОТОВО", status.shouldBe(visible).text());
    }

    @When("Пользователь перевел задачу в статус В РАБОТЕ, затем в статус ВЫПОЛНЕНО")
    public static void changeStatus() {
        tasksButton.shouldBe(visible).click();
        reportedByMeTasks.shouldBe(visible).click();
        needToDoStatus.shouldBe(visible).click();
        inWorkStatus.shouldBe(visible).click();
        closedStatusDropdown.shouldBe(visible).click();
        closedStatus.shouldBe(visible).click();
    }
}
