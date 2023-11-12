package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    public ResultTableComponent checkResult(String key, String value) {
        $(".modal-dialog").should(appear);
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public void checkNegativeResult() {
        $(".modal-dialog").shouldNot(appear);
    }
}
