import java.awt.*;
import java.awt.event.*;
import java.util. *;
import javax.swing.*;
public class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555)); // adjusts accordingly to game width
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 125;
    static final int PADDLE_HEIGHT = 25;

    Thread gameThread;
    Graphics graphics;
    Random random;
    Image image;
    GamePaddle paddle1;
    GamePaddle paddle2;

    Ball ball1;
    Ball ball2;
    Score score;




    GamePanel(){
         newPaddle();
         newBall();
         score = new Score(GAME_WIDTH,GAME_WIDTH);
         this.setFocusable(true);
         this.addKeyListener(new AL());
         this.setPreferredSize(SCREEN_SIZE);

         gameThread = new Thread(this);
         gameThread.start();
    }
    public void newBall(){
       // random = new Random();
        ball1 = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2), (GAME_HEIGHT/2) - (BALL_DIAMETER/2), BALL_DIAMETER,BALL_DIAMETER,1);
        ball2 = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2), (GAME_HEIGHT/2) - (BALL_DIAMETER/2), BALL_DIAMETER,BALL_DIAMETER,2);

    }
    public void newPaddle(){
        //paddle1 = new GamePaddle(0,(GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT,1);  // review formulas
       // paddle2 = new GamePaddle((GAME_WIDTH/2) - (PADDLE_WIDTH/2),525,PADDLE_WIDTH, PADDLE_HEIGHT, 2);

        paddle1 = new GamePaddle((GAME_WIDTH/2) - (PADDLE_WIDTH/2),525,PADDLE_WIDTH, PADDLE_HEIGHT, 1);

    }

    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g){
        paddle1.draw(g);
        ball1.draw(g);
        ball2.draw(g);
       // paddle2.draw(g);

    }
    public void move(){
        paddle1.move();
        ball1.move();
        ball2.move();
    }
    public void Collision() { //creates barriers
        // create barrier of paddle later //ball barrier

        if (ball1.x <=0) {
            ball1.setXDirection(-ball1.xVelocity);
        }
        if (ball1.x >= GAME_WIDTH-BALL_DIAMETER){
            ball1.setXDirection(-ball1.xVelocity);

        }
        if (ball1.y <=0) {
            ball1.setYDirection(-ball1.yVelocity);
        }

        if (ball1.intersects(paddle1)) {
            ball1.xVelocity = ball1.xVelocity * -1;
            ball1.yVelocity = ball1.yVelocity * -1;

            ball1.setXDirection(ball1.xVelocity);
            ball1.setYDirection(ball1.yVelocity);
            //give player score
            score.player1++;
            System.out.println("Score :" + score.player1 * 4);
        } if (score.player1 >= 10){



        }




    }
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while(true){     // this could be done a different way we can adjust later
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                Collision();   // ch the collesion
                repaint();
                delta--;
            }
        }


    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);

        }
        public void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
        }

    }
}
