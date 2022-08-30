import java.util.Scanner;

import duke.helper.Parser;
import duke.helper.Storage;
import duke.helper.Ui;
import duke.task.TaskList;

/**
 * Main class used to handle inputs
 */
public class Duke {
    private TaskList list;
    private Storage storage;

    /**
     * Constructor of the Duke class given a filepath
     * @param filePath path of file to be saved/loaded from
     */
    public Duke(String filePath) {
        storage = new Storage(filePath);
        list = new TaskList(storage.load());
    }

    /**
     * This method runs the duke program
     */
    public void run() {
        Ui.welcome();

        String in = "";
        Scanner sc = new Scanner(System.in);

        while (true) {
            in = sc.nextLine();
            if (in.equals("bye")) {
                break;
            } else {
                Parser.parse(in, list);
            }
        }
        Ui.bye();
    }
    public static void main(String[] args) {
        new Duke("./data/duke.txt").run();
    }
}
