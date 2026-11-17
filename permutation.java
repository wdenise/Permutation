package exam;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class permutation {
	
	static Scanner input = new Scanner(System.in);
	static Queue<String> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("[1] Add Elements\n[2] Remove Elements\n[3] Permutate\n[4] Exit\nEnter choice: ");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				addElements();
				break;
			case 2:
				removeElements(null);
				break;
			case 3:
				generatePermutation();
				break;
			case 4:
				System.out.println();
				break;
			default:
				System.out.println("Invalid");
				break;
			}
		} while (choice!=4);
		
	}
	
	static void addElements() {
		System.out.print("How many elements to add? ");
		int count = input.nextInt();
		input.nextLine();
		for (int i = 0; i < count; i++) {
			System.out.print("Enter element " + (i + 1) + ": ");
			String element = input.nextLine();
			queue.add(element);
			}
		}
	
	static void removeElements(String elements) {
		System.out.print("How many elements to remove? ");
		int count = input.nextInt();
		input.nextLine();
		for (int i = 0; i < count; i++) {
			System.out.print("Enter element " + (i + 1) + ": ");
			String element = input.nextLine();
			queue.remove(element);
			}
	}

	static void generatePermutation() {
		if (queue.isEmpty()) {
			System.out.println("Queue is empty!");
			return;
			}
		System.out.println("Queue: " + queue);
		System.out.print("Enter number of elements to arrange: ");
		int r = input.nextInt();
		int size = queue.size();
		String[] elements = new String[size];
		for (int i = 0; i < size; i++) {
			String val = queue.poll();
			elements[i] = val;
			queue.add(val);
			}
		
		System.out.println("\nGenerated Permutations:");
		int[] count = new int[1];
		permute(elements, "", new boolean[size], r, count);
		System.out.println("Total Permutations: " + count[0] +"\n");
		}
	
	private static void permute(String[] elements, String current, boolean[] used, int perm, int[] count) {
		if (current.length() == perm) {
			System.out.print(current + "\n");
			count[0]++;
			return;
			}
		
		for (int i = 0; i < elements.length; i++) {
			if (!used[i]) {
				used[i] = true;
				permute(elements, current + elements[i], used, perm, count);
				used[i] = false;
				}
			}
		}
	}































