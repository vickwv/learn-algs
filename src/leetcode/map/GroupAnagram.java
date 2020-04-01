package leetcode.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    /**
     * 主要思路：拿一个key:List的哈希表，遍历数组，每个value排序，排序后相等的value放在一个key中。（如aet: eat, tae）
     * @param strs
     * @return
     */
    public List<List<String>> Solution1(String[] strs) {
        if (strs.length == 0) {
            return null;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String keyStr = String.valueOf(arr);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }


    /**
     * 主要思路：拿一个key:List的哈希表，遍历数组，计算每个value字符出现的次数，计算次数相等的value放在一个key中。（如aet: eat, tae）
     * @param strs
     * @return
     */
    public List<List<String>> Solution2(String[] strs) {
        if (strs.length == 0) {
            return null;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] counter = new char[26];
            // 计算字符串中字符出现的次数
            for (char c : str.toCharArray()) {
                counter[c - 'a']++;
            }
            // 生成key
            String keyStr = String.valueOf(counter);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
