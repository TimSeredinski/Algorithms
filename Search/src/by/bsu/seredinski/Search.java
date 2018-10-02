package by.bsu.seredinski;

public class Search {

    static void binarySearch(int[] array, int a) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (array[mid] == a)
                return;
            if (a > array[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
    }

    static void interpolationSearch(int[] array, int a) {
        int left = 0, right = (array.length - 1);
        while (left <= right && a >= array[left] && a <= array[right]) {
            int mid = left + (((right - left) * (a - array[left])) /
                    (array[right] - array[left]));
            if (array[mid] == a)
                return;
            if (array[mid] < a)
                left = mid + 1;
            else
                right = mid - 1;
        }
    }

}
