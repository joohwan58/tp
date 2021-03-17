package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.utilities.Ui;
import seedu.fridgefriend.utilities.Logger;

/**
 * Represents a command to search for a specific food item in the fridge.
 */
public class SearchCommand extends Command {

    public static final int NOT_FOUND = -1;
    private String foodName;

    public SearchCommand(String foodName) throws EmptyDescriptionException {
        if (foodName.isEmpty()) {
            throw new EmptyDescriptionException();
        }
        this.foodName = foodName;
    }

    @Override
    public void execute() {
        showResults();
    }

    private void showResults() {
        Ui.printMessage(getMessagePrintedToUser());
    }

    /**
     * Returns the result of the command.
     *
     * @return the message shown to the user
     */
    public String getMessagePrintedToUser() {
        int indexOfFoodStored = getIndexOfFoodStored();
        String message;
        if (indexOfFoodStored >= 0) {
            Logger.logInfo("Search for food successful: " + foodName + " found.");
            message = "You have " + foodName + " stored in "
                    + fridge.getFood(indexOfFoodStored).getStorageLocation()
                    + " of your fridge.";
        } else {
            Logger.logInfo("Search for food unsuccessful: No " + foodName + " found.");
            message = "You do not have " + foodName + " in your fridge.";
        }
        assert message != null : "message string should not be null";
        return message;
    }

    private int getIndexOfFoodStored() {
        assert !foodName.equals(null) : "Unable to search a null food name";
        for (int i = 0; i < fridge.getSize(); i += 1) {
            Food food = fridge.getFood(i);
            if (food.getFoodName().equals(foodName)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

}
