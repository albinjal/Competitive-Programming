const split = (str: string, index: number) => [
    str.slice(0, index),
    str.slice(index),
];

function partitionLabels(S: string): number[] {
    for (let i = 1; i <= S.length; i++) {
        const [left, right] = split(S, i);
        let ok = true;
        for (const c of left) {
            const prob = right.lastIndexOf(c);
            if (prob !== -1) {
                i = left.length + prob;
                ok = false;
                break;
            }
        }
        if (ok) {
            return [left.length, ...partitionLabels(right)];
        }
    }
}
console.log(partitionLabels('dnsajignjinaxncbakdsakklkowkokflöööö'));
