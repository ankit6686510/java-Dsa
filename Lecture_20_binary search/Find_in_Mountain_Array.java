 class Find_in_Mountain_Array {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = getPeakElement(mountainArr);
        int len = mountainArr.length();
        
        // Check if the peak element is the target
        if (mountainArr.get(peak) == target) return peak;

        // Binary search on the left side
        int leftIndex = binarySearchAgnostic(target, 0, peak, mountainArr);
        if (leftIndex != -1) return leftIndex;

        // Binary search on the right side
        return binarySearchAgnostic(target, peak + 1, len - 1, mountainArr);
    }

    // peak element k liye
    int getPeakElement(MountainArray mountainArr) {
        int ans = -1;
        int len = mountainArr.length();
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid < len - 1 && mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    // Agnostic binary search (works for both ascending and descending)
    int binarySearchAgnostic(int target, int start, int end, MountainArray mountainArr) {
        boolean isAsc = mountainArr.get(start) < mountainArr.get(end);
        
        int low = start;
        int high = end;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mountainArr.get(mid) == target) {
                return mid;
            }

            if (isAsc) {
                if (target > mountainArr.get(mid)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (target > mountainArr.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
