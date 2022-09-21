package page_object.page_steps.test_jira;

import hooks.WebHooks;
import org.junit.jupiter.api.*;

import static page_object.page_steps.AuthPageSteps.*;
import static page_object.page_steps.JiraHeaderPageSteps.*;
import static page_object.page_steps.TasksPageSteps.*;
import static page_object.page_steps.TestSelenium_bugPageSteps.*;
import static utils.Configuration.getConfigurationValue;
import static utils.Const.*;

public class TestJira extends WebHooks {
    @BeforeEach
    public void start() {
        openUrl(getConfigurationValue(JIRA_URL));
        auth(getConfigurationValue(LOGIN), getConfigurationValue(PASSWORD));

    }

    @Test
    public void tasksNumberCheckTest() {
        openTestProject();
        Assertions.assertTrue(getTasksNumber() > 0);
        System.out.println(getTasksNumber());
    }

    @Test
    public void statusTaskTest() {
        searchTask(TASK_NAME);
        Assertions.assertEquals("СДЕЛАТЬ", getStatusTask());
    }

    @Test
    public void versionsAffectedTaskTest() {
        searchTask(TASK_NAME);
        Assertions.assertEquals("Version 2.0", getVersionsAffected());
    }

    @Test
    public void createTaskTest(){
        createTask();
        Assertions.assertEquals("СДЕЛАТЬ", getStatusTask());
    }

    @Test
    public void changeTaskStatus(){
        Assertions.assertEquals("ГОТОВО",getChangeStatus());
    }
}
