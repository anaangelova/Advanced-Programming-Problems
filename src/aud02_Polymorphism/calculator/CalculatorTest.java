package aud02_Polymorphism.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static char getFirstCharLower(String line){
        if(line.trim().length()>0){
            return Character.toLowerCase(line.charAt(0));
        }
        return '?';
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(true){ // Y/N
            Calculator calculator=new Calculator();  //za sekoja nova presmetka, korisnikot dobiva "nov" kalkulator
            System.out.println("Calculator is on.");

            while (true){ //R
                String line=scanner.nextLine();
                char choice=CalculatorTest.getFirstCharLower(line);
                if(choice=='r'){
                    System.out.format("Final result is: %.2f",calculator.getResult());
                    break;
                }
                String[] parts=line.split("\\s+");
                char operator= parts[0].charAt(0);
                double value=Double.parseDouble(parts[1]);
                try{
                    System.out.println(calculator.execute(operator,value));
                    System.out.println(calculator);
                }catch (UnknownOperatorException exception){
                    System.out.println(exception.getMessage());

                }

            }
            System.out.println("Again? Y/N");
            String line=scanner.nextLine();
            char choice=CalculatorTest.getFirstCharLower(line);
            if(choice=='n') break;
        }
    }
}
