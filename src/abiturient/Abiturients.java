package abiturient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Abiturients {
    public static List<String> findFailed(String filename) throws IOException {
        Map<String, int[]> abiturients = new HashMap<>();
        List<String> failed = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (line == null) {
                return failed;
            }

            int n = Integer.parseInt(line.trim());

            for (int i = 0; i < n; i++) {
                line = reader.readLine();
                if (line == null) break;

                String[] parts = line.split(" ");
                if (parts.length >= 4) {
                    String surname = parts[0];
                    String name = parts[1];
                    int score1 = Integer.parseInt(parts[2]);
                    int score2 = Integer.parseInt(parts[3]);

                    String fullName = surname + " " + name;
                    abiturients.put(fullName, new int[]{score1, score2});

                    if (score1 < 30 || score2 < 30) {
                        failed.add(fullName);
                    }
                }
            }
        }

        return failed;
    }
}