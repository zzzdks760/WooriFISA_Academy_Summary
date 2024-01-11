package dev.syntax.step04facade;

public class HardDrive {
	public byte[] read(long bootSector, int sectorSize) {
		byte[] result = new byte[sectorSize];
		
		System.out.println(String.format("position: %d, data: %d", bootSector, sectorSize));
		
		return result;
	}
}
