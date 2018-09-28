package First;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class W0756PyramidTransitionMatrix {
	private Map<String, List<String>> map = new HashMap<>();
	
	public boolean pyramidTransition(String bottom, List<String> allowed) {
        init(allowed);
        return helper(bottom, map);
    }
	
	private void init(List<String> allowed) {
		for (String s : allowed) {
			String key = s.substring(0, 2);
			String value = s.substring(2);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(value);
		}
	}
	
	private boolean helper(String bottom, Map<String, List<String>> map) {
		if (bottom.length() == 1)
			return true;
		for (int i = 0; i < bottom.length() - 1; i++) {
			if (!map.containsKey(bottom.substring(i, i + 2)))
				return false;
		}
		List<String> nextBottomList = new ArrayList<>();
		generateNextBottomList(bottom, 0, new StringBuilder(), nextBottomList, map);
		
		for (String nextBottom : nextBottomList) {
			if (helper(nextBottom, map))
				return true;
		}
		return false;
	}
	
	private void generateNextBottomList(String bottom, int idx, StringBuilder nextBottom, List<String> nextBottomList, Map<String, List<String>> map) {
		if (idx == bottom.length() - 1) {
			nextBottomList.add(nextBottom.toString());
			return;
		}
		
		for (String s : map.get(bottom.substring(idx, idx + 2))) {
			nextBottom.append(s);
			generateNextBottomList(bottom, idx + 1, nextBottom, nextBottomList, map);
			nextBottom.deleteCharAt(nextBottom.length() - 1);
		}
	}
}