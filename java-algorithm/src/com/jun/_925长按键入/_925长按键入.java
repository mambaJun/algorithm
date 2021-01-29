package com.jun._925长按键入;

/**
 * @author Jun
 * @date 2020/10/21 上午10:52
 */
public class _925长按键入 {
    public static void main(String[] args) {
        String name = "leelee";
        String typed = "lleeelee";
        System.out.println(isLongPressedName(name, typed));
    }

    private static boolean isLongPressedName(String name, String typed) {
        if (typed == null || typed.length() == 0) return false;

        int nameLen = name.length();
        int typedLen = typed.length();

        int nameIndex = -1;
        int typedIndex = -1;
        while (++nameIndex < nameLen && ++typedIndex < typedLen) {
            if (name.charAt(nameIndex) != typed.charAt(typedIndex)) {
                return false;
            }

            int nameCount = 0;
            while (nameIndex < nameLen - 1 && name.charAt(nameIndex) == name.charAt(nameIndex + 1)) {
                nameCount++;
                nameIndex++;
            }

            int typedCount = 0;
            while (typedIndex < typedLen - 1 && typed.charAt(typedIndex) == typed.charAt(typedIndex + 1)) {
                typedCount++;
                typedIndex++;
            }

            if (nameCount > typedCount) {
                return false;
            }

            if (nameIndex + 1 == nameLen && typedIndex + 1 == typedLen) {
                return true;
            }
        }

        return false;
    }
}
