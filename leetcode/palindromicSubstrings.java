class Palindromic {

    public static void main(String[] args) {
        System.out.println(countSubstrings("bannabx"));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            int steps = 1;
            while (i - steps >= 0 && i + steps < s.length()) {
                if (s.charAt(i - steps) == s.charAt(i + steps)) {
                    steps++;
                    continue;
                }
                break;
            }
            count += steps - 1;
            if (s.charAt(i) == s.charAt(i - 1)) {
                steps = 1;
                while (i - steps - 1 >= 0 && i + steps < s.length()) {
                    if (s.charAt(i - steps - 1) == s.charAt(i + steps)) {
                        steps++;
                        continue;
                    }
                    break;
                }
                count += steps;
            }

        }

        return count + s.length();
    }
}
