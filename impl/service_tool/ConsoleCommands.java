package main.java.TextAnalyzer.impl.service_tool;

import main.java.TextAnalyzer.impl.scanner_adapter.ScannerForUser;
import main.java.TextAnalyzer.impl.utility.CommandList;
import main.java.TextAnalyzer.impl.utility.Text;

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

    private Text userInputTextAndPath;
    private ScannerForUser scannerInputText;

    public ConsoleCommands(ScannerForUser scannerInputText) {
        this.scannerInputText = scannerInputText;
        userInputTextAndPath = new Text();
    }

    public boolean scanningProcess() {
        System.out.println("Enter the command please");
        String command = scannerInputText.nextLine();
        try {
            if (getStringEnumMap().containsKey(command)) {
                switch (getStringEnumMap().get(command)) {
//
                    case TEXT_MODEL:
                        print("Enter the text, please");
                        readUserInputText();
                        if (userInputTextAndPath.getInputText().equals("exit")) {
                            System.out.println("Bay!");
                            return true;
                        }
                        break;

                    case FILE_MODEL:
                        print("Enter the file path");
                        readUserFilePath();
                        if (userInputTextAndPath.getFilePath().equals("exit")) {
                            System.out.println("Bay!");
                            return true;
                        }
                        break;

                    case NUMBER_OF_WORDS:
                        TextAnalyzerUtils.numbersOfWords(userInputTextAndPath.getInputText());
                        break;

                    case NUMBER_OF_SENTENCE:
                        TextAnalyzerUtils.numberOfSentence(userInputTextAndPath.getInputText());
                        break;

                    case VOWELS_AND_CONSONANTS:
                        TextAnalyzerUtils.consAndWow(userInputTextAndPath.getInputText());
                        break;

                    case TO_FIND_THE_WORD:
                        print("Write the word which u wanna find");
                        String searchWord = scannerInputText.nextLine();
                        TextAnalyzerUtils.findWord(userInputTextAndPath.getInputText(), searchWord);
                        break;

                    case NUMBER_OF_SYMBOLS:
                        TextAnalyzerUtils.numberOfSymbols(userInputTextAndPath.getInputText());
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
        } catch (NullPointerException e) {
            System.out.println("At first, u should enter the text");
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

            userInputTextAndPath.setInputText(stringBuilder.toString());
            System.out.print(userInputTextAndPath);
            print("Successful scan");
            print("Enter the command");

//            scanningProcess();
        } catch (FileNotFoundException e) {
            print("Non-correct file path");
            readUserFilePath();
        } catch (IOException e) {
            print("Can't scanning file! Please check file settings and entering the correct file directory:");
            readUserFilePath();
        } catch (Exception e) {
            print("Something going wrong. Please try again");
        }
//        return scanningProcess();
    }

    private void readUserFilePath() {
        userInputTextAndPath.setFilePath(scannerInputText.nextLine());
        fileChose(userInputTextAndPath.getFilePath());
    }


    private void readUserInputText() {
        userInputTextAndPath.setInputText(scannerInputText.nextLine());
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
