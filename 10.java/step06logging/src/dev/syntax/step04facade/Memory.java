package dev.syntax.step04facade;

public class Memory {
	public void load(long position, byte[] data) {
		System.out.println(String.format("position: %d, data: %d", position, data));
	}
}
