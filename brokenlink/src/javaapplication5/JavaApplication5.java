/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.DataInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author fatih01
 */
public class JavaApplication5 {

      public static ArrayList<String> linkbul(String link){ 
        ArrayList<String> urller=new ArrayList<String>();
     String pattern =  "\\b(https?|ftp|file|/|)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

      Pattern r = Pattern.compile(pattern);

      Matcher m = r.matcher(link);
    while(m.find()){   
    urller.add(m.group()); 
    }
    return urller;
 }
    
  public static int linkkontrol(String url){
      int responseCode = 0;
         if(url.equalsIgnoreCase("https")) {
        
     
        try {
            
        HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        responseCode = connection.getResponseCode();
 
       }
        
catch (Exception e) {
        }
    } else {

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        responseCode = connection.getResponseCode();
       
 
       }
           
          catch (Exception e) {
        }
    }
  return responseCode;
  }
   public String getHTML(String url) {
        String content = null;
        URLConnection connection = null;
        try {
            connection = new URL(url).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream(), "UTF-8");
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        } catch (Exception e) {
            
        }
        URLConnection urlConn = null;
        DataInputStream input = null;
        return content;
    }
    public static void main(String[] args) {
      JavaApplication5 aa=new JavaApplication5();
       
        String adres = "http://turkishcodergirls.com/";
        String sites=aa.getHTML(adres);
        sites=sites.substring(sites.lastIndexOf("<body"));
        sites=sites.substring(0,sites.indexOf("</body>"));
               ArrayList<String> calısan=new ArrayList<String>();
               ArrayList<String> liste300=new ArrayList<String>();
                   ArrayList<String> liste400=new ArrayList<String>();
                   ArrayList<String> liste500=new ArrayList<String>();
  
                   int len=linkbul(sites).size();
        for(int a=1;a<len;a++){
        String deneme=linkbul(sites).get(a);
        if(linkkontrol(deneme)==200){
        calısan.add(deneme);
            System.out.println(deneme); System.out.println("**************************************************");
String sites2=aa.getHTML(deneme);

        for(int a1=0;a1<linkbul(sites2).size();a1++){
           
        String deneme2=linkbul(sites2).get(a1);
            int uzu=linkbul(sites2).size();
         
            if(linkkontrol(deneme2)==200)
            {
                System.out.println(deneme2);
            }else{
            
            liste400.add(deneme2);}
            
            }
        
        
        
        }else{
        liste400.add(deneme);
        }
       
            
        } 
//        for(int v=0;v<calısan.size();v++){
//            
//                System.out.println(calısan.get(v));
//            
//            }
            
         }
    
}
