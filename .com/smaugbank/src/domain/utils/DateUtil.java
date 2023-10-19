package domain.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    private static final String DATA_BASE = "1997-10-07";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final ZoneId ZONE_BRAZIL = ZoneId.of("America/Sao_Paulo");

    public static String calculateDateFactor(LocalDateTime dueDate) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String format = formatter.format(dueDate);
        Date dataBase = DATE_FORMAT.parse(DATA_BASE);
        Date dataVenc = DATE_FORMAT.parse(format);

        long diferencaEmMillis = dataVenc.getTime() - dataBase.getTime();
        Integer fator = (int) (diferencaEmMillis / (1000 * 60 * 60 * 24));
        String dueDateText = fator.toString();

        return dueDateText;
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now(ZONE_BRAZIL);
    }

    public static LocalDateTime resetTimeToMidnight(LocalDateTime dateTime) {
        return dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static LocalDateTime addDays(LocalDateTime dateTime, int days) {
        return dateTime.plusDays(days);
    }
}
