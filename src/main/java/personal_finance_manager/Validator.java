package personal_finance_manager;

import java.util.regex.Pattern;

public class Validator
{
    public static boolean validateDescription(String description)
    {
        Pattern p = Pattern.compile("^[A-Za-z0-9]{5,}$");
        return p.matcher(description).matches();
    }
    public static boolean validateCategory(String category)
    {
        Pattern p = Pattern.compile("^[A-Za-z]{5,}$");
        return p.matcher(category).matches();
    }

    public static boolean validateBudgetLabel(String budgetLabel)
    {
        Pattern p = Pattern.compile("^[A-Za-z0-9]{5,}$");
        return p.matcher(budgetLabel).matches();
    }
}
