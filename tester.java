
public class tester {

	public static void main(String[] args) {
		A4Set<Integer> test = new A4Set<>();
		
		int val1 = 11;
		test.add(val1);
		System.out.println("add: " + test.add(val1));
		System.out.println("contains 11: " + test.contains(val1));
		System.out.println("contains 12: " + test.contains(12));
		val1 = 12;
		test.add(val1);
		System.out.println("add: " + test.add(val1));
		System.out.println("contains 11: " + test.contains(val1));
		System.out.println("contains 12: " + test.contains(12));
		System.out.println(test.size());
		test.clear();
		
		System.out.println("contains 11: " + test.contains(val1));
		System.out.println("contains 12: " + test.contains(12));
		
	}
}
