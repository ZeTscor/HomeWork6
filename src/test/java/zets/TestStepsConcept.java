package zets;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@Owner("Zets")
@Feature("Issue")
@Story("Issue display")
public class TestStepsConcept {
    private AnnotationStep step = new AnnotationStep();
    private static final String REPO = "selenide/selenide";
    private static final String ISSUE = "Bad browser language in version 6+";

    @BeforeAll
    static void beforeAll() {
        browserSize = "1920x1080";
    }

    @DisplayName("Проверка наличия issue с помощью лямбда степов")
    @Test
    void gitHubTestLambdaStep() {
        step("Открытия главной страници github", () -> open("https://github.com/"));

        step("Поиск репозитория" + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
            $(".header-search-input").submit();
        });

        step("Переход в репозиторий" + REPO, () -> $(byLinkText(REPO)).click());

        step("Открытие вкладки Issues", () -> $(byPartialLinkText("Issues")).click());

        step("Проверка наличия issues по названию" + ISSUE, () -> {
            $(withText(ISSUE)).shouldHave(Condition.visible);
        });

    }

    @DisplayName("Проверка наличия issue с помощью аннотаций step")
    @Test
    void gitHubTestAnnoStep() {
        step.openMainPage();
        step.searchRepos(REPO);
        step.goToRepo(REPO);
        step.openIssueTab();
        step.searchIssues(ISSUE);
    }

}
