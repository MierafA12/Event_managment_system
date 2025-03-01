package exercises;
// public class Main {
//     String x = "car";
//     int y =10;
//     public static void main(String[] args){
//             Main myMain = new Main();
//             Main myObj = new Main();
//             System.out.println(myMain.x);
//             System.out.println(myObj.y);
//             myObj.y=20;
//             System.out.println(myObj.y);
//             System.out.println("hi");

//     }
// }



public class Main {
    static void myMethod(){
        System.out.println("hey i an java developer");
    }
    
    public void myMethod2(int x, int y){
        System.out.println("hey an object oriented java developer:"+ x+y);
    }

    public static void main(String[] args) {
        myMethod();
        Main myObj = new Main();
        myObj.myMethod2(2,5);
    }
}   