package Softeer.level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://softeer.ai/practice/info.do?idx=1&eid=990&sw_prbl_sbms_sn=148516
 * 근무 시간
 */

/*
10:00 19:00
09:00 15:00
10:00 11:00
11:00 22:00
09:00 15:00
 */
/*
09:17 18:34
09:17 18:34
09:17 18:34
09:17 18:34
09:17 18:34
*/
/*
09:17 19:24
10:11 18:45
09:34 18:27
10:47 15:33
08:47 18:32
*/
public class 근무시간 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sum = 0;

        for(int t = 1; t <= 5; t++){
            st = new StringTokenizer(br.readLine());
            String go = st.nextToken();
            String leave = st.nextToken();

            String[] goArr = go.split(":");
            String[] leaveArr = leave.split(":");

            int leaveMin = Integer.parseInt(leaveArr[0]) * 60 +  Integer.parseInt(leaveArr[1]);
            int goMin = Integer.parseInt(goArr[0]) * 60 + Integer.parseInt(goArr[1]);

            sum += leaveMin - goMin;
        }
        System.out.println(sum);
    }
}