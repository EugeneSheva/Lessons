package createDirectionFile;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.isDirectory;
import static java.nio.file.Files.isRegularFile;

public class Main {
    static Path path1 = Path.of("e:\\folder1\\folder2\\folder3");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Files.createDirectories(path1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Files.createFile(Path.of("e:\\folder1\\folder2\\folder3\\file1.txt"));
            Files.createFile(Path.of("e:\\folder1\\folder2\\folder3\\file2.txt"));
            Files.createFile(Path.of("e:\\folder1\\folder2\\folder3\\file3.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Введите название файля для поиска: ");
        String name = scanner.next();
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path1)) {
            for (Path path : files) {

                if (isRegularFile(path)) {
                    if (path.getFileName().toString().toLowerCase().contains(name.toLowerCase())) {
                        System.out.println(path + " ");
                    }

                }
            }
            }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}