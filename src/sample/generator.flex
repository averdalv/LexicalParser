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




%%

%public
%class Scanner
%type JavaSymbol

%unicode

%line
%column
%char



%{
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
 
%}

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace =  [\t\f ]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} 
          

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?


/* identifiers */
Identifier = [:jletter:][:jletterdigit:]*

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*
DecLongLiteral    = {DecIntegerLiteral} [lL]

HexIntegerLiteral = 0 [xX] 0* {HexDigit} {1,8}
HexLongLiteral    = 0 [xX] 0* {HexDigit} {1,16} [lL]
HexDigit          = [0-9a-fA-F]

/*OctIntegerLiteral = 0+ [1-3]? {OctDigit} {1,15}
OctLongLiteral    = 0+ 1? {OctDigit} {1,21} [lL]
OctDigit          = [0-7]*/
    
/* floating point literals */        
FloatLiteral  = ({FLit1}|{FLit2}|{FLit3}) {Exponent}? [fF]
DoubleLiteral = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?

FLit1    = [0-9]+ \. [0-9]* 
FLit2    = \. [0-9]+ 
FLit3    = [0-9]+ 
Exponent = [eE] [+-]? [0-9]+

/* string and character literals */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]

%state STRING, CHARLITERAL

%%

<YYINITIAL> {

  /* keywords */
  
  
  "break"                        { return symbol(yytext(),Lexem.keyword); }
 
  "case"                         { return symbol(yytext(),Lexem.keyword); }
  "catch"                        { return symbol(yytext(),Lexem.keyword); }
  
  "class"                        { return symbol(yytext(),Lexem.keyword); }
  "const"                       { return symbol(yytext(),Lexem.keyword); }
  "continue"                     { return symbol(yytext(),Lexem.keyword); }
  "do"                           { return symbol(yytext(),Lexem.keyword); }
  
  "else"                        { return symbol(yytext(),Lexem.keyword); }
  
  "final"                        { return symbol(yytext(),Lexem.keyword); }
  "finally"                     { return symbol(yytext(),Lexem.keyword); }
  
  "for"                         { return symbol(yytext(),Lexem.keyword); }
  "default"                      { return symbol(yytext(),Lexem.keyword); }
  
  "instanceof"                  { return symbol(yytext(),Lexem.keyword); }
  
  "new"                          { return symbol(yytext(),Lexem.keyword); }
 
  "if"                           { return symbol(yytext(),Lexem.keyword); }
  
  "super"                        { return symbol(yytext(),Lexem.keyword); }
  "switch"                       { return symbol(yytext(),Lexem.keyword); }
  
  "void"			{ return symbol(yytext(),Lexem.keyword); }
  "return"                       { return symbol(yytext(),Lexem.keyword); }
  
  "while"                       { return symbol(yytext(),Lexem.keyword); }
  "this"                         { return symbol(yytext(),Lexem.keyword); }
  "throw"                        { return symbol(yytext(),Lexem.keyword); }
  "throws"                       { return symbol(yytext(),Lexem.keyword); }
  "try"                          { return symbol(yytext(),Lexem.keyword); }
  "var"				{ return symbol(yytext(),Lexem.keyword); }
  "debugger"			{ return symbol(yytext(),Lexem.keyword); }
  "function"			{ return symbol(yytext(),Lexem.keyword); }
  
 "in"				{ return symbol(yytext(),Lexem.keyword); }
"export"			{ return symbol(yytext(),Lexem.keyword); }
"import"			{ return symbol(yytext(),Lexem.keyword); }
"yield"				{ return symbol(yytext(),Lexem.keyword); }
  /* boolean literals */
  "true"                         { return symbol(yytext(),Lexem.keyword); }
  "false"                        { return symbol(yytext(),Lexem.keyword); }
  
  /* null literal */
  "null"                        { return symbol(yytext(),Lexem.keyword); }
  
  
  /* separators */
  "("                            { return symbol(yytext(),Lexem.separator); }
  ")"                            { return symbol(yytext(),Lexem.separator); }
  "{"                            { return symbol(yytext(),Lexem.separator); }
  "}"                            { return symbol(yytext(),Lexem.separator); }
  "["                            { return symbol(yytext(),Lexem.separator); }
  "]"                            { return symbol(yytext(),Lexem.separator); }
  ";"                            { return symbol(yytext(),Lexem.separator); }
  ","                           { return symbol(yytext(),Lexem.separator); }
  "."                           { return symbol(yytext(),Lexem.separator); }
  
  /* operators */
  "="                            { return symbol(yytext(),Lexem.operator); }
  ">"                            { return symbol(yytext(),Lexem.operator); }
  "<"                            { return symbol(yytext(),Lexem.operator); }
  "!"                            { return symbol(yytext(),Lexem.operator); }
  "~"                            { return symbol(yytext(),Lexem.operator); }
  "?"                          	 { return symbol(yytext(),Lexem.operator); }
  ":"                            { return symbol(yytext(),Lexem.operator); }
  "=="                           { return symbol(yytext(),Lexem.operator); }
  "<="                           { return symbol(yytext(),Lexem.operator); }
  ">="                          { return symbol(yytext(),Lexem.operator); }
  "!="                           { return symbol(yytext(),Lexem.operator); }
  "&&"                           { return symbol(yytext(),Lexem.operator); }
  "||"                           { return symbol(yytext(),Lexem.operator); }
  "++"                           { return symbol(yytext(),Lexem.operator); }
  "--"                           { return symbol(yytext(),Lexem.operator); }
  "+"                            { return symbol(yytext(),Lexem.operator); }
  "-"                           { return symbol(yytext(),Lexem.operator); }
  "*"                            { return symbol(yytext(),Lexem.operator); }
  "/"                            { return symbol(yytext(),Lexem.operator); }
  "&"                            { return symbol(yytext(),Lexem.operator); }
  "|"                            { return symbol(yytext(),Lexem.operator); }
  "^"                            { return symbol(yytext(),Lexem.operator); }
  "%"                            { return symbol(yytext(),Lexem.operator); }
  "<<"                           { return symbol(yytext(),Lexem.operator); }
  ">>"                           { return symbol(yytext(),Lexem.operator); }
  ">>>"                          { return symbol(yytext(),Lexem.operator); }
  "+="                           { return symbol(yytext(),Lexem.operator); }
  "-="                           { return symbol(yytext(),Lexem.operator); }
  "*="                           { return symbol(yytext(),Lexem.operator); }
  "/="                           { return symbol(yytext(),Lexem.operator); }
  "&="                           { return symbol(yytext(),Lexem.operator); }
  "|="                           { return symbol(yytext(),Lexem.operator); }
  "^="                           { return symbol(yytext(),Lexem.operator); }
  "%="                           { return symbol(yytext(),Lexem.operator); }
  "<<="                          { return symbol(yytext(),Lexem.operator); }
  ">>="                          { return symbol(yytext(),Lexem.operator); }
  ">>>="                         { return symbol(yytext(),Lexem.operator); }
  
  /* string literal */
  \"                             { yybegin(STRING); string.setLength(0);string.append('\"'); }

  /* character literal */
  \'                             { yybegin(CHARLITERAL);string.setLength(0);string.append('\''); }

  /* numeric literals */

  /* This is matched together with the minus, because the number is too big to 
     be represented by a positive integer. */
  
  {DecIntegerLiteral}           { return symbol(yytext(),Lexem.number); }
  {DecLongLiteral}               { return symbol(yytext(),Lexem.number); }
  
  {HexIntegerLiteral}            { return symbol(yytext(),Lexem.number); }
  {HexLongLiteral}               { return symbol(yytext(),Lexem.number); }
 
  
  {FloatLiteral}                 { return symbol(yytext(),Lexem.number); }
  {DoubleLiteral}               { return symbol(yytext(),Lexem.number); }
  {DoubleLiteral}          { return symbol(yytext(),Lexem.number); }
  
  /* comments */
  {Comment}                      {return symbol(yytext(),Lexem.comment); }

  /* whitespace */
  {LineTerminator}                   {return symbol(yytext(),Lexem.notLexem);}
  {WhiteSpace}			 {return symbol(yytext(),Lexem.whiteSpace);}		

  /* identifiers */ 
  {Identifier}                   { return symbol(yytext(), Lexem.identifier); }  
}

