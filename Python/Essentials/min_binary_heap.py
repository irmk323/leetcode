class MinHeap:
    def __init__(self, arr):
        self.heap = []
        for num in arr:
            self.add(num)
    
    def add(self, num):
        self.heap.append(num)
        index = len(self.heap) -1
        parent = index // 2
        while (index != 0 and self.heap[index] < self.heap[(index - 1) // 2]):
            self.heap[index], self.heap[parent] = self.heap[parent], self.heap[index]
            index = parent
            parent = index //2
        print("print add process", self.heap)
    
    def pop(self):
        if len(self.heap) == 1:
            return self.heap[0]

        res = self.heap[0]
        self.heap[0] = self.heap.pop(-1)
        print(self.heap)
        index = 0
        while ( (2 * index + 2 ) <= len(self.heap)-1):
            print(2 * index + 2 )
            l_idx = 2 * index + 1
            r_idx = 2 * index + 2
            child_left = self.heap[l_idx]
            child_right = self.heap[r_idx]

            # [3, 100, 4, 7, 9, 45, 17]
            if self.heap[index] > min(child_left, child_right):
                if child_left < child_right:
                    self.heap[index], self.heap[l_idx] = self.heap[l_idx], self.heap[index]
                    index = l_idx 
                else:
                    self.heap[index], self.heap[r_idx] = self.heap[r_idx], self.heap[index]
                    index = r_idx    
        print(self.heap)
        return res

if __name__ == "__main__":
    my_list = [3, 1, 4, 7, 9,45, 17]
    my_heap = MinHeap(my_list)
    my_heap.add(100)
    print(my_heap.pop())
    print("end")


    
# ===============
# d number of children ( d is max )
# 1 -> d(3)
# [1,2,3,4,5,6,7,8,9,10]

# 1 -> 234  range is index[0] -> (index[1] to index[3])
# 2 -> 567  range is index[1] -> (index[5] to index[6])
# 3 -> 8910 range is index[2] -> (index[7] to index[9])

# (i * d) + 1  to (i + 1) * d
