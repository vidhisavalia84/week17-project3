package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BookingGetTest extends TestBase {

    @Test
    public void getAllBooking(){
        Response response=given()
                .when()
                .get("/Booking");
        response.then().statusCode(200);
        response.prettyPrint();

    }
@Test
    public void getSingleBooking(){
        Response response=given()
                //.pathParam("booking",54)
                .when()
                .get("/booking/88");
        response.then().statusCode(200);
        response.prettyPrint();
}

}
