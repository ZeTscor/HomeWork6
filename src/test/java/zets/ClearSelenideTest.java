package zets;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@Owner("Zets")
@Feature("Issue")
@Story("Issue display")
public class ClearSelenideTest {


    private static final String REPO = "selenide/selenide";
    private static final String ISSUE = "Bad browser language in version 6+";

    @BeforeAll
    static void beforeAll() {
        browserSize = "1920x1080";
        addListener("AllureSelenide", new AllureSelenide());
        baseUrl = "https://github.com/";
    }

    @DisplayName("Проверка наличия issue с помощью selenide")
    @Test
    void GitHubTest() {
        open(baseUrl);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPO);
        $(".header-search-input").submit();
        $(byLinkText(REPO)).click();
        $(byPartialLinkText("Issues")).click();
        $(withText(ISSUE)).shouldHave(Condition.visible);
    }
}
