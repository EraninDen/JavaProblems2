package leetcode.easyProblems;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {


    public static void main(String[] args) {
        String s = "25525511135";
        int group = 4;
        int groupCapacity;
        int length = s.length();
        int groupLength = length / group;
        int[] intToStringArray;
        System.out.println(restoreIpAddresses(s));


    }

//    public List<String> restoreIpAddresses(String s) {
//
//        int length = s.length();
//        if (length < 4 && length > 12) {
//            String str = "not solution - input failed";
//            return Collections.singletonList(str);
//        }
//        s.split()
//    }
    /*
    Действительный IP-адрес состоит ровно из четырех целых чисел, разделенных одиночными точками.
    Каждое целое число находится между 0и 255( включительно ) и не может иметь ведущих нулей.

Например, "0.1.2.201"и "192.168.1.1"являются допустимыми IP-адресами,
но "0.011.255.245", "192.168.1.312"и "192.168.1.1"являются недопустимыми IP-адресами.
Учитывая строку s, содержащую только цифры, вернуть все возможные действительные IP-адреса,
которые могут быть образованы путем вставки точек вs . Вы не можете изменить порядок или удалить какие-либо цифры в s.
Вы можете вернуть действительные IP-адреса в любом порядке.

Пример 1:
Ввод: s = "25525511135"
 Вывод: ["255.255.11.135","255.255.111.35"]
Пример 2:
Ввод: s = "0000"
 Вывод: ["0.0.0.0"]
Пример 3:
Ввод: s = "101023"
 Вывод: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

Ограничения:
1 <= s.length <= 20
s состоит только из цифр.
     */


    // ideas:
// A valid ip address would have 4 parts separated by dots
// we iterate through `s` to insert 3 dots and separate the string into 4 segments
// for each segment, we check if it is valid
// if all 4 segments are valid, we combine those 4 segments with dots and push to the answer

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        // iterate `s` - place 3 dots to have 4 segments
        // [seg1].[seg2].[seg3].[seg4]
        // 1st dot - we just need to run it 3 times at most
        // e.g. for 255, we can place the first dot at `2.55`, `25.5` or `255.`
        for (int i = 1; i < 4 && i < n; i++) {
            // we place the 2nd dot in a similar way
            for (int j = i + 1; j < i + 4 && j < n; j++) {
                // we place the 3rd dot in a similar way
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    // now we can separate into 4 segments
                    String seg1 = s.substring(0, i),
                            seg2 = s.substring(i, j),
                            seg3 = s.substring(j, k),
                            seg4 = s.substring(k);
                    // for each segment, check if it is valid
                    if (ok(seg1) && ok(seg2) && ok(seg3) && ok(seg4)) {
                        // if so, we build the ip address and push to answer
                        ans.add(seg1 + "." + seg2 + "." + seg3 + "." + seg4);
                    }
                }
            }
        }
        return ans;
    }

    // check if a given IP address segment is valid
    // 192 -> true
    // 312 -> false
    private static boolean ok(String s) {
        // string length > 3 is not a valid IP address segment
        if (s.length() > 3 ||
                // empty segment is not valid
                s.length() == 0 ||
                // if the first character is 0, we cannot have something like 0x, 0xx
                (s.charAt(0) == '0' && s.length() > 1) ||
                // segment is out of range
                Integer.parseInt(s) > 255
        ) {
            return false;
        }
        return true;
    }

    public static List<String> restoreIPAddressesVer2(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < 4 && i < n; i++) {
            for (int j = i + 1; j < i + 4 && j < n; j++) {
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    String seg1 = s.substring(0, i),
                            seg2 = s.substring(i, j),
                            seg3 = s.substring(j, k),
                            seg4 = s.substring(k);
                    if (ok2(seg1) && ok2(seg2) && ok2(seg3) && ok2(seg4)) {
                        ans.add(seg1 + "." + seg2 + "." + seg3 + "." + seg4);
                    }
                }
            }
        }
        return ans;
    }

    private static boolean ok2(String s) {
        return s.length() <= 3 &&
                s.length() != 0 &&
                (s.charAt(0) != 0 || s.length() <= 1) &&
                Integer.parseInt(s) <= 255;
    }

}



