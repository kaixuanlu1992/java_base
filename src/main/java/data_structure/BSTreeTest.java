package data_structure;

public class BSTreeTest {
    public static void main(String[] args){
        int[] nodes = {5,1,2,3,4,6,7,8,9,11};
        BSTree root = new BSTree();
        for (int temp : nodes){
            root.insert(temp);
        }
        System.out.print("----前序遍历：----");
        root.inOrder();
        System.out.println();
        System.out.print("----二叉树打印：----");
        root.print();
        System.out.println();
//        System.out.print("----二叉树删除2：----");
//        root.remove(2);
//        root.inOrder();
        System.out.println();
        System.out.print("----层序遍历：----");
        root.levelOrder();
    }

}
