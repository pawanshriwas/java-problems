import java.util.Arrays;

public class PrintAllSubsets {
  
   public static void main(String[] args) {		
		int[] A=new int[] {1, 2, 3, 4, 5};
		generateSubsets(A);
	}
  
  
  /* Method will print all subsets in a given array*/
  static void generateSubsets(int[] A) {
//		for(int i=0;i<Math.pow(2, A.length);i++) { // Math.pow(2, A.length) or we can write 1<<A.length
			for(int i=0;i<(1<<A.length);i++) { 
			 for(int j=0;j<A.length;j++) {
				 if(checkBit(i,j)) {
					 System.out.print(A[j]+" ");
				 }
			 }
			 System.out.println();
		}
	}
  
   static boolean checkBit(int A, int bitPosition) {
		 return ((A>>bitPosition)&1)==1?true:false;
	 }
}
