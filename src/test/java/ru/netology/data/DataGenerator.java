package ru.netology.data;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Value;
import lombok.val;

import java.sql.ConnectionBuilder;
import java.util.Locale;

import static io.restassured.RestAssured.form;
import static io.restassured.RestAssured.given;

public class DataGenerator {
    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    private DataGenerator() {
    }

    private static void sendRequest(RegistrationDto user) {
        // TODO: отправить запрос на указанный в требованиях path, передав в body запроса объект user
        //  и не забудьте передать подготовленную спецификацию requestSpec.
        //  Пример реализации метода показан в условии к задаче.
        // сам запрос преобразован в JSON
        given() // "дано"
                .spec(requestSpec) // указываем, какую спецификацию используем
                .body(new RegistrationDto("vasya", "password", "active")); // передаём в теле объект, который будет


    }

    public static String getRandomLogin() {
        // TODO: добавить логику для объявления переменной login и задания её значения, для генерации
        //  случайного логина используйте faker
        Faker faker = new Faker(new Locale("en"));
        String login = faker.name().username();
        return login;
    }

    public static String getRandomPassword() {
        // TODO: добавить логику для объявления переменной password и задания её значения, для генерации
        //  случайного пароля используйте faker
        Faker faker = new Faker(new Locale("en"));
        Internet internet = null;
        String password = internet.password();
        return password;
    }

    public static class Registration {
        private Registration() {
        }

        public static RegistrationDto getUser(String status) {
//            // TODO: создать пользователя user используя методы getRandomLogin(), getRandomPassword() и параметр status
            RegistrationDto user = new RegistrationDto(getRandomLogin(), getRandomPassword(), status);
            return user;

        }

        public static RegistrationDto getRegisteredUser(String status) {
            // TODO: объявить переменную registeredUser и присвоить ей значение возвращённое getUser(status).
            // Послать запрос на регистрацию пользователя с помощью вызова sendRequest(registeredUser)
            RegistrationDto registeredUser = getUser(status);
            return registeredUser;
        }
    }

    @Value
    public static class RegistrationDto {
        String login;
        String password;
        String status;

        }
}