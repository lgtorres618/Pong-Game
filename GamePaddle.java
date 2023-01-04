import java.awt.*;
import java.awt.event.*;
import java.util. *;
import javax.swing.*;

public class GamePaddle extends Rectangle {
           int id;
           int xVelocity;
           int speed = 7;

    GamePaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x,y,PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id=id;
    }
        public void keyPressed(KeyEvent e){
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_A)
            {
                setXDirection(-speed);
                move();
            }
            if (e.getKeyCode() == KeyEvent.VK_D)
            {
                setXDirection(speed);
                move();
            }
            break;
        }

            }




        public void keyReleased(KeyEvent e){
            switch (id){
                case 1:
                    if(e.getKeyCode()==KeyEvent.VK_A) {
                    setXDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_D) {
                    setXDirection(0);
                    move();
                }
                break;

            }

            }






        public void setXDirection(int xDirection){
                xVelocity = xDirection;
        }
        public void move(){
        x = x + xVelocity;

        }
        public void draw(Graphics g){
            if(id==1)
                g.setColor(Color.BLUE);

            g.fillRect(x,y,width,height);

        }
    }

