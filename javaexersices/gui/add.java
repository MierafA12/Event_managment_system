package gui;
import javax.swing.*;
public class add {
     public static void main(String[] args){
        String x=JOptionPane.showInputDialog("enter the first number");
        String y=JOptionPane.showInputDialog("enter the second number");
        int num1=Integer.parseInt(x);
        int num2=Integer.parseInt(y);
        int sum=num1+num2;
        JOptionPane.showMessageDialog(null,"the sum is "+sum);
     }
}
