package step02generic.dec.syntax.step02;

import step02generic.dec.syntax.step01.Apple;
import step02generic.dec.syntax.step01.Banana;

public class FirstGeneric {

	public static void main(String[] args) {
		OnlyOneTypeBox<Apple> appleBox = new OnlyOneTypeBox();
		
		Apple apple = new Apple();
		appleBox.set(apple);
		
		Apple appleFromBox = appleBox.get();

		Banana banana = new Banana();
		OnlyOneTypeBox<Banana> bananaBox = new OnlyOneTypeBox();
		
		bananaBox.set(banana);
		Banana bananaFromBox = bananaBox.get();
		
//		Apple apple = (Apple)bananaBox.get();
		
	}

}
