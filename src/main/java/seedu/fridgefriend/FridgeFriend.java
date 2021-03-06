package seedu.fridgefriend;

import seedu.fridgefriend.command.Command;
import seedu.fridgefriend.exception.InvalidIndexException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.utilities.Logger;
import seedu.fridgefriend.utilities.Parser;
import seedu.fridgefriend.utilities.Storage;
import seedu.fridgefriend.utilities.Ui;

public class FridgeFriend {

    private static boolean isExit = false;
    public static Fridge fridge = new Fridge();

    public FridgeFriend() {
        new Ui();
        new Logger();
        Logger.logInfo("FridgeFriend application initialised.");
        new Storage();
    }

    public static void main(String[] args) {
        Ui.printWelcomeMessage();
        Storage.load(fridge);
        run();
        Storage.save(fridge);
        Ui.printByeMessage();
    }

    private static void run() {
        Logger.logInfo("Main programme loop started.");
        while (!isExit) {
            try {
                String input = Ui.getNextLine();
                Command command = Parser.getCommand(input);
                executeCommand(command);
                isExit = command.isExit();
            } catch (Exception exception) {
                Ui.printExceptionMessage(exception);
                Logger.logInfo("Error found.", exception);
            }
        }
        Logger.logInfo("Main programme loop exited.");
    }

    private static void executeCommand(Command command) throws InvalidInputException, InvalidIndexException {
        command.setData(fridge);
        command.execute();
    }
}