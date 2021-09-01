import java.util.LinkedHashMap;
import java.util.Scanner;
import java.time.LocalDate;




/**
 * ���C�^�[�N���X
 * ���̃N���X�́A��l�̃��C�^�[��\���܂��B
 * @author yasuhiro
 *
 */
public class Writer {
	
	/** ���C�^�[�̖��O */
	private String name;

	/** �������L���W*/
	private LinkedHashMap<String, Article> doneArticles = new LinkedHashMap<String, Article>();
	
	/**
	 * �R���X�g���N�^
	 * @param name�@���C�^�[�̖��O
	 */
	public Writer(String name) {
		this.name = name;
	}
	
	public LinkedHashMap<String, Article> getDoneArticles() {
		return doneArticles;
	}
	
	
	/**
	 * �L�����������\�b�h
	 */
	public void write(Scanner sc) {
		
		String title;
		int date;
		boolean constrained;
		String body;
		int isLimited = 0;
		
//		�^�C�g�����擾����
		do {
			System.out.println("�^�C�g������͂��Ă��������i�T�����ȓ��j");
		title = sc.nextLine();
		if(1 <= title.length() && title.length() <= Article.TITLE_LENGTH)
			break;
		else
			System.out.println("1�����ȏ�T�����ȓ��Ɏ��߂Ă��������B");
		} while(true);
		
		
//		���݂̓��t���擾����
		LocalDate now = LocalDate.now();
		
//		�L���E�����L�������擾����
		while(true) {
			System.out.println("�L���L���ł����A����Ƃ������L���ł����u�L���E�E�E�P�C�����E�E�E�O�v");
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
					System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
				}

			} catch(NumberFormatException e) {
				System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
			}
		}

		
		
//		�{��������
		do {
			System.out.println("�{���������Ă��������B");
			body = sc.nextLine();
			
			if(body.length() <= Article.BODY_LENGTH) {
				break;
			} else {
				System.out.println("���������������܂��B������x���͂��ĉ������B");
			}
		} while(true);
		
		
//		�擾�����f�[�^���g���ċL���쐻
		Article a = new Article(title, now, constrained, body);
		
//		�L���W�ɓo�^����
		doneArticles.put(title, a);
	}
	
//TODO rewrite method ����
//	public void rewrite() {
//		
//	}

}
