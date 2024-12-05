import java.util.Arrays;

public class InsertionSort {
    /*
    - 삽입 정렬
    - 주어진 배열에서 가장 작은 원소를 찾아 선택한다..
    - 해당 원소를 배열의 맨 앞 원소와 교환
     */
    public static void insertSort(int[] arr) {
        int n = arr.length;
        System.out.println("최초 배열: " + Arrays.toString(arr));
        System.out.println("--------------------------------------");
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            System.out.println("선택된 값: " + key);

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                System.out.println("이동할 값: " + arr[j] + ", 이동할 위치: arr[" + (j + 1) + "]");
                j--;
            }
            arr[j + 1] = key;
            System.out.println("이동할 값: " + key + ", 이동할 위치: arr[" + (j + 1) + "]");
            System.out.println("현 배열: " + Arrays.toString(arr));
            System.out.println("--------------------------------------");
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 1, 9};
        insertSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
