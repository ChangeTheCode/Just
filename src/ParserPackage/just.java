/* Generated By:JavaCC: Do not edit this line. just.java */
package ParserPackage;

public class just implements justConstants {
  public static void main(String args []) throws ParseException
  {
    just parser = new just(System.in);
    while (true)
    {
      System.out.println("Reading from standard input...");
      System.out.print("Enter an Just synatax  :");
      try
      {
        switch (just.one_line())
        {
          case 0 :
          System.out.println("OK.");
          break;
          case 1 :
          System.out.println("Goodbye.");
          break;
          default :
          break;
        }
      }
      catch (Exception e)
      {
        System.out.println("NOK.");
        System.out.println(e.getMessage());
        just.ReInit(System.in);
      }
      catch (Error e)
      {
        System.out.println("Oops.");
        System.out.println(e.getMessage());
        break;
      }
    }
  }

  static final public int one_line() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PROGRAM:
      firstExpression();
      jj_consume_token(39);
    {if (true) return 0;}
      break;
    case 39:
      jj_consume_token(39);
    {if (true) return 1;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public void firstExpression() throws ParseException {
    jj_consume_token(PROGRAM);
    jj_consume_token(IDENT);
    jj_consume_token(LGESCHWEIFT);
    programmCode();
    jj_consume_token(RGESCHWEIFT);
  }

  static final public void programmCode() throws ParseException {
    defintion();
  }

/*Block = "{" { VarDef| Stat} "}".*/
  static final public void block() throws ParseException {
    jj_consume_token(LGESCHWEIFT);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TYPE:
      case LGESCHWEIFT:
      case SEMI:
      case IF:
      case WHILE:
      case RETURN:
      case IDENT:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TYPE:
        varDef();
        break;
      case LGESCHWEIFT:
      case SEMI:
      case IF:
      case WHILE:
      case RETURN:
      case IDENT:
        statement();
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(RGESCHWEIFT);
  }

/*Definition= { VarDef| FuncDef}.*/
  static final public void defintion() throws ParseException {
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TYPE:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TYPE:
        varDef();
        break;
        funcDef();
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

/* FuncDef =FuncHeadBlock.*/
  static final public void funcDef() throws ParseException {
    funcHeadBlock();
  }

/*FuncHead = Type ident "(" [ FormParList] ")".*/
  static final public void funcHeadBlock() throws ParseException {
    jj_consume_token(TYPE);
    jj_consume_token(IDENT);
    jj_consume_token(RLKLAMMER);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TYPE:
    case BYREF:
      formParList();
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    jj_consume_token(RRKLAMMER);
  }

/*FormParList = ["byref"] Type ident{"," ["byref"] Type ident}.*/
  static final public void formParList() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BYREF:
      jj_consume_token(BYREF);
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    jj_consume_token(TYPE);
    jj_consume_token(IDENT);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case KOMMA:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
      jj_consume_token(KOMMA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BYREF:
        jj_consume_token(BYREF);
        break;
      default:
        jj_la1[8] = jj_gen;
        ;
      }
      jj_consume_token(TYPE);
      jj_consume_token(IDENT);
    }
  }

/*ident "=" Expr";".*/
  static final public void assignStat() throws ParseException {
    jj_consume_token(IDENT);
    jj_consume_token(EQUALS);
    expr();
    jj_consume_token(SEMI);
  }

  static final public void expr() throws ParseException {
    orExpr();
  }

/*OrExpr = AndExpr{ "||" AndExpr}.*/
  static final public void orExpr() throws ParseException {
    andExpr();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_4;
      }
      jj_consume_token(OR);
      andExpr();
    }
  }

/*AndExpr = RelExpr{ "&&" RelExpr}.*/
  static final public void andExpr() throws ParseException {
    relExpr();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case KAUFUND:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_5;
      }
      jj_consume_token(KAUFUND);
      relExpr();
    }
  }

/*RelExpr = SimpleExpr[ ("==" | "!=" | "<" | "<=" | ">" | ">=") SimpleExpr].*/
  static final public void relExpr() throws ParseException {
    simpleExpr();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case GLEICHGLEICH:
    case AUSGLEICH:
    case KLEINER:
    case KLEINERGLEICH:
    case GROESSER:
    case GROESSERGLEICH:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case GLEICHGLEICH:
        jj_consume_token(GLEICHGLEICH);
        break;
      case AUSGLEICH:
        jj_consume_token(AUSGLEICH);
        break;
      case KLEINER:
        jj_consume_token(KLEINER);
        break;
      case KLEINERGLEICH:
        jj_consume_token(KLEINERGLEICH);
        break;
      case GROESSER:
        jj_consume_token(GROESSER);
        break;
      case GROESSERGLEICH:
        jj_consume_token(GROESSERGLEICH);
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      simpleExpr();
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
  }

