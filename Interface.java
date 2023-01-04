import java.awt.*;
import java.awt.event.*;
import java.util. *;
import javax.swing.*;
public class Interface extends JFrame {
        GamePanel panel;

    Interface(){



        panel = new GamePanel();
    this.add(panel);
    this.setTitle("Pong Game");
    this.setResizable(false);
    this.setBackground(Color.lightGray);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
    this.setLocationRelativeTo(null);

    }
}
