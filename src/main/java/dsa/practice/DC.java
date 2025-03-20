package dsa.practice;

public class DC {

    private int mergeAndCount(int l, int m, int r, int[] arr) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] left= new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[m + 1 + j];
        int i = 0;
        int k = l;
        int j = 0;
        int count = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                //i and j are inversion
                //i.e. established => i<j and a[i]>a[j]
                // a[i+1] [i+2]... a[m] all should be counted
                // (m-l) - (i) + 1 
                //all i's coming after i are
                arr[k] = right[j];
                j++;
                // all left -
                count = count + (m + 1) - (l + i);
            }
            k++;
        }

        // Copy remaining elements of left[] if any
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of right[] if any
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return count;
    }
    private int inversionUtil(int[] arr, int low, int high) {
        if (low>=high) {
            return 0;
        }
        int mid = low + (high - low)/2;

        return inversionUtil(arr, low, mid) + inversionUtil(arr, mid+1, high) + mergeAndCount(low, mid, high, arr);
    }

    public int countInversions(int[] arr) {
        return inversionUtil(arr, 0, arr.length-1);
    }
}
