import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.next();
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, strs[i].length());
        }
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (strs[j].charAt(i) != ' ') {
                    sb.append(strs[j].charAt(i));
                }
            }
            array.add(Integer.parseInt(sb.toString()));
        }
        int[] ans = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            ans[i] = array.get(i);
        }
        Arrays.sort(ans);
        StringBuilder ansStr = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            ansStr.append(ans[i]);
            ansStr.append(" ");
        }
        System.out.println(ansStr);
    }
}
