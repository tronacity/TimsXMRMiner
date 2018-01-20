import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class getDataFromNPAPI {


	private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36";

	private static final String GET_URL = "https://api.nanopool.org/v1/xmr/balance/";
	
	private static final String myAddress = "43vdUkP4T5FcYkXBvbU99VhS9MtetbeGujhS1NT2BTavEu6WahBzK16ACoGj4A61ah2C27CGBVphq1UkmFP2EHzJ7vcvSh1";


	public static void main(String[] args) throws IOException {

		sendGET();
		System.out.println("GET DONE");
	}

	private static void sendGET() throws IOException {
		URL obj = new URL(GET_URL + myAddress);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}

	}
}
