/**
 * Problem Set 4.
 * 
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 * 
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 * 
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Scanner;

public class ProblemSet4 {
    
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();
        
        // comment out or uncomment as needed
        
        //ps.sum();
        //ps.reverse();
        //ps.digits();
        //ps.average();
        //ps.prime();
        //ps.fibonacci();
        ps.factors();
        ps.mario();
        ps.luigi();
        ps.credit();
                
        in.close();
    }
    
    /*
     * Exercise 1.
     * 
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     * 
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */
    
    public void sum() {
        int lowerBound = -1;
        int upperBound = 1;
        long total = 0;
        System.out.println("");

        do {
            System.out.print("Lower bound: ");
            lowerBound = in.nextInt();
            in.nextLine();
            System.out.print("Upper bound: ");
            upperBound = in.nextInt();
            in.nextLine();
        } while (upperBound < lowerBound);

        int i = lowerBound;
        while (i <= upperBound) {
            if (i % 2 == 0) {
                total += i;
            }
            i++;
        }
        System.out.printf("\n%,d\n", total);
    }
    
    /*
     * Exercise 2.
     * 
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */
    
    public void reverse() {
        int positiveNumber = 0;
        System.out.println("");
        do {
            System.out.print("Positive integer: ");
            positiveNumber = in.nextInt();
            in.nextLine();
        } while (positiveNumber <= 0);
        
        System.out.println("");
        while (positiveNumber > 0) {
            if (positiveNumber >= 10) {
                System.out.print((positiveNumber % 10) + ", ");
            } else {
                System.out.print((positiveNumber % 10) + ".");
            }
            positiveNumber /= 10;
        }

    }
    
    /*
     * Exercise 3.
     * 
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */
    
    public void digits() {
        int positiveNumber = 0;
        long total = 0;
        System.out.println("");
        do {
            System.out.print("Positive integer: ");
            positiveNumber = in.nextInt();
            in.nextLine();
        } while (positiveNumber <= 0);

        System.out.println("");
        while (positiveNumber > 0) {
            if (positiveNumber % 2 != 0) {
                total += (positiveNumber % 10);
            }
            positiveNumber /= 10;
        }
        System.out.println(total + ".");
    }
    
    /*
     * Exercise 4.
     * 
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */
    
    public void average() {
        int positiveNumber = 0;
        double total = 0;
        int numberCount = 0;
        System.out.println("");
        do {
            System.out.print("Non-negative integer: ");
            positiveNumber = in.nextInt();
            if (positiveNumber >= 0) {
                total += positiveNumber;
                numberCount++;
            }
        } while (positiveNumber >= 0);
        double average = (double) (total/numberCount);
        System.out.printf("\n%,.2f.", average);
    }
    
    /*
     * Exercise 5.
     * 
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */
    
    public void prime() {
        int positiveNumber = 0;
        boolean isPrime = true;
        System.out.println("");
        do {
            System.out.print("Non-negative integer: ");
            positiveNumber = in.nextInt();
        } while (positiveNumber < 0);

        if (positiveNumber == 2 || positiveNumber == 3 || positiveNumber == 5) {
            isPrime = true;
        } else if (positiveNumber <= 1) {
            isPrime = false;
        } else {
            int counter = 0;
            for (int i = 2; i < positiveNumber; i++) {
                if (positiveNumber % i == 0) {
                    counter++;
                }
            }
        
            if (counter == 0) {
                isPrime = true;
            } else {
                isPrime = false;
            }
        }

        if (isPrime) {
            System.out.println("\nPrime.");
        } else {
            System.out.println("\nNot prime.");
        }
    }
    
    /*
     * Exercise 6.
     * 
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */
    
    public void fibonacci() {
        int positiveNumber = 0;
        System.out.println("");
        do {
            System.out.print("Positive integer: ");
            positiveNumber = in.nextInt();
        } while (positiveNumber < 1 || positiveNumber > 92);
        positiveNumber += 1;
        
        int lowerFibNum = 0;
        int higherFibNum = 1;

        //issue: higher and lower one switches over and over
        for (int i = 0; i < positiveNumber - 1; i++) {
            int placeHolder;
            int firstFibNum = lowerFibNum;
            int secFibNum = higherFibNum;
            
            placeHolder = firstFibNum;
            firstFibNum = secFibNum;
            secFibNum = placeHolder + firstFibNum;
            
            if (firstFibNum > secFibNum) {
                higherFibNum = firstFibNum;
                lowerFibNum = secFibNum;
            } else {
                lowerFibNum = firstFibNum;
                higherFibNum = secFibNum;
            }
        }

        System.out.printf("\n" + lowerFibNum + ".");
    }
    
    /*
     * Exercise 7.
     * 
     * Prompt the user to enter a positive integer. What are its factors?
     */
    
    public void factors() {
        int positiveNumber = 0;
        boolean isPrime = true;
        System.out.println("");
        do {
            System.out.print("Positive integer: ");
            positiveNumber = in.nextInt();
        } while (positiveNumber <= 0);

        String message = "";
        for (int i = 1; i < positiveNumber + 1; i++) {
            if (positiveNumber % i == 0) {
                message += i;
                message += ", ";
                int otherFactor = positiveNumber / i;
                message += otherFactor;
                message += ", ";
            }
        }

        message = message.substring(0, ((message.length() - 1) / 2));
        message = message.substring(0, message.length() - 1);
        message += ".";
        System.out.println(message);
    }
    
    /*
     * Exercise 8.
     * 
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */
    
    public void mario() {        

    }
    
    /*
     * Exercise 9.
     * 
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */
    
    public void luigi() {

    }
    
    /*
     * Exercise 10.
     * 
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */
    
    public void credit() {
        
    }
}