/*  91. Decode Ways
A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
The number of ways decoding "12" is 2.
*/
public class Solution {
    public int numDecodings(String s) {
        // check s is vaild input
        if (s == null || s.length() == 0 || s.charAt(0) == '0'){
            	return 0;
        }
        int[] res = new int[s.length()+1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= s.length(); i++){
            // use dp function to calculate total ways digit by digit 
            int t = Integer.valueOf(s.substring(i-1,i));
            if(t != 0){
                res[i] = res[i-1];
            }
            // if '0' continue appear twice which means input is illegal, return 0
            // if two digit string value between 1 and 26, it means it could have different arrangement
            if(s.charAt(i-2) != '0'){
                t = Integer.valueOf(s.substring(i-2,i));
                if(t >= 1 && t <= 26){
                    res[i] += res[i-2];
                }
            }
        }
        return res[s.length()];
    }
}