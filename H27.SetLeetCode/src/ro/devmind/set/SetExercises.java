package ro.devmind.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExercises {
	public int singleNumber(int[] nums) {
        Set<Integer> num = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if(num.contains(curr)) {
                num.remove(curr);
            } else {
                num.add(curr);
            }
        }
        
        return num.stream().findFirst().get();
    }
	
	public int numJewelsInStones(String J, String S) {
        int result = 0;
        Set<Character> jewels = new HashSet<>();
        for(Character c : J.toCharArray()) {
            jewels.add(c);
        }
        
        for(Character stone : S.toCharArray()) {
            if(jewels.contains(stone)) {
                result++;
            }
        }
        
        return result;
    }
	
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        
        for(int num : nums2) {
            if(set.contains(num)) {
                result.add(num);
                set.remove(num);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
	
	public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        Set<Character>[] rows = new HashSet[3];
        for(int i = 0; i < rows.length; i++) {
            rows[i] = new HashSet<Character>();
        }
        for(Character c : "qwertyuiop".toCharArray()) {
            rows[0].add(c);
        }
        for(Character c : "asdfghjkl".toCharArray()) {
            rows[1].add(c);
        }
        for(Character c : "zxcvbnm".toCharArray()) {
            rows[2].add(c);
        }
        
        for(String word : words) {
            result.add(word);
            word = word.toLowerCase();
            Set<Character> currRow = null;
            for(Set<Character> row : rows) {
                if(row.contains(word.charAt(0))) {
                    currRow = row;
                    break;
                }
            }
            for(int i = 0; i < word.length(); i++) {
                if(!currRow.contains(word.charAt(i))) {
                    result.remove(result.size() - 1);
                    break;
                }
            }
        }
        
        return result.toArray(new String[0]);
    }
	
	public int distributeCandies(int[] candies) {
        Set<Integer> res = new HashSet<>();
        int max = candies.length / 2;
        for(int candy : candies) {
            if(!res.contains(candy)) {
                res.add(candy);
            }
        }
        
        return res.size() > max ? max : res.size();
    }
	
	public boolean containsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for(int num : nums) {
            if(res.contains(num)) {
                return true;
            }
            res.add(num);
        }
        
        return false;
    }
}
