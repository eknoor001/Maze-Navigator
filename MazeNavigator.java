package maze_navigator_project;

import java.util.Scanner;

public class MazeNavigator {

	public static final String WELCOME = "Welcome to the Maze Navigator!";
	public static final String INITIALIZE_MAZE = "Initializing maze...";
	public static final String MAZE_DIMENSIONS = "Please enter the maze dimensions:";
	public static final String MAZE_VALUES = "Please enter the values for the maze's row %d:\n";
	public static final String TREASURE_LOCATION = "Please enter the expected treasure location:";
	public static final String READY = "Ready to start?";
	public static final String CURRENT_POSITION = "Player's Position: %d,%d";
	public static final String MOVE_SELECT = "Please enter a move:";
	public static final String[] MOVES = { "Up", "Down", "Left", "Right" };
	public static final String INVALID_MOVE = "Invalid move! Select another direction.";
	public static final String TREASURE_FOUND = "Treasure found!";
	public static final String FAREWELL = "Thank you for playing!";

	public static void main(String[] args) {
		int up = 0;
		int down = 0;
		int left = 0;
		int right = 0;

		Maze obj = new Maze();
		Scanner scanner = new Scanner(System.in);
		System.out.println(WELCOME + "\n" + INITIALIZE_MAZE);
		System.out.println(MAZE_DIMENSIONS);
		boolean arr[][] = new boolean[scanner.nextInt()][scanner.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			System.out.printf(MAZE_VALUES, i);
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scanner.nextBoolean();
			}

		}

		obj.setMaze(arr);

		System.out.println(TREASURE_LOCATION);
		obj.setTreasureRow(scanner.nextInt());
		obj.setTreasureColumn(scanner.nextInt());

		System.out.println(READY);
		if (scanner.next().equalsIgnoreCase("yes")) {
			System.out.printf(CURRENT_POSITION, 0, 0);
			obj.setPlayerRow(0);
			obj.setPlayerColumn(0);
			do {

				if (obj.checkWin()) {
					System.out.println("\n" + TREASURE_FOUND);
					System.out.println(FAREWELL);
					System.exit(0);
				}

				System.out.println("\n" + MOVE_SELECT);
				for (int i = 0; i < MOVES.length; i++) {
					System.out.println((i + 1) + ". " + MOVES[i]);
				}

				String key = scanner.next();
				switch (key) {
				case "up":
					try {

						up = obj.getPlayerRow();
						up--;
						obj.setPlayerRow(up);

						if (obj.getMaze()[obj.getPlayerRow()][obj.getPlayerColumn()] == true) {
							System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());
						}
						else {
							System.out.println(INVALID_MOVE);
							up++;
							obj.setPlayerRow(up);
							System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());
						}
					}

					catch (ArrayIndexOutOfBoundsException e) {

						up += 2;
						obj.setPlayerRow(up);
						if (obj.getMaze()[obj.getPlayerRow()][obj.getPlayerColumn()] == false) {
							up -= 1;
							obj.setPlayerRow(up);

						}

						System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());

					}
					break;

				case "down":
					try {

						down = obj.getPlayerRow();

						down++;
						obj.setPlayerRow(down);

						if (obj.getMaze()[obj.getPlayerRow()][obj.getPlayerColumn()] == true) {
							System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());
						} else {
							System.out.println(INVALID_MOVE);
							down--;
							obj.setPlayerRow(down);
							System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());
						}
					}

					catch (ArrayIndexOutOfBoundsException e) {

						down -= 2;
						obj.setPlayerRow(down);

						System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());
					}
					break;

				case "left":

					try {

						left = obj.getPlayerColumn();
						left--;
						obj.setPlayerColumn(left);
						if (obj.getMaze()[obj.getPlayerRow()][obj.getPlayerColumn()] == true) {
							System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());
						} else {
							System.out.println(INVALID_MOVE);
							left++;
							obj.setPlayerColumn(left);
							System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());

						}
					} catch (ArrayIndexOutOfBoundsException e) {
						left += 2;
						obj.setPlayerColumn(left);
						if (obj.getMaze()[obj.getPlayerRow()][obj.getPlayerColumn()] == false) {
							left -= 1;
							obj.setPlayerColumn(left);

						}

						System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());
					}

					break;

				case "right":
					try {
						right = obj.getPlayerColumn();
						right++;
						obj.setPlayerColumn(right);
						if (obj.getMaze()[obj.getPlayerRow()][obj.getPlayerColumn()] == true) {
							System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());
						} else {
							System.out.println(INVALID_MOVE);
							right--;
							obj.setPlayerColumn(right);
							System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());
						}
					} catch (ArrayIndexOutOfBoundsException e) {

						right -= 2;
						obj.setPlayerColumn(right);

						System.out.printf(CURRENT_POSITION, obj.getPlayerRow(), obj.getPlayerColumn());

					}

					break;
				default:
					System.out.println("please enter the valid input");
				}

			} while (obj.getPlayerRow() != obj.getTreasureRow() || obj.getPlayerColumn() != obj.getTreasureColumn());

			if (obj.checkWin()) {
				System.out.println("\n" + TREASURE_FOUND);
				System.out.println(FAREWELL);
			}

		} else {
			System.out.println(FAREWELL);
		}

	}
}
