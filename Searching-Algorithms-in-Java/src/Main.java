// Implementing Linear and Binary search algorithms on an array
import java.util.Arrays;

public class Main {
    private int arraySize = 25;
    private int[] myArray = new int[arraySize];

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void generateRandomArray() {
        // generate random nos from 10 to 19
        for (int i = 0; i < arraySize; i++) {
            myArray[i] = (int) (Math.random() * arraySize);
        }
    }

    public int getIndexOf(int searchItem) {
//        Linear Search
        for (int i = 0; i < arraySize; i++) {
            if (myArray[i] == searchItem) return i;
        }
        return -1;
    }

    public int binarySearch(int searchItem) {
//        Array has to be sorted in order to use Binary Search
        Arrays.sort(myArray);

        int low = 0;
        int high = arraySize - 1;
        int mid;
        while (low <= high) {
//            Previously used expression
//            mid = (low + high) / 2;
//            mid = (low / 2) + (high / 2);
//            mid = (low / 2) + (high / 2) + low - low;
//            mid = (high / 2) + low - low - (low / 2);
//            mid = (high / 2) + low - (low / 2);
            mid = low + ((high - low) / 2);
//            the expression obtained above is a better option to use as "high" approaches really large values
//            (low + high) (line 40) could end up going over maximum positive int value (2^31 – 1) and
//            may result in negative values throwing ArrayIndexOutOfBoundException

            if (myArray[mid] < searchItem) {
                low = mid + 1;
            } else if (myArray[mid] > searchItem) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public void printArray() {
        System.out.println(Arrays.toString(myArray));
    }

    public static void main(String[] args) {
        Main myArrayObj = new Main();
        myArrayObj.generateRandomArray();

//        Generating a random search item: 0 <= searchItem < array.size
        int searchItem = (int) (Math.random() * myArrayObj.getArraySize());

//        int searchResult = myArrayObj.getIndexOf(searchItem);// Linear Search
        int searchResult = myArrayObj.binarySearch(searchItem);// Binary Search
        System.out.println("Index of " + searchItem + " is " + searchResult);
        myArrayObj.printArray();
    }
}
