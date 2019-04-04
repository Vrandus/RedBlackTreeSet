import java.util.*;
public class SetTester {
    public static void main(String[] args){
         int[] N = { 1000, 10000, 100000, 1000000};
         Random rand = new Random();
         for (int i = 0; i < N.length; i++) {
             ArrayList<Integer> randomList = new ArrayList<>();
             for(int j = 0; j < N[i]; j++){
                 randomList.add(j);
             }
             Collections.shuffle(randomList);


             //Add Complexity Test
             A4Set<Integer> rbTree = new A4Set<>();
             long a4AddBefore = System.currentTimeMillis();
             for(int j = 0; j < randomList.size(); j++){
                 rbTree.add(randomList.get(j));
             }
             long a4AddAfter = System.currentTimeMillis() - a4AddBefore;

             TreeSet<Integer> tree = new TreeSet<>();
             long treeAddBefore = System.currentTimeMillis();
             for(int j = 0; j < randomList.size(); j++){
                 tree.add(randomList.get(j));
             }
             long treeAddAfter = System.currentTimeMillis() - treeAddBefore;


             HashSet<Integer> hash = new HashSet<>();
             long hashAddBefore = System.currentTimeMillis();
             for(int j = 0; j < randomList.size(); j++){
                 hash.add(randomList.get(j));
             }
             long hashAddAfter = System.currentTimeMillis() - hashAddBefore;


             long a4ContainsBefore = System.currentTimeMillis();
             for(int j = 0; j < randomList.size(); j++){
                 rbTree.contains(randomList.get(j));
             }
             long a4ContainsAfter = System.currentTimeMillis() - a4AddBefore;

             long treeContainsBefore = System.currentTimeMillis();
             for(int j = 0; j < randomList.size(); j++){
                 tree.contains(randomList.get(j));
             }
             long treeContainsAfter = System.currentTimeMillis() - treeContainsBefore;

             long hashContainsBefore = System.currentTimeMillis();
             for(int j = 0; j < randomList.size(); j++){
                 hash.contains(randomList.get(j));
             }
             long hashContainsAfter = System.currentTimeMillis() - hashContainsBefore;


             System.out.format("N = %d:\n", N[i]);
             System.out.format("A4Set add %22d ms\nTreeSet add %20d ms\nHashSet add %20d ms\n", a4AddAfter, treeAddAfter, hashAddAfter);
             System.out.format("A4Set contains %17d ms\nTreeSet contains %15d ms\nHashSet contains %15d ms\n", a4ContainsAfter, treeContainsAfter, hashContainsAfter);
            }
        }

    }

