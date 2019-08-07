package ut1pd1;

/**
 *
 * @author Lucas Astor
 */

public class UT1PD1 {
    /**
     * -- Letter of the exercise --
     * A lot of calculus can be expresed in a concrete way using the operation “multsuma”,
it takes an operand and it makes a*b + c. Also some processors provides an implementation
of hardware to do this operation for floating point numbers.
Make a Java program called Multsuma.java. Write a method called multsuma it takes three
doubles as parameters and prints the result.
Write a main wich tests multsuma invoking him with parameter like
1.0, 2.0, 3.0, and then print the result, it must be 5.0. 
     */
    /**
     * 
     * @param a variable to multiply
     * @param b variable to multiply
     * @param c variable to add
     * @return 
     */
    public static double Multsuma(double a,double b,double c){
        return a*b+c;
    }

    public static void main(String[] args) {
        //Test of the implementation
        double result = Multsuma(1.0,2.0,3.0);
        //Print the result on screen
        System.out.println(result);
    }
    
}
