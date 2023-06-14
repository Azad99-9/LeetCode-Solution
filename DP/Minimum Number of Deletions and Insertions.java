import java.util.* ;
import java.io.*; 
public class Solution {
    public static int canYouMake(String s, String t) {
        int n = s.length();
		int m = t.length();
		// int[][] memoize = new int[n][m];
		// for (int i = 0; i < n; i++) Arrays.fill(memoize[i], -1);
		// return recur(s.toCharArray(), t.toCharArray(), n-1, m-1, memoize);

		int[][] table = new int[n+1][m+1];
		char[] sarr = s.toCharArray();
		char[] tarr = t.toCharArray();
		for (int i1 = 1; i1 <= n; i1++) {
			for (int i2 = 1; i2 <= m; i2++) {
				if (sarr[i1-1] == tarr[i2-1]) table[i1][i2] = 1 + table[i1-1][i2-1];
				else {
					table[i1][i2] = Math.max(table[i1-1][i2], table[i1][i2-1]);
				}
			}
		}
		return s.length() + t.length() - 2 * table[n][m];
    }

}