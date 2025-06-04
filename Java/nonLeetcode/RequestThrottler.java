package nonLeetcode;

import java.util.*;

public class RequestThrottler {

    public static List<Integer> getRejectedRequests(List<String> requests, int limitPerSecond) {

        Map<String, Deque<Integer>> map = new HashMap<>();
        List<Integer> rejectedRequests = new ArrayList<>();

        for (String request : requests) {
            String[] split = request.split(" ");
            String key = split[1];
            if (!map.containsKey(key)) {
                Deque<Integer> deque = new ArrayDeque<>();
                deque.add(Integer.valueOf(split[2]));
                map.put(key, deque);
            }else{
                int  threshold = Integer.parseInt(split[2]) - 1000;
                boolean canAcceptRequest  =  canAcceptRequest(threshold,  map.get(key), limitPerSecond);
                if (canAcceptRequest){
                    map.get(key).addLast(Integer.valueOf(split[2]));
                }else {
                    rejectedRequests.add(Integer.valueOf(split[0]));
                }
            }
        }
        return rejectedRequests;
    }

    private static boolean canAcceptRequest(int threshold, Deque<Integer> deque, int limitPerSecond) {
        while (!deque.isEmpty() && deque.peek() <= threshold) {
            deque.removeFirst();
        }
        return deque.size() < limitPerSecond;
    }

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        List<String> test1 = Arrays.asList(
                "1 172.253.115.138 50000",
                "2 172.253.115.139 50100",
                "3 172.253.115.138 50210", //
                "4 172.253.115.139 50300", //
                "5 172.253.115.138 51000",
                "6 172.253.115.139 60300"
        );

        int limit1 = 1;
        List<Integer> expected1 = Arrays.asList(3, 4);
        runTestCase(1, test1, limit1, expected1);

        List<String> test2 = Arrays.asList(
                "1 192.168.1.1 1000",
                "2 192.168.1.1 1500",
                "3 192.168.1.1 2000"
        );
        int limit2 = 1;
        List<Integer> expected2 = Arrays.asList(2);
        runTestCase(2, test2, limit2, expected2);

        List<String> test3 = Arrays.asList(
                "1 10.0.0.1 1000",
                "2 10.0.0.2 1000",
                "3 10.0.0.1 2000",
                "4 10.0.0.2 2000"
        );
        int limit3 = 2;
        List<Integer> expected3 = Collections.emptyList();
        runTestCase(3, test3, limit3, expected3);
    }

    private static void runTestCase(int testCaseNumber, List<String> requests, int limit, List<Integer> expected) {
        List<Integer> result = getRejectedRequests(requests, limit);
        System.out.println("Test Case " + testCaseNumber + ": " + (result.equals(expected) ? "Passed" : "Failed"));
        System.out.println("Expected: " + expected);
        System.out.println("Got     : " + result);
        System.out.println();
    }
}

