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
			int articleNum = a.getArticleNumber();
			
			articles.put(articleNum, a);
		}
		
	}
	
	/**
	 * 記事一覧を表示するメソッド
	 * ２記事ごとに改行する
	 * 
	 */
	public void displayAllArticles(Set<Integer> doneArticles) {
		
//		TODO 下の処理if-elseで書く、articleの記事数が２よりも少ない時、上いif文だけではなく下のfor文も実行されてしまうから
//		TODO articleのsizeが０の時の処理（上のif文）
		
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
	 * @param articleNum
	 */
	public void displayAnArticle(int articleNum) {
		articles.get(articleNum).displayArticle();
	}
	
	/**
	 * 記事を取得するメソッド
	 * @param articleNum
	 * @return
	 */
	public Article getArticle(int articleNum) {
		return articles.get(articleNum);
	}
	

	/**
	 * このインスタンスを返すメソッド
	 * @return
	 */
	public static Articles getInstance() {
		return articleSingleton;
	}
	
	


}
