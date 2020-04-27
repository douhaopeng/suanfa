class NumArray {
    static int[] sumArray ;
    static int[] array;
    public NumArray(int[] nums) {
        sumArray = new int[nums.length];
        array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
            if (i == 0) sumArray[i] = nums[i];
            else sumArray[i] = nums[i] + sumArray[i-1];
        }
    }
    public int sumRange(int i, int j) {
        return  sumArray[j] - sumArray[i] + array[i];
    }
}
