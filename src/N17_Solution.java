import java.util.ArrayList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 17.电话号码的字母组合
 */
public class N17_Solution {
    List<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder();
    String[] digitTable = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        backtrack(digits, 0);
        return res;
    }

    /*
    回溯算法
    */
    void backtrack(String digits, int start) {
        if (track.length() == digits.length()) {
            res.add(track.toString());
            return;
        }

        for (int i = start; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            for (char c : digitTable[digit].toCharArray()) {
                track.append(c);
                backtrack(digits, i + 1);
                track.deleteCharAt(track.length() - 1);
            }
        }
    }
}
