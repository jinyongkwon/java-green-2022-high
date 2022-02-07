package quest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class Covid19Test {
    public static void main(String[] args) {
        try {
            URL url = new URL(
                    "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D&pageNo=1&numOfRows=10&startCreateDt=20220110&endCreateDt=20220115&_type=json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            String responseJson = br.readLine();
            System.out.println(responseJson);

            Gson gson = new Gson();
            Covid19Dto dto = gson.fromJson(responseJson, Covid19Dto.class);
            System.out.println("다운받은 아이템 개수:" + dto.getResponse().getBody().getTotalCount());
            String resultCode = dto.getResponse().getHeader().getResultCode();
            if (resultCode.equals(" 00")) {
                System.out.println("resultCode : " + resultCode);
                System.out.println("통신이 정상적으로 수행되지 않았습니다.");
                return;
            }
            int totalCount = dto.getResponse().getBody().getTotalCount();
            if (totalCount == 0) {
                System.out.println("통신의 결과가 0건입니다.");
                return;
            }
            for (int i = 0; i < dto.getResponse().getBody().getTotalCount(); i++)
                System.out.println("현재상황 :" + dto.getResponse().getBody().getItems().getItem().get(i).getDecideCnt());

        } catch (Exception e) {
            System.out.println("정보를 가져오지 못했습니다." + e.getMessage());
            e.printStackTrace();
        }
    }
}
