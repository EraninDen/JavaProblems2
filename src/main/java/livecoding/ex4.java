package livecoding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ex4 {
    //int[?] firstArr
    //int[?] secondArr
    //найти медианное значение

    public static void main(String[] args) {
        int[] firstArr = new int[]{1, 5, 7};
        int[] secondArr = new int[]{1, 3, 7, 8};
        int[] thirdArr = new int[]{1, 2};
        int[] fourthArr = new int[]{3, 4};
        System.out.println(arrMedian(firstArr, secondArr));
        System.out.println(arrMedian(thirdArr, fourthArr));
        System.out.println();
        System.out.println(Arrays.toString(new double[]{getMedian(concatenateArray(firstArr, secondArr))}));
        System.out.println(Arrays.toString(new double[]{getMedian(concatenateArray(thirdArr, fourthArr))}));
        System.out.println(Arrays.toString(concatenateArray(firstArr, secondArr)));
        System.out.println(Arrays.toString(concatenateArray(thirdArr, fourthArr)));
        System.out.println();
        System.out.println(Arrays.toString(new double[]{arrMedian(firstArr, secondArr)}));
        System.out.println(Arrays.toString(new double[]{arrMedian(thirdArr, fourthArr)}));
    }

    public static double arrMedian(int[] firstArr, int[] secondArr) {
        int[] fullArr = IntStream.concat(Arrays.stream(firstArr), Arrays.stream(secondArr)).sorted().toArray();

        return fullArr.length % 2 == 0 ?
                ((fullArr[fullArr.length / 2] + fullArr[fullArr.length / 2 - 1]) / 2d) : fullArr[fullArr.length / 2];
    }

    public static int[] concatenateArray(int[] first, int[] second) {
        return IntStream.concat(Arrays.stream(first), Arrays.stream(second)).sorted().toArray();
    }

    public static double getMedian(int[] fullArr) {
        if (fullArr.length % 2 == 0) {
            return ((fullArr[fullArr.length / 2] + fullArr[fullArr.length / 2 - 1]) / 2d);
        }
        return fullArr[fullArr.length / 2];
    }
}
