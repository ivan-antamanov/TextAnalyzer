package TextAnalyzer;

import TextAnalyzer.Enum.CommandList;
import TextAnalyzer.Enum.EnumComListMap;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by iantaman on 26.09.2015.
 */
public class ConsoleCommands {


    private TextAnalyzerMethods textAnalyzerMethods;
    private String string;
    private Scanner scanner;


    public ConsoleCommands(TextAnalyzerMethods textAnalyzerMethods) {
        this.textAnalyzerMethods = textAnalyzerMethods;
        scanner = new Scanner(System.in);
        scanningProcessChoosen();
    }

    private void scanningProcessChoosen() {
        print("Enter the command for analyze text or text-file. (help)");
        try {
            switch (EnumComListMap.getStringEnumMap().get(scanner.nextLine())) {
                case ENTER_TEXT:
                    print("Enter the text");
                    toScanningCommand();
                    print("Enter the command");
                    process(scanner.nextLine());
                    break;
                case ENTER_FILE_PATH:
                    print("Enter the file path");
                    fileChose(scanner.nextLine());
                    break;
                case HELP:
                    help();
                    break;
                default:
                    throw new NumberFormatException();
            }
        } catch (Exception e) {
            System.out.println("Error!");
            scanningProcessChoosen();
        }
        scanningProcessChoosen();
    }

    private void fileChose(String filePath) {
        Path file = Paths.get(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(file);
            while ((string = bufferedReader.readLine()) != null) {
                stringBuilder.append(string);
                stringBuilder.append("\n");
            }
            bufferedReader.close();
            string = stringBuilder.toString();
            System.out.print(string);
            print("Successful scan");
            print("Enter the command");
            process(scanner.nextLine());
        } catch (FileNotFoundException e) {
            print("Non-correct file path");
            fileChose(scanner.nextLine());
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void process(String command) {
        print("Enter command:");
        if (EnumComListMap.getStringEnumMap().containsKey(command)) {
            switch (EnumComListMap.getStringEnumMap().get(command)) {
                case NUMBER_OF_WORDS:
                    textAnalyzerMethods.numbersOfWords(string);
                    break;
                case NUMBER_OF_SENTENCE:
                    textAnalyzerMethods.numberOfSentence(string);
                    break;
                case VOWELS_AND_CONSONANTS:
                    textAnalyzerMethods.consAndWow(string);
                    break;
                case TO_FIND_THE_WORD:
                    print("Write the word which u wanna find");
                    String find = scanner.nextLine();
                    textAnalyzerMethods.findWord(string, find);
                    break;
                case HELP:
                    help();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    print("Error! You have to enter digit such as those" + EnumComListMap.getStringEnumMap());
            }
        }
        process(scanner.nextLine());

    }

    private void toScanningCommand() {
        string = scanner.nextLine();
    }

    public void help() {
        print("This is \"text analyzer\" which can analyzing the text.\n" +
                "At first u have to choose how r u going to analyze text: from file or has entered in console.\n" +
                "After that u can choose methods to analyze\n" +
                "When the analyze has finished u may exit from applications");
        for (CommandList command : CommandList.values())
            System.out.println(command.toString());
    }

    public void print(String string) {
        System.out.println(string);
    }
}
