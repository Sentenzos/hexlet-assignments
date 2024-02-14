package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    String tagName;
    Map<String, String> attributes;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("<" + this.tagName);
        for (String key: this.attributes.keySet()) {
            stringBuilder.append(" ")
                    .append(key)
                    .append("=")
                    .append("\"")
                    .append(this.attributes.get(key))
                    .append("\"");
        }
        stringBuilder.append(">");

        return stringBuilder.toString();
    }
}
// END
