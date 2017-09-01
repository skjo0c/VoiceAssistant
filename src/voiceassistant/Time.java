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
public class Time {
    private static final String VOICENAME = "kevin16";
    
    public void Time(){
        GregorianCalendar time = new GregorianCalendar();
        int hour_day = time.get(Calendar.HOUR_OF_DAY);
        int hour = time.get(Calendar.HOUR);  //using java.util.GregorianCalender and util.Calender;
        int minute = time.get(Calendar.MINUTE);
        //http://javaandj2eetutor.blogspot.com/2013/08/java-code-to-greet-user-based-on.html
        
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VOICENAME);
        voice.allocate();
        voice.setRate(100);
        voice.setPitch(100);
        
        try{
            if(hour_day < 12){
                voice.speak("It's " + hour + "a" + "m" + minute + "minute");
            }
            else{
                voice.speak("It's " + hour + "p" + "m" + minute + "minute");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
