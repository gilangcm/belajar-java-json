package programmerzamannow.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JavaBeanTest {
    @Test
    void createJsonFromObject() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("gils");
        person.setHobbies(List.of("gaming","cooking"));

        Address address = new Address();
        address.setStreet("jalan belum jadi");
        address.setCity("bandung");
        address.setCountry("indonesia");
        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);

    }

    @Test
    void readObjectFromJson() throws JsonProcessingException {
        String json = """
                {"id":"1","name":"gils","hobbies":["gaming","cooking"],"address":{"street":"jalan belum jadi","city":"bandung","country":"indonesia"}}
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json,Person.class);

        Assertions.assertEquals("1",person.getId());
        Assertions.assertEquals("gils",person.getName());
        Assertions.assertEquals("jalan belum jadi",person.getAddress().getStreet());
    }
}
