package dev.syntax.step04facade;

public class Computer {
	
	public void boot() {
		CPU cpu = new CPU();
		HardDrive hdd = new HardDrive();
		Memory memory = new Memory();
		
		cpu.freeze();
		memory.load(100, hdd.read(150, 200));
		cpu.execute();
	}
}
