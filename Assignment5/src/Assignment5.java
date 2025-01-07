/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab#: Assignment5
*/

import java.util.ArrayList;
import java.util.Scanner;

interface Deductible {
    public boolean hasMetDeductible();
    public boolean hasMetTotalOutOfPocket();
}

abstract class InsurancePolicy {
    private String policyHolder;
    private int policyNumber;
    private static int numberOfPolicies = 0;
    private double premium = 0;

    public InsurancePolicy(String policyHolder) {
        this.policyHolder = policyHolder;
        numberOfPolicies++;
    }

    public abstract void selectPolicyCoverage();

    public abstract void calculatePremium();

    public String getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(String policyHolder) {
        this.policyHolder = policyHolder;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber ;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public static int getNumberOfPolicies() {
        return numberOfPolicies;
    }

    public static void setNumberOfPolicies(int numberOfPolicies) {
        InsurancePolicy.numberOfPolicies = numberOfPolicies;
    }

    @Override
    public String toString() {
        return String.format("Policy Holder: %s \nPolicy Number: %s \nNo of Policies: %s \nPremium: %s",
                this.policyHolder, this.policyNumber, InsurancePolicy.numberOfPolicies, this.premium);
    }
}


class HealthInsurancePolicy extends InsurancePolicy implements Deductible {
    private double deductibleLimit;
    private double totalDeductiblePaid = 0;
    private double coPayment;
    private double totalCoPaymentPaid = 0;
    private double totalOutOfPocket;

    public HealthInsurancePolicy(String policyHolder, double deductibleLimit, double coPayment,
                                 double totalOutOfPocket) {
        super(policyHolder);
        this.deductibleLimit = deductibleLimit;
        this.coPayment = coPayment;
        this.totalOutOfPocket = totalOutOfPocket;
    }

    public double getDeductibleLimit() {
        return deductibleLimit;
    }

    public void setDeductibleLimit(double deductibleLimit) {
        this.deductibleLimit = deductibleLimit;
    }

    public double getTotalDeductiblePaid() {
        return totalDeductiblePaid;
    }

    public void setTotalDeductiblePaid(double totalDeductiblePaid) {
        this.totalDeductiblePaid = totalDeductiblePaid;
    }

    public double getCoPayment() {
        return coPayment;
    }

    public void setCoPayment(double coPayment) {
        this.coPayment = coPayment;
    }

    public double getTotalCoPaymentPaid() {
        return totalCoPaymentPaid;
    }

    public void setTotalCoPaymentPaid(double totalCoPaymentPaid) {
        this.totalCoPaymentPaid = totalCoPaymentPaid;
    }

    public double getTotalOutOfPocket() {
        return totalOutOfPocket;
    }

    public void setTotalOutOfPocket(double totalOutOfPocket) {
        this.totalOutOfPocket = totalOutOfPocket;
    }

    @Override
    public void selectPolicyCoverage() {
        System.out.println("Selecting policy coverage");
    }
    @Override
    public void calculatePremium() {
        System.out.println("Calculating and updating premium");
    }
    @Override
    public boolean hasMetDeductible() {
        return totalDeductiblePaid >= deductibleLimit;
    }
    @Override
    public boolean hasMetTotalOutOfPocket() {
        return (totalDeductiblePaid + totalCoPaymentPaid) >= totalOutOfPocket;
    }
    @Override
    public String toString() {
        return super.toString() + "\nDeductible Amount: " + deductibleLimit + "\nTotal deductible paid: " + totalCoPaymentPaid + "\nCo-payment amount: " + coPayment + "\nTotal co-payment paid: " + totalCoPaymentPaid + "\nTotal out-of-pocket amount: " + totalOutOfPocket;
    }
}

class TermLifeInsurancePolicy extends InsurancePolicy {
    private String beneficiary;
    private int term;
    private double termPayout;

    public TermLifeInsurancePolicy(String policyHolder, String beneficiary, int term, double termPayout) {
        super(policyHolder);
        this.beneficiary = beneficiary;
        this.term = term;
        this.termPayout = termPayout;
    }

    @Override
    public void selectPolicyCoverage() {
        System.out.println("Selecting policy coverages");
    }

    @Override
    public void calculatePremium() {
        System.out.println("Calculating and updating premium");
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getTermPayout() {
        return termPayout;
    }

    public void setTermPayout(double termPayout) {
        this.termPayout = termPayout;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nBeneficiary: " + beneficiary
                + "\nNo of years in term: " + term
                + "\nTerm payout: " + termPayout;
    }}


public class Assignment5 {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        ArrayList<InsurancePolicy> insurancePolicies = new ArrayList<>();

        while (true) {
            System.out.println("\n1 - Create Health Insurance Policy");
            System.out.println("2 - Create Term-Life Insurance Policy");
            System.out.println("3 - Exit\n");

            System.out.print("Enter choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            if (choice == 1) {
                System.out.println("\nEnter name of policy holder:");
                String policyHolder = scan.nextLine();

                System.out.println("Enter deductible amount:");
                double deductibleLimit = scan.nextDouble();

                System.out.println("Enter co-payment amount:");
                double coPayment = scan.nextDouble();

                System.out.println("Enter total out-of-pocket amount:");
                double totalOutOfPocket = scan.nextDouble();

                insurancePolicies
                        .add(new HealthInsurancePolicy(policyHolder, deductibleLimit, coPayment, totalOutOfPocket));
            } else if (choice == 2) {

                System.out.println("\nEnter name of policy holder:");
                String policyHolder = scan.nextLine();
                System.out.println("Enter name of beneficiary:");
                String beneficiary = scan.nextLine();
                System.out.println("Enter number of years in term:");
                int term = scan.nextInt();
                System.out.println("Enter amount of payout:");
                double termPayout = scan.nextDouble();

                insurancePolicies.add(new TermLifeInsurancePolicy(policyHolder, beneficiary, term, termPayout));
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Error: Please Enter Valid Input");
            }
        }

        for (InsurancePolicy insurancePolicy : insurancePolicies) {
            System.out.print(insurancePolicy.getPolicyHolder() + ",");
            System.out.print("\t" + insurancePolicy.getPolicyNumber()+ ", ");

            if (insurancePolicy instanceof HealthInsurancePolicy) {
                HealthInsurancePolicy hip = (HealthInsurancePolicy) insurancePolicy;
                System.out.print("Met Deductible: " + (hip.hasMetDeductible() ? "true" : "false"));
                System.out.print(", Met Total Out-of-Pocket: " + (hip.hasMetTotalOutOfPocket() ? "true" : "false"));
            }
            System.out.println();
        }
    }
}
