package ques1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class BuildingSkyscraper {

	private ArrayList<Integer> takeInput() throws Exception {
		// function takeInput is to take input from user, throws Exception for duplicate
		// value and negative values

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the total no of floors in the building");
		int N = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			int temp = sc.nextInt();
			if (temp <= 0)
				throw new Exception("Wrong input");
			if (list.contains(temp))
				throw new Exception("Duplicate input enter");
			else
				list.add(temp);
		}
		sc.close();

		return list;
	}

	private void printOrderOfConstruction(ArrayList<Integer> arr) {
		// this function will Print Order of Construction using Arraylist and Stack

		System.out.println("The order of construction is as follows");

		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> newarr = new ArrayList<>(arr);

		Collections.sort(newarr);

		int k = newarr.size() - 1;

		for (int i = 0; i < arr.size(); i++) {

			System.out.println("\nDay: " + (i + 1));

			stack.push(arr.get(i));

			if (newarr.get(k) == arr.get(i)) {
				while (!stack.isEmpty()) {
					if (stack.peek() == newarr.get(k)) {
						System.out.print(stack.pop() + " ");
						k--;
					} else {
						break;
					}
				}
			}
		}

		ArrayList<Integer> leftFloor = new ArrayList<>();
		while (!stack.isEmpty()) {
			leftFloor.add(stack.pop());
		}
		Collections.sort(leftFloor);
		for (int i = leftFloor.size() - 1; i >= 0; i--) {
			System.out.print(leftFloor.get(i) + " ");
		}

	}

	public static void main(String[] args) {
		// main function

		BuildingSkyscraper Bs = new BuildingSkyscraper();
		ArrayList<Integer> arr = null;
		try {
			arr = Bs.takeInput();
		} catch (Exception e) {
			System.out.println("An error occur while giving inputs");
			e.printStackTrace();
		}

		Bs.printOrderOfConstruction(arr);

	}

}
