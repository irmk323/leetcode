public class Shipping {

    public static void main(String[] args) {
        System.out.println("here");
        System.out.println(minimalNumberOfPackages(16, 2, 10)); // 出力: 3
    }

    private static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
        int totalBoxNum = 0;

        int largeBoxUsage = Math.min(availableLargePackages, items / 5);
        totalBoxNum += largeBoxUsage;
        items -= (largeBoxUsage * 5);

        int smallBoxUsage = Math.min(availableSmallPackages, items);
        totalBoxNum += smallBoxUsage;
        items -= smallBoxUsage;

        if (items > 0) {
            return -1;
        }
        return totalBoxNum;
    }
}


