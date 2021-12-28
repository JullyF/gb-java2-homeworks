package lesson2homework;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String s) {
        super(s + "В массиве должны быть только целочисленные значения.");
    }
}
