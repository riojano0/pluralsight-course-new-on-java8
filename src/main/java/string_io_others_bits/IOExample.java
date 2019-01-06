package string_io_others_bits;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IOExample {

    public static void main(String[] args) {
        System.out.println("-- Lines");
        Path path = Paths.get("./","src", "main", "resources","people-example.txt");
        try(Stream<String> stream = Files.lines(path)){
            stream
                    .filter(line -> line.contains("Daniel"))
                    .findFirst()
                    .ifPresent(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-- List");
        Path path2 = Paths.get("./","src", "main", "java");
        try(Stream<Path> stream = Files.list(path2)){
            stream
                    .filter(pathOutput -> pathOutput.toFile().isDirectory())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Walk visit the whole subtree and you can define a limit of the depth
        System.out.println("-- Walk");
        Path path3 = Paths.get("./","src", "main", "java");
        try(Stream<Path> stream = Files.walk(path3, 2)){
            stream
                    .filter(pathOutput -> pathOutput.toFile().isDirectory())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
