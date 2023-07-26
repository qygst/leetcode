//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
//
// Related Topics 队列 哈希表 字符串 计数 👍 610 👎 0


package leetcode.editor.cn;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

//Java：字符串中的第一个唯一字符
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            if (s == null || s.isEmpty()) return -1;

            HashMap<Character, Integer> hashMap = new HashMap<>();

            int index = -1;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (hashMap.containsKey(ch)) hashMap.put(ch, hashMap.get(ch) + 1);
                else hashMap.put(ch, 1);
            }

            for (int i = 0; i < s.length(); i++) {
                if (hashMap.get(s.charAt(i)) == 1) return i;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}