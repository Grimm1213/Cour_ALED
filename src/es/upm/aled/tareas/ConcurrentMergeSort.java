package es.upm.aled.tareas;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentMergeSort implements Callable<int[]> {

	private static ExecutorService executor;

	private int[] list;

	public ConcurrentMergeSort(int[] list) {
		this.list = list;
	}

	@Override
	public int[] call() {
		// Caso base
		if (list.length == 1) {
			return list;
		}
		// Paso recursivo
		int[] left = Arrays.copyOfRange(list, 0, list.length / 2);
		int[] right = Arrays.copyOfRange(list, list.length / 2, list.length);

		Callable<int[]> taskLeft = new ConcurrentMergeSort(left);
		Callable<int[]> taskRight = new ConcurrentMergeSort(right);
		Future<int[]> futureSortedLeft = executor.submit(taskLeft);
		Future<int[]> futureSortedRight = executor.submit(taskRight);
		try {
			int[] sortedLeft = futureSortedLeft.get();
			int[] sortedRight = futureSortedRight.get();
			int[] sortedMerged = new int[list.length];
			int iMerged = 0, iLeft = 0, iRight = 0;
			while (iLeft < sortedLeft.length || iRight < sortedRight.length) {
				if (iLeft == sortedLeft.length) {
					sortedMerged[iMerged] = sortedRight[iRight];
					iMerged++;
					iRight++;
				} else if (iRight == sortedRight.length) {
					sortedMerged[iMerged] = sortedLeft[iLeft];
					iMerged++;
					iLeft++;
				} else if (sortedLeft[iLeft] <= sortedRight[iRight]) {
					sortedMerged[iMerged] = sortedLeft[iLeft];
					iMerged++;
					iLeft++;
				} else if (sortedLeft[iLeft] > sortedRight[iRight]) {
					sortedMerged[iMerged] = sortedRight[iRight];
					iMerged++;
					iRight++;
				}
			}
			return sortedMerged;
		} catch (Exception e) {
			System.out.println("Task was interrupted or threw an exception: " + e.getMessage());
		}
		return list;
	}

	public static void main(String[] args) {
		int[] listBazillion = new int[10000000];
		for (int i = 0; i < listBazillion.length; i++) {
			listBazillion[i] = 10000000 - i;
		}

		long t1 = System.nanoTime();
		// Crea un ExecutorService
		executor = Executors.newCachedThreadPool();
		Callable<int[]> task = new ConcurrentMergeSort(listBazillion);
		Future<int[]> futureSortedList = executor.submit(task);
		try {
			int[] sortedList = futureSortedList.get();
			long t2 = System.nanoTime();
			System.out.println("Tiempo: " + (t2 - t1));
		} catch (Exception e) {
			System.out.println("Task was interrupted or threw an exception: " + e.getMessage());
		} finally {
			executor.shutdown();
		}
	}
}

