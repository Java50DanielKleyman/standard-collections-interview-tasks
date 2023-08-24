package telran.interviews;

import java.util.PriorityQueue;

public class ShootingRating {

	public static int rateShooting(int[] hittingResults) {
		int resIndex = hittingResults.length - (int) (hittingResults.length * 0.7);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int e : hittingResults) {
			pq.add(e);
		}
		Integer[] resArray = new Integer [hittingResults.length];
		for(int i = 0; i < resArray.length; i++) {
			resArray[i] = pq.poll();
		}		
		return resArray[resIndex];
	}

	public static void main(String[] args) {
		int[] hittingResults = { 4, 3, 6, 7, 2, 9, 9, 4, 10, 8 };		
		if (rateShooting(hittingResults) != 4) {
			System.out.println("Test failed");
			return;
		}
		System.out.println("Success");
	}
}