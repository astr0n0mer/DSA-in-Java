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

    private void swap(int index1, int index2) {
        int temp = myArray[index1];
        myArray[index1] = myArray[index2];
        myArray[index2] = temp;
    }

    public static void main(String[] args) {
        Main myArrayObj = new Main();
//        myArrayObj.generateRandomArray();
        for (int i = 0; i < myArrayObj.arraySize; i++) {
            myArrayObj.myArray[i] = 55 - i;
        }
//        myArrayObj.bubbleSort();
//        myArrayObj.selectionSort();
        myArrayObj.insertionSort();
        myArrayObj.printArray();
    }
}
