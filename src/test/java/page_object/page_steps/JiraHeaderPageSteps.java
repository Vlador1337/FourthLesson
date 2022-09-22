package page_object.page_steps;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static page_object.page_elements.JiraHeaderPageElem.*;

public class JiraHeaderPageSteps {
    public static void openTestProject() {
        tasksButton.click();
        tasksSearchButton.shouldBe(Condition.visible).click();
    }

    public static void searchTask(String task) {
        searchField.sendKeys(task + Keys.ENTER);
    }

    public static void createTask() {
        createBugReportButton.shouldBe(visible).click();
        issueType.shouldBe(visible).click();
        issueType.sendKeys("Ошибка" + Keys.ENTER);;
        summaryInput.shouldBe(visible).click();
        summaryInput.setValue("Тест");
        descriptionButton.shouldBe(visible).click();
        description.setValue("Описание");
        version.click();
        assignOnMe.click();
        createIssueSubmit.shouldBe(visible).click();
        tasksButton.shouldBe(visible).click();
        reportedByMeTasks.shouldBe(visible).click();
    }


}
