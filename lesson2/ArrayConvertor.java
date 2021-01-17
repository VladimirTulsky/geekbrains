package lesson2;

public class ArrayConvertor {

    protected void arrayCheck (String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr.length != 4 | arr[i].length != 4) {
                    throw new MyArraySizeException("Размер массива не соответствует 4х4");
                }
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Массив не содержит число в ячейке " + i + " " + j);
                }
            }
        }
        System.out.println(sum);
    }

}