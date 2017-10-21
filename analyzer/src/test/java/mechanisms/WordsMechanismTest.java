package mechanisms;

//import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import reader.FileReader;

/**
 * Created by User on 21.10.2017.
 */
public class WordsMechanismTest {

    FileReader fileReader =new FileReader();
    String PATH_TO_FILE = "src/main/resources/TestBook.txt";


    @Test
    public void test10Method() throws IOException {
//        Files.lines(Paths.get(PATH_TO_FILE), Charset.forName("windows-1251"));
        String text = fileReader.readFile(PATH_TO_FILE);
        WordsMechanism wordsMechanism = new WordsMechanism();
        wordsMechanism.countTop10words(text);
    }
}