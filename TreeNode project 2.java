class TreeNode {
    TreeNode leftChild;
    String keyword;
    TreeNode rightChild;
    ArticleNode head;

    public TreeNode(String key, ArticleNode rec){
        leftChild = null;
        keyword = key;
        rightChild = null;
        head = rec;
    }
}
