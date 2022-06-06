import java.util.*;

class  Main
{
    public static int fnc(int[] list, int max) {
        if (list.length == 0)
            return max;

        if (list[0] > max) {
            max = list[0];
            int newArr[] = Arrays.copyOfRange(list, 1, list.length);
            return fnc(newArr, max);
        }
        else {
            int newArr[] = Arrays.copyOfRange(list, 1, list.length);
            return fnc(newArr, max);
        }
    }

    public static List<Integer> tournam(int[] list, List<Integer> winners) {
        if (list.length % 2 != 0) {
            return winners;
        }
        if (list.length == 0){
            List<Integer> nList = new ArrayList<Integer>();
            int[] new_list = new int[winners.size()];
            for (int i = 0; i < winners.size()-1; i++) {
                new_list[i] = winners.get(i);
            }
            if (winners.size() == 2) {
                List<Integer> end = new ArrayList<Integer>();
                if (winners.get(0) > winners.get(1)) {
                    end.add(winners.get(0));
                    return end;
                }
                else {
                    end.add(winners.get(0));
                    return end;
                }
            }
            return tournam(new_list, nList);
        }

        if (list[0] > list[1]){
            winners.add(list[0]);
            int newA[] = Arrays.copyOfRange(list, 2, list.length);
            return tournam(newA, winners);
        }
        if (list[0] < list[1]) {
            winners.add(list[1]);
            int newA[] = Arrays.copyOfRange(list, 2, list.length);
            return tournam(newA, winners);
        }
        else {
            winners.add(list[0]);
            int newA[] = Arrays.copyOfRange(list, 2, list.length);
            return tournam(newA, winners);
        }
    }

    public static String longest(String input) {
        char[] ch = new char[input.length()];
        for(int i = 0; i < input.length(); i++){
            ch[i] = input.charAt(i);
        }
        Hashtable<Character, Integer> dict = new Hashtable<Character, Integer>();
        for(int i = 0; i < ch.length; i++){
            if(dict.containsKey(ch[i])){
                int count = dict.get(ch[i]);
                count+=1;
                dict.replace(ch[i], count);
            }
            else {
                dict.put(ch[i], 1);
            }
        }
        System.out.println(dict);
        return "";
    }

