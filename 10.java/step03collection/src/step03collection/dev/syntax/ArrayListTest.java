package step03collection.dev.syntax;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		Mouse mini = new Mouse(10, "미니", "하와이", "구직중");
		Mouse mickey = new Mouse(25, "미키", "런던", "맨체스터 유나이티드");
		Mouse jay = new Mouse(15, "제이", "상하이", "텐센트");
		Mouse jerry = new Mouse(20, "제리", "도쿄", "라인");
		Mouse jamie = new Mouse(40, "제이미", "대한민국", "삼성");

		ArrayList<Mouse> mice = new ArrayList<Mouse>();
		System.out.println(mice);
		mice.add(mini);
		mice.add(mickey);
		mice.add(jay);
		mice.add(jerry);
		mice.add(jamie);

		System.out.println(mice); // [Mouse mini, micky, jay, jerry, jamie]

		// 1번째 인덱스 조회
		System.out.println("list의 첫 번째 요소 : " + mice.get(0));

		// 3번째 요소 삭제
		System.out.println(mice.remove(2) + " 요소 삭제.");
		System.out.println();

		// 전체 요소 조회
		System.out.println("전체 요소 조회");
		for (Mouse mouse : mice) {
			System.out.println(mouse);
		}

		// 제리의 나이를 21살로 수정.
		mice.get(2).setAge(21); // 왜 2번째 인덱스지?
		System.out.println();

		// 수정된 제리의 나이만 조회.
		System.out.println("제리의 나이 : " + mice.get(2).getAge());
		System.out.println();

		// 새로운 쥐 '지니' 추가.
		mice.add(new Mouse(30, "지니", "대한민국", "스타벅스"));

		// 전체 요소 조회
		System.out.println("전체 요소 조회");
		for (Mouse mouse : mice) {
			System.out.println(mouse);
		}
	}
}