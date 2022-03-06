import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.google.gson.reflect.TypeToken;

public class Arcesium {

    public static void main(String[] args) throws IOException {
        String url = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
        String output = callApi(url);
        Gson gson = new Gson();
        System.out.println(output);
        Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
        List<User> users = gson.fromJson(output, userListType);
        List<Integer> outputFinal = new ArrayList<>();

        String input1 = "username";
        String operation = "equals";
        String checker = "PrernaB";

        List<Function<User, Object>> getPropes = Arrays.asList(
                User::getUsername, User::getAddress,
                User::getCompany, User::getEmail,
                User::getId, User::getWebsite,
                User::getName, User::getCompany
        );
        List<Integer> outs = users.stream().filter(user -> getPropes.stream()
                        .map(f -> f.apply(user))
                        .anyMatch(checker::equals))
                .map(User::getId).collect(Collectors.toList());

        System.out.println(outs);
    }

    public static List<Integer> apiResponseParser(List<String> inputList, int size) {
        String url = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
        String urlResponse = "";
        try{
            urlResponse = callApi(url);
        } catch(Exception e){}
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
        List<User> users = gson.fromJson(urlResponse, userListType);
        List<Integer> output = new ArrayList<>();

        String input1 = inputList.get(0);
        String operation = inputList.get(1);
        String checker = inputList.get(2);
        String[] arr = checker.split(",");


        List<Function<User, Object>> getPropes = Arrays.asList(
                User::getUsername, User::getAddress,
                User::getCompany, User::getEmail,
                User::getId, User::getWebsite,
                User::getName, User::getCompany
        );
        List<Function<Address, Object>> getPropesAddress = Arrays.asList(
                Address::getCity
        );

        List<Function<Company, Object>> getPropesCompany = Arrays.asList(
                Company::getBasename, Company::getName
        );

        List<Integer> outs = new ArrayList<>();
        for(String element1 : arr){
            System.out.println(input1);
            System.out.println(element1);
            List<Integer> out = users.stream()
                    .filter(user -> getPropes.stream()
                            .map(f -> f.apply(user))
                            .anyMatch(element1::equals))

                    .map(User::getId).collect(Collectors.toList());

            if(out.size() == 0){
                out = users.stream()

                        .filter(user -> getPropesAddress.stream()
                                .map(f -> f.apply(user.getAddress()))
                                .anyMatch(element1::equals))


                        .map(User::getId).collect(Collectors.toList());
            }
            if(out.size() == 0){
                out = users.stream()

                        .filter(user -> getPropesCompany.stream()
                                .map(f -> f.apply(user.getCompany()))
                                .anyMatch(element1::equals))


                        .map(User::getId).collect(Collectors.toList());
            }
            outs.addAll(out);
        }
        List<Integer> tempOut = new ArrayList<>();
        tempOut.add(-1);
        return outs.size() > 0 ? outs : tempOut;

    }

    public static String callApi(String url) throws IOException {
        URL callURL = new URL(url);
        HttpURLConnection conn = (HttpURLConnection)callURL.openConnection();
        conn.setRequestMethod(("GET"));
        conn.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sbl = new StringBuilder();
        String input = br.readLine();


        while(input != null){
            sbl.append(input);
            input = br.readLine();
        }
        return sbl.toString();
    }

    public void filter(){

        String[] split = "abc.abc".split("\\.");

        List<Function<User, Object>> getPropes = Arrays.asList(
                User::getUsername, User::getAddress,
                User::getCompany, User::getEmail,
                User::getId, User::getWebsite,
                User::getName, User::getCompany
        );
        String[] values = new String[2];
        Gson gson = new Gson();
        String out = "";
        List<User> outList = gson.fromJson(out, ArrayList.class);
        //Type type = new TypeToken
        List<User> list = new ArrayList<>();
        List<Integer> out1 = list.stream().filter(user -> getPropes.stream()
                .map(f -> f.apply(user))
                .anyMatch(values::equals))
                .map(User::getId).collect(Collectors.toList());


    }

    public static Object getFromFilterList(String input){
        Map<String, Function<User, Object>> map = new HashMap<>();
        map.put("name", User::getName);
        map.put("username", User::getUsername);
        map.put("email", User::getEmail);
        map.put("website", User::getWebsite);
        if(map.containsKey(input))
            return map.get(input);

        Map<String, Function<Address, Object>> map1 = new HashMap<>();
        map1.put("address.street", Address::getStreet);
        map1.put("address.suite", Address::getSuite);
        map1.put("address.city", Address::getCity);
        map1.put("address.zipcode", Address::getZipcode);
        if(map1.containsKey(input))
            return map1.get(input);

        Map<String, Function<Company, Object>> map2 = new HashMap<>();
        map2.put("company.name", Company::getName);
        map2.put("company.basename", Company::getBasename);

        return map2.get(input);
    }

    static class User{
        private int id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private String website;
        private Company company;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public Company getCompany() {
            return company;
        }

        public void setCompany(Company company) {
            this.company = company;
        }
    }

    static class Address{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private GEO geo;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public GEO getGeo() {
            return geo;
        }

        public void setGeo(GEO geo) {
            this.geo = geo;
        }
    }

    static class Company {
        private  String name;
        private String basename;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBasename() {
            return basename;
        }

        public void setBasename(String basename) {
            this.basename = basename;
        }
    }

    static class GEO{
        private double lat;
        private double lng;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }
}
