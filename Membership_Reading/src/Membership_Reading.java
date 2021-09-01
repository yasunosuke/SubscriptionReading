import java.util.InputMismatchException;
import java.util.Scanner;

public class Membership_Reading {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
//		Writerクラスインスタンス化
		Writer writer = new Writer("A");
		
//		記事作製
		writer.write(scanner);
		
		//		記事集
		Articles articles = Articles.getInstance();
		
//		記事を登録
		articles.register(writer.getDoneArticles());
		
//		全てのメンバーのデータ
		Members members = Members.getInstance();
		
		int isPaidMember = 0; /* PaidMemberかどうかを表す */
		int canRegister = 0; /* 登録するかどうかを表す */
		int isRegistered = 0; /* 登録されているかどうかを表す */
		Member member = null;
		
		//		有料会員かどうかの確認
		
		for(;;) {
			System.out.println("あなたは有料会員ですか？はい「１」　いいえ「０」");
			try {
				isPaidMember = Integer.parseInt(scanner.nextLine());
				if(0 <= isPaidMember && isPaidMember <= 1 ) {
					break;
				} else {
					System.out.println("不正な値が入力されました。もう一度入力して下さい。");
				}
				
			} catch(NumberFormatException e) {
				System.out.println("不正な値が入力されました。もう一度入力して下さい。");
			}

		}
		
//version2
//		while(true) {
//			System.out.println("あなたは有料会員ですか？はい「１」　いいえ「０」");
//			try {
//				isPaidMember = Integer.parseInt(scanner.nextLine());
//				if(0 <= isPaidMember && isPaidMember <= 1 ) {
//					break;
//				} else {
//					System.out.println("不正な値が入力されました。もう一度入力して下さい。");
//				}
//				
//			} catch(NumberFormatException e) {
//				System.out.println("不正な値が入力されました。もう一度入力して下さい。");
//			}
//		}
		
//version1
//		do {
//			boolean isValid  = false;
//			do {
//				System.out.println("あなたは有料会員ですか？はい「１」　いいえ「０」");
//				try {
//					isPaidMember = Integer.parseInt(scanner.nextLine());
//					if(0 <= isPaidMember && isPaidMember <= 1 ) {
//						break;
//					} else {
//						System.out.println("不正な値が入力されました。もう一度入力して下さい。");
//					}
//					
//				} catch(NumberFormatException e) {
//					System.out.println("不正な値が入力されました。もう一度入力して下さい。");
//				}
//			} while(isValid == false);
//			
//		} while(!(isPaidMember == 1 || isPaidMember ==0));
		
//		有料会員の場合
		if(isPaidMember == 1) {
//			ログインする
			do {
//				password取得
				System.out.println("ログインするためのパスワードを入力して下さい。");
				String password = scanner.nextLine();
//				パスワード確認andログイン
				if(!members.confirmPassword(password)) {
					member = members.login(password);
					break;
				} else {
					System.out.println("パスワードが違います。");
				}
			} while(true);
		} else { /*有料会員ではない場合*/
//			会員登録するかどうか確認する
			do {
				System.out.println("会員登録しますか？はい「１」　いいえ「０」");
				try {
					canRegister = Integer.parseInt(scanner.nextLine());
					if(0 <= canRegister && canRegister <= 1 ) {
						break;
					} else {
						System.out.println("不正な値が入力されました。もう一度入力して下さい。");
					}
					
				} catch(NumberFormatException e) {
					System.out.println("不正な値が入力されました。もう一度入力して下さい。");
				}
				
			} while(true);
			
//			会員登録する場合
			if(canRegister == 1) {
				String name;
//				登録する名前取得
				do {
					System.out.println("名前を入力して下さい。");
					name = scanner.nextLine();
					if(1 <= name.length() && name.length() <= Member.NAME_LENGTH)
						break;
					else
						System.out.println("1文字以上５文字以内に収めてください。");
				} while(true);
				
				do {
					String password;
					//					登録するパスワード取得
					while(true) {
						System.out.println("登録するためのパスワードを入力して下さい。");
						password = scanner.nextLine();
						if(password.matches("[A-Za-z] {1}"))
							break;
						else
							System.out.println("不正なパスワードです。もう一度入力して下さい。");
					}

					//					パスワード重複がないか確認
					if(members.confirmPassword(password)) {
						System.out.println("このパスワードは既に使われています。");
					} else {
						//						パスワード重複がない場合登録andログイン
						member = new PaidMember(name, password, articles);
						System.out.println("登録しました。");
						break;
					}
				} while(true); /*パスワードの被りがなくて登録できるまで継続*/
//			会員登録しない場合	
			} else {
				member = new NonePaidMember(articles);
			}
		}
		
		
		
		do {
			int isLogined = 1; /* ログイン状態 １・・・ログインしている 0・・・ログインしていない */
			
			/* ログアウトするまで継続 isLogined = 0 */
//			記事一覧を表示
			System.out.println("記事を一覧を表示します。");
			member.browseAllArticles();

//			記事番号の取得と記事読
			for(;;) {
 				int articleNum;
 				System.out.println("読みたい記事番号を指定して下さい。");

 				try {
 					articleNum = Integer.parseInt(scanner.nextLine());
 					if(0 <= articleNum && articleNum <= 1 ) {
 						//			記事を読む
 						member.read(articleNum);
 						break;
 					} else {
 						System.out.println("不正な値が入力されました。もう一度入力して下さい。");
 					}

 				} catch(NumberFormatException e) {
 					System.out.println("不正な値が入力されました。もう一度入力して下さい。");
 				}

 			}
			
//			続けて読むかどうかの確認
			do {
				System.out.println("続けて読みますか？はい「１」　いいえ「０」");

				try {
					isLogined = Integer.parseInt(scanner.nextLine());
					if(0 <= isLogined && isLogined <= 1 ) {
						break;
					} else {
						System.out.println("不正な値が入力されました。もう一度入力して下さい。");
					}

				} catch(NumberFormatException e) {
					System.out.println("不正な値が入力されました。もう一度入力して下さい。");
				}
			} while(true);

//			ログアウト
			if(isLogined == 0) {
				System.out.println("ログアウトします。");
				break;
			}
		} while(true); /* ログアウトするまで継続 isLogined = 0 */
		
		
	}

}
