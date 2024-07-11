import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import personal_finance_manager.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinanceTest
{
    private static Methods m;

    @BeforeAll
    public static void setUp() {
        m = new Methods();
    }
    @Test
    public void testAddTransaction() throws CustomeException {
    Category category = new Category("Food");
    Transaction transaction = new Transaction("Lunch", 10.0, LocalDate.now(), category);
    m.addTrans(transaction);
    assertEquals(1, m.ViewTransAll().size());
    }
    @Test
    public void testSetBudget() {
        Category category = new Category("Food");
        Budget budget = new Budget(200.0, category);
        m.setBudget(budget);
        assertEquals(200.0, m.viewBudget("Food").getAmount());
    }

}
