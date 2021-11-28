package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataGenerator;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryWithDataGeneratorTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

//    @Test
//    @DisplayName("Should successful plan and replan meeting")
//    void shouldSuccessfulPlanAndReplanMeeting() {
//        var validUser = DataGenerator2.Registration.generateUser("ru");
//        var daysToAddForFirstMeeting = 4;
//        var firstMeetingDate = DataGenerator2.generateDate(daysToAddForFirstMeeting);
//        var daysToAddForSecondMeeting = 7;
//        var secondMeetingDate = DataGenerator2.generateDate(daysToAddForSecondMeeting);
//     Для заполнения полей формы можно так же использовать пользователя validUser и строки с датами в переменных
//     firstMeetingDate и secondMeetingDate.
//    }

    @Test
    void shouldBookingACard() {

        String planningDate1 = DataGenerator.generateFirstDate();
        String planningDate2 = DataGenerator.generateSecondDate();

        $("[data-test-id='city']  input").setValue(DataGenerator.generateCity());
        $("[data-test-id='date']  input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date']  input").setValue(planningDate1);
        $("[data-test-id='name']  input").setValue(DataGenerator.generateName());
        $("[data-test-id='phone']  input").setValue(DataGenerator.generatePhone());
        $("[data-test-id='agreement']").click();
        $(".grid-col button[role='button']").click();

        $(withText("Успешно!")).shouldBe(visible);
        $(withText("Встреча успешно запланирована на")).shouldBe(visible);
        $(withText(planningDate1)).shouldBe(visible);
//      $(".notification__content").shouldBe(visible).shouldHave(exactText("Встреча успешно запланирована на " + planningDate1));

        $("[data-test-id='date']  input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date']  input").setValue(planningDate2);

        $(".grid-col button[role='button']").click();

        $(withText("У вас уже запланирована встреча на другую дату. Перепланировать?")).shouldBe(visible);
//      $("[data-test-id=replan-notification] .notification__content").shouldBe(visible).shouldHave(exactText("У вас " +
//              "уже запланирована встреча на другую дату. Перепланировать?"));

        $(".notification_status_error .button_view_extra").click();

        $(withText("Успешно!")).shouldBe(visible);
        $(withText("Встреча успешно запланирована на")).shouldBe(visible);
        $(withText(planningDate2)).shouldBe(visible);
//     $("[data-test-id='success-notification'] .notification__content").shouldBe(visible).shouldHave
//     (exactText("Встреча успешно забронирована на " + planningDate2));


    }

    
}
