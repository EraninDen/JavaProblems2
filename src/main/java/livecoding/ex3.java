package livecoding;

public class ex3 {


    public static void main(String[] args) {

        String a = "string a";
        String b = new String("string a");
        String c = b.intern();

        System.out.println(a == b);//ссылки разные false
        System.out.println(c == b);//ссылки разные false
        System.out.println(a == c);//true
        /*
        Что делает метод intern ()?
        InternМетод использует пул интернирования для поиска строки, равной значению str .
        Если такая строка существует, возвращается ее ссылка в пуле интернирования.
        Если строка не существует, в str пул интернирования добавляется ссылка на, а затем возвращается ссылка.
        */
    }
}
