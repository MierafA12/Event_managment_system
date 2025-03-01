package inheritance;
import java.util.Scanner;

 class shape {
    float radius;
    float pi=3.14f;
    float p;
    float A;
    public void  getPerimeter(){
       float  p=2*pi*radius;
       System.out.println("the perimeter is " + p);
    }
    public void  getArea(){
       float A=pi*radius*radius;
       System.out.println("the AREA is " +A);
    }
}
class circle extends shape {
    public void  getPerimeter(){
         float p=2*pi*radius;
        System.out.println("the perimeter is " + p);
    }
    public void  getArea(){
         float A=pi*radius*radius;
       System.out.println("the AREA is " +A);
    }
}
public class main{
    public static void main(String[] args){
      Scanner scanner= new Scanner(System.in);
      System.out.println("enter the radius");
     float radius= scanner.nextFloat();
      circle c1= new circle();
      c1.radius=radius;
      c1.getPerimeter();
      c1.getArea();
    }
}
