package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.ItemFromFiles;
import java.util.Map;

public class Json {
    public static String makeFileJson(Map<String, ItemFromFiles> differ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(differ);
        return result;
    }
}


