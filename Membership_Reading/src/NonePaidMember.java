
/**
 * ���������\���N���X
 * 
 *
 */
public class NonePaidMember extends Member {
	
	private int readArticleNumber = 0; /* �ǂ񂾋L���� */
	
	private Articles articles; /* �L���ꗗ */
	
	/**
	 * �R���X�g���N�^
	 * @param articles
	 */
	public NonePaidMember(Articles articles) {
		super("�Q�X�g");
		this.articles = articles;
	}
	
	public void browseAllArticles() {
		articles.displayAllArticles();
	}
	
	/**
	 * �L����ǂރ��\�b�h
	 * �R�L�����������ǂ߂Ȃ�
	 * @param articleNum
	 */
	public void read(int articleNum) {
		
		Article a = articles.getArticle(articleNum);
		
		if(readArticleNumber >= 3 || a.isLimited()) {
			
			if(readArticleNumber >=3)
				System.out.println("�K�萔�ɒB�������߁A�L����ǂ߂܂���B");
			
			if(a.isLimited())
				System.out.println("�L���L���̂��ߓǂ߂܂���B");
			
		} else {
			articles.displayAnArticle(articleNum);
			readArticleNumber++;
		}
	}

}
