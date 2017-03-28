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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

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
   
//        public void FileSearch() throws  IOException{
//            Scanner scan = new Scanner(System.in);
//            System.out.println("Enter the file to be searched.. " );
//            String name = scan.next();
//            System.out.println("Enter the directory where to search ");
//            String directory = scan.next();
//
//            FileSearch fs = new FileSearch();
//            fs.findFile(name,new File(directory));
//        }
        
        
        public void FileSearch() throws IOException{
            JFrame jf = new JFrame();
            JPanel jp = new JPanel();
            JLabel jl = new JLabel("File name");
            JLabel jl1 = new JLabel("File extension");
            JLabel jl2 = new JLabel("Where to find");
            JTextField fn = new JTextField(20);
            JTextField ext = new JTextField(5);
            JTextField dir = new JTextField(1);
            JButton btn = new JButton("Search");

            jp.add(jl);
            jp.add(fn);
            jp.add(jl1);
            jp.add(ext);
            jp.add(dir);
            jp.add(btn);
                btn.addActionListener(
                        new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                            String wholename = fn.getText().toUpperCase()+ "." + ext.getText();
                            String fulldir = dir.getText().toUpperCase() + ":";
                            FileSearch fs = new FileSearch();
                            try{
                                fs.findFile(wholename,new File(fulldir));
                            }
                            catch(Exception e){
                                System.out.println(e);
                            }

                    }
                }
                );
            jf.add(jp);

            jf.setVisible(true);
            jf.setSize(300,300);
            jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              
            
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
