package exception;

public class main {
    public static void main(String[] args)  {
        // int dividedByZero=5/0;
        // System.out.println(dividedByZero); Arithmetic Exception
        // String s=null;
        // System.out.println(s.length());  Nullpointer Exception
        // int[] myNumbers={1,2,3};
        // System.out.println(myNumbers[5]); ArrayIndexOutOfBoundsException

        int num[]={1,7,12,19,16,19};	
        try{
            // System.out.println("num[0]="+num[0]);
            // System.out.println("num[0]="+num [1]);
            // System.out.println("num[0]="+num[2]);
            // System.out.println("num[0]="+num[3]);
            // System.out.println("num[0]="+num[4]);
            // int data = 50/0;
            int d=25/0;
            System.out.println(d);
        }
      //  catch(ArithmeticException err){  // not Handle  the exception then finally,error
           // System.out.println(err);
        //}
        finally{
            System.out.println("finaly block is always excutable");
        }
        System.out.println("rest of code");
     
    }
}
