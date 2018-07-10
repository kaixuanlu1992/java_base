package data_structure;


import java.util.ArrayList;
import java.util.List;

public class BSTree<T  extends Comparable<T>> {
    //数据结构
    private BSNode<T> mroot;
    public class BSNode<T  extends Comparable<T>>{
        private T key;
        private BSNode<T> left;
        private BSNode<T> right;
        private BSNode<T> parent;

        public BSNode(T key, BSNode<T> parent, BSNode<T> left, BSNode<T> right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    //前、中、后续遍历
    private void postOrder(BSNode<T> mroot){
        if (mroot == null) return;
        postOrder(mroot.left);
        postOrder(mroot.right);
        System.out.print("--" + mroot.key);

    }
    public void postOrder() {
        postOrder(mroot);
    }

    private void preOrder(BSNode<T> mroot){
        if (mroot == null) return;
        System.out.print("--" + mroot.key);
        preOrder(mroot.left);
        preOrder(mroot.right);

    }
    public void preOrder() {
        preOrder(mroot);
    }

    private void inOrder(BSNode<T> mroot){
        if (mroot == null) return;
        inOrder(mroot.left);
        System.out.print("--" + mroot.key);
        inOrder(mroot.right);

    }
    public void inOrder() {
        inOrder(mroot);
    }

    private void levelOrder(BSNode<T> mroot){
        List<BSNode> tempList = new ArrayList<BSNode>();
        int index = 0;
        if (mroot != null){
            tempList.add(mroot);
            while (index <= tempList.size()-1){
                System.out.println(tempList.get(index).key);
                BSNode temp = tempList.get(index++);
                if (temp.left != null)
                    tempList.add(temp.left);
                if (temp.right != null)
                    tempList.add(temp.right);
            }
        }

    }

    public void levelOrder() {
        levelOrder(mroot);
    }

    //插入节点，先找到要插入节点的位置，也就是该节点的父节点
    private void insert(BSTree<T>node, BSNode<T> z){
        BSNode<T> x = node.mroot;
        int cmp;
        BSNode<T> y = null;

        //找到节点插入的位置：父节点[y来存储]
        while (x != null){
            y = x;
            cmp = x.key.compareTo(z.key);
            if (cmp > 0){
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.parent = y;
        if (y==null)
            node.mroot = z;
        else {
            cmp = z.key.compareTo(y.key);
            if (cmp < 0)
                y.left = z;
            else
                y.right = z;
        }
    }

    public void insert(T key){
        BSNode tem = new BSNode(key, null, null, null);
        this.insert(this, tem);
    }

    /**
     * 删除节点，并返回被删除的结点
     * 1：叶子节点直接删除
     * 2：只有一个叶子节点，直接替换
     * 3：有双叶子节点，后继节点替换，删除后继节点
     *
     */
    private BSNode<T> delete(BSTree<T>node, BSNode<T> z){
        BSNode<T> x=null;
        BSNode<T> y=null;
        if ((z.left == null) || (z.right == null) )
            y = z;
        else
            y = successor(z);
        //z的后继最多只有一个子节点
        //此时y最多只有一个子节点

        //x为要替换删除节点的位置
        if (y.left != null)
            x = y.left;
        else
            x = y.right;

        //叶子节点替换父节点
        if (x != null)
            x.parent = y.parent;

        if (y.parent == null)
            node.mroot = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;
        //修改原位置的值
        if (y != z)
            z.key = y.key;

        return y;

    }

    public void remove(T key) {
        BSNode<T> z, node;
        if ((z = search(mroot, key)) != null)
            if ( (node = delete(this, z)) != null)
                node = null;
    }

    private BSNode<T> search(BSNode<T> x, T key){
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

    public BSNode<T> search(T key) {
        return search(mroot, key);
    }

    private BSNode<T> maximum(BSNode<T> tree) {
        if (tree == null) return  null;
        while (tree.right != null){
            tree = tree.right;
        }
        return tree;
    }

    public T maximum(){
        BSNode<T> p = maximum(mroot);
        if (p != null){
            return p.key;
        }
        return null;
    }

    private BSNode<T> minimum(BSNode<T> tree) {
        if (tree == null) return  null;
        while (tree.left != null){
            tree = tree.left;
        }
        return tree;
    }

    public T minimum(){
        BSNode<T> p = minimum(mroot);
        if (p != null){
            return p.key;
        }
        return null;
    }

    //前驱，查找"二叉树中数据值小于该结点"的"最大结点"
    public BSNode<T> predecessor(BSNode<T> x) {
        //如果存在左孩子，那么前驱就是该节点左子树最大值
        if(x.left != null){
            return maximum(x.left);
        }
        /**
         * 如果不存在左孩子：
         * 1：为右孩子，那么其前驱就是该节点的父节点
         * 2：为左孩子，那么其前驱为x的最低的父结点，并且该节点在此父结点的右子树上
         */
        BSNode<T> p = x.parent;
        while ((p!=null) && (x==p.left)){
            p=p.parent;
            x=p;
        }
        return p;
    }

    //前驱，查找"二叉树中数据值大于该结点"的"最小结点"
    public BSNode<T> successor(BSNode<T> x) {
        //如果存在右孩子，那么前驱就是该节点右子树最小值
        if(x.right != null){
            return minimum(x.right);
        }
        /**
         * 如果不存在右孩子：
         * 1：为左孩子，那么其后继就是该节点的父节点
         * 2：为右孩子，那么其前驱为x的最低的父结点，并且该节点在此父结点的左子树上
         */
        BSNode<T> p = x.parent;
        while ((p!=null) && (x==p.right)){
            p=p.parent;
            x=p;
        }
        return p;
    }

    /**
     *
     * @param tree
     * @param key
     * @param direction:是否为根节点
     */
    private void print(BSNode<T>tree, T key, int direction){
        if(tree != null) {
            if(direction==0)// tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            else                // tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (mroot != null)
            print(mroot, mroot.key, 0);
    }

    /**
     *  销毁二叉树
     */
    private void destroy(BSNode<T> tree) {
        if (tree==null)
            return ;
        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);
        tree=null;
    }

    public void clear() {
        destroy(mroot);
        mroot = null;
    }

}
