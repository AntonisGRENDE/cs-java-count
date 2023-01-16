package main.service;

import java.util.Random;

public class GenerateData {
    public static String generateNumbers(int iterations){ //duplicate-inclusive
        StringBuilder n = new StringBuilder();
        Random r;
        for (int i = 0; i < iterations; i++){
            r = new Random();
            n.append("+43 ").append(r.nextInt(79999999)+10999999).append("\n");
            n.append("+49 ").append(r.nextInt(79999999)+10999999).append("\n");
            n.append("+30 ").append(r.nextInt(79999999)+10999999).append("\n");
            n.append("+81 ").append(r.nextInt(79999999)+10999999).append("\n");
        }
        return n.toString();
    }


    public static String generateEmails(){
        String prefix [] = {"Mozart", "Goedel", "Turing", "Dijkstra", "Babbage", "Alan", "Tannenbaum", "Gosling", "Bolzano", "Hawking", "Becker", "Armin", "Kugel", "Steinmeier", "Steinmeier", "Evergarden", "Gilbert", "Lauterbach", "Manousos", "Straus",
                            "Bach", "Merkel", "Scholz","Berthold","Kokkinou","Anj","Beesly", "lee", "Martsakis", "Solomos", "Diligiannis","palutena", "Hades", "Aaron",  "Rousos", "Lauterbach", "Kingston", "Erica", "Eren", "mikaela", "Yuichiro"};
        String postfix [] = {"@gmail.com", "@yahoo.gr", "@gmx.de", "@t-online.com", "@t-online.de", "@outlook.com", "@aol.com", "@iCloud.com", "@eurobank.gr", "@agileactors.com"};
        StringBuilder s = new StringBuilder();
        Random r ;
        int randomize_more;
        for (int i = 0; i < 10000; i++){
            r = new Random();
            randomize_more = i * r.nextInt();
            s.append(prefix[randomize_more % prefix.length]).append(r.nextInt(999))
                    .append(postfix[r.nextInt() % prefix.length]).append("\n");
        }
        return s.toString();
    }


}
