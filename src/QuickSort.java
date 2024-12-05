import java.util.Arrays;

public class QuickSort {
    /*
    - 퀵 정렬
    - 배열에서 pivot을 기준점으로 선택
    - pivot 기준으로 왼쪽에는 pivot보다 작은 값, 오른쪽은 큰 값들이 위치하도록 배열을 분할
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗을 기준으로 배열을 분할하고 피벗의 위치를 반환
            int pi = partition(arr, low, high);

            System.out.println("분할 완료: " + Arrays.toString(arr) + " (피벗 위치: " + pi + ")");
            System.out.println("-----------------------------------------------------------");

            // 피벗을 기준으로 왼쪽과 오른쪽 배열을 재귀적으로 정렬
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // 배열을 분할하고 피벗의 최종 위치를 반환하는 메서드
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 배열의 마지막 요소를 피벗으로 선택
        int i = (low - 1); // 작은 요소들의 끝 인덱스를 저장

        for (int j = low; j < high; j++) {
            // 현재 요소가 피벗보다 작거나 같으면
            if (arr[j] <= pivot) {
                i++;

                // i와 j 위치의 값을 교환
                System.out.println("교환: arr[" + i + "] = " + arr[j] + ", arr[" + j + "] = " + arr[i]);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println("교환 후 배열 상태: " + Arrays.toString(arr));
            }
        }

        // 피벗을 적절한 위치로 이동
        System.out.println("피벗 교환: arr[" + (i + 1) + "] = " + arr[high] + ", arr[" + high + "] = " + arr[i + 1]);
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        System.out.println("피벗 이동 후 배열 상태: " + Arrays.toString(arr));
        return i + 1; // 피벗의 최종 위치 반환
    }

    public static void main(String[] args) {
        int[] arr = {25, 189, 37, 102, 18, 250, 70, 300};
        quickSort(arr, 0, arr.length - 1); // 퀵 정렬 수행
        System.out.println("최종 정렬: " + Arrays.toString(arr)); // 정렬된 배열 출력
    }
}
