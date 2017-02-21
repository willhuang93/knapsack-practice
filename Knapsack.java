// Knapsack

public class Knapsack {
	public static void main (String [] args) {
		int values[] = {1, 4, 5, 7};
		int weights[] = {1, 3, 4, 5};
		int weight = 7;
		int numOfItems = 4;
		System.out.println(solve(weight, numOfItems, weights, values));

	}

	public static int solve (int weightLimit, int n, int[] weights, int[] values) {
		int[][] table = new int[n + 1][weightLimit + 1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= weightLimit; w++) {
				if (i == 0 || w == 0)
					table[i][w] = 0;
				else if (weights[i - 1] > w) 
					table[i][w] = table[i-1][w];
				else table[i][w] = max(values[i - 1] + table[i - 1][w - weights[i - 1]], table[i - 1][w]);
			}
		}
		itemsChosen(weightLimit, n, weights, values, table);
		return table[n][weightLimit];
	}

	public static void itemsChosen(int weightLimit, int n, int[] weights, int[] values, int[][] table) {
		int i = n;
		int w = weightLimit;

		while (i != 0) {
			while (w != 0) {
				if (table[i - 1][w] == table[i][w]) 
					System.out.printf("item %d was not chosen\n", i);
				else {
					System.out.printf("item %d was chosen\n", i);
					w = w - weights[i - 1];
				}

				i--;
				System.out.printf("w: %d\t i: %d\n", w, i);
			}
		}

		
	}

	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
