import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.sql.*;

/**
 * class KantineSimulatie
 * @version 2.0
 * @author Joost Blaauwiekel & Hessel Jager
 */
public class KantineSimulatie {

    //variabelen voor de database verbinding
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("KantineSimulatie");
    private EntityManager manager;
    private EntityManager manager2 = new EntityManager() {
        @Override
        public void persist(Object o) {

        }

        @Override
        public <T> T merge(T t) {
            return null;
        }

        @Override
        public void remove(Object o) {

        }

        @Override
        public <T> T find(Class<T> aClass, Object o) {
            return null;
        }

        @Override
        public <T> T find(Class<T> aClass, Object o, Map<String, Object> map) {
            return null;
        }

        @Override
        public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType) {
            return null;
        }

        @Override
        public <T> T find(Class<T> aClass, Object o, LockModeType lockModeType, Map<String, Object> map) {
            return null;
        }

        @Override
        public <T> T getReference(Class<T> aClass, Object o) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public void setFlushMode(FlushModeType flushModeType) {

        }

        @Override
        public FlushModeType getFlushMode() {
            return null;
        }

        @Override
        public void lock(Object o, LockModeType lockModeType) {

        }

        @Override
        public void lock(Object o, LockModeType lockModeType, Map<String, Object> map) {

        }

        @Override
        public void refresh(Object o) {

        }

        @Override
        public void refresh(Object o, Map<String, Object> map) {

        }

        @Override
        public void refresh(Object o, LockModeType lockModeType) {

        }

        @Override
        public void refresh(Object o, LockModeType lockModeType, Map<String, Object> map) {

        }

        @Override
        public void clear() {

        }

        @Override
        public void detach(Object o) {

        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public LockModeType getLockMode(Object o) {
            return null;
        }

        @Override
        public void setProperty(String s, Object o) {

        }

        @Override
        public Map<String, Object> getProperties() {
            return null;
        }

        @Override
        public Query createQuery(String s) {
            return null;
        }

        @Override
        public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
            return null;
        }

        @Override
        public Query createQuery(CriteriaUpdate criteriaUpdate) {
            return null;
        }

        @Override
        public Query createQuery(CriteriaDelete criteriaDelete) {
            return null;
        }

        @Override
        public <T> TypedQuery<T> createQuery(String s, Class<T> aClass) {
            return null;
        }

        @Override
        public Query createNamedQuery(String s) {
            return null;
        }

        @Override
        public <T> TypedQuery<T> createNamedQuery(String s, Class<T> aClass) {
            return null;
        }

        @Override
        public Query createNativeQuery(String s) {
            return null;
        }

        @Override
        public Query createNativeQuery(String s, Class aClass) {
            return null;
        }

        @Override
        public Query createNativeQuery(String s, String s1) {
            return null;
        }

        @Override
        public StoredProcedureQuery createNamedStoredProcedureQuery(String s) {
            return null;
        }

        @Override
        public StoredProcedureQuery createStoredProcedureQuery(String s) {
            return null;
        }

        @Override
        public StoredProcedureQuery createStoredProcedureQuery(String s, Class... classes) {
            return null;
        }

        @Override
        public StoredProcedureQuery createStoredProcedureQuery(String s, String... strings) {
            return null;
        }

        @Override
        public void joinTransaction() {

        }

        @Override
        public boolean isJoinedToTransaction() {
            return false;
        }

        @Override
        public <T> T unwrap(Class<T> aClass) {
            return null;
        }

        @Override
        public Object getDelegate() {
            return null;
        }

        @Override
        public void close() {

        }

        @Override
        public boolean isOpen() {
            return false;
        }

        @Override
        public EntityTransaction getTransaction() {
            return null;
        }

        @Override
        public EntityManagerFactory getEntityManagerFactory() {
            return null;
        }

        @Override
        public CriteriaBuilder getCriteriaBuilder() {
            return null;
        }

        @Override
        public Metamodel getMetamodel() {
            return null;
        }

        @Override
        public <T> EntityGraph<T> createEntityGraph(Class<T> aClass) {
            return null;
        }

        @Override
        public EntityGraph<?> createEntityGraph(String s) {
            return null;
        }

        @Override
        public EntityGraph<?> getEntityGraph(String s) {
            return null;
        }

