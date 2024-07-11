package personal_finance_manager;

public class Budget
{
    private double amount;
    private Category category;

    public Budget(double amount, Category category) {
        this.amount = amount;
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "amount=" + amount +
                ", category=" + category +
                '}';
    }
}
