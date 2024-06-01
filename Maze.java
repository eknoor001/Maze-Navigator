package maze_navigator_project;

public class Maze {

	private boolean Maze[][];
	private int playerRow;
	private int playerColumn;
	private int treasureRow;
	private int treasureColumn;

	public Maze() {

	}

	public Maze(boolean[][] maze, int treasureRow, int treasureColumn) {
		super();
		Maze = maze;
		this.treasureRow = treasureRow;
		this.treasureColumn = treasureColumn;
	}

	public boolean[][] getMaze() {
		return Maze;
	}

	public void setMaze(boolean[][] maze) {
		Maze = maze;
	}

	public int getPlayerRow() {
		return playerRow;
	}

	public void setPlayerRow(int playerRow) {
		this.playerRow = playerRow;
	}

	public int getPlayerColumn() {
		return playerColumn;
	}

	public void setPlayerColumn(int playerColumn) {
		this.playerColumn = playerColumn;
	}

	public int getTreasureRow() {
		return treasureRow;
	}

	public void setTreasureRow(int treasureRow) {
		this.treasureRow = treasureRow;
	}

	public int getTreasureColumn() {
		return treasureColumn;
	}

	public void setTreasureColumn(int treasureColumn) {
		this.treasureColumn = treasureColumn;
	}

	public boolean checkWin() {
		if (getPlayerRow() == getTreasureRow() && getPlayerColumn() == getTreasureColumn()) {
			return true;
		} else {
			return false;
		}

	}

}
