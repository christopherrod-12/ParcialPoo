import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class MorseConverter {
    private final Map<Character, String> map = new HashMap<>();
    private final Map<String, Character> rev = new HashMap<>();

    public MorseConverter() {
        String[][] pairs = {
                {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."},
                {"E", "."}, {"F", "..-."}, {"G", "--."}, {"H", "...."},
                {"I", ".."}, {"J", ".---"}, {"K", "-.-"}, {"L", ".-.."},
                {"M", "--"}, {"N", "-."}, {"O", "---"}, {"P", ".--."},
                {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"},
                {"Y", "-.--"}, {"Z", "--.."},
                {"1", ".----"}, {"2", "..---"}, {"3", "...--"}, {"4", "....-"},
                {"5", "....."}, {"6", "-...."}, {"7", "--..."}, {"8", "---.."},
                {"9", "----."}, {"0", "-----"},
                {".", ".-.-.-"}, {",", "--..--"}, {"?", "..--.."}, {"!", "-.-.--"},
                {" ", "/"}
        };
        for (String[] p : pairs) {
            char c = p[0].charAt(0);
            map.put(c, p[1]);
            rev.put(p[1], c);
        }
    }

    public String textToMorse(String text) {
        StringJoiner sj = new StringJoiner(" ");
        for (char c : text.toUpperCase().toCharArray()) {
            sj.add(map.getOrDefault(c, ""));
        }
        return sj.toString().replaceAll("\\s+", " ").trim();
    }

    public String morseToText(String morse) {
        StringBuilder sb = new StringBuilder();
        String[] parts = morse.trim().split(" ");
        for (String token : parts) {
            if (token.equals("/")) {
                sb.append(' ');
            } else {
                Character ch = rev.get(token);
                sb.append(ch == null ? '?' : ch);
            }
        }
        return sb.toString();
    }
}
