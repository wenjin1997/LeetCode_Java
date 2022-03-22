import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 49.字母异位词分组
 */
public class N49_Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 编码到分组的映射
        HashMap<String, List<String>> codeToGroup = new HashMap<>();
        for (String s : strs) {
            // 对字符串进行编码
            String code = encode(s);
            // 把编码相同的字符串放在一起
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(s);
        }

        // 获取结果
        List<List<String>> res = new LinkedList<>();
        for (List<String> group : codeToGroup.values()) {
            res.add(group);
        }

        return res;
    }

    // 利用每个字符的出现次数进行编码
    String encode(String s) {
        char[] code = new char[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            code[delta]++;
        }
        return new String(code);
    }
}

