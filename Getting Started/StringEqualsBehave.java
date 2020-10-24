package strings;

public class StringEqualsBehave {

	public static void main(String[] args) {

				String s1 = "Hello";
				String s2 = "Hello";       // "Hello" will be stored in 1 place only and its address will be
				                           // given to both s1 and s2

				s1 = s1 + 'e';            // a new memory will be used where "Hello" will be copied and 'e' will be added to it.
										  // THEREFORE TIME COMPLEXITY : O(n)

				s1 = "Hello";
				// To store "Hello" in new place we have to use keyword : new


				String s3 = new String("Hello");

				// == sign only compares the address :

				System.out.println(s1 == s2);

				System.out.println(s1 == s3);

				// to compare the characters we use "equals" :

				System.out.println(s1.equals(s3));
				 //to check not an actual change





	}

}
