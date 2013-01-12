package vendingmachine;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	private VendingMachine sut;

	@Before
	public void setUp() throws Exception {
		sut = new VendingMachine();
	}

	@Test
	public void _10円玉が投入されているかを確認() {
		sut.add(10);
		int actual = sut.amount;
		assertThat(actual, is(10));
	}

	@Test
	public void _50円玉が投入されているかを確認() {
		sut.add(50);
		int actual = sut.amount;
		assertThat(actual, is(50));
	}

	@Test
	public void _100円玉が投入されているかを確認() {
		sut.add(100);
		int actual = sut.amount;
		assertThat(actual, is(100));
	}

	@Test
	public void _500円玉が投入されているかを確認() {
		sut.add(500);
		int actual = sut.amount;
		assertThat(actual, is(500));
	}

	@Test
	public void _1000円玉が投入されているかを確認() {
		sut.add(1000);
		int actual = sut.amount;
		assertThat(actual, is(1000));
	}

	@Test
	public void 投入されていなかったら0円() throws Exception {
		int actual = sut.getTotalamount();
		assertThat(actual, is(0));
	}

	@Test
	public void _10円が1枚投入されたら10円() throws Exception {
		sut.add(10);
		int actual = sut.getTotalamount();
		assertThat(actual, is(10));
	}

	@Test
	public void _10円が1枚_50円が1枚投入されたら60円() throws Exception {
		sut.add(10);
		sut.add(50);
		int actual = sut.getTotalamount();
		assertThat(actual, is(60));
	}

	@Test
	public void 払い戻し操作を行うと_投入金額の総計をつり銭として出力する() throws Exception {
		sut.add(10);
		sut.add(50);
		int actual = sut.payback();
		assertThat("つり銭", actual, is(60));
		assertThat("総計", sut.getTotalamount(), is(0));
	}
}
