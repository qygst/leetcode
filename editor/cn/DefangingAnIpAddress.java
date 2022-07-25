//给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。 
//
// 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。 
//
// 
//
// 示例 1： 
//
// 输入：address = "1.1.1.1"
//输出："1[.]1[.]1[.]1"
// 
//
// 示例 2： 
//
// 输入：address = "255.100.50.0"
//输出："255[.]100[.]50[.]0"
// 
//
// 
//
// 提示： 
//
// 
// 给出的 address 是一个有效的 IPv4 地址 
// 
// Related Topics 字符串 👍 95 👎 0


package leetcode.editor.cn;

//Java：IP 地址无效化
public class DefangingAnIpAddress {
    public static void main(String[] args) {
        Solution solution = new DefangingAnIpAddress().new Solution();
        // TO TEST
        String address = "255.100.50.0";
        System.out.println(solution.defangIPaddr(address));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String defangIPaddr(String address) {
            StringBuilder stringBuilder = new StringBuilder();
            int index = -1, len = address.length();
            while (++index < len) {
                if (address.charAt(index) == '.') {
                    stringBuilder.append("[");
                    stringBuilder.append(address.charAt(index));
                    stringBuilder.append("]");
                } else {
                    stringBuilder.append(address.charAt(index));
                }
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}