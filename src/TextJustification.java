import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TextJustification {
    private int maxWidth;

    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int len = 20;

        System.out.println(textJustification.fullJustify(words, len));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        this.maxWidth = maxWidth;
        Queue<String> wordQueue = new LinkedList<>(Arrays.asList(words));
        int availability = maxWidth;
        List<String> result = new LinkedList<>();
        List<StringBuilder> wordList = new LinkedList<>();

        while (!wordQueue.isEmpty()) {
            if (wordQueue.peek().length() <= availability) {
                StringBuilder word = new StringBuilder().append(wordQueue.poll()).append(" ");
                wordList.add(word);
                availability -= word.length();
            } else {
                StringBuilder[] wordArray = wordList.toArray(new StringBuilder[0]);
                formatLine(wordArray, maxWidth - availability);
                result.add(getLine(wordArray));
                availability = maxWidth;
                wordList = new LinkedList<>();
            }
        }
        if (!wordList.isEmpty()) {
            result.add(formatLastLine(wordList.toArray(new StringBuilder[0]), maxWidth - availability));
        }
        return result;
    }

    private String formatLastLine(StringBuilder[] wordArray, int totalLength) {
        int length = wordArray.length;
        wordArray[length - 1].deleteCharAt(wordArray[length - 1].length() - 1);
        totalLength--;
        int paddingRequired = maxWidth - totalLength;
        for (int i = 0; i < paddingRequired; i++) {
            wordArray[length - 1].append(" ");
        }
        return getLine(wordArray);
    }

    private String getLine(StringBuilder[] wordArray) {
        StringBuilder sb = new StringBuilder();
        for (StringBuilder word : wordArray) {
            sb.append(word);
        }
        return sb.toString();
    }

    private void formatLine(StringBuilder[] wordArray, int totalLength) {
        int length = wordArray.length;
        wordArray[length - 1].deleteCharAt(wordArray[length - 1].length() - 1);
        totalLength--;
        int paddingRequired = maxWidth - totalLength;
        if (length == 1) {
            for (int i = 0; i < paddingRequired; i++) {
                wordArray[0].append(" ");
            }
        } else {
            int index = 0;
            for (int i = 0; i < paddingRequired; i++) {
                wordArray[index].append(" ");
                index = (index + 1) % (length - 1);
            }
        }
    }
}
