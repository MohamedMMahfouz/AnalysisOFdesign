import java.util.Scanner;

public class Assignment2 {
	
	public static void standsOut(int[] arr , int low, int hi){ //where hi is N initially and low is intitally 0
		
		if((hi-low)==1 ){
			if(arr[hi]>arr[low]){
			System.out.println("the Stand out pixel is: "+ hi);
			}else{
				System.out.println("the Stand out pixel is in index: "+low);
			}
			return;
				
		}
		int mid= (hi+low)/2;
		if(arr[mid] >= arr[mid-1] && arr[mid]>= arr[mid+1]){
			System.out.println("the Stand out pixel is in index: "+  mid);
			return;
		}
		if(arr[mid] < arr[mid-1]){
				standsOut(arr,low, mid-1);
			}else{
				standsOut(arr,mid+1, hi);
			}
		
	}
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		//System.out.println("No. of test cases:"+"\n");
		int T=sc.nextInt();
		for(int i=0; i<T ; i++){
			//System.err.println("No. of elements in array :"+"\n");
			int N= sc.nextInt();
			int[] arr= new int[N];
			for (int j=0; j<N ; j++){
				arr[j]= sc.nextInt();
			}
			standsOut(arr, 0, N-1);
		}
		sc.close();
	}
	
}

/*
 Proof of correctness: 
 the algorithm runs in O(log n) as every time we cut the array into half (n/2) as the binary search algorithm does.

	proof of complexity:
	When we recurse, we reduce size n array into size n/2 in O(1).
 	 recurrence equation:
	
	T(n) = T(n/2)+c
	T(n) = T(n/4)+c+c        by subst.
	T(n) = T(n/8)+c+c+c
	T(n) = T(n/2^k) + c.k
	Substitute k = log2 n 
	T(n) = T(n/(2^(log2 n)))+c.log2 n 
	= T(1)+c.log2 n 
	= O(log n) 
	
	
	
 	proof of correctness: 
 	the algorithm picks them middle element, assume we have the numbers plotted on a graph, so we either have rising graph where
 	middle is bigger than the left element but smaller than the right element, in this case we know the peak is on the right side of the graph ( array)
 	or we have a falling graph, middle smaller than the left but bigger than the right element, so we know our peak of the graph is on the right side. 
 	in case the middle is smaller than both, then we have 2 peaks on the right and left side and it doesn't matter which side of the array to continue the operation
*/