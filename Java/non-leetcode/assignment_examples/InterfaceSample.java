public class Main {
    interface A {
        int aMethod(String s);
    }

    public static void main(String[] args) {
        // A: これは無効なステートメントです。
        // A a = a -> a.length();

        // B: これも無効なステートメントです。
        // A x = y -> {return y;};

        // C: これも無効なステートメントです。
        // A s = "2" -> Integer.parseInt(s);

        // D: これは有効なステートメントです。
        A b = (String s) -> 1;
        System.out.println(b.aMethod("test"));  // 1を出力します。
    }
}
