import java.util.Random;
import java.util.Stack;

public class Assignment1 {

    public static void sortStack(Stack<Integer> s) {

        Stack<Integer> tempStack = new Stack<>();
        int tmp;

        tempStack.push(s.pop());

        while (!s.isEmpty()) {
            if (s.peek() >= tempStack.peek()) {
                tempStack.push(s.pop());
            } else {
                tmp = s.pop();
                while (!tempStack.isEmpty() && tmp < tempStack.peek()) {
                    s.push(tempStack.pop());
                }
                tempStack.push(tmp);
            }
        }

        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }
    }

    private static int[] genArray(int n){
		int[] ret = new int[n];
		for(int i=0; i < ret.length; i++){
			ret[i] = i;
		}
		return ret;
	}
	
	/**
	 * Randomly shuffles an array
	 *
	 * @param  array array of ints to be shuffled
	 * @return      randomized array
	 */
	private static int[] randomizeArray(int[] array){
		Random rng = new Random();  		
 
		for (int i=array.length -1; i > 0; i--) {
			//rng.nextInt(N) returns random number between 0 and N-1 inclusive
			int randomPosition = rng.nextInt(i);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}	
    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int[] arr = randomizeArray(genArray(20));

        for (int i: arr) {
            s.push(i);
        }
        System.out.println(s);
        sortStack(s);
        System.out.println(s);
    }
}
