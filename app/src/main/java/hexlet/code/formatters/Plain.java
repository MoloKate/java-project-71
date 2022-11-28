package hexlet.code.formatters;

import hexlet.code.ItemFromFiles;
import java.util.List;
import java.util.Map;



public class Plain {
    public static String makeFilePlain(Map<String, ItemFromFiles> differ) throws Exception {

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, ItemFromFiles> item : differ.entrySet()) {

            String newValue = checkFileValue(item.getValue().getNewValue());
            String oldValue = checkFileValue(item.getValue().getOldValue());

            switch (item.getValue().getStatus()) {
                case added -> result.append("Property '").append(item.getKey())
                        .append("' was added with value: ").append(oldValue).append("\n");
                case deleted -> result.append("Property '").append(item.getKey())
                        .append("' was removed").append("\n");
                case changed -> result.append("Property '").append(item.getKey())
                        .append("' was updated. From ").append(oldValue)
                        .append(" to ").append(newValue).append("\n");
                case unchanged -> {
                }
                default -> throw new Exception("Incorrect status: '" + item.getValue().getStatus() + "'");
            }
        }
        return result.toString().trim();
    }
    public static String checkFileValue(Object value) {

        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value == null) {
            return null;
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }
    }
}
