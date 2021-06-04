/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 *
 * @author absal
 */
public class State {
    
    private final int[] nextState;//next state numbers
    private final String[] input;//the input
    private int counter;//the index of the two arrays

    public State(int size) {
        //size var is the length of the arrays
        this.nextState = new int [size];
        this.input = new String [size];
        this.counter = 0;//set the index to 0
    }
    
    public void setNextState(int nextState, String input) {
        //make the input avilable
        this.nextState[this.counter] = nextState;
        this.input[this.counter] = input;
        this.counter++;
    }

    public int getNextState(String input) {
        //if the input exsits at the input array then it available
        //get the same index of the next state
        //if not input exsits return -1
        int i;
        for (i = 0; i < this.counter; i++){
            if (this.input[i].equals("searchFor}"))
            {
                return -2;//shearch for the next }
            }
            
            if (this.input[i].equals("AnyThing")){
                return this.nextState[i];
            }
            
            if (input.equals(this.input[i]))
                return this.nextState[i];
        }
        return -1;
    }
}
