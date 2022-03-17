class ArticleNode {
    int id;
    String title;
    String author;
    ArticleNode next;

    ArticleNode(int i, String t, String a, ArticleNode r){
        id = i;
        title = t;
        author = a;
        next = r;
    }
}
