import java.util.ArrayList;

class Person {
    String name;
    int totalInHand;
    private boolean isDealer = false;
    ArrayList<String> playerCards = new ArrayList<String>();

//    static {
//        Text texten = new Text();
//    }

    Person() {

    }

    Person(String name, boolean isDealer) {
        this.name = name;
        this.isDealer = isDealer;
        this.totalInHand = 0;
    }

    static int startOnePlayerGame(ArrayList<Person> players, ArrayList<Card> deck, int cardsDealt) {
        int playerCards = 0;
        for (int i = 0; i < 2; i++) {
            players.get(0).totalInHand += deck.get(cardsDealt).value;       // in case of more players, 0 would need to be adjustable. 0 = player1
            players.get(0).playerCards.add(deck.get(cardsDealt).front);
            System.out.println("Jij hebt " + players.get(0).playerCards.get(playerCards) + " gekregen. De totale score van je hand is nu " + players.get(0).totalInHand);
            playerCards++;
            cardsDealt++;
        }
        return cardsDealt;
    }

    static int firstDealerHand(ArrayList<Person> players, ArrayList<Card> deck, int cardsDealt) {
        int dealerCards = 0;
        for (int i = 0; i < 2; i++) {
            players.get(1).totalInHand += deck.get(cardsDealt).value;       // in case of more players, 1 would need to be adjustable. 1 = dealer in a 1 player game.
            players.get(1).playerCards.add(deck.get(cardsDealt).front);
            int lastCardValue = deck.get(cardsDealt).value;
            if (dealerCards == 1) {
                System.out.println("De dealer heeft in elk geval " + players.get(1).playerCards.get(0) + " gekregen. De score van zijn hand is minstens " + (players.get(1).totalInHand - lastCardValue));
            }
            dealerCards++;
            cardsDealt++;
        }
        return cardsDealt;
    }

    static int takeCard(ArrayList<Person> players, ArrayList<Card> deck, int cardsDealt, int i) {
        int playerCards = players.get(i).playerCards.size();
        int lastCardValue = 0;

        if (players.get(i).isDealer) {
            int dealerScore = players.get(i).totalInHand;
            System.out.print("De dealer heeft ");
            for(int j = 0; j < players.get(i).playerCards.size(); j++) {
                if (j > 0) {
                    System.out.print("en " + players.get(i).playerCards.get(j) + " ");
                } else {
                    System.out.print(players.get(i).playerCards.get(j) + " ");
                }

            }
            System.out.println("De totale score in de hand van de dealer is " + dealerScore);

            while (true) {
                if (dealerScore < 17) {
                    System.out.println("De dealer heeft minder dan 17 punten dus hij pakt nog een kaart.");

                    if (deck.get(cardsDealt).value == 11 && (dealerScore + deck.get(cardsDealt).value) > 21) {
                        dealerScore += 1;
                    } else {
                        dealerScore += deck.get(cardsDealt).value;
                    }

                    players.get(i).playerCards.add(deck.get(cardsDealt).front);
                    System.out.println("De dealer heeft " + players.get(i).playerCards.get((players.get(i).playerCards.size() - 1)) + " gekregen. " + "De dealer heeft nu " + dealerScore + " punten.");
                    cardsDealt++;
                } else {
                    System.out.println("De dealer heeft meer dan 17 punten dus hij past.");
                    break;
                }
            }

        } else {
            if (deck.get(cardsDealt).value == 11 && (players.get(i).totalInHand + deck.get(cardsDealt).value) > 21) {
                players.get(i).totalInHand += 1;
                lastCardValue = 1;
            } else {
                players.get(i).totalInHand += deck.get(cardsDealt).value;
                lastCardValue = deck.get(cardsDealt).value;
            }
            players.get(i).playerCards.add(deck.get(cardsDealt).front);

            System.out.println("Jij hebt " + players.get(i).playerCards.get(playerCards) + " met een waarde van " + lastCardValue +  " gekregen. \nDe totale score van je hand is nu " + players.get(i).totalInHand);

            cardsDealt++;
        }
        return cardsDealt;
    }
}
