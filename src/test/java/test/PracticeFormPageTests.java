package test;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ResultTableComponent;


public class PracticeFormPageTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    @Test
    void successfulFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setEmail("alex@egorov.com")
                .setGender("Male")
                .setUserNumber("8133701488")
                .setDateOfBirth("1", "January", "1989")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .uploadPicture("1.png")
                .setCurrentAddress("Elm street")
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmit();

        resultTableComponent.checkResult("Student Name", "Alex Egorov")
                .checkResult("Student Email", "alex@egorov.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8133701488")
                .checkResult("Date of Birth", "1 January,1989")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "Elm street")
                .checkResult("State and City", "NCR Delhi");
    }
    @Test
    void reqFieldsFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setGender("Male")
                .setUserNumber("8133701488")
                .pressSubmit();

        resultTableComponent.checkResult("Student Name", "Alex Egorov");
    }

    @Test
    void negativeFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Alex")
                .pressSubmit();

        resultTableComponent.checkNegativeResult();
    }
}
