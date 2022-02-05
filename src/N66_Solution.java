/**
 * @author 文进
 * @version 1.0
 * 66.加一
 */
public class N66_Solution {
    public int[] plusOne(int[] digits) {
        // 从数组的最低位开始加一
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            // 如果不进位，就直接返回，否则继续进位加一
            if (digits[i] <= 9) {
                break;
            }
            // 进位后，该位为0，也就是9 + 1 = 10
            digits[i] = 0;
        }

        // 如果最高位仍要进位，返回的数组长度为digits.length + 1
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            // 数组拷贝
            System.arraycopy(digits, 0, res, 1, digits.length);
//            for (int i = 0; i < digits.length; i++) {
//                res[i + 1] = digits[i];
//            }

            return res;
        }
        // 最高位不进位，就直接返回变化后的digits
        return digits;
    }
}
