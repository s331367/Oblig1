// Dusanth Selvarajah - S331367
// Rizwan Mahmoood - S331409
import java.util.*;

public class Oblig1 {

    //Oppgave 1
    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Tom Array");
        }

        int storst = a[0];

        for(int i=0; i<a.length; i++) {

            for(int j=1; j<a.length; j++) {

                if (a[i] > a[j]) {
                    storst = a[i];
                    a[i] = a[j];
                    a[j] = storst;
                } else {
                    storst = a[j];
                }
                i++;
            }
        }

        return storst;
    }

    public static int ombyttinger(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Tom Array");
        }

        int antall = 0; //Teller antall Ombyttinger
        int storst = a[0];
        for(int i=0; i<a.length; i++) {

            for(int j=1; j<a.length; j++) {

                if (a[i] > a[j]) {
                    storst = a[i];
                    a[i] = a[j];
                    a[j] = storst;
                    antall++;
                } else {
                    storst = a[j];
                }
                i++;
            }
        }

        return antall;
    }

    //1. Vi får flest ombytter om tabellen er i synkende rekkefølge
    //2. Vi får færrest ombytter om tabellen er i stigende rekkefølge
    //3. Vi har brukt metoden randPerm(int n) og ombyttinger(int[] a) for å finne gjennomsnittet.
    //   Etter noen prøver får vi at det er ca. n/2 i gjennomsnittet.
    //   Først prøvde vi med n=10, og vi fikk tilsammen 60 ombyttninger for 10 forsøk som er ca snitt n/2

    //Oppgave 2
    public static int antallUlikeSortert(int[] a){
        if(a.length == 0){ //Sjekker om arrayen er tom
            return 0;
        }
        if(a.length==1){
            return 1;
        }
        for(int i = 0; i<a.length-1; i++){
            if(a[i]>a[i+1]) throw new IllegalStateException("usortert tabell");
        }

        int temp = 0;//hjelpevariabel for å sammenligne med a[i], og om de er ulike eller ikke
        int antall = 0;//hjelpevarbel som teller antall ulike verdier
        for(int i = 0; i<a.length; i++){
            if(a[i]!=temp){//hvis verdiene ikke er like
                antall++;//pluss 1 på antall forskjellige verdier
            }
            temp=a[i];
        }
        return antall;//returner antall forskjellige verdier til slutt
    }

    //Oppgave 3
    public static int antallUlikeUsortert ( int [] a) {

        //Hjelpetabell som tar imot elementene fra tabell a, men alle verdiene i denne skal være unik fra hverandre
        List<Integer> liste = new ArrayList<Integer>();

        //For-løkke som suser gjennom en og en element i tabellen a
        for(int i=0; i<a.length; i++) {

            //If-setning som sjekker om hvis arraylisten er tom, så legges det a[i](samsvarer a[0]) i hjelpetabellen
            //Men hvis hjelpetabellen har en/fler elementer så sjekkes den om a[i] lik med noen av elementene i
            //hjelpetabellen, dersom ikke så legges det elementet i hjelpetabellen
            if (liste.size() == 0) {
                liste.add(a[i]);
            } else {
                for (int j = 0; j < liste.size(); j++)
                    if (liste.contains(a[i])) {
                        j = liste.size() - 1;
                    } else {
                        liste.add(a[i]);
                    }
            }
        }

        return liste.size(); //Skriver ut antall ulike elementer i tabellen a, som ligger i hjelpetabellen
    }

    //Oppgave 4
    public static void delsortering ( int[] a) {
        if(a.length == 0 || a.length == 1) {
            return;
        }

        int venstre = 0;
        int hoyre = a.length -1;

        //Finner antall oddetall og partall
        int oddeTall = 0;
        int parTall = 0;


        for(int i = 0; i<a.length; i++) {
            if((a[i]&1)==1) {
                oddeTall++;
            } else {
                parTall++;
            }
        }

        //hvis det er kun partall eller oddetall, trenger vi ikke aa lete etter index
        //til skilleverdien
        if(parTall == 0 || oddeTall == 0) {
            kvikksortering0(a,0,a.length-1);//sorterer hele tabellen
        }

        //Soker fra begge sider, oddetall skyves bort til venstre, mens partall tl høyre
        while (venstre<hoyre) {
            while((a[venstre]&1)==1 && venstre < hoyre) {
                venstre++;
            }

            while((a[hoyre]&1)==0 && venstre < hoyre) {
                hoyre--;
            }

            if(venstre<hoyre) {
                int temp = a[venstre];
                a[venstre] = a[hoyre];
                a[hoyre] = temp;
                venstre++;
                hoyre--;
            }
        }
        //bruker kvikksorteringsmetoden til å sortere oddetall og partall i stigende rekkefolge
        kvikksortering(a,0,oddeTall);
        kvikksortering(a,oddeTall,a.length);
    }

    //Oppgave 5
    public static void rotasjon(char[] a) {//roterer en verdi til høyre, og siste verdi til starten av arrayet
        if(a.length > 0) {
            char temp = a[a.length-1];//tilordner siste verdien til temp
            for (int i = a.length-1; i>0; i--) {
                a[i]=a[i-1];//flytter en og en verdi til høyre
            }
            a[0]=temp;//tilorden første verdien den siste

        } else {
            return;
        }
    }



    //oppgave 6
    public static void rotasjon(char[] a, int k) {

        if(a.length == 1 || a.length == 0) {
            return; //skjer ingen rotasjon hvis tabellen har et element
            // eller er tom
        }

        int n = a.length;
        if((k%=n)<0) k+= n;     //motsatt vei hvis k r negativ

        //Bruker euklids algoritme for da slipper vi å tenke på sykler, altså
        //en hel 360 rotasjon
        //hvis vi har en tabell på 10 elementer og den skal roteres 16 ganger
        //trenger vi bare å rotere den 6 ganger for etter de første 10 gangene,
        //kommer verdiene tilbake til deres startverdier
        int s = gcd(n,k);

        for(int z = 0; z<s; z++) {
            char verdi = a[z];
            for(int i = z-k, j=z; i!=z; i-=k) {
                if(i<0) i+= n;
                a[j]=a[i]; j = i;
            }
            a[z+k]=verdi;
        }
    }

    //Oppgave 7a
    public static String flett (String s, String t) {
        //Splitter hvertbokstav fra s og t til en array
        String[] sSplit = s.split("");
        String[] tSplit = t.split("");

        //If setning som finner arrayen med størst lengde mellom sSplit og tSplit
        int lengde=0;
        if(sSplit.length>tSplit.length) {
            lengde = sSplit.length;
        } else {
            lengde = tSplit.length;
        }

        //For-løkke som setter sammen indeks 0 fra sSplit og tSplit, så indeks 1 i sSplit og tSplit.....
        //etterhverandre helt til løkken har lest alle indeksene i begge array
        String ut="";
        for(int i=0; i<lengde; i++) {
            if(i < sSplit.length && i < tSplit.length) {
                ut += sSplit[i] + tSplit[i];
            } else if(i >= sSplit.length) {
                ut += tSplit[i];
            } else {
                ut += sSplit[i];
            }
        }

        return ut; //Skriver ut resultatet
    }

    public static String flett (String... s) {
        int lengde=0;
        if(s.length == 1) {
            return s[0];
        } else if(s.length == 0) {
            return "";
        } else {
            lengde = s[0].length();
            for(int i=1; i<s.length; i++) {
                if(s[i].length()>lengde) {
                    lengde = s[i].length();
                }
            }
        }

        String ut="";
        for(int i=0; i<lengde; i++) {
            int j=0;
            while(j < s.length) {
                String tekst = s[j];
                String[] sSplit = tekst.split("");

                if (i > sSplit.length-1) {
                    j++;
                } else {
                    ut += sSplit[i];
                    j++;
                }
            }
            j=0;
        }

        return ut;
    }


    //Oppgave 8
    public static int [] indekssortering ( int [] a) {
        int[] aStigende = a.clone();
        int[] indeksStigende = new int [a.length];
        int tmp;

        for(int i=0; i<aStigende.length; i++) {
            for(int j=0; j<aStigende.length-1; j++) {
                if (aStigende[j + 1] < aStigende[j]) {
                    tmp = aStigende[j + 1];
                    aStigende[j + 1] = aStigende[j];
                    aStigende[j] = tmp;
                }
            }
        }

        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a.length; j++) {
                if(a[j] == aStigende[i]) {
                    indeksStigende[i] = j;
                }
            }
        }

        return indeksStigende;
    }



    //Oppgave 9
    public static int[] tredjeMin(int [] a) {
        // If-setning som sjekker om det er flere elementer enn 3
        if (a.length < 3) {
            throw new java.util.NoSuchElementException("Tabellen må har minimum 3 verdier");
        }

        //Hjelpetabell som tar inn tre første verdiene fra tabell a ved hjelp av en for-løkke
        int[] treForsteVerdier = new int[3];
        for (int i=0; i<3; i++) {
            treForsteVerdier[i] = a[i];
        }

        //Sorterer tabellen treForsteVerdier, for å finne ut det minste av de tre
        int[] indeks = indekssortering(treForsteVerdier);

        int m = treForsteVerdier[indeks[0]];      // m er posisjonen til minste verdi
        int nm = treForsteVerdier[indeks[1]];     // nm er posisjonen til nest minste verdi
        int nnm = treForsteVerdier[indeks[2]];    // nnm er posisjonen til nest nest minste verdi

        int tmp;
        for (int i = 3; i < a.length; i++) {
            if (a[i] < nnm){
                tmp = nnm;
                nnm = a[i];

                if (a[i] < nm){
                    nnm = nm;
                    nm = a[i];

                    if(a[i] < m){
                        nm = m;
                        m = a[i];
                    }
                }
            }
        }

        int indeksM = 0;            // indeksen til minste verdi
        int indeksNM = 0;           // indeksen til nest minste verdi
        int indeksNNM = 0;          // indeksen til nest nest minste verdi

        //For-løkke som finner indeksene til minste (m), nestminste (nm) og nestnestminste (nnm) index
        for(int i=0; i<a.length; i++){
            if(a[i] == m){
                indeksM = i;   //m indeks legges i variabelen indekM
            } else if(a[i] == nm){
                indeksNM = i;  //nm indeks legges i variabelen indekNM
            } else if(a[i] == nnm){
                indeksNNM = i; //nnm indeks legges i variabelen indekNNM
            }
        }

        return new int[] {indeksM,indeksNM,indeksNNM};    // m i posisjon 0, nm i posisjon 1, nnm i posisjon 3
    }

    //Oppgave 10
    public static boolean inneholdt (String a, String b) {

        //Deler opp hvert bokstav i String a og String b. Bokstavene satt i en annen array. a til aSplit og b til bSplit.
        char[] aSplit = a.toCharArray();
        char[] bSplit = b.toCharArray();

        //Sorterer listene, altså aSplit og bSplit ved å bruke kvikksortering
        kvikkSortChar(aSplit, 0, aSplit.length-1);
        kvikkSortChar(bSplit, 0, bSplit.length-1);

        return inklusjon(aSplit, bSplit, aSplit.length, bSplit.length);

    }







    //Hjelpemetoder fra kompendiet
    public static boolean inklusjon(char[] a, char[] b, int aLengde, int bLengde) {
        // Vi har ikke noe arbeid å gjore, saa vi returnerer
        if (a.length == 0 || (a.length ==0 & b.length == 0)) {
            return true;
        } else if(b.length==0){
            return false;
        }

        int i = 0, j = 0;
        int ekstra=0;

        //Løkke som kjøres så lenge i er mindre enn aLengde og j er mindre enn bLengde
        while (i < aLengde && j < bLengde) {
            if (a[i] < b[j]){ //Elementet i a[i](altså bokstavet) er mindre enn elementet i b[j], så økes i med 1
                i++;
            } else if (a[i] == b[j]) { //Hvis elementene(altså bokstavene) i a[i] er lik med b[j] så økes i og j med 1
                i++;
                j++;
            } else { //Hvis a[i] ikke er et element i b[j] så retuneres det false;
                j++;
                ekstra++;
            }
        }
        if(j-ekstra == i) {
            if(a.length == b.length && ekstra != 0) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static void kvikkSortChar(char[] a, int fra, int til) {
        // Vi har ikke noe arbeid å gjore, saa vi returnerer
        if (fra >= til) {
            return;
        }

        int midtpunktVerdi = a[fra + (til - fra) / 2]; // Finner verdien til midtpunktet

        int i = fra;
        int j = til;

        while (i <= j) {
            while (a[i] < midtpunktVerdi) {
                i++; //Øker med 1 hvis verdien i a[i] er mindre en midtpunktverdien
            }

            while (a[j] > midtpunktVerdi) {
                j--; //Minker med 1 hvis verdien i a[j] er mindre en midtpunktverdien
            }

            if (i <= j) {
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        kvikkSortChar(a, fra, j); // Sorterer arrayen før og med midpunktsverdien
        kvikkSortChar(a,i,til );  // Sorterer arrayen etter og med midpunktsverdien
    }

    public static int gcd(int a, int b) {
        if (a == 0) { return b;}
        return gcd(b%a,a);
    }

    public static int partisjon(int[] a, int v, int h, int skilleverdi) {
        while(v <= h && a[v]<skilleverdi){
            v++;// v kan ikke stige h
        }
        while(v<=h && a[h]>=skilleverdi){
            h--;//h kan ikke gå forbi v
        }
        while(true){

            if(v<h){
                bytt(a,v++,h--); //bytter om a[v] og a[h]
            }else{
                return v; // a[v] er nåden førstet som ikke er mindre enn skilleverdi
            }
            while (a[v] < skilleverdi){
                v++;
            }
            while (a[h]>=skilleverdi){
                h--;
            }

        }
    }

    public static int sPartisjon(int[] a, int v, int h, int indeks) {
        bytt(a,indeks,h);               //skilleverdi a[indeks] flyttes bakerst
        int pos = partisjon(a,v,h-1,a[h]);  //partisjonerer a[v:h-1]
        bytt(a, pos, h);                //bytter for å få skileverdien på rett plass
        return pos;                     //returnerer posisjonen til skilleverdien
    }

    private static void kvikksortering0(int[] a, int v, int h) {
        if(v >= h) return; //a[v:h] er tomt eller har maks ett element
        int k = sPartisjon(a,v,h,(v+h)/2); //bruker midtverdien
        kvikksortering0(a,v,k-1);       //sorterer intervallet a[v:k-1]
        kvikksortering0(a,k+1,h);       //sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) {//a[fra:til>
        kvikksortering0(a,fra,til-1);
    }

    public static void bytt(int[] c, int i, int j) {
        int temp = c[i]; c[i] = c[j]; c[j] = temp;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall
        for (int i = 0; i < n; i++)
            a[i] = i + 1;                  // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1);        // en tilfeldig tall fra 0 til k

            int temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }

        return a;                        // permutasjonen returneres
    }


}
