package cn.oo.demo.pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleMatcherTest {

    @Test
    public void testSimpleMatcher() {
        Matcher m = Pattern.compile("\\w+").matcher("");
        System.out.println(m.pattern().pattern());
        Assert.assertEquals(m.pattern().pattern(), "\\w+");
    }

}
