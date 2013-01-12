package vendingmachine;

public class VendingMachine {

	public int amount;

	public int add(int i) {
		if (i == 1 || i == 5 || i == 2000 || i == 5000 || i == 10000) {
			return i;
		}
		this.amount += i;
		return 0;
	}

	public int getTotalamount() {
		// TODO 自動生成されたメソッド・スタブ
		return this.amount;
	}

	public int payback() {
		int i = this.amount;
		this.amount = 0;
		return i;
	}

}
