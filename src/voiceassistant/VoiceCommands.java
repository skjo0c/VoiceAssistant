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
import edu.cmu.sphinx.api.Microphone;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.recognizer.Recognizer;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WhiteshadoW
 */
public class VoiceCommands {

    private final Logger logger = Logger.getLogger(getClass().getName());

    public void VoiceCommands(){
         // Configuration Object
        Configuration configuration = new Configuration();
        try{
               // Set path to the acoustic model.
               configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
               // Set path to the dictionary.
               configuration.setDictionaryPath("/Users/WhiteshadoW/Desktop/tryout/final.dic");
               // Set path to the language model.
               configuration.setLanguageModelPath("/Users/WhiteshadoW/Desktop/tryout/final.lm");
               
                //Recognizer Object, Pass the Configuration object
                LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);

                //Start Recognition Process (The bool parameter clears the previous cache if true)
                recognize.startRecognition(true);
                 logger.log(Level.INFO, "You can start to speak in 5sec...\n");
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

                    if(command.equalsIgnoreCase("search cats jpg")){
                        String wholename = "cats.jpg";
                            String fulldir = "D:";
                            FileSearch fs = new FileSearch();
                            try{
                                fs.findFile(wholename,new File(fulldir));
                            }
                            catch(Exception e){
                                System.out.println(e);
                            }
                    }
                    
                    else if(command.equalsIgnoreCase("search first docx")){
                        String wholename = "first.docx";
                            String fulldir = "D:";
                            FileSearch fs = new FileSearch();
                            try{
                                fs.findFile(wholename,new File(fulldir));
                            }
                            catch(Exception e){
                                System.out.println(e);
                            }
                    }
                    else if(command.equalsIgnoreCase("what time is it now")){
                            Time time = new Time();
                            time.Time();
                    }
                    else if(command.equalsIgnoreCase("open facebook")){
                        java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://facebook.com"));
                    }
                    else if(command.equalsIgnoreCase("open mail")){
                        java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://mail.google.com"));
                    }
                    else if(command.equalsIgnoreCase("open youtube")){
                        java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://youtube.com"));
                    }
                    else if(command.equalsIgnoreCase("close browser")){
                        rt.exec("Taskkill /IM chrome.exe /T /F");
                    }
                    else if(command.equalsIgnoreCase("close")){
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
                    Desktop.getDesktop().open(f2);                }
            }        
        }
//        else{
//            JOptionPane.showMessageDialog(null, "Nothing found");
//        }
    }
}
