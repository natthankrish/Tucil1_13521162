import app.*;
import java.util.Scanner;

public class Main {    
    public static void main (String[] args) {
        App executable = new App();
        boolean choicevalid = true;
        Scanner inputTray = new Scanner(System.in);

        System.out.println("\'24\' Card Game Solver");
        while (choicevalid) {
            choicevalid = executable.exe(inputTray);
            inputTray = new Scanner(System.in);
        }
        inputTray.close();
    }
}