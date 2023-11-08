sudoku=
[["5","3",".",".","7",".",".",".","."]

,["6",".",".","1","9","5",".",".","."]

,[".","9","8",".",".",".",".","6","."]

,["8",".",".",".","6",".",".",".","3"]

,["4",".",".","8",".","3",".",".","1"]

,["7",".",".",".","2",".",".",".","6"]

,[".","6",".",".",".",".","2","8","."]

,[".",".",".","4","1","9",".",".","5"]

,[".",".",".",".","8",".",".","7","9"]]

function isValidSudoku(board) {
    // Check rows
    for (let i = 0; i < 9; i++) {
        if (!isValidUnit(board[i])) {
            return false;
        }
    }

    // Check columns
    for (let j = 0; j < 9; j++) {
        const column = [];
        for (let i = 0; i < 9; i++) {
            column.push(board[i][j]);
        }
        if (!isValidUnit(column)) {
            return false;
        }
    }

    // Check 3 x 3 sub-boxes
    for (let boxRow = 0; boxRow < 9; boxRow += 3) {
        for (let boxCol = 0; boxCol < 9; boxCol += 3) {
            const subBox = [];
            for (let i = boxRow; i < boxRow + 3; i++) {
                for (let j = boxCol; j < boxCol + 3; j++) {
                    subBox.push(board[i][j]);
                }
            }
            if (!isValidUnit(subBox)) {
                return false;
            }
        }
    }

    return true;
}

function isValidUnit(unit) {
    const seen = new Set();
    for (const cell of unit) {
        if (cell === '.') {
            continue;
        }
        if (seen.has(cell)) {
            return false;
        }
        seen.add(cell);
    }
    return true;
}

ans=isValidSudoku(sudoku);
console.log(ans)