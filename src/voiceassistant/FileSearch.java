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

import java.io.*;
import java.util.*;
import java.awt.*;

public class FileSearch{
//        public static void main(String[] args)throws IOException {        
//        
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the file to be searched.. " );
//        String name = scan.next();
//        System.out.println("Enter the directory where to search ");
//        String directory = scan.next();
//
//        FileSearch fs = new FileSearch();
//        fs.findFile(name,new File(directory));
//    }
//        

    
        public void FileSearch() throws  IOException{
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the file to be searched.. " );
            String name = scan.next();
            System.out.println("Enter the directory where to search ");
            String directory = scan.next();

            FileSearch fs = new FileSearch();
            fs.findFile(name,new File(directory));
        }
    
    public void findFile(String name,File file1)throws IOException
    {      
        File[] list = file1.listFiles();       
        if(list!=null)  
        {                          
        for(File file2 : list)
        {            
            if (file2.isDirectory())
            {
                findFile(name,file2);             
            }
            else if (name.equalsIgnoreCase(file2.getName()))
            {                                                              
                System.out.println("Found");                
                System.out.println("File found at : "+file2.getParentFile());
                System.out.println("Path diectory: "+file2.getAbsolutePath());
                String p1 = ""+file2.getParentFile();
                File f2 = new File(p1);
                Desktop.getDesktop().open(f2);                               
            }                      
        }        
      }
    } 
}
