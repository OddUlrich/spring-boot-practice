package cn.oo.demo.pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class SimplePatternTest {

    @Test
    public void testPatternMatches() {
        Assert.assertTrue(Pattern.matches("\\d+", "154234"));
        Assert.assertFalse(Pattern.matches("\\d+", "dad154234"));
        Assert.assertFalse(Pattern.matches("aab", "abababababasbdfbcdbfababbabbfd"));
    }

}
