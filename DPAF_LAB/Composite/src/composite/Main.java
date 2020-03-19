/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

/**
 *
 * @author Yash
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Employee dean = new Employee("D.G.Panchal", "Dean,FOT");
        Employee HODIT = new Employee("V.Dabhi", "HOD,IT");
        Employee HODEC = new Employee("N.J.Kothari", "HOD,EC");
        Employee f1 = new Employee("M.M.G.", "AP,IT");
        Employee f2 = new Employee("A.D.D.", "AP,IT");
        Employee f3 = new Employee("H.M.P.", "AP,EC");
        Employee f4 = new Employee("M.A.S.", "AP,EC");
        dean.add(HODIT);
        dean.add(HODEC);
        HODIT.add(f1);
        HODIT.add(f2);
        HODEC.add(f3);
        HODEC.add(f4);
        System.out.println(dean);
        for (Employee headEmployee : dean.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }

        }
    }
}