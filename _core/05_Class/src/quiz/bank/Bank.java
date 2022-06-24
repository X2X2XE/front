package quiz.bank;

public class Bank {
	private User[] users;
	
	
	public Bank() {
		
	}
	public Bank(int cnt) {
		users = new User[cnt];
	}
	
	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	public void saving(int money, User user) {
		if(money > user.getCashAmount()) {
			System.out.println("소유액이 부족합니다");
		} else{
			user.getAccount().setBalance(user.getAccount().getBalance() + money);
			user.setCashAmount(user.getCashAmount()-money);
			System.out.println("입금 완료");
			System.out.println(user.toString());
			System.out.println(user.getAccount().toString());
		}
		
	}

	public void withdraw(int money, User user) {
		if(money > user.getAccount().getBalance()) {
			System.out.println("계좌 금액이 부족합니다");
		} else {
			user.getAccount().setBalance(user.getAccount().getBalance() - money);
			user.setCashAmount(user.getCashAmount()+ money);
			System.out.println("출금 완료");
			System.out.println(user.toString());
			System.out.println(user.getAccount().toString());
		}
		
	}

	public void transfer(int money, User from, User to) {
		if(from.getAccount().getBalance() >= money) {
			from.getAccount().setBalance(from.getAccount().getBalance()-money);
			to.getAccount().setBalance(to.getAccount().getBalance()+money);
		} else {
			System.out.println("잔액이 부족합니다");
		}
		
	}
	
}
