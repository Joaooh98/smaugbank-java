package domain.ienum.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    private static final String DATA_BASE = "1997-10-07";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

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

}
