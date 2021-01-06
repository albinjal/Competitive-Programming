
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CD {

    public static void main(String[] args) {
        Kattio io;
        try {
            io = new Kattio(new FileInputStream("data/cd.txt"), System.out);
            while (true) {
                final int p0 = io.getInt();
                final int p1 = io.getInt();
                if (p0 == 0 && p1 == 0) {
                    break;
                }

                int ans = 0;
                final List<Integer> l = new ArrayList<Integer>(p0);
                for (int i = 0; i < p0; i++) {
                    l.add(io.getInt());
                }
                int check = 0;
                for (int i = 0; i < p1; i++) {
                    final int find = io.getInt();
                    int potential = -1;
                    boolean b = false;
                    do {
                        if (check == p0) {
                            b = true;
                            break;
                        }
                        potential = l.get(check);
                        check++;
                    } while (potential < find);
                    if (b) {
                        break;
                    }
                    if (potential == find) {
                        ans++;
                        continue;
                    }
                }
                System.out.println(ans);
            }

            io.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
