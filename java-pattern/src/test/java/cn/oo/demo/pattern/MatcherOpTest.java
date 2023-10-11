package cn.oo.demo.pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherOpTest {

    @Test
    public void testMatchSinglePattern() {
        String s1 = "vnkjslifgoia123aoivcmaiosdjfaio456vmldfjviodf789avoasdmfoi010";
        String s2 = "000vnkjslifgoia123aoivcmaiosdjfaio456vmldfjviodf789avoasdmfoi010";

        Pattern p = Pattern.compile("\\d+");
        Matcher m1 = p.matcher(s1);
        Matcher m2 = p.matcher(s2);

        // 包含字母，全匹配失败
        Assert.assertFalse(m1.matches());
        Assert.assertFalse(m2.matches());

        // 存在数字，有匹配的部分
        Assert.assertTrue(m2.find());
        // 开头部分是否匹配成功
        Assert.assertFalse(m1.lookingAt());
        Assert.assertTrue(m2.lookingAt());

        // 分别取出匹配的部分，每执行一次find()方法，获取一次下一个匹配项的信息
        if (m1.find()) {
            Assert.assertEquals(m1.group(), "123");
            Assert.assertEquals(m1.start(), 12);
            Assert.assertEquals(m1.end(), 15);
        }
        if (m1.find()) {
            Assert.assertEquals(m1.group(), "456");
            Assert.assertEquals(m1.start(), 31);
            Assert.assertEquals(m1.end(), 34);
        }
    }

    @Test
    public void testMatchMultiPattern() {
        String s = "aaa111AAA bbb222 cccccc33CCCCCC  ";

        // 两组匹配内容，用括号()封装
        Pattern p = Pattern.compile("([a-z]+)(\\d+)([A-Z]+)");
        Matcher m = p.matcher(s);

        if (m.find()) {
            // 匹配模式中有三个()子序列，因此捕获组内count为3
            Assert.assertEquals(m.group(), "aaa111AAA");
            Assert.assertEquals(m.group(0), "aaa111AAA");
            Assert.assertEquals(m.groupCount(), 3);

            Assert.assertEquals(m.group(1), "aaa");
            Assert.assertEquals(m.group(2), "111");
            Assert.assertEquals(m.group(3), "AAA");

            Assert.assertEquals(m.start(), 0);
            Assert.assertEquals(m.start(1), 0);
            Assert.assertEquals(m.start(2), 3);
            Assert.assertEquals(m.start(3), 6);

            Assert.assertEquals(m.end(), 9);
            Assert.assertEquals(m.end(1), 3);
            Assert.assertEquals(m.end(2), 6);
            Assert.assertEquals(m.end(3), 9);
        }

        if (m.find()) {
            Assert.assertEquals(m.group(), "cccccc33CCCCCC");
            Assert.assertEquals(m.group(0), "cccccc33CCCCCC");
            Assert.assertEquals(m.groupCount(), 3);

            Assert.assertEquals(m.group(1), "cccccc");
            Assert.assertEquals(m.group(2), "33");
            Assert.assertEquals(m.group(3), "CCCCCC");

            Assert.assertEquals(m.start(), 17);
            Assert.assertEquals(m.start(1), 17);
            Assert.assertEquals(m.start(2), 23);
            Assert.assertEquals(m.start(3), 25);

            Assert.assertEquals(m.end(), 31);
            Assert.assertEquals(m.end(1), 23);
            Assert.assertEquals(m.end(2), 25);
            Assert.assertEquals(m.end(3), 31);
        }
    }


    @Test
    public void testMatcherRegion() {
        String s = "aaa111AAACCCCCC  ";

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        m.region(0, 3);

        Assert.assertFalse(m.find());

        m.region(4, 10);
        if (m.find()) {
            Assert.assertEquals(m.group(), "11");
        }
    }


    @Test
    public void testMatcherReset() {
        String s = "aaa111AAA bbb222 cccccc33CCCCCC  ";

        // 两组匹配内容，用括号()封装
        Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher(s);

        if (m.find()) {
            Assert.assertEquals(m.group(), "aaa");
        }
        if (m.find()) {
            Assert.assertEquals(m.group(), "bbb");
        }
        m.reset();
        if (m.find()) {
            Assert.assertEquals(m.group(), "aaa");
        }
    }

}
