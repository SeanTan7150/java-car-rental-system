package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Current {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    DateTimeFormatter tf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    LocalDateTime ld = LocalDateTime.now();
    public String datetime = dtf.format(ld);
    public String date = tf.format(ld);
    public String empty = null;
}