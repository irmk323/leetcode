// O(nlgn)
class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrs = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);


        // sorting reverse order s1: "30" and s2: "3" , then  "330" or "303"
        Arrays.sort(numStrs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        // Arrays.sort(numStrs, new MyComparator());

        if(numStrs[0].equals("0")){
            return "0";
        }
        return String.join("" , numStrs);
    }
    // static class MyComparator implements Comparator<String>{
    //     @Override
    //     public int compare(String a, String b){
    //         String order1 = a+b;
    //         String order2 = b+a;
    //         return order2.compareTo(order1);
    //     }

    // }
}