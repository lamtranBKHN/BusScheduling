package busScheduling;
import java.io.*;

public class BusScheduling extends Map {
	public static int[] A = new int[20];
	public static int[] Check = new int[A.length];
	public static int shortestDistance = Integer.MAX_VALUE;
	public static int[] route = new int[A.length];
	
	private void findBestRoute(int root, int numberOfNode) {
		for(int i = 1; i <= numberOfNode; i++) {
			if (Check[i] == 0) {
	            A[root] = i; 
	            Check[i] = 1;
	            if (root == numberOfNode) {
            	/*-----------------------------------------------------------------------------------------*/
	            	boolean buffer = true;
	            	int pickup = 0, dropoff = 0;
	            	
	            	for(int x = 1; x <= super.getN(); x++) {
	            		for(int y = 1; y <= numberOfNode; y++ ) {
	            			if(A[y] == x) pickup = y;
	            			if(A[y] == (x + super.getN())) dropoff = y;
	            		}
	            		if(pickup > dropoff) {
	            			buffer = false;
	            			break;
	            		}
	            	}
	            	
	            	if(buffer) {
	            		int numPassenger = 0;
	            		int[] isOnBus = new int[(super.getN() + 1)];
	            		for(int index = 1; index <= super.getN(); index ++) {
	            			isOnBus[index] = 0;
	            		}
	            		for(int x = 1; x <= numberOfNode; x++) {
	            			if(A[x] <= super.getN()) {
	            				numPassenger += 1;
	            				isOnBus[A[x]] = 1;
	            			}
	            			if(A[x] > super.getN()) {
	            				if(A[x] <= 2*super.getN()) {
	    	            			if(isOnBus[ (A[x] - super.getN()) ] == 1) {
	    	            				numPassenger -= 1;
	    	            				isOnBus[ (A[x] - super.getN()) ] = 0;
	    	            			}
	            				}
	            			}
	            			if(numPassenger > super.getK()) {
	            				buffer = false;
	            				break;
	            			}
	            		}
	            	}
	            	int distance = 0;
	            	if(buffer) {
	            		for(int j = 0; j <= numberOfNode; j++) {
	            			A[numberOfNode + 1] = 0;
	            			distance += super.findDistance(A[j], A[j+1]);
	            			
		            	}
		            	if(distance < shortestDistance) {
		            		shortestDistance = distance;
		            		for(int j = 0; j <= numberOfNode; j++) {
			            		//System.out.print(A[j] + " ");
			            		route[j] = A[j];
			            		route[numberOfNode + 1] = 0;
			            	}
		            		//System.out.println(A[numberOfNode + 1]);
		            		//System.out.println(distance);
		            	}
	            	}
	            /*-----------------------------------------------------------------------------------------*/
	            }
	            else findBestRoute(root + 1, numberOfNode);
	            Check[i] = 0;
	        }
		}
	}
	public void findBestRoute() {
		int numberOfNode = super.getNum();
		//int numberOfNode = super.getN()*2;
		do {
			findBestRoute(1, numberOfNode);
			numberOfNode -= 1;
		} while(super.getN()*2 <= numberOfNode);
	}
	
	public static void main(String[] args) throws IOException {
		for(int i = 1; i < 20; i++) {
			Check[i] = 0;
		}
		ReadingData readingData = new ReadingData();
		readingData.readFile();
		BusScheduling busScheduling = new BusScheduling();
		busScheduling.findBestRoute();
		System.out.println("Shortest distance is: " + shortestDistance);
		int i = 1;
		System.out.print("The shortest route is: 0");
		while(route[i] != 0) {
			System.out.print("->");
			System.out.print(route[i]);
			i++;
		} 
	}
	
}


      

