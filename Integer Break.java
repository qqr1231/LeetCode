public class Solution {
    public int integerBreak(int n) {
        int[] d = new int[n+1];
        d[0] = 2;
        int count = 2;
        for (int i = 1; i <= n; i++) {
            d[i] = d[i-1];
            if (maxProduct(i,d[i]) < maxProduct(i,d[i]+1)) {
                d[i]++;
            }
        }
        return maxProduct(n,d[n]);
    }
    public int maxProduct(int n, int t) {
        int product = 1;
        int k = n/t;
        int rest = n%t;
        for (int i = 1; i <= t; i++) {
            if (rest > 0) {
                rest--;
                product = product * (k+1);
                //System.out.println(k+1);
            }else {
                product = product * k;
                //System.out.println(k);
            }
        }
        return product;
    }
}