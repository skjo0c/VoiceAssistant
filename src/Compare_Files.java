
import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.wave.Wave;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WhiteshadoW
 */
public class Compare_Files {
    public static void main(String[] args) {
         FingerprintSimilarity siml = new Wave("C://Dir_Data/file1.wav").getFingerprintSimilarity(new Wave("C://Dir_Data/file.wav"));
         System.out.println(siml.getScore());
    }
}
