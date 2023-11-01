package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PractceFormTests {

    @BeforeAll
    static void beforeAll() {
      Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//      Configuration.holdBrowserOpen = true;

    }

    @Test
    void formTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8133701488");
        $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("January");
            $(".react-datepicker__year-select").selectOption("1989");
            $(".react-datepicker__week > div").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("Elm street");
        $("#state").click();
            $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
            $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();


        $(".table-responsive").shouldHave(text("Alex"));
        $(".table-responsive").shouldHave(text("Egorov"));
        $(".table-responsive").shouldHave(text("alex@egorov.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("January"));
        $(".table-responsive").shouldHave(text("1989"));
        $(".table-responsive").shouldHave(text("1"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("Elm street"));
        $(".table-responsive").shouldHave(text("NCR"));
        $(".table-responsive").shouldHave(text("Delhi"));

    }
}
