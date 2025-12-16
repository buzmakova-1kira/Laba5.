package processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ConsonantProcessor {
    private static final Set<Character> VOICED = Set.of('б','в','г','д','ж','з','й','л','м','н','р');

    public static List<Character> findConsonants(String filename) throws IOException {
        Set<Character> seenOnce = new HashSet<>();
        Set<Character> seenMultiple = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^а-яё\\s]", " ")
                        .split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    Set<Character> inWord = new HashSet<>();
                    for (char c : word.toCharArray()) {
                        if (VOICED.contains(c)) inWord.add(c);
                    }

                    for (char c : inWord) {
                        if (seenOnce.contains(c)) {
                            seenMultiple.add(c);
                        } else {
                            seenOnce.add(c);
                        }
                    }
                }
            }
        }

        List<Character> result = new ArrayList<>(seenMultiple);
        Collections.sort(result);
        return result;
    }
}