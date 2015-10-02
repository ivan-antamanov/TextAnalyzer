package TextAnalyzer;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.Scanner;

/**
 * Created by iantaman on 26.09.2015.
 */
public class Command {

    private TextAnalyzer textAnalyzer;
    private String string;
    private Scanner scanner;


    public Command(TextAnalyzer textAnalyzer) {
        this.textAnalyzer = textAnalyzer;
        scanner= new Scanner(System.in);
        commandChoosen();
    }

    private void fileChose(){
        System.out.println("Enter file path like: C:\\Users\\iantaman\\Desktop\\new 1.txt");
        String path = scanner.nextLine();
        File file = new File(path);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((string =bufferedReader.readLine()) !=null){
                stringBuilder.append(string);
                stringBuilder.append("\n");
            }
//            try {
//                bufferedReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            string =stringBuilder.toString();
            System.out.println(string);
            digitChose();
        } catch (FileNotFoundException e) {
            System.out.println("Non-correct file path");
            fileChose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void commandChoosen(){
        System.out.println("Chose the variant of scan:\n 1.Read entered text; \n 2.Read file.");
        try {int i = Integer.valueOf(scanner.nextLine());
            switch (i){
                case 1: digitChose();break;
                case 2: fileChose();break;
                default: System.out.println("Error! You have to enter digit such as those above");
                    break;
            }
        }catch (NumberFormatException e) {
           System.out.println("Error! U have not entered digit");
            commandChoosen();
        }

    }

    private void textChosee(){
        System.out.println("Enter the text, please");
        string =scanner.nextLine();
        digitChose();
    }

    private void digitChose(){
        String choice = "Choose the command (enter only number of command without any symbols: \n";
        System.out.println(choice + CommandList.getCommandList());

        String digit = scanner.nextLine();

            try{
                int i = 0;
                i = Integer.parseInt(digit);//

                switch (i){
                    case 1: textAnalyzer.wordsNumbers(string);break;
                    case 2: textAnalyzer.sentenceNumbers(string);break;
                    case 3: textAnalyzer.symbolanalyz(string); break;
                    case 4:
                        System.out.println("White the word which u wanna find");
                        String find =scanner.nextLine();
                        textAnalyzer.wordFinder(string,find); break;
                    case 5: System.exit(0); break; /*cycle; */
                    default: System.out.println("Error! You have to enter digit such as those above");
                }
            } catch (Exception e){
                System.out.println("Error! U have not entered digit");
//                e.printStackTrace();
            }

            digitChose();
        }
    }



//}
