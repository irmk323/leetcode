class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        graph = collections.defaultdict(list)
        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)
        
        seen = [False] * n
        seen[source] = True
        stack = [source]

        while stack:
            cur_node = stack.pop()
            for next_node in graph[cur_node]:
                if next_node == destination:
                    return True
                if not seen[next_node]:
                    seen[next_node] = True
                    stack.append(next_node)
        return seen[destination]
         # setting False doesn't work for n =1, edges =[],source=0,destination=0