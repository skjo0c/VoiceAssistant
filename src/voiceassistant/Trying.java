/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voiceassistant;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author WhiteshadoW
 */
public class Trying {
    public void Trying(){
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
                    Runtime rt = Runtime.getRuntime();
                    
                    //Match recognized speech with our commands

                    if(command.equalsIgnoreCase("open file manager")){
                        String wholename = "Abstract.docx";
                            String fulldir = "D:";
                            FileSearch fs = new FileSearch();
                            try{
                                fs.findFile(wholename,new File(fulldir));
                            }
                            catch(Exception e){
                                System.out.println(e);
                            }
                    }
                    else if(command.equalsIgnoreCase("Close")){
                        System.exit(0);
                    }
                    
                }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
        private static final String VOICENAME = "kevin16";
    public void findFile(String name,File file1)throws IOException{
        File[] list = file1.listFiles();
        if(list!=null){                          
            for(File file2 : list){ 
                
                if (file2.isDirectory())
                {
                    findFile(name,file2);
                }
                else if (name.equalsIgnoreCase(file2.getName()))
                {   
                    String sayfound = "File found at " + file2.getParentFile();
                    String saypath =  file2.getAbsolutePath();
                    
                    Voice voice;
                    VoiceManager vm = VoiceManager.getInstance();
                    voice = vm.getVoice(VOICENAME);
                    voice.allocate();
                    voice.setRate(100);
                    voice.setPitch(100);
                    try{
                        voice.speak("File found at " + saypath);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    String p1 = ""+file2.getParentFile();
                    String p2 = ""+file2.getAbsolutePath();
                    File f2 = new File(p1);
                    Desktop.getDesktop().open(f2);
                }
            }        
        }
//        else{
//            JOptionPane.showMessageDialog(null, "Nothing found");
//        }
    }
}
