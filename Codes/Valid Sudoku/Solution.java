public class Solution {
	public int isValidSudoku(final List<String> a) {
	    char [][] b = new char[9][9];
	    for (int y = 0; y < a.size(); y++) {
	        String i = a.get(y);
	        for (int x = 0; x < i.length(); x++) {
	            b[y][x] = i.charAt(x);
	        }
	    }
	    
	    int result = -1;
	    boolean answer = isValid(b);
	    if (answer) {
	        return 1;
	    } else {
	        return 0;
	    }
	}
	
	public boolean isValid(char[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return false;
		// check row
		Set duplicates = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			duplicates = new HashSet<>();
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.')
					continue;
				if (duplicates.contains(board[i][j]))
					return false;
				duplicates.add(board[i][j]);
			}
		}

		// check colm
		for (int i = 0; i < board.length; i++) {
			duplicates = new HashSet<>();
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == '.')
					continue;
				if (duplicates.contains(board[j][i]))
					return false;
				duplicates.add(board[j][i]);
			}
		}

		for (int i = 0; i <= board.length - 3; i = i + 3) {
			for (int j = 0; j <= board[0].length - 3; j = j + 3) {
				if (!check(i, i + 3, j, j + 3, board)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean check(int i, int i1, int j, int j1, char[][] board) {
		Set duplicates = new HashSet<>();
		for (int r = i; r < i1; r++) {
			for (int c = j; c < j1; c++) {
				if (board[r][c] == '.')
					continue;
				if(duplicates.contains(board[r][c])) {
					return false;
				}
				duplicates.add(board[r][c]);
			}
		}
		return true;
	}
}
