package domain.utils;

import java.util.Random;

public class StringUtil {

    public static String numberGenerator(int e) {
        Random random = new Random();
        int unicDigitRandom = random.nextInt(10);
        StringBuilder sequenceRandom = new StringBuilder();

        for (int i = 0; i < e; i++) {
            int digitRandom = random.nextInt(10);
            sequenceRandom.append(digitRandom);
        }

        sequenceRandom = sequenceRandom.append("-" + unicDigitRandom);
        return sequenceRandom.toString();
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

}
