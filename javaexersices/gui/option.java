package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class option {
    JFrame frame;
     void JOptionPane(){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(300, 200);
        JOptionPane.showMessageDialog(frame, "login successfully");
    }
    public static void main(String[] args) {
        new JOptionPane();
       
    }
    
}

