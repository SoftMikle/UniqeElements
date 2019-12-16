import java.util.Scanner;

public class UniqueArrayElements {
    void mainMethod(){
        int[] array = init();
        int[] temp = new int[array.length];
        int n = array.length;
        array = merge(array, temp, 0, n - 1);
        System.arraycopy(array, 0, temp, 0, n);
        for (int i = 0; i < n - 1; i++) {
            if(temp[i] == temp[i + 1]){
                for (int j = i; j < n - 1; j++) {
                    temp[j] = temp[j + 1];
                }
                n--;
                i--;
            }
        }
        System.out.println("There are " + n + " unique elements in the array.");
        System.out.println("They are:");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + temp[i]);
        }
    }
    private int[] init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array to search");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
    private int[] merge(int[] massive, int[] tmp, int left, int right){
        if(left == right){
            tmp[left] = massive[left];
            return tmp;
        }
        int middle = (left + right) / 2;

        int[] lSide = merge(massive, tmp, left, middle);
        int[] rSide = merge(massive, tmp, middle + 1, right);

        int[] target = lSide == massive ? tmp : massive;

        int lCur = left;
        int rCur = middle + 1;
        for (int i = left; i <= right; i++) {
            if(lCur <= middle && rCur <= right){
                if(lSide[lCur] < rSide[rCur]){
                    target[i] = lSide[lCur];
                    lCur++;
                }
                else {
                    target[i] = rSide[rCur];
                    rCur++;
                }
            }
            else {
                if (lCur <= middle){
                    target[i] = lSide[lCur];
                    lCur++;
                }
                else {
                    target[i] = rSide[rCur];
                    rCur++;
                }
            }
        }
        return target;
    }
}
