package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("tmmzuxt");
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0)
            return 0;

        Set<Character> set = new HashSet<>();
        int f = 0, l = 0, res = -1;
        for (f = 0; f < n; f++) {
            char c = s.charAt(f);
            if (set.isEmpty() || !set.contains(c)) {
                set.add(c);
                continue;
            }

            res = Math.max(res, f - l);
            while(l <= f && s.charAt(l) != c) {
                set.remove(s.charAt(l));
                l++;
            }
            l++;
        }
        res = Math.max(res, f - l);
        return res;
    }
}