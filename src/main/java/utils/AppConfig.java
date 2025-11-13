package utils;

public final class AppConfig {

    public static final String BASE_URL = "https://fasttrackit.org";
    public static final String LOGIN_URL = BASE_URL + "/account";
    public static final String CART_URL = BASE_URL + "/cart";
    public static final String CHECKOUT_URL = BASE_URL + "/checkout";
    public static final String DEFAULT_USERNAME = "testautomation@fasttrackit.org";
    public static final String DEFAULT_PASSWORD = "FastTrack123!";
    public static final int DEFAULT_TIMEOUT = 15;

    private AppConfig() {
    }
}
