package session1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.*;
public class StreamsFromFile {
    public static void main(String[] args) {
        Path path = Paths.get("/Users/a206073/IdeaProjects/Collections_Streams/src/Names");
        try (Stream<String> lines = Files.lines(path);) {
            long count = lines.count();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
