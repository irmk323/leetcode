class Solution {
public List<String> letterCombinations(String digits) {
	//要素の取得・削除が頻繁にあり得るためLinkedList
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
            //getNumericValue数字を意味するchar型をそのままの見た目の数値に変換したい場合
			int x = Character.getNumericValue(digits.charAt(i));
            //peekは最初の要素を取得して、削除なし、removeは削除あり、
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
}
