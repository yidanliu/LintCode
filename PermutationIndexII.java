import java.util.HashMap;
import java.util.Map;

public class PermutationIndexII {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        // Write your code here
    	Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
    	
    	long res = 1, nom = 1, denom = 1;
    	for (int i = A.length-1; i >= 0; i--) {
    		freq.put(A[i], freq.containsKey(A[i]) ? freq.get(A[i])+1 : 1);
    		denom *= freq.get(A[i]);
    		int count = 0;
    		for (int j = i+1; j < A.length; j++) {
    			if (A[i] > A[j]) {
    				count++;
    			}
    		}
    		res += count * nom / denom;
    		nom *= A.length-i;
    	}
    	System.out.println(res);
		return res;
    }
    
}