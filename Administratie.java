import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 * class Administratie
 * @version 1.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class Administratie {

    //Deze lijsten bevatten informatie voor het aanmaken van unieke personen
    public static ArrayList<String> achternamen = maakAchternamen();
    public static ArrayList<String> voornamenM = maakVoornaamMan();
    public static ArrayList<String> voornamenV = maakVoornaamVrouw();
    public static ArrayList<String> richtingen = new ArrayList<String>(Arrays.asList("ICT", "Psychologie", "Wiskunde", "Biologie",
            "Natuurkunde", "Bedrijfskunde", "Economie", "Bierologie"));
    public static ArrayList<LocalDate> data = maakData();

    //Hoeveel dagen er in een week zitten
    final static int DAYS_IN_WEEK = 7;

    /**
     * Constructor voor Administratie, deze is private zodat
     * je niet per ongeluk een instantie van deze klasse kunt maken
     */
    private Administratie() { }

    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal aantak
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        double totaal = 0;
        for (double i : aantal) {
            totaal += i;
        }
        if(aantal.length == 0) {
            return 0;
        } else {
            return totaal / aantal.length;
        }
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double totaal = 0;
        for (double i : omzet) {
            totaal += i;
        }
        if(omzet.length == 0) {
            return 0;
        } else {
            return totaal / omzet.length;
        }
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet omzet
     * @return array (7 elementen) met dagomzetten
     */
    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        for(int i = 0; i < DAYS_IN_WEEK; i++) {

            int j = 0;
            //Bereken eerst ALLE maandagen, dan ALLE dinsdagen enz.
            while(i + DAYS_IN_WEEK * j < omzet.length) {
                temp[i] += omzet[i + DAYS_IN_WEEK * j];
                j++;
            }
        }
        return temp;
    }

    /**
     * Vind de dag gebasseerd op de numerieke waarde
     * @param x nummer van dag
     * @return string van dag
     */
    public static String getDay(int x) {
        switch(x%7) {
            case 0:
                return "maandag";
            case 1:
                return "dinsdag";
            case 2:
                return "woensdag";
            case 3:
                return "donderdag";
            case 4:
                return "vrijdag";
            case 5:
                return "zaterdag";
            case 6:
                return "zondag";
            default:
                return ("Er ging iets mis met de dag vinden x=" + x);
        }
    }

    /**
     * @return een willekeurige studierichting uit de lijst
     */
    public static String getRandomStudierichting() {
        return richtingen.get((int)(Math.random() * richtingen.size()-1));
    }

    /**
     * Pakt een willekeurige voornaam voor het juiste geslacht uit een arraylist
     * @param geslacht geslacht persoon
     * @return voornaam
     */
    public static String getRandomVoornaam(char geslacht) {
        if(geslacht == 'm') {
            return voornamenM.get((int)(Math.random() * voornamenM.size()-1));
        } else {
            return voornamenV.get((int)(Math.random() * voornamenV.size()-1));
        }
    }

    /**
     * Pakt een willekeurige achternaam uit een arraylist
     * @return achternaam
     */
    public static String getRandomAchternaam() {
        return achternamen.get((int)(Math.random() * achternamen.size()-1));
    }

    /**
     * Pakt een willekeurige datum uit een arraylist
     * @return geboortedatum
     */
    public static LocalDate getRandomDatum() {
        return data.get((int)(Math.random() * data.size()-1));
    }

    /**
     * Maakt een lijst van 100 achternamen
     * @return arraylist met achternamen
     */
    private static ArrayList<String> maakAchternamen() {
        ArrayList<String> achternamen = new ArrayList<>();
        achternamen.add("	deJog	");
        achternamen.add("	Jase	");
        achternamen.add("	deVies	");
        achternamen.add("	Beg	");
        achternamen.add("	vaDijk	");
        achternamen.add("	Bakke	");
        achternamen.add("	Jasse	");
        achternamen.add("	Visse	");
        achternamen.add("	Smit	");
        achternamen.add("	Meije	");
        achternamen.add("	deBoe	");
        achternamen.add("	Mulde	");
        achternamen.add("	deGoot	");
        achternamen.add("	Bos	");
        achternamen.add("	Vos	");
        achternamen.add("	Petes	");
        achternamen.add("	Hediks	");
        achternamen.add("	vaLeeuwe	");
        achternamen.add("	Dekke	");
        achternamen.add("	Bouwe	");
        achternamen.add("	deWit	");
        achternamen.add("	Dijksta	");
        achternamen.add("	Smits	");
        achternamen.add("	deGaaf	");
        achternamen.add("	Mee	");
        achternamen.add("	Lide	");
        achternamen.add("	Kok	");
        achternamen.add("	Jacobs	");
        achternamen.add("	deHaa	");
        achternamen.add("	Vemeule	");
        achternamen.add("	Heuvel	");
        achternamen.add("	Vee	");
        achternamen.add("	Boek	");
        achternamen.add("	deBuij	");
        achternamen.add("	deBui	");
        achternamen.add("	Heijde	");
        achternamen.add("	Schoute	");
        achternamen.add("	Beek	");
        achternamen.add("	Willems	");
        achternamen.add("	Vliet	");
        achternamen.add("	Vendel	");
        achternamen.add("	Hoeksta	");
        achternamen.add("	Maas	");
        achternamen.add("	Vehoeve	");
        achternamen.add("	Koste	");
        achternamen.add("	vaDam	");
        achternamen.add("	Wal	");
        achternamen.add("	Pis	");
        achternamen.add("	Blom	");
        achternamen.add("	Huisma	");
        achternamen.add("	Peetes	");
        achternamen.add("	deJoge	");
        achternamen.add("	Kuipes	");
        achternamen.add("	vaVee	");
        achternamen.add("	Post	");
        achternamen.add("	Kuipe	");
        achternamen.add("	Veesta	");
        achternamen.add("Kame	");
        achternamen.add("Bik	");
        achternamen.add("Scholte	");
        achternamen.add("vaWijk	");
        achternamen.add("Postma	");
        achternamen.add("Mates	");
        achternamen.add("Vik	");
        achternamen.add("deuite	");
        achternamen.add("Timmemas	");
        achternamen.add("Goe	");
        achternamen.add("Geitse	");
        achternamen.add("Joke	");
        achternamen.add("vaLoo	");
        achternamen.add("Boe	");
        achternamen.add("Velde	");
        achternamen.add("Willemse	");
        achternamen.add("Smeets	");
        achternamen.add("deLage	");
        achternamen.add("deVos	");
        achternamen.add("Bosch	");
        achternamen.add("Dongen	");
        achternamen.add("Schippe	");
        achternamen.add("deKoig	");
        achternamen.add("Laa	");
        achternamen.add("Koig	");
        achternamen.add("Velde	");
        achternamen.add("Diesse	");
        achternamen.add("vaDoo	");
        achternamen.add("Hemas	");
        achternamen.add("Eves");
        achternamen.add("Bosch");
        achternamen.add("Meule");
        achternamen.add("Hofma");
        achternamen.add("Bosma");
        achternamen.add("Woltes");
        achternamen.add("Sades");
        achternamen.add("Host");
        achternamen.add("Mol");
        achternamen.add("Kuijpes");
        achternamen.add("Moleaa");
        achternamen.add("Pol");
        achternamen.add("deLeeuw");
        achternamen.add("Vebeek");
        return achternamen;
    }

    /**
     * Maakt een lijst van 100 voornamen voor vrouwen
     * @return arraylist met voornamen
     */
    private static ArrayList<String> maakVoornaamVrouw() {
        ArrayList<String> voornamenV = new ArrayList<>();
        voornamenV.add("	Zoé	");
        voornamenV.add("	Emma	");
        voornamenV.add("	Esmee	");
        voornamenV.add("	Evi	");
        voornamenV.add("	Tess	");
        voornamenV.add("	Sophie	");
        voornamenV.add("	Mila	");
        voornamenV.add("	Julia	");
        voornamenV.add("	Lieke	");
        voornamenV.add("	Sofia	");
        voornamenV.add("	Lynn	");
        voornamenV.add("	Hailey	");
        voornamenV.add("	Eva	");
        voornamenV.add("	Nora	");
        voornamenV.add("	Sofie	");
        voornamenV.add("	Milou	");
        voornamenV.add("	Ivy	");
        voornamenV.add("	Fleur	");
        voornamenV.add("	Nina	");
        voornamenV.add("	Emily	");
        voornamenV.add("	Fenna	");
        voornamenV.add("	Yara	");
        voornamenV.add("	Elin	");
        voornamenV.add("	Naomi	");
        voornamenV.add("	Isa	");
        voornamenV.add("	Nova	");
        voornamenV.add("	Lizzy	");
        voornamenV.add("	Elena	");
        voornamenV.add("	Charlotte	");
        voornamenV.add("	Maud	");
        voornamenV.add("	Anna	");
        voornamenV.add("	Noor	");
        voornamenV.add("	Iris	");
        voornamenV.add("	Lisa	");
        voornamenV.add("	Evy	");
        voornamenV.add("	Jasmijn	");
        voornamenV.add("	Liv	");
        voornamenV.add("	Hannah	");
        voornamenV.add("	Olivia	");
        voornamenV.add("	Sara	");
        voornamenV.add("	Sophia	");
        voornamenV.add("	Senna	");
        voornamenV.add("	Lize	");
        voornamenV.add("	Kate	");
        voornamenV.add("	Lauren	");
        voornamenV.add("	Sarah	");
        voornamenV.add("	Marit	");
        voornamenV.add("	Chloë	");
        voornamenV.add("	Lotte	");
        voornamenV.add("	Roos	");
        voornamenV.add("	Tessa	");
        voornamenV.add("	Vera	");
        voornamenV.add("	Siënna	");
        voornamenV.add("	Merel	");
        voornamenV.add("	Amber	");
        voornamenV.add("	Rosalie	");
        voornamenV.add("	Leah	");
        voornamenV.add("	Loïs	");
        voornamenV.add("	Veerle	");
        voornamenV.add("	Benthe	");
        voornamenV.add("	Jill	");
        voornamenV.add("	Lily	");
        voornamenV.add("	Lara	");
        voornamenV.add("	Lena	");
        voornamenV.add("	Amy	");
        voornamenV.add("	Hanna	");
        voornamenV.add("	Amélie	");
        voornamenV.add("	Fay	");
        voornamenV.add("	Beau	");
        voornamenV.add("	Romee	");
        voornamenV.add("	Isabella	");
        voornamenV.add("	Liva	");
        voornamenV.add("	Jaylinn	");
        voornamenV.add("	Elise	");
        voornamenV.add("	Vajèn	");
        voornamenV.add("	Liz	");
        voornamenV.add("	Jolie	");
        voornamenV.add("	Sanne	");
        voornamenV.add("	Noa	");
        voornamenV.add("	Davina	");
        voornamenV.add("	Marilou	");
        voornamenV.add("	Bo	");
        voornamenV.add("	Femke	");
        voornamenV.add("	Lana	");
        voornamenV.add("	Indy	");
        voornamenV.add("	Noortje	");
        voornamenV.add("	Selin	");
        voornamenV.add("	Milana	");
        voornamenV.add("	Fayén	");
        voornamenV.add("	Mara	");
        voornamenV.add("	Mia	");
        voornamenV.add("	Stella	");
        voornamenV.add("	Lilly	");
        voornamenV.add("	Fiene	");
        voornamenV.add("	Victoria	");
        voornamenV.add("	Féline	");
        voornamenV.add("	Isabelle	");
        voornamenV.add("	Laura	");
        voornamenV.add("	Luna	");
        voornamenV.add("	Arya	");
        return voornamenV;
    }

    /**
     * Maakt een lijst van 100 voornamen voor mannen
     * @return arraylist met voornamen
     */
    private static ArrayList<String> maakVoornaamMan() {
        ArrayList<String> voornamenM = new ArrayList<>();
        voornamenM.add("	Daan	");
        voornamenM.add("	Lucas	");
        voornamenM.add("	Milan	");
        voornamenM.add("	Noah	");
        voornamenM.add("	Levi	");
        voornamenM.add("	Thomas	");
        voornamenM.add("	Liam	");
        voornamenM.add("	Max	");
        voornamenM.add("	Bram	");
        voornamenM.add("	Luuk	");
        voornamenM.add("	Sem	");
        voornamenM.add("	Mason	");
        voornamenM.add("	Thijs	");
        voornamenM.add("	James	");
        voornamenM.add("	Olivier	");
        voornamenM.add("	Noud	");
        voornamenM.add("	Lars	");
        voornamenM.add("	Sam	");
        voornamenM.add("	Ryan	");
        voornamenM.add("	Finn	");
        voornamenM.add("	Sven	");
        voornamenM.add("	Stijn	");
        voornamenM.add("	Jason	");
        voornamenM.add("	Nathan	");
        voornamenM.add("	Xavi	");
        voornamenM.add("	Jesse	");
        voornamenM.add("	Vince	");
        voornamenM.add("	Boaz	");
        voornamenM.add("	Jace	");
        voornamenM.add("	Logan	");
        voornamenM.add("	Daniël	");
        voornamenM.add("	Benjamin	");
        voornamenM.add("	Teun	");
        voornamenM.add("	Jens	");
        voornamenM.add("	Julian	");
        voornamenM.add("	Timo	");
        voornamenM.add("	Dean	");
        voornamenM.add("	Owen	");
        voornamenM.add("	David	");
        voornamenM.add("	Jayden	");
        voornamenM.add("	Roan	");
        voornamenM.add("	Dex	");
        voornamenM.add("	Mees	");
        voornamenM.add("	Hugo	");
        voornamenM.add("	Tim	");
        voornamenM.add("	Dylan	");
        voornamenM.add("	Tom	");
        voornamenM.add("	Jelte	");
        voornamenM.add("	Tijn	");
        voornamenM.add("	Ruben	");
        voornamenM.add("	Jaxx	");
        voornamenM.add("	Fabian	");
        voornamenM.add("	Stan	");
        voornamenM.add("	Kaj	");
        voornamenM.add("	Quinten	");
        voornamenM.add("	Mick	");
        voornamenM.add("	Riley	");
        voornamenM.add("	Jack	");
        voornamenM.add("	Quinn	");
        voornamenM.add("	Guus	");
        voornamenM.add("	Colin	");
        voornamenM.add("	Alex	");
        voornamenM.add("	Aiden	");
        voornamenM.add("	Nick	");
        voornamenM.add("	Philip	");
        voornamenM.add("	Floris	");
        voornamenM.add("	Kyan	");
        voornamenM.add("	Fynn	");
        voornamenM.add("	Gijs	");
        voornamenM.add("	Senn	");
        voornamenM.add("	Luca	");
        voornamenM.add("	Lukas	");
        voornamenM.add("	Oscar	");
        voornamenM.add("	Mats	");
        voornamenM.add("	Joshua	");
        voornamenM.add("	Mayson	");
        voornamenM.add("	Milo	");
        voornamenM.add("	Lorenzo	");
        voornamenM.add("	Pim	");
        voornamenM.add("	Collin	");
        voornamenM.add("	Jasper	");
        voornamenM.add("	Sepp	");
        voornamenM.add("	Wiebe	");
        voornamenM.add("	Damian	");
        voornamenM.add("	Samuel	");
        voornamenM.add("	Vinz	");
        voornamenM.add("	Jamie	");
        voornamenM.add("	Dani	");
        voornamenM.add("	Adam	");
        voornamenM.add("	Casper	");
        voornamenM.add("	Ezra	");
        voornamenM.add("	Kay	");
        voornamenM.add("	Mike	");
        voornamenM.add("	Niels	");
        voornamenM.add("	Tygo	");
        voornamenM.add("	Cas	");
        voornamenM.add("	Jurre	");
        voornamenM.add("	Tobias	");
        voornamenM.add("	Jorrit	");
        voornamenM.add("	Bryan	");
        return voornamenM;
    }

    /**
     * Maakt een lijst van alle data van 1-1-1970 tot 31-12-2001
     * @return arraylist met data
     */
    private static ArrayList<LocalDate> maakData() {
        ArrayList<LocalDate> data = new ArrayList<>();

        //begindatum vaststellen
        LocalDate startLocalDate = LocalDate.of(1970,1,1);

        //einddatum vaststellen
        LocalDate endLocalDate = LocalDate.of(2001, 12, 31);

        //voeg begindatum toe aan arraylist
        data.add(startLocalDate);

        //ga langs alle data van begindatum tot einddatum en voeg ze toe aan de arraylist
        for (int i = 0; i < ChronoUnit.DAYS.between(startLocalDate, endLocalDate); i++) {
            data.add(startLocalDate.plusDays(i + 1));
        }
        return data;
    }
}
