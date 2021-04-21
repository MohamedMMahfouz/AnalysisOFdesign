import java.lang.Object;
import java.util.Scanner;
public class Assignment3 {
	
	
	public static void FindElement(Object arr[]){
		int index = 0;
		int count = 1;
		for (int i = 1; i < arr.length; i++) { // N-1 times
			if (arr[index].equals(arr[i])){
				count++;
			}else{
				count--;
			}
			if(count==0){
				index=i;
				count=1;
			}
			
			
		}
		count=0;
		for (int i = 0; i < arr.length; i++) { // N times
			if(arr[index].equals(arr[i]))
				count++;
		}
		int x = (arr.length)/2 ;
		if(count > x){
			System.out.println(arr[index].toString());
		}else{
			System.err.println("No element appears more than N/2 times");
		}
	}
	public static void main(String[] args) {
		Object a[] = {"a","a","s","d","a","a","4"};
		FindElement(a);
		
		Scanner sc= new Scanner(System.in);
		//System.out.println("No. of test cases:"+"\n");
		int T=sc.nextInt();
		for(int i=0; i<T ; i++){
			//System.err.println("No. of elements in array :"+"\n");
			int N= sc.nextInt();
			Object[] arr= new Object[N];
			for (int j=0; j<N ; j++){
				arr[j]= sc.next();
			}
			FindElement(arr);
		}
		sc.close();
		
	}
}


/* using moore's vote algorithm
 * 
 * 
 * the algorithm find the element that is most likely to be repeated more than n/2 times,
 * which is either only one element in the array or there is no element. 
 * we find this element by cancelling each occurrence of an element with the other elements occurrences so that only the first element is left,
 * EX. assume a group of girls, and a group of boys bigger that the girls, if we pair a boy with a girl, then some boys will remain un-paired,
 * so if there is an element repeated more than n/2 it's either the boys or none.
 * so after choosing the element, we make sure it's repeated more than N/2 times by counting the number of it's occurrences 
 * 
 * 
 * */
