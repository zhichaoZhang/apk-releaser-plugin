package me.yamlee.apkrelease;

/**
 * @Description: 文本工具类
 * @Author: joye
 * @CreateDate: 2019-11-18 17:08
 * @ProjectName: apk-releaser-plugin
 * @Package: me.yamlee.apkrelease
 * @ClassName: WordUtils
 */
public class WordUtils {
    public static String capitalize(String str) {
        return capitalize(str, (char[])null);
    }

    public static String capitalize(String str, char[] delimiters) {
        int delimLen = delimiters == null ? -1 : delimiters.length;
        if (str != null && str.length() != 0 && delimLen != 0) {
            int strLen = str.length();
            StringBuffer buffer = new StringBuffer(strLen);
            boolean capitalizeNext = true;

            for(int i = 0; i < strLen; ++i) {
                char ch = str.charAt(i);
                if (isDelimiter(ch, delimiters)) {
                    buffer.append(ch);
                    capitalizeNext = true;
                } else if (capitalizeNext) {
                    buffer.append(Character.toTitleCase(ch));
                    capitalizeNext = false;
                } else {
                    buffer.append(ch);
                }
            }

            return buffer.toString();
        } else {
            return str;
        }
    }

    private static boolean isDelimiter(char ch, char[] delimiters) {
        if (delimiters == null) {
            return Character.isWhitespace(ch);
        } else {
            int i = 0;

            for(int isize = delimiters.length; i < isize; ++i) {
                if (ch == delimiters[i]) {
                    return true;
                }
            }

            return false;
        }
    }
}
