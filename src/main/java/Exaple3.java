import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Требуется реализовать метод позволяющий найти автора с наибольшим количеством сказанных слов:
 * record -> "Andrew:somethind i can talk"
 * records -> {"Andrew:somethind i can talk", "Ben:me too", "Andrew:more and more"} -> Andrew
 */

public class Exaple3 {

    public static void main(String[] args) {

        List<String> records = new ArrayList<>();
        records.add("Роман: лучше не ссать, чем ссать");
        records.add("Роман: Когда туда, тогда откуда");
        records.add("Роман: не время гуся душить - холодно на улице");
        records.add("Паша: я не пью, я выпиваю");
        records.add("Паша: предоплата не возвращается");
        records.add("Паша: с бабами опять тусили");
        records.add("Паша: надо чего нибудь употребить");
        records.add("Паша: хорошее состояния");

        Exaple3 exaple3 = new Exaple3();
        System.out.println(exaple3.findTheMostTalkingAuthor(records));
    }


    // public List<String> findTheMostTalkingAuthor(List<String> records, Integer numToView) {
    public List<String> findTheMostTalkingAuthor(List<String> records) {
        Map<String, Long> map = new HashMap<>();
        Map.Entry<String, Long> maxEntry = null;

        for (String rec : records) {
            //обход массива строк
            String[] words = rec.split(": ");
            // разделение сроки на подстроки
            String key = words[0];
            //в первой подстроке берем ключ
            Long value = (long) words[1].split(" ").length;
            //во второй считаем пробелы- это значение
            if (map.containsKey(key)) {
                BiFunction<Long, Long, Long> biFunction = Long::sum;
                // функция для сложения значений по ключу
                map.merge(key, value, biFunction);
            } else {
                map.put(key, value);
            }
            //находим ключ с максимальным значением
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                }
            }
        }
        // возвращаем как коллекцию состоящую из одного значения
        return Collections.singletonList(maxEntry.getKey());
    }
}

