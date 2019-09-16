import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oblig1 {

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

    //Oppgave 7b

    public static String flett (String... s){

        String ut="";
        for(int i=0; i<s.length; i++){
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
                new java.util.NoSuchElementException("a.length(" + n + ") < 3!");


        //En array som får tre første verdiene
        int[] treForsteVerdier = new int[3];


        int[] indeksStigende = indekssortering(a);

        int m = indeksStigende[0];      // m er posisjonen til minste verdi
        int nm = indeksStigende[1];     // nm er posisjonen til nest minste verdi
        int nnm = indeksStigende[3];    // nnm er posisjonen til nest nest minste verdi

        // bytter om m og nm hvis a[1] er større enn a[0]
        if(a[2] < a[1]) { nnm = 1; nm = 2; }
        if(a[1] < a[0]) { nm =0; m=1; }

        int minstverdi = a[m];                // minste verdi
        int nestminstverdi = a[nm];           // nest minste verdi
        int nestnestminstverdi = a[nnm];      // nest nest minste verdi

        for (int i = 3; i < n; i++){

            if (a[i] < nestnestminstverdi){
                nnm = nm;
                nestnestminstverdi = nestminstverdi;
                m=i;

                nestminstverdi = a[nm];

                if(a[i] < nestminstverdi){

                    if (a[i] > minstverdi){
                        nm = m;
                        nestminstverdi = minstverdi;     // ny nest størst

                        m = i;
                        minstverdi = a[m];              // ny størst
                    } else {
                        nm = i;
                        nestminstverdi = a[nm];         // ny nest størst
                    }
                }
            }
        } // for

        return new int[] {m,nm, nnm};    // n i posisjon 0, nm i posisjon 1
    }



    //Oppgave 10
    public static boolean inneholdt (String a, String b) {
        String[] aSplit = a.split("");
        String[] bSplit = b.split("");

        //Finner arrayen som har størst lengde av sSplit og tSplit
        int lengde=0;
        if(bSplit.length>aSplit.length){
            lengde = bSplit.length;
        } else {
            lengde = aSplit.length;
        }


        List<String> antallLik = new ArrayList<String>();
        for(int i=0; i<lengde; i++){
            int antall=1;
            for (int j=1; j<lengde; j++) {
                if (aSplit[i] == aSplit[j]) {
                    antall++;

                }
            }
        }

    }



    public static void main(String[] args){
        /*String a = flett ( "ABC" , "DEFGH" );
        String b = flett ( "IJKLMN" , "OPQ" );
        String c = flett ( "" , "AB" );
        System. out .println(a + " " + b + " " + c);*/

        int [] a = {16,6,12,11,7,12,3,9,8,5};
        System.out.print(Arrays.toString(tredjeMin(a)));


        //int [] indeks = indekssortering (a);

        // Utskrift: [6, 10, 16, 11, 7, 12, 3, 9, 8, 5] a er ikke endret
        // Utskrift: [6, 9, 0, 4, 8, 7, 1, 3, 5, 2]

    }

}
