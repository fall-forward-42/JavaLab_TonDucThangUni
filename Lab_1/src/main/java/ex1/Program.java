package ex1;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Excute programe: ");
        String input = sc.nextLine();
        sc.close();

        try {
            String[] tokens = input.split(" ");
            int operand1 = Integer.parseInt(tokens[0]);
            String o3 = tokens[1];
            int operand2 = Integer.parseInt(tokens[2]);
            int result = 0;
            switch (o3) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
                default:
                    System.out.println("Invalid operator");
                    return;
            }
                System.out.println("Result: " + result);
        }catch (Exception e){
            System.out.println("Invalid input. Please enter a valid mathematical expression.");
        }

    }
}
