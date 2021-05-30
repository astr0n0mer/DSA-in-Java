// Bubble sort
// Selection sort
// Insertion sort
// Merge sort
// Quick sort

import java.util.Arrays;

public class Main {
    private int arraySize = 30;
    private int[] myArray = new int[arraySize];

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void generateRandomArray() {
        // generate random nos such that 0 <= randomNo < arraySize*2
        for (int i = 0; i < arraySize; i++) {
            myArray[i] = (int) (Math.random() * arraySize * 2);
        }
    }

    public void printArray() {
        System.out.println(Arrays.toString(myArray));
    }

    public void bubbleSort() {
//        Start first loop at the LAST INDEX & go till INDEX=1
//        Start second loop at the INDEX=0 & go till (i-1)th element
//        Check condition and swap accordingly
        for (int i = arraySize - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (myArray[j] > myArray[j + 1]) swap(j, j + 1);
    }

    public void selectionSort() {
        for (int i = 0; i < arraySize - 1; i++) {
//            Pick the 0th element from the unsorted array & assume it is the smallest
            int minimum = i;
            for (int j = i + 1; j < arraySize; j++) {
//            now compare "minimum" with the remaining elements to find the smallest no.
                if (myArray[j] < myArray[minimum]) minimum = j;
            }
//            if any other no. is smaller than minimum then swap their positions (minimum & the new smaller no.)
            swap(minimum, i);
        }
    }

    public void insertionSort() {
//        Select elements one by one starting from INDEX 1 to arr.length-1, we'll call this element as "Key"
//        compare "Key" with elements before it and move them 1 step forward if they're greater than "Key"
//        now place "Key" in its appropriate position such that elements before "Key" are less than "Key"
//        Repeat this procedure for the elements ahead of "Key"
        for (int i = 1; i < myArray.length; i++) {
            int key = myArray[i];
            // j is set to i - 1 to compare "key" to its previous elements
            int j = i - 1;
            // we check j >= 0 to make sure we don't go below 0 index
            while (j >= 0 && myArray[j] > key) {
                myArray[j + 1] = myArray[j];
                j -= 1;
            }
            // loop is broken i.e. all elements that are greater than "key" are at the right side of "key" now
            myArray[j + 1] = key;
        }
    }

    public void mergeArrays(int[] array, int left, int mid, int right) {
        int leftLength = mid - left + 1; // using formula upperbound - lowerbound + 1
        int rightLength = right - mid; // simplified this ->  right - (mid + 1) -1

        int[] L = new int[leftLength];
        int[] R = new int[rightLength];

//        for (int i = 0; i < leftLength; i++) L[i] = array[left + i];
        System.arraycopy(array, left, L, 0, leftLength);
//        for (int j = 0; j < rightLength; j++) R[j] = array[mid + 1 + j];
        System.arraycopy(array, mid + 1, R, 0, rightLength);

        int i = 0, j = 0;
        int k = left;
        while (i < leftLength && j < rightLength) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < leftLength) {
            array[k] = L[i];
            k++;
            i++;
        }
        while (j < rightLength) {
            array[k] = R[j];
            k++;
            j++;
        }
    }

    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            mergeArrays(array, left, mid, right);
        }
    }

    public void mergeSort() {
        mergeSort(myArray, 0, getArraySize() - 1);
    }

    private int partition(int[] array, int left, int right) {
//        This function takes last element as pivot, places the pivot element at its correct position
//        in sorted array, also places all elements smaller than pivot to left of pivot
//        and all greater elements to right of pivot
        int pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, right);
        return i + 1;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);

            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
    }

    public void quickSort() {
        quickSort(myArray, 0, getArraySize() - 1);
    }

    private void swap(int index1, int index2) {
        int temp = myArray[index1];
        myArray[index1] = myArray[index2];
        myArray[index2] = temp;
    }

    public static void main(String[] args) {
        Main myArrayObj = new Main();
        myArrayObj.generateRandomArray();
//        myArrayObj.bubbleSort();
//        myArrayObj.selectionSort();
//        myArrayObj.insertionSort();
//        myArrayObj.mergeSort();
        myArrayObj.quickSort();
        myArrayObj.printArray();
    }
}
