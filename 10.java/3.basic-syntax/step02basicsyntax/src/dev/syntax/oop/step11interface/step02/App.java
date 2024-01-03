package dev.syntax.oop.step11interface.step02;

public class App {

	public static void main(String[] args) {
		Audio audio = new Audio();
		audio.musicPlay(new Bts());
		
		System.out.println("다음 노래 재생");
		audio.musicPlay(new Joy());
		
		/**
		 * 1. 음악을 재생할 수 있는 Audio클래스
		 * - musicPlay(??)
		 * 
		 * 2. 음악 CD 클래스(Bts, Joy)
		 * 
		 * 3. 음악 CD는 혼자서는 재생 못함. Playable이라는 인터페이스 필요
		 * - play();
		 * 
		 * 음악 CD에게 재생할 수 있는 능력을 부여
		 */
	}

}
