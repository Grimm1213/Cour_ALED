package es.upm.aled.tareas;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentMergeSort implements Callable<int[]> {
	
	private static ExecutorService ex;
	private int[] list;

	public ConcurrentMergeSort(int[] list) {
		this.list = list;
	}

	@Override
	public int[] call() throws Exception {
		//Caso base
				if (list.length ==1) {
					return list;
				}
				//Paso Recursivo
				int [] left = Arrays.copyOfRange(list, 0,list.length/2); //O(n/2)
				int [] right = Arrays.copyOfRange(list, list.length/2,list.length); //O(n/2)
				
				//Ahora lo hago lanzado dos nuevos thread con nuevas tareas
				
				Callable<int[]> taskleft = new ConcurrentMergeSort(left);//Crear una tarea
				Callable<int[]> taskright = new ConcurrentMergeSort(right);
				
				Future<int[]> futureSortedLeft = ex.submit(taskleft);//Pedir que la tarea se ejecute
				Future<int[]> futureSortedRight = ex.submit(taskright);
				
				
				int [] sortedLeft = futureSortedLeft.get(); // Pedir la promesa
				int [] sortedRight = futureSortedRight.get();
				
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
	long t1 = System.nanoTime();
	
	try {
		int cores = Runtime.getRuntime().availableProcessors();
		ex = Executors.newFixedThreadPool(cores);
		Callable<int[]> task = new ConcurrentMergeSort(list);
		Future<int[]> futureList = ex.submit(task);
		
		int[] sortedLists = futureList.get();
		for (int v : sortedLists) {
			System.out.println(v);
		}
		
	}catch (Exception e) {
	} finally {
	ex.shutdown();
	
	}
	}
}
