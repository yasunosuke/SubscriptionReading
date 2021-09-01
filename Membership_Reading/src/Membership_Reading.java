import java.util.InputMismatchException;
import java.util.Scanner;

public class Membership_Reading {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
//		Writer�N���X�C���X�^���X��
		Writer writer = new Writer("A");
		
//		�L���쐻
		writer.write(scanner);
		
		//		�L���W
		Articles articles = Articles.getInstance();
		
//		�L����o�^
		articles.register(writer.getDoneArticles());
		
//		�S�Ẵ����o�[�̃f�[�^
		Members members = Members.getInstance();
		
		int isPaidMember = 0; /* PaidMember���ǂ�����\�� */
		int canRegister = 0; /* �o�^���邩�ǂ�����\�� */
		int isRegistered = 0; /* �o�^����Ă��邩�ǂ�����\�� */
		Member member = null;
		
		//		�L��������ǂ����̊m�F
		
		for(;;) {
			System.out.println("���Ȃ��͗L������ł����H�͂��u�P�v�@�������u�O�v");
			try {
				isPaidMember = Integer.parseInt(scanner.nextLine());
				if(0 <= isPaidMember && isPaidMember <= 1 ) {
					break;
				} else {
					System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
				}
				
			} catch(NumberFormatException e) {
				System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
			}

		}
		
//version2
//		while(true) {
//			System.out.println("���Ȃ��͗L������ł����H�͂��u�P�v�@�������u�O�v");
//			try {
//				isPaidMember = Integer.parseInt(scanner.nextLine());
//				if(0 <= isPaidMember && isPaidMember <= 1 ) {
//					break;
//				} else {
//					System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
//				}
//				
//			} catch(NumberFormatException e) {
//				System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
//			}
//		}
		
//version1
//		do {
//			boolean isValid  = false;
//			do {
//				System.out.println("���Ȃ��͗L������ł����H�͂��u�P�v�@�������u�O�v");
//				try {
//					isPaidMember = Integer.parseInt(scanner.nextLine());
//					if(0 <= isPaidMember && isPaidMember <= 1 ) {
//						break;
//					} else {
//						System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
//					}
//					
//				} catch(NumberFormatException e) {
//					System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
//				}
//			} while(isValid == false);
//			
//		} while(!(isPaidMember == 1 || isPaidMember ==0));
		
//		�L������̏ꍇ
		if(isPaidMember == 1) {
//			���O�C������
			do {
//				password�擾
				System.out.println("���O�C�����邽�߂̃p�X���[�h����͂��ĉ������B");
				String password = scanner.nextLine();
//				�p�X���[�h�m�Fand���O�C��
				if(!members.confirmPassword(password)) {
					member = members.login(password);
					break;
				} else {
					System.out.println("�p�X���[�h���Ⴂ�܂��B");
				}
			} while(true);
		} else { /*�L������ł͂Ȃ��ꍇ*/
//			����o�^���邩�ǂ����m�F����
			do {
				System.out.println("����o�^���܂����H�͂��u�P�v�@�������u�O�v");
				try {
					canRegister = Integer.parseInt(scanner.nextLine());
					if(0 <= canRegister && canRegister <= 1 ) {
						break;
					} else {
						System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
					}
					
				} catch(NumberFormatException e) {
					System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
				}
				
			} while(true);
			
//			����o�^����ꍇ
			if(canRegister == 1) {
				String name;
//				�o�^���閼�O�擾
				do {
					System.out.println("���O����͂��ĉ������B");
					name = scanner.nextLine();
					if(1 <= name.length() && name.length() <= Member.NAME_LENGTH)
						break;
					else
						System.out.println("1�����ȏ�T�����ȓ��Ɏ��߂Ă��������B");
				} while(true);
				
				do {
					String password;
					//					�o�^����p�X���[�h�擾
					while(true) {
						System.out.println("�o�^���邽�߂̃p�X���[�h����͂��ĉ������B");
						password = scanner.nextLine();
						if(password.matches("[A-Za-z] {1}"))
							break;
						else
							System.out.println("�s���ȃp�X���[�h�ł��B������x���͂��ĉ������B");
					}

					//					�p�X���[�h�d�����Ȃ����m�F
					if(members.confirmPassword(password)) {
						System.out.println("���̃p�X���[�h�͊��Ɏg���Ă��܂��B");
					} else {
						//						�p�X���[�h�d�����Ȃ��ꍇ�o�^and���O�C��
						member = new PaidMember(name, password, articles);
						System.out.println("�o�^���܂����B");
						break;
					}
				} while(true); /*�p�X���[�h�̔�肪�Ȃ��ēo�^�ł���܂Ōp��*/
//			����o�^���Ȃ��ꍇ	
			} else {
				member = new NonePaidMember(articles);
			}
		}
		
		
		
		do {
			int isLogined = 1; /* ���O�C����� �P�E�E�E���O�C�����Ă��� 0�E�E�E���O�C�����Ă��Ȃ� */
			
			/* ���O�A�E�g����܂Ōp�� isLogined = 0 */
//			�L���ꗗ��\��
			System.out.println("�L�����ꗗ��\�����܂��B");
			member.browseAllArticles();

//			�L���ԍ��̎擾�ƋL����
			for(;;) {
 				int articleNum;
 				System.out.println("�ǂ݂����L���ԍ����w�肵�ĉ������B");

 				try {
 					articleNum = Integer.parseInt(scanner.nextLine());
 					if(0 <= articleNum && articleNum <= 1 ) {
 						//			�L����ǂ�
 						member.read(articleNum);
 						break;
 					} else {
 						System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
 					}

 				} catch(NumberFormatException e) {
 					System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
 				}

 			}
			
//			�����ēǂނ��ǂ����̊m�F
			do {
				System.out.println("�����ēǂ݂܂����H�͂��u�P�v�@�������u�O�v");

				try {
					isLogined = Integer.parseInt(scanner.nextLine());
					if(0 <= isLogined && isLogined <= 1 ) {
						break;
					} else {
						System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
					}

				} catch(NumberFormatException e) {
					System.out.println("�s���Ȓl�����͂���܂����B������x���͂��ĉ������B");
				}
			} while(true);

//			���O�A�E�g
			if(isLogined == 0) {
				System.out.println("���O�A�E�g���܂��B");
				break;
			}
		} while(true); /* ���O�A�E�g����܂Ōp�� isLogined = 0 */
		
		
	}

}
