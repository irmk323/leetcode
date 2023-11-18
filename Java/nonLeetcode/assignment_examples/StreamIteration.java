import java.util.stream.Stream;

public class StreamIteration{

    public static void main(String[] args) {
        Stream.iterate(
            new int[]{0, 1},
            x -> new int[]{x[1], x[0] + x[1]})
            .limit(8)
            // .forEach(arr -> System.out.println("(" + arr[0] + ", " + arr[1] + ")"));
            .map(x -> x[0])
            .distinct()
            .filter(element -> element % 2 == 0)
            .forEach(firstElement -> System.out.print("" + firstElement + ", "));
            // .mapToInt(x -> x)
            // .sum();

        // System.out.println("sum: " + sum);
    }
}
