package personal_finance_manager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws CustomeException, IOException {

        Scanner sc=new Scanner(System.in);
        Methods m=new Methods();
        while(true)
        {
            System.out.println("1. ADD TRANSACTION");
            System.out.println("2. VIEW ALL TRANSACTION");
            System.out.println("3. SET BUDGET");
            System.out.println("4. VIEW BUDGET");
            System.out.println("5. SET GOAL");
            System.out.println("6. VIEW GOAL");
            System.out.println("7. GET TOTAL EXPENSE");
            System.out.println("8. SAVE TO FILE");
            System.out.println("9. RETRIEVE FROM FILE");
            System.out.println("10.EXIT");
            System.out.println("Enter your choice-");
            int choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter Description-");
                    String desc=sc.next();
                    System.out.println("Enter Amount-");
                    double amt=sc.nextDouble();
                    System.out.println("Enter Category");
                    String category=sc.next();
                    Transaction t=new Transaction(desc,amt,LocalDate.now(),new Category(category));
//                    Transaction t1=new Transaction("Lunch",100, LocalDate.now(),new Category("Food"));
                    m.addTrans(t);
                    break;
                case 2:
                    m.ViewTransAll().forEach(System.out::println);
                    break;
                case 3:
//                    Budget b1=new Budget(100,new Category("Food"));
                    System.out.println("Enter amount -");
                    double amt3=sc.nextDouble();
                    System.out.println("Enter Category -");
                    String category3=sc.next();
                    Budget b=new Budget(amt3,new Category(category3));
                    m.setBudget(b);
                    break;
                case 4:
                    System.out.println("Enter Category-");
                    String category4=sc.next();
                    Budget budget4 = m.viewBudget(category4);
                    System.out.println(budget4);
                    break;
                case 5:
//                    Goal g1=new Goal("goal",100,25);
                    System.out.println("Enter goal name-");
                    String g5=sc.next();
                    System.out.println("Enter target amount-");
                    double tamt=sc.nextDouble();
                    System.out.println("Enter Current amount-");
                    double camt=sc.nextDouble();
                    Goal g=new Goal(g5,tamt,camt);
                    m.setGoal(g);
                    break;
                case 6:
                    m.viewGoal().forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Enter Category to get there total expense:-");
                    String c7=sc.next();
                    System.out.println("total expense of "+c7+" is "+m.getTotalExpense(c7));
                    break;
                case 8:
                    System.out.println("Enter file location to save transactions-");
                    String fileloc=sc.next();
                    m.saveTransactionsToFile(fileloc);
                    break;
                case 9:
                    System.out.println("Enter file location to retrieve transactions-");
                    String fileloc10=sc.next();
                    m.saveTransactionsToFile(fileloc10);
                    break;
                case 10:
                    System.out.println("EXIT!!");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid choice!!");
            }
        }
    }
}
