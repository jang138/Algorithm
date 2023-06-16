package test1;

import java.util.Arrays;
import java.util.StringTokenizer;

public class test1 {

	public static void main(String[] args) throws Exception {
		String str = "hi my name is david kim";
		StringTokenizer st = new StringTokenizer(str);

		String strArr[] = new String[st.countTokens()];
		String strSP[] = str.split(" ");

		int index = 0;
		while (st.countTokens() > 0) {
			strArr[index] = st.nextToken();
			index++;
		}

		System.out.println(Arrays.toString(strArr));
		System.out.println(Arrays.toString(strSP));
	}

}
