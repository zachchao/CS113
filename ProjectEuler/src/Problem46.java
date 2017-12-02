import java.util.ArrayList;

public class Problem46 {
	public static void main(String[] args){
		boolean[] sieve = sieveOfE(121);
		print(sieve[7]);
		print(sieve[120]);
		
		
	}
	
	/**
	 * Returns array of odd composites up until n
	 * @param n
	 * @return
	 */
	public static int[] oddComposites(int n){
		boolean[] sieve = sieveOfE(n);
		ArrayList<Integer> oddComposites = new ArrayList<Integer>();
	}
	
	public static void print(Object o){
		System.out.println(String.valueOf(o));
	}
	
	/**
	 * Returns an array, if index is composite returns true if prime, false
	 * @param n The max number + 1
	 * @return
	 */
	public static boolean[] sieveOfE(int n){
		boolean[] sieve = new boolean[n];
		for(int i = 2; i < Math.pow(n, .5); i++){
			if(sieve[i] == false){
				for(int j = i*2; j<= n; j+=i){
					sieve[j] = true;
				}
			}
		}
		return sieve;
	}
}
