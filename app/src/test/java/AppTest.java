import hexlet.code.Differ;
import hexlet.code.UtilsForFiles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.skyscreamer.jsonassert.JSONAssert;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;
    private  final String pathToDirectory = "app/src/test/resources/";
    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }
    private static Path getPath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }
    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("cheking_json1.json");
        resultPlain = readFixture("cheking_plain.txt");
        resultStylish = readFixture("cheking_stylish.txt");
    }
    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateTest(String format) throws Exception {
        String filePath1 = getPath("file1Test." + format).toString();
        String filePath2 = getPath("file2Test." + format).toString();

        assertEquals(resultStylish, Differ.generate(filePath1, filePath2));
        assertEquals(resultStylish, Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals(resultPlain, Differ.generate(filePath1, filePath2, "plain"));

        String actualJson = Differ.generate(filePath1, filePath2, "json");
        JSONAssert.assertEquals(resultJson, actualJson, false);
    }

    @Test
    public void testGetDataFormatYml() {
        var filePath1 = pathToDirectory + "file1Test.yml";
        String actual = UtilsForFiles.getDataFormat(filePath1);
        String expected = "yml";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testGetDataFormatJson() {
        var filePath1 = pathToDirectory + "file1Test.json";
        String actual = UtilsForFiles.getDataFormat(filePath1);
        String expected = "json";
        assertThat(actual).isEqualTo(expected);
    }
}
