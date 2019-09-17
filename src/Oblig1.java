// Dusanth Selvarajah - S331367
// Rizwan Mahmoood - S331409

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

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
    public static int antallUlikeUsortert ( int [] a){
        if(a.length == 0){
            return 0;
        }
        if(a.length == 0){
            return 1;
        }
        int antall = 0;
        for(int i = 0; i<a.length; i++){//første verdien
            for(int j = i+1; j<a.length; j++){
                if(a[i]==a[j]){//sammenligner de resterende verdiene
                    //med første verdien, om det finnes duplikater
                    antall++;//hvis ja, legges det til inn på antall
                }
            }
            antall++;
        }
        return antall;//Trekker duplikater fra antall verdier
    }

    //Oppgave 4
    public static void delsortering ( int[] a) {
        int j=0;
        for(int i=0; i<a.length; i++) {
            int tmp = a[j];
            if(a[i] % 2 == 0){

            } else {
                a[j] = a[i];
                a[i] = tmp;
                j++;

            }
        }

        int storstOdd = a[0];
        for(int i=0; i<j-1; i++) {
            for(int k=1; k<j; k++) {
                if (a[i] > a[k]) {
                    storstOdd = a[i];
                    a[i] = a[k];
                    a[k] = storstOdd;
                } else {
                    storstOdd = a[k];
                }
                i++;
            }
        }

        int storstPartall = a[j];
        for(int i=j; i<a.length-1; i++) {
            for(int k=j+1; k<a.length; k++) {
                if (a[i] > a[k]) {
                    storstPartall = a[i];
                    a[i] = a[k];
                    a[k] = storstPartall;
                } else {
                    storstPartall = a[k];
                }
                i++;
            }
        }
        System.out.println(j);

        for(int k : a) {
            System.out.print(k +" ");
        }
    }

    //Oppgave 7a
    public static String flett (String s, String t) {
        //Splitter hvertbokstav fra s og t til en array
        String[] sSplit = s.split("");
        String[] tSplit = t.split("");

        //If setning som finner arrayen med størst lengde mellom sSplit og tSplit
        int lengde=0;
        if(sSplit.length>tSplit.length){
            lengde = sSplit.length;
        } else {
            lengde = tSplit.length;
        }

        //For-løkke som setter sammen indeks 0 fra sSplit og tSplit, så indeks 1 i sSplit og tSplit.....
        //etterhverandre helt til løkken har lest alle indeksene i begge array
        String ut="";
        for(int i=0; i<lengde; i++){
            if(i < sSplit.length && i < tSplit.length){
                ut += sSplit[i] + tSplit[i];
            } else if(i >= sSplit.length){
                ut += tSplit[i];
            } else {
                ut += sSplit[i];
            }
        }

        return ut; //Skriver ut resultatet
    }

    public static String flett (String... s){
        int lengde=0;
        if(s.length == 1){
            return s[0];
        } else if(s.length == 0){
            return "";
        } else {
            lengde = s[0].length();
            for(int i=1; i<s.length; i++){
                if(s[i].length()>lengde){
                    lengde = s[i].length();
                }
            }

        }

        String ut="";
        for(int i=0; i<lengde; i++){
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
    public static int [] indekssortering ( int [] a){
        int[] aStigende = a.clone();
        int[] indeksStigende = new int [a.length];
        int tmp;

        for(int i=0; i<aStigende.length; i++){
            for(int j=0; j<aStigende.length-1; j++){
                if (aStigende[j + 1] < aStigende[j]) {
                    tmp = aStigende[j + 1];
                    aStigende[j + 1] = aStigende[j];
                    aStigende[j] = tmp;
                }
            }
        }

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                if(a[j] == aStigende[i]){
                    indeksStigende[i] = j;
                }
            }
        }


        return indeksStigende;
    }



    //Oppgave 9
    public static int[] tredjeMin ( int [] a){
        int n = a.length;     // tabellens lengde
        if (n < 3) throw      // må ha minst tre verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        //Tabell som tar inn tre første verdiene fra tabell a ved hjelp av en for-løkke
        int[] treForsteVerdier = new int[3];
        for (int i=0; i<3; i++){
            treForsteVerdier[i] = a[i];
        }

        int m = 0;      // m er posisjonen til minste verdi
        int nm = 1;     // nm er posisjonen til nest minste verdi
        int nnm = 2;    // nnm er posisjonen til nest nest minste verdi

        // bytter om m og nm hvis a[1] er større enn a[0]
        if (a[2] < a[1]) { nnm = 1; nm = 0; }


        int minstverdi = a[m];                // minste verdi
        int nestminstverdi = a[nm];           // nest minste verdi
        int nestnestminstverdi = a[nnm];      // nest nest minste verdi

        for (int i = 3; i < n; i++)
        {
            if (a[i] > nestminstverdi)
            {
                if (a[i] > minstverdi)
                {
                    nm = m;
                    nestminstverdi = minstverdi;     // ny nest størst

                    m = i;
                    minstverdi = a[m];              // ny størst
                }
                else
                {
                    nm = i;
                    nestminstverdi = a[nm];         // ny nest størst
                }
            }
        } // for

        return new int[] {m,nm};    // n i posisjon 0, nm i posisjon 1
    }



    public static void main(String[] args){
        /*String a = flett ( "ABC" , "DEFGH" );
        String b = flett ( "IJKLMN" , "OPQ" );
        String c = flett ( "" , "AB" );
        System. out .println(a + " " + b + " " + c);*/

        //int [] a = {16,6,12,11,7,12,3,9,8,5};
        //tredjeMin(a);

        String a = flett ("AM ", "L", "GEDS", "ORATKRR", "", "R TRTE", "IO", "TGAUU");
        System. out .println(a);


        //int [] indeks = indekssortering (a);

        // Utskrift: [6, 10, 16, 11, 7, 12, 3, 9, 8, 5] a er ikke endret
        // Utskrift: [6, 9, 0, 4, 8, 7, 1, 3, 5, 2]

    }

}
