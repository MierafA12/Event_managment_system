package exercises;
// swamping numbers using third variable

public class swap {
    public static void main(String[] args){
        int a =10;
        int b = 20;
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping: a = "+a+" b = "+b);

    }
}
