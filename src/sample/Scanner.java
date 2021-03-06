/* The following code was generated by JFlex 1.4.3 on 15.11.16 1:55 */

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 1998-2015  Gerwin Klein <lsf@jflex.de>                    *
 * All rights reserved.                                                    *
 *                                                                         *
 * License: BSD                                                            *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/* Java 1.2 language lexer specification */

/* Use together with unicode.flex for Unicode preprocesssing */
/* and java12.cup for a Java 1.2 parser                      */

/* Note that this lexer specification is not tuned for speed.
   It is in fact quite slow on integer and floating point literals, 
   because the input is read twice and the methods used to parse
   the numbers are not very fast. 
   For a production quality application (e.g. a Java compiler) 
   this could be optimized */

package sample;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 15.11.16 1:55 from the specification file
 * <tt>generator.flex</tt>
 */
public class Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int YYINITIAL = 0;
  public static final int CHARLITERAL = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\7\1\3\1\2\1\0\1\3\1\1\16\7\4\0\1\3\1\57"+
    "\1\21\1\0\1\6\1\57\1\61\1\22\1\53\1\53\1\5\1\63"+
    "\1\53\1\20\1\16\1\4\1\10\11\11\1\60\1\53\1\56\1\54"+
    "\1\55\1\60\1\0\4\14\1\17\1\15\5\6\1\12\13\6\1\13"+
    "\2\6\1\53\1\23\1\53\1\57\1\6\1\0\1\27\1\24\1\31"+
    "\1\42\1\26\1\43\1\50\1\34\1\40\1\6\1\30\1\35\1\52"+
    "\1\37\1\36\1\46\1\6\1\25\1\32\1\33\1\41\1\47\1\45"+
    "\1\51\1\44\1\6\1\53\1\62\1\53\1\60\41\7\2\0\4\6"+
    "\4\0\1\6\2\0\1\7\7\0\1\6\4\0\1\6\5\0\27\6"+
    "\1\0\37\6\1\0\u01ca\6\4\0\14\6\16\0\5\6\7\0\1\6"+
    "\1\0\1\6\21\0\160\7\5\6\1\0\2\6\2\0\4\6\10\0"+
    "\1\6\1\0\3\6\1\0\1\6\1\0\24\6\1\0\123\6\1\0"+
    "\213\6\1\0\5\7\2\0\236\6\11\0\46\6\2\0\1\6\7\0"+
    "\47\6\7\0\1\6\1\0\55\7\1\0\1\7\1\0\2\7\1\0"+
    "\2\7\1\0\1\7\10\0\33\6\5\0\3\6\15\0\5\7\6\0"+
    "\1\6\4\0\13\7\5\0\53\6\37\7\4\0\2\6\1\7\143\6"+
    "\1\0\1\6\10\7\1\0\6\7\2\6\2\7\1\0\4\7\2\6"+
    "\12\7\3\6\2\0\1\6\17\0\1\7\1\6\1\7\36\6\33\7"+
    "\2\0\131\6\13\7\1\6\16\0\12\7\41\6\11\7\2\6\4\0"+
    "\1\6\5\0\26\6\4\7\1\6\11\7\1\6\3\7\1\6\5\7"+
    "\22\0\31\6\3\7\104\0\1\6\1\0\13\6\67\0\33\7\1\0"+
    "\4\7\66\6\3\7\1\6\22\7\1\6\7\7\12\6\2\7\2\0"+
    "\12\7\1\0\7\6\1\0\7\6\1\0\3\7\1\0\10\6\2\0"+
    "\2\6\2\0\26\6\1\0\7\6\1\0\1\6\3\0\4\6\2\0"+
    "\1\7\1\6\7\7\2\0\2\7\2\0\3\7\1\6\10\0\1\7"+
    "\4\0\2\6\1\0\3\6\2\7\2\0\12\7\4\6\7\0\1\6"+
    "\5\0\3\7\1\0\6\6\4\0\2\6\2\0\26\6\1\0\7\6"+
    "\1\0\2\6\1\0\2\6\1\0\2\6\2\0\1\7\1\0\5\7"+
    "\4\0\2\7\2\0\3\7\3\0\1\7\7\0\4\6\1\0\1\6"+
    "\7\0\14\7\3\6\1\7\13\0\3\7\1\0\11\6\1\0\3\6"+
    "\1\0\26\6\1\0\7\6\1\0\2\6\1\0\5\6\2\0\1\7"+
    "\1\6\10\7\1\0\3\7\1\0\3\7\2\0\1\6\17\0\2\6"+
    "\2\7\2\0\12\7\1\0\1\6\17\0\3\7\1\0\10\6\2\0"+
    "\2\6\2\0\26\6\1\0\7\6\1\0\2\6\1\0\5\6\2\0"+
    "\1\7\1\6\7\7\2\0\2\7\2\0\3\7\10\0\2\7\4\0"+
    "\2\6\1\0\3\6\2\7\2\0\12\7\1\0\1\6\20\0\1\7"+
    "\1\6\1\0\6\6\3\0\3\6\1\0\4\6\3\0\2\6\1\0"+
    "\1\6\1\0\2\6\3\0\2\6\3\0\3\6\3\0\14\6\4\0"+
    "\5\7\3\0\3\7\1\0\4\7\2\0\1\6\6\0\1\7\16\0"+
    "\12\7\11\0\1\6\7\0\3\7\1\0\10\6\1\0\3\6\1\0"+
    "\27\6\1\0\12\6\1\0\5\6\3\0\1\6\7\7\1\0\3\7"+
    "\1\0\4\7\7\0\2\7\1\0\2\6\6\0\2\6\2\7\2\0"+
    "\12\7\22\0\2\7\1\0\10\6\1\0\3\6\1\0\27\6\1\0"+
    "\12\6\1\0\5\6\2\0\1\7\1\6\7\7\1\0\3\7\1\0"+
    "\4\7\7\0\2\7\7\0\1\6\1\0\2\6\2\7\2\0\12\7"+
    "\1\0\2\6\17\0\2\7\1\0\10\6\1\0\3\6\1\0\51\6"+
    "\2\0\1\6\7\7\1\0\3\7\1\0\4\7\1\6\10\0\1\7"+
    "\10\0\2\6\2\7\2\0\12\7\12\0\6\6\2\0\2\7\1\0"+
    "\22\6\3\0\30\6\1\0\11\6\1\0\1\6\2\0\7\6\3\0"+
    "\1\7\4\0\6\7\1\0\1\7\1\0\10\7\22\0\2\7\15\0"+
    "\60\6\1\7\2\6\7\7\4\0\10\6\10\7\1\0\12\7\47\0"+
    "\2\6\1\0\1\6\2\0\2\6\1\0\1\6\2\0\1\6\6\0"+
    "\4\6\1\0\7\6\1\0\3\6\1\0\1\6\1\0\1\6\2\0"+
    "\2\6\1\0\4\6\1\7\2\6\6\7\1\0\2\7\1\6\2\0"+
    "\5\6\1\0\1\6\1\0\6\7\2\0\12\7\2\0\4\6\40\0"+
    "\1\6\27\0\2\7\6\0\12\7\13\0\1\7\1\0\1\7\1\0"+
    "\1\7\4\0\2\7\10\6\1\0\44\6\4\0\24\7\1\0\2\7"+
    "\5\6\13\7\1\0\44\7\11\0\1\7\71\0\53\6\24\7\1\6"+
    "\12\7\6\0\6\6\4\7\4\6\3\7\1\6\3\7\2\6\7\7"+
    "\3\6\4\7\15\6\14\7\1\6\17\7\2\0\46\6\1\0\1\6"+
    "\5\0\1\6\2\0\53\6\1\0\u014d\6\1\0\4\6\2\0\7\6"+
    "\1\0\1\6\1\0\4\6\2\0\51\6\1\0\4\6\2\0\41\6"+
    "\1\0\4\6\2\0\7\6\1\0\1\6\1\0\4\6\2\0\17\6"+
    "\1\0\71\6\1\0\4\6\2\0\103\6\2\0\3\7\40\0\20\6"+
    "\20\0\125\6\14\0\u026c\6\2\0\21\6\1\0\32\6\5\0\113\6"+
    "\3\0\3\6\17\0\15\6\1\0\4\6\3\7\13\0\22\6\3\7"+
    "\13\0\22\6\2\7\14\0\15\6\1\0\3\6\1\0\2\7\14\0"+
    "\64\6\40\7\3\0\1\6\3\0\2\6\1\7\2\0\12\7\41\0"+
    "\3\7\2\0\12\7\6\0\130\6\10\0\51\6\1\7\1\6\5\0"+
    "\106\6\12\0\35\6\3\0\14\7\4\0\14\7\12\0\12\7\36\6"+
    "\2\0\5\6\13\0\54\6\4\0\21\7\7\6\2\7\6\0\12\7"+
    "\46\0\27\6\5\7\4\0\65\6\12\7\1\0\35\7\2\0\13\7"+
    "\6\0\12\7\15\0\1\6\130\0\5\7\57\6\21\7\7\6\4\0"+
    "\12\7\21\0\11\7\14\0\3\7\36\6\15\7\2\6\12\7\54\6"+
    "\16\7\14\0\44\6\24\7\10\0\12\7\3\0\3\6\12\7\44\6"+
    "\122\0\3\7\1\0\25\7\4\6\1\7\4\6\3\7\2\6\11\0"+
    "\300\6\47\7\25\0\4\7\u0116\6\2\0\6\6\2\0\46\6\2\0"+
    "\6\6\2\0\10\6\1\0\1\6\1\0\1\6\1\0\1\6\1\0"+
    "\37\6\2\0\65\6\1\0\7\6\1\0\1\6\3\0\3\6\1\0"+
    "\7\6\3\0\4\6\2\0\6\6\4\0\15\6\5\0\3\6\1\0"+
    "\7\6\16\0\5\7\32\0\5\7\20\0\2\6\23\0\1\6\13\0"+
    "\5\7\5\0\6\7\1\0\1\6\15\0\1\6\20\0\15\6\3\0"+
    "\33\6\25\0\15\7\4\0\1\7\3\0\14\7\21\0\1\6\4\0"+
    "\1\6\2\0\12\6\1\0\1\6\3\0\5\6\6\0\1\6\1\0"+
    "\1\6\1\0\1\6\1\0\4\6\1\0\13\6\2\0\4\6\5\0"+
    "\5\6\4\0\1\6\21\0\51\6\u0a77\0\57\6\1\0\57\6\1\0"+
    "\205\6\6\0\4\6\3\7\2\6\14\0\46\6\1\0\1\6\5\0"+
    "\1\6\2\0\70\6\7\0\1\6\17\0\1\7\27\6\11\0\7\6"+
    "\1\0\7\6\1\0\7\6\1\0\7\6\1\0\7\6\1\0\7\6"+
    "\1\0\7\6\1\0\7\6\1\0\40\7\57\0\1\6\u01d5\0\3\6"+
    "\31\0\11\6\6\7\1\0\5\6\2\0\5\6\4\0\126\6\2\0"+
    "\2\7\2\0\3\6\1\0\132\6\1\0\4\6\5\0\51\6\3\0"+
    "\136\6\21\0\33\6\65\0\20\6\u0200\0\u19b6\6\112\0\u51cd\6\63\0"+
    "\u048d\6\103\0\56\6\2\0\u010d\6\3\0\20\6\12\7\2\6\24\0"+
    "\57\6\1\7\4\0\12\7\1\0\31\6\7\0\1\7\120\6\2\7"+
    "\45\0\11\6\2\0\147\6\2\0\4\6\1\0\4\6\14\0\13\6"+
    "\115\0\12\6\1\7\3\6\1\7\4\6\1\7\27\6\5\7\20\0"+
    "\1\6\7\0\64\6\14\0\2\7\62\6\21\7\13\0\12\7\6\0"+
    "\22\7\6\6\3\0\1\6\4\0\12\7\34\6\10\7\2\0\27\6"+
    "\15\7\14\0\35\6\3\0\4\7\57\6\16\7\16\0\1\6\12\7"+
    "\46\0\51\6\16\7\11\0\3\6\1\7\10\6\2\7\2\0\12\7"+
    "\6\0\27\6\3\0\1\6\1\7\4\0\60\6\1\7\1\6\3\7"+
    "\2\6\2\7\5\6\2\7\1\6\1\7\1\6\30\0\3\6\2\0"+
    "\13\6\5\7\2\0\3\6\2\7\12\0\6\6\2\0\6\6\2\0"+
    "\6\6\11\0\7\6\1\0\7\6\221\0\43\6\10\7\1\0\2\7"+
    "\2\0\12\7\6\0\u2ba4\6\14\0\27\6\4\0\61\6\u2104\0\u016e\6"+
    "\2\0\152\6\46\0\7\6\14\0\5\6\5\0\1\6\1\7\12\6"+
    "\1\0\15\6\1\0\5\6\1\0\1\6\1\0\2\6\1\0\2\6"+
    "\1\0\154\6\41\0\u016b\6\22\0\100\6\2\0\66\6\50\0\15\6"+
    "\3\0\20\7\20\0\7\7\14\0\2\6\30\0\3\6\31\0\1\6"+
    "\6\0\5\6\1\0\207\6\2\0\1\7\4\0\1\6\13\0\12\7"+
    "\7\0\32\6\4\0\1\6\1\0\32\6\13\0\131\6\3\0\6\6"+
    "\2\0\6\6\2\0\6\6\2\0\3\6\3\0\2\6\3\0\2\6"+
    "\22\0\3\7\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\2\2\1\3\2\4\1\5\2\6\1\7"+
    "\1\4\1\10\1\11\15\5\1\7\6\4\1\12\2\13"+
    "\1\14\1\1\1\12\1\15\1\16\1\0\2\6\1\0"+
    "\1\6\1\0\15\5\2\17\10\5\1\4\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\2\16\2\0"+
    "\3\6\1\0\24\5\1\0\1\6\14\5\1\6\2\5"+
    "\1\17\3\5\1\17\1\5\1\6\4\5\1\6\1\5"+
    "\1\6\1\5\1\6\1\5\1\6\10\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\64\0\150\0\234\0\320\0\234\0\234\0\u0104"+
    "\0\u0138\0\u016c\0\u01a0\0\u01d4\0\u0208\0\u023c\0\234\0\234"+
    "\0\u0270\0\u02a4\0\u02d8\0\u030c\0\u0340\0\u0374\0\u03a8\0\u03dc"+
    "\0\u0410\0\u0444\0\u0478\0\u04ac\0\u04e0\0\234\0\u0514\0\u0548"+
    "\0\234\0\u057c\0\u05b0\0\u05e4\0\u0618\0\u064c\0\234\0\234"+
    "\0\u0680\0\u06b4\0\234\0\u06e8\0\u071c\0\u0750\0\234\0\u0784"+
    "\0\u07b8\0\u07ec\0\u0820\0\u0854\0\u0888\0\u08bc\0\u08f0\0\u0924"+
    "\0\u0958\0\u098c\0\u09c0\0\u09f4\0\u0a28\0\u0a5c\0\u0a90\0\u0ac4"+
    "\0\u016c\0\u0af8\0\u0b2c\0\u0b60\0\u0b94\0\u0bc8\0\u0bfc\0\u0c30"+
    "\0\u0c64\0\u0c98\0\234\0\234\0\234\0\234\0\234\0\234"+
    "\0\234\0\234\0\u0ccc\0\234\0\u0d00\0\u0d34\0\u0d68\0\u0d9c"+
    "\0\u0dd0\0\u0e04\0\u0e38\0\u0e6c\0\u0ea0\0\u0ed4\0\u0f08\0\u0f3c"+
    "\0\u0f70\0\u0fa4\0\u0fd8\0\u100c\0\u1040\0\u1074\0\u10a8\0\u10dc"+
    "\0\u1110\0\u1144\0\u1178\0\u11ac\0\u11e0\0\u1214\0\u1248\0\u127c"+
    "\0\u12b0\0\u12e4\0\u1318\0\u134c\0\u1380\0\u13b4\0\u13e8\0\u141c"+
    "\0\u1450\0\u1484\0\u14b8\0\u14ec\0\u1520\0\u1554\0\u1588\0\u1040"+
    "\0\u15bc\0\u15f0\0\u1624\0\u1658\0\u168c\0\u16c0\0\u16f4\0\u1728"+
    "\0\u175c\0\u1790\0\u17c4\0\u17f8\0\u182c\0\u1860\0\u1894\0\u18c8"+
    "\0\u18fc\0\u1930\0\u1964\0\u1998\0\u19cc\0\u1a00\0\u1a34\0\u1a68"+
    "\0\u1a9c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\4"+
    "\1\13\1\14\4\12\1\15\1\12\1\16\1\17\1\20"+
    "\1\4\1\21\1\22\1\23\2\12\1\24\1\25\1\26"+
    "\3\12\1\27\1\30\1\12\1\31\1\32\1\33\1\34"+
    "\1\12\1\35\3\12\1\36\1\11\1\37\1\40\1\11"+
    "\1\41\1\42\1\43\1\44\1\45\1\46\1\47\16\45"+
    "\1\50\1\45\1\51\40\45\1\52\1\46\1\47\17\52"+
    "\1\53\1\51\40\52\66\0\1\6\65\0\1\54\1\55"+
    "\46\0\1\41\63\0\1\41\15\0\10\12\1\0\1\12"+
    "\4\0\27\12\21\0\2\56\1\57\1\60\1\0\1\57"+
    "\1\61\1\62\6\0\1\62\6\0\1\57\5\0\1\57"+
    "\5\0\1\60\22\0\2\14\1\57\2\0\1\57\1\61"+
    "\1\62\6\0\1\62\6\0\1\57\5\0\1\57\30\0"+
    "\2\61\72\0\1\41\33\0\1\41\15\0\10\12\1\0"+
    "\1\12\4\0\1\12\1\63\25\12\17\0\10\12\1\0"+
    "\1\12\4\0\2\12\1\64\24\12\17\0\10\12\1\0"+
    "\1\12\4\0\11\12\1\65\13\12\1\66\1\12\17\0"+
    "\10\12\1\0\1\12\4\0\3\12\1\67\5\12\1\70"+
    "\1\71\14\12\17\0\10\12\1\0\1\12\4\0\15\12"+
    "\1\72\3\12\1\73\5\12\17\0\10\12\1\0\1\12"+
    "\4\0\1\12\1\74\6\12\1\75\16\12\17\0\10\12"+
    "\1\0\1\12\4\0\2\12\1\76\12\12\1\77\11\12"+
    "\17\0\10\12\1\0\1\12\4\0\13\12\1\100\3\12"+
    "\1\101\6\12\1\66\17\0\10\12\1\0\1\12\4\0"+
    "\2\12\1\102\7\12\1\101\14\12\17\0\10\12\1\0"+
    "\1\12\4\0\3\12\1\103\6\12\1\104\1\12\1\105"+
    "\1\106\11\12\17\0\10\12\1\0\1\12\4\0\14\12"+
    "\1\107\12\12\17\0\10\12\1\0\1\12\4\0\10\12"+
    "\1\110\16\12\17\0\10\12\1\0\1\12\4\0\3\12"+
    "\1\104\6\12\1\111\14\12\65\0\1\41\1\112\62\0"+
    "\1\41\1\0\1\11\61\0\1\41\4\0\1\41\56\0"+
    "\1\41\5\0\1\41\55\0\1\41\6\0\1\41\1\45"+
    "\2\0\16\45\1\0\1\45\1\0\40\45\2\0\1\47"+
    "\61\0\2\47\1\0\16\47\1\113\1\114\1\115\1\116"+
    "\1\117\5\47\1\120\3\47\1\121\3\47\1\122\20\47"+
    "\1\52\2\0\17\52\2\0\40\52\1\54\1\123\1\124"+
    "\61\54\5\125\1\126\56\125\10\0\2\56\3\0\1\57"+
    "\1\61\1\62\6\0\1\62\14\0\1\57\30\0\1\127"+
    "\1\130\2\0\2\130\1\0\1\130\4\0\1\130\1\0"+
    "\2\130\1\0\1\130\10\0\2\130\30\0\2\61\3\0"+
    "\1\57\1\0\1\62\6\0\1\62\14\0\1\57\30\0"+
    "\2\131\6\0\1\132\42\0\1\132\6\0\10\12\1\0"+
    "\1\12\4\0\2\12\1\133\24\12\17\0\10\12\1\0"+
    "\1\12\4\0\7\12\1\134\17\12\17\0\10\12\1\0"+
    "\1\12\4\0\6\12\1\135\20\12\17\0\10\12\1\0"+
    "\1\12\4\0\22\12\1\136\4\12\17\0\10\12\1\0"+
    "\1\12\4\0\6\12\1\135\1\137\17\12\17\0\10\12"+
    "\1\0\1\12\4\0\3\12\1\140\23\12\17\0\10\12"+
    "\1\0\1\12\4\0\13\12\1\141\13\12\17\0\10\12"+
    "\1\0\1\12\4\0\22\12\1\142\4\12\17\0\10\12"+
    "\1\0\1\12\4\0\14\12\1\143\12\12\17\0\10\12"+
    "\1\0\1\12\4\0\15\12\1\135\2\12\1\101\6\12"+
    "\17\0\10\12\1\0\1\12\4\0\1\12\1\144\12\12"+
    "\1\145\12\12\17\0\10\12\1\0\1\12\4\0\21\12"+
    "\1\101\5\12\17\0\10\12\1\0\1\12\4\0\11\12"+
    "\1\146\15\12\17\0\10\12\1\0\1\12\4\0\6\12"+
    "\1\147\20\12\17\0\10\12\1\0\1\12\4\0\1\150"+
    "\16\12\1\151\7\12\17\0\10\12\1\0\1\12\4\0"+
    "\11\12\1\65\15\12\17\0\10\12\1\0\1\12\4\0"+
    "\1\12\1\101\25\12\17\0\10\12\1\0\1\12\4\0"+
    "\13\12\1\152\13\12\17\0\10\12\1\0\1\12\4\0"+
    "\13\12\1\153\13\12\17\0\10\12\1\0\1\12\4\0"+
    "\2\12\1\154\24\12\17\0\10\12\1\0\1\12\4\0"+
    "\14\12\1\155\12\12\17\0\10\12\1\0\1\12\4\0"+
    "\14\12\1\156\12\12\65\0\1\41\1\11\10\0\1\124"+
    "\61\0\5\125\1\157\56\125\4\0\1\124\1\126\66\0"+
    "\1\127\1\130\1\57\1\0\2\130\1\0\1\130\4\0"+
    "\1\130\1\0\2\130\1\0\1\130\3\0\1\57\4\0"+
    "\2\130\30\0\2\160\1\57\1\0\2\160\1\0\1\160"+
    "\4\0\1\160\1\0\2\160\1\0\1\160\3\0\1\57"+
    "\4\0\2\160\30\0\2\131\3\0\1\57\25\0\1\57"+
    "\30\0\2\131\60\0\10\12\1\0\1\12\4\0\3\12"+
    "\1\161\23\12\17\0\10\12\1\0\1\12\4\0\15\12"+
    "\1\162\11\12\17\0\10\12\1\0\1\12\4\0\2\12"+
    "\1\101\24\12\17\0\10\12\1\0\1\12\4\0\12\12"+
    "\1\163\14\12\17\0\10\12\1\0\1\12\4\0\5\12"+
    "\1\164\21\12\17\0\10\12\1\0\1\12\4\0\6\12"+
    "\1\145\20\12\17\0\10\12\1\0\1\12\4\0\6\12"+
    "\1\165\1\166\17\12\17\0\10\12\1\0\1\12\4\0"+
    "\2\12\1\104\24\12\17\0\10\12\1\0\1\12\4\0"+
    "\7\12\1\137\17\12\17\0\10\12\1\0\1\12\4\0"+
    "\12\12\1\167\14\12\17\0\10\12\1\0\1\12\4\0"+
    "\6\12\1\101\20\12\17\0\10\12\1\0\1\12\4\0"+
    "\11\12\1\101\15\12\17\0\10\12\1\0\1\12\4\0"+
    "\7\12\1\170\17\12\17\0\10\12\1\0\1\12\4\0"+
    "\15\12\1\171\11\12\17\0\10\12\1\0\1\12\4\0"+
    "\3\12\1\172\23\12\17\0\10\12\1\0\1\12\4\0"+
    "\3\12\1\173\23\12\17\0\10\12\1\0\1\12\4\0"+
    "\5\12\1\174\21\12\17\0\10\12\1\0\1\12\4\0"+
    "\11\12\1\156\15\12\17\0\10\12\1\0\1\12\4\0"+
    "\11\12\1\135\15\12\17\0\10\12\1\0\1\12\4\0"+
    "\16\12\1\101\10\12\11\0\4\125\1\124\1\157\56\125"+
    "\10\0\2\175\1\57\1\0\2\175\1\0\1\175\4\0"+
    "\1\175\1\0\2\175\1\0\1\175\3\0\1\57\4\0"+
    "\2\175\26\0\10\12\1\0\1\12\4\0\4\12\1\101"+
    "\22\12\17\0\10\12\1\0\1\12\4\0\1\12\1\176"+
    "\25\12\17\0\10\12\1\0\1\12\4\0\1\12\1\165"+
    "\25\12\17\0\10\12\1\0\1\12\4\0\10\12\1\101"+
    "\16\12\17\0\10\12\1\0\1\12\4\0\7\12\1\101"+
    "\17\12\17\0\10\12\1\0\1\12\4\0\14\12\1\177"+
    "\12\12\17\0\10\12\1\0\1\12\4\0\21\12\1\200"+
    "\5\12\17\0\10\12\1\0\1\12\4\0\3\12\1\201"+
    "\23\12\17\0\10\12\1\0\1\12\4\0\24\12\1\202"+
    "\2\12\17\0\10\12\1\0\1\12\4\0\15\12\1\203"+
    "\11\12\17\0\10\12\1\0\1\12\4\0\11\12\1\204"+
    "\15\12\17\0\10\12\1\0\1\12\4\0\7\12\1\205"+
    "\17\12\21\0\2\206\1\57\1\0\2\206\1\0\1\206"+
    "\4\0\1\206\1\0\2\206\1\0\1\206\3\0\1\57"+
    "\4\0\2\206\26\0\10\12\1\0\1\12\4\0\13\12"+
    "\1\101\13\12\17\0\10\12\1\0\1\12\4\0\13\12"+
    "\1\207\13\12\17\0\10\12\1\0\1\12\4\0\13\12"+
    "\1\210\13\12\17\0\10\12\1\0\1\12\4\0\24\12"+
    "\1\142\2\12\17\0\10\12\1\0\1\12\4\0\11\12"+
    "\1\165\15\12\17\0\10\12\1\0\1\12\4\0\11\12"+
    "\1\211\15\12\17\0\10\12\1\0\1\12\4\0\14\12"+
    "\1\212\12\12\21\0\2\213\1\57\1\0\2\213\1\0"+
    "\1\213\4\0\1\213\1\0\2\213\1\0\1\213\3\0"+
    "\1\57\4\0\2\213\26\0\10\12\1\0\1\12\4\0"+
    "\15\12\1\135\11\12\17\0\10\12\1\0\1\12\4\0"+
    "\5\12\1\214\21\12\17\0\10\12\1\0\1\12\4\0"+
    "\20\12\1\101\6\12\17\0\10\12\1\0\1\12\4\0"+
    "\12\12\1\176\14\12\21\0\2\215\1\57\1\0\2\215"+
    "\1\0\1\215\4\0\1\215\1\0\2\215\1\0\1\215"+
    "\3\0\1\57\4\0\2\215\26\0\10\12\1\0\1\12"+
    "\4\0\2\12\1\216\24\12\21\0\2\217\1\57\1\0"+
    "\2\217\1\0\1\217\4\0\1\217\1\0\2\217\1\0"+
    "\1\217\3\0\1\57\4\0\2\217\26\0\10\12\1\0"+
    "\1\12\4\0\12\12\1\220\14\12\21\0\2\221\1\57"+
    "\1\0\2\221\1\0\1\221\4\0\1\221\1\0\2\221"+
    "\1\0\1\221\3\0\1\57\4\0\2\221\26\0\10\12"+
    "\1\0\1\12\4\0\17\12\1\101\7\12\21\0\2\222"+
    "\1\57\1\0\2\222\1\0\1\222\4\0\1\222\1\0"+
    "\2\222\1\0\1\222\3\0\1\57\4\0\2\222\30\0"+
    "\2\223\1\57\1\0\2\223\1\0\1\223\4\0\1\223"+
    "\1\0\2\223\1\0\1\223\3\0\1\57\4\0\2\223"+
    "\30\0\2\224\1\57\1\0\2\224\1\0\1\224\4\0"+
    "\1\224\1\0\2\224\1\0\1\224\3\0\1\57\4\0"+
    "\2\224\30\0\2\225\1\57\1\0\2\225\1\0\1\225"+
    "\4\0\1\225\1\0\2\225\1\0\1\225\3\0\1\57"+
    "\4\0\2\225\30\0\2\226\1\57\1\0\2\226\1\0"+
    "\1\226\4\0\1\226\1\0\2\226\1\0\1\226\3\0"+
    "\1\57\4\0\2\226\30\0\2\227\1\57\1\0\2\227"+
    "\1\0\1\227\4\0\1\227\1\0\2\227\1\0\1\227"+
    "\3\0\1\57\4\0\2\227\30\0\2\230\1\57\1\0"+
    "\2\230\1\0\1\230\4\0\1\230\1\0\2\230\1\0"+
    "\1\230\3\0\1\57\4\0\2\230\30\0\2\231\1\57"+
    "\1\0\2\231\1\0\1\231\4\0\1\231\1\0\2\231"+
    "\1\0\1\231\3\0\1\57\4\0\2\231\32\0\1\57"+
    "\22\0\1\57\26\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6864];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\1\1\2\11\7\1\2\11\15\1\1\11"+
    "\2\1\1\11\5\1\2\11\2\1\1\11\1\1\1\0"+
    "\1\1\1\11\1\0\1\1\1\0\30\1\10\11\1\1"+
    "\1\11\2\0\3\1\1\0\24\1\1\0\42\1\10\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  StringBuilder string = new StringBuilder();
  
  private JavaSymbol symbol(String str,Lexem type) {
    return (new JavaSymbol(str, yyline+1, yycolumn+1,type,-1));
  }
