from typing import List


class Solution:
    count = 0

    def rob(self, nums: List[int]) -> int:
        self.count += 1
        if len(nums) <= 2:
            if len(nums) == 0:
                return 0
            return max(nums)
        if nums[0] >= nums[1]:
            return nums[0] + self.rob(nums[2:])
        if nums[1] >= nums[0] + nums[2]:
            return nums[1] + self.rob(nums[3:])
        alt1 = nums[0] + self.rob(nums[2:])
        alt2 = nums[1] + self.rob(nums[3:])

        return max(alt1, alt2)


inp = [226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191, 68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55, 122, 65, 66, 177, 101, 63,
       131, 203, 219, 10, 82, 35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124, 21234, 123,
       24132, 124, 412, 3, 2413, 12, 3, 12, 213, 312, 51, 123, 543, 23, 532, 21, 12, 23, 1, 4, 5, 6, 2, 3, 6, 23, 52,82, 35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124, 21234, 123,
       24132, 124, 412, 3, 2413, 12, 3, 12, 213, 312, 51, 123, 543, 23, 532, 21, 12, 23, 1, 4, 5, 6, 2, 3, 6, 23]
print(len(inp))
x = Solution()
print(x.rob(inp))
print(x.count)
