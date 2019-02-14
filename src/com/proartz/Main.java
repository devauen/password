package com.proartz;

import java.io.Console;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Console console = System.console();
        if(console == null) {
            System.err.println("No console");
            System.exit(1);
        }

        String login = console.readLine("Enter your login: ");
        char[] oldPassword = console.readPassword("Enter old password: ");

        if(verify(login, oldPassword)) {
            boolean noMatch = true;

            do {
                char[] newPassword1 = console.readPassword("Enter new password: ");
                char[] newPassword2 = console.readPassword("Re-Enter new password: ");

                noMatch = !Arrays.equals(newPassword1, newPassword2);
                if(noMatch) {
                    console.format("Passwords don't match, please try again.%n");
                } else {
                    change(login, newPassword1);
                    console.format("Password for %s changed.%n", login);
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            }while(noMatch);
        }
        Arrays.fill(oldPassword, ' ');
    }

    public static boolean verify(String login, char[] password) {
        return true;
    }

    public static void change(String login, char[] password) {

    }
}
