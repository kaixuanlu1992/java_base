package data_structure;

/**
 * 平衡二叉查找树 AVL
 */
public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> mroot;
    class AVLNode<T extends Comparable<T>>{
        private T key;
        private int height;         // 高度
        private AVLNode<T> left;    // 左孩子
        private AVLNode<T> right;    // 右孩子

        public AVLNode(T key, AVLNode<T> left, AVLNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }
    private int max(int a, int b) {
        return a>b ? a : b;
    }

    /**
     * 获取树的高度
     *
     */
    private int height(AVLNode<T> tree) {
        if (tree != null)
            return tree.height;

        return 0;
    }

    public int height() {
        return height(mroot);
    }

    //LL
    private AVLNode<T> llRotation(AVLNode<T> node){
        AVLNode<T> k1 = node.left;
        node.left = k1.right;
        k1.right = node;
        node.height = max( height(node.left), height(node.right)) + 1;
        k1.height = max( height(k1.left), node.height) + 1;
        return k1;
    }

    //RR
    private AVLNode<T> rrRotation(AVLNode<T> node){
        AVLNode<T> k1 = node.right;
        node.right = k1.left;
        k1.left = node;
        node.height = max( height(node.left), height(node.right)) + 1;
        k1.height = max( height(k1.right), node.height) + 1;
        return k1;
    }

    //LR
    private AVLNode<T> lrRotation(AVLNode<T> node){
        node.left = rrRotation(node.left);
        return llRotation(node);
    }

    //RL
    private AVLNode<T> rlRotation(AVLNode<T> node){
        node.right = llRotation(node.right);
        return rrRotation(node);
    }

    /**
     * 将结点插入到AVL树中，并返回根节点
     *
     */
    private AVLNode<T> insert(AVLNode<T> node, T key){
        int cmp;
        if (node == null){
            node = new AVLNode<T>(key, null, null);
        } else {
            cmp = node.key.compareTo(key);
            if (cmp>0){
                insert(node.left, key);
                if (node.left.height - node.right.height == 2){
                    if (node.left.key.compareTo(key)>0)
                        node=llRotation(node);
                    else
                        node=lrRotation(node);
                }
            } else if (cmp<0){
                insert(node.right, key);
                if (node.right.height - node.left.height == 2){
                    if (node.right.key.compareTo(key)>0)
                        node=rlRotation(node);
                    else
                        node=rrRotation(node);
                }
            }
            else {
                System.out.println("添加失败：不允许添加相同的节点！");
            }
        }
        node.height = max( height(node.left), height(node.right)) + 1;

        return node;
    }

    public void insert(T key) {
        mroot = insert(mroot, key);
    }

    /**
     * 删除节点
     *
     */
    private AVLNode<T> remove(AVLNode<T> tree, AVLNode<T> z) {
        if (tree==null || z==null)
            return null;
        int cmp = z.key.compareTo(tree.key);
        if (cmp < 0) {
            // 待删除的节点在"tree的左子树"中
            tree.left = remove(tree.left, z);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.right) - height(tree.left) == 2) {
                AVLNode<T> r =  tree.right;
                if (height(r.left) > height(r.right))
                    tree = rlRotation(tree);
                else
                    tree = rrRotation(tree);
            }
        } else if (cmp > 0) {
            // 待删除的节点在"tree的右子树"中
            tree.right = remove(tree.right, z);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.left) - height(tree.right) == 2) {
                AVLNode<T> l =  tree.left;
                if (height(l.right) > height(l.left))
                    tree = lrRotation(tree);
                else
                    tree = llRotation(tree);
            }
        } else {    // tree是对应要删除的节点。
            // tree的左右孩子都非空
            if ((tree.left!=null) && (tree.right!=null)) {
                if (height(tree.left) > height(tree.right)) {
                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的左子树中的最大节点
                    //   (02)将该最大节点的值赋值给tree。
                    //   (03)删除该最大节点。
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                    AVLNode<T> max = maximum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);
                } else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的右子树中的最小节点
                    //   (02)将该最小节点的值赋值给tree。
                    //   (03)删除该最小节点。
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                    AVLNode<T> min = maximum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }
            } else {
                AVLNode<T> tmp = tree;
                tree = (tree.left!=null) ? tree.left : tree.right;
                tmp = null;
            }
        }

        return tree;
    }

    private AVLNode<T> maximum(AVLNode<T> tree) {
        if (tree == null) return  null;
        while (tree.right != null){
            tree = tree.right;
        }
        return tree;
    }

    public T maximum(){
        AVLNode<T> p = maximum(mroot);
        if (p != null){
            return p.key;
        }
        return null;
    }
    private AVLNode<T> search(AVLNode<T> x, T key){
        int cmp;
        while (x != null){
            cmp = x.key.compareTo(key);
            if (cmp == 0){
                return x;
            }else if (cmp>0){
                x=x.left;
            }else {
                x=x.right;
            }
        }
        return x;
    }
    public void remove(T key) {
        AVLNode<T> z;

        if ((z = search(mroot, key)) != null)
            mroot = remove(mroot, z);
    }
}
