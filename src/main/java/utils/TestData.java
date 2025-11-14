package utils;

public final class TestData {

    public static final String DEFAULT_SEARCH_KEYWORD = "course";

    private TestData() {
    }

    public static BillingInfo defaultBillingInfo() {
        return new BillingInfo(
                "Jane",
                "Doe",
                "FastTrackit Way 42",
                "Cluj-Napoca",
                "400000",
                "Romania",
                "0712345678",
                AppConfig.DEFAULT_USERNAME
        );
    }

    public static final class BillingInfo {
        private final String firstName;
        private final String lastName;
        private final String address;
        private final String city;
        private final String postalCode;
        private final String country;
        private final String phone;
        private final String email;

        public BillingInfo(String firstName, String lastName, String address,
                           String city, String postalCode, String country,
                           String phone, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.postalCode = postalCode;
            this.country = country;
            this.phone = phone;
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public String getCountry() {
            return country;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }
    }
}
