
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voiceassistant;


import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.Microphone;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.recognizer.Recognizer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.TargetDataLine;


/**
 *
 * @author WhiteshadoW
 */
public class Selectingcommand {
    Microphone microphone;
        Recognizer recognizer;
    public void Selectingcommand(){
        
         // Configuration Object
        Configuration configuration = new Configuration();
        
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
                 result = recognize.getResult();
                    //Get the recognize speech
                    
                    String command = result.getHypothesis();
                    
                    //Match recognized speech with our commands

                   if(command.equalsIgnoreCase("search")){

//                        recognizer.deallocate();
//                        microphone.stopRecording();
//                        
//                        recognizer.allocate();
//                        microphone.startRecording();
                        
                        FrontView.src.doClick();
                    }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
