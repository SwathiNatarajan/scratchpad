package dynamicProgramming;

import java.util.*;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        findAllPermutation(res, nums, new ArrayList(), visited);
        return res;
    }

    void findAllPermutation(List<List<Integer>> res, int[] nums, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            curr.add(nums[i]);
            visited[i] = true;
            findAllPermutation(res, nums, curr, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {

        int test = "23".charAt(0)-'0';
        Permutation permutation = new Permutation();
    //    System.out.println(permutation.permute(new int[]{1, 2, 3}));
        System.out.println(permutation.letterCombination("23") );
    }

    public List<String> letterCombination(String digit) {
        Map<Character, Character[]> lookUp = new HashMap<>();
        lookUp.put('2', new Character[]{'a', 'b', 'c'});
        lookUp.put('3', new Character[]{'d', 'e', 'f'});
        lookUp.put('4', new Character[]{'g', 'h', 'i'});
        lookUp.put('5', new Character[]{'j', 'k', 'l'});
        lookUp.put('6', new Character[]{'m', 'n', 'o'});
        lookUp.put('7', new Character[]{'p', 'q', 'r', 's'});
        lookUp.put('8', new Character[]{'t', 'u', 'v'});
        lookUp.put('9', new Character[]{'w', 'x', 'y', 'z'});

        List<Character> variables = new ArrayList<>();

        for (int i = 0; i < digit.length(); i++) {
           variables.addAll(List.of(lookUp.get(digit.charAt(i))));
        }

        return permute(variables);
    }

    private List<String> permute(List<Character> variables) {
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[variables.size()];
        findAllPermutation(result, variables, new ArrayList<>() , visited);
        return result;
    }

    private void findAllPermutation(List<String> result, List<Character> variables, ArrayList<Character> curr, boolean[] visited) {
        if (curr.size() == 2) {
            result.add(curr.toString());
            return;
        }

        for (int i = 0; i < variables.size(); i++) {
            if(visited[i]){
                continue;
            }
            curr.add(variables.get(i));
            visited[i]=true;
            findAllPermutation(result,variables,curr,visited);
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
}
