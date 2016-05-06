public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k > n) return res;
        List<Integer> tep = new ArrayList<Integer>();
        helper(res, tep, n, k, 1);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> tep, int n, int k, int t) {
        if (tep.size() == k) {
            res.add(new ArrayList<Integer>(tep));
            // System.out.println(res);
            // System.out.println("add: " + tep);
            return;
        }
        for (int i = t; i <= n; i++) {
            tep.add(i);
            //System.out.println("tep: " + tep);
            helper(res,tep,n,k,i+1);
            tep.remove(tep.size()-1);
        }
    }
}