package lesson2homework;

public class MyArraySizeException extends IndexOutOfBoundsException {
    public MyArraySizeException(String s) {
        super(s + "Массив должен быть размером 4х4 элемента.");
    }
}
