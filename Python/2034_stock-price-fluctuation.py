class StockPrice:

    def __init__(self):
        self.timestamps = {}
        self.max_time = 0
        self.max_heap = []
        self.min_heap = []
# 1:3
# 2:5

    def update(self, timestamp: int, price: int) -> None:
        # O(1)
        self.timestamps[timestamp] = price 
        # O(1)
        self.max_time = max(self.max_time, timestamp)
        
        # refer the link for heapq
        # https://qiita.com/T_Wakasugi/items/dac6eb77a3cace54f95e
        # O(log n) n : len(min_heap)
        heapq.heappush(self.min_heap, (price, timestamp))
        # If the element is taken out (pop) and the sign is reversed again (multiplied by -1), the maximum value can eventually be taken out.
        # O(log n) n : len(max_heap)
        heapq.heappush(self.max_heap, (-price, timestamp))
        

    def current(self) -> int:
        # O(1)
        return self.timestamps[self.max_time]

    def maximum(self) -> int:
        # O(log n)
        cur_price, timestamp = self.max_heap[0]
        # O(n log n) log n on average 
        # O(1) if we use .peek() average, 
        
        while -cur_price != self.timestamps[timestamp]:
            heapq.heappop(self.max_heap)
            cur_price, timestamp = self.max_heap[0]
            

        # heapq.heappush(self.max_heap, (cur_price, timestamp))
        return -cur_price

    def minimum(self) -> int:
        cur_price, timestamp = self.min_heap[0]
        
        while cur_price != self.timestamps[timestamp]:
            heapq.heappop(self.min_heap)
            cur_price, timestamp = self.min_heap[0]
        return cur_price
        
# Time
# Update O(log n)
# Current O(1)
# Max k * log K
# Min k * log K

# Space
# O(N)

# Your StockPrice object will be instantiated and called as such:
# obj = StockPrice()
# obj.update(timestamp,price)
# param_2 = obj.current()
# param_3 = obj.maximum()
# param_4 = obj.minimum()