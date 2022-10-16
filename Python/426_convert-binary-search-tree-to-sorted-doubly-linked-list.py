class Solution:
    # Time: O(n) one pass to turn the BST into a sorted array, another to turn the array into a sorted dbl ll.
    # Space: O(n) intermediate array to store BST contents; solution space as well
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        return array_to_sdll(bst_to_array(root, []))

# In-order traversal of BST yields a sorted list
def bst_to_array(root: 'Optional[Node]', partial: list[int]) -> list[int]:
    if not root:
        return partial
    
    bst_to_array(root.left, partial)
    partial.append(root.val)
    bst_to_array(root.right, partial)

    return partial

def array_to_sdll(nums: list[int]) -> 'Optional[Node]':
    # Edge case: no items
    if not nums:
        return None
    
    # Edge case: only one node points to itself both to the left & right
    if len(nums) == 1:
        aux = Node(nums[0])
        aux.left = aux.right = aux
        return aux

    # General case:

    # We know there are at least 2 elements. Head is a sentinel node whose right value is the first element in the array
    head = Node(-1)

    
    # Keep track of the "previous" element to "cur"
    prev = Node(nums[0])
    head.right = prev

    # From second element onwards, create a node, assign its value & previous
    for i in range(1, len(nums)):
        cur = Node(nums[i])
        cur.left = prev
        prev.right = cur

        # Keep "prev" up to date as we advance "cur"
        prev = cur
    
    # Finally, hook up the first and last nodes to each other
    prev.right = head.right
    head.right.left = prev

    return head.right
