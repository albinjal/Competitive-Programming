from typing import List


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        waits = [0] * len(T)
        unresolved = []
        for i, temp in enumerate(T):
            x = 0
            remove = []
            for index, temperature in unresolved:
                if temp > temperature:
                    waits[index] = i - index
                    remove.append(x)
                    x += 1
                else:
                    break
                
            for r in range(0, x):
                unresolved.pop(0)
            unresolved.append((i, temp))
            unresolved.sort(key=lambda temp: temp[1])

        return waits


print(Solution().dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))
