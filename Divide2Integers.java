/* 29. Divide Two Integers
Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT.
*/
public class Solution {
    public int divide(int dividend, int divisor) {
        // consider corner case
        if(divisor == 0)    return Integer.MAX_VALUE;
        if(divisor == -1 && dividend == Integer.MIN_VALUE)  return Integer.MAX_VALUE;
        // change both inputs to long to avoid overflow during calculation
        // get abstract value to avoid negative effect
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res = 0;
        // if a >= b means a still can be divide by b
        while(a >= b){
            int t = 0;
            // due to the large value, it is necessary to use digit count
            // t is to represent to how many digits need to be shift 
            while((a >> t) >= b){
                t++;
            }
            // change the global value for next loop
            res += 1 << (t-1);
            a -= (b<<(t-1));
        }
        //considering positive / negative
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
            return res;
        }else{
            return -res;
        }
    }
}