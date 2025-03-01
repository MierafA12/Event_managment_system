package exercises;
public class volume {
    double width = 19;
    double height = 40;
    double length =50;

}
class  volume1 {
     public static void main(String[] args){
        volume objct = new volume();
        double  x=objct.width;
        double y=objct.height;
        double z=objct.length;
        System.out.println("the volume is "+ x*y*z);
     }
    
}