package lesson2;

public class MainClass {
    public static void main(String[] args) {
        String [][] arr = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        ArrayConvertor arrayConvertor = new ArrayConvertor();
        try {
            arrayConvertor.arrayCheck(arr);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
