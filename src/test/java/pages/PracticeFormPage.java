package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateInput = $("#react-select-3-input"),
            city = $("#city"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit");

    public PracticeFormPage openPage() {
        open("/automation-practice-form");


        return this;

    }

    public PracticeFormPage removeWaste() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    CalendarComponent calendarComponent = new CalendarComponent();

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);

        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public PracticeFormPage setState(String value) {
        state.click();
        stateInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setCity(String value) {
        city.click();
        cityInput.setValue(value).pressEnter();

        return this;
    }

    public void pressSubmit() {
        submit.click();
    }

}


