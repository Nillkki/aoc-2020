package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class DayTwo {

    public static void main(String[] args) throws IOException {
        String fileName = "day2/input.txt";

        Path filePath = Paths.get(fileName);

        AtomicInteger validPasswordsOne = new AtomicInteger(0);
        AtomicInteger validPasswordsTwo = new AtomicInteger(0);

        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach((line) -> {
                // min-max char: password
                String[] lineParts = line.split(" ");

                // System.out.println(Arrays.toString(lineParts));
                String password = lineParts[2];
                // System.out.println(password);
                String[] minMax = lineParts[0].split("-");
                // System.out.println(Arrays.toString(minMax));
                int min = Integer.parseInt(minMax[0]);
                int max = Integer.parseInt(minMax[1]);
                String chr = lineParts[1].substring(0, 1);
                // System.out.println(chr);
                int count = password.length() - password.replace(chr, "").length();
                // System.out.println(count);

                if (count >= min && count <= max) {
                    validPasswordsOne.incrementAndGet();
                }

                if ((password.substring(min - 1, min).equals(chr)
                        && !password.substring(max - 1, max).equals(chr))
                        || (!password.substring(min - 1, min).equals(chr)
                                && password.substring(max - 1, max).equals(chr))) {
                    System.out.println(Arrays.toString(lineParts));
                    System.out.println(password.substring(min - 1, min));
                    System.out.println(password.substring(max - 1, max));
                    validPasswordsTwo.incrementAndGet();
                }

            });

            System.out.println(validPasswordsOne.get());
            System.out.println(validPasswordsTwo.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
