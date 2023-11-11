import com.company.cli.Command;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.company.cli.CommandF;
public class ConsoleBitmapEditor {

    private static List<String> currentSessionImages = new ArrayList<>();
    private static int currentSessionNumber = 1;

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, Exception {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome");
        ;
        System.out.println("Input open <file> down below!");
        while (true) {
            System.out.print(">");
            String userInput = scanner.nextLine();
            String[] splitInput = userInput.split(" ");
            String commandName = splitInput[0];
            String[] commandArgs = new String[splitInput.length - 1];
            System.arraycopy(splitInput, 1, commandArgs, 0, commandArgs.length);
            if (commandArgs.length == 0) {
                commandArgs = new String[]{""};
            }
            Command command = CommandF.receiveCommand(commandName);
            if (command != null) {
                command.execute(commandArgs);
            } else {
                System.out.println("Bad command. Try again or use help.");
            }
        }
    }
}
