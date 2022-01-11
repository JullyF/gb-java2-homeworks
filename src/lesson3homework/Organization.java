package lesson3homework;

import java.util.Objects;

public class Organization implements Comparable {
    String name;
    String phoneNumber;

    public Organization(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + ", тел.: " + phoneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return name.equals(that.name) && phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    @Override
    public int compareTo(Object o) {
        Organization another = (Organization) o; // почему не работает реализация без присвоения переменной another?
        // например, int result = this.name.compareTo(o.name); ???
        int result = this.name.compareTo(another.name);
        if (result == 0) {
            result = this.phoneNumber.compareTo(another.phoneNumber);
        }
        return result;
    }

    public String getName() {
        return name;
    }
}
