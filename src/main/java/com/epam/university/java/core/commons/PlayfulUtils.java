package com.epam.university.java.core.commons;

public class PlayfulUtils {
    /**
     * Quick sort for array of integers.
     *
     * @param array array of integers to be sorted
     * @param left index of range beginning
     * @param right index of range end
     */
    public static void quickSort(Integer[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);

            quickSort(array, left, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, right);
        }
    }

    private static int partition(Integer[] array, int left, int right) {
        int pivot = array[right];
        int i = (left - 1);

        for (int j = left; j < right; j++) {
            if (array[j] >= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;

        return i + 1;
    }

}
