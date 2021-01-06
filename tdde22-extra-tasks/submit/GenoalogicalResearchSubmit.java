package submit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Person {
    String birth;
    String death;
    String father;
    String mother;
    List<String> children;

    Person(String birth, String mother, String father) {
        this.birth = birth;
        this.mother = mother;
        this.father = father;
    }
}

class FamilyTree {
    private Map<String, Person> people = new HashMap<String, Person>();

    public void birth(String name, Person person) {
        this.people.put(name, person);
        final Person father = this.people.get(person.father);
        if (father != null) {
            if (father.children == null) {
                father.children = new ArrayList<String>(5);

            }
            father.children.add(name);
            Collections.sort(father.children);
        }
        final Person mother = this.people.get(person.mother);
        if (mother != null) {
            if (mother.children == null) {
                mother.children = new ArrayList<String>(5);

            }
            mother.children.add(name);
            Collections.sort(mother.children);
        }
    }

    public void death(String name, String date) {
        this.people.get(name).death = date;
    }

    public void ancestors(String name) {
        System.out.println("ANCESTORS of " + name);
        final Person p = this.people.get(name);
        if (p.father.compareTo(p.mother) < 1) {
            this.printAnc(p.father, 1);
            this.printAnc(p.mother, 1);
        } else {
            this.printAnc(p.mother, 1);
            this.printAnc(p.father, 1);
        }

    }

    private void printAnc(String name, int depth) {
        final Person p = this.people.get(name);
        for (int i = 0; i < depth; ++i) {
            System.out.print("  ");
        }
        if (p == null) {
            System.out.println(name);
        } else {
            System.out.printf("%s %s -", name, p.birth);
            if (p.death != null) {
                System.out.println(" " + p.death);
            } else {
                System.out.println();
            }
            if (p.father.compareTo(p.mother) < 1) {
                this.printAnc(p.father, depth + 1);
                this.printAnc(p.mother, depth + 1);

            } else {

                this.printAnc(p.mother, depth + 1);
                this.printAnc(p.father, depth + 1);
            }

        }
    }

    public void descendants(String name) {
        System.out.println("DESCENDANTS of " + name);
        final Person p = this.people.get(name);
        if (p.children != null) {
            p.children.forEach(n -> this.printDes(n, 1));
        }

    }

    private void printDes(String name, int depth) {
        final Person p = this.people.get(name);
        for (int i = 0; i < depth; ++i) {
            System.out.print("  ");
        }
        System.out.printf("%s %s -", name, p.birth);
        if (p.death != null) {
            System.out.println(" " + p.death);
        } else {
            System.out.println();
        }
        if (p.children != null) {
            p.children.forEach(n -> this.printDes(n, depth + 1));
        }
    }

}

public class GenoalogicalResearchSubmit {

    public static void main(String[] args) {
        final Scanner io = new Scanner(System.in);
        final FamilyTree tree = new FamilyTree();
        boolean newLine = false;
        while (true) {
            final String[] command = io.nextLine().split(" ", 2);

            switch (command[0]) {
                case "BIRTH": {

                    final String[] content = command[1].split(" : ");
                    tree.birth(content[0], new Person(content[1], content[2], content[3]));

                    break;
                }
                case "DEATH": {

                    final String[] content = command[1].split(" : ");
                    tree.death(content[0], content[1]);

                    break;
                }
                case "ANCESTORS": {
                    if (newLine) {
                        System.out.println();
                    }
                    tree.ancestors(command[1]);
                    newLine = true;
                    break;
                }
                case "DESCENDANTS": {
                    if (newLine) {
                        System.out.println();
                    }
                    tree.descendants(command[1]);
                    newLine = true;
                    break;
                }

                default:
                    System.exit(0);
            }

        }

    }
}
