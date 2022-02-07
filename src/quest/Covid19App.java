package quest;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import quest.Covid19Dto.Response.Body.Items.Item;

public class Covid19App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=====한국 확진자 수를 확인합니다. 궁금한 시작 날자를 입력하세요.=====");
        System.out.println("예)2021년 9월 30일의 경우 20210930");
        String startCreateDt = sc.nextLine();
        if (startCreateDt.length() != 8) {
            System.out.println("잘못된 입력입니다.");
            System.exit(0);
        }

        System.out.println("=====한국 확진자 수를 확인합니다. 궁금한 마지막 날자를 입력하세요.=====");
        System.out.println("=====주의! 시작 날자와 같거나 그 이후의 날자를 입력하세요!=====");
        System.out.println("=====예)2022년 1월 10일의 경우 20220110=====");
        String endCreateDt = sc.nextLine();
        if (endCreateDt.length() != 8) {
            System.out.println("잘못된 입력입니다.");
            System.exit(0);
        }
        List<Item> covidList = Covid19Download.getCovidList(startCreateDt, endCreateDt);
        for (int i = 0; i < covidList.size(); i++) {
            System.out.println("======================");
            System.out.println("누적 의심신고 검사자 : " + covidList.get(i).getAccExamCnt());
            System.out.println("등록일시분초 : " + covidList.get(i).getCreateDt());
            System.out.println("사망 수 : " + covidList.get(i).getDeathCnt());
            System.out.println("확진자 수 : " + covidList.get(i).getDecideCnt());
            System.out.println("게시글 번호 : " + covidList.get(i).getSeq());
            System.out.println("기준일 : " + covidList.get(i).getStateDt());
            System.out.println("기준시간 : " + covidList.get(i).getStateTime());
            System.out.println("수정일시분초 : " + covidList.get(i).getUpdateDt());
            System.out.println("======================");
        }

    }
}
