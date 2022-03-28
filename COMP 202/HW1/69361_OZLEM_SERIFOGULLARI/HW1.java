import java.util.Random;
import java.util.Arrays;

public class HW1 {
	
	// This is the method that returns the count of 'a' chars in the matrix
	// Feel free to add a helper method for the recursive part of the algorithm
  static int counter(char a[][], int r, int l, int u){
    int mid;
    if(r == a.length){
      return 0;
    }
    if(u != l){
      mid = l + (u-l)/2;
      if(a[r][mid] == 'a'){
        l = mid + 1;
        return counter(a, r, l, u);
      }
      else {
        u = mid;
        return counter(a, r, l, u);
      }
    }
    r++;
    return l + counter(a, r, 0, (a.length -1));
  }

	public static int acount(char[][] mat) {
		int result = 0;
		// Your code goes here
    result = counter(mat, 0, 0, (mat.length -1)); 
		return result;
	}

	public static void main(String[] args) {
		// This method creates a test case for you
		int n = 5;
		Random rand = new Random();
		char[][] input = new char[n][n];
		for (int i = 0; i < n; i++) {
			int a_num = rand.nextInt(n);
			for (int j = 0; j < a_num; j++) {
				input[i][j] = 'a';
			}
			for (int j = a_num; j < n; j++) {
				input[i][j] = 'b';
			}
		}
		// Here you can see the matrix row by row 
		System.out.println(Arrays.deepToString(input));
		// Here you can see the result of your function
		System.out.println(acount(input));
	}

}
