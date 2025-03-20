package dsa.practice;

public class Internal {
    int length;
    Internal left;
    Internal right;
    String value;

    public Internal(int length, String value) {
        this.length = length;
        this.value = value;
    }

    public Internal(int length) {
        this.length = length;
    }
}
