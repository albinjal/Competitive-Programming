class Shortest {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[] { 2,6,4,8,10,9,15}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        boolean prob = false;
        int l = 0, r = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                l = i;
                prob = true;
                break;
            }
        }
        if (prob) {
            for (int i = nums.length - 2; i >= l; i--) {
                if (nums[i] >= nums[i + 1] ) {
                    r = i + 1;
                    break;
                }
            }
            return r - l + 1;
        }
        return 0;

    }
}