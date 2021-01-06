from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i in range(1, len(prices)):
            change = prices[i] - prices[i-1]
            if change > 0:
                profit += change
            else:
                lastDayProfit = 0
                nextDayProfit = 0
                if i-2 >= 0:
                    lastDayProfit = prices[i-1] - prices[i-2]
                if i+1 < len(prices):
                    nextDayProfit = prices[i+1] - prices[i]

                selLoss = min(lastDayProfit, nextDayProfit)
                if -change > selLoss:
                    profit -= max(0, selLoss)
                else:
                    profit += change
        return profit


print(Solution().maxProfit(
    [2, 6, 8, 7, 8, 7, 9, 4, 1, 2, 4, 5, 8]))
# 15
