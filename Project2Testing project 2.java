import java.util.ArrayList;
import java.io.*;

class Project2Testing {
    BufferedReader fileReader;
    BinarySearchTree bst;
    public static void main(String [] args) {
      Project2Testing Test = new Project2Testing("datafile.txt");
      //System.out.println("I will stay focused!");
      Test.bst.print();
    }

    public Project2Testing(String filename) {
      try {
        bst = new BinarySearchTree();
        fileReader = new BufferedReader(new FileReader(filename));

        ArticleData article;
        while ((article = readNextRecord()) != null) {
          bst.addArticle(article);
        }
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }

    public ArticleData readNextRecord() {
      if (fileReader == null) {
        System.out.println("Error: You must open the file first.");
        return null;
      }
      else {
        ArticleData article;
        try{
          String data = fileReader.readLine();
          if (data==null)
            return null;
          int titleId = Integer.parseInt(data);
          String title = fileReader.readLine();
          String author = fileReader.readLine();
          int numKeys = Integer.parseInt(fileReader.readLine());
          article = new ArticleData(titleId, title, author, numKeys);

          String keyword;
          for (int  i=0; i<numKeys; i++) {
            keyword = fileReader.readLine();
            article.addKeyword(keyword);
          }
          // we can add testing for space later; for now read the blank line
          fileReader.readLine();
        }
        catch(NumberFormatException e) {
          System.out.println("Error: Number expected!");
          return null;
        }
        catch(Exception e){
          System.out.println("Fatal Error: " + e);
          return null;
        }
        return article;
      }
    }










}
