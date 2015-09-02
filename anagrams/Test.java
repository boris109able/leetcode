package anagrams;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		String[] strs = new String[3];
		strs[0] = "abfba";
		strs[1] = "fjdlsanbdsd";
		strs[2] = "dffd";
		Solution sol = new Solution();
		List<String> result = sol.anagrams(strs);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}		
	}
}
