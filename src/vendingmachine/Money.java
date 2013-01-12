package vendingmachine;

public enum Money {
	_10(10), _50(50), _100(100), _1(1);
	private Money(int value) {
		this.value = value;
	}

	public final int value;

}
