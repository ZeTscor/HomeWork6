package zets;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AnnotationStep {

    @Step("Открытия главной страници GitHub")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Поиск репозитория {repos}")
    public void searchRepos(String repos) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repos);
        $(".header-search-input").submit();
    }

    @Step("Переход в репозиторий {repos}")
    public void goToRepo(String repos) {
        $(byLinkText(repos)).click();
    }

    @Step("Открытие вкладки Issues")
    public void openIssueTab() {
        $(byPartialLinkText("Issues")).click();
    }

    @Step("Проверка наличия issues по названию {issues}")
    public void searchIssues(String issues) {
        $(withText(issues)).shouldHave(Condition.visible);
    }

}
