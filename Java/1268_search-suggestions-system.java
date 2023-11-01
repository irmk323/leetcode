class Solution {

    public int searchStartPosition(String prefix, List<String> sortedProducts){
        int left = 0, right = sortedProducts.size()-1;
        while(left <= right){
            int mid = (left + right)/2;
            // prefix is earlier
            // ["a" , "c", "e", "g", "h"] "f" 
            if(prefix.compareTo(sortedProducts.get(mid)) <= 0){
                right = mid -1;
            // prefix is later
            }else{
                left = mid +1;
            }
        }
        return left;
    }

    public void addWordsIntoRes(int basePosition, List<String> sortedProducts , List<List<String>> ans, String prefix){
        int n = sortedProducts.size();
        List<String> curList = new ArrayList<>();
        for(int i = basePosition; i < Math.min(basePosition+3, n );i++){
            if(sortedProducts.get(i).startsWith(prefix)){
                curList.add(sortedProducts.get(i));
            }
        }
        ans.add(curList);
    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> sortedProducts = new ArrayList<>(Arrays.asList(products));
        Collections.sort(sortedProducts);
        List<List<String>> ans = new ArrayList<>();
        String prefix = "";
        int basePosition = 0;
        for(char c : searchWord.toCharArray()){
            prefix +=c;
            basePosition = searchStartPosition(prefix , sortedProducts);
            addWordsIntoRes(basePosition, sortedProducts, ans, prefix);
        }
        return ans;
    }
}


// actually Trie was slower...
// Custom class Trie with function to get 3 words starting with given prefix
class Trie {

    // Node definition of a trie
    class Node {
        boolean isWord = false;
        List<Node> children = Arrays.asList(new Node[26]);
    };
    Node Root, curr;
    List<String> resultBuffer;

    // Runs a DFS on trie starting with given prefix and adds all the words in the resultBuffer, limiting result size to 3
    void dfsWithPrefix(Node curr, String word) {
        if (resultBuffer.size() == 3)
            return;
        if (curr.isWord)
            resultBuffer.add(word);

        // Run DFS on all possible paths.
        for (char c = 'a'; c <= 'z'; c++)
            if (curr.children.get(c - 'a') != null)
                dfsWithPrefix(curr.children.get(c - 'a'), word + c);
    }
    Trie() {
        Root = new Node();
    }

    // Inserts the string in trie.
    void insert(String s) {

        // Points curr to the root of trie.
        curr = Root;
        for (char c : s.toCharArray()) {
            if (curr.children.get(c - 'a') == null)
                curr.children.set(c - 'a', new Node());
            curr = curr.children.get(c - 'a');
        }

        // Mark this node as a completed word.
        curr.isWord = true;
    }
    List<String> getWordsStartingWith(String prefix) {
        curr = Root;
        resultBuffer = new ArrayList<String>();
        // Move curr to the end of prefix in its trie representation.
        for (char c : prefix.toCharArray()) {
            if (curr.children.get(c - 'a') == null)
                return resultBuffer;
            curr = curr.children.get(c - 'a');
        }
        dfsWithPrefix(curr, prefix);
        return resultBuffer;
    }
};


class Solution {
    List<List<String>> suggestedProducts(String[] products,
                                         String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        // Add all words to trie.
        for (String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }
};



// sort + binary search => nlog n + mlogn,


class Solution {
    // private List<String> sortProducts(String[] products){
    //     List<String> sortedProcut = new ArrayList<>(Arrays.asList(products));
    //     Collections.sort(sortedProcut);
    //     return sortedProcut;
    // }

    private int insertionIndexOf(List<String> products, String seachPrefix){
        int lo=0, hi = products.size() -1;
        while(lo <= hi){
            int mid= (lo+hi)/2;
            int comrparison = seachPrefix.compareTo(products.get(mid));
            if(comrparison <= 0){
                hi = mid-1;
            }else{
                lo= mid+1;
            }
        }
        return lo;
    }

    private List<String> findMatches(List<String> products, String searchPrefix){
        int iStart = insertionIndexOf(products,searchPrefix);
        int iEnd= Math.min(iStart+3, products.size());
        return products.subList(iStart, iEnd).stream()
        .takeWhile(product -> product.startsWith(searchPrefix))
        .collect(Collectors.toList());
        // List<String>  res=new ArrayList<>();
        // for(int i=iStart; i< iEnd; i++){
        //     String product = products.get(i);
        //     if(product.startsWith(searchPrefix)){
        //         res.add(product);
        //     }
        // }
        // return res;
    }
    public List<List<String>> suggestedProducts(String[] rawproducts, String searchWord) {
        List<String> products = Arrays.stream(rawproducts)
        .sorted()
        .collect(Collectors.toList());

        return IntStream.range(1, searchWord.length() +1).boxed()
        .map(i -> findMatches(products,searchWord.substring(0,i)))
        .collect(Collectors.toList());
        // List<String> products= sortProducts(rawproducts);
        // List<List<String>>res = new ArrayList<>();
        // for(int i= 1; i<= searchWord.length(); i++){
        //     String prefix= searchWord.substring(0,i);
        //     res.add(findMatches(products,prefix));
        // }
        // return res;
    }
}

