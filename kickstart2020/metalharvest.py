
cases = int(input())
for case in range(0, cases):
    N, maxTime = [int(x) for x in input().split()]

    print("Case #{}:".format(case+1), end="")

    intervals = []
    for i in range(0, N):
        intervals.append(tuple([int(x) for x in input().split()]))
    intervals.sort()

    robotUntil = 1
    deployments = 0
    for start, end in intervals:
        if robotUntil <= start:
            robotUntil = start + maxTime
            deployments += 1
        while (robotUntil < end):
            robotUntil += maxTime
            deployments += 1

    print(" {}".format(deployments))
