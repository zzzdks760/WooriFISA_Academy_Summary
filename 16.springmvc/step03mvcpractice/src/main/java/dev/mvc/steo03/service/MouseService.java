package dev.mvc.steo03.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.mvc.steo03.model.Mouse;

public class MouseService {
	
	private static List<Mouse> mice;
	
	static {
		Mouse mini = new Mouse(10, "�̴�", "�Ͽ���", "������");
		Mouse mickey = new Mouse(25, "��Ű", "����", "��ü���� ������Ƽ��");
		Mouse jay = new Mouse(15, "����", "������", "�ټ�Ʈ");
		Mouse jerry = new Mouse(20, "����", "����", "����");
		Mouse jamie = new Mouse(40, "���̹�", "���ѹα�", "�Ｚ");
		
		Mouse[] mouseArray = { mini, mickey, jay, jerry, jamie };
		
		mice = new ArrayList<>(Arrays.asList(mouseArray));
	}
	
	public List<Mouse> findAll() {
		// DB���� Mouse ��� ��ȸ ó�� �����ߴٰ� ����
		
		return mice;
	}

	public void add(Mouse mouse) {
		mice.add(mouse);
	}

	// ���� ����
//	public int delete() {}

//	public int update() {}
}