    public static int[] twosum(int[] nums, int target){
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] + nums[i+1] == target)
            {
                res[0] = i;
                res[1] = i+1;
                return res;
            }
        }
        return new int[]{0, 0};
    }

    public static int[] addtwo(int[] l1, int[] l2)
    {
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();
        for (int i = l1.length-1; i >= 0; i--){
            n1.append(l1[i]);
        }
        for (int i = l2.length-1; i >= 0; i--){
            n2.append(l2[i]);
        }
        int num1 = Integer.parseInt(String.valueOf(n1));
        int num2 = Integer.parseInt(String.valueOf(n2));

        int res = num1 + num2;
        String result = Integer.toString(res);
        StringBuilder res_str = new StringBuilder();
        for (int i = result.length()-1; i >= 0; i--) {
            res_str.append(result.charAt(i));
        }
        int[] res_int = new int[res_str.length()];
        for (int i = 0; i < res_str.length(); i++) {
            res_int[i] = Integer.parseInt(String.valueOf(res_str.charAt(i)));
        }
        return res_int;

    }

    public static int[] exchanger(int[] money, int howm){
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> money_din = new ArrayList<Integer>();
        for(int i = 0; i < money.length; i++) {
            money_din.add(money[i]);
        }
        res = exc(money_din, res, howm);
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static ArrayList<Integer> exc(ArrayList<Integer> money, ArrayList<Integer> res, int howm) {
        if (money.get(money.size()-1) > howm){
            return res;
        }
        int curr_m = howm;
        for(int i = 0; i < money.size(); i++) {
            if(money.get(i) <= curr_m) {
                res.add(money.get(i));
                curr_m -= money.get(i);
                return exc(money, res, curr_m);
            }
        }
        if (money.get(money.size()-1) == howm)
        {
            res.add(money.get(money.size()-1));
            return res;
        }
        return res;
    }

    public static int[] nth(int[] input, int nth) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] res = new int[input.length-1];
        for(int i = 0; i < input.length; i++) {
            if(i != nth){
                arr.add(input[i]);
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }

        return res;
    }

    public static String thread_n_needle(String thread, String needle)
    {
        String[] str = thread.split(" ");
        ArrayList<String> sorted = new ArrayList<String>();
        for (int i = 0; i < str.length; i++)
        {
            if (!str[i].equals(needle)) {
                sorted.add(str[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sorted.size(); i++)
        {
            if (i == sorted.size()-1)
                res.append(sorted.get(i));
            else
                res.append(sorted.get(i)).append(" ");
        }
        return res.toString();
    }

    public static String multiply_strings(String num1, String num2)
    {
        int inum1 = Integer.parseInt(num1);
        int inum2 = Integer.parseInt(num2);
        int res = inum1 * inum2;
        return String.valueOf(res);
    }

    public static int trap(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1],arr[i]);
            System.out.println(left[i]);
        }
        System.out.println(Arrays.toString(left));

        right[n-1]= arr[n-1];
        for(int i = n-2; i >= 0; i--){
            right[i] = Math.max(right[i+1],arr[i]);
        }
        System.out.println(Arrays.toString(right));

        int ans = 0;
        for(int i=0; i<n; i++){
            ans += (Math.min(left[i],right[i])-arr[i]);
        }

        return ans;
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<Integer> shfl = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            shfl.add(nums[i]);
        }
        int combinations = factorial(nums.length);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        while (res.size() != combinations) {
            Collections.shuffle(shfl);
            if (!res.contains(shfl)) {
                ArrayList<Integer> inside = new ArrayList<Integer>(shfl);
                res.add(inside);
            }
        }
        return res;
    }

    public static int factorial(int num) {
        int fact = 1;
        for(int i = 1; i <= num; i++){
            fact = fact * i;
        }
        return fact;
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        if (strs.length == 0){
            return "";
        }

        for (int i = 0; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }

        return prefix;
    }

    public static int[] maxInMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++){
            int max = matrix[i][0];
            for (int j = 0; j < matrix.length;j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            res.add(max);
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static int container(int[] arr)
    {
        ArrayList<Integer> cont = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            cont.add(arr[i]);
        }
        int res = cont_rec(cont, cont.get(0), 0);
        return res;
    }

    public static int cont_rec(ArrayList<Integer> arr, int current_max, int val) {
        // manual here
        if (arr.size() == 2) {
            if (arr.get(0) < arr.get(1)) {
                if(arr.get(1) < current_max) {
                    val -= arr.get(1);
                }

            }
            else if (arr.get(0) > arr.get(1)) {
                if(val < 0) {
                    val = 0;
                }
            }
            else {
                val -= current_max;
            }
            return val;
        }

        int next_el = arr.get(1);
        if(next_el > current_max) {
            current_max = next_el;
        }
        else if (next_el < current_max) {
            val += current_max - next_el;
            if(val < 0) {
                val = 0;
            }
        }

        arr.remove(0);

        return cont_rec(arr, current_max, val);
    }

    public static void main(String args[])  //static method  
    {
//        int[] a = {11,5,2,7,8,3,7,4};
//        List<Integer> list = new ArrayList<Integer>();
//        System.out.println(tournam(a, list));
//        String str = "szovegggmaai";
//        System.out.println(longest(str));

//        int[] nums = {3, 2, 4};
//        System.out.println(Arrays.toString(twosum(nums, 5)));

//        int[] l1 = {9,9,9,9,9,9,9};
//        int[] l2 = {9,9,9,9};
//        System.out.println(Arrays.toString(addtwo(l1, l2)));

//        int[] money = {100, 50, 20, 10, 5};
//        int howmuch = 455;
//        System.out.println(Arrays.toString(exchanger(money, howmuch)));

//        System.out.println(Arrays.toString(nth(new int[]{1, 2, 3, 4, 5}, 2)));

//        System.out.println(thread_n_needle("Haza hoztam 2 tojast a boltbol", "tojast"));

//        System.out.println(multiply_strings("5", "6"));

//        System.out.println(trap(new int[]{1,0,1,5,2,0,6,2,5}));

//        System.out.println(permute(new int[]{1,2,3}));

//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

//        System.out.println(Arrays.toString(maxInMatrix(new int[][]{
//                {1,8,3},
//                {6,7,5},
//                {6,7,4}
//        })));
        // 0,0,0,0,1,3,2,3,1,3 -> 3
        // 2,0,0,0,1,3,2,3,1,3 -> 10
        // 1,0,1,3,2,3,1 -> 2
        // 1,0,1,3,2,3,1,4 -> 4
        // 2,1,0,2,3,2,1,2 -> 4
        // 3,2,1,0,2,3,2,1,2,3 -> 11
        System.out.println(container(new int[]{2,0,0,0,1,3,2,3,1,3}));
    }
}