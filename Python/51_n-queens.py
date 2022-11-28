class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        def create_board(state):
            board = []
            for row in state:
                board.append("".join(row))
            return board
            
        def backtrack(row, cols, diagonal, anti_diagonal, state):
            
            if row == n:
                ans.append(create_board(state))
                return
            
            for col in range(n):
                cur_diagonal = row - col
                cur_anti_diagonal = row + col
                if (col in cols or cur_diagonal in diagonal or cur_anti_diagonal in anti_diagonal):
                    continue
                    
                cols.add(col)
                diagonal.add(cur_diagonal)
                anti_diagonal.add(cur_anti_diagonal)
                state[row][col] = "Q"
                    
                backtrack(row+1, cols, diagonal,anti_diagonal, state)
                cols.remove(col)
                diagonal.remove(cur_diagonal)
                anti_diagonal.remove(cur_anti_diagonal)
                state[row][col] = "."
        
        ans = []
        empty = [["."] * n for _ in range(n) ]
        backtrack(0, set(), set(),set(),empty)
        return ans