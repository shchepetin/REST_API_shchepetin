package utils;

import io.qameta.allure.restassured.AllureRestAssured;

public class CustomAllureListener extends AllureRestAssured {
    public CustomAllureListener() {
        super()
                .setRequestTemplate("allure-templates/request.ftl")
                .setResponseTemplate("allure-templates/response.ftl");
    }
}
