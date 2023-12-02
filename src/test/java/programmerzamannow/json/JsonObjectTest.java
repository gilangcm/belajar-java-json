package programmerzamannow.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonObjectTest {
    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstname", "diva",
                "lastname", "maulana",
                "age", 18,
                "married", false,
                "address",Map.of(
                        "street","jalan belum ada",
                        "city", "jakarta",
                        "country", "indonesia"
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void readJson() throws JsonProcessingException {
        String json = """
                {
                  "age": 18,
                  "married": false,
                  "lastname": "maulana",
                  "address": {
                    "street": "jalan belum ada",
                    "country": "indonesia",
                    "city": "jakarta"
                               },
                  "firstname": "diva"
                }""";

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        Assertions.assertEquals("diva", person.get("firstname"));
        Assertions.assertEquals("maulana", person.get("lastname"));
    }
}
