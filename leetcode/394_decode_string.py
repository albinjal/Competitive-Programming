class Solution:
    def d(self, s: str, m: int) -> str:

        start = s.find('[')
        end = s.find(']')

        if end == -1:
            return s

        if end < start or start == -1:
            return m*s[0:end] + self.d(s[end+1:], 1)

        i = 1
        while True:
            if not s[start-i:start].isnumeric():
                break
            i += 1
        k = int(s[start-i+1:start])
        return m * (s[0:start-i+1] + self.d(s[start+1:], k))

    def decodeString(self, s: str) -> str:
        return self.d(s, 1)


print(Solution().decodeString(
    "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"))
print("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef")
