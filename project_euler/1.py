

def main(below=1000):
    res = 0
    for i in range(1, below):
        if i % 3 == 0 or i % 5 == 0:
            res += i

    return res


if __name__ == '__main__':
    print(main(1000))
