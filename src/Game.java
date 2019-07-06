import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Game {

    public static void main(String[] args) {
        int gamesRun = 0;
        Game game = new Game();
        game.startGame(gamesRun);
    }

    private void startGame(int gamesRun) {
        // General initiliazers
        Scanner scanner = new Scanner(System.in);
        boolean continuePlaying = true;

        // Text initiliazers
        Text texten = new Text();       // instance a Text object
        texten.fillTextArray();         // fill the text Arraylists

        // Card initializers
        ArrayList<Card> deck = new ArrayList<Card>();
        Card.createDeck(deck);
        int cardsDealt;

        // Person initializer
        Person person = new Person();
        ArrayList<Person> people = new ArrayList<Person>();
        Person player1 = new Person();
        Person dealer = new Person("Gastõn", true);
        people.add(player1);
        people.add(dealer);

        while (continuePlaying) {
            gamesRun++;                     // keep track of # games run
            cardsDealt = 0;

            // reset hand, cardsDealt
            for (Person value : people) {
                value.totalInHand = 0;
                value.playerCards.clear();
            }

            if (player1.name == null) {
                texten.generateText(9);
                player1.name = scanner.nextLine();
                texten.generateText(10);
                System.out.println(player1.name + "!");
                texten.generateText(11);
                System.out.println(dealer.name + ". \n");
            }

            // Actual game start
            if (gamesRun < 2) {
                texten.generateText(0);
                texten.generateText(1);
                String answer = scanner.nextLine().toLowerCase();
                explainRules(answer, scanner, texten);

                Card.displayDeck(deck, 0);
                Card.displayDeck(deck, 13);
                Card.displayDeck(deck, 26);
                Card.displayDeck(deck, 39);

                texten.generateText(2);
                texten.generateText(3);

                Collections.shuffle(deck);
                enterToContinue(texten);

            } else {
                texten.generateText(8);
                Collections.shuffle(deck);
                enterToContinue(texten);
            }

            texten.generateText(12);

            cardsDealt = Person.startOnePlayerGame(people, deck, cardsDealt);
            System.out.println("Het aantal uitgegeven kaarten is: " + cardsDealt + "\n");

            if (player1.totalInHand == 21) {
                while (true)  {
                    texten.generateText(16);
                    texten.generateText(17);
                    String answer = scanner.nextLine();
                    if (answer.toLowerCase().equals("y")) {
                        break;
                    } else if (answer.toLowerCase().equals("n")) {
                        continuePlaying = false;
                        break;
                    } else {
                        texten.generateText(14);
                    }
                }

            } else {

                cardsDealt = Person.firstDealerHand(people, deck, cardsDealt);
                System.out.println("Het aantal uitgegeven kaarten is: " + cardsDealt + "\n");

                label:
                while (true) {
                    texten.generateText(13);
                    String answer = scanner.nextLine();
                    switch (answer.toLowerCase()) {
                        case "q":
                            texten.generateText(19);
                            continuePlaying = false;
                            break label;
                        case "k":
                            cardsDealt = Person.takeCard(people, deck, cardsDealt, 0);
                            if (player1.totalInHand > 21) {
                                texten.generateText(18);
                                while (true) {
                                    texten.generateText(17);
                                    String answer2 = scanner.nextLine();
                                    if (answer2.toLowerCase().equals("y")) {
                                        break;
                                    } else if (answer2.toLowerCase().equals("n")) {
                                        continuePlaying = false;
                                        break;
                                    } else {
                                        texten.generateText(14);
                                    }
                                }
                                break label;
                            }
                            break;
                        case "p":
                            System.out.print("Je hebt gepast met de volgende hand: ");
                            for (String element : player1.playerCards) {
                                System.out.printf(" %2s, ", element);
                            }
                            System.out.print(". Dit heeft totaal een waarde van " + player1.totalInHand + ".");
                            System.out.println();

                            enterToContinue(texten);

                            texten.generateText(15);
                            texten.generateText(20);
                            System.out.println();
                            cardsDealt = Person.takeCard(people, deck, cardsDealt, 1);

                            //win check
                            if (people.get(0).totalInHand > people.get(1).totalInHand) {
                                texten.generateText(22);
                            } else if (people.get(0).totalInHand < people.get(1).totalInHand) {
                                texten.generateText(24);
                            } else if (people.get(0).totalInHand == people.get(1).totalInHand) {
                                texten.generateText(23);
                            }

                            // choice to continue playing
                            texten.generateText(21);
                            while (true) {
                                texten.generateText(17);
                                String answer2 = scanner.nextLine();
                                if (answer2.toLowerCase().equals("y")) {
                                    break;
                                } else if (answer2.toLowerCase().equals("n")) {
                                    continuePlaying = false;
                                    break;
                                } else {
                                    texten.generateText(14);
                                }
                            }
                            break label;
                        default:
                            texten.generateText(14);
                            break;
                    }
                }
            }
        }
    }

    private static void enterToContinue(Text texten) {
        texten.generateText(7);
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void explainRules(String answer, Scanner scanner, Text texten) {
        if (answer.contentEquals("y")) {
            texten.generateText(4);
            enterToContinue(texten);
            texten.generateText(5);
            enterToContinue(texten);
        } else if (answer.contentEquals("n")) {
            texten.generateText(5);
            enterToContinue(texten);
        } else {
            texten.generateText(6);
            String reply = scanner.nextLine();
            explainRules(reply, scanner, texten);
        }
    }

}
