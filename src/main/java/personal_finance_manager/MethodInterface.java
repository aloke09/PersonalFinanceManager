package personal_finance_manager;

import java.io.IOException;
import java.util.List;

public interface MethodInterface
{
    public void addTrans(Transaction transaction) throws CustomeException;
    public List<Transaction> ViewTransAll();
    public void setBudget(Budget budget);
    public Budget viewBudget(String Cname);
    public void setGoal(Goal goal) throws CustomeException;
    public List<Goal> viewGoal();
    public double getTotalExpense(String cName);
    public void saveTransactionsToFile(String filename) throws IOException;
    public void loadTransactionsFromFile(String filename) throws IOException, ClassNotFoundException;
}
