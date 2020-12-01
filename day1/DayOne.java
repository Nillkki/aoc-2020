package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

class DayOne {

    public static Integer[] twoSum(Integer[] array, int sum) {
        Arrays.sort(array);

        int low = 0;
        int high = array.length - 1;

        while (array[high] > sum + array[0]) {
            high--;
        }

        while (low < high) {
            if (array[low] + array[high] == sum) {
                return new Integer[] {array[low], array[high]};
            } else if (array[low] + array[high] < sum) {
                low++;
            } else {
                high--;
            }
        }

        return new Integer[0];
    }

    public static Integer[] threeSum(Integer[] array, int sum) {
        Arrays.sort(array);

        for (int i = 0; i < array.length - 1; i++) {

            int start = i + 1;
            int end = array.length - 1;

            while (start < end) {
                if (array[i] + array[start] + array[end] == sum) {
                    return new Integer[] {array[i], array[start], array[end]};
                } else if (array[i] + array[start] + array[end] > sum) {
                    end = end - 1;
                } else {
                    start = start + 1;
                }
            }
        }

        return new Integer[0];
    }



    public static void main(String[] args) throws IOException {
        String fileName = "day1/input.txt";

        Path filePath = Paths.get(fileName);

        try (Stream<String> lines = Files.lines(filePath)) {

            Integer[] data = lines.map(Integer::valueOf).toArray(Integer[]::new);

            Integer[] twoSumResult = twoSum(data, 2020);

            System.out.println(Arrays.toString(twoSumResult));
            System.out.println(twoSumResult[0] * twoSumResult[1]);

            Integer[] threeSumResult = threeSum(data, 2020);

            System.out.println(Arrays.toString(threeSumResult));
            System.out.println(threeSumResult[0] * threeSumResult[1] * threeSumResult[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
