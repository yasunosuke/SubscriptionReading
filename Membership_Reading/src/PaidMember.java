import java.util.Set;
import java.util.HashSet;

/**
 * �L�������\���N���X
 * @author yasuhiro
 *
 */
public class PaidMember extends Member {
	
	private static int counter = 0; /* �����o�[ID�̂��߂̃J�E���^�[�B�C���X�^���X�����̓x�ɂP������ */
	
	private final int memberId; /* ���ʔԍ� */
	
	private String password; 
	
	private Articles articles; /* �L���ꗗ */
	
	private Set<Integer> doneArticles = new HashSet<Integer>(); /* �ǂݏI������L���̋L���ԍ��W */
	
	/**
	 * �R���X�g���N�^
	 * @param password
	 */
	public PaidMember(String name, String password, Articles articles) {
		super(name);
		this.memberId = ++counter;
		this.password = password;
		this.articles = articles;
	}
	
	/**
	 *�L���ꗗ��\�����郁�\�b�h�B�Ǘ��ς݂ɂ́u�ρv�}�[�N
	 */
	public void browseAllArticles() {
//		�R�s�[���ēn�����ق����ǂ��H
		articles.displayAllArticles(this.doneArticles);
	}

	/**
	 * �L����ǂރ��\�b�h
	 * ����̋L����\���A�ǂ񂾋L����o�^����B
	 * @override
	 * @param articleNum
	 */
	public void read(int articleNum) {
		articles.displayAnArticle(articleNum);
		registerDoneArticle(articleNum);
	}
	
	/**
	 * �L����o�^���郁�\�b�h
	 * @param _articleNum
	 */
	private void registerDoneArticle(int _articleNum) {
		doneArticles.add(_articleNum);
	}
	
	

}
