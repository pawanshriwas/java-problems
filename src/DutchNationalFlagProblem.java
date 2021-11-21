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
