package ru.netology.web.data;

import com.github.javafaker.Faker;
import ru.netology.web.test.Cities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    private DataGenerator() {
    }

    public static String generateFirstDate() {
        String date = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateSecondDate() {
        String date = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity() {
        // с помощью Faker, либо используя массив валидных городов и класс Random
        String city = Cities.getRandomCity();
        return city;
    }

    public static String generateName() {
        Faker faker = new Faker(new Locale("RU"));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone() {
        Faker faker = new Faker(new Locale("RU"));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

//    public static class Registration {
//        private Registration() {
//        }

//        public static UserInfo generateUser(String locale) {
//            // TODO: добавить логику для создания пользователя user с использованием методов
//             generateCity(locale),
//            generateName(locale),
//            generatePhone(locale)
//            return user;
//        }
//    }

//        @Value
//        public static class UserInfo {
//            String city;
//            String name;
//            String phone;
//        }

}