private JavaSymbol symbol(String str,Lexem type,int charSt) {
    return (new JavaSymbol(str, yyline+1, yycolumn+1,type,charSt));
  }



  /** 
   * assumes correct representation of a long value for 
   * specified radix in scanner buffer from <code>start</code> 
   * to <code>end</code> 
   */
 


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2266) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public JavaSymbol yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 12: 
          { yybegin(YYINITIAL);string.append('\"');return symbol(string.toString(), Lexem.string);
          }
        case 24: break;
        case 5: 
          { return symbol(yytext(), Lexem.identifier);
          }
        case 25: break;
        case 14: 
          { return symbol(yytext(),Lexem.comment);
          }
        case 26: break;
        case 17: 
          { string.append( '\'' );
          }
        case 27: break;
        case 7: 
          { return symbol(yytext(),Lexem.separator);
          }
        case 28: break;
        case 13: 
          { yybegin(YYINITIAL);string.append('\''); return symbol(string.toString(), Lexem.string);
          }
        case 29: break;
        case 10: 
          { string.append( yytext() );
          }
        case 30: break;
        case 8: 
          { yybegin(STRING); string.setLength(0);string.append('\"');
          }
        case 31: break;
        case 15: 
          { return symbol(yytext(),Lexem.keyword);
          }
        case 32: break;
        case 20: 
          { string.append( '\r' );
          }
        case 33: break;
        case 6: 
          { return symbol(yytext(),Lexem.number);
          }
        case 34: break;
        case 2: 
          { return symbol(yytext(),Lexem.notLexem);
          }
        case 35: break;
        case 19: 
          { string.append( '\b' );
          }
        case 36: break;
        case 11: 
          { return symbol(string.toString(),Lexem.error,yychar-string.length());
          }
        case 37: break;
        case 21: 
          { string.append( '\t' );
          }
        case 38: break;
        case 4: 
          { return symbol(yytext(),Lexem.operator);
          }
        case 39: break;
        case 3: 
          { return symbol(yytext(),Lexem.whiteSpace);
          }
        case 40: break;
        case 1: 
          { return symbol(yytext(),Lexem.error,yychar);
          }
        case 41: break;
        case 18: 
          { string.append( '\\' );
          }
        case 42: break;
        case 9: 
          { yybegin(CHARLITERAL);string.setLength(0);string.append('\'');
          }
        case 43: break;
        case 22: 
          { string.append( '\n' );
          }
        case 44: break;
        case 23: 
          { string.append( '\f' );
          }
        case 45: break;
        case 16: 
          { string.append( '\"' );
          }
        case 46: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            switch (zzLexicalState) {
            case STRING: {
              return symbol(string.toString(),Lexem.error,yychar-string.length());
            }
            case 154: break;
            case CHARLITERAL: {
              return symbol(string.toString(),Lexem.error,yychar-string.length());
            }
            case 155: break;
            default:
              {
                return symbol("eof",Lexem.eof);
              }
            }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
