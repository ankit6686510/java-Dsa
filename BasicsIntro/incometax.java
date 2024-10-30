package BasicsIntro;
import java.util.Scanner;

class IncomeTaxBasic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter your annual income: ");
        double income = scn.nextDouble();
        double tax = 0;

        // Calculate tax based on income slabs
        if (income <= 250000) {
            tax = 0;
        } else if (income <= 500000) {
            tax = (income - 250000) * 0.05;
        } else if (income <= 1000000) {
            tax = (250000 * 0.05) + (income - 500000) * 0.20;
        } else {
            tax = (250000 * 0.05) + (500000 * 0.20) + (income - 1000000) * 0.30;
        }

        // Calculate net income after tax
        double netIncome = income - tax;

        // Display the output
        System.out.println("Your calculated tax is: " + tax);
        System.out.println("Your net income after tax is: " + netIncome);

        // Close the scanner
        scn.close();
    }
}

class IncomeTaxWithCommas {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter your annual income: ");
        String incomeStr = scn.next();

        // Remove commas if any
        incomeStr = incomeStr.replace(",", "");
        double income = Double.parseDouble(incomeStr);
        double tax = 0;

        // Calculate tax based on income slabs
        if (income <= 250000) {
            tax = 0;
        } else if (income <= 500000) {
            tax = (income - 250000) * 0.05;
        } else if (income <= 1000000) {
            tax = (250000 * 0.05) + (income - 500000) * 0.20;
        } else {
            tax = (250000 * 0.05) + (500000 * 0.20) + (income - 1000000) * 0.30;
        }

        // Calculate net income after tax
        double netIncome = income - tax;

        // Display the output with formatted values
        System.out.printf("Your calculated tax is: %.2f%n", tax);
        System.out.printf("Your net income after tax is: %.2f%n", netIncome);

        // Close the scanner
        scn.close();
    }
}
