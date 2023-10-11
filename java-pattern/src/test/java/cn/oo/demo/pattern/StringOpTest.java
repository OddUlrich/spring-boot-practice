package cn.oo.demo.pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOpTest {

    @Test
    public void testStringSplit() {
        String s = "Good morning, ladies and gentleman!";

        // 按空格分割字符串，获取各个单词
        Pattern spacePattern = Pattern.compile("\\s+");

        String[] arr = spacePattern.split(s);
        Assert.assertEquals(arr[0], "Good");
        Assert.assertEquals(arr[1], "morning,");
        Assert.assertEquals(arr[2], "ladies");
        Assert.assertEquals(arr[3], "and");
        Assert.assertEquals(arr[4], "gentleman!");
    }

    @Test
    public void testStringReplacement() {
        String s = "apple-red,banana-yellow,grass-green,sky-blue";

        Pattern p = Pattern.compile("-");
        Assert.assertEquals(p.matcher(s).replaceAll(":"), "apple:red,banana:yellow,grass:green,sky:blue");
        Assert.assertEquals(p.matcher(s).replaceFirst("->"), "apple->red,banana-yellow,grass-green,sky-blue");
    }

    @Test
    public void testStringBuilderAppend(){
        Pattern pattern = Pattern.compile("a|b");
        Matcher matcher = pattern.matcher("aiiiibqqqqqafffffff@here.com");

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        if (matcher.find()) {
            matcher.appendReplacement(sb1, matcher.group());
            Assert.assertEquals(sb1.toString(), "a");
        }
        if (matcher.find()) {
            matcher.appendReplacement(sb1, matcher.group());
            Assert.assertEquals(sb1.toString(), "aiiiib");
        }
        if (matcher.find()) {
            matcher.appendReplacement(sb1, matcher.group());
            Assert.assertEquals(sb1.toString(), "aiiiibqqqqqa");
        }

        matcher.appendTail(sb2);
        Assert.assertEquals(sb2.toString(), "fffffff@here.com");
    }
}
