package com.anagram.matcher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AnagramFinder{
  FileReader freader;
  String fileName;
  private Scanner sc;
  public AnagramFinder(String fileName) throws FileNotFoundException{
    freader = new FileReader(fileName); 
    this.fileName = fileName;
  }
  public void loadToMap() throws Exception {
    HashMap<String, ArrayList<String>> hmap = new HashMap<String, ArrayList<String>>();
    BufferedReader reader = new BufferedReader(freader);
    String line;
    long startTime = System.currentTimeMillis();

    while((line = reader.readLine()) != null) {
      char[] key = line.toLowerCase().toCharArray();
      Arrays.sort(key);
      if(hmap.containsKey(new String(key))) {
        ArrayList<String> temp = hmap.get(new String(key));
        temp.add(line);
        hmap.put(new String(key), temp);
      }
      else {
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(line);
        hmap.put(new String(key), temp);
      }      
    } 
    System.out.println("Dictionary loaded in " + (System.currentTimeMillis()- startTime));
    sc = new Scanner(System.in);
    System.out.print("AnagramFinder>");
    String in = sc.nextLine();
    while(!in.equals("exit")) {
      long start = System.currentTimeMillis();
      char[] checker = in.toLowerCase().toCharArray();
      Arrays.sort(checker);
      if(hmap.containsKey(new String(checker))) {
        int noOfWords = hmap.get(new String(checker)).size();
        if(noOfWords == 1) {
          System.out.println("No anagrams found for "+ in +" in "+ (System.currentTimeMillis()-start)+"ms");
        }else {
          System.out.println(noOfWords + " Anagrams found for " + in +" in " + (System.currentTimeMillis()-start)+"ms");
          ArrayList<String> anagramResult = hmap.get(new String(checker));
          System.out.println(String.join(", ", anagramResult));
        }
       
      }else {
        System.out.println("No anagrams found for "+ in +" in "+ (System.currentTimeMillis()-start)+"ms");
      }
      System.out.print("\n" + "AnagramFinder>");
      in = sc.nextLine();  
    }    
  }
  
}
