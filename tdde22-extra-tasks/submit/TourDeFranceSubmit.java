package submit;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null)
                        return null;
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

public class TourDeFranceSubmit {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        while (true) {
            final int f = io.getInt();
            if (f == 0) {
                break;
            }
            final int r = io.getInt();
            ArrayList<Integer> frontGears = new ArrayList<Integer>(f);
            ArrayList<Float> ratios = new ArrayList<Float>(f * r);
            for (int i = 0; i < f; ++i) {
                frontGears.add(io.getInt());
            }
            for (int i = 0; i < r; ++i) {
                final int n = io.getInt();
                for (int m : frontGears) {
                    ratios.add((float) n / m);
                }
            }
            ratios.sort(null);
            float maxSpread = 0;
            for (int i = 1; i < ratios.size(); ++i) {
                final float spread = ratios.get(i) / ratios.get(i - 1);
                if (maxSpread < spread) {
                    maxSpread = spread;
                }
            }
            System.out.printf("%.2f\n", maxSpread);

        }

    }
}
