package dev.syntax;

public class Finally {

	public static void main(String[] args) {
        method1();
        System.out.println("method1()의 수행 종료, main()으로 복귀.");
    }

    public static void method1() {
        try {
            System.out.println("method1()이 호출 되었음.");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("method1()의 finally block이 실행 되었음.");
        }
    }

}
