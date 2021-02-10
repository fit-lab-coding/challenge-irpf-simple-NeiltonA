package fit;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class IrpfCalculator {
    public static double calculateBaseSalary(double totalSalary) {
        double result = calculateDedINSS(totalSalary);
        return totalSalary - result;
    }

    public static double calculateDiscount(double baseSalary) {
        return baseCalculate(baseSalary) ;
    }

    private static double baseCalculate(double baseSalary) {
        return baseSalary - 1903.98D;
    }

    public static double calculateTaxLayer(double baseSalary) {
        return tax(baseSalary);
    }

    public static double calculateIrpf(double totalSalary) {
        double result = calculateDedINSS(totalSalary);
        double result2 = (totalSalary - result - 1903.98D) * 0.075;

        return result2;
    }

    public static double  calculateExemption() {
        return calculate( 1903.98D);
    }

    private static double calculate(double salary){
        double ir = salary;

        if(ir <= 1903.98D){
            ir = 1903.98D;
        }else if(ir <= 2826.65d){
            ir = ir * salary - 0.075d;
        }else  if(ir <= 3751.05d){
            ir = ir * salary - 0.15d;;
        }else if(ir <= 4664.68d){
            ir = ir * salary - 0.225d;
        }else {
            ir = ir * salary - 0.275d;
        }
        return ir;
    }

    private static double tax(double salary){
        double tax;

        if(salary <= 1903.98D){
            tax = 0d;
        }else if(salary <= 2826.65d){
            tax = 0.075d;
        }else  if(salary <= 3751.05d){
            tax  =  0.15d;;
        }else if(salary <= 4664.68d){
            tax = 0.225d;
        }else {
           tax = 0.275d;
        }
        return tax;
    }

    private static double calculateDedINSS(double salary){
        double result;
        if(salary <= 1751.81d){
            result = salary * 0.08d;
        }else if(salary <= 2919.72d){
            result = salary * 0.09d;
        }else {
            result = salary * 0.11d;
        }
        return result;
    }
}
