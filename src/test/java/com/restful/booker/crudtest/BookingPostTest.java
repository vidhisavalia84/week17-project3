package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingPostTest extends TestBase {

    @Test
    public void setAuth(){
        BookingPojo bookingPojo = new BookingPojo();

        bookingPojo.setUserName("admin");
        bookingPojo.setPassword("password123");

        Response response = given().log().all()

                .headers("Content-Type", "application/json")
                .headers("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .headers("Cookie","token=abc123")
                .body(bookingPojo)
                .when()
                .post("/auth");
        response.then().statusCode(200);
        response.prettyPrint();

    }



    @Test
    public void bookRequest() {


        HashMap<String, String> dates = new HashMap();
        dates.put("checkin", "2023-02-23");
        dates.put("checkout", "2023-04-24");

       BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstName("Krishnaben");
        bookingPojo.setLastName("Patel");
        bookingPojo.setTotalPrice(112);
        bookingPojo.setDepositPaid(true);
        bookingPojo.setBookingDates(dates);
        bookingPojo.setAdditionalNeeds("Vegetarian");
       // bookingPojo.setUserName("admin");
      //  bookingPojo.setPassword("password123");
        Response response = given().log().all()

                .headers("Content-Type", "application/json")
               // .headers("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .headers("Cookie","token=abc123")
                //.auth().preemptive().basic("admin", "password123")
               //  .authorization("basic auth")
               // . authorization("Username","admin")
                //.authorization("Password","password123")
                .when()
                .body(bookingPojo)
                .post("/booking");

        response.then().statusCode(200);
        response.prettyPrint();
    }

}
