package be.jedi.jvncsender;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class VncMappings {

   public static final Map<String, Integer> KEYMAP = createKeyMap();
   public static final Map<String, Integer> SPECIAL_KEYMAP = createSpecialKeyMap();
   public static final Map<String, Integer> MODIFIER_MAP = createModifierMap();
   public static final Map<String, Integer[]> SEQUENCES_MAP = createSequencesMap();
   public static final int WINDOWS_KEY = 0xffeb;

   static void printMaps() {
      for (String key : KEYMAP.keySet()) {
         System.out.println(key);
      }
      for (String key : SPECIAL_KEYMAP.keySet()) {
         System.out.println(key);
      }
      for (String key : MODIFIER_MAP.keySet()) {
         System.out.println(key);
      }
      for (String key : SEQUENCES_MAP.keySet()) {
         System.out.println(key);
      }
   }

   static Map<String, Integer> createKeyMap() {
      Map<String, Integer> keyMap = new HashMap<>();
      
      //lowercase a= 0x0061
      String key = "a";
      
      for (int i = 0; i < 26; i++) {
         int charValue = key.charAt(0);
         keyMap.put(String.valueOf((char) (charValue + i)), 0x0061 + i);
      }

      
      key = "A";
      for (int i = 0; i < 26; i++) {
         int charValue = key.charAt(0);

         keyMap.put(String.valueOf((char) (charValue + i)), 0x0041 + i );
      }
      
      key = "0";
      for (int i = 0; i < 10; i++) {
         int charValue = key.charAt(0);
         keyMap.put(String.valueOf((char) (charValue + i)), 0x0030 + i);
      }

      // builder.put("{", KeyEvent.VK_BRACELEFT);
      // builder.put("}", KeyEvent.VK_BRACERIGHT);

      keyMap.put("[", KeyEvent.VK_OPEN_BRACKET);
      keyMap.put("]", KeyEvent.VK_CLOSE_BRACKET);

      // builder.put("$", KeyEvent.VK_DOLLAR);
      keyMap.put("�", KeyEvent.VK_EURO_SIGN);
      // builder.put("!", KeyEvent.VK_EXCLAMATION_MARK);
      keyMap.put("=", KeyEvent.VK_EQUALS);

      // builder.put("<", KeyEvent.VK_LESS);
      // builder.put(">", KeyEvent.VK_GREATER);
      keyMap.put("(", KeyEvent.VK_LEFT_PARENTHESIS);
      keyMap.put(")", KeyEvent.VK_RIGHT_PARENTHESIS);

      keyMap.put("-", KeyEvent.VK_MINUS);

      // builder.put("*", KeyEvent.VK_MULTIPLY);
      // builder.put("#", KeyEvent.VK_NUMBER_SIGN);
      keyMap.put(".", KeyEvent.VK_PERIOD);
      keyMap.put("+", KeyEvent.VK_PLUS);
      keyMap.put("/", KeyEvent.VK_SLASH);

      // builder.put("'", KeyEvent.VK_QUOTE);
      // builder.put("\"", KeyEvent.VK_QUOTEDBL);

      keyMap.put(",", KeyEvent.VK_COMMA);
      // builder.put(":", KeyEvent.VK_COLON);
      keyMap.put(";", KeyEvent.VK_SEMICOLON);
      keyMap.put(" ", KeyEvent.VK_SPACE);
      // builder.put("_", KeyEvent.VK_UNDERSCORE);
      // builder.put("&", KeyEvent.VK_AMPERSAND);
      // builder.put("@", KeyEvent.VK_AT);
      // / builder.put("`", KeyEvent.VK_BACK_QUOTE);
      keyMap.put("\\", KeyEvent.VK_BACK_SLASH);

      return keyMap;

   }

   static Map<String, Integer> createSpecialKeyMap() {
      Map<String, Integer> specialKeyMap = new HashMap<>();

      specialKeyMap.put("<ACCEPT>", KeyEvent.VK_ACCEPT);
      specialKeyMap.put("<ADD>", KeyEvent.VK_ADD);
      // builder.put("<AMPERSAND>", KeyEvent.VK_AMPERSAND);
      specialKeyMap.put("<ASTERISK>", KeyEvent.VK_ASTERISK);
      // builder.put("<AT>", KeyEvent.VK_AT);
      // builder.put("<BACK_QUOTE>", KeyEvent.VK_BACK_QUOTE);
      // builder.put("<BACK_TICK>", KeyEvent.VK_BACK_QUOTE);
      specialKeyMap.put("<BACK_SLASH>", KeyEvent.VK_BACK_SLASH);
      specialKeyMap.put("<BACKSPACE>", KeyEvent.VK_BACK_SPACE);
      // builder.put("<BRACELEFT>", KeyEvent.VK_BRACELEFT);
      // builder.put("<BRACE_RIGHT>", KeyEvent.VK_BRACERIGHT);
      specialKeyMap.put("<CANCEL>", KeyEvent.VK_CANCEL);
      specialKeyMap.put("<CAPS_LOCK>", KeyEvent.VK_CAPS_LOCK);
      specialKeyMap.put("<CIRCUMFLEX>", KeyEvent.VK_CIRCUMFLEX);
      specialKeyMap.put("<CLEAR>", KeyEvent.VK_CLEAR);
      specialKeyMap.put("<CLOSE_BRACKET>", KeyEvent.VK_CLOSE_BRACKET);
      specialKeyMap.put("<CODE_INPUT>", KeyEvent.VK_CODE_INPUT);
      // builder.put("<COLON>", KeyEvent.VK_COLON);
      specialKeyMap.put("<COMMA>", KeyEvent.VK_COMMA);
      specialKeyMap.put("<COMPOSE>", KeyEvent.VK_COMPOSE);
      specialKeyMap.put("<CONTROL>", KeyEvent.VK_CONTROL);
      specialKeyMap.put("<CONVERT>", KeyEvent.VK_CONVERT);
      specialKeyMap.put("<COPY>", KeyEvent.VK_COPY);
      specialKeyMap.put("<CUT>", KeyEvent.VK_CUT);
      specialKeyMap.put("<DEAD_ABOVEDOT>", KeyEvent.VK_DEAD_ABOVEDOT);
      specialKeyMap.put("<DEAD_ABOVERING>", KeyEvent.VK_DEAD_ABOVERING);
      specialKeyMap.put("<DEAD_ACUTE>", KeyEvent.VK_DEAD_ACUTE);
      specialKeyMap.put("<DEAD_BREVE>", KeyEvent.VK_DEAD_BREVE);
      specialKeyMap.put("<DEAD_CARON>", KeyEvent.VK_DEAD_CARON);
      specialKeyMap.put("<DEAD_CEDILLA>", KeyEvent.VK_DEAD_CEDILLA);
      specialKeyMap.put("<DEAD_CIRCUMFLEX>", KeyEvent.VK_DEAD_CIRCUMFLEX);
      specialKeyMap.put("<DEAD_DIAERESIS>", KeyEvent.VK_DEAD_DIAERESIS);
      specialKeyMap.put("<DEAD_DOUBLEACUTE>", KeyEvent.VK_DEAD_DOUBLEACUTE);
      specialKeyMap.put("<DEAD_GRAVE>", KeyEvent.VK_DEAD_GRAVE);
      specialKeyMap.put("<DEAD_IOTA>", KeyEvent.VK_DEAD_IOTA);
      specialKeyMap.put("<DEAD_MACRON>", KeyEvent.VK_DEAD_MACRON);
      specialKeyMap.put("<DEAD_OGONEK>", KeyEvent.VK_DEAD_OGONEK);
      specialKeyMap.put("<DEAD_SEMIVOICED_SOUND>", KeyEvent.VK_DEAD_SEMIVOICED_SOUND);
      specialKeyMap.put("<DEAD_TILDE>", KeyEvent.VK_DEAD_TILDE);
      specialKeyMap.put("<DEAD_VOICED_SOUND>", KeyEvent.VK_DEAD_VOICED_SOUND);
      specialKeyMap.put("<DECIMAL>", KeyEvent.VK_DECIMAL);
      specialKeyMap.put("<DELETE>", KeyEvent.VK_DELETE);
      specialKeyMap.put("<DIVIDE>", KeyEvent.VK_DIVIDE);
      // builder.put("<DOLLAR>", KeyEvent.VK_DOLLAR);
      // builder.put("<DOWN>", KeyEvent.VK_DOWN);
      specialKeyMap.put("<END>", KeyEvent.VK_END);
      specialKeyMap.put("<ENTER>", KeyEvent.VK_ENTER);
      specialKeyMap.put("<RETURN>", 13);

      specialKeyMap.put("<EQUALS>", KeyEvent.VK_EQUALS);
      specialKeyMap.put("<ESCAPE>", KeyEvent.VK_ESCAPE);
      specialKeyMap.put("<ESC>", KeyEvent.VK_ESCAPE);
      specialKeyMap.put("<EURO_SIGN>", KeyEvent.VK_EURO_SIGN);

      specialKeyMap.put("<FINAL>", KeyEvent.VK_FINAL);
      specialKeyMap.put("<FIND>", KeyEvent.VK_FIND);
      specialKeyMap.put("<FULL_WIDTH>", KeyEvent.VK_FULL_WIDTH);
      // builder.put("<GREATER>", KeyEvent.VK_GREATER);
      specialKeyMap.put("<HALF_WIDTH>", KeyEvent.VK_HALF_WIDTH);
      specialKeyMap.put("<HELP>", KeyEvent.VK_HELP);
      specialKeyMap.put("<HIRAGANA>", KeyEvent.VK_HIRAGANA);
      // builder.put("<HOME>", KeyEvent.VK_HOME);
      specialKeyMap.put("<INPUT_METHOD_ON_OFF>", KeyEvent.VK_INPUT_METHOD_ON_OFF);
      specialKeyMap.put("<INSERT>", KeyEvent.VK_INSERT);
      specialKeyMap.put("<INVERTED_EXCLAMATION_MARK>", KeyEvent.VK_INVERTED_EXCLAMATION_MARK);
      specialKeyMap.put("<JAPANESE_HIRAGANA>", KeyEvent.VK_JAPANESE_HIRAGANA);
      specialKeyMap.put("<JAPANESE_KATAKANA>", KeyEvent.VK_JAPANESE_KATAKANA);
      specialKeyMap.put("<JAPANESE_ROMAN>", KeyEvent.VK_JAPANESE_ROMAN);
      specialKeyMap.put("<KANA>", KeyEvent.VK_KANA);
      specialKeyMap.put("<KANA_LOCK>", KeyEvent.VK_KANA_LOCK);
      specialKeyMap.put("<KANJI>", KeyEvent.VK_KANJI);
      specialKeyMap.put("<KATAKANA>", KeyEvent.VK_KATAKANA);
      specialKeyMap.put("<KP_DOWN>", KeyEvent.VK_KP_DOWN);
      specialKeyMap.put("<KP_LEFT>", KeyEvent.VK_KP_LEFT);
      specialKeyMap.put("<KP_RIGHT>", KeyEvent.VK_KP_RIGHT);
      specialKeyMap.put("<KP_UP>", KeyEvent.VK_KP_UP);
      // builder.put("<LEFT>", KeyEvent.VK_LEFT);
      specialKeyMap.put("<LEFT_PARENTHESIS>", KeyEvent.VK_LEFT_PARENTHESIS);
      // builder.put("<LESS>", KeyEvent.VK_LESS);
      specialKeyMap.put("<META>", KeyEvent.VK_META);
      specialKeyMap.put("<MINUS>", KeyEvent.VK_MINUS);
      specialKeyMap.put("<MODECHANGE>", KeyEvent.VK_MODECHANGE);
      // builder.put("<MULTIPLY>", KeyEvent.VK_MULTIPLY);
      specialKeyMap.put("<NONCONVERT>", KeyEvent.VK_NONCONVERT);
      specialKeyMap.put("<NUM_LOCK>", KeyEvent.VK_NUM_LOCK);
      specialKeyMap.put("<NUMLOCK>", KeyEvent.VK_NUM_LOCK);
      // builder.put("<NUMBER_SIGN>", KeyEvent.VK_NUMBER_SIGN);
      // builder.put("<HASH>", KeyEvent.VK_NUMBER_SIGN);
      specialKeyMap.put("<NUMPAD0>", KeyEvent.VK_NUMPAD0);
      specialKeyMap.put("<NUMPAD1>", KeyEvent.VK_NUMPAD1);
      specialKeyMap.put("<NUMPAD2>", KeyEvent.VK_NUMPAD2);
      specialKeyMap.put("<NUMPAD3>", KeyEvent.VK_NUMPAD3);
      specialKeyMap.put("<NUMPAD4>", KeyEvent.VK_NUMPAD4);
      specialKeyMap.put("<NUMPAD5>", KeyEvent.VK_NUMPAD5);
      specialKeyMap.put("<NUMPAD6>", KeyEvent.VK_NUMPAD6);
      specialKeyMap.put("<NUMPAD7>", KeyEvent.VK_NUMPAD7);
      specialKeyMap.put("<NUMPAD8>", KeyEvent.VK_NUMPAD8);
      specialKeyMap.put("<NUMPAD9>", KeyEvent.VK_NUMPAD9);
      specialKeyMap.put("<OPEN_BRACKET>", KeyEvent.VK_OPEN_BRACKET);

      specialKeyMap.put("<PASTE>", KeyEvent.VK_PASTE);
      specialKeyMap.put("<PAUSE>", KeyEvent.VK_PAUSE);
      specialKeyMap.put("<PERIOD>", KeyEvent.VK_PERIOD);
      specialKeyMap.put("<PLUS>", KeyEvent.VK_PLUS);
      specialKeyMap.put("<PREVIOUS_CANDIDATE>", KeyEvent.VK_PREVIOUS_CANDIDATE);
      specialKeyMap.put("<PRINTSCREEN>", KeyEvent.VK_PRINTSCREEN);
      specialKeyMap.put("<PROPS>", KeyEvent.VK_PROPS);
      specialKeyMap.put("<RIGHT_PARENTHESIS>", KeyEvent.VK_RIGHT_PARENTHESIS);
      specialKeyMap.put("<ROMAN_CHARACTERS>", KeyEvent.VK_ROMAN_CHARACTERS);
      specialKeyMap.put("<SCROLL_LOCK>", KeyEvent.VK_SCROLL_LOCK);
      specialKeyMap.put("<SEMICOLON>", KeyEvent.VK_SEMICOLON);
      specialKeyMap.put("<SEPARATER>", KeyEvent.VK_SEPARATER);
      specialKeyMap.put("<SEPARATOR>", KeyEvent.VK_SEPARATOR);
      specialKeyMap.put("<SHIFT>", KeyEvent.VK_SHIFT);
      specialKeyMap.put("<SLASH>", KeyEvent.VK_SLASH);
      specialKeyMap.put("<SPACE>", KeyEvent.VK_SPACE);
      specialKeyMap.put("<STOP>", KeyEvent.VK_STOP);
      specialKeyMap.put("<SUBTRACT>", KeyEvent.VK_SUBTRACT);
      specialKeyMap.put("<TAB>", KeyEvent.VK_TAB);
      specialKeyMap.put("<UNDEFINIED>", KeyEvent.VK_UNDEFINED);
      specialKeyMap.put("<UNDO>", KeyEvent.VK_UNDO);

      return specialKeyMap;
   }

   static Map<String, Integer> createModifierMap() {

      Map<String, Integer> modifierMap = new HashMap<>();

      // writeKeyEvent(0xffe3, (newModifiers & CTRL_MASK) != 0);
      // writeKeyEvent(0xffe1, (newModifiers & SHIFT_MASK) != 0);
      // writeKeyEvent(0xffe7, (newModifiers & META_MASK) != 0);
      // writeKeyEvent(0xffe9, (newModifiers & ALT_MASK) != 0);

      modifierMap.put("<SHIFT>", 0xffe1);
      modifierMap.put("<ALT>", 0xffe9);
      modifierMap.put("<CONTROL>", 0xffe3);
      modifierMap.put("<META>", 0xffe7);

      // builder.put("<SHIFT>", KeyEvent.VK_SHIFT);
      // builder.put("<ALT>", KeyEvent.VK_ALT);
      // builder.put("<CONTROL>", KeyEvent.VK_CONTROL);
      // builder.put("<META>", KeyEvent.VK_META);
      modifierMap.put("<WINDOWS>", WINDOWS_KEY);

      return modifierMap;

   }

   static Map<String, Integer[]> createSequencesMap() {
      Map<String, Integer[]> sequencesMap = new HashMap<>();

      sequencesMap.put("<BACK_TICK>", new Integer[] { KeyEvent.VK_Z + 6 });
      sequencesMap.put("<BACK_QUOTE>", new Integer[] { KeyEvent.VK_Z + 6 });
      sequencesMap.put("`", new Integer[] { KeyEvent.VK_Z + 6 });

      sequencesMap.put("~", new Integer[] { 0xffe1, KeyEvent.VK_Z + 6 });
      sequencesMap.put("<TILDE>", new Integer[] { 0xffe1, KeyEvent.VK_Z + 6 });

      sequencesMap.put("<QUESTION_MARK>", new Integer[] { 0xffe1, KeyEvent.VK_SLASH });
      sequencesMap.put("?", new Integer[] { 0xffe1, KeyEvent.VK_SLASH });
      sequencesMap.put("<PIPE>", new Integer[] { 0xffe1, KeyEvent.VK_BACK_SLASH });
      sequencesMap.put("|", new Integer[] { 0xffe1, KeyEvent.VK_BACK_SLASH });
      sequencesMap.put("<COLON>", new Integer[] { 0xffe1, KeyEvent.VK_SEMICOLON });
      sequencesMap.put(":", new Integer[] { 0xffe1, KeyEvent.VK_SEMICOLON });

      sequencesMap.put("<AMPERSAND>", new Integer[] { 0xffe1, KeyEvent.VK_7 });
      sequencesMap.put("&", new Integer[] { 0xffe1, KeyEvent.VK_7 });

      sequencesMap.put("<EXCLAMATION_MARK>", new Integer[] { 0xffe1, KeyEvent.VK_1 });
      sequencesMap.put("!", new Integer[] { 0xffe1, KeyEvent.VK_1 });
      sequencesMap.put("<AT>", new Integer[] { 0xffe1, KeyEvent.VK_2 });
      sequencesMap.put("@", new Integer[] { 0xffe1, KeyEvent.VK_2 });
      sequencesMap.put("<DOLLAR>", new Integer[] { 0xffe1, KeyEvent.VK_4 });
      sequencesMap.put("$", new Integer[] { 0xffe1, KeyEvent.VK_4 });

      sequencesMap.put("<UNDERSCORE>", new Integer[] { 0xffe1, KeyEvent.VK_MINUS });
      sequencesMap.put("_", new Integer[] { 0xffe1, KeyEvent.VK_MINUS });

      sequencesMap.put("<BRACELEFT>", new Integer[] { 0xffe1, KeyEvent.VK_OPEN_BRACKET });
      sequencesMap.put("{", new Integer[] { 0xffe1, KeyEvent.VK_OPEN_BRACKET });

      sequencesMap.put("<BRACERIGHT>", new Integer[] { 0xffe1, KeyEvent.VK_CLOSE_BRACKET });
      sequencesMap.put("}", new Integer[] { 0xffe1, KeyEvent.VK_CLOSE_BRACKET });

      sequencesMap.put("<PERCENT>", new Integer[] { 0xffe1, KeyEvent.VK_5 });
      sequencesMap.put("%", new Integer[] { 0xffe1, KeyEvent.VK_5 });

      sequencesMap.put("<RETURN>", new Integer[] { 0xff0d });

      sequencesMap.put("<MULTIPLY>", new Integer[] { 0xffe1, 0x2a });
      sequencesMap.put("*", new Integer[] { 0xffe1, 0x2a });

      sequencesMap.put("<QUOTE>", new Integer[] { 0x27 });
      sequencesMap.put("'", new Integer[] { 0x27 });

      sequencesMap.put("<QUOTEDBL>", new Integer[] { 0xffe1, 0x27 });
      sequencesMap.put("\"", new Integer[] { 0xffe1, 0x27 });

      sequencesMap.put("<NUMBER_SIGN>", new Integer[] { 0xffe1, 0x23 });
      sequencesMap.put("#", new Integer[] { 0xffe1, 0x23 });

      sequencesMap.put("<HASH>", new Integer[] { 0xffe1, 0x23 });

      sequencesMap.put("<F1>", new Integer[] { 0xffbe });
      sequencesMap.put("<F2>", new Integer[] { 0xffbf });
      sequencesMap.put("<F3>", new Integer[] { 0xffc0 });
      sequencesMap.put("<F4>", new Integer[] { 0xffc1 });
      sequencesMap.put("<F5>", new Integer[] { 0xffc2 });
      sequencesMap.put("<F6>", new Integer[] { 0xffc3 });
      sequencesMap.put("<F7>", new Integer[] { 0xffc4 });
      sequencesMap.put("<F8>", new Integer[] { 0xffc5 });
      sequencesMap.put("<F9>", new Integer[] { 0xffc6 });
      sequencesMap.put("<F10>", new Integer[] { 0xffc7 });
      sequencesMap.put("<F11>", new Integer[] { 0xffc8 });
      sequencesMap.put("<F12>", new Integer[] { 0xffc9 });
      sequencesMap.put("<F13>", new Integer[] { 0xffca });
      sequencesMap.put("<F14>", new Integer[] { 0xffcb });
      sequencesMap.put("<F15>", new Integer[] { 0xffcc });
      sequencesMap.put("<F16>", new Integer[] { 0xffcd });
      sequencesMap.put("<F17>", new Integer[] { 0xffce });
      sequencesMap.put("<F18>", new Integer[] { 0xffcf });
      sequencesMap.put("<F19>", new Integer[] { 0xffd0 });
      sequencesMap.put("<F20>", new Integer[] { 0xffd1 });
      sequencesMap.put("<F21>", new Integer[] { 0xffd2 });
      sequencesMap.put("<F22>", new Integer[] { 0xffd3 });
      sequencesMap.put("<F23>", new Integer[] { 0xffd4 });
      sequencesMap.put("<F24>", new Integer[] { 0xffd5 });
      sequencesMap.put("<F25>", new Integer[] { 0xffd6 });
      sequencesMap.put("<F35>", new Integer[] { 0xffe0 });

      sequencesMap.put("<HOME>", new Integer[] { 0xff50 });
      sequencesMap.put("<LEFT>", new Integer[] { 0xff51 });
      sequencesMap.put("<UP>", new Integer[] { 0xff52 });
      sequencesMap.put("<RIGHT>", new Integer[] { 0xff53 });
      sequencesMap.put("<DOWN>", new Integer[] { 0xff54 });
      sequencesMap.put("<PAGE_UP>", new Integer[] { 0xff55 });
      sequencesMap.put("<PAGE_DOWN>", new Integer[] { 0xff56 });
      sequencesMap.put("<END>", new Integer[] { 0xff57 });
      sequencesMap.put("<INSERT>", new Integer[] { 0xff63 });

      return sequencesMap;
   }
}
