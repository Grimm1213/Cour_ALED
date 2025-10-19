package es.upm.aled.complejidad;

import java.util.Arrays;

public class MergeSort {
	
	private static int[] mergeSort(int [] list) {
		//Caso base
		if (list.length ==1) {
			return list;
		}
		//Paso Recursivo
		int [] left = Arrays.copyOfRange(list, 0,list.length/2); //O(n/2)
		int [] right = Arrays.copyOfRange(list, list.length/2,list.length); //O(n/2)
		
		int [] sortedLeft = mergeSort(left); // O(log n )
		int [] sortedRight = mergeSort(right); // O(log n )
		
		int [] sortedMerged = new int[list.length];
		
		int iMerged = 0, iLeft = 0, iRight = 0;
		
		while(iLeft < sortedLeft.length || iRight < sortedRight.length) {
			
			
			if(iLeft == sortedLeft.length) {
				sortedMerged[iMerged] = sortedRight[iRight];
				++iMerged;
				++iRight;
			}
			
			else if(iRight == sortedRight.length) {
				sortedMerged[iMerged] = sortedLeft[iLeft];
				++iMerged;
				++iLeft;
			}
			else if(sortedLeft[iLeft] <= sortedRight[iRight]) {
				//Cojo del array iz
				sortedMerged[iMerged] = sortedLeft[iLeft];
				++iMerged;
				++iLeft;
				
			}
			else if (sortedLeft[iLeft] > sortedRight[iRight]) {
				//Cojo del array iz
				sortedMerged[iMerged] = sortedRight[iRight];
				++iMerged;
				++iRight;
			}
		}
		return sortedMerged;
		
	}
	
	public static void main(String[] args) {
		int [] list = {31,29,27,23,21,19,17,15,13,11,9,7,5,3,1};
		int [] listOrdenada = mergeSort(list);
		System.out.println("Ordenado:");
		for (int v : listOrdenada) {
			System.out.println(v);
		}
	}
}
