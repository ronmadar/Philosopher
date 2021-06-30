package com.example.mypackage;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* This is the panel class to show the philosophers eating and thinking*/

public class DiningPanel extends JPanel implements ActionListener {

    private Philosopher[] philosophers;
    private Timer ourTriger;
    private Timer imgTriger;
    boolean swapMyImageInApropiate =true;

    //constructor
    public DiningPanel(Philosopher[] philosophers){
        this.philosophers=philosophers;

        //using timers to control the animation
        ourTriger =new Timer(300,this);
        ourTriger.start();
        imgTriger =new Timer(600,this);
        imgTriger.start();
    }

    //drawing our philosophers in the table
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width=getWidth();
        int height=getHeight();
        if (philosophers[0].isCheackedIfNowIEat())
            drawEating( width / 2 , height / 4,g);
        else
            drawThinking( width / 2 , height / 4,g);

        if (philosophers[1].isCheackedIfNowIEat())
            drawEating(4*width/5,2*height/5,g);
        else
            drawThinking(4*width/5,2*height/5,g);

        if (philosophers[2].isCheackedIfNowIEat())
            drawEating(13*width/20,3*height/4,g);
        else
            drawThinking(13*width/20,3*height/4,g);

        if (philosophers[3].isCheackedIfNowIEat())
            drawEating(7*width/20,3*height/4,g);
        else
            drawThinking(7*width/20,3*height/4,g);

        if (philosophers[4].isCheackedIfNowIEat())
            drawEating(width/5,2*height/5,g);
        else
            drawThinking(width/5,2*height/5,g);
    }

    //catching and dealing with the actions created by the timers
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== ourTriger)
            repaint();
        if(e.getSource()== imgTriger)
            swapMyImageInApropiate =!swapMyImageInApropiate;
    }

    //draw eating
    public void drawEating(int x, int y, Graphics g){
        Image eating1=Toolkit.getDefaultToolkit().getImage("pic/eating6.jpg");
        Image eating2=Toolkit.getDefaultToolkit().getImage("pic/eating7.jpg");
        if(swapMyImageInApropiate) {
            g.drawImage(eating1, x - 50, y - 50, 100, 100, this);
        }else{
            g.drawImage(eating2, x - 50, y - 50, 100, 100, this);
        }
    }

    //draw thinking
    public void drawThinking(int x,int y,Graphics g){
        Image thinking1=Toolkit.getDefaultToolkit().getImage("pic/thinking3.gif");
        Image thinking2=Toolkit.getDefaultToolkit().getImage("pic/thinking4.gif");
        if(swapMyImageInApropiate) {
            g.drawImage(thinking1, x - 50, y - 50, 100, 100, this);
        }else{
            g.drawImage(thinking2, x - 50, y - 50, 100, 100, this);
        }
    }

}
