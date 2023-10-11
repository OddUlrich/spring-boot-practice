package cn.oo.demo.pattern.utils;

import java.util.regex.Pattern;

public final class PatternConstants {

    private static final Pattern SPECIAL_CHARACTER = Pattern.compile("^[a-zA-Z0-9u4e00-u9fa5]+");
    private static final Pattern LETTERS = Pattern.compile("\\w+");
    private static final Pattern CHINESE_WORD = Pattern.compile("[u4e00-u9fa5]");
    private static final Pattern NUMBER = Pattern.compile("[0-9]");
    private static final Pattern NUMERIC_CHARACTERS = Pattern.compile("^-?\\d+(\\.\\d*)?$");
    private static final Pattern HTML_TAG = Pattern.compile("([^<]*?>)|(<[\\s]*?/[^<]*?>)|(<[^<]*?/[\\s]*?>)");

    private static final Pattern AT = Pattern.compile("[@]");
    private static final Pattern COMMA = Pattern.compile("[,]");
    private static final Pattern C_COMMA = Pattern.compile("[，]");
    private static final Pattern COLON = Pattern.compile("[:]");
    private static final Pattern BLANK = Pattern.compile("[ ]+");
    private static final Pattern SWAP = Pattern.compile("[\n]");

    private static final Pattern SPACE = Pattern.compile("\\s+");
    private static final Pattern DOT = Pattern.compile("\\.");
    private static final Pattern CIRCUMFLEX = Pattern.compile("\\^");
    private static final Pattern VERTICAL_BAR = Pattern.compile("\\|");
    private static final Pattern DOLLAR = Pattern.compile("\\$");

    private PatternConstants() {
    }

}
