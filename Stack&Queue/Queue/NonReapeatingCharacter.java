package Queue;

import java.util.*;

public class NonReapeatingCharacter {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		char c = scn.next().charAt(0);
		HashMap<Character, Integer> map = new HashMap<>();
		Queue<Character> queue = new LinkedList<>();

		while (c != '.') {
			queue.add(c);

			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}

			while (!queue.isEmpty()) {
				int frq = map.get(queue.peek());
				if (frq == 1) {
					System.out.println(queue.peek());
					break;
				} else {
					queue.poll();
				}
			}

			if (queue.isEmpty())
				System.out.println("-1");
			c = scn.next().charAt(0);
		}

	}

}
