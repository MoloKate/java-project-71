package hexlet.code.formatters;

import hexlet.code.ItemFromFiles;

import java.util.Map;


public class Stylish {

    public static String makeFileStylish(Map<String, ItemFromFiles> differ) throws Exception {

        StringBuilder result = new StringBuilder();

        result.append("{");
        for (Map.Entry<String, ItemFromFiles> item : differ.entrySet()) {
            result.append("\n").append(" ".repeat(2));
            switch (item.getValue().getStatus()) {
                case added:
                    result.append("+").append(" ")
                            .append(item.getKey()).append(": ").append(item.getValue().getOldValue());
                    break;
                case deleted:
                    result.append("-").append(" ")
                            .append(item.getKey()).append(": ").append(item.getValue().getOldValue());
                    break;
                case changed:
                    result.append("-").append(" ")
                            .append(item.getKey()).append(": ").append(item.getValue().getOldValue());
                    result.append("\n").append(" ".repeat(2)).append("+").append(" ")
                            .append(item.getKey()).append(": ").append(item.getValue().getNewValue());
                    break;
                case unchanged:
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
