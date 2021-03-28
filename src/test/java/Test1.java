import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Test1 {

    @BeforeAll
    // делаем расширения браузера на весь экран
    static void setup() {

        Configuration.startMaximized = true;
    }
    @Test
    void shouldFindSelenideGitHub(){
        Selenide.open("https://github.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        Selenide.$$("ul.repo-list li").get(0).$("a").click();
        $("h1").shouldHave(Condition.text("selenide / selenide"));
        $("[data-tab-item=i4wiki-tab]").click();
        $("#wiki-body").shouldHave(Condition.text("Soft assertions"));
        $(byText("Soft assertions")).click();
        //$("#wiki-body").$("/selenide/selenide/wiki/SoftAssertions").click();
        //$(".d-flex:nth-child(5) > .js-selected-navigation-item > span:nth-child(2)").click();

        sleep(5000);

    }
}
