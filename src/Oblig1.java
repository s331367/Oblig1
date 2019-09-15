import java.util.Arrays;

public class Oblig1 {

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

    public static void  indekssortering( int [] a){
        int[] indeksStigende = {};
        int tmp;

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length-1; j++){
                    if (a[j + 1] < a[j]) {
                        tmp = a[j + 1];
                        a[j + 1] = a[j];
                        a[j] = tmp;
                    }
            }

        }

        for(int k : a) System.out.print(k + " ");
    }

    public static void main(String[] args){
        /*String a = flett ( "ABC" , "DEFGH" );
        String b = flett ( "IJKLMN" , "OPQ" );
        String c = flett ( "" , "AB" );
        System. out .println(a + " " + b + " " + c);*/

        int [] a = {6,10,16,11,7,12,3,9,8,5};
        indekssortering(a);

        // Utskrift: [6, 10, 16, 11, 7, 12, 3, 9, 8, 5] a er ikke endret
        // Utskrift: [6, 9, 0, 4, 8, 7, 1, 3, 5, 2]

    }
}
