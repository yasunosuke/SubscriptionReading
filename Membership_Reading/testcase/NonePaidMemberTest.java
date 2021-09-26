import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class NonePaidMemberTest {
	
	@Nested
	public class InstanciatingTest {
		
		//name fieldが適切に初期化されているか確かめるためのメソッド。
		@Test
		public void testNonePaidMember01() throws Exception {

			Articles articles = Articles.getInstance();
			Member npm = new NonePaidMember(articles);

			assertEquals("ゲスト", getMemberName(npm));
		}

		//Memberクラスの特定のフィールドを取ってくる
		Field getMemberField(String fieldName) throws Exception {
			Field f = Member.class.getDeclaredField(fieldName);
			f.setAccessible(true);
			return f;
		}

		//指定されたインスタンスのnameをとってくる
		String getMemberName(Member obj) throws Exception {
			Field f = getMemberField("name");
			return (String) f.get(obj);
		}

		//articles field にArticlesクラスのインスタンスが期待通りに初期化されたかを確かめるためのメソッド	
		@Test
		void testNonePaidMember02() throws Exception {

			Articles articles = Articles.getInstance();
			NonePaidMember npm = new NonePaidMember(articles);

			assertEquals(articles, getNonePaidMemberArticles(npm));
		}

		//指定されたインスタンスのarticlesをとってくる
		Articles getNonePaidMemberArticles(Member obj) throws Exception {
			Field f = getNonePaidMemberField("articles");
			return (Articles) f.get(obj);
		}

		//NonePaidMemberクラスの特定のフィールドを取ってくる
		Field getNonePaidMemberField(String fieldName) throws Exception {
			Field f = NonePaidMember.class.getDeclaredField(fieldName);
			f.setAccessible(true);
			return f;
		}
	}
	
	@Nested
	public class readTest {
		
//		npm Article isLimited ture, falseの場合
		
		@Nested
		public class NullPointerExceptionTest {
			Member npm;
			
			@BeforeEach
			public void setUp() throws Exception {
				
				Article article = ArticleStoreTestHelper.instantiateArticle();
				Map<String, Article> doneArticles = new LinkedHashMap<String, Article>();
				Articles articles = Articles.getInstance();
				articles.register(doneArticles);
				npm = new NonePaidMember(articles);
			
			}
			
			@Test
			public void testNullPointerException() throws Exception {
				assertThrows(NullPointerException.class, () -> npm.read(2));
			}
		}
		
//		readArticleNumber = 3, isLimited = true のとき
		@Nested
		public class ReadArticleNumber3ArticleIsLimitedTrue {
			private final ByteArrayOutputStream out = new ByteArrayOutputStream();
			Member npm;
			
//			SetUp
			@BeforeEach
			public void setUp() throws Exception {
				
//				有料記事をセットする
				Article article = ArticleStoreTestHelper.instanciateIsLimitedTrueArticle();
				
				Map<String, Article> doneArticles = new LinkedHashMap<String, Article>();
				doneArticles.put(article.getTitle(), article);
				
//				記事番号をキーとしてarticlesのインスタンスに登録
				Articles articles = Articles.getInstance();
				articles.register(doneArticles);
				
//				インスタンス生成				
				npm = new NonePaidMember(articles);
//				ここまで有料記事セット
				
//				リフレクションAPIでreadArticleNumberフィールドに３を設定する
				Field f = NonePaidMember.class.getDeclaredField("readArticleNumber");
				f.setAccessible(true);
				f.set(npm, 3);
				
//				標準出力をByteArrayOutputStreamへ変更
				System.setOut(new PrintStream(out));
			}
			
			@AfterEach
			public void clearUpStream() throws Exception {
//				TearDown
				System.setOut(null);
			}
			
			@Test
			public void testReadReadArticleNumber3ArticleIsLimitedTrue() throws Exception {
//				Exercise
				npm.read(1);
//				Verify			
				assertEquals("規定数に達したため、記事を読めません。" + System.lineSeparator() + "有料記事のため読めません。" + System.lineSeparator(), out.toString());
				
			}
		}
		
		
	}



}
