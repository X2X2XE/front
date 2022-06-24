package quiz.bank;

public class Banker_old {

	public static void main(String[] args) {
//		// 은행계좌 개설하기 2개 (myBA, urBA)
//		User myBA = new User("a",1111, 100);
//		User urBA = new User("b",1112,100);
//		// 잔액 조회 기능 구현
//		System.out.println(myBA.getAccount());
//		System.out.println(urBA.getAccount());
//		// 입금, 출금 기능 구현
//		myBA.setAccount(10000);
//		urBA.setAccount(5000);
//		
//		System.out.println(myBA.getAccount());
//		System.out.println(urBA.getAccount());
		//계좌 개설
		BankAccount myBA = new BankAccount();
		BankAccount urBA = new BankAccount();
		// 다른 계좌
		User me = new User("park", 10000);
		User you = new User("you", 100000);
		
		BankAccount acc1 = new BankAccount();
		BankAccount acc2 = new BankAccount();
		
		me.setAccount(myBA);
		you.setAccount(urBA);
		//잔액 조회
		System.out.println("my계좌 잔액:" + me.getAccount().getBalance());
		System.out.println("your계좌 잔액:" + you.getAccount().getBalance());
		
		// 입금, 출금 기능 구현 => setter의 활용 한계점
		/*
		 * myBA.setBalance(10000); 
		 * urBA.setBalance(50000);
		 * 
		 * myBA.setBalance(-5000); 
		 * urBA.setBalance(-20000);
		 */
		// 입금
		myBA.saving(10000);
		urBA.saving(50000);
		// 다른 방식 입금
		me.getAccount().saving(10000);
		you.getAccount().saving(10000);
		
		// 출금
		myBA.withdraw(5000);
		urBA.withdraw(20000);
		// 다른 방식 출금
		me.getAccount().withdraw(5000);
		you.getAccount().withdraw(20000);
	}

}
