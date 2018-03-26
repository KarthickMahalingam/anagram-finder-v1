package com.anagram.matcher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        AnagramFinder a = new AnagramFinder(args[0]);
        System.out.println("Welcome to Anagram Finder");
        System.out.println("-------------------------");
        a.loadToMap();
    }
}
