package dsaProblems;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingComparison {
	
	public static void bubbleSort(int[] data , int length) {
		boolean swapped;
		for(int i = 0; i < length-1; i++) {
			swapped = false;
			for(int j = 0; j < length-i-1; j++) {
				if(data[j] > data[j+1]) {
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
	
	public static void mergeSort(int[] data , int left , int right) {
		if(left <  right) {
			int mid = left + (right - left)/2;
			mergeSort(data, left, mid);
			mergeSort(data, mid+1, right);
			merge(data, left, mid, right);
		}
	}
	
	public static void merge(int[] data , int left , int mid , int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];
		
		System.arraycopy(data, left, leftArr, 0, n1);
		System.arraycopy(data, mid+1, rightArr, 0, n2);
		
		int i = 0, j = 0, k = left;
		while(i < n1 && j < n2) {
			if(leftArr[i] <= rightArr[j]) {
				data[k++] = leftArr[i++];
			}else {
				data[k++] = rightArr[j++];
			}
		}
		while(i < n1) {
			data[k++] = leftArr[i++];
		}
		while(j < n2) {
			data[k++] = rightArr[j++];
		}				
	}
	
	public static void quickSort(int[] data , int low, int high) {
		if(low < high) {
			int pivot = partition(data, low, high);
			quickSort(data, low, pivot-1);
			quickSort(data, pivot+1, high);
		}
		
	}
	
	public static int partition(int[] data, int low, int high) {
		int pivot = data[high];
		int i = low-1;
		for(int j = low; j < high; j++) {
			if(data[j] < pivot) {
				i++;
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}
		int temp = data[i+1];
		data[i+1] = data[high];
		data[high] = temp;
		
		return i+1;
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
    	System.out.print("Enter the array size : ");
        int n = input.nextInt();
        
        int[] data = new int[n];
        Random rand = new Random();
        for(int i = 0; i < n; i++) {
            data[i] = rand.nextInt(n*10);
        }
        
        int[] dataBubble = Arrays.copyOf(data, n);
        int[] dataMerge  = Arrays.copyOf(data, n);
        int[] dataQuick  = Arrays.copyOf(data, n);

        long startBubble = System.nanoTime();
        bubbleSort(dataBubble,n);
        long endBubble = System.nanoTime();
      
        long startMerge = System.nanoTime();
        mergeSort(dataMerge,0,n-1);
        long endMerge = System.nanoTime();
        
        long startQuick = System.nanoTime();
        quickSort(dataQuick,0,n-1);
        long endQuick = System.nanoTime();
        
        System.out.println("Dataset : "+ n);
        System.out.println("Bubble Sort : "+(endBubble-startBubble)/1000000.0 +" ms");
        System.out.println("Merge Sort : "+(endMerge-startMerge)/1000000.0 +" ms");
        System.out.println("Quick Sort : "+(endQuick-startQuick)/1000000.0 +" ms");
        input.close();

	}

}
