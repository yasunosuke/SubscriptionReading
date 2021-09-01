import java.util.LinkedHashMap;
import java.util.Scanner;
import java.time.LocalDate;




/**
 * ライタークラス
 * このクラスは、一人のライターを表します。
 * @author yasuhiro
 *
 */
public class Writer {
	
	/** ライターの名前 */
	private String name;

	/** 書いた記事集*/
	private LinkedHashMap<String, Article> doneArticles = new LinkedHashMap<String, Article>();
	
	/**
	 * コンストラクタ
	 * @param name　ライターの名前
	 */
	public Writer(String name) {
		this.name = name;
	}
	
	public LinkedHashMap<String, Article> getDoneArticles() {
		return doneArticles;
	}
	
	
	/**
	 * 記事を書くメソッド
	 */
	public void write(Scanner sc) {
		
		String title;
		int date;
		boolean constrained;
		String body;
		int isLimited = 0;
		
//		タイトルを取得する
		do {
			System.out.println("タイトルを入力してください（５文字以内）");
		title = sc.nextLine();
		if(1 <= title.length() && title.length() <= Article.TITLE_LENGTH)
			break;
		else
			System.out.println("1文字以上５文字以内に収めてください。");
		} while(true);
		
		
//		現在の日付を取得する
		LocalDate now = LocalDate.now();
		
//		有料・無料記事かを取得する
		while(true) {
			System.out.println("有料記事ですか、それとも無料記事ですか「有料・・・１，無料・・・０」");
			try {
				isLimited = Integer.parseInt(sc.nextLine());
				if(0 <= isLimited && isLimited <= 1 ) {
					if(isLimited == 1) {
						constrained = true;
					} else {
						constrained = false;
					}
					break;
				} else {
					System.out.println("不正な値が入力されました。もう一度入力して下さい。");
				}

			} catch(NumberFormatException e) {
				System.out.println("不正な値が入力されました。もう一度入力して下さい。");
			}
		}

		
		
//		本文を書く
		do {
			System.out.println("本文を書いてください。");
			body = sc.nextLine();
			
			if(body.length() <= Article.BODY_LENGTH) {
				break;
			} else {
				System.out.println("文字数が多すぎます。もう一度入力して下さい。");
			}
		} while(true);
		
		
//		取得したデータを使って記事作製
		Article a = new Article(title, now, constrained, body);
		
//		記事集に登録する
		doneArticles.put(title, a);
	}
	
//TODO rewrite method 書く
//	public void rewrite() {
//		
//	}

}
