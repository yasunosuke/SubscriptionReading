import java.time.LocalDate;

/**
 * 記事を表すクラス
 * @author yasuhiro
 *
 */
public class Article {
	private static int counter = 0;
	public static final int TITLE_LENGTH = 5;
	public static final int BODY_LENGTH = 50;
	private final int article_number;
	private String title;
	private LocalDate written_date;
	private boolean limited;
	private String body;
	
	/**
	 * コンストラクタ
	 * インスタンス生成時に記事番号を入れてフィールドを初期化する。
	 * @param title
	 * @param written_date
	 * @param limited
	 * @param body
	 */
	public Article(String title, LocalDate written_date, boolean limited, String body) {
		super();
		this.article_number = ++counter;
		this.title = title;
		this.written_date = written_date;
		this.limited = limited;
		this.body = body;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + article_number;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + (limited ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((written_date == null) ? 0 : written_date.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (article_number != other.article_number)
			return false;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (limited != other.limited)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (written_date == null) {
			if (other.written_date != null)
				return false;
		} else if (!written_date.equals(other.written_date))
			return false;
		return true;
	}




	/**
	 * 記事番号を返すメソッド
	 * @return
	 */
	public int getArticleNumber() {
		return article_number;
	}
	
	/**
	 * この記事の要約を返すメソッド
	 * @return
	 */
	public String getSummaryArticle() {
		
		String isPaid;
		
		if(this.limited == true) {
			isPaid = "有";
		} else {
			isPaid = "無";
		}
		return String.format("%4d%2s%5s%11s ", this.article_number, isPaid, this.title, this.written_date);
	}

	public boolean isLimited() {
		return limited;
	}
	
//	記事を表示するメソッド
	public void displayArticle() {
		
		String isLimited;
		if(this.limited == true) {
			isLimited = "有";
		} else {
			isLimited = "無";
		}
		
		String titles = String.format("%4d%2s%6s%11s ", this.article_number, isLimited, this.title, this.written_date);
		System.out.println(titles);
		
		System.out.print(" ");/* 最初の段落のインデント */
		String[] bitsBody = this.body.split("");
		for(int i = 0; i < bitsBody.length; i++) {
			System.out.print(bitsBody[i]);
			if(i % 24 == 23)
				System.out.println();
		}
		System.out.println();
	}
	
	
	
	
	
	
	
}
