import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test1 {

    @BeforeAll
    // делаем расширения браузера на весь экран
    static void setup() {

        Configuration.startMaximized = true;
    }
    @Test
    void shouldFindSelenideGitHub(){
        Selenide.open("https://github.com/");
        Selenide.$("[name=q]").setValue("selenide").pressEnter();
        Selenide.$$("ul.repo-list li").get(0).$("a").click();
        Selenide.$("h1").shouldHave(Condition.text("selenide / selenide"));
        Selenide.sleep(5000);
    }
}
