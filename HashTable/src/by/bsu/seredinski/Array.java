package by.bsu.seredinski;

public class Array {

    public static int[][] createArray() {
        int[][] array = new int[50][1000];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = (int) Math.round(Math.random() * 1000);
            }
        }
        return array;
    }

}
