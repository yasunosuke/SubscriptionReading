import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

class NonePaidMemberTest {

//	name field���K�؂ɏ���������Ă��邩�m���߂邽�߂̃��\�b�h�B
	@Test
	public void testNonePaidMember() throws Exception {
		
		Articles articles = Articles.getInstance();
		Member npm = new NonePaidMember(articles);
		
		assertEquals("�Q�X�g", getMemberName(npm));
	}
	
	 //	Member�N���X�̓���̃t�B�[���h������Ă���
		Field getMemberField(String fieldName) throws Exception {
			Field f = Member.class.getDeclaredField(fieldName);
			f.setAccessible(true);
			return f;
		}
		
	     //	�w�肳�ꂽ�C���X�^���X��name���Ƃ��Ă���
		String getMemberName(Member obj) throws Exception {
			Field f = getMemberField("name");
			return (String) f.get(obj);
		}
		
// TODO articles field �ɏ��������ꂽ�V���O���g���Ǝ��O�Ɏ擾�����V���O���g������v���邩�m���߂�	
	@Test
	void test() throws Exception {
		
		Articles articles = Articles.getInstance();
		NonePaidMember npm = new NonePaidMember(articles);
		
		assertEquals(articles, getNonePaidMemberArticles(npm));
	}
	
//	�w�肳�ꂽ�C���X�^���X��articles���Ƃ��Ă���
	Articles getNonePaidMemberArticles(Member obj) throws Exception {
		Field f = getNonePaidMemberField("articles");
		return (Articles) f.get(obj);
	}
	
//	NonePaidMember�N���X�̓���̃t�B�[���h������Ă���
		Field getNonePaidMemberField(String fieldName) throws Exception {
			Field f = NonePaidMember.class.getDeclaredField(fieldName);
			f.setAccessible(true);
			return f;
		}

}
