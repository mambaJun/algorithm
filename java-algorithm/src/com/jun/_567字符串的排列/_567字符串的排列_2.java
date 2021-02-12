package com.jun._567字符串的排列;

/**
 * @author Jun
 * @date 2021/2/10 下午4:20
 */
public class _567字符串的排列_2 {
    class Solution {

        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length();
            int len2 = s2.length();
            if (len1 > len2) {
                return false;
            }
            int[] exist = new int[256];
            int existCount = len1;
            for (char temp : s1.toCharArray()) {
                exist[temp]++;
            }

            char[] array2 = s2.toCharArray();
            int left = 0, right = 0;
            while (right < len2) {
                //存在
                if (exist[array2[right++]]-- > 0) {
                    existCount--;
                }

                while (existCount == 0) {
                    if (right - left == len1) {
                        return true;
                    }

                    if (exist[array2[left++]]++ == 0) {
                        existCount++;
                    }
                }
            }
            return false;
        }
        // =======================================================//
        // 对tmap进行优化， 即窗口滑动时只使用一个tmap
        // public boolean checkInclusion(String s1, String s2) {

        //     int[] map = new int[26];
        //     countFreq(s1, map);
        //     int left = 0;
        //     int right = left + s1.length();
        //     int len = s2.length();
        //     while(right <= len){
        //         String t = s2.substring(left, right);
        //         int[] tmap = new int[26];
        //         countFreq(t, tmap);
        //         int i = 0 ;
        //         for(; i < 26;i++){
        //             if(tmap[i] != map[i])
        //                 break;
        //         }
        //         if(i == 26) return true;
        //         left++;
        //         right++;
        //     }
        //     return false;

        // }

        public void countFreq(String s, int[] map) {
            if (s == null) return;
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i) - 'a']++;
            }
        }


        // =======================================================//
        // 数组充当map
        // public boolean checkInclusion(String s1, String s2) {

        //     int[] map = new int[26];
        //     countFreq(s1, map);
        //     int left = 0;
        //     int right = left + s1.length();
        //     int len = s2.length();
        //     int[] tmap = new int[26];
        //     while(right <= len){
        //         String t = s2.substring(left, right);

        //         countFreq(t, tmap);
        //         int i = 0 ;
        //         for(; i < 26;i++){
        //             if(tmap[i] != map[i])
        //                 break;
        //         }
        //         if(i == 26) return true;
        //         left++;
        //         right++;
        //     }
        //     return false;

        // }

        // public void countFreq(String s, int[] map){
        //     if(s == null) return;
        //     for(int i = 0 ; i < s.length(); i++){
        //         map[s.charAt(i) - 'a']++;
        //     }
        // }
// =======================================================//
        //    // 超出内存限制
        // public boolean checkInclusion(String s1, String s2) {
        //     List<String> container =  new ArrayList<>();
        //     StringBuilder sb = new StringBuilder();
        //     boolean[] isUsed = new boolean[s1.length()];
        //     generate(s1, container, sb, isUsed);
        //     int left = 0;
        //     int right = left + s1.length();
        //     int len = s2.length();
        //     while(right <= len){
        //         if(container.contains(s2.substring(left, right) ) ){
        //             return true;
        //         }
        //         left++;
        //         right++;
        //     }
        //     return false;
        // }
        //
        // public void generate(String s1, List<String> res, StringBuilder curres,  boolean[] isUsed){
        //     if(curres.length() == s1.length()){
        //         res.add(curres.toString());
        //         return;
        //     }
        //     for(int i = 0; i < s1.length(); i++){
        //         if(isUsed[i]) continue;

        //         curres.append(s1.charAt(i));
        //         isUsed[i] = true;
        //         generate(s1, res, curres, isUsed);
        //         curres.deleteCharAt(curres.length() - 1);
        //         isUsed[i] = false;
        //     }
        // }
    }
}

