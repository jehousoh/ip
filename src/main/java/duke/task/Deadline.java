package duke.task;
import java.time.LocalDate;

public class Deadline extends Task {
    /**
     * Child class of Task with a deadline
     */
    private static final String SYMBOL = "[D]";
    protected String dateStr;
    protected LocalDate dateTime;
    public Deadline(String description, String dateStr, LocalDate dateTime) {
        super(description, SYMBOL);
        this.dateStr = dateStr;
        this.dateTime = dateTime;
    }

    /**
     * Method to get the date of the deadline
     *
     * @return the date of the deadline
     */
    public String getDate() { return this.dateStr; }

    /**
     * Method to get the info of the event
     * in the format of [D]--[ ]--{deadline name}--{date}
     *
     * @return the info of the deadline
     */
    @Override
    public String getInfo() {
        return (super.getInfo() + "--" + getDate());
    }

    /**
     * Method to get the string info of the event
     * in the format of [D][ ] {deadline name} (by: {date})
     *
     * @return the date of the deadline
     */
    @Override
    public String toString() {
        return SYMBOL + super.toString() + " (by: " + dateStr + ")";
    }
}
