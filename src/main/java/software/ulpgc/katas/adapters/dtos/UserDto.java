package software.ulpgc.katas.adapters.dtos;

public class UserDto {
    public String gender;
    public Name name;
    public Location location;
    public String email;
    public Login login;
    public Dob dob;
    public Registered registered;
    public String phone;
    public String cell;
    public Id id;
    public Picture picture;
    public String nat;

    public static class Name {
        public String title;
        public String first;
        public String last;
    }

    public static class Location {
        public Street street;
        public String city;
        public String state;
        public String country;
        public String postcode;
        public Coordinates coordinates;
        public Timezone timezone;
    }

    public static class Street {
        public int number;
        public String name;
    }

    public static class Coordinates {
        public String latitude;
        public String longitude;
    }

    public static class Timezone {
        public String offset;
        public String description;
    }

    public static class Login {
        public String uuid;
        public String username;
        public String password;
        public String salt;
        public String md5;
        public String sha1;
        public String sha256;
    }

    public static class Dob {
        public int age;
        public String date;
    }

    public static class Registered {
        public int age;
        public String date;
    }

    public static class Id {
        public String name;
        public String value;
    }

    public static class Picture {
        public String large;
        public String medium;
        public String thumbnail;
    }
}
