/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexpr;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Yash
 */
public class Main {
    
    static private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
    
    public static int totalNumbers(List<Integer> numbers, Predicate<Integer> selector) {
        int result = 0;
        for (int no : numbers) {
            if (selector.test(no)) {
                System.out.print(no+" ");
                result += no;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (int a, int b) -> a - b;
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        MathOperation division = (int a, int b) -> a / b;
        System.out.println("25 + 10 = " + operate(25, 10, addition));
        System.out.println("25 - 10 = " + operate(25, 10, subtraction));
        System.out.println("25 * 10 = " + operate(25, 10, multiplication));
        System.out.println("25 / 10 = " + operate(25, 10, division));

        List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 7, 9, 10, 12, 13);
        System.out.println("\tTotal of the numbers is: " + totalNumbers(numbers, no -> true));
        //System.out.println("");
        System.out.println("\tTotal of the Even numbers is: " + totalNumbers(numbers, no -> no % 2 == 0));
        //System.out.println("");
        System.out.println("\tTotal of the Odd numbers is: " + totalNumbers(numbers, no -> no % 2 != 0));
        //System.out.println("");
    }

    
}
