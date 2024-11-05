import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		long m = scanner.nextLong();

		int[] trees = new int[n];
		for (int i = 0; i < n; i++) {
			trees[i] = scanner.nextInt();
		}

		System.out.println(findMaxSawHeight(n, m, trees));
	}

	public static int findMaxSawHeight(int n, long m, int[] trees) {
		int low = 0;
		int high = Arrays.stream(trees).max().getAsInt();
		int result = 0;

		while (low <= high) {
			int mid = (low + high) / 2;
			long total = 0;

			for (int tree : trees) {
				if (tree > mid) {
					total += (tree - mid);
				}
			}

			if (total >= m) {
				result = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return result;
	}
}

