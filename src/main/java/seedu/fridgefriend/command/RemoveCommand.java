package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.InvalidIndexException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to remove a food item from the fridge by index specify by user.
 */
public class RemoveCommand extends Command {

    private static final int EXTRA_INDEX = 1;
    private final int indexToRemove;
    private Food foodToBeRemoved;

    /**
     * Constructor creates a RemoveCommand object.
     * 
     * @param indexToRemove integer index given by user
     * @throws InvalidIndexException if provided index is out of bounds
     */
    public RemoveCommand(int indexToRemove) {
        int actualIndexToRemoved = indexToRemove - EXTRA_INDEX;
        this.indexToRemove = actualIndexToRemoved;
    }

    @Override
    public void execute() throws InvalidIndexException {
        removeFood();
        showResults();
    }

    private void removeFood() throws InvalidIndexException {
        try {
            this.foodToBeRemoved = fridge.getFood(indexToRemove);
        } catch (Exception e) {
            throw new InvalidIndexException(e);
        }
        fridge.removeByIndex(indexToRemove);
    }

    private void showResults() {
        Ui.printMessage(getMessagePrintedToUser());
    }

    /**
     * Return the results after remove the item from the fridge.
     *
     * @return the message shown to user
     */
    public String getMessagePrintedToUser() {
        String message = "Noted! I've removed " + foodToBeRemoved.getFoodName()
                + " from your fridge.\n"
                + "Now you have " + fridge.getSize()
                + " food in the fridge.";
        return message;
    }

}
