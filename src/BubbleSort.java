import java.util.Arrays;

public class BubbleSort {
    /*
    - 버블 정렬
    - 인접한 두 원소끼리 비교 후 교환 진행
    - 첫 수행 시 가장 큰 값이 가장 뒤에 위치하게 된다.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 인접한 원소를 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println("교체된 위치: arr[" + j + "] , arr[" + (j + 1) +
                            "] (값: " + arr[j] + " , " + arr[j + 1] + ")");
                    System.out.println("정렬 수행" + Arrays.toString(arr));
                    System.out.println("--------------------------------------");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 12, 18, 1, 8};
        System.out.println("초기 배열: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("최종 정렬: " + Arrays.toString(arr));
    }
}
