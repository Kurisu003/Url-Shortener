package UrlShortner;

import java.util.*;

public class Main {

    static Hashtable<String, String> longUrlKey = new Hashtable<String, String>();
    static Hashtable<String, String> shortUrlKey = new Hashtable<String, String>();
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    static int firstPosCounter  = 0;
    static int secondPosCounter = 0;
    static int thirdPosCounter  = 0;
    static int fourthPosCounter = 0;

    public static void main(String[] args) {

        System.out.println(urlShortener("test"));
        System.out.println(urlShortener("test"));

    }

    public static String urlRedirector(String shortUrl){
        return shortUrlKey.get(shortUrl);
    }

    public static String urlShortener(String longUrl){

        if(longUrlKey.containsKey(longUrl)){
            return longUrlKey.get(longUrl);
        }

        firstPosCounter = ++firstPosCounter % 26;
        if (firstPosCounter % 26 == 0) {
            secondPosCounter = ++secondPosCounter % 26;
            if (secondPosCounter % 26 == 0) {
                thirdPosCounter = ++thirdPosCounter % 26;
                if (thirdPosCounter % 26 == 0) {
                    fourthPosCounter = ++fourthPosCounter % 26;
                }
            }
        }

        longUrlKey.put(longUrl, "short.ly/" + alphabet[fourthPosCounter] + "" + alphabet[thirdPosCounter] + "" + alphabet[secondPosCounter] + "" + alphabet[firstPosCounter]);
        shortUrlKey.put("short.ly/" + alphabet[fourthPosCounter] + "" + alphabet[thirdPosCounter] + "" + alphabet[secondPosCounter] + "" + alphabet[firstPosCounter], longUrl);

        return "short.ly/" + alphabet[fourthPosCounter] + "" + alphabet[thirdPosCounter] + "" + alphabet[secondPosCounter] + "" + alphabet[firstPosCounter];
    }

}
