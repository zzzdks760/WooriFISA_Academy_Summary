package step02generic.dec.syntax.step02;

public class OnlyOneTypeBox<T> {
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
	
	
}
