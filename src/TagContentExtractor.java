import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TagContentExtractor {

    // Not working with regex here since HTML is context free!
    // RegEx would be WAY
    public static String extract(final String input) {
        List<String> openTags = new ArrayList<>();
        List<String> closingTags = new ArrayList<>();
        List<String> textTokens = new ArrayList<>();

        String in = input.trim();

        while (!in.isEmpty()) {
            in = readTags(in, openTags);
            in = readText(in, textTokens);
            in = readClosingTags(in, closingTags);
            closingTags.sort(Collections.reverseOrder());
            closingTags = closingTags.stream()
                    .map(tag -> tag.replace("/", ""))
                    .collect(Collectors.toList());
            if (!openTags.equals(closingTags)) {
                return "None";
            }
        }

        return String.join("\n", textTokens);
    }

    private static String readText(String in, List<String> tokens) {
        tokens.add(in.substring(0, in.indexOf('<')));
        return in.substring(in.indexOf('<'));
    }

    private static String readTags(String in, List<String> tags) {
        while (in.length() >= 1 && in.charAt(0) == '<') {
            int close = in.indexOf('>');
            tags.add(in.substring(in.indexOf('<'), close + 1));
            in = in.substring(close + 1);
        }
        return in;
    }

    private static String readClosingTags(String in, List<String> tags) {
        while (in.length() >= 1 && in.startsWith("</")) {
            int open = in.indexOf("</");
            int close = in.indexOf('>');
            tags.add(in.substring(open, close + 1));
            in = in.substring(close + 1);
        }
        return in;
    }
}
