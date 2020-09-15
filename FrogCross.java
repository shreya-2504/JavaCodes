package ProblemStatement;

import java.util.HashSet;
import java.util.Stack;

public class FrogCross {

	public static void main(String[] args) {
		int arr[]= {0,1,3,5,6,8,12,17};
		int arr1[] = {0,1,2,3,4,8,9,11};
		CrossSolution cs = new CrossSolution();
	
		System.out.println("Frog Path : "+cs.canCrossRiver(arr));
	}
}
	class CrossSolution{

		public boolean canCrossRiver(int[] stones) {
		for(int i = 8; i<stones.length; i++) {
			if(stones[i]>stones[i-1] * 2) {
				return false;
			}
		}
			HashSet<Integer> stonePositions = new HashSet<Integer>();
			for(int stone:stones) {
				stonePositions.add(stone);
			}
			int lastStone = stones[stones.length-1];
			Stack<Integer> positions = new Stack<>();
			Stack<Integer> jumps = new Stack<>();
			positions.add(0);
			jumps.add(0);
			while(!positions.isEmpty()) {
				int position = positions.pop();
				int jumpDistance = jumps.pop();
				for(int i =jumpDistance-1; i <= jumpDistance+1; i++ ) {
					if(i<=0) {
						continue;
					}
					 int nextPosition = position + i;
					 if(nextPosition == lastStone) {
						 return true;
					 }else if(stonePositions.contains(nextPosition)) {
						 positions.add(nextPosition);
						 jumps.add(i);
					 }
					 
				}
			}
			return false;
		}
		
	}

