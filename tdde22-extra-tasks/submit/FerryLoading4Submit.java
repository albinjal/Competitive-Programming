package submit;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class Kattio {
    public Kattio(InputStream i) {
        r = new BufferedReader(new InputStreamReader(i));
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                line = r.readLine();
                st = new StringTokenizer(line);
            }
            token = st.nextToken();
        } catch (IOException e) {
        }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}

public class FerryLoading4Submit {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);

        final int c = io.getInt();
        for (int cc = 0; cc < c; ++cc) {

            // Solution
            int leftPackages = 0;
            int rightPackages = 0;
            final int ferryLength = io.getInt() * 100;
            final int m = io.getInt();
            int leftBuffer = 0;
            int rightBuffer = 0;
            for (int car = 0; car < m; ++car) {
                final int carLength = io.getInt();
                if (io.getWord().length() == 4) {
                    final int newBuffer = leftBuffer + carLength;
                    if (newBuffer > ferryLength) {
                        ++leftPackages;
                        leftBuffer = carLength;
                    } else {
                        leftBuffer = newBuffer;
                    }
                } else {
                    final int newBuffer = rightBuffer + carLength;
                    if (newBuffer > ferryLength) {
                        ++rightPackages;
                        rightBuffer = carLength;
                    } else {
                        rightBuffer = newBuffer;
                    }

                }
            }
            if (leftBuffer > 0) {
                ++leftPackages;
            }
            if (rightBuffer > 0) {
                ++rightPackages;
            }
            System.out.println(leftPackages > rightPackages ? leftPackages * 2 - 1 : rightPackages * 2);

        }
    }

}