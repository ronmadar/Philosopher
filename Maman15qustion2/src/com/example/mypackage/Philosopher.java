package com.example.mypackage;

 /* This class is a thread that represent a philosopher,
 * it can eat or think for a random time between 2 to 10 seconds
 */
public class Philosopher extends Thread {

    private int indexPrimToCheack;
    private int numerOfPhilosopher;
    private Sticks AllMysticks;
    private boolean CheackedIfNowIEat;

    //constructor
    public Philosopher(int num, int numberOfPhilosophers,Sticks sticks){
        indexPrimToCheack =num;
        numerOfPhilosopher =numberOfPhilosophers;
        this.AllMysticks =sticks;
        CheackedIfNowIEat =false;
    }

    //return true if the philosopher is CheackedIfNowIEat
    public boolean isCheackedIfNowIEat() {
        return CheackedIfNowIEat;
    }

    //return true if the philosopher successfully caught 2 AllMysticks
    private boolean catchSticks(){
        boolean successing = AllMysticks.catchSticks(((indexPrimToCheack)% numerOfPhilosopher),((indexPrimToCheack +1)% numerOfPhilosopher));
        return successing;
    }

    //release the AllMysticks the philosopher caught
    private void releaseSticks(){
        AllMysticks.releaseStick(((indexPrimToCheack)% numerOfPhilosopher));
        AllMysticks.releaseStick(((indexPrimToCheack +1)% numerOfPhilosopher));
    }

    //return an int that represent time in milliseconds and between 2 to 8 seconds
    private int getTime(){
        return (int)((Math.random()*6000)+2000); //minimum 2 sec, maximum 8 sec
    }


    @Override
    public void run() {

        while(true) {

            //if the philosopher successfully caught 2 All My sticks, it eats for a random time
            if (catchSticks()) {
                //eats
                this.CheackedIfNowIEat =true;
                try {
                    sleep(getTime());
                } catch (InterruptedException e) {
                    System.out.println("ERROR interrupted to our sleep thread");
                    System.exit(1);
                }
                releaseSticks();
                this.CheackedIfNowIEat =false;
            }

            //thinks
            try {
                sleep(getTime());
            } catch (InterruptedException e) {
                System.out.println("interrupted in the sleep of thread");
                System.exit(1);
            }

        }

    }
}
