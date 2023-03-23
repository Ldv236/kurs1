public class Questions {

    public static void main(String[] args) {

        boolean bool = true;
        int int1 = 0;
        int int2 = 1;

        if (bool) {
            //true
        } else if (int1 < int2) {
            //true compare int
        } else {
            //other
        }

        bool = (int1 > int2 ? true : false);

        switch (int1) {
            case 0:
                bool = true;
                break;
            case 1:
                bool = false;
                break;
            default:
                bool = !bool;
        }
        ;

        bool = switch (int1) {
            case 0 -> true;
            case 1 -> false;
            default -> !bool;
        };

        int[] intMas = new int[]{1, 2, 3, 4, 5};

        for (int itmas : intMas) {
            //do something
        }

        String str1 = "asdsa";
        String str2 = "asddsa";
        String str3 = "asdfg";
        char chchchar = str1.charAt(1);

        char[] charArray = str1.toCharArray();
        System.out.println(checkPalindrome(charArray));
        System.out.println(charArray.length / 2);
    }

    public static boolean checkPalindrome (char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;

            }
        }
        return true;
    }

    /*
    Пару моментов подсвечу:
    Строку не обязательно приводить к массиву. Можно воспользоваться методом charAt у строки.
    Проверка на длину в начале тоже не обязательная. Для строк длиною 0 и 1 цикл просто не выполнится и сразу вернётся true.
    Ну и по мелочи - забыл закрывающую круглую скобку в условном операторе
    */
}
