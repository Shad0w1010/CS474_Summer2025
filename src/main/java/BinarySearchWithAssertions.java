public class BinarySearchWithAssertions {
    static int binarySearch(int[] a, int key) {
        int low = 0, high = a.length - 1;
        // The array must be sorted in non-decreasing order.
        assert java.util.stream.IntStream.range(0, a.length - 1)
                .allMatch(i -> a[i] <= a[i + 1]);
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                // Postcondition: return value is a valid index whose element equals key.
                assert a[mid] == key;
                return mid;
            }
        }
        // Postcondition for unsuccessful search: key absent, result must be negative.
        assert java.util.Arrays.binarySearch(a, key) < 0;
        return -1;
    }

}
