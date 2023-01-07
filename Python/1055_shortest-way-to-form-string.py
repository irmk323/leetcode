# This solution is M*N
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        s_p = 0
        count = 0
        t_p = 0
        while t_p < len(target):
            s_p = 0
            match_flag = False
            while s_p < len(source) and t_p < len(target):
                if source[s_p] == target[t_p]:
                    match_flag = True
                    s_p += 1
                    t_p += 1
                else:
                    s_p += 1
            if match_flag == False:
                return -1
            else:
                count +=1
        return count
                    