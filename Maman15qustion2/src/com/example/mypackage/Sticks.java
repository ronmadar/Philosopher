package com.example.mypackage;

 /* This class represent all the sticks.
    a stick can either be free or used.*/
public class Sticks {

    private boolean[] used;
    private int num;

    //constructor
    public Sticks(int numOfSticks){
        used=new boolean[numOfSticks];
        num=numOfSticks;
    }

    //return true if succeed catching 2 sticks
    // we receive here two places value of the array - that tell us if the two value is false is mean
    // thread doesn't use(means they'r free) so we want to catch the sticks therefore we put !(NOT)
    // CUZ is change the value to true for to get in to the function.
    // and change the value to true mean is they'r use
    // now the sticks caught until release the thread
    public synchronized boolean catchSticks(int n1,int n2){
        if(!used[n1]&&!used[n2]){ //both sticks are not used
            used[n1]=!used[n1];
            used[n2]=!used[n2];  //sticks caught
            return true;
        }else return false;
    }

    //release a stick
    // we checked if the number position that pass as parameter in the boolean array, is there are true means use
    // in this position in the array, if true get in the function and release the thread(change value to false), else
    //  print ERROR interrupted means we we are in deadlock situation
    public synchronized void releaseStick(int n){
        if (used[n]) //the stick is used
            used[n]=!used[n]; //released
        else
            System.out.println("ERROR: this is impassible trying to release a free stick Cuz we need to be in thread to release");
    }
}
