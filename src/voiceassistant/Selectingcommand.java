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
import java.io.File;
import java.util.logging.Level;

public class Selectingcommand {
    public Selectingcommand(){
         Configuration configuration = new Configuration();
         FrontView fv = new FrontView();
         
        try{
               // Set path to the acoustic model.
               configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
               // Set path to the dictionary.
               configuration.setDictionaryPath("/Users/WhiteshadoW/Desktop/tryout/7905.dic");
               // Set path to the language model.
               configuration.setLanguageModelPath("/Users/WhiteshadoW/Desktop/tryout/7905.lm");
               
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
                    Runtime rt = Runtime.getRuntime();
                    
                    //Match recognized speech with our commands

                    if(command.equalsIgnoreCase("search")){
                        fv.src.doClick();
                    }
                }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
