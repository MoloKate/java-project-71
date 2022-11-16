package hexlet.code;

import java.util.Objects;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static hexlet.code.ItemFromFiles.ADDED;
import static hexlet.code.ItemFromFiles.DELETED;
import static hexlet.code.ItemFromFiles.UNCHANGED;
import static hexlet.code.ItemFromFiles.CHANGED;

public class Differences {
    public static Map<String, ItemFromFiles> getDiff(
            Map<String, Object> dataFromFirstFile, Map<String, Object> dataFromSecondFile) {
        Map<String, ItemFromFiles> differ = new TreeMap<>();

        Set<String> allKeys= new TreeSet<>();
        allKeys.addAll(dataFromFirstFile.keySet());
        allKeys.addAll(dataFromSecondFile.keySet());
        for (String key : allKeys) {
            Object oldValue = dataFromFirstFile.get(key);
            Object newValue = dataFromSecondFile.get(key);

            if (!dataFromFirstFile.containsKey(key)) {
                differ.put(key, new ItemFromFiles(newValue, ADDED));
            } else if (!dataFromSecondFile.containsKey(key)) {
                differ.put(key, new ItemFromFiles(oldValue, DELETED));
            } else if (Objects.equals(oldValue, newValue)) {
                differ.put(key, new ItemFromFiles(oldValue, newValue, UNCHANGED));
            } else {
                differ.put(key, new ItemFromFiles(oldValue, newValue, CHANGED));
            }
        }
        return differ;
    }
}
