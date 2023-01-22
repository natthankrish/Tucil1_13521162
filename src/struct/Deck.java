package struct;

import java.util.Random;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Deck {
    final String[] allowedChar = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};
    final String[] operators = {"+", "-", "*", "/", "(", ")"};
    String[] cardDeck;

    public void constructDeck (String[] inputCards) {
        // Initializing Deck
        this.cardDeck = new String[inputCards.length];
        for (int i = 0; i < inputCards.length; i++) {
            this.cardDeck[i] = inputCards[i];
        }
    }

    public boolean isDeckValid (String[] cardIn) {
        // Checking whether the rank of cards in Deck are valid
        boolean valid = true;
        int i = 0;
        while (i < cardIn.length && valid) {
            int j = 0;
            boolean found = false;
            while (j < allowedChar.length && !found) {
                if (allowedChar[j].equals(cardIn[i])) {
                    found = true;
                }
                j++;
            }
            valid = found;
            i++;
        }
        return valid;
    }

    public String[] randomizeDeck () {
        // Get a set of Random Deck
        Random rand = new Random();
        String[] randomDeck = new String[4];

        for (int i = 0; i < 4; i++) {
            randomDeck[i] = allowedChar[rand.nextInt(13)];
        }
        return randomDeck;
    }

    static double processCalculation (double card1, double card2, String operator) {
        if (operator.equals("+")) {
            return card1 + card2;
        } else if (operator.equals("-")) {
            return card1 - card2;
        } else if (operator.equals("*")) {
            return card1 * card2;
        } else {
            return card1 / card2;
        }
    }

    public ArrayList<String> calculateDeck (String[] inputDeck) {
        // There is only five ways to place brackets
        // ABCD are Deck, xyz are operators
        // (A x B) y (C z D)
        // ((A x B) y C) z D
        // (A x (B y C)) z D
        // A x ((B y C) z D)
        // A x (B y (C z D))
        Map dict = new Map();
        ArrayList<String> res = new ArrayList<String>();

        long start = System.nanoTime();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    for (int k = 0; k < 4; k++) {
                        if (i != k && j != k) {
                            for (int l = 0; l < 4; l++) {
                                if (i != l && j != l && k != l) {
                                    for (int m = 0; m < 4; m++) {
                                        for (int n = 0; n < 4; n++) {
                                            for (int o = 0; o < 4; o++) {
                                                double temp = processCalculation(processCalculation(dict.getValue(inputDeck[i]), dict.getValue(inputDeck[j]), operators[m]), processCalculation(dict.getValue(inputDeck[k]), dict.getValue(inputDeck[l]), operators[o]), operators[n]);
                                                if (temp == 24.0) {
                                                    if (!res.contains("(" + inputDeck[i] + " " + operators[m] + " " + inputDeck[j] + ") " + operators[n] + " (" + inputDeck[k] + " " + operators[o] + " " + inputDeck[l] + ")")) {
                                                        res.add("(" + inputDeck[i] + " " + operators[m] + " " + inputDeck[j] + ") " + operators[n] + " (" + inputDeck[k] + " " + operators[o] + " " + inputDeck[l] + ")");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } 
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    for (int k = 0; k < 4; k++) {
                        if (i != k && j != k) {
                            for (int l = 0; l < 4; l++) {
                                if (i != l && j != l && k != l) {
                                    for (int m = 0; m < 4; m++) {
                                        for (int n = 0; n < 4; n++) {
                                            for (int o = 0; o < 4; o++) {
                                                double temp = processCalculation(processCalculation(processCalculation(dict.getValue(inputDeck[i]), dict.getValue(inputDeck[j]), operators[m]), dict.getValue(inputDeck[k]), operators[n]), dict.getValue(inputDeck[l]), operators[o]);
                                                if (temp == 24.0) {
                                                    if (!res.contains("((" + inputDeck[i] + " " + operators[m] + " " + inputDeck[j] + ") " + operators[n] + " " + inputDeck[k] + ") " + operators[o] + " " + inputDeck[l])) {
                                                        res.add("((" + inputDeck[i] + " " + operators[m] + " " + inputDeck[j] + ") " + operators[n] + " " + inputDeck[k] + ") " + operators[o] + " " + inputDeck[l]);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } 
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    for (int k = 0; k < 4; k++) {
                        if (i != k && j != k) {
                            for (int l = 0; l < 4; l++) {
                                if (i != l && j != l && k != l) {
                                    for (int m = 0; m < 4; m++) {
                                        for (int n = 0; n < 4; n++) {
                                            for (int o = 0; o < 4; o++) {
                                                double temp = processCalculation(processCalculation(dict.getValue(inputDeck[i]), processCalculation(dict.getValue(inputDeck[j]), dict.getValue(inputDeck[k]), operators[n]), operators[m]), dict.getValue(inputDeck[l]), operators[o]);
                                                if (temp == 24.0) {
                                                    if (!res.contains("(" + inputDeck[i] + " " + operators[m] + " (" + inputDeck[j] + " " + operators[n] + " " + inputDeck[k] + ")) " + operators[o] + " " + inputDeck[l])) {
                                                        res.add("(" + inputDeck[i] + " " + operators[m] + " (" + inputDeck[j] + " " + operators[n] + " " + inputDeck[k] + ")) " + operators[o] + " " + inputDeck[l]);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } 
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    for (int k = 0; k < 4; k++) {
                        if (i != k && j != k) {
                            for (int l = 0; l < 4; l++) {
                                if (i != l && j != l && k != l) {
                                    for (int m = 0; m < 4; m++) {
                                        for (int n = 0; n < 4; n++) {
                                            for (int o = 0; o < 4; o++) {
                                                double temp = processCalculation(dict.getValue(inputDeck[i]), processCalculation(processCalculation(dict.getValue(inputDeck[j]), dict.getValue(inputDeck[k]), operators[n]), dict.getValue(inputDeck[l]), operators[o]), operators[m]);
                                                if (temp == 24.0) {
                                                    if (!res.contains(inputDeck[i] + " " + operators[m] + " ((" + inputDeck[j] + " " + operators[n] + " " + inputDeck[k] + ") " + operators[o] + " " + inputDeck[l] + ")")) {
                                                        res.add(inputDeck[i] + " " + operators[m] + " ((" + inputDeck[j] + " " + operators[n] + " " + inputDeck[k] + ") " + operators[o] + " " + inputDeck[l] + ")");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } 
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i != j) {
                    for (int k = 0; k < 4; k++) {
                        if (i != k && j != k) {
                            for (int l = 0; l < 4; l++) {
                                if (i != l && j != l && k != l) {
                                    for (int m = 0; m < 4; m++) {
                                        for (int n = 0; n < 4; n++) {
                                            for (int o = 0; o < 4; o++) {
                                                double temp = processCalculation(dict.getValue(inputDeck[i]), processCalculation(dict.getValue(inputDeck[j]), processCalculation(dict.getValue(inputDeck[k]), dict.getValue(inputDeck[l]), operators[o]), operators[n]), operators[m]);
                                                if (temp == 24.0) {
                                                    if (!res.contains(inputDeck[i] + " " + operators[m] + " (" + inputDeck[j] + " " + operators[n] + " (" + inputDeck[k] + " " + operators[o] + " " + inputDeck[l] + "))")) {
                                                        res.add(inputDeck[i] + " " + operators[m] + " (" + inputDeck[j] + " " + operators[n] + " (" + inputDeck[k] + " " + operators[o] + " " + inputDeck[l] + "))");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } 
            }
        }
        long end = System.nanoTime();
        long time = end - start;
        res.add(String.valueOf(time));
        return res;
    }

    public void displayResult (ArrayList<String> result) {
        // Display Result to Terminal
        if (result.size() == 1) {
            System.out.println("No solution found");
            System.out.println("Time taken: " + Integer.parseInt(result.get(0))/1000000000.0);

        } else if (result.size() == 2) {
            System.out.println(String.valueOf(result.size()-1) + " solution found");
            for (int i = 0; i < result.size()-1; i++) {
                System.out.println(result.get(0));
                System.out.println("Time taken: " + Integer.parseInt(result.get(1))/1000000000.0);
            }

        } else {
            System.out.println(String.valueOf(result.size()-1) + " solutions found");
            for (int i = 0; i < result.size()-1; i++) {
                System.out.println(result.get(i));
            }
            System.out.println("Time taken: " + Integer.parseInt(result.get(result.size()-1))/1000000000.0);
        }
    }

    public void saveResultsToFile (String[] inputDeck, ArrayList<String> result) {
        // Save Results to File
        try {
            File buffer = new File("..\\test\\Solution " + inputDeck[0] + " " + inputDeck[1] + " " + inputDeck[2] + " " + inputDeck[3] + ".txt");
            if (buffer.createNewFile()) {
                try {
                    try (FileWriter writer = new FileWriter(buffer)) {
                        if (result.size() == 1) {
                            writer.write("No solution found");
                        } else if (result.size() == 2) {
                            writer.write("1 solution found\n");
                            writer.write(result.get(0));
                        } else {
                            writer.write(result.size()-1 + " solutions found\n");
                            for (int i = 0; i < result.size()-1; i++) {
                                writer.write(result.get(i) + "\n");
                            }
                        }
                        writer.write("Time taken: " + Integer.parseInt(result.get(result.size()-1))/1000000000.0);
                    }
                } catch (IOException e) {
                    System.out.println("Something went wrong. Please try again.");
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong. Please try again.");
        }
    }
    
}
