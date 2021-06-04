/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import static compiler.Compiler.TotalErorr;

/**
 *
 * @author absal
 */

public class DFA {
    private final State[] states = new State[103];
    private int currentState, numOfOpenBraces;
   private boolean flag = false; 
    public DFA() {
        currentState = 0;
        numOfOpenBraces = 0;
        
        //bulid the same graph as the documentation
        states[0] = new State(19);
        states[0].setNextState(1, "Divisio");
        states[0].setNextState(9, "WhetherDo-Else");
        states[0].setNextState(20, "Ire");
        states[0].setNextState(27, "Sire");
        states[0].setNextState(28, "Clo");
        states[0].setNextState(37, "SetOfClo");
        states[0].setNextState(46, "FBU");
        states[0].setNextState(46, "SFBU");
        states[0].setNextState(55, "NoneValue");
        states[0].setNextState(67, "TerminateThisNow");
        states[0].setNextState(69, "RingWhen");
        states[0].setNextState(76, "BackedValue");
        states[0].setNextState(79, "STT");
        states[0].setNextState(87, "Beginning");
        states[0].setNextState(89, "End");
        states[0].setNextState(94, "Using");
        states[0].setNextState(97, "/#");
        states[0].setNextState(100, "/-");

        states[1] = new State(1);
        states[1].setNextState(2, "@");
        
        states[2] = new State(1);
        states[2].setNextState(3, "IDENTIFIER");
        
        states[3] = new State(2);
        states[3].setNextState(4, "{");
        states[3].setNextState(7, "InferedFrom");
        
        states[4] = new State (1);
        states[4].setNextState(0, "searchFor}");

        states[5] = null;
        
        states[6]= null;
        
        states[7] = new State (1);
        states[7].setNextState(8, "IDENTIFIER");
        
        states[8] = new State (1);
        states[8].setNextState(4, "{");
        
        states[9] = new State (2);
        states[9].setNextState(10, "IDENTIFIER");
        
        states[10] = new State (1);
        states[10].setNextState(4, "{");
        
        //skip from 11 to 19
        
        states[20] = new State (1);
        states[20].setNextState(21, "@");
        
        states[21] = new State (1);
        states[21].setNextState(22, "IDENTIFIER");
        
        states[22] = new State (3);
        states[22].setNextState(23, "=");
        states[22].setNextState(0, ";");
        states[22].setNextState(26, ",");
        
        states[23] = new State(1);
        states[23].setNextState(24, "Constant");
        
        states[24] = new State(2);
        states[24].setNextState(0, ";");
        states[24].setNextState(26, ",");
        
        states[26] = new State(1);
        states[26].setNextState(22, "IDENTIFIER");
        
        states[27] = new State(1);
        states[27].setNextState(21, "@");
        
        states[28] = new State(1);
        states[28].setNextState(29, "@");
        
        states[29] = new State(1);
        states[29].setNextState(30, "IDENTIFIER");
        
        states[30] = new State(3);
        states[30].setNextState(23, "=");
        states[30].setNextState(0, ";");
        states[30].setNextState(36, ",");
        
        states[31] = new State(1);
        states[31].setNextState(32, "'");
        
        states[32] = new State(1);
        states[32].setNextState(33, "IDENTIFIER");
        
        states[33] = new State(1);
        states[33].setNextState(34, "'");
        
        states[34] = new State(2);
        states[34].setNextState(0, ";");
        states[34].setNextState(36, ",");
        
        states[36] = new State(1);
        states[36].setNextState(30, "IDENTIFIER");
        
        states[37] = new State(1);
        states[37].setNextState(38, "@");
        
        states[38] = new State(1);
        states[38].setNextState(39, "IDENTIFIER");
        
        states[39] = new State(3);
        states[39].setNextState(40, "=");
        states[39].setNextState(0, ";");
        states[39].setNextState(45, ",");
        
        states[40] = new State(1);
        states[40].setNextState(41, "\"");
        
        states[41] = new State(1);
        states[41].setNextState(42, "IDENTIFIER");
        
        states[42] = new State(2);
        states[42].setNextState(42, "IDENTIFIER");
        states[42].setNextState(43, "\"");
        
        states[43] = new State(2);
        states[43].setNextState(0, ";");
        states[43].setNextState(45, ",");
        
        states[45] = new State(1);
        states[45].setNextState(39, "IDENTIFIER");
        
        states[46] = new State(1);
        states[46].setNextState(47, "@");
        
        states[47] = new State(1);
        states[47].setNextState(48, "IDENTIFIER");
        
        states[48] = new State(3);
        states[48].setNextState(49, "=");
        states[48].setNextState(0, ";");
        states[48].setNextState(54, ",");
        
        states[49] = new State(1);
        states[49].setNextState(50, "Constant");
        
        states[50] = new State(3);
        states[50].setNextState(51, ".");
        states[50].setNextState(0, ";");
        states[50].setNextState(54, ",");
        
        states[51] = new State(1);
        states[51].setNextState(52, "Constant");
        
        states[52] = new State(2);
        states[52].setNextState(0, ";");
        states[52].setNextState(54, ",");
        
        states[54] = new State(1);
        states[54].setNextState(48, "IDENTIFIER");
        
        states[55] = new State(1);
        states[55].setNextState(56, "@");
        
        states[56] = new State(1);
        states[56].setNextState(57, "IDENTIFIER");
        
        states[57] = new State(1);
        states[57].setNextState(58, "(");
        
        states[58] = new State(8);
        states[58].setNextState(59, ")");
        states[58].setNextState(63, "Ire");
        states[58].setNextState(63, "Sire");
        states[58].setNextState(63, "Clo");
        states[58].setNextState(63, "SetOfClo");
        states[58].setNextState(63, "FBU");
        states[58].setNextState(63, "SFBU");
        states[58].setNextState(63, "NoneValue");
        
        states[59] = new State(1);
        states[59].setNextState(4, "{");
        
        states[63] = new State(1);
        states[63].setNextState(64, "@");
        
        states[64] = new State(1);
        states[64].setNextState(65, "IDENTIFIER");
        
        states[65] = new State(2);
        states[65].setNextState(59, ")");
        states[65].setNextState(66, ",");
        
        states[66] = new State(7);
        states[66].setNextState(63, "Ire");
        states[66].setNextState(63, "Sire");
        states[66].setNextState(63, "Clo");
        states[66].setNextState(63, "SetOfClo");
        states[66].setNextState(63, "FBU");
        states[66].setNextState(63, "SFBU");
        states[66].setNextState(63, "NoneValue");
        
        states[67] = new State(1);
        states[67].setNextState(68, "TerminateThisNow");
        
        states[68] = new State(1);
        states[68].setNextState(0, ";");
        
        states[69] = new State(1);
        states[69].setNextState(70, "(");
        
        states[70] = new State(1);
        states[70].setNextState(71, "IDENTIFIER");
        
        states[71] = new State(1);
        states[71].setNextState(72, ")");
        
        states[72] = new State(1);
        states[72].setNextState(4, "{");
        
        states[76] = new State(1);
        states[76].setNextState(77, "IDENTIFIER");
        
        states[77] = new State(1);
        states[77].setNextState(0, ";");
        
        states[79] = new State(1);
        states[79].setNextState(80, "@");
        
        states[80] = new State(1);
        states[80].setNextState(81, "IDENTIFIER");
        
        states[81] = new State(1);
        states[81].setNextState(82, "{");
        
        states[82] = new State(8);
        states[82].setNextState(0, "}");
        states[82].setNextState(84, "Ire");
        states[82].setNextState(84, "Sire");
        states[82].setNextState(84, "Clo");
        states[82].setNextState(84, "SetOfClo");
        states[82].setNextState(84, "FBU");
        states[82].setNextState(84, "SFBU");
        states[82].setNextState(84, "NoneValue");
        
        states[84] = new State(1);
        states[84].setNextState(85, "@");
        
        states[85] = new State(1);
        states[85].setNextState(86, "IDENTIFIER");
        
        states[86] = new State(1);
        states[86].setNextState(82, ";");
        
        states[87] = new State(1);
        states[87].setNextState(0, ";");
        
        states[89] = new State(1);
        states[89].setNextState(0, ";");
        
        states[94] = new State(1);
        states[94].setNextState(95, "IDENTIFIER");
        
        states[95] = new State(1);
        states[95].setNextState(0, ";");
        
        states[97] = new State(1);
        states[97].setNextState(0, "#/");
        
        states[98] = new State(2);
        states[98].setNextState(0, "#/");
        states[98].setNextState(98, "AnyThing");
        
        states[100] = new State(1);
        states[100].setNextState(0, "/-");
    }
    
