package Java8Functions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestObjectMapper {

    static class Person {
        String name;
        String age;
        String address;
        String height;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public Person () {}
    }

    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person();
        person.setName("abc");
        person.setAddress("j-52");
        person.setAge("32");
        person.setHeight("6");

        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(person);
        System.out.println(value);
        ObjectMapper mapper1 = new ObjectMapper();

            Java8Functions.persons.Person person1 = mapper1.readValue(value, Java8Functions.persons.Person.class);
        System.out.println(person1);

    }

}
