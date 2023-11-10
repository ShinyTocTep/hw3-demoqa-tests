package test;

import data.TestData;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ResultTableComponent;


public class PracticeFormPageTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    TestData testData = new TestData();
    @Test
    void successfulFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day,
                        testData.month,
                        testData.year)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .uploadPicture("1.png")
                .setCurrentAddress(testData.streetAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .pressSubmit();

        resultTableComponent.checkResult("Student Name", testData.firstName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.day + "\n" +
                        testData.month + "," +
                        testData.year)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", "1.png")
                .checkResult("Address", testData.streetAddress)
                .checkResult("State and City", testData.state + "\n" + testData.city);
    }
    @Test
    void reqFieldsFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .pressSubmit();

        resultTableComponent.checkResult("Student Name", testData.firstName + "\n" + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber);
    }

    @Test
    void negativeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(testData.firstName)
                .pressSubmit();

        resultTableComponent.checkNegativeResult();
    }
}
