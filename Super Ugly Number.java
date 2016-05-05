public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes == null || primes.length == 0)   return n;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        Arrays.sort(primes);
        int[] index = new int[primes.length];
        while (list.size() < n) {
            int min = Integer.MAX_VALUE;
            int t = 0;
            for (int i = 0; i < primes.length; i++) {
                if (primes[i] * list.get(index[i]) < min) {
                    min = primes[i] * list.get(index[i]);
                    t = i;
                }
            }
            if (min != list.get(list.size()-1)) {
                list.add(min);
            }
            index[t]++;
        }
        //System.out.print(list);
        return list.get(n-1);
    }
}