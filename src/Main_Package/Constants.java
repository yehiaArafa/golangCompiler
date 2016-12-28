package Main_Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author ninja
 */
public class Constants {
    
    public static String Location = System.getProperty("user.dir") + "/";
    public static String DEFAULT_CODE_NAME = "test.go";
    public static String csvParseSeparator = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

    public static HashMap regexHashMap = new HashMap<String, String>();
    
    public static ArrayList<String> keyWords = new ArrayList<String>(
            Arrays.asList("break", "default", "func", "interface", "select", "case",
                    "defer", "go", "map", "struct", "chan", "else", "goto", "package", "switch", "const", "fallthrough",
                    "if", "range", "type", "continue", "for", "import", "return", "var"));
    
    //constatns for short var declaration ":="//
    
    public static String[] terminals={"DotEq","COMMA","OPERAND","IDENTIFIER","$"};
    
    public static String[] nonTerminals={"ShortVarDecl","IdentifierList","IdentifierList'"
                                        ,"ExpressionList","ExpressionList'","Expression","Expression'","Identifier"};
    
    
/*     
 ============================================================================================================================================================================================================================
                |         DotEq         |                COMMA                      |                 OPERAND                            |               IDENTIFIER                              |         $
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
shortValDecl    |                       |                                           |                                                    | ShortVarDecl -> IdentifierList DotEq ExpressionList   |                      
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
IdentifierList  |                       |                                           |                                                    | IdentifierList -> Identifier IdentifierList'          |      
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
IdentifierList' | IdentifierList' -> '' | IdentifierList' -> comma IdentifierList   |                                                    |                                                       | 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
ExpressionList  |                       |                                           |                                                    |  ExpressionList -> Expression ExpressionList'         |   
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
ExpressionList' |                       |  ExpressionList' -> comma ExpressionList  |                                                    |                                                       |                                                   
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Expression      |                       |                                           |                                                    |  Expression -> Identifier Expression'                 |  ExpressionList' -> ''                                                 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Expression'     |                       |    Expression' -> ''                      |  Expression' -> OPERAND Identifier Expression'     |                                                       |  Expression' -> ''                                                 
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Identifier      |                       |                                           |                                                    |Identifier -> IDENTIFIER                             	 |                                                   
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
============================================================================================================================================================================================================================
*/    
    
    
    public static String [][] parsingTable={
        
        {null, null, null, "IdentifierList DotEq ExpressionList", null},
        {null, null, null, "Identifier IdentifierList'", null},
        {"", "comma IdentifierList", null, null, null},
        {null, null,null,"Expression ExpressionList'", null},
        {null, "comma ExpressionList", null, null, ""},
        {null, null, null, "Identifier Expression'", null},
        {null, "", "OPERAND Identifier Expression'", null, ""},
        {null, null, null, "IDENTIFIER", null}
    };
    
}
