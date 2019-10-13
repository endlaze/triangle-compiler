/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    AND = 4, //new
    ARRAY		= 4,
//    BEGIN		= 5,
    CONST		= 6,
    DO			= 7,
    ELSE		= 8,
    END			= 9,
    FOR = 1000, //new
    FUNC		= 10,
    IF			= 11,
    IN			= 12,
    INIT = 1000, //new
    LET			= 13,
    LOCAL = 1000, //new
    LOOP = 1000, //new
    OF			= 14,
    PROC		= 15,
    RECORD		= 16,
    RECURSIVE = 1000, //new
    REPEAT = 1000, //new
    SKIP = 1000, //new
    THEN		= 17,
    TO = 1000, //new
    TYPE		= 18,
    UNTIL = 1000, //new
    VAR			= 19,
    WHILE		= 20,

    // punctuation...
    DOT			= 21,
    COLON		= 22,
    SEMICOLON	= 23,
    COMMA		= 24,
    BECOMES		= 25,
    IS			= 26,

    // brackets...
    LPAREN		= 27,
    RPAREN		= 28,
    LBRACKET	= 29,
    RBRACKET	= 30,
    LCURLY		= 31,
    RCURLY		= 32,

    // special tokens...
    EOT			= 33, //new
    ERROR		= 34;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "and", //new
    "array",
//    "begin",
    "const",
    "do",
    "else",
    "end",
    "for", //new
    "func",
    "if",
    "in",
    "init", //new
    "let",
    "local", //new 
    "loop", //new
    "of",
    "proc",
    "record",
    "recursive", //new
    "repeat", //new
    "skip", //new
    "then",
    "to", //new
    "type",
    "until", //new
    "var",
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"
  };

  private final static int	firstReservedWord = Token.ARRAY,
  				lastReservedWord  = Token.WHILE;

}
