package api.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.CustomAllureListener;

public class ApiSpecs {

    public static final String API_KEY_NAME = "x-api-key";
    public static final String API_KEY_VALUE = "reqres-free-v1";

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .addHeader(API_KEY_NAME, API_KEY_VALUE)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .addFilter(new CustomAllureListener())
                .build();
    }

    public static ResponseSpecification responseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .log(LogDetail.ALL)
                .build();
    }
}