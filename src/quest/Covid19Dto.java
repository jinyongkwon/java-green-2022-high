package quest;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Covid19Dto {
    private Response response;

    @AllArgsConstructor
    @Data
    class Response {
        private Header header;
        private Body body;

        @AllArgsConstructor
        @Data
        class Header {
            private String resultCode;// 결과 코드
            private String resultMsg;// 결과 메시지
        }

        @AllArgsConstructor
        @Data
        class Body {
            private int pageNo;// 페이지 번호
            private int numOfRows;// 한 페이지 결과 수
            private int totalCount;// 나온 결과의 총 수
            private String startCreateDt;// 데이터 생성일 시작범위
            private String endCreateDt;// 데이터 생성일 종료범위
            private Items items;

            @AllArgsConstructor
            @Data
            class Items {

                private List<Item> item;

                @AllArgsConstructor
                @Data
                class Item {
                    private Integer accExamCnt;// 누적 의심신고 검사자
                    private String createDt;// 등록일시분초
                    private String deathCnt;// 사망 수
                    private String decideCnt;// 확진자 수
                    private Integer seq;// 게시글번호
                    private Integer stateDt;// 기준일
                    private String stateTime;// 기준시간
                    private String updateDt;// 수정일시분초
                }

            }

        }

    }
}