        @Override
        public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> aClass) {
            return null;
        }
    };

    //de kansen om studenten, docenten en medewerkers te krijgen
    static int kansStudenten = 89;
    static int kansDocenten = 10;
    static int kansKantineMedewerkers = 1;
    static int totaalKans = kansStudenten + kansDocenten + kansKantineMedewerkers;

    // ArrayList personen
    private ArrayList<Persoon> personen = new ArrayList();

    //BSNCounter wordt gebruikt om ervoor te zorgen dat elke BSN uniek blijft
    private static int BSNCounter = 1;

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random = new Random();

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // aantal dagen van simulatie
    private static final int AANTAL_DAGEN = 7;

    // artikelen
    private static final String[] artikelnamen = new String[]
            {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[]{1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    /**
     * Start een simulatie
     */
    public static void main(String[] args) {
        //als kansen van de typen personen moeten altijd 100% totaal zijn
        if(!(totaalKans == 100)) {
            System.out.println("Kansen moeten totaal 100% zijn. Het is nu: " + (totaalKans) + "%");
            return;
        }

        //Initialiseer de simulatie
        KantineSimulatie simulatie = new KantineSimulatie();

        //Begin simulatie
        simulatie.simuleer(AANTAL_DAGEN);

        //Voer de queries uit
        simulatie.totaalAggregate();
        simulatie.gemiddeldAggregate();
        simulatie.besteDrie();

        //Stop EntityManager
        simulatie.manager.close();
        simulatie.ENTITY_MANAGER_FACTORY.close();
    }

    /**
     * Constructor van KantineSimulatie
     */
    public KantineSimulatie() {
        //Initialiseer manager
        this.manager = ENTITY_MANAGER_FACTORY.createEntityManager();

        //Maak kantine aan
        kantine = new Kantine(manager);

        //Maak kantine aanbod aan
        int[] hoeveelheden = getRandomArray(
                AANTAL_ARTIKELEN,
                MIN_ARTIKELEN_PER_SOORT,
                MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(
                artikelnamen, artikelprijzen, hoeveelheden);
        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen hoeveelheid dagen dat de kantine simuleert
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            //Random totaal aantal mensen
            int totaalPersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            //Maakt een arraylist van alle personen van vandaag
            maakLijstPersonen(totaalPersonen);
            for(Persoon persoon: personen) {
                System.out.println(persoon.toString());
            }

            // laat de personen maar komen...
            for(int j = 0; j < totaalPersonen; j++) {
                //Random totaal aantal artikelen
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

                //Pak een persoon uit de arraylist
                Persoon persoon = personen.get(j);

                //Initialiseer een dienblad van de persoon
                Dienblad dienblad = new Dienblad(persoon);

                //Creeer een String array voor geselecteerde artikelen
                String[] artikelen = geefArtikelNamen(getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN-1));

                //Voeg artikelen toe aan dienblad
                kantine.loopPakSluitAan(dienblad, artikelen);

                //Initialiseer een kassarij
                KassaRij kassarij = kantine.getKassaRij();

                //Persoon sluit achteraan in de rij
                kassarij.sluitAchteraan(persoon);
            }
            //Initialiseer een kassa
            Kassa kassa = kantine.getKassa();

            //Verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            //Geef weer hoeveel artikelen verkocht zijn en totale omzet van de dag
            System.out.printf("Aantal verkochte artikelen op %s: %d\ttotale omzet: €%.2f\n",
                    Administratie.getDay(i), kassa.aantalArtikelen(), kassa.hoeveelheidGeldInKassa());

            // reset de kassa en personenlijst voor de volgende dag
            kassa.resetKassa();
            personen.clear();
        }
    }

    /**
     * Methode om een array van random getallen liggend tussen
     * min en max van de gegeven lengte te genereren
     *
     * @param lengte lengte van array
     * @param min mininum getal
     * @param max maximum getal
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for(int i = 0; i < lengte ;i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl)
     * en max(incl) te genereren.
     *
     * @param min minimum getal
     * @param max maximum getal
     * @return Een random getal tussen min en max
     */
    public int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array
     * artikelnamen de bijhorende array van artikelnamen te maken
     *
     * @param indexen de indexen van de artikelen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        //Vind de artikelnaam van elk artikel in de indexen
        for(int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];
        }

        return artikelen;
    }

    /**
     * Genereert een willekeurig subklasse van Persoon
     * gebasseerd op de kansen
     * @return type persoon
     */
    public Persoon persoonGenerator(int BSN, String voornaam, String achternaam, char geslacht, LocalDate geboortedatum) {
        Persoon persoon;

        //geef een willekeurige int tot en met 100
        int randomPersoon = random.nextInt(100);

        //als randomPersoon tussen 1 en kansStudenten is, dan is het een student
        if(randomPersoon <= kansStudenten) {

            //Initialiseer student-specifieke parameters
            String studierichting = Administratie.getRandomStudierichting();;
            int studentnummer = getRandomValue(300000, 400000);

            //Maak een student aan
            persoon = new Student(BSN, voornaam, achternaam, geslacht, geboortedatum, studierichting, studentnummer);
        }
        //als randomPersoon tussen kansStudenten en kansStudenten+kansDocenten is, dan is het een docent
        else if(randomPersoon <= totaalKans-kansKantineMedewerkers) {

            //Initialiseer docent-specifieke parameters
            String afdeling = Administratie.getRandomStudierichting();

            //Afkorting is eerste twee letters van voor- en achternaam in hoofdletters
            String afkorting = (voornaam.substring(0,2).concat(achternaam.substring(0,2))).toUpperCase();

            //Maak een docent aan
            persoon = new Docent(BSN, voornaam, achternaam, geslacht, geboortedatum, afdeling, afkorting);
        }
        //als randomPersoon boven kansStudenten+kansDocenten is, dan is het een KassaMedewerker
        else {

            //Initialiseer kassamedewerker-specifieke parameters
            int medewerkersNummer = getRandomValue(100,400);
            boolean magKassaStaan = false;

            //Maak een kassamedewerker aan
            persoon = new KantineMedewerker(BSN, voornaam, achternaam, geslacht, geboortedatum, medewerkersNummer, magKassaStaan);
        }
        BSNCounter++;
        return persoon;
    }

    /**
     * Vult de arraylist met personen
     * @param aantal personen die toegevoegd worden
     */
    public void maakLijstPersonen(int aantal) {
        for(int x = 0; x < aantal; x++) {
            //50% welk geslacht het is
            char geslacht;
            if(Math.random() < 0.5) {geslacht = 'm';} else {geslacht = 'v';}

            //pakt een willekeurige voor- en achternaam uit een arraylist
            String voornaam = Administratie.getRandomVoornaam(geslacht);
            String achternaam = Administratie.getRandomAchternaam();

            //pakt een willekeurige datum uit een arraylist
            LocalDate geboortedatum = Administratie.getRandomDatum();

            //Initialiseerd persoon door methode op te geven en parameters door te geven
            Persoon persoon = persoonGenerator(BSNCounter, voornaam, achternaam, geslacht, geboortedatum);

            //voeg persoon toe aan personen Arraylist
            personen.add(persoon);
        }
    }

    /**
     * Query die totale omzet en korting laat zien
     */
    public void totaalAggregate() {
        Query query = manager.createQuery(
                "SELECT SUM(totaal) as 'totale omzet', SUM(korting) as 'totale korting' FROM Factuur"
        );
        List<Object[]> resultList = query.getResultList();
        resultList.forEach(a -> System.out.println(Arrays.toString(a)));
    }

    /**
     * Query die gemiddelde omzet en korting laat zien
     */
    public void gemiddeldAggregate() {
        Query query = manager.createQuery(
                "SELECT AVG(totaal) as 'gemiddelde omzet', AVG(korting) as 'gemiddelde korting' FROM Factuur"
        );
        List<Object[]> resultList = query.getResultList();
        resultList.forEach(a -> System.out.println(Arrays.toString(a)));
    }

    /**
     * Query die de hoogste drie facturen kwa omzet
     */
    public void besteDrie() {
        Query query = manager.createQuery(
                "SELECT totaal FROM Factuur ORDER BY totaal desc");
        query.setMaxResults(3);
        List<Double> resultList = query.getResultList();
        System.out.println("Top drie factureren qua omzet:\n");
        for(Double i : resultList) {
            System.out.printf("€%.2f\n",i);
        }
    }
}