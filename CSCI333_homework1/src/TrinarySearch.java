import java.util.Scanner;

public class TrinarySearch {
	
	public static void main(String[] args) {
		int arr1[] = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int arr2[] = new int[] {1,3,4,6,8,9,11,12,16,17,18,19,20,22,23,24,25,26,27,30};
		int arr3[] = new int[] {1,4,4,4,5,6,7,8,10,11}; 
		int arr4[] = new int[] {};
		int arr5[] = new int[] {};
		TrinarySearch ts = new TrinarySearch();
		int answer = 0;
		Scanner Obj = new Scanner(System.in);
		//test 1
		for(int i = 1; i < 6; i++) {
			answer = ts.trinarySearch(arr1, 11, 0, arr1.length-1);
			System.out.println("Test 1");
			//int temp = arri;
			if(answer != -1) {
				//System.out.println("You are looking for the number" + ("arr"+i)[answer] + " and it is located at index " + answer + "");
			}else {
				
			}
			System.out.println("");
		}	//System.out.println("the number you are looking for it number " + arr1[answer] + " and it is located at index " + answer + "");
	}
	
	
	public int trinarySearch(int[] arr, int findNum, int start, int end) {
		int arrLength = end - start;
		//checks if the length of the array divided by 3 has a remainder
		int comp = arrLength%3; 
		//System.out.println("" + start + " " + end + "");
		int index1 = 0;
		int index2 = 0;
		int answer = 0;
		//gets 2 array indexes
		if(comp  == 2) {
			//if the array has a remainder of 2 it makes the second and third group 1 longer than the first
			index1 = start + arrLength/3;
			index2 = start + ((arrLength/3)*2)+1;
		}else{
			//if it has 1 or 0 remainder both indexes will be in the same place
			// if it has a remainder of 1 the last group will be one item longer
			index1 = start + arrLength/3;
			index2 = start + ((arrLength/3)*2);
		}
		//System.out.println("the first index is " + index1 + " The second index is " + index2 + "");
		//System.out.println("" + index1 + " " + index2 + "");
		
		// if the length of the more specific array is more than 2 items
		if(arrLength > 2){
			//checks if the number is greater than or equal to index 2
			if(findNum >= arr[index2]) {
				//checks to see if the number is equal to the item that come before index 2 in the array
				if(findNum == arr[index2 -1]) {
					//if so it recurses group 2
					answer = trinarySearch(arr, findNum, index1, (index2-1));
				}else {
					//else it recurses group 3
					answer = trinarySearch(arr, findNum, index2, (end));
					//System.out.println("" + index2 + " " + end + "");
				}
			//check to see if the number is equal to or greater than index 1 and less than index 2
			}else if(findNum >= arr[index1]) {
				//check to see if the number equals the item before index 1 in the array
				if(findNum == arr[index1-1]) {
					//if so it recurse group 1
					answer = trinarySearch(arr, findNum, start, (index1-1));
				}else {
					//it recurses group 2
					answer = trinarySearch(arr, findNum, index1, (index2-1));
				}
			//else it recurses group 1
			}else{
				answer = trinarySearch(arr, findNum, start, (index1-1));
			}
		}else if(arrLength <3){
			int tempIndex = -1;
			//System.out.println("" + end + " " + start + "");
			for(int i = end; i > start-1 ; i--) {
				if(arr[i] == findNum) {
					tempIndex = i;
				}
			}
			
			answer = tempIndex;
			//System.out.println("" + answer + "");
		}
		//System.out.println("" + answer + "");
		
		return answer;
		
		
	}
	
}