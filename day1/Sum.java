package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

class Sum {

    public static Integer[] subsetSum(Integer[] array, int sum) {
        Arrays.sort(array);

        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (array[rightIndex] > sum + array[0])
        {
            rightIndex--;    
        }

        while (leftIndex < rightIndex)
        {
            if (array[leftIndex] + array[rightIndex] == sum)
            {
                return new Integer[]{array[leftIndex], array[rightIndex]};
            }
            else if(array[leftIndex] + array[rightIndex]  < sum)
            {
                leftIndex++;
            }
            else
            {
                rightIndex--;   
            }
        }

        return new Integer[0];
    }
    public static void main(String[] args) throws IOException {
        String fileName = "day1/input.txt";

        Path filePath = Paths.get(fileName);

        try (Stream<String> lines = Files.lines(filePath)) {

            Integer[] data = lines.map(Integer::valueOf).toArray(Integer[]::new);

            Integer[] result = subsetSum(data, 2020);

            System.out.println(result[0] * result[1]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
