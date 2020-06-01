class TreeNode:
	def __init__(self, x, left, right):
		self.val = x
		self.left, self.right = None, None

	def createBST(self, nums):
		root = None
		for num in nums:
			root = insert(root, num)
		return root

	def insert(self, root, val):
		if not root: return TreeNode(val, None, None)
		if val <= root.val:
			root.left = self.insert(root.left, val)
		else:
			root.right = self.insert(root.right, val)
		return root

	def inorder(self, root):
		if not root: return
		self.inorder(root.left)
		print(root.val)
		self.inorder(root.right)

# Tree Question Template
# Template 1: one root
def func_solve(root):
	if not root: return ...
	if fun_a(root): return ...
	l = func_solve(root.left)
	r = func_solve(root.right)
	return fun_b(root, l, r)

# LeetCode 104.
def maxDepth(root):
	if not root: return 0
	l = maxDepth(root.left)
	r = maxDepth(root.right)
	return max(l, r) + 1

# LeetCode 111.
def minDepth(root):
	if not root: return 0    # 空节点
	if not root.left and not root.right: return 1    # 叶节点
	l = minDepth(root.left)
	r = minDepth(root.right)

	if not root.left: return 1 + r
	if not root.right: return 1 + l

	return max(l, r) + 1

# LeetCode 112.
def pathSum(root, sum):
	if not root: return False
	if not root.left and not root.right: return root.val == sum
	l = pathSum(root.left, sum - root.val)
	r = pathSum(root.right, sum - root.val)
	return l or r


# Template 2: two roots
def solve(p, q):
	if not p and not q: return ...
	if fun_a(p, q): return ...
	c1 = solve(p.child, q.child)
	c2 = solve(p.child, q.child)
	return fun_b(p, q, c1, c2)

# LeetCode 100. Same Tree
def sameTree(p, q):
	if not p and not q: return True
	if not p or not q: return False
	l = sameTree(p.left, q.left)
	r = sameTree(p.right, q.right)
	return p.val == q.val and l and r

# LeetCode 101. Symmetric Tree
def mirror(p, q):
	if not p and not q: return True
	if not p or not q: return False
	l = mirror(p.left, q.right)
	r = mirror(p.right, q.left)
	return p.val == q.val and l and r

# LeetCode 951. Flip Equivalent Binary Trees
def flipEquiv(p, q):
	if not p and not q: return True
	if not p or not q: return False
	l1 = flipEquiv(p.left, q.left)
	l2 = flipEquiv(p.left, q.right)
	r1 = flipEquiv(p.right, q.right)
	r2 = flipEquiv(p.right, q.left)
	return p.val == q.val and ((l1 and r1) or (l2 and r2))