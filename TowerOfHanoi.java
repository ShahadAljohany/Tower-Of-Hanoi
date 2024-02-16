
import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number of disks from the user
        System.out.print("Enter the number of disks: ");
        int numberDisks = input.nextInt();

        // Validate input
        if (numberDisks > 0) // Solve Tower of Hanoi
            towerOfHanoi(numberDisks);
         else 
            System.out.println("Sorry , number of disks should be greater than 0.");
        
    }
    // Function to perform Tower of Hanoi non-recursively
    public static void towerOfHanoi(int numberDisks) {
        Stack<Integer> Stack_1 = new Stack<>();
        Stack<Integer> Stack_2 = new Stack<>();
        Stack<Integer> Stack_3 = new Stack<>();

        // Initialize Stack_1 pole with disks
        for (int i = numberDisks; i > 0; i--) {
            Stack_1.push(i);
        }

        char A = 'A', C = 'C', B = 'B';//  Initially
        int totalMoves = (int) Math.pow(2, numberDisks) - 1;//  Calculate the sum of disk movements

        // Iterate through each move
        for (int move = 1; move <= totalMoves; move++) {
            switch (move % 3) { //call method
                case 1:
                    moveDisk(Stack_1, Stack_3, A, C);
                    break;
                case 2:
                    moveDisk(Stack_1, Stack_2, A, B);
                    break;
                default:
                    moveDisk(Stack_3, Stack_2, C, B);
                    break;
            }
        }

        System.out.println(" The sum of disk movements = " + totalMoves);

    }

    // Function to perform disk movement
    private static void moveDisk(Stack<Integer> fromFirst, Stack<Integer> toSec, char fromTower, char toTower) {
        if (!fromFirst.isEmpty() && (toSec.isEmpty() || fromFirst.peek() < toSec.peek())) {
            toSec.push(fromFirst.pop()); // pop from the first stack and push in second stack
            System.out.println("Move disk "+ toSec.peek()+ " from " + fromTower + " to " + toTower);
        } else {
            fromFirst.push(toSec.pop());// pop from the second stack and push in first stack
            System.out.println("Move disk "+ fromFirst.peek()+ " from " + toTower + " to " + fromTower);
        }
    }

}
