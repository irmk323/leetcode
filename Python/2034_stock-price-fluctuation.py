class StockPrice:

    def __init__(self):
        self.timestamps = {}
        self.max_time = 0
        self.max_heap = []
        self.min_heap = []

    def update(self, timestamp: int, price: int) -> None:
        self.timestamps[timestamp] = price
        self.max_time = max(self.max_time, timestamp)
        
        # refer the link for heapq
        # https://qiita.com/T_Wakasugi/items/dac6eb77a3cace54f95e
        heapq.heappush(self.min_heap, (price, timestamp))
        # If the element is taken out (pop) and the sign is reversed again (multiplied by -1), the maximum value can eventually be taken out.
        heapq.heappush(self.max_heap, (-price, timestamp))
        

    def current(self) -> int:
        return self.timestamps[self.max_time]

    def maximum(self) -> int:
        cur_price, timestamp = heapq.heappop(self.max_heap)
        
        while -cur_price != self.timestamps[timestamp]:
            cur_price, timestamp = heapq.heappop(self.max_heap)

        heapq.heappush(self.max_heap, (cur_price, timestamp))
        return -cur_price

    def minimum(self) -> int:
        cur_price, timestamp = heapq.heappop(self.min_heap)
        
        while cur_price != self.timestamps[timestamp]:
            cur_price, timestamp = heapq.heappop(self.min_heap)
        heapq.heappush(self.min_heap, (cur_price, timestamp))
        return cur_price
        
# Time
# Update O(log K)
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