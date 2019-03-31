import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClass {
    //定义每个数字对应的字符表示的常量
    private static final String[][] NUM0 = new String[][] { { " ", "-", " " }, { "|", " ", "|" }, { " ", " ", " " }, { "|", " ", "|" }, { " ", "-", " " } };
    private static final String[][] NUM1 = new String[][] { { " ", " ", " " }, { " ", " ", "|" }, { " ", " ", " " }, { " ", " ", "|" }, { " ", " ", " " } };
    private static final String[][] NUM2 = new String[][] { { " ", "-", " " }, { " ", " ", "|" }, { " ", "-", " " }, { "|", " ", " " }, { " ", "-", " " } };
    private static final String[][] NUM3 = new String[][] { { " ", "-", " " }, { " ", " ", "|" }, { " ", "-", " " }, { " ", " ", "|" }, { " ", "-", " " } };
    private static final String[][] NUM4 = new String[][] { { " ", " ", " " }, { "|", " ", "|" }, { " ", "-", " " }, { " ", " ", "|" }, { " ", " ", " " } };
    private static final String[][] NUM5 = new String[][] { { " ", "-", " " }, { "|", " ", " " }, { " ", "-", " " }, { " ", " ", "|" }, { " ", "-", " " } };
    private static final String[][] NUM6 = new String[][] { { " ", "-", " " }, { "|", " ", " " }, { " ", "-", " " }, { "|", " ", "|" }, { " ", "-", " " } };
    private static final String[][] NUM7 = new String[][] { { " ", "-", " " }, { " ", " ", "|" }, { " ", " ", " " }, { " ", " ", "|" }, { " ", " ", " " } };
    private static final String[][] NUM8 = new String[][] { { " ", "-", " " }, { "|", " ", "|" }, { " ", "-", " " }, { "|", " ", "|" }, { " ", "-", " " } };
    private static final String[][] NUM9 = new String[][] { { " ", "-", " " }, { "|", " ", "|" }, { " ", "-", " " }, { " ", " ", "|" }, { " ", "-", " " } };
    private static final String[][] option = new String[][] { { " ", " ", " " }, { " ", "●", " " }, { " ", " ", " " }, { " ", "●", " " }, { " ", " ", " " } };

    private static String[][][] numAll = new String[][][] { NUM0, NUM1, NUM2, NUM3, NUM4, NUM5, NUM6, NUM7, NUM8, NUM9 };
    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    public static void main(String[] args) {
        print();
    }

    private static void print() {
        String[][][] newStr = getDateArray();
        //遍历三维数组，并输出
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < newStr.length; k++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(newStr[k][i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 获得把当前时间转化为字符串后的三维数组
     * @return 获得的三维数组
     */
    private static String[][][] getDateArray() {
        //三维数组
        String[][][] dateArray = new String[5][][];
        //当前时间
        String dateStr = sdf.format(new Date());
        //把当前时间转化为一个字符串数组
        char[] dateChars = dateStr.toCharArray();

        //遍历当前时间的字符串数组,将替换后的字符赋值给要返回的三维数组
        for (int i = 0; i < dateChars.length; i++) {
            switch (dateChars[i]) {

                case ':':
                    dateArray[i] = option;
                    break;
                default:
                    dateArray[i] = numAll[Integer.valueOf(String.valueOf(dateChars[i]))];
                    break;
            }
        }
        return dateArray;
    }
}
