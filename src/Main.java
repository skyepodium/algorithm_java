import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) {



    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int x: nums) {
            if(!s.contains(x)) s.add(x);
            else return true;
        }

        return false;
    }
}