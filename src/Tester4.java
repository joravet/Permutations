
public class Tester4
{
	 static long perms; // How many permutations did we identify?
	 static int size; // What's the size of the set we're permuting (the first "size" elements of A)
	 static String format = "%-11s %d permutations in %15.10f seconds (%9d permutations / second)\n";

	 public static void main(String[] args)
	 {
		 long time; // What time did we start this test?
		 double elapsed; // What was the elapsed time for all repetitions of this test (in seconds)?
	
		 long reps = 27000000000l; // How many repetitions to run (to average out variation)
		 size = 1; // How large is the set we're permuting?
	
		 long fact = 1; for (int i = size; i > 1; fact *= i--); // compute size!
		 System.out.println("Size: " + size + " (" + size + "! = " + fact + ")"); // Output size & target count
	
		 perms = 0; // We've not generated any permutations yet
		 time = System.nanoTime(); // mark the start time
		 for (long times = 1; times <= reps; times++) // repeat test, to average out variations in run time
		 	{
			 int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
			 generateNonRec(size, A); // <----- Change to generateNonRec for Part IV ******
		 	}	
		 elapsed = ((System.nanoTime() - time) / 1000000000.0 / reps);
		 System.out.printf(format, "Iterative", perms/reps, elapsed, (long)(perms/elapsed/reps)); // use "Iterative" in Part IV
	 } // end main 
	 
	 public static void generateNonRec(int n, int[] A)
	 {
		 int[] c = new int[A.length];
		 perms++;
		 int temp;
		 for (int i = 0; i < c.length; i++)
		 {
			 c[i] = 0;
		 }
		 
		 int i = 1;
		 while (i < n)
		 {
			 if (c[i] < i)
			 {
				 if (i % 2 == 0)
					{
						temp = A[i];
						A[i] = A[0];
						A[0] = temp;
					}
						
					else
					{
						temp = A[i];
						A[i] = A[c[i]];
						A[c[i]] = temp;
					}
				 perms++;
				 c[i]++;
				 i = 1;
			 }
			 else
			 {
				 c[i] = 0;
				 i++;
			 }
				 
		 }
	 }
}
