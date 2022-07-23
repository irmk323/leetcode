# Time: O(n)
# Space: O(n)
class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        # Y, X , start from left top
        rows = [0,0,0]
        columns = [0,0,0]
        diagonal_top_left = 0
        diagonal_bottom_left = 0
        
        player = 1
        for i, move in enumerate(moves):
            rows[move[0]] += player
            columns[move[1]] += player
            if move[0] == move[1]:
                diagonal_top_left += player
            if move[0] + move[1] == 2:
                diagonal_bottom_left  += player 
            player *= -1

            if i == len(moves)-1:
                results = [rows[move[0]], columns[move[1]], diagonal_top_left, diagonal_bottom_left]
                if any([n==3 for n in results]):
                    return 'A' 
                if any([n==-3 for n in results]):
                    return 'B' 
            
        return 'Draw' if len(moves) == 9 else 'Pending'
