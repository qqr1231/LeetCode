public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length == 0 || candidates == null)   return res;
        List<Integer> tep = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        helper(res, tep, candidates, target, 0);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> tep, int[] candidates, int target, int index) {
        if (target == 0) {
            Collections.sort(tep);
            
            if (!res.contains(tep)){
                res.add(new ArrayList<Integer>(tep));
            }
            
            return;
        }
        if (target < 0 || index >= candidates.length) return;
        
        for (int i = index; i < candidates.length; i++) {
            
            tep.add(candidates[i]);
            int t = target - candidates[i];
            helper(res,tep,candidates,t,i+1);
            tep.remove(tep.size()-1);
        }
    }
}