import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class ConsonantProcessor {
    private static final Set<Character> VOICED_CONSONANTS = new HashSet<>(Arrays.asList(
            'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'
    ));

    public static List<Character> findConsonants(String filename) throws IOException {
        Map<Character, Integer> consonantCount = new TreeMap<>();
        Set<Character> consonantsInCurrentWord = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^а-яё\\s]", " ");
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    consonantsInCurrentWord.clear();

                    for (char c : word.toCharArray()) {
                        if (VOICED_CONSONANTS.contains(c)) {
                            consonantsInCurrentWord.add(c);
                        }
                    }

                    // Увеличиваем счетчик для каждой согласной в этом слове
                    for (char consonant : consonantsInCurrentWord) {
                        consonantCount.put(consonant, consonantCount.getOrDefault(consonant, 0) + 1);
                    }
                }
            }
        }

        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : consonantCount.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);

        return result;
    }
}