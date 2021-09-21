
/**
 * 無料会員を表すクラス
 * 
 *
 */
public class NonePaidMember extends Member {
	
	private int readArticleNumber = 0; /* 読んだ記事数 */
	
	private Articles articles; /* 記事一覧 */
	
	/**
	 * コンストラクタ
	 * @param articles
	 */
	public NonePaidMember(Articles articles) {
		super("ゲスト");
		this.articles = articles;
	}
	
	public void browseAllArticles() {
		articles.displayAllArticles();
	}
	
	/**
	 * 記事を読むメソッド
	 * ３記事よりも多く読めない
	 * @param article_num
	 */
	public void read(int article_num) {
		
		Article a = articles.getArticle(article_num);
		
		if(readArticleNumber >= 3 || a.isLimited()) {
			if(readArticleNumber >=3)
				System.out.println("規定数に達したため、記事を読めません。");
			
			if(a.isLimited())
				System.out.println("有料記事のため読めません。");
		} else {
			articles.displayAnArticle(article_num);
			readArticleNumber++;
		}
	}

}
