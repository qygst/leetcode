//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1842 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

//Java：字母异位词分组
public class GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        // TO TEST
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = solution.groupAnagrams(strs);
        System.out.println(res.toString());
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String key = String.valueOf(word);
            List<String> sameWord = map.getOrDefault(key, new ArrayList<>());

            sameWord.add(strs[i]);
            map.put(key, sameWord);
        }
        return map.values().stream().collect(Collectors.toList());

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}