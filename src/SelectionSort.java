import java.util.Arrays;

public class SelectionSort {
    /*
    - 선택 정렬
    - 주어진 배열에서 가장 작은 원소를 찾아 선택한다..
    - 해당 원소를 배열의 맨 앞 원소와 교환
     */
    public static void selectSort(int[] arr) {
        int n = arr.length;
        System.out.println("최초 배열: " + Arrays.toString(arr));
        System.out.println("---------------------------------------------");
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // 새로운 최솟값 인덱스 갱신
                }
            }

            if (minIndex != i) { // 교환이 필요한 경우에만 실행
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;

                // 교환된 정보와 배열 상태 출력
                System.out.println("교체된 위치: arr[" + i + "] , arr[" + minIndex +
                        "] (교체된 값: " + arr[i] + " , " + arr[minIndex] + ")");
                System.out.println("현 배열: " + Arrays.toString(arr));
                System.out.println("---------------------------------------------");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 12, 18, 1, 8};
        selectSort(arr);
        System.out.println("최종 정렬: " + Arrays.toString(arr));
    }
}
