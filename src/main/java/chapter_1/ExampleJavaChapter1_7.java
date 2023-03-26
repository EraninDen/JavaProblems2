package chapter_1;

public class ExampleJavaChapter1_7 {
    // Конвертирование строки в:
    // int, long, float, double

    private static final String TO_INT = "423";
    private static final String TO_LONG = "4233425234234";
    private static final String TO_FLOAT = "45.823F";
    private static final String TO_DOUBLE = "13.89847D";

    int toInt = Integer.parseInt(TO_INT);
    long toLong = Long.parseLong(TO_LONG);
    float toFloat = Float.parseFloat(TO_FLOAT);
    double toDouble = Double.parseDouble(TO_DOUBLE);

    //конвертировать можно по средствам:
    Integer toInt2 = Integer.valueOf(TO_INT);
    Long toLong2 = Long.valueOf(TO_LONG);
    Float toFloat2 = Float.valueOf(TO_FLOAT);
    Double toDouble2 = Double.valueOf(TO_DOUBLE);
}
