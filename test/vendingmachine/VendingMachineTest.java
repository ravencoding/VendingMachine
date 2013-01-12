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
		int actual = sut.getTotalamount();
		assertThat(actual, is(10));
	}

	@Test
	public void _50円玉が投入されているかを確認() {
		sut.add(50);
		int actual = sut.getTotalamount();
		assertThat(actual, is(50));
	}

	@Test
	public void _100円玉が投入されているかを確認() {
		sut.add(Money._100);
		int actual = sut.getTotalamount();
		assertThat(actual, is(100));
	}

	@Test
	public void _500円玉が投入されているかを確認() {
		sut.add(500);
		int actual = sut.getTotalamount();
		assertThat(actual, is(500));
	}

	@Test
	public void _1000円玉が投入されているかを確認() {
		sut.add(1000);
		int actual = sut.getTotalamount();
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
	
	@Test
	public void _1円玉を投入すると1円玉が帰ってくる() throws Exception {
		int actual = sut.add(Money._1);
		assertThat(actual ,is(1));
	}
	
	@Test
	public void _100円玉を投入すると0が帰ってくる() throws Exception {
		int actual = sut.add(100);
		assertThat(actual ,is(0));
	}
	
	@Test
	public void _5円玉を投入すると5円玉が帰ってくる() throws Exception {
		int actual = sut.add(5);
		assertThat(actual ,is(5));
	}
	
	@Test
	public void 二千円札を投入すると二千円札が帰ってくる() throws Exception {
		int actual = sut.add(2000);
		assertThat(actual ,is(2000));
	}
	
	@Test
	public void 五千円札を投入すると五千円札が帰ってくる() throws Exception {
		int actual = sut.add(5000);
		assertThat(actual ,is(5000));
	}
	
	@Test
	public void 一万円札を投入すると一万円札が帰ってくる() throws Exception {
		int actual = sut.add(10000);
		assertThat(actual ,is(10000));
	}
	
	@Test
	public void _1円玉を投入しても金額に加算しない() throws Exception {
		assertThat("投入前",sut.getTotalamount(),is(0));
		sut.add(1);
		int actual = sut.getTotalamount();
		assertThat("投入後",actual ,is(0));
	}
	
	@Test
	public void _5円玉を投入しても金額に加算しない() throws Exception {
		assertThat("投入前",sut.getTotalamount(),is(0));
		sut.add(5);
		int actual = sut.getTotalamount();
		assertThat("投入後",actual ,is(0));
	}
	
	@Test
	public void _10円玉列挙型にリファクタリングする() throws Exception {
		sut.add(Money._10);
		int actual = sut.getTotalamount();
		assertThat(actual, is(10));
	}

	@Test
	public void _50円玉列挙型にリファクタリングする() throws Exception {
		sut.add(Money._50);
		int actual = sut.getTotalamount();
		assertThat(actual, is(50));
	}
	
	
}
