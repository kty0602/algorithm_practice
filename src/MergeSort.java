import java.util.Arrays;

public class MergeSort {
    /*
    - 병합 정렬
    - 배열을 반으로 나누어 가장 작은 단위로 부할한다. (분할)
    - 나누어진 배열들을 병합하며 정렬한다. 두 배열의 각 원소를 비교하여 크기 순서대로 합친다. (정복)
    - 정렬된 작은 배열들을 합쳐 큰 배열을 만든다. (병합)
     */
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return; // 배열 크기가 1 이하이면 정렬 완료된 것으로 간주

        int mid = arr.length / 2;

        // 좌우 배열 분할
        int[] left = Arrays.copyOfRange(arr, 0, mid);  // 배열 [0]부터 [mid-1]까지
        int[] right = Arrays.copyOfRange(arr, mid, arr.length); // 배열 [mid]부터 끝까지

        System.out.println("분할: " + Arrays.toString(left) + " | " + Arrays.toString(right));

        // 분할 재귀 호출
        mergeSort(left);
        mergeSort(right);

        // 병합
        merge(arr, left, right);
        System.out.println("병합 후: " + Arrays.toString(arr));
        System.out.println("--------------------------------------");
    }

    // 두 배열을 병합하는 메서드
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // 좌우 배열의 원소를 비교하며 병합
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // 왼쪽 배열의 남은 원소 추가
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // 오른쪽 배열의 남은 원소 추가
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {32, 57, 43, 1, 9, 62, 15};
        System.out.println("초기 배열: " + Arrays.toString(arr));
        mergeSort(arr); // 병합 정렬 실행
        System.out.println("최종 정렬: " + Arrays.toString(arr)); // 정렬된 배열 출력
    }
}
