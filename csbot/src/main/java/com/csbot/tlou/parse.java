package com.csbot.tlou;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class parse {
    
    
    
    public static void main(String[] args){
        Document doc = null;
        try {
            doc = Jsoup.connect("https://liquipedia.net/counterstrike/S-Tier_Tournaments").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String title = doc.title();
        System.out.println(title);
        Element twenty_two = doc.getElementsByClass("divTable table-full-width tournament-card").first();
        Elements divs = twenty_two.getElementsByClass("divRow");
        //System.out.println(twenty_two.text());
        
        for (Element div : divs){
            System.out.println(div.text());
        }
        
        Date d = new Date();
        System.out.println(d.getDate());
    }


    
    

    
}
