import java.util.Set;
import java.util.HashSet;

/**
 * 有料会員を表すクラス
 * @author yasuhiro
 *
 */
public class PaidMember extends Member {
	
	private static int counter = 0; /* メンバーIDのためのカウンター。インスタンス生成の度に１増える */
	
	private final int memberId; /* 識別番号 */
	
	private String password; 
	
	private Articles articles; /* 記事一覧 */
	
	private Set<Integer> doneArticles = new HashSet<Integer>(); /* 読み終わった記事の記事番号集 */
	
	/**
	 * コンストラクタ
	 * @param password
	 */
	public PaidMember(String name, String password, Articles articles) {
		super(name);
		this.memberId = ++counter;
		this.password = password;
		this.articles = articles;
	}
	
	/**
	 *記事一覧を表示するメソッド。読了済みには「済」マーク
	 */
	public void browseAllArticles() {
//		コピーして渡したほうが良い？
		articles.displayAllArticles(this.doneArticles);
	}

	/**
	 * 記事を読むメソッド
	 * 特定の記事を表示、読んだ記事を登録する。
	 * @override
	 * @param articleNum
	 */
	public void read(int articleNum) {
		articles.displayAnArticle(articleNum);
		registerDoneArticle(articleNum);
	}
	
	/**
	 * 記事を登録するメソッド
	 * @param _articleNum
	 */
	private void registerDoneArticle(int _articleNum) {
		doneArticles.add(_articleNum);
	}
	
	

}
