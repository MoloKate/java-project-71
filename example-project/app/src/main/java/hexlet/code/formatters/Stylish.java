package hexlet.code.formatters;

import hexlet.code.ItemFromFiles;
import java.util.Map;

import static hexlet.code.ItemFromFiles.ADDED;
import static hexlet.code.ItemFromFiles.DELETED;
import static hexlet.code.ItemFromFiles.CHANGED;
import static hexlet.code.ItemFromFiles.UNCHANGED;

public class Stylish {

    public static String makeFileStylish(Map<String, ItemFromFiles> differ) throws Exception {

        StringBuilder result = new StringBuilder();

        result.append("{");
        for (Map.Entry<String, ItemFromFiles> item : differ.entrySet()) {
            result.append("\n").append(" ".repeat(2));
            switch (item.getValue().getStatus()) {
                case ADDED:
                    result.append("+").append(" ")
                            .append(item.getKey()).append(": ").append(item.getValue().getOldValue());
                    break;
                case DELETED:
                    result.append("-").append(" ")
                            .append(item.getKey()).append(": ").append(item.getValue().getOldValue());
                    break;
                case CHANGED:
                    result.append("-").append(" ")
                            .append(item.getKey()).append(": ").append(item.getValue().getOldValue());
                    result.append("\n").append(" ".repeat(2)).append("+").append(" ")
                            .append(item.getKey()).append(": ").append(item.getValue().getNewValue());
                    break;
                case UNCHANGED:
                    result.append(" ".repeat(2))
                            .append(item.getKey()).append(": ").append(item.getValue().getOldValue());
                    break;
                default:
                    throw new Exception("Incorrect status: '" + item.getValue().getStatus() + "'");
            }
        }
        return result.append("\n}").toString();
    }
}
