package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeGranularity {
    private long diff;

    public void setGranularity(String datetime) throws ParseException {
        Current c = new Current();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date now = format.parse(c.datetime);
        Date ago = format.parse(datetime);
        diff = TimeUnit.DAYS.convert(Math.abs(ago.getTime() - now.getTime()), TimeUnit.MILLISECONDS);
    }

    public String getGranularity() {
        if (diff == 0) {
            return "Today";
        } else if (diff == 1) {
            return Long.toString(diff) + " day ago";
        } else if (diff > 1 && diff < 30) {
            return Long.toString(diff) + " days ago";
        } else if (diff > 30) {
            return "Several months ago";
        } else {
            return null;
        }
    }
}