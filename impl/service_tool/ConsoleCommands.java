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

        CommandList enumCommand = getStringEnumMap().get(command);
        if (enumCommand != null) {
            switch (enumCommand) {

                case TEXT_MODE:
                case FILE_MODE:
                    if (readContext(enumCommand)) {
                        return true;
                    }
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
                    System.out.println("Write the word which u wanna find");
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
            System.out.println("The are incorrect command (help)");
        }

        return scanningProcess();
    }

    private boolean readContext(CommandList command) {
        System.out.println(command.getDescription());
        String inputText = scannerInputText.nextLine();
        if ((EXIT.getShortCommand()).equals(inputText)) {
            System.out.println("Bay");
            return true;
        }
        switch (command) {
            case TEXT_MODE:
                userContext.setInputText(inputText);
                break;
            case FILE_MODE:
                readFile(inputText);
                break;
        }
        return false;
    }

    private void readFile(String filePath) {
        Path file = Paths.get(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            String nextLine;
            while ((nextLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(nextLine);
                stringBuilder.append("\n");
            }
            userContext.setInputText(stringBuilder.toString());
            System.out.print(userContext.getInputText());
            System.out.println("Successful scan");
        } catch (FileNotFoundException e) {
            System.out.println("Non-correct file path");
            readFile(scannerInputText.nextLine());
        } catch (IOException e) {
            System.out.println("Can't scanning file! Please check file settings and entering the correct file directory:");
            readFile(scannerInputText.nextLine());
        } catch (Exception e) {
            System.out.println("Something going wrong. Please try again");
        }

    }

    private void help() {
        System.out.println("This is \"text analyzer\" which can analyzing the text.\n" +
                "At first u have to choose how r u going to analyze text: from file or has entered in console.\n" +
                "After that u can choose methods to analyze\n" +
                "When the analyze has finished u may exit from applications\n" +
                "If u already had choose variable of text, please, don't enter this command: ett, efp");
        for (CommandList command : CommandList.values())
            System.out.println(command.toString());
    }

}
