package lesson5homework;


import java.util.Arrays;

public class TestingThreadsApp {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] array1 = createAndFillArray();
        float[] array2 = createAndFillArray();
        firstMethod(array1);
        secondMethod(array2);
    }

    private static float[] createAndFillArray() {
        float[] myArray = new float[SIZE];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = 1.0f;
        }
        return myArray;
    }

    private static void firstMethod(float[] array) {
        long startTime = System.currentTimeMillis();
        countAndChangeArrayElements(array, 0);
        System.out.println("Время выполнения программы для одного потока: " + (System.currentTimeMillis() - startTime) + " мс.");
    }

    private static void secondMethod(float[] array) {
        long startTime = System.currentTimeMillis();
        float[] leftHalfOfArray = new float[HALF];
        float[] rightHalfOfArray = new float[HALF];
        System.arraycopy(array, 0, leftHalfOfArray, 0, HALF);
        System.arraycopy(array, HALF, rightHalfOfArray, 0, HALF);

        // Запускаем два потока и параллельно просчитываем каждый малый массив
        Thread thread1 = new Thread(() -> {
            countAndChangeArrayElements(leftHalfOfArray, 0);
        });
        Thread thread2 = new Thread(() -> {
            countAndChangeArrayElements(rightHalfOfArray, HALF);
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        float[] mergedMyArray = new float[SIZE];
        System.arraycopy(leftHalfOfArray, 0, mergedMyArray, 0, leftHalfOfArray.length);
        System.arraycopy(rightHalfOfArray, 0, mergedMyArray, HALF, rightHalfOfArray.length);
        System.out.println("Время выполнения программы для двух потоков: " + (System.currentTimeMillis() - startTime) + " мс.");
    }

    private static void countAndChangeArrayElements(float[] arr, int factor) {
        for (int i = 0; i < arr.length; i++) {
            /* Я просто внесла коэффициент, учитывающий индекс элементов массива, в формулу. Но если по условию
            в формулу нельзя вносить изменения, то можно просто вынести само вычисление по формуле
             в отдельный метод, куда и передать соответствующий коэффициент.
             */
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + factor) / 5.0) * Math.cos(0.2f + (i + factor) / 5.0) * Math.cos(0.4f + (i + factor) / 2.0));
        }
    }
}
