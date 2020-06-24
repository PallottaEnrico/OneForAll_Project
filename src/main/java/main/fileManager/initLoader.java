/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.fileManager;

import exceptions.GameNotFoundException;
import exceptions.LanguageNotFoundException;
import games.GenericGame;
import games.TryToStudy;

import java.io.*;

/**
 *
 * @author enrico
 */
public class initLoader {
    
    public static final String CONFIG = "./src/main/resources/config.txt";
    
    public static String loadGameClass() throws Exception{
        BufferedReader input = new BufferedReader(new FileReader(CONFIG));
        
        String current;
        
        current = input.readLine();
        
        if(current.toLowerCase().startsWith("game")){
            current = current.replaceAll("game","");
            current = current.replaceAll(" ", "");
            current = current.replaceAll("=", "");
            current = current.replaceAll("\"", "");

            return "games." + current;
        }
        throw new GameNotFoundException();
    }
    
    public static String loadLanguage() throws Exception{
        BufferedReader input = new BufferedReader(new FileReader(CONFIG));
        
        String current;
        
        current = input.readLine();
        current = input.readLine();
        
        if(current.contains("language")){
            current = current.replaceAll("language", "");
            current = current.replaceAll("=", "");
            current = current.replaceAll(" ", "");
            current = current.replaceAll("\"", "");
            
            return "parser." + current + "Parser";
        }
        throw new LanguageNotFoundException();
    }

    public static void writeDefaultGame() throws Exception {
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("/home/enrico/IdeaProjects/EnricoPallotta_MAProject/src/main/resources/TryToStudyDefault.dat"));
        GenericGame game = new TryToStudy();
        game.init();
        obj.writeObject(game);
    }

    public static GenericGame loadGame() throws Exception{
        ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("/home/enrico/IdeaProjects/EnricoPallotta_MAProject/src/main/resources/TryToStudyDefault.dat"));
        GenericGame game = (GenericGame) inStream.readObject();
        return game;
    }
}
