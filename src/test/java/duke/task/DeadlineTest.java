package duke.task;

import duke.helper.DateTimeConverter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void toStringTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-M-d");
        DateTimeConverter converter = new DateTimeConverter(formatter);
        String[] dateTime = new String[ ] {"2022-5-12", "1800"};
        assertEquals(new Deadline("return book", converter.convert(dateTime),
                LocalDate.parse(dateTime[0], formatter)).toString(),
                        "[D][ ] return book (by: May 12 2022 6:00 PM)");
    }
}