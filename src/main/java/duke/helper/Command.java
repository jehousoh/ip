package duke.helper;

import duke.exception.InvalidCommandException;
import duke.exception.InvalidDateException;
import duke.exception.NoDescriptionException;
import duke.task.ErrorTask;
import duke.task.Task;
import duke.task.TaskCreator;
import duke.task.TaskList;

/**
 * Class to contain all the commands for parse
 */
public class Command {

    /**
     * Method to find task given a String and TaskList
     *
     * @param in the input command given
     * @param list the list to find the task from
     * @return the string representing the task found
     */
    public static String find(String in, TaskList list) {
        String keywords = in.split(" ", 2)[1];
        return list.find(keywords);
    }

    /**
     * Method to clear the list given
     * @param list the list to be cleared
     * @return the string message of clear
     */
    public static String clear(TaskList list) {
        return list.clear();
    }

    /**
     * Method to list out the tasks in the list given
     * @param list the list to be listed out
     * @return the string of the list
     */
    public static String list(TaskList list) {
        return list.printTasks();
    }

    /**
     * Method to mark a task given a String and TaskList
     *
     * @param in the input command given
     * @param list the list to mark the task from
     * @return the string message of mark
     */
    public static String mark(String in, TaskList list) {
        int index = Integer.valueOf(in.split(" ")[1]) - 1;
        return list.mark(index);
    }

    /**
     * Method to unmark a task given a String and TaskList
     *
     * @param in the input command given
     * @param list the list to unmark the task from
     * @return the string message of unmark
     */
    public static String unmark(String in, TaskList list) {
        int index = Integer.valueOf(in.split(" ")[1]) - 1;
        return list.unmark(index);
    }

    /**
     * Method to delete a task given a String and TaskList
     *
     * @param in the input command given
     * @param list the list to delete the task from
     * @return the string message of delete with the task deleted
     */
    public static String delete(String in, TaskList list) {
        int index = Integer.valueOf(in.split(" ")[1]) - 1;
        String message;

        try {
            if (index >= list.getSize()) {
                throw new InvalidCommandException();
            }
            Task task = list.getTask(index);
            message = Ui.delete(task) + "\n";
            list.delete(index);
            message += Ui.countTasks(list);
            return message;
        } catch (InvalidCommandException e) {
            return e.toString();
        }
    }

    public static String createTask(String in, TaskList list) {
        String message;
        try {
            Task task = TaskCreator.createTask(in);
            if (task == null) {
                throw new InvalidCommandException();
            } else if (task.getClass() == ErrorTask.class) {
                throw new InvalidDateException();
            } else if (task.getDescription().length() < 1) {
                throw new NoDescriptionException();
            } else {
                list.add(task);
                message = Ui.add(task);
                return message;
            }
        } catch (Exception e) {
            return e.toString();
        }
    }
}
