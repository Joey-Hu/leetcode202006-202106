package leetcode.math;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/12/3 10:36
 * @desc: https://leetcode.com/problems/perfect-squares/
 */
public class M279_PerfectSquares {

    /**
     * dp
     *
     dp[0] = 0
     dp[1] = dp[0]+1 = 1
     dp[2] = dp[1]+1 = 2
     dp[3] = dp[2]+1 = 3
     dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
     = Min{ dp[3]+1, dp[0]+1 }
     = 1
     dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
     = Min{ dp[4]+1, dp[1]+1 }
     = 2
     .
     .
     .
     dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
     = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
     = 2
     .
     .
     .
     dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n ; i++) {
            int j = 1;
            int min = Integer.MAX_VALUE;
            while (i - j*j >=0) {
                min = Math.min(dp[i-j*j]+1, min);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
