package by.bsu.seredinski;

public class Algorithms {
    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middleIndex = (end + start) / 2;

            mergeSort(array, start, middleIndex);
            mergeSort(array, middleIndex + 1, end);
            merge(array, start, middleIndex, end);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int leftLength = middle - left + 1;
        int rightLength = right - middle;

        int[] leftArray = new int[leftLength + 1];
        int[] rightArray = new int[rightLength + 1];

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightLength; i++) {
            rightArray[i] = array[middle + i + 1];
        }

        leftArray[leftLength] = (int) Double.POSITIVE_INFINITY;
        rightArray[rightLength] = (int) Double.POSITIVE_INFINITY;

        int i = 0, j = 0;

        for (int k = left; k <= right; k++) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
        }
    }
}
