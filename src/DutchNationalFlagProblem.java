/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/

public class Solution {
  
    public int[] sortColors(int[] A) {
        
		int start=0;
		int mid=0;
    int high=A.length-1;

		while(mid<=high){
         if(A[mid]==0){
			 int temp=A[start];
			 A[start]=A[mid];
			 A[mid]=temp;
			 mid++;
			 start++;
		 } else if(A[mid]==1){
             mid++;
		 }else{
			 int temp=A[high];
			 A[high]=A[mid];
			 A[mid]=temp;
			 high--;
		 }
		}
		return A;
}
}
