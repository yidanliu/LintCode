public class PermutationIndex {
	public long permutationIndex(int[] A) {
		int[] larger = new int[A.length];
		for (int i = A.length-1; i >= 0; i--) {
			if (i == A.length-1) {
				larger[i] = 0;
			} else {
				
					int index = larger.length-1, num = 0;
					while (index > i) {
						if (A[index] > A[i]) {
						    num++;
						}
						index--;
					}
					System.out.println(index + "," + num);

					larger[i] = num;
				
			}
			
		}
		
		long num = 0;
		long fact = fac(larger.length);
		long factorial = fact / larger.length;
		for (int i = 0; i < larger.length-1; i++) {
			num += larger[i] * factorial;
			factorial /= larger.length-i-1;
		}
		return fact-num;
	}
	
	private long fac(int n) {
		long res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
}