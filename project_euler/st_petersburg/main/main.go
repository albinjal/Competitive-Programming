package main

import "fmt"

const cost = 2
const cutoff = 0.000000001

var probabability = 1.0

func pro(s int, p float64) {
	// Out of money?
	if s < cost {
		probabability -= p
		return
	}

	// Can play
	var res = 1
	for {
		var prob = p / float64(res*2)
		if prob < cutoff {
			break
		}
		pro(s-cost+res, prob)
		res *= 2
	}

}

func main() {
	pro(5, 1)
	fmt.Println(probabability)
}
