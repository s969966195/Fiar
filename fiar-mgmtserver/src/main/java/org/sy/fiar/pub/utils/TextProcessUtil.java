package org.sy.fiar.pub.utils;

/**
 * 文本处理工具类
 *
 * @author SY
 * @since 2021/7/7 23:15
 */
public class TextProcessUtil {

    public static String stripHtml(String content) {
        content = content.replaceAll("<p .*?>", "");
        content = content.replaceAll("<br\\s*/?>", "");
        content = content.replaceAll("\\<.*?>", "");
        return content;
    }

}
