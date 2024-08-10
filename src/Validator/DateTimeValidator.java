package Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateTimeValidator extends Validator {
    public void validateDateTime(String dateTime) {
        String[] dateTimeList = dateTime.split(" ", 2);

        if (dateTimeList.length != 2) {
            throw new IllegalArgumentException();
        }

        try {
            validateDate(dateTimeList[0]);
            validateTime(dateTimeList[1]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDate(String date) {
        try {
            LocalDate.parse(date,
                    DateTimeFormatter.ofPattern(dateRegex)
                            .withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException();
        }
    }

    public void validateTime(String time) {
        boolean timeIsValid = validate(time, timeRegex);
        if (!timeIsValid) {
            throw new IllegalArgumentException();
        }
    }

    public void validateYear(String year) {
        Integer yearInt;

        try {
            yearInt = Integer.valueOf(year);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        if (yearInt > currentYear) {
            throw new IllegalArgumentException();
        }
    }
}