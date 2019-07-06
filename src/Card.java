import java.util.ArrayList;

class Card {
    String front;               // Each card has a front i.e. H4 (4 of Hearts). This'll be in Dutch, so the suits will be H, S, R, K
    int value;                  // Value held by each card, 1 - 11

    private static String[] cardType = {"H", "S", "R", "K"};
    private static String[] cardFace = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "V", "K", "A"};

    // Vanaf JDK 11 kun je op deze manier de icoontjes van kaarten tonen ipv bijvoorbeeld H4.
//    static char suitH = '\u2665';
//    static char suitS = '\u2660';
//    static char suitR = '\u2666';
//    static char suitK = '\u2663';
//    static String cardType[] = {Character.toString(suitH), Character.toString(suitS), Character.toString(suitR), Character.toString(suitK)},
//            cardFace[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "V", "K", "A"};
    private static int[] cardValue = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

//    ArrayList<Card> deck = new ArrayList<Card>();       // The Deck that holds all cards

    private Card(String front, int value) {
        this.front = front;
        this.value = value;
    }

    static void createDeck(ArrayList deck) {
        for (int i = 0; i < 4; i++) {
            StringBuilder front = new StringBuilder(cardType[i]);

            for (int j = 0; j < 13; j++) {
                front.append(cardFace[j]);
                int value = cardValue[j];
                deck.add(new Card(front.toString(), value));
                front = new StringBuilder(cardType[i]);
            }
        }
    }

    static void displayDeck(ArrayList<Card> deck, int card) {
        for (int count = 0; count < 4; count++) {
            int cardNumber = card;
            for (int j = 0; j < 13; j++) {
                if (count == 0) {
                    System.out.print("---- ");
                    if ((j + 1) % 13 == 0) {
                        System.out.print("\n");
                    }
                } else if (count == 1) {
                    System.out.print("|" + deck.get(cardNumber).front + "  ");
                    cardNumber++;
                    if ((j + 1) % 13 == 0) {
                        System.out.print("\n");
                    }
                } else if (count == 2 && cardNumber >= 39) {
                    System.out.print("|    ");
                    cardNumber++;
                    if (cardNumber == 48) {
                        System.out.print(" ");
                    }
                    if ((j + 1) % 13 == 0) {
                        System.out.print("\n");
                    }
                } else if (count == 3 && cardNumber >= 39) {
                    System.out.print("---- ");
                    cardNumber++;
                    if (cardNumber == 48) {
                        System.out.print(" ");
                    }
                    if ((j + 1) % 13 == 0) {
                        System.out.print("\n\n");
                    }
                }
            }
        }
    }
}
