package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
public class UtilsForFiles {
    public static final String JSON = "json";
    public static final String YML = "yml";
    public static final String YAML = "yaml";
    public static String readFromFile(String pathToFile) throws Exception {
        File file = new File(pathToFile);
        String absolutePath = file.getAbsolutePath();
        Path pathFile = Path.of(absolutePath);
        String content = Files.readString(pathFile);
        return content;
    }
    public static String getDataFormat(String pathToFile) {
        int index = pathToFile.lastIndexOf('.');
        return index > 0 ? pathToFile.substring(index + 1) : "";
    }
}
