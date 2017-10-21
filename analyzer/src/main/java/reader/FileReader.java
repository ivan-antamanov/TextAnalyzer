package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    public String readFile(String filePath) throws IOException {
        Path file = Paths.get(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(nextLine);
                stringBuilder.append("\n");
            }
            System.out.println("Successful scan");
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            System.out.println("Non-correct file path");
            throw e;
        } catch (IOException e) {
            System.out.println("Can't scanning file! Please check file settings and entering the correct file directory:");
            throw e;
        } catch (Exception e) {
            System.out.println("Something going wrong. Please try again");
            throw e;
        }
    }

}
