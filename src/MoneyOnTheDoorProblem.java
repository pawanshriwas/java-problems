/*

There are 100 doors, all closed. In a nearby cage are 100 monkeys.

The first monkey is let out, and runs along the doors opening every one. The second monkey is then let out, and runs along the doors closing the 2nd, 4th, 6th,… - all the even-numbered doors. 
The third monkey is let out. He attends only to the 3rd, 6th, 9th,… doors (every third door, in other words), closing any that is open and opening any that is closed, and so on. 
After all 100 monkeys have done their work in this way, what state are the doors in after the last pass?


//Ans is only doorsequence which is perfect square will be opened at last 

*/


public class MoneyOnTheDoorProblem {

	public static void main(String[] args) {
        
         System.out.println(monkeyOnTheDoor(100)); // Ans is 10 for 100 door
         System.out.println(monkeyOnTheDoor(60)); // Ans is 7 for 60 door
}
 
 public static int monkeyOnTheDoor(int numberOfDoor){
		  int [] doorsArray = new int[numberOfDoor];
		 // int monkey=1;
		  
		  for(int monkey=1;monkey<=100;monkey++) {
			  System.out.println("Monkey Number-"+monkey);
			  int sequnace=1;
			  int doorStep=1;
		     while((doorStep = sequnace * monkey)<=numberOfDoor) {
		    	 if(doorsArray[doorStep-1]==0)
		    	 {
					  System.out.println("doorStep-"+doorStep+"Opened");
		    		 doorsArray[doorStep-1]=1; 
		    	 
		    	 }else {
					 System.out.println("doorStep-"+doorStep+"Closed");
		    		 doorsArray[doorStep-1]=0; 
		    	 }
			     sequnace++;
		     }
		  }
		  
		 int openDoorCount=0; 
	     for(int i=0;i<numberOfDoor;i++) {
	    	 if(doorsArray[i]==1) {
				  System.out.println("Door- "+(i+1)+" open");
				  openDoorCount++;
	    	 }
	     }
	     //Hence only door sequence which is perfect square will be opened at last 
	     return openDoorCount;
	}
}
