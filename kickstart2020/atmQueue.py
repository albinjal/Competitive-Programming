import math

cases = int(input())
for case in range(0, cases):
    N, maxAmount = [int(x) for x in input().split()]
    people = sorted([(math.ceil(int(x) / maxAmount), i+1) for i, x in enumerate(input().split())])
    print("Case #{}:".format(case+1), end="")

    for person in people:
        print(" {}".format(person[1]), end="")
    print()
