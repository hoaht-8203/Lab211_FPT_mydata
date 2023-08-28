package bubbleSortProgram;

public class BubbleSortProgram {
    public static int[] input_arr() {
        System.out.println("----- Input Element -----");
        System.out.println("Input Length Of Array");
        int size = Input.input_int("Enter number: ", 0);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int val = Input.input_int("Enter Number " + (i + 1) + ": ");
            arr[i] = val;
        }

        return arr;
    }

    public static String arrayToString(int[] arr) {
        if (arr.length == 0) {
            return "Array is empty!";
        }

        String data = "";
        for (int val : arr) {
            data = data + "[" + val + "]->";
        }
        return data.substring(0, data.length() - 2);
    }

    public static int[] sortAscending(int[] arr) {
        if (arr.length != 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                boolean swap = false;

                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                        swap = true;
                    }
                }

                if (!swap) break;
            }

        }
        return arr;
    }

    public static int[] sortDescending(int[] arr) {
        if (arr.length != 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                boolean swap = false;

                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] < arr[j + 1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                        swap = true;
                    }
                }

                if (!swap) break;
            }

        }
        return arr;
    }
}
