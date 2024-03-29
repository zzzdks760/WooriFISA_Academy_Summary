package dev.mvc.steo03.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.mvc.steo03.model.Mouse;

@Service
public class MouseService {
	
	private static List<Mouse> mice;
	
	static {
		Mouse mini = new Mouse(10, "미니", "하와이", "구직중");
		Mouse mickey = new Mouse(25, "미키", "런던", "맨체스터 유나이티드");
		Mouse jay = new Mouse(15, "제이", "상하이", "텐센트");
		Mouse jerry = new Mouse(20, "제리", "도쿄", "라인");
		Mouse jamie = new Mouse(40, "제이미", "대한민국", "삼성");
		
		Mouse[] mouseArray = { mini, mickey, jay, jerry, jamie };
		
		mice = new ArrayList<>(Arrays.asList(mouseArray));
	}
	
	public List<Mouse> findAll() {
		// DB에서 Mouse 목록 조회 처리 수행했다고 가정
		
		return mice;
	}

	public void add(Mouse mouse) {
		mice.add(mouse);
	}

	// 직접 구현
//	public int delete() {}

//	public int update() {}
}