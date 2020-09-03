package leetcode;

/**
 * @author: huhao
 * @time: 2020/9/3 20:22
 * @desc: https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    /**
     * 快慢指针
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = division(n);
        while (slow != fast) {
            slow = division(slow);
            fast = division(division(fast));
        }

        return slow == 1;
    }

    private int division(int n) {
        int sumOfSquares = 0;
        while (n > 0) {
            sumOfSquares += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sumOfSquares;
    }

    public static void main(String[] args) {
        new HappyNumber().isHappy(18);
    }
}
