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
		
		//name field���K�؂ɏ���������Ă��邩�m���߂邽�߂̃��\�b�h�B
		@Test
		public void testNonePaidMember01() throws Exception {

			Articles articles = Articles.getInstance();
			Member npm = new NonePaidMember(articles);

			assertEquals("�Q�X�g", getMemberName(npm));
		}

		//Member�N���X�̓���̃t�B�[���h������Ă���
		Field getMemberField(String fieldName) throws Exception {
			Field f = Member.class.getDeclaredField(fieldName);
			f.setAccessible(true);
			return f;
		}

		//�w�肳�ꂽ�C���X�^���X��name���Ƃ��Ă���
		String getMemberName(Member obj) throws Exception {
			Field f = getMemberField("name");
			return (String) f.get(obj);
		}

		//articles field ��Articles�N���X�̃C���X�^���X�����Ғʂ�ɏ��������ꂽ�����m���߂邽�߂̃��\�b�h	
		@Test
		void testNonePaidMember02() throws Exception {

			Articles articles = Articles.getInstance();
			NonePaidMember npm = new NonePaidMember(articles);

			assertEquals(articles, getNonePaidMemberArticles(npm));
		}

		//�w�肳�ꂽ�C���X�^���X��articles���Ƃ��Ă���
		Articles getNonePaidMemberArticles(Member obj) throws Exception {
			Field f = getNonePaidMemberField("articles");
			return (Articles) f.get(obj);
		}

		//NonePaidMember�N���X�̓���̃t�B�[���h������Ă���
		Field getNonePaidMemberField(String fieldName) throws Exception {
			Field f = NonePaidMember.class.getDeclaredField(fieldName);
			f.setAccessible(true);
			return f;
		}
	}
	
	@Nested
	public class readTest {
		
//		npm Article isLimited ture, false�̏ꍇ
		
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
		
//		readArticleNumber = 3, isLimited = true �̂Ƃ�
		@Nested
		public class ReadArticleNumber3ArticleIsLimitedTrue {
			private final ByteArrayOutputStream out = new ByteArrayOutputStream();
			Member npm;
			
//			SetUp
			@BeforeEach
			public void setUp() throws Exception {
				
//				�L���L�����Z�b�g����
				Article article = ArticleStoreTestHelper.instanciateIsLimitedTrueArticle();
				
				Map<String, Article> doneArticles = new LinkedHashMap<String, Article>();
				doneArticles.put(article.getTitle(), article);
				
//				�L���ԍ����L�[�Ƃ���articles�̃C���X�^���X�ɓo�^
				Articles articles = Articles.getInstance();
				articles.register(doneArticles);
				
//				�C���X�^���X����				
				npm = new NonePaidMember(articles);
//				�����܂ŗL���L���Z�b�g
				
//				���t���N�V����API��readArticleNumber�t�B�[���h�ɂR��ݒ肷��
				Field f = NonePaidMember.class.getDeclaredField("readArticleNumber");
				f.setAccessible(true);
				f.set(npm, 3);
				
//				�W���o�͂�ByteArrayOutputStream�֕ύX
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
				assertEquals("�K�萔�ɒB�������߁A�L����ǂ߂܂���B" + System.lineSeparator() + "�L���L���̂��ߓǂ߂܂���B" + System.lineSeparator(), out.toString());
				
			}
		}
		
		
	}



}
