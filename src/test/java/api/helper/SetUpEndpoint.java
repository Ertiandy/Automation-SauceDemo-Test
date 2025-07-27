package api.helper;

import api.request.Endpoint;
import org.apache.commons.lang3.RandomStringUtils;

public class SetUpEndpoint {
    private static SetUpEndpoint helperClass;
    private static String URL;

    //first time run api
    public static void setUpApi() {
        if (helperClass==null) {

            helperClass = new SetUpEndpoint();
        }
    }

    //get current state URL
    public static String getURL() {
        return URL;
    }

    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10); // Panjang email 10 karakter
        email = temp + "@testdata.com";
        return email.toLowerCase();
    }

    public static void prepareURL(String url) {
        System.out.println("Prepare URL : " + url);
        URL = "";
        switch (url) {
            case "GET_LIST_USERS" :
                URL = Endpoint.GET_LIST_USERS;
                break;
            case "GET_PROFILE_USER" :
                URL = Endpoint.GET_PROFILE_USER;
                break;
            case "CREATE_NEW_USER" :
                URL = Endpoint.CREATE_NEW_USER;
                break;
            case "UPDATE_USER" :
                URL = Endpoint.UPDATE_USER;
                break;
            case "DELETE_USER" :
                URL = Endpoint.DELETE_USER;
                break;
            case "GET_LIST_TAGS" :
                URL = Endpoint.GET_LIST_TAGS;
                break;
            default:
                System.out.println("Please Input Right URL : ");
        }

        if(!url.isBlank()){
            System.out.println("URL is : " + URL);
        }



    }
}
