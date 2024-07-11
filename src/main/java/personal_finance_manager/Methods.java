package personal_finance_manager;

import java.io.*;
import java.util.*;

public class Methods implements MethodInterface {
    //private static final Logger logger = Logger.getLogger(Methods.class.getName());

    private List<Transaction> transactions = new ArrayList<>();
    public Map<String, Budget> budgets = new HashMap<>();
    private List<Goal> goals = new ArrayList<>();

    public void addTrans(Transaction transaction) throws CustomeException {
        if(transaction.getAmount()<=0)
        {
            throw new CustomeException("Transaction amount should be greater then 0");
        }
        else {
            transactions.add(transaction);
        }
    }
    public List<Transaction> ViewTransAll()
    {
        return transactions;
    }
    public void setBudget(Budget budget)
    {
        budgets.put(budget.getCategory().getName(),budget);
    }
    public Budget viewBudget(String Cname)
    {
        budgets.put("null",new Budget(0.0,new Category("null")));
        if(budgets.containsKey(Cname))
        {
            return budgets.get(Cname);
        }
        else
        {
            return budgets.get("null");
        }
//
    }
    public void setGoal(Goal goal) throws CustomeException {
        if(goal.getCurrentAmount()*2<=goal.getTargetAmount())
        {
            throw new CustomeException("Target Amount is more then twice the Actual Amount");
        }
        else {
            goals.add(goal);
        }
    }
    public List<Goal> viewGoal()
    {
        return goals;
    }
    public double getTotalExpense(String cName)
    {
        return transactions.stream().filter(f->f.getCategory().getName().equalsIgnoreCase(cName))
                .mapToDouble(Transaction::getAmount).sum();
    }
    public void saveTransactionsToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(transactions);
        } catch (IOException e) {
            System.err.println("Failed to save transactions: " + e.getMessage());
            throw e;
        }
    }

    public void loadTransactionsFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            transactions = (List<Transaction>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load transactions: " + e.getMessage());
            throw e;
        }
    }

}
