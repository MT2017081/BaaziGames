public class Baazi {
	
	
	
	int balancedSum(int[] arr) {
		int leftsum = 0;
		int rightsum = 0;
		int i = 0;
		int j = arr.length -1;
		
		while (i<j) {
			leftsum += arr[i];
			rightsum += arr[j];
			
			while(leftsum < rightsum && i < j) {
				i++;
				leftsum += arr[i];
			}
			while(rightsum < leftsum && i < j) {
				j--;
				rightsum += arr[j];
			}
			i++;
			j--;
		}
		if (leftsum == rightsum && i == j) {
			return i;
			
		}
		else {
			return -1;
		}
		
	}
	
	
	

}

