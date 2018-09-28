package First;

import java.util.Set;
import java.util.HashSet;

public class W0003LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
    	if (s == null || s.length() == 0)
    		return 0;
    	
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        
        int startIdx = 0;
        int endIdx = 1;
        
        int res = 1;
        
        while(startIdx < s.length() && endIdx < s.length()) {
        	char endC = s.charAt(endIdx);
        	if (!set.contains(endC)) {
        		endIdx++;
        		set.add(endC);
        		res = Math.max(res, endIdx - startIdx);
        	}
        	else {
        		while (s.charAt(startIdx) != endC) {
        			set.remove(s.charAt(startIdx));
        			startIdx++;
        		}
        		startIdx++;
        		endIdx++;
        	}
        }    
        return res;        
    }
    
    public static void main(String[] args) {
    	W0003LongestSubstringWithoutRepeatingCharacters e = new W0003LongestSubstringWithoutRepeatingCharacters();
    	System.out.println(e.lengthOfLongestSubstring("pwwkew"));
    }
}