

def main(max=4000000):
    numbers = [1, 2]
    res = 2
    while True:
        incoming = numbers[-1] + numbers[-2]
        if incoming >= max:
            return res
        if incoming % 2 == 0:
            res += incoming
        numbers.append(incoming)


if __name__ == '__main__':
    print(main())
