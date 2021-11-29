package question_1_500;

/**
 * @author 文进
 * @version 1.0
 * 278.第一个错误版本
 */
public class N278_FirstBadVersion {

}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}
