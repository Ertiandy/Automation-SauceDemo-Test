package api.request;

import api.scenario.Location;
import api.scenario.UserProfile;
import api.helper.SetUpEndpoint;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;


public class ApiTestProcess {
    public static void validationResponseData(Response currentRes, String data){
        System.out.println("check response data : " + data);
        File fileUsersJson = getJSONSchemaFile(data);
        currentRes.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(fileUsersJson));
    }

    private static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/resources/JSONSchemaData/" + JSONFile);
    }

    /*check status code response same with  status code expected*/
    public static void validationStatusCode(Response currentRes, int expectedStatusCode){
        System.out.println("check status code : " + expectedStatusCode);
        Assert.assertEquals(currentRes.getStatusCode(), expectedStatusCode);
    }

    public static UserProfile prepareDataUserTestPost() {
        UserProfile dataUser = new UserProfile();
        Location dataLocation   = new Location();

        // prepare data test user
        // information user
        String title        = "mr";
        String firstName    = "Ertiandy";
        String lastName     = "Waluyo";
        String picture      = "https://randomuser.me/api/portraits/med/men/95.jpg";
        String gender       = "male";
        String email        = SetUpEndpoint.generateRandomEmail(); // generate email
        String dateOfBirth  = "1993-04-09T02:31:57.367Z";
        String phone        = "080989999";

        dataUser.setTitle(title);
        dataUser.setFirstName(firstName);
        dataUser.setLastName(lastName);
        dataUser.setPicture(picture);
        dataUser.setGender(gender);
        dataUser.setEmail(email);
        dataUser.setDateOfBirth(dateOfBirth);
        dataUser.setPhone(phone);

        // location
        String street       = "Jalanin aja";
        String city         = "Depok";
        String state        = "Jawa Barat";
        String country      = "Indonesia";
        String timezone     = "+7:00";

        dataLocation.setStreet(street);
        dataLocation.setCity(city);
        dataLocation.setState(state);
        dataLocation.setCountry(country);
        dataLocation.setTimezone(timezone);
        dataUser.setLocation(dataLocation);

        return dataUser;
    }

    public static UserProfile prepareDataUserTestUpdate() {
        UserProfile dataUser = new UserProfile();
        Location dataLocation   = new Location();

        // prepare data test user
        // information user
        String title        = "mr";
        String firstName    = "Ertiandy";
        String lastName     = "Update User";
        String picture      = "https://randomuser.me/api/portraits/med/men/95.jpg";
        String gender       = "male";
        String dateOfBirth  = "1993-04-09T02:31:57.367Z";
        String phone        = "080989999";

        dataUser.setTitle(title);
        dataUser.setFirstName(firstName);
        dataUser.setLastName(lastName);
        dataUser.setPicture(picture);
        dataUser.setGender(gender);
        dataUser.setDateOfBirth(dateOfBirth);
        dataUser.setPhone(phone);

        // location
        String street       = "Jalan jalan";
        String city         = "Jakarta Pusat";
        String state        = "Jakarta";
        String country      = "Indonesia";
        String timezone     = "+7:00";

        dataLocation.setStreet(street);
        dataLocation.setCity(city);
        dataLocation.setState(state);
        dataLocation.setCountry(country);
        dataLocation.setTimezone(timezone);
        dataUser.setLocation(dataLocation);

        return dataUser;
    }
}
