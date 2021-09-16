import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


/**
 * 記事の集まりを表すクラス
 * シングルトン
 * @author yasuhiro
 *
 */
public class Articles {
	
	private static Articles articleSingleton = new Articles();
	
	private Map<Integer, Article> articles = new LinkedHashMap<Integer, Article>();
	/**
	 * コンストラクタ
	 */
	private Articles() {
		
	}
	
	/**
	 * 記事を登録するメソッド
	 * @param writer_articles
	 */
	public void register(Map<String, Article> writer_articles) {
		
		for(String k: writer_articles.keySet()) {
			Article a = writer_articles.get(k);
			int article_num = a.getArticleNumber();
			
			articles.put(article_num, a);
		}
		
	}
	
	/**
	 * 記事一覧を表示するメソッド
	 * ２記事ごとに改行する
	 * 
	 */
	public void displayAllArticles(Set<Integer> doneArticles) {
		
		if(articles.size() < 2) {
			for(Integer a: articles.keySet()) {
				System.out.print(articles.get(a).getSummaryArticle());
			}
			
			System.out.println("");
			
		}
		
		List<Article> ala = new ArrayList<Article>();
		
		for(Integer k: articles.keySet()) {
			
			Article a = articles.get(k);
			ala.add(a);
			
			if(ala.size() == 2) {
				
				for(int i = 0; i < 2; i++) {
					
					for(Integer j: doneArticles) {
						if(ala.get(i).getArticleNumber() == j) {
							System.out.print("済");
						}
					}
					
					String s = ala.get(i).getSummaryArticle();
					System.out.print(s);
				}
				
				System.out.println("");
				
				System.out.println("----------------------");
				
				ala.clear();
			}
		}
	}
	
	public void displayAllArticles() {
		
		if(articles.size() < 2) {
			for(Integer a: articles.keySet()) {
				System.out.print(articles.get(a).getSummaryArticle());
			}
			
			System.out.println("");
			
		}
		
		List<Article> ala = new ArrayList<Article>();

		for(Integer k: articles.keySet()) {

			Article a = articles.get(k);
			ala.add(a);

			if(ala.size() == 2) {

				for(int i = 0; i < 2; i++) {
					String s = ala.get(i).getSummaryArticle();
					System.out.print(s);
				}

				System.out.println("");

				System.out.println("----------------------");

				ala.clear();
			}
		}
	}
	
	/**
	 * 1つの記事を表示するメソッド
	 * @param article_num
	 */
	public void displayAnArticle(int article_num) {
		articles.get(article_num).displayArticle();
	}
	
	/**
	 * 記事を取得するメソッド
	 * @param article_num
	 * @return
	 */
	public Article getArticle(int article_num) {
		return articles.get(article_num);
	}
	

	/**
	 * このインスタンスを返すメソッド
	 * @return
	 */
	public static Articles getInstance() {
		return articleSingleton;
	}
	
	


}
