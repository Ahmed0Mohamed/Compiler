package compiler;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Compiler {
    public static int Counter=0;
    public static  Object[][] rows ;
    public static int tableSize;
    public static int TotalErorr=0;
    public static boolean CheckCounter =false;

   public static void main(String[] args) {
        Frame frame =new Frame();
        frame.setSize(500, 500);      
        frame.textarea.setMinimumSize(new Dimension(20,40));
        Font font = new Font("Verdana", Font.PLAIN, 20);
        frame.textarea.setFont(font);
   }
    
    
    public static void Display(Object [] [] mark){
       
      String[] Colum =  {"Line No","Lexeme","Return Token","Lexeme No in Line","Matchability"}; 
      JLabel  label  = new JLabel("Total NO of errors: "+TotalErorr);
      JTable table = new JTable(mark, Colum)
      {
      public boolean isCellEditable(int r, int w)
      {
      return false;
      }
      };
     
      Font font = new Font("Verdana", Font.PLAIN, 12);
      table.setFont(font);
      table.setRowHeight(30);
      JFrame frame = new JFrame();
      frame.setSize(500, 500);
      frame.add(new JScrollPane(table));
      frame.setVisible(true);
      frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
      frame.setLayout(new FlowLayout());;
      frame.add(label);
     
    }
public static void CalculateArray (Object a, String lexeme ,int tokenNo , int LineNo, int Length,String Matchbility ){
  
  int j = 0;
      
              if(!CheckCounter){
                 for(int i =0; i<Length;i++){
                  rows[Counter][j]=LineNo;
                  rows[Counter][j+1]=a;
                  rows[Counter][j+2]=lexeme;
                  rows[Counter][j+3]=tokenNo;
                  rows[Counter][j+4]=Matchbility;
                  //lexeme = "Class";
                  //CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                 }
              

                if(Counter != Length-1 ){ 
                Counter=Counter+1;

                 }
              }
              else
              {
               Counter--;   
              }  
             
   

}

public static void Analyze( String starr, Integer InLine[] , int Token ){
         int y =0; // To loop for Correct Line 
          int token =0; //All Token in Program
          int LineNo =1;
           int flag =0;
          boolean b= false;
        String lexeme = new String();
        char [] Digit = new char[]{'0','1','2','3','4','5','6','7','8','9'};
        char [] Char = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','Z'};
        String [] St = new String[] {"Divisio","InferedFrom","WhetherDo-Else","Ire","Sire","Clo","SetOfClo",
            "FBU","SFBU","NoneValue","TerminateThisNow" , "RingWhen","BackedValue","STT","Check –CaseOf","Beginning","End","Using"};
         for(int i =0; i<Token;i++){ //all token in Program
              
               token+= InLine[i];

           }
         rows = new Object [token][5];
         tableSize = token;
     System.out.println("\nInput Line :");
        String output[] = starr.split(" ");
        
        for(String output1 : output)
        {
        System.out.println("" + output1);
        }
        System.out.println("");
        
        int id = 0, tokenNo=0,totalToken=1;
       
        for(int i = 0; i < output.length; i++ )
        {
            
            totalToken = output.length;
            if(null != output[i])
               
                switch(output[i])
                {
                    
                    case "Divisio":
                    tokenNo++;
                    System.out.println("<Class," + output[i] + ">");
                    lexeme = "Class";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "InferedFrom":
                    tokenNo++;
                    System.out.println("<Inheritance," + output[i] + ">");
                    lexeme = "Inheritance";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "WhetherDo-Else":
                    tokenNo++;
                    System.out.println("<Condition," + output[i] + ">");
                    lexeme = "Condition";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "Ire":
                    tokenNo++;
                    System.out.println("<Integer," + output[i] + ">");
                    lexeme= "Integer";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "Sire":
                    tokenNo++;
                    System.out.println("<SInteger," + output[i] + ">");
                    lexeme= "SInteger";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "Clo":
                    tokenNo++;
                    System.out.println("<Character," + output[i] + ">");
                    lexeme= "Character";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "SetOfClo":
                    tokenNo++;
                    System.out.println("<String," + output[i] + ">");
                    lexeme= "String";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "FBU":
                    tokenNo++;
                    System.out.println("<Float," + output[i] + ">");
                    lexeme= "Float";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "SFBU":
                    tokenNo++;
                    System.out.println("<SFloat," + output[i] + ">");
                    lexeme= "SFloat";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "NoneValue":
                    tokenNo++;
                    System.out.println("<Void," + output[i] + ">");
                    lexeme= "Void";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "TerminateThisNow":
                    tokenNo++;
                    System.out.println("<Break," + output[i] + ">");
                    lexeme= "Break";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "RingWhen":
                    tokenNo++;
                    System.out.println("<Loop," + output[i] + ">");
                    lexeme= "Loop";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "BackedValue":
                    tokenNo++;
                    System.out.println("<Return," + output[i] + ">");
                    lexeme= "Return";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "STT":
                    tokenNo++;
                    System.out.println("<Struct," + output[i] + ">");
                    lexeme= "Struct";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "Check –CaseOf":
                    tokenNo++;
                    System.out.println("<Switch," + output[i] + ">");
                    lexeme= "Switch";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "Beginning":
                    tokenNo++;
                    System.out.println("<Start Statement," + output[i] + ">");
                    lexeme= "Start Statement";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "End":
                    tokenNo++;
                    System.out.println("<End Statement," + output[i] + ">");
                    lexeme= "End Statement";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    tokenNo++;
                    System.out.println("<Arithmetic Operation," + output[i] + ">");
                    lexeme= "Arithmetic Operation";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "&&":
                    case "||":
                    case "~":
                    tokenNo++;
                    System.out.println("<Logic operators," + output[i] + ">");
                    lexeme= "Logic operators";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "==":
                    case "<":
                    case ">":
                    case "!=":
                    case "<=":
                    case ">=":
                    tokenNo++;
                    System.out.println("<relational operators," + output[i] + ">");
                    lexeme= "relational operators";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "=":
                    tokenNo++;
                    System.out.println("<Assignment operator," + output[i] + ">");
                    lexeme= "Assignment operator";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case ".":
                    tokenNo++;
                    System.out.println("<Access Operator," + output[i] + ">");
                    lexeme= "Access Operator";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "{,}":
                    case "[,]":
                    tokenNo++;
                    System.out.println("<Braces," + output[i] + ">");
                    lexeme= "Braces";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "0":
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                    tokenNo++;
                    System.out.println("<Constant," + output[i] + ">");
                    lexeme= "Constant";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "a":
                    case "b":
                    case "c":
                    case "d":
                    case "e":
                    case "f":
                    case "g":
                    case "h":
                    case "i":
                    case "j":
                    case "k":
                    case "l":
                    case "m":
                    case "n":
                    case "o":
                    case "p":
                    case "q":
                    case "r":
                    case "s":
                    case "t":
                    case "u":
                    case "v":
                    case "w":
                    case "x":
                    case "y":
                    case "z":
                    tokenNo++;
                    id++;
                    System.out.println("<IDENTIFIER"+id+","+ output[i] + ">");
                    lexeme= "IDENTIFIER";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "A":
                    case "B":
                    case "C":
                    case "D":
                    case "E":
                    case "F":
                    case "G":
                    case "H":
                    case "I":
                    case "J":
                    case "K":
                    case "L":
                    case "M":
                    case "N":
                    case "O":
                    case "P":
                    case "Q":
                    case "R":
                    case "S":
                    case "T":
                    case "U":
                    case "V":
                    case "W":
                    case "X":
                    case "Y":
                    case "Z":
                    tokenNo++;
                    id++;
                    System.out.println("<IDENTIFIER"+id+","+ output[i] + ">");
                    lexeme= "IDENTIFIER";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "'":
                    tokenNo++;
                    System.out.println("<Single Quotation Mark," + output[i] + ">");
                    lexeme= "Single Quotation Mark";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "\"":
                    tokenNo++;
                    System.out.println("<Double Quotation Mark," + output[i] + ">");
                    lexeme= "Double Quotation Mark";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "_":
                    tokenNo++;
                    System.out.println("<IDENTIFIER," + output[i] + ">");
                    lexeme= "IDENTIFIER";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case " ":
                    System.out.println("");
                    lexeme= "";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "Using":
                    tokenNo++;
                    System.out.println("<Inclusion," + output[i] + ">");
                    lexeme= "Inclusion";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "{":
                    tokenNo++;
                    System.out.println("<Left Braces," + output[i] + ">");
                    lexeme= "Left Braces";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "}":
                    tokenNo++;
                    System.out.println("<Right Braces," + output[i] + ">");
                    lexeme= "Right Braces";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "[":
                    tokenNo++;
                    System.out.println("<Left Braces," + output[i] + ">");
                    lexeme= "Left Braces";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "]":
                    tokenNo++;
                    System.out.println("<Right Braces," + output[i] + ">");
                    lexeme= "Right Braces";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    case "/-":  
                    System.out.println("<Comment," + output[i] + ">");
                    tokenNo++;
                    lexeme= "Comment";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    int remain= InLine[y]-tokenNo;
                     while(remain!=0){
                      i++;
                      InLine[y]--;
                      remain--;
                      tableSize--;
                      CheckCounter = true;
                      //CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    // token --;
                     }
                     CheckCounter =false;
                    break;
                    case "/#":
                        System.out.println("<Comment," + output[i] + ">");
                    tokenNo++;
                    lexeme= "Start Comment";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    flag= y;
                   i++; 
                   InLine[y]--;
                    while (!output[i].equals("#/")){
                        
                       tableSize--;
                        System.out.println(InLine[y]); 
                        InLine[y]--;

                        if(InLine[y]==0){
                            y++;
                            LineNo++;
                            
                            

                        } 
                         
                        i++; 
                    }
                    InLine[y]--;
                    
                    
                       if(flag==y){
                       tokenNo++;
                       }
                       else{
                       tokenNo = 1;
                       } 
                        
                        lexeme= "End Comment";
                        CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                        if(InLine[y]== 0)
                        {
                        tokenNo = 0;
                        }
                     
                    break;
                    case "@":
                        boolean s =false;
                    tokenNo++;
                for(int k =0 ;k<St.length;k++)
                {
                     if (i==0)
                    {
                      s= false;  
                    }
                     else if(output[i-1].equals(St[k]) && i!=0)
                    {
                      s =true;
                    }
                   
                 }
                    if(s)
                    {
                    System.out.println("<Delimiter," + output[i] + ">");
                    lexeme= "Delimiter";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    }
                    else
                    {
                           tokenNo--;
                            lexeme="Erorr";
                            System.out.println(output[i] + "Erorr");
                            CalculateArray(output[i],lexeme,0,LineNo,totalToken,"UnMatched"); 
                            TotalErorr++;
                             InLine[y]--;
                           
                    }
                    
                    break;
                    case ";":
                    tokenNo++;
                    if(tokenNo == InLine[y] && !output[i-1].equals("{"))
                    {
                    
                    System.out.println("<Delimiter," + output[i] + ">");
                    lexeme= "Delimiter";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    }
                    else if (output[i+1].equals("/-"))
                    { 
                                       
                    System.out.println("<Delimiter," + output[i] + ">");
                    lexeme= "Delimiter";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                           
                    }
                    else
                    {
                             tokenNo--;
                            lexeme="Erorr";
                            System.out.println(output[i] + "Erorr");
                            CalculateArray(output[i],lexeme,0,LineNo,totalToken,"UnMatched"); 
                            TotalErorr++;
                             InLine[y]--;
                    
                    }
                    break;
                    case ",":
                    tokenNo++;
                    System.out.println("<Comma," + output[i] + ">");
                    lexeme= "Comma";
                    CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                    break;
                    default:      
                   for(int k=0;k<Char.length;k++)
                   {
                       if(output[i].charAt(0) == Char[k])
                        {
                        b=true;
                        
                        }
                   }
                   if(b)
                   {                   
                        tokenNo++;
                        System.out.println(output[i] + "IDENTIFIER");
                        lexeme="IDENTIFIER";
                        CalculateArray(output[i],lexeme,tokenNo,LineNo,totalToken,"Matched");
                        b=false;

                   }

                    else
                   {
                             lexeme="Erorr";
                            System.out.println(output[i] + "Erorr");
                            CalculateArray(output[i],lexeme,0,LineNo,totalToken,"UnMatched"); 
                            TotalErorr++;
                            InLine[y]--;
                            
                            
                    } 

                    
                    break;
                  
                }
           
                if(tokenNo==InLine[y]){
                LineNo++;
                tokenNo=0;
                y++;
               
            }
                
         }
            DFA graph = new DFA();
            rows = graph.isAccepted(rows, tableSize);
            Display(rows);
            Frame f = new Frame();
            f.setVisible(false);
                  
         }

}