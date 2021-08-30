class Solution {
    public int solution(String skill, String[] skill_trees) {
        // 1. init
        String pattern = "[^"+skill+"]";
        int res = 0;

        // 2. loop
        for(String s: skill_trees) {
            String r = s.replaceAll(pattern, "");

            if(skill.indexOf(r) == 0) res++;
        }

        return res;
    }
}