<STRING> {
  \"                             { yybegin(YYINITIAL);string.append('\"');return symbol(string.toString(), Lexem.string); }
  
  {StringCharacter}+             { string.append( yytext() ); }
  
  /* escape sequences */
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\'"                          { string.append( '\'' ); }
  "\\\\"                         { string.append( '\\' ); }

  
  /* error cases */
  \\.                           { return symbol(string.toString(),Lexem.error,yychar-string.length()); }
  {LineTerminator}               { return symbol(string.toString(),Lexem.error,yychar-string.length()); }
<<EOF>>             	{ return symbol(string.toString(),Lexem.error,yychar-string.length()); }
}

<CHARLITERAL> {
 \'                             { yybegin(YYINITIAL);string.append('\''); return symbol(string.toString(), Lexem.string); }
  
  {SingleCharacter}+             { string.append( yytext() ); }
  
  /* escape sequences */
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\'"                          { string.append( '\'' ); }
  "\\\\"                         { string.append( '\\' ); }
 
  
  /* error cases */
  \\.                            { return symbol(string.toString(),Lexem.error,yychar-string.length()); }
  {LineTerminator}               { return symbol(string.toString(),Lexem.error,yychar-string.length()); } 
	<<EOF>>             	{ return symbol(string.toString(),Lexem.error,yychar-string.length()); } 
}

/* error fallback */
[^]                              { return symbol(yytext(),Lexem.error,yychar); } 
<<EOF>>                          { return symbol("eof",Lexem.eof); }