    public Object[][] isAccepted (Object[][] inputTable, int tableSize){
        Object[][] table = new Object[tableSize][5];
        int lineNumber = -1;
        for (int i = 0; i < tableSize; i++){
            table[i] = inputTable[i];
            if (currentState == -1) {
                table[i][4] = "UnMatched";
                currentState = 0;
                flag =true;
                
            }else if (currentState == -2) {//search for }
                numOfOpenBraces++;
                int notClosed = numOfOpenBraces;
                for (int currentIndex = i; currentIndex < table.length; currentIndex++){
                    if (((String)table[currentIndex][1]).equals("}")){
                        notClosed--;
                    }
                    if (notClosed == 0){
                        currentState = 0;
                        break;
                    }
                }
                if (notClosed != 0){
                    table[i][4] = "Not Closed";
                }
            }
            
            
            
            if(((int)table[i][0]) != lineNumber){
                currentState = 0;
                lineNumber = (int)table[i][0];
            }
            if (((String)table[i][2]).equals("IDENTIFIER")){
                currentState = states[currentState].getNextState("IDENTIFIER");
            }else if (((String)table[i][2]).equals("Constant")){
                currentState = states[currentState].getNextState("Constant");                
            }
            else{
                currentState = states[currentState].getNextState((String)table[i][1]);
            }
        }
        if(flag == true )
        {
        
        TotalErorr++;
        flag = false;
        }
        return table;
    }
}
