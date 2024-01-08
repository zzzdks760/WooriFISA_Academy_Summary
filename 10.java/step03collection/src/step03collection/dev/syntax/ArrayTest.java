package step03collection.dev.syntax;

public class ArrayTest {

	public static void main(String[] args) {
		Mouse mini = new Mouse(10, "미니", "하와이", "구직중");
		Mouse mickey = new Mouse(25, "미키", "런던", "맨체스터 유나이티드");
		Mouse jay = new Mouse(15, "제이", "상하이", "텐센트");
		Mouse jerry = new Mouse(20, "제리", "도쿄", "라인");
		Mouse jamie = new Mouse(40, "제이미", "대한민국", "삼성");

		Mouse[] array = new Mouse[5];
		array[0] = mini;
		array[1] = mickey;
		array[2] = jay;
		array[3] = jerry;
		array[4] = jamie;
		// Mouse[] array = {mini, mickey, jay, jerry, jamie};

		// 쥐 조회
		for (Mouse mouse : array) {
			System.out.println(mouse);
		}
		System.out.println();

		// 쥐 수정 - jay의 거주지를 프랑스, 회사를 루브르 박물관으로 변경한 후 확인하기.
		System.out.println("쥐 정보 수정");
		jay.setAddress("프랑스");
		jay.setCompany("루브르 박물관");
		System.out.println(array[2]);
		System.out.println();
		
		System.out.println("쥐 정보 조회");
		System.out.println("jerry의 회사 : " + array[3].getCompany());
		System.out.println();

		// 쥐 정보 삭제 - jay, jamie의 정보를 삭제.
		System.out.println("쥐 정보 삭제");
		array[2] = null;
		System.out.println(array[2]);

		array[4] = null;
		System.out.println(array[4]);
		System.out.println();

		// 쥐 조회
		for (Mouse mouse : array) {
			System.out.println(mouse);
		} // 인덱스가 틈틈이 비어있음
	}

}
