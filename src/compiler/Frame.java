/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Frame extends JFrame implements ActionListener {
JPanel panel ;     
JButton button;
JButton run;
JTextArea textarea;
JScrollPane scroll ;
Container cont ;
JLabel label ;
String starr ="";
String line;
int Lines;
Integer Number[] =new Integer[100];
int count =0;
int loop=0;
   


Frame(){
    
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setResizable(false);   
		this.setLayout(new FlowLayout());
                cont= getContentPane();
                cont.setLayout(new FlowLayout());
                label = new JLabel("Eneter Your Program Code :");
                button = new JButton("Browse");
                run = new JButton("Run");
                textarea =new  JTextArea();
                scroll= new JScrollPane(textarea);
                scroll.setPreferredSize(new Dimension (480,300));
                scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                scroll.getViewport().add(textarea);
               
                textarea.setLineWrap(true);
                textarea.setWrapStyleWord(true);
		button.addActionListener(this);
                run.addActionListener(this);   
              
                
                this.add(label);
                this.add(scroll);
		this.add(button);
                this.add(run);
		this.pack();
                this.setVisible(true);
		

	}

	

	@Override

public void actionPerformed(ActionEvent e) {
    if(e.getSource()==button) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(".")); //sets current directory
        int response = fileChooser.showOpenDialog(null); //select file to open
        if(response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (scanner.hasNextLine()) {
                
                line = scanner.nextLine();
                line = line.replaceAll("\\s+", " ");
               // System.out.println(line);
                line = line.replaceAll("\\s+$", "");
                //System.out.println(line);
                for(int i =0 ; i<line.length();i++){
                    char c =line.charAt(i);
                    if (c == ' '){
                        count++;
                    }
                }
                Number[loop]=count+1;
                count =0;
                loop++;
                starr = starr.concat(line+ " ");
               // starr = starr.replaceAll("\\s+", " ");
            }
            Compiler obj = new  Compiler();
            obj.Analyze(starr,Number,loop);
         }
      }
    
    if(e.getSource()==run) {
   
        
        this.setVisible(false);
     String s[] = textarea.getText().split("\\r?\\n");
     ArrayList<String>arrList = new ArrayList<>(Arrays.asList(s)) ;
     
     for(int i = 0 ; i < arrList.size(); i++)
        {   
         
         arrList.set(i,arrList.get(i).replaceAll("\\s+", " "));
         arrList.set(i,arrList.get(i).replaceAll("\\s+$", ""));
        
         
       for(int y =0 ; y <arrList.get(i).length();y++){
                    char c =arrList.get(i).charAt(y);
                    if (c == ' '){
                        count++;
                    }
                }
                Number[loop]=count+1;
                count =0;
                loop++;
                starr = starr.concat(arrList.get(i)+" ");
        }
     
       Compiler obj = new Compiler();
       obj.Analyze(starr,Number,loop);

    }
        
 
    

   }
}
 