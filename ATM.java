package ATM_Interface;
import java.util.Scanner;

public class ATM {
    Scanner sc = new Scanner(System.in);
    public double withdrwing;
    public double depositAmount;
    public double Balance;

    public void setcheckBalance(double Balance){
        this.Balance = Balance;
    }
    public double getcheckBalance(){
        return Balance;
    }
    public void Menu(){
        System.out.println("Menu\n");
        System.out.println("    1- Checking Balance");
        System.out.println("    2- Deposite");
        System.out.print("    3- Withdraw\n");
        System.out.print("Enter Your Choice : ");

    }

    public void Withdraw(){
        System.out.print("Enter Your withdraw Amount : ");
        double Amount;
        Amount = sc.nextDouble();

        if(Balance<Amount){
            System.out.print("Your Balance is insufficient");
        }
        else{
            System.out.println("Successfully withdrawed");
            setcheckBalance(getcheckBalance()-Amount);
        }
    }
    public void deposit(){
        System.out.print("Enter your deposite Amount : ");
        depositAmount = sc.nextDouble();
        System.out.println("Successfully Deposited");
        setcheckBalance(getcheckBalance()+depositAmount);

    }
    public double Checkingbalance(){
        return Balance;
    }
}
class Details extends ATM{
    String Name,account_NO,type;
    Details(String Name, String account_NO, String type){
        this.Name = Name;
        this.account_NO = account_NO;
        this.type = type;
    }
    public void Account(){
        System.out.println("AccountHolderName : "+Name);
        System.out.println("Account No        : "+account_NO);
        System.out.println("Account Type      :"+type);
       // System.out.println("Balance      :"+getcheckBalance());
        System.out.println("--------------------------");

    }
}
class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int Choice;
        char wish;
        Details de = new Details("Christheena", "82387945", "Saving");
        ATM at = new ATM();
        at.setcheckBalance(56000.00);

        System.out.println("--------User Details-------");
        de.Account();
        do{
            at.Menu();
            Choice =sc.nextInt();
            switch (Choice) {
                case 1:
                    System.out.println("Account Balance : "+at.Checkingbalance());
                    break;
                case 2:
                    at.deposit();
                    break;
                case 3:
                    at.Withdraw();
                    break;
                default:
                    System.out.println("Your choice isn't found ");
                    break;
            }
            System.out.print("Do you want to Activate Again [Y|N]: ");
            wish= sc.next().charAt(0);
        }
        while(wish=='Y' || wish=='y');
        System.out.println("Thank you for Choosing us\n Have A Nice Day");
    }
}