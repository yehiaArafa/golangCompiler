/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Package;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 *
 * @author omarkrostom
 */
public class Warehouse {
//    public void bracketCase(String row, int lineIterator) {
//        LinkedHashMap<String, String> results = new LinkedHashMap();
//        for (int i = 0; i < row.length(); i++) {
//            if (row.charAt(i) == '(') {
//                results.put("Left Bracket", String.valueOf('('));
//            } else if (row.charAt(i) == ')') {
//                results.put("Right Brachet", String.valueOf(')'));
//            } else if (row.charAt(i) == '{') {
//                results.put("Curly Left Bracket", String.valueOf('{'));
//            } else if (row.charAt(i) == '}') {
//                results.put("Curly Right Bracket", String.valueOf('}'));
//            } else {
//                continue;
//            }
//            //To skip whitspaces
//        }
//        finalOutput.put(String.valueOf(lineIterator + 1), results);
//    }
//
//    private void noVar(String row, int lineIterator) {
//
//        int objectIndex = 0;
//        LinkedHashMap<String, String> results = new LinkedHashMap();
//        boolean containDot = false;
//        String[] rowSplit = row.split("=");
//
//        if (rowSplit[0].charAt(rowSplit[0].length() - 1) == ':') {
//            containDot = true;
//        }
//        if (containDot) {
//            if (this.isKeyword(rowSplit[0].substring(0, rowSplit[0].length() - 1))) {
//                System.out.println(Strings.lineNumber + (lineIterator + 1) + " :" + Strings.syntaxError);
//                return;
//            } else {
//                results.put(Strings.IDENTIFIER + "_" + objectIndex, rowSplit[0].substring(0, rowSplit[0].length() - 1));
//                objectIndex++;
//            }
//            results.put(Strings.OPERAND, ":=");
//        } else {
//            if (this.isKeyword(rowSplit[0])) {
//                System.out.println(Strings.lineNumber + (lineIterator + 1) + " :" + Strings.syntaxError);
//                return;
//            } else {
//                results.put(Strings.IDENTIFIER + "_" + objectIndex, rowSplit[0]);
//                objectIndex++;
//            }
//            results.put(Strings.OPERAND + "_" + objectIndex, "=");
//            objectIndex++;
//        }
//
//        parsingString(rowSplit[1], results, lineIterator, objectIndex);
//    }
//
//    private void var(String row, int lineIterator) {
//        LinkedHashMap<String, String> results = new LinkedHashMap();
//        boolean error = false;
//        int objectIndex = 0;
//        String mode = "";
//        String output = "";
//        String[] rowSplit = row.split("=");
//
//        String beforeEqual = rowSplit[0];
//        String AfterEqual = rowSplit[1];
//
//        String[] temp = beforeEqual.split("var");
//        String[] splitBeforeEqual = temp[1].split(" ");
//
//        results.put("Keyword", "var");
//
//        for (int i = 1; i < splitBeforeEqual.length; i++) {
//            if (this.isKeyword(splitBeforeEqual[i])) {
//                System.out.println(Strings.lineNumber + (lineIterator + 1) + " :" + Strings.syntaxError);
//                return;
//            } else {
//                results.put(Strings.IDENTIFIER + "_" + objectIndex, splitBeforeEqual[i]);
//                objectIndex++;
//            }
//        }
//        results.put(Strings.OPERAND + "_" + objectIndex, "=");
//        objectIndex++;
//
//        parsingString(AfterEqual, results, lineIterator, objectIndex);
//
//    }
//
//    public void addComment(String row, int lineIterator) {
//        LinkedHashMap<String, String> results = new LinkedHashMap();
//        results.put("Comment", row);
//        finalOutput.put(String.valueOf(lineIterator + 1), results);
//    }
//
//    public void ifconiditon(String row, int lineIterator) {
//        LinkedHashMap<String, String> results = new LinkedHashMap();
//        int objectIndex = 0;
//        String[] lineAfterIf = row.split("if");
//        results.put("Keyword", "if");
//        parsingString(lineAfterIf[1], results, lineIterator, objectIndex);
//    }
//
//    public void arthematic(String row, int lineIterator) {
//        LinkedHashMap<String, String> results = new LinkedHashMap();
//        int objectIndex = 0;
//
//        parsingString(row, results, lineIterator, objectIndex);
//    }
//
//    private void funcMain(String row, int lineIterator) {
//        LinkedHashMap<String, String> results = new LinkedHashMap();
//        int objectIndex = 0;
//        results.put("keyword_" + objectIndex, "func");
//        objectIndex++;
//        results.put(Strings.IDENTIFIER + "_" + objectIndex, "main");
//        objectIndex++;
//        finalOutput.put(String.valueOf(lineIterator + 1), results);
//    }
//
//    private void parsingString(String stringToParse, LinkedHashMap results, int lineIterator, int objectIndex) {
//        boolean error = false;
//        String mode = "", output = "";
//
//        stringToParse = stringToParse.replace(" ", "");
//        if (isChar(String.valueOf(stringToParse.charAt(0)))) {
//            mode = Strings.IDENTIFIER;
//        } else if (isOperator(String.valueOf(stringToParse.charAt(0)))) {
//            mode = Strings.OPERAND;
//        } else if (isBracket(String.valueOf(stringToParse.charAt(0)))) {
//            mode = Strings.BRACKET;
//        }
//        /*START PARSING*/
//        for (int i = 0; i < stringToParse.length(); i++) {
//            if (stringToParse.length() - 1 == i) {
//                if (isChar(String.valueOf(stringToParse.charAt(i)))) {
//                    if (mode == Strings.IDENTIFIER) {
//                        output += String.valueOf(stringToParse.charAt(i));
//                        if (!isKeyword(output)) {
//                            objectIndex++;
//                            results.put(Strings.IDENTIFIER + "_" + objectIndex, output);
//                        } else {
//                            error = true;
//                        }
//                    } else if (mode == Strings.OPERAND) {
//                        if (!isKeyword(output)) {
//                            objectIndex++;
//                            results.put(Strings.OPERAND + "_" + objectIndex, output);
//
//                        } else {
//                            error = true;
//                        }
//
//                        output = String.valueOf(stringToParse.charAt(i));
//                        if (!isKeyword(output)) {
//                            objectIndex++;
//                            results.put(Strings.IDENTIFIER + "_" + objectIndex, output);
//                        } else {
//                            error = true;
//                        }
//                    }
//                } else if (isOperator(String.valueOf(stringToParse.charAt(i)))) {
//                    if (mode == Strings.OPERAND) {
//                        output += String.valueOf(stringToParse.charAt(i));
//                        if (!isKeyword(output)) {
//                            objectIndex++;
//                            results.put(Strings.OPERAND + "_" + objectIndex, output);
//                        } else {
//                            error = true;
//                        }
//                    } else if (mode == Strings.IDENTIFIER) {
//                        if (!isKeyword(output)) {
//                            objectIndex++;
//                            results.put(Strings.IDENTIFIER + "_" + objectIndex, output);
//                        } else {
//                            error = true;
//                        }
//                        output = String.valueOf(stringToParse.charAt(i));
//                        if (!isKeyword(output)) {
//                            objectIndex++;
//                            results.put(Strings.OPERAND + "_" + objectIndex, output);
//                        } else {
//                            error = true;
//                        }
//                    }
//                } else if (stringToParse.charAt(i) == '(') {
//                    results.put(mode,output);
//                    results.put("Left Bracket", String.valueOf('('));
//                } else if (stringToParse.charAt(i) == ')') {
//                    results.put(mode,output);
//                    results.put("Right Bracket", String.valueOf(')'));
//                } else if (stringToParse.charAt(i) == '{') {
//                    results.put(mode,output);
//                    results.put("Left Curly Bracket", String.valueOf('{'));
//                } else if (stringToParse.charAt(i) == '}') {
//                    results.put(mode,output);
//                    results.put("Right Curly Bracket", String.valueOf('}'));
//                }
//            } else if (stringToParse.charAt(i) == '(') {
//                results.put(mode,output);
//                results.put("Left Bracket", String.valueOf('('));
//            } else if (stringToParse.charAt(i) == ')') {
//                results.put(mode,output);
//                results.put("Right Bracket", String.valueOf(')'));
//            } else if (stringToParse.charAt(i) == '{') {
//                results.put(mode,output);
//                results.put("Left Curly Bracket", String.valueOf('{'));
//            } else if (stringToParse.charAt(i) == '}') {
//                results.put(mode,output);
//                results.put("Right Curly Bracket", String.valueOf('}'));
//            } else {
//                if (isChar(String.valueOf(stringToParse.charAt(i)))) {
//                    if (mode == Strings.IDENTIFIER) {
//                        output += String.valueOf(stringToParse.charAt(i));
//                    } else {
//                        if (!isKeyword(String.valueOf(output))) {
//                            objectIndex++;
//                            results.put(Strings.OPERAND + "_" + objectIndex, output);
//                            mode = Strings.IDENTIFIER;
//                            output = String.valueOf(stringToParse.charAt(i));
//                        } else {
//                            error = true;
//                        }
//                    }
//                } else if (isOperator(String.valueOf(stringToParse.charAt(i)))) {
//                    if (mode == Strings.OPERAND) {
//                        output += String.valueOf(stringToParse.charAt(i));
//                    } else {
//                        if (!isKeyword(String.valueOf(output))) {
//                            objectIndex++;
//                            results.put(Strings.IDENTIFIER + "_" + objectIndex, output);
//                            mode = Strings.OPERAND;
//                            output = String.valueOf(stringToParse.charAt(i));
//                        } else {
//                            error = true;
//                        }
//                    }
//                } else {
//                    continue;
//                }
//            }
//        }
//        if (error) {
//            LinkedHashMap<String, String> resErrors = new LinkedHashMap();
//            resErrors.put(Strings.syntaxError, String.valueOf(lineIterator + 1));
//            results.clear();
//            finalOutput.put(String.valueOf(lineIterator + 1), resErrors);
//        } else {
//            finalOutput.put(String.valueOf(lineIterator + 1), results);
//        }
//
//    }
//
//    private void printMap() {
//        Iterator it = finalOutput.entrySet().iterator();
//        while (it.hasNext()) {
//            HashMap.Entry pair = (HashMap.Entry) it.next();
//            System.out.println(Strings.lineNumber + " " + pair.getKey() + " :");
//            LinkedHashMap results = (LinkedHashMap) pair.getValue();
//            Iterator it2 = results.entrySet().iterator();
//            for (int i = 0; i < results.size(); i++) {
//                HashMap.Entry pair2 = (HashMap.Entry) it2.next();
//                System.out.println("    " + ((String) pair2.getKey()).split("_")[0] + " : " + pair2.getValue());
//            }
//        }
//    }
//    
//    public boolean isKeyword(String keyWord) {
//        if (Constants.keyWords.contains(keyWord)) {
//            return true;
//        }
//        return false;
//    }
    
//    private void getTokens(String key, String row, int lineIterator) {
//        if (key.equals(Strings.DECLARATION_NO_VAR_REGEX)) {
//            //No var initialization
//            this.noVar(row, lineIterator);
//        } else if (key.equals(Strings.DECLARATION_VAR_REGEX)) {
//            //var initilization
//            this.var(row, lineIterator);
//        } else if (key.equals(Strings.IF_CONDITION_REGEX)) {
//            this.ifconiditon(row, lineIterator);
//            //if condition
//        } else if (key.equals(Strings.ARTH_REGEX)) {
//            //Arithematic
//            this.arthematic(row, lineIterator);
//        } else if (key.equals(Strings.FUNC_MAIN_REGEX)) {
//            //func main
//            this.funcMain(row, lineIterator);
//        } else if (key.equals(Strings.COMMENT_REGEX)) {
//            //comment
//            this.addComment(row, lineIterator);
//        } else if (key.equals(Strings.BRACKET_REGEX)) {
//            //bracket case
//            this.bracketCase(row, lineIterator);
//        }
//
//    }
    
//    private void checkVRegex(String row, int lineIterator) {
//        Iterator it = Constants.regexHashMap.entrySet().iterator();
//        while (it.hasNext()) {
//            HashMap.Entry pair = (HashMap.Entry) it.next();
//            if (row.matches((String) pair.getValue())) {
//                getTokens((String) pair.getKey(), row, lineIterator);
//            }
//        }
//    }

}
