package domain.ienum.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String DATA_BASE = "1997-10-07";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static String calculateDateFactor(String dueDate) throws ParseException {

        Date dataBase = DATE_FORMAT.parse(DATA_BASE);
        Date dataVenc = DATE_FORMAT.parse(dueDate);

        long diferencaEmMillis = dataVenc.getTime() - dataBase.getTime();
        Integer fator = (int) (diferencaEmMillis / (1000 * 60 * 60 * 24));
        String dueDateText = fator.toString();

        return dueDateText;
    }

}
