class BinarySearchTree {
    TreeNode root;

    public void addArticle(ArticleData article) {
      ArticleNode newArticleNode = new ArticleNode(article.id, article.title, article.author, null);
      for (String key:article.keywords) {
        boolean inserted = insertTreeNode(key, newArticleNode);
        //System.out.printf("%s %s\n", key, inserted);
        if (!inserted) {
          // append the ArticleNode
          appendArticleNode(key, newArticleNode);
        }
      }
    }

    public void appendArticleNode(String keyword, ArticleNode newArticleNode) {
      TreeNode current = root;
      while (current != null) {
        if (keyword.compareTo(current.keyword) < 0) {
          //System.out.printf("Test Left %s %s %d\n", keyword, current.keyword, newArticleNode.id);
          current = current.leftChild;
        }
        else if (keyword.compareTo(current.keyword) > 0) {
          //System.out.printf("Test Right %s %s %d\n", keyword, current.keyword, newArticleNode.id);
          current = current.rightChild;
        }
        else {
          //System.out.printf("Test Equal %s %s %d\n", keyword, current.keyword, newArticleNode.id);
          newArticleNode.next = current.head;
          current.head = newArticleNode;
          return;
        }
      }
    }

    public boolean insertTreeNode(String keyword, ArticleNode newArticleNode) {
      if (root == null) {
        root = new TreeNode(keyword, newArticleNode);
        return true;
      }
      else {
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
          if (keyword.compareTo(current.keyword) < 0) {
            //System.out.printf("Test Left %s %s %d\n", keyword, current.keyword, newArticleNode.id);
            parent = current;
            current = current.leftChild;
          }
          else if (keyword.compareTo(current.keyword) > 0) {
            //System.out.printf("Test Right %s %s %d\n", keyword, current.keyword, newArticleNode.id);
            parent = current;
            current = current.rightChild;
          }
          else {
            //System.out.printf("Test Equal %s %s %d\n", keyword, current.keyword, newArticleNode.id);
            return false;
          }
        }
        if (keyword.compareTo(parent.keyword) < 0) {
          parent.leftChild = new TreeNode(keyword, newArticleNode);
        }
        else if (keyword.compareTo(parent.keyword) > 0) {
          parent.rightChild = new TreeNode(keyword, newArticleNode);
        }
      }
      return true;
    }
    public void print() {
      inOrderPrint(root);
    }

    private void inOrderPrint(TreeNode node) {
      if (node == null) return;
      inOrderPrint(node.leftChild);
      System.out.printf("\n%s\n", node.keyword);
      ArticleNode article = node.head;
      while (article != null) {
        System.out.printf("\t %d | %s | %s-->\n", article.id, article.title, article.author);
        article = article.next;
      }
      inOrderPrint(node.rightChild);
    }

    private void preOrderPrint(TreeNode root) {
      if (root == null) return;
      System.out.printf("%s\n\t", root.keyword);
      ArticleNode article = root.head;
      while (article != null) {
        System.out.printf("%d %s %s-->\n", article.id, article.title, article.author);
        article = article.next;
      }
      inOrderPrint(root.leftChild);
      inOrderPrint(root.rightChild);
    }
}
