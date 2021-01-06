// package submit;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.StringTokenizer;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;

// class Kattio {
//     public Kattio(InputStream i) {
//         r = new BufferedReader(new InputStreamReader(i));
//     }

//     public int getInt() {
//         return Integer.parseInt(nextToken());
//     }

//     public String getWord() {
//         return nextToken();
//     }

//     private BufferedReader r;
//     private String line;
//     private StringTokenizer st;
//     private String token;

//     private String peekToken() {
//         try {
//             while (st == null || !st.hasMoreTokens()) {
//                 line = r.readLine();
//                 st = new StringTokenizer(line);
//             }
//             token = st.nextToken();
//         } catch (IOException e) {
//         }
//         return token;
//     }

//     private String nextToken() {
//         String ans = peekToken();
//         token = null;
//         return ans;
//     }
// }

// public class CDSubmit {

//     public static void main(String[] args) {
//         Kattio io = new Kattio(System.in);
//         while (true) {
//             final int p0 = io.getInt();
//             final int p1 = io.getInt();
//             if (p0 == 0 && p1 == 0) {
//                 break;
//             }

//             int ans = 0;
//             final List<Integer> l = new ArrayList<Integer>(p0);
//             for (int i = 0; i < p0; i++) {
//                 l.add(io.getInt());
//             }
//             int check = 0;
//             for (int i = 0; i < p1; i++) {
//                 final int find = io.getInt();
//                 int potential = -1;
//                 boolean b = false;
//                 do {
//                     if (check == p0) {
//                         b = true;
//                         break;
//                     }
//                     potential = l.get(check);
//                     check++;
//                 } while (potential < find);
//                 if (b) {
//                     break;
//                 }
//                 if (potential == find) {
//                     ans++;
//                     continue;
//                 }
//             }
//             System.out.println(ans);
//         }

//     }

// }
