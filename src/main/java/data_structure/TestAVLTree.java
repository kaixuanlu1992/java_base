package data_structure;

public class TestAVLTree {
    public static void main(String[] args){
        int[] nodes = {5,1,2,3,4,6,7,8,9,11};
        AVLTree root = new AVLTree();
        for (int temp : nodes){
            root.insert(temp);
        }
    }
}