/*SimpleExpr = ["+" | "-"] Term { ("+" | "-") Term }.*/
  static final public void simpleExpr() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
    term();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
        break;
      case MINUS:
        jj_consume_token(MINUS);
        term();
        break;
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  /*Term = NotFact{ ("*" | "/") NotFact}.*/
  static final public void term() throws ParseException {
    notFact();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAL:
      case DIV:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_7;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAL:
        jj_consume_token(MAL);
        break;
      case DIV:
        jj_consume_token(DIV);
        notFact();
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

/*NotFact = ["!"] Fact.*/
  static final public void notFact() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AUSRUF:
      jj_consume_token(AUSRUF);
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
    fact();
  }

/*Fact = number | ident["(" [ ActParList] ")" ] | "(" Expr")".*/
  static final public void fact() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case IDENT:
      jj_consume_token(IDENT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RLKLAMMER:
        jj_consume_token(RLKLAMMER);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case RLKLAMMER:
        case PLUS:
        case MINUS:
        case AUSRUF:
        case NUMBER:
        case IDENT:
          actParList();
          break;
        default:
          jj_la1[20] = jj_gen;
          ;
        }
        jj_consume_token(RRKLAMMER);
        break;
      default:
        jj_la1[21] = jj_gen;
        ;
      }
      break;
    case RLKLAMMER:
      jj_consume_token(RLKLAMMER);
      expr();
      jj_consume_token(RRKLAMMER);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*CallStat = Call ";".*/
  static final public void callStat() throws ParseException {
    call();
    jj_consume_token(SEMI);
  }

/*Call = ident "(" [ ActParList] ")"*/
  static final public void call() throws ParseException {
    jj_consume_token(IDENT);
    jj_consume_token(RLKLAMMER);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RLKLAMMER:
    case PLUS:
    case MINUS:
    case AUSRUF:
    case NUMBER:
    case IDENT:
      actParList();
      break;
    default:
      jj_la1[23] = jj_gen;
      ;
    }
    jj_consume_token(RRKLAMMER);
  }

//Stat = AssignStat| CallStat| IfStat| WhileStat| ReturnStat| Block | ";".
  static final public void statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
      assignStat();
      break;
    case IF:
      ifStat();
      break;
    case WHILE:
      whileState();
      break;
    case RETURN:
      returnStat();
      break;
      callStat();
      break;
    case LGESCHWEIFT:
      block();
      break;
    case SEMI:
      jj_consume_token(SEMI);
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

/*ActParList = Expr{ "," Expr}.*/
  static final public void actParList() throws ParseException {
    expr();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case KOMMA:
        ;
        break;
      default:
        jj_la1[25] = jj_gen;
        break label_8;
      }
      jj_consume_token(KOMMA);
      expr();
    }
  }

//IfStat = "if" "(" Expr ")" Stat [ "else" Stat ].
  static final public void ifStat() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(RLKLAMMER);
    expr();
    jj_consume_token(RRKLAMMER);
    statement();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      statement();
      break;
    default:
      jj_la1[26] = jj_gen;
      ;
    }
  }

/*"while" "(" Expr")" Stat.*/
  static final public void whileState() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(RLKLAMMER);
    expr();
    jj_consume_token(RRKLAMMER);
    statement();
  }

/*ReturnStat = "return" [ Expr] ";" .*/
  static final public void returnStat() throws ParseException {
    jj_consume_token(RETURN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RLKLAMMER:
    case PLUS:
    case MINUS:
    case AUSRUF:
    case NUMBER:
    case IDENT:
      expr();
      break;
    default:
      jj_la1[27] = jj_gen;
      ;
    }
    jj_consume_token(SEMI);
  }

/*VarDef = Type ident[ Init] ";".*/
  static final public void varDef() throws ParseException {
    jj_consume_token(TYPE);
    jj_consume_token(IDENT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQUALS:
      init();
      break;
    default:
      jj_la1[28] = jj_gen;
      ;
    }
    jj_consume_token(SEMI);
  }

/*Init = "=" number.*/
  static final public void init() throws ParseException {
    jj_consume_token(EQUALS);
    jj_consume_token(NUMBER);
  }

/*FuncDef = FuncHeadBlock*/
//funchead = Type ident "(" [ FormParList] ")".
  static final public void funcHead() throws ParseException {
    jj_consume_token(TYPE);
    jj_consume_token(IDENT);
    jj_consume_token(RLKLAMMER);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TYPE:
    case BYREF:
      formParList();
      break;
    default:
      jj_la1[29] = jj_gen;
      ;
    }
    jj_consume_token(RRKLAMMER);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public justTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[30];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x20,0xd08c0,0xd08c0,0x40,0x40,0x40,0x0,0x8000,0x0,0x200000,0x100000,0xfc00000,0xfc00000,0x30000000,0x30000000,0x30000000,0x30000000,0xc0000000,0xc0000000,0x0,0x30004000,0x4000,0x4000,0x30004000,0xd0880,0x8000,0x20000,0x30004000,0x1000,0x40,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x80,0x40,0x40,0x0,0x0,0x2,0x2,0x0,0x2,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x45,0x0,0x44,0x45,0x40,0x0,0x0,0x45,0x0,0x2,};
   }

  /** Constructor with InputStream. */
  public just(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public just(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new justTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public just(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new justTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public just(justTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(justTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[40];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 30; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 40; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
