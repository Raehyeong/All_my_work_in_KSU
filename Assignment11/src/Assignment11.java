/*
Class: CSE 1322L
Section: J04
Term: Spring 2022
Instructor: Yamini Hanisha Talluri
Name: Raehyeong Lee
Lab #: Assignment11
*/

class CreditCard {
    private double balance;

    public CreditCard() {
        balance = 5000.00;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double balance) {
        this.balance -= balance;
    }
}


class CardHolder implements Runnable {
    private CreditCard card;

    public CardHolder(CreditCard card) {
        this.card = card;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            makeWithdrawal(500);
            if(card.getBalance() < 0) {
                System.out.println("Account is Overdrawn");
            }
        }
    }

    private synchronized void makeWithdrawal(double amount) {
        if (card.getBalance() < amount) {
            System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw $" + amount + card.getBalance());
        } else {
            System.out.println(Thread.currentThread().getName() + " Before Withdrawing $" + amount + " Balance: $"
                    + card.getBalance());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            card.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " After Withdrawing $" + amount + " Balance: $" + card.getBalance());
        }
    }

}

public class Assignment11 {
    public static void main(String[] args) {

        CreditCard creditCard = new CreditCard();
        CardHolder cardHolder = new CardHolder(creditCard);

        Thread thread1 = new Thread(cardHolder);
        thread1.setName("John");
        Thread thread2 = new Thread(cardHolder);
        thread2.setName("Mary");

        thread1.start();
        thread2.start();

    }
}