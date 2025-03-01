package method;

 class collage {
    public void Move(){
        System.out.println("colllage is open ");
    }
}
class univ extends collage {
    public void Move(){
        System.out.println("univ is open too ");
    }
}
public class stud{
    public static void main(String args[]){
        // a=new collage();    //error   compilation 
         collage a=new collage();   //the two out puts are output
        collage b=new univ();
        a.Move();
        b.Move();
    }
}