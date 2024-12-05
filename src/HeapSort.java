import java.util.Arrays;

public class HeapSort {
    /*
    - 힙 정렬
    - 최대 힙 : 부모 노드가 항상 자식 노드보다 크거나 같은 값을 가짐
    - 최소 힙 : 부모 노드가 항상 자식 노드보다 작거나 같은 값을 가짐
    - 주어진 배열을 최대 힙으로 변환 -> 가장 큰 값이 루트에 위치하도록 재구성
    - 루트를 배열의 마지막 위치로 이동 -> 남은 힙을 다시 최대 힙으로 재구성 -> 반복하여 배열이 정렬될 때까지 진행
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. 주어진 배열을 최대 힙으로 변환
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
            System.out.println("힙 구성 중: " + Arrays.toString(arr));
        }

        // 2. 하나씩 힙에서 요소를 꺼내 배열 끝에 배치
        for (int i = n - 1; i > 0; i--) {
            // 현재 루트(최대값)를 배열 끝으로 이동
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            System.out.println("최대값 이동 후: " + Arrays.toString(arr));

            // 힙 재구성
            heapify(arr, i, 0);
            System.out.println("힙 재구성 후: " + Arrays.toString(arr));
        }
    }

    // 최대 힙을 구성하는 함수
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;  // 부모 노드의 인덱스
        int left = 2 * i + 1;  // 왼쪽 자식 노드의 인덱스
        int right = 2 * i + 2;  // 오른쪽 자식 노드의 인덱스

        // 왼쪽 자식이 더 큰 경우
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 오른쪽 자식이 더 큰 경우
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 가장 큰 값이 부모 노드가 아니라면 교환
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // 재귀적으로 힙 재구성
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        System.out.println("초기 배열: " + Arrays.toString(arr));
        heapSort(arr); // 힙 정렬 수행
        System.out.println("Sorted array: " + Arrays.toString(arr)); // 정렬된 배열 출력
    }
}
