package vendingmachine;

public class VendingMachine {

	public int amount;

	public void add(int i) {
		// TODO 自動生成されたメソッド・スタブ
		this.amount += i;
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
