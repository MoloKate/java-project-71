package hexlet.code.formatters;

import hexlet.code.ItemFromFiles;
import java.util.Map;

public class Formatter {
    public static String getFileFormat(Map<String, ItemFromFiles> differ, String format) throws Exception {
        return switch (format) {

            case "plain" -> Plain.makeFilePlain(differ);
            case "json" -> Json.makeFileJson(differ);
            case "stylish" -> Stylish.makeFileStylish(differ);
            default -> throw new Exception("Formatting error exception");

        };
    }
}
