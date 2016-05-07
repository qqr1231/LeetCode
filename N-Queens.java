public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int[] num = new int[n];
        helper(res, num, n, 0);
        return res;
    }
    public void helper(List<List<String>> res, int[] num, int n, int start) {
        if (start == n) {
            List<String> list = new LinkedList<String>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == num[i]) {
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
        }else {
            for (int j = 0; j < n; j++) {
                num[start] = j;
                if (isValid(num, start)) {
                    helper(res, num, n, start+1);
                }
            }
        
        }
        
    }
    public boolean isValid(int[] num, int x) {
        for (int i = 0; i < x; i++) {
            if (num[i] == num[x] || Math.abs(x-i) == Math.abs(num[x]-num[i])) {
                return false;
            }
        }
        return true;
    }
}