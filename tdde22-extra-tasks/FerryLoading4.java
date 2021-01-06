
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FerryLoading4 {

    public static void main(String[] args) {
        Kattio io;
        try {
            io = new Kattio(new FileInputStream("data/ferry.txt"), System.out);

            final int c = io.getInt();
            for (int cc = 0; cc < c; cc++) {

                // Solution
                int leftPackages = 0;
                int rightPackages = 0;
                final int ferryLength = io.getInt() * 100;
                final int m = io.getInt();
                int leftBuffer = 0;
                int rightBuffer = 0;
                for (int car = 0; car < m; car++) {
                    final int carLength = io.getInt();
                    if ("left".equals(io.getWord())) {
                        leftBuffer += carLength;
                        if (leftBuffer > ferryLength) {
                            leftPackages++;
                            leftBuffer = carLength;
                        }
                    } else {
                        rightBuffer += carLength;
                        if (rightBuffer > ferryLength) {
                            rightPackages++;
                            leftBuffer = carLength;
                        }

                    }
                }
                if (leftBuffer > 0) {
                    leftPackages++;
                }
                if (rightBuffer > 0) {
                    rightPackages++;
                }
                System.out.println(leftPackages > rightPackages ? leftPackages * 2 - 1 : rightPackages * 2);

            }

            io.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
