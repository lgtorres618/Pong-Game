import java.awt.*;
import java.awt.event.*;
import java.util. *;
import javax.swing.*;
public class Ball extends Rectangle {

    Random random;
    int xVelocity;
    int yVelocity;
    int StartingSpeed = 5;
    static int randomXDirection;
    static int randomYDirection;


    Ball(int x, int y, int width, int height, int ballID){
        super(x,y,width,height);
        random = new Random();
        switch(ballID) {

            case 1:
            randomXDirection = random.nextInt(1);
            if (randomXDirection == 0) {
                randomXDirection--;
                setXDirection(randomXDirection * StartingSpeed);

                 randomYDirection = random.nextInt(1);
                if (randomYDirection == 0) ;
                randomYDirection--;
                setYDirection(randomYDirection * StartingSpeed);
            }
            break;
            case 2:
                randomXDirection = random.nextInt(4);
                if (randomXDirection == 0) {
                    randomXDirection--;
                    setXDirection(randomXDirection * StartingSpeed);

                    randomYDirection = random.nextInt(4);
                    if (randomYDirection == 0) ;
                    randomYDirection--;
                    setYDirection(randomYDirection * StartingSpeed);
                }

        }

    }


    public void setXDirection(int randomXDirection){
                xVelocity = randomXDirection;
    }
    public void setYDirection(int randomYDirection){
                yVelocity = randomYDirection;

    }
    public void move(){
        x += xVelocity;
        y += yVelocity;
    }
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x,y,height,width);
    }
}
