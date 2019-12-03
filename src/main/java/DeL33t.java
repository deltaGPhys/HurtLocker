public class DeL33t {
    enum L33tSub {
        _48('o'), //0
        _49('l'), //1
        _51('e'), //3
        _52('a'), //4
        _54('b'), //6
        _55('t'), //7
        _33('i'), //!
        //... etc.: can be expanded to more, and works with multiple possibilities per letter
        ;

        private char realChar;

        L33tSub(char value) {
            this.realChar = value;
        }

        public static Character replace(char inChar) {
            for (L33tSub num : L33tSub.values()) {
                if (num.toString().equals("_"+(int)inChar)){
                    return num.realChar;
                }
            }
            return null;
        }
    }

    public static String translate (String word) {
        if (word.length() > 0) {
            StringBuilder translated = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                Character sub = L33tSub.replace(word.charAt(i));
                if (sub != null) {
                    translated.setCharAt(i, sub);
                }
            }
            return StringService.toTitleCase(translated.toString());
        } else {
            return "";
        }

    }
}
