package lesson2homework;

public class TestingExceptions {
    private static final int ARRAY_SIZE = 4;
    public static void main(String[] args) {
        String[][] array = {
                {"7", "2", "10", "7"},
                {"4", "4", "6", "2"},
                {"1", "3", "9", "7"},
                {"4", "7", "13", "4"}
        };

        try {
            System.out.println("Сумма всех элементов массива: " + summarizeArrayElements(array));
        } catch (MyArraySizeException e) {
            System.out.println(" Ошибка. " + e.getMessage());
        } catch (MyArrayDataException e1) {
            System.out.println(" Ошибка. " + e1.getMessage());
        }
    }

    private static int summarizeArrayElements(String array[][]) {

        checkArrayBounds(array);
        int result = convertStringArrayToIntegerAndSummarizeElements(array);
        return result;
    }

    private static int convertStringArrayToIntegerAndSummarizeElements(String[][] array) {
        int[][] myNumericArray = new int[4][4];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    myNumericArray[i][j] = Integer.parseInt(array[i][j].trim());
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] находится не целочисленное значение. ");
                }
                sum += myNumericArray[i][j];
            }
        }
        return sum;
    }

    private static void checkArrayBounds(String[][] array) {

        if (array.length != ARRAY_SIZE) {
            throw new MyArraySizeException("Количество строк в массиве должно быть 4. ");
        } else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i].length != ARRAY_SIZE) {
                        throw new MyArraySizeException("Количество столбцов в массиве должно быть 4. ");
                    }
                }
            }
        }

    }
}
