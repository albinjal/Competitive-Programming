import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Stack;

class MathSet {
    private static final int INIT_SIZE = 8;
    private int totChildren;
    private HashSet<MathSet> children;

    MathSet(int totChildren, HashSet<MathSet> children) {
        this.totChildren = totChildren;
        this.children = children;
    }

    MathSet() {
        this(0, new HashSet<MathSet>(INIT_SIZE));
    }

    public MathSet copy() {
        return new MathSet(this.totChildren, (HashSet<MathSet>) this.children.clone());
    }

    public int cardinality() {
        return this.children.size();
    }

    public MathSet add(MathSet child) {
        if (this == child) {
            child = child.copy();
        }
        if (this.children.add(child)) {
            this.totChildren += 1 + child.totChildren;
        }
        return this;
    }

    public MathSet union(MathSet otherMathSet) {
        for (MathSet s : otherMathSet.children) {
            this.add(s);
        }
        return this;

    }

    public MathSet intersect(MathSet otherMathSet) {
        MathSet res = new MathSet();
        for (MathSet s : otherMathSet.children) {
            if (this.children.contains(s)) {
                res.add(s);
            }
        }
        return res;

    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof MathSet))
            return false;
        if (obj == this)
            return true;

        MathSet set = (MathSet) obj;
        if (this.totChildren != set.totChildren) {
            return false;
        }
        return set.children.containsAll(this.children);
    }

    @Override
    public int hashCode() {
        return this.totChildren + this.cardinality();
    }
}

public class SetStackComputer {
    static class MathSetStack {
        private Stack<MathSet> MathSets = new Stack<MathSet>();

        public void push() {
            this.MathSets.push(new MathSet());
        }

        public void duplicate() {
            this.MathSets.push(MathSets.peek().copy());
        }

        public void union() {
            this.MathSets.push(this.MathSets.pop().union(this.MathSets.pop()));
        }

        public void intersect() {
            this.MathSets.push(this.MathSets.pop().intersect(this.MathSets.pop()));
        }

        public void add() {
            this.MathSets.push(this.MathSets.pop().add(this.MathSets.pop()));
        }

        public void printCardinality() {
            System.out.println(this.MathSets.peek().cardinality());
        }

    }

    public static void main(String[] args) {
        Kattio io;
        try {
            io = new Kattio(new FileInputStream("data/setstack.txt"), System.out);
            final int T = io.getInt();
            for (int c = 0; c < T; ++c) {
                final MathSetStack stack = new MathSetStack();
                final int N = io.getInt();
                for (int i = 0; i < N; ++i) {
                    switch (io.getWord()) {
                        case "PUSH":
                            stack.push();
                            break;
                        case "DUP":
                            stack.duplicate();
                            break;
                        case "UNION":
                            stack.union();
                            break;
                        case "INTERSECT":
                            stack.intersect();
                            break;
                        case "ADD":
                            stack.add();
                            break;
                        default:
                            System.out.println("Command not found.");
                    }
                    stack.printCardinality();

                }
                System.out.println("***");

            }
            io.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
