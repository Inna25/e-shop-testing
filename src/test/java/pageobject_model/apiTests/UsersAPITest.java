package pageobject_model.apiTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;

public class UsersAPITest {
    String endpoint = "https://jsonplaceholder.typicode.com/users";

    @Test
    public void verifyStatusCodeTest() {

        given().
        when().get(endpoint).
        then().
           assertThat().
           statusCode(200);
    }
    @Test
    public void verifyResponseHeader(){
        given().
        when().
           get(endpoint).
        then().
           assertThat().
           header("Content-Type", is(not(nullValue()))).
           header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void verifyNumberOfUsersInResponse(){
        given().
        when().
           get(endpoint).
        then().
           assertThat().
           body("user.size()", equalTo(10));
    }
}
