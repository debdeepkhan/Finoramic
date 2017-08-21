public class Solution {
	public long pow(int x, int n, int d) {
	    if (x == 0) {
	        return x;
	    }
	    if (n == 0){
	        return 1;
	    }
	    if (n == 1 ){
	        if ( x < 0){
	            return (x + d) % d ;
	            
	        } else {
	            return x % d ;
	        }
	    }
	       long result = 1;
        long power = x;
        while (n != 0) { 
            if (n % 2 != 0) {
                result = result * power;
            }
            power = (power * power) % d;
            n = n / 2;
            if (result > d) {
                result = result % d;
            }
        }
        return result;
	}
}