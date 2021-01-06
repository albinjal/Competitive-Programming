import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TourDeFrance {
    public static void main(String[] args) {
        Kattio io;
        try {
            io = new Kattio(new FileInputStream("data/toursample.txt"), System.out);
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
            io.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
