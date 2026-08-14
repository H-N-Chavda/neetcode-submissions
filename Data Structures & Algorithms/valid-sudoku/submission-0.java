class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkRows(board) && checkColumns(board) && checkSquares(board);
    }

    private boolean checkRows(char[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] != '.') {
                    if(set.contains(arr[i][j] - '0'))
                        return false;
                    else 
                        set.add(arr[i][j] - '0');
                }
            }
        }
        return true;
    }

    private boolean checkColumns(char[][] arr) {
        for(int j = 0; j < arr[0].length; j++) {
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < arr.length; i++) {
                if(arr[i][j] != '.') {
                    if(set.contains(arr[i][j] - '0'))
                        return false;
                    else 
                        set.add(arr[i][j] - '0');
                }
            }
        }
        return true;
    }

    private boolean checkSquares(char[][] arr) {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                HashSet<Integer> set = new HashSet<>();
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (arr[i][j] != '.') {
                            if (set.contains(arr[i][j] - '0'))
                                return false;
                            set.add(arr[i][j] - '0');
                        }
                    }
                }
            }
        }
        return true;
    }
}
