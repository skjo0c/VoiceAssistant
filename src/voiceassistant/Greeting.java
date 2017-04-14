/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voiceassistant;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author WhiteshadoW
 */
public class Greeting {
    private static final String VOICENAME = "kevin16";
    
    public void greet(){
        GregorianCalendar time = new GregorianCalendar();
        int hour = time.get(Calendar.HOUR_OF_DAY);  //using java.util.GregorianCalender and util.Calender;
        //http://javaandj2eetutor.blogspot.com/2013/08/java-code-to-greet-user-based-on.html
        
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VOICENAME);
        voice.allocate();
        voice.setRate(100);
        voice.setPitch(100);
        
        try{
            
            if (hour < 12)
                voice.speak("Good Morning Su jan senpai.");
            else if (hour < 17 && !(hour == 12))
                 voice.speak("Good Afternoon Su jan senpai.");
            else if (hour == 12)
                voice.speak("Good Noon Su jan senpai.");
            else
                voice.speak("Good Evening Su jan senpai.");
            
            voice.speak("What would you like to do today? Search for file or visit some site?");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
