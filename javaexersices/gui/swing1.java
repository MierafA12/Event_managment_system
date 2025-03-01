package gui;
import javax.swing.*;

public class swing1 {
    public static void main(String[] args){
     JFrame frame = new JFrame("name");
     JLabel l1,l2,l3;
     l1 = new JLabel("Name:");
     l1.setBounds(30,80,90,50);
     l2=new JLabel("password");
     l2.setBounds(30,130,140,55);
     l3= new JLabel("Gender:");
     l3.setBounds(30,170,100,50);
     JButton bb = new JButton("login");
     JTextField b = new JTextField("");
     JTextField s = new JTextField("");
     JRadioButton r1 = new JRadioButton("male");
     r1.setBounds(80,170,100,50);
     JRadioButton r2 = new JRadioButton("female");
     r2.setBounds(200,170,100,50);
      ButtonGroup bg = new ButtonGroup();
     s.setBounds(80,130,150,50); 
     b.setBounds(80,80,150,50); 
     bb.setBounds(80,210,80,40); // X axis,y axis,width,height
     frame .add(b);
     frame.add(bb);
     frame.add(s);
     frame.add(l3);
     frame.add(l1);frame.add(l2);
     frame.add(r1);frame.add(r2); // add to button group
      bg.add(r1);bg.add(r2);
     frame.setSize(400,500);
     frame.setLayout(null);
     frame.setVisible(true);
    }
}
