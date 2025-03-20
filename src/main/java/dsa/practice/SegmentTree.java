package dsa.practice;

public class SegmentTree {
    int[] segmentValues;
    int n;
    public SegmentTree(int [] arr) {
        n = arr.length;
        segmentValues = new int[4*n];
        buildTree(arr, 0, 0, n-1);
    }
    private int buildTree(int[] arr, int index, int l, int r) {
        if (l == r) {
            segmentValues[index] = arr[l];
        } else {
            int mid = l + (r-l)/2;
            int leftValue = buildTree(arr, 2*index+1, l, mid);
            int rightValue = buildTree(arr, 2*index + 2, mid+1, r);
            segmentValues[index] = leftValue + rightValue;
        }
        return segmentValues[index];
    }

    private void updateSegTree(int index, int nodeIndex, int value, int l, int r) {
        if (l == r) {
            segmentValues[nodeIndex] = value;
            return;
        }
        int mid = l + (r-l)/2;
        if (index <= mid) {
            updateSegTree(index, 2*nodeIndex + 1, value, l, mid);
        } else {
            updateSegTree(index, 2*nodeIndex + 2,value, mid+1, r);
        }
        segmentValues[nodeIndex] = segmentValues[2*nodeIndex+1] + segmentValues[2*nodeIndex+2];
    }

    public void update(int index, int val) {
        updateSegTree(index, 0, val,0, n-1);
    }

    private int sumRange(int index, int start, int end, int l, int r) {
        if (l >end || r<start) {
            return 0;
        }
        if (l>=start && r<=end) {
            return segmentValues[index];
        }
        int mid = (l + r)/2;
        return sumRange(2*index+1, start, end, l, mid)  +
                sumRange(2*index+2, start, end, mid+1, r);

    }

    public int sumRange(int l,int r) {
        return sumRange(0, l, r, 0, n-1);
    }
}
