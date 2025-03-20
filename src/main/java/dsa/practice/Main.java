package dsa.practice;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] versions = new int[] { 1, 2, 3, 4, 5, 6 };

        int size = versions.length;

        int i = 0;
        int j = size - 1;

        int mid = (j - i) / 2 + 1;
        int bad = badone(versions, i, j);

    }

    public static Boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static int badone(int[] versions, int i, int j) {

        int size = versions.length;

        int mid = (j - i )/ 2;

        Boolean isbad = isBadVersion(mid);
        System.out.println(isbad);
        if (isbad == true) {


            if (isBadVersion(mid - 1)) {

                return badone(versions, i, mid);

            } else {

                return mid;
            }

        }

        else {

            System.out.println(mid);

            return badone(versions, mid + 1, j);

        }

    }
}