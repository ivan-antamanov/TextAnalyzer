package main.java.TextAnalyzer.impl.service_tool;

import main.java.TextAnalyzer.impl.scanner_adapter.ScannerForUser;
import main.java.TextAnalyzer.impl.utility.CommandList;
import main.java.TextAnalyzer.impl.utility.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static main.java.TextAnalyzer.impl.utility.CommandList.*;

/**
 * Created by iantaman on 26.09.2015.2
 */
public class ConsoleCommands {

    private Context userContext;
    private ScannerForUser scannerInputText;

    public ConsoleCommands(ScannerForUser scannerInputText) {
        this.scannerInputText = scannerInputText;
        userContext = new Context();
    }

    public boolean scanningProcess() {
        System.out.println("Enter the command please");
        String command = scannerInputText.nextLine();

        if (getStringEnumMap().containsKey(command)) {
            switch (getStringEnumMap().get(command)) {

                case TEXT_MODE:
                    print("Enter the text, please");
                    if (userContext.readInputText()) return true;

                    break;

                case FILE_MODE:
                    print("Enter the file path");
                    if (userContext.readFilePath()) return true;
                    fileChose(userContext.getFilePath());
                    break;

                case NUMBER_OF_WORDS:
                    TextAnalyzerUtils.numbersOfWords(userContext.getInputText());
                    break;

                case NUMBER_OF_SENTENCE:
                    TextAnalyzerUtils.numberOfSentence(userContext.getInputText());
                    break;

                case VOWELS_AND_CONSONANTS:
                    TextAnalyzerUtils.consAndWow(userContext.getInputText());
                    break;

                case TO_FIND_THE_WORD:
                    print("Write the word which u wanna find");
                    String searchWord = scannerInputText.nextLine();
                    TextAnalyzerUtils.findWord(userContext.getInputText(), searchWord);
                    break;

                case NUMBER_OF_SYMBOLS:
                    TextAnalyzerUtils.numberOfSymbols(userContext.getInputText());
                    break;

                case HELP:
                    help();
                    break;

                case EXIT:
                    System.out.println("Bay!");
                    return true;

                default:
                    System.out.println("This command has not included into processing command list yet");
            }

        } else {
            System.out.println("Wrong command");
        }

        return scanningProcess();
    }

    private void fileChose(String filePath) {
        Path file = Paths.get(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(nextLine);
                stringBuilder.append("\n");
            }
            userContext.readInputText(stringBuilder.toString());
            System.out.print(userContext.getInputText());
            print("Successful scan");
        } catch (FileNotFoundException e) {
            print("Non-correct file path");
            userContext.readFilePath();
        } catch (IOException e) {
            print("Can't scanning file! Please check file settings and entering the correct file directory:");
            userContext.readFilePath();
        } catch (Exception e) {
            print("Something going wrong. Please try again");
        }

    }

    boolean checkExit() {
        return (userContext.getFilePath().equals("exit") | userContext.getFilePath().equals("exit"));

    }

    public void help() {
        print("This is \"text analyzer\" which can analyzing the text.\n" +
                "At first u have to choose how r u going to analyze text: from file or has entered in console.\n" +
                "After that u can choose methods to analyze\n" +
                "When the analyze has finished u may exit from applications\n" +
                "If u already had choose variable of text, please, don't enter this command: ett, efp");
        for (CommandList command : CommandList.values())
            System.out.println(command.toString());
    }

    public void print(String string) {
        System.out.println(string);
    }


}
