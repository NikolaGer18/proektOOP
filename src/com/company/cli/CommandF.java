package com.company.cli;

public class CommandF {
    public static Command receiveCommand(String command) {
        switch (command.toLowerCase()) {
            case "close":
                return new Close();
            default:
                System.out.println("Bad command. Try again or use help.");
                return null;
        }

}