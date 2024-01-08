package dev.syntax;

public class Finally {

	public static void main(String[] args) {
        method1();
        System.out.println("method1()�� ���� ����, main()���� ����.");
    }

    public static void method1() {
        try {
            System.out.println("method1()�� ȣ�� �Ǿ���.");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("method1()�� finally block�� ���� �Ǿ���.");
        }
    }

}
