package dev.cls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Console {
	private static final BufferedReader br;
	private static final BufferedWriter bw;
	
//	프로그램 시작과 동시에 실행되는 코드들
	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public static String read() {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	public static void print(String s) {
		try {
			bw.write(s);
			bw.flush();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

}
