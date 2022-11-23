
interface IOne {
	default void name() {
		System.out.println("name from IOne...");
	}
}

interface ITwo {
	default void name() {
		System.out.println("Name from ITwo...");
	}
}

interface IThree {
	default void name() {
		System.out.println("Name from IThree...");
	}
}

class Test implements IOne, ITwo, IThree {

	@Override
	public void name() {
		IOne.super.name();
		ITwo.super.name();
		IThree.super.name();
	}
	
}
public class Diamond {
	public static void main(String[] args) {
		new Test().name();
	}
}
