import java.util.ArrayList;

public class PersonalizedMealPlanGenerator {

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegetarianMeal =
                new Meal<>(new VegetarianMeal());

        Meal<VeganMeal> veganMeal =
                new Meal<>(new VeganMeal());

        Meal<KetoMeal> ketoMeal =
                new Meal<>(new KetoMeal());

        Meal<HighProteinMeal> proteinMeal =
                new Meal<>(new HighProteinMeal());

        generateMeal(vegetarianMeal);
        generateMeal(veganMeal);
        generateMeal(ketoMeal);
        generateMeal(proteinMeal);
    }

    public static <T extends MealPlan> void generateMeal(Meal<T> meal) {

        System.out.println("Meal Plan: " + meal.getMeal().getMealName());
    }
}

interface MealPlan {

    String getMealName();
}

class VegetarianMeal implements MealPlan {

    public String getMealName() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {

    public String getMealName() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {

    public String getMealName() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {

    public String getMealName() {
        return "High Protein Meal";
    }
}

class Meal<T extends MealPlan> {

    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }
}