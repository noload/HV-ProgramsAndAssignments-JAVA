import java.io.*;
import java.util.*;

public class TextFileAnalyzer {

    public static void main(String[] args) {
        String directoryPath = "F:\\New folder\\directory1\\directory2";
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Invalid directory path.");
            return;
        }

        List<File> txtFiles = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();
        long totalSize = 0;

        analyzeDirectory(directory, txtFiles, wordCount);
        
        // Display the list of .txt files
        System.out.println("List of .txt files:");
        for (File file : txtFiles) {
            System.out.println(file.getPath());
            totalSize += file.length();
        }

        System.out.println("Total size of .txt files: " + totalSize + " bytes");

        // Display the top 10 most frequent words
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        System.out.println("Top 10 most frequent words:");
        for (int i = 0; i < Math.min(10, sortedWords.size()); i++) {
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static void analyzeDirectory(File directory, List<File> txtFiles, Map<String, Integer> wordCount) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    analyzeDirectory(file, txtFiles, wordCount);
                } else if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                    txtFiles.add(file);
                    processTextFile(file, wordCount);
                }
            }
        }
    }

    private static void processTextFile(File file, Map<String, Integer> wordCount) {
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading file: " + file.getAbsolutePath());
        }
    }
}
