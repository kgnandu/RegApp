import java.util.function.Function;

public class LambdaByteCode {

	public void fun(int delta) {
		Function<String, Integer> fn = (s) -> s.length() + delta;
	}
}
