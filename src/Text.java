import java.util.ArrayList;

class Text {
    private String text;
    private ArrayList<Text> textenList = new ArrayList<Text>();
    private static ArrayList<String> textArrayList = new ArrayList<String>();

    // Texts filler
    void fillTextArray() {
        fillPreList();
        for (String s : textArrayList) {
            textenList.add(new Text(s));
        }
    }

    // General constructor
    Text() {

    }

    // Specific Constructor
    private Text(String text) {
        this.text = text;
    }

    void generateText(int id) {
        System.out.print(textenList.get(id).text);
    }

    private void fillPreList() {
        textArrayList.add("Dit is BlackJack! Wellicht het meest bekende gokspel met kaarten! \n\n");                                                     //0
        textArrayList.add("Wil je dat ik kort de regels uitleg? y/n \n");
        textArrayList.add("Zie hier het hele deck. Kijk maar na, het is helemaal compleet! \n");
        textArrayList.add("Goed, nu je de kaarten hebt gezien gaan we ze schudden en verdelen. Onthoud, de dealer houdt er één verborgen van je. \n");
        textArrayList.add("Het doel van het spel is om 21 punten te halen of in ieder geval zo dicht mogelijk bij 21 punten te komen. \nZodra je over de 21 punten komt, ben je direct af (bust). Als eerste de kaarten 2 t/m 10, deze hebben gewoon hun normale waarde. \nDaarop volgen de kaarten met een afbeelding. De Boer, de Vrouw en de Heer zijn allen 10 punten waard. Tenslotte is er de Aas. Deze is 11 punten waard. \nJe behaalt de hoogst mogelijke waarde als je direct een Aas en een kaart met een waarde van 10 punten hebt. Dit heet een blackjack. Alleen als de bank ook een blackjack heeft, win je niet maar krijg je jouw inzet terug. Zo niet, dan heb je direct gewonnen. \nDe kaarten worden gedeeld door de dealer. Jij en iedere andere speler ontvangen twee kaarten en, afhankelijk van het casino, ontvangt de dealer 1 kaart of twee kaarten waarvan er 1 tot het einde omgekeerd blijft liggen. \nHeb je minder dan 21 punten dan kun je een kaart bijvragen aan de dealer. Doorgaans moet de dealer kaarten vragen tot hij 17 punten heeft en moet hij bij 17 punten passen. \nHeb je minder dan 21 punten, maar je wilt geen kaart bijvragen, dan kun je passen en speelt de dealer verder. \n");
        textArrayList.add("Mooi, laten we nu snel beginnen. \nDe dealer laat je eerst even het hele deck zien.\n");                                       //5
        textArrayList.add("Dat begreep ik niet helemaal, wil je de uitleg lezen? y/n \n");
        textArrayList.add("\n ##### Druk op Enter om door te gaan. \n");
        textArrayList.add("Je hebt de regels al gezien (of overgeslagen), dus we gaan gelijk verder met het spel. \n");
        textArrayList.add("Hoe heet je? \n");
        textArrayList.add("Van harte welkom, ");                                                                                                           //10
        textArrayList.add("Uw BlackJack dealer is ");
        textArrayList.add("#De dealer schudt de kaarten zeer kundig# \n");
        textArrayList.add("Wil je een kaart (k), wil je passen (p) of wil je stoppen (q)? \n");
        textArrayList.add("Dat begreep ik niet helemaal. \n");
        textArrayList.add("Dan is het aan de dealer. \n");                                                                                             //15
        textArrayList.add("Gefeliciteerd! Je hebt Black Jack! Je hebt automatisch gewonnen! \n");
        textArrayList.add("Wil je nog een rondje spelen? y/n \n");
        textArrayList.add("Ahhhh helaas, je hebt meer dan 21 punten, dus je bent af.\n");
        textArrayList.add("Jammer dat je stopt, maar het was leuk. Tot de volgende keer!\n");
        textArrayList.add("De dealer laat eerst zijn hele hand zien: \n");                                                                                 //20
        textArrayList.add("Het spel is voorbij! \n");
        textArrayList.add("Gefeliciteerd, je hebt gewonnen! \n");
        textArrayList.add("Gelijkspel! What are the odds? \n");
        textArrayList.add("Jammer! De dealer heeft gewonnen. \n");
    }
}
