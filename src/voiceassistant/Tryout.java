/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voiceassistant;

/**
 *
 * @author WhiteshadoW
 */

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;

public class Tryout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // Configuration Object
        Configuration configuration = new Configuration();
        try{
               // Set path to the acoustic model.
               configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
               // Set path to the dictionary.
               configuration.setDictionaryPath("/Users/WhiteshadoW/Desktop/tryout/1684.dic");
               // Set path to the language model.
               configuration.setLanguageModelPath("/Users/WhiteshadoW/Desktop/tryout/1684.lm");
               
                //Recognizer Object, Pass the Configuration object
                LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);

                //Start Recognition Process (The bool parameter clears the previous cache if true)
                recognize.startRecognition(true);
                //Create SpeechResult Object
                 SpeechResult result;
                //Checking if recognizer has recognized the speech
                while ((result = recognize.getResult()) != null) {
                    //Get the recognize speech
                    String command = result.getHypothesis();
                    String work = null;
                    Process p;
                    
                    //Match recognized speech with our commands
                        if(command.equalsIgnoreCase("open file manager")) {
                            work = "explorer";
                        } else if (command.equalsIgnoreCase("close file manager")) {
                            work = "Taskkill /IM explorer.exe /F";
                        } else if (command.equalsIgnoreCase("open browser")) {
                            work = "C://Program Files (x86)/Google/Chrome/Application/chrome.exe";
                        } else if (command.equalsIgnoreCase("close browser")) {
                            work = "Taskkill/IM chrome.exe/F";
                        }
                        //In case command recognized is none of the above hence work might be null
                        if(work != null) {
                            //Execute the command
                            p = Runtime.getRuntime().exec(work);
                        }
                }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
