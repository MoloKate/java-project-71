package hexlet.code;

import hexlet.code.formatters.Formatter;
import java.util.Map;

public class Differ {
    public static String generate(String firstFilePath, String secondFilePath, String formatFile) throws Exception {
        String contentFromFirstFile = UtilsForFiles.readFromFile(firstFilePath);
        String contentFromSecondFile = UtilsForFiles.readFromFile(secondFilePath);

        String dataFormatOfFirstFile = UtilsForFiles.getDataFormat(firstFilePath);
        String dataFormatOfSecondFile = UtilsForFiles.getDataFormat(secondFilePath);

        Map<String, Object> data1 = Parser.getData(contentFromFirstFile, dataFormatOfFirstFile);
        Map<String, Object> data2 = Parser.getData(contentFromSecondFile, dataFormatOfSecondFile);

        Map<String, ItemFromFiles> differ = Differences.getDiff(data1, data2);
        return Formatter.getFileFormat(differ, formatFile);
    }

    public static String generate(String firstFilePath, String secondFilePath) throws Exception {
        return generate(firstFilePath, secondFilePath, "stylish");
    }
}

