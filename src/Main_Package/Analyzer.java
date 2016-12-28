package Main_Package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 *
 * @author ninja
 */
public class Analyzer {

    private String fileName;
    private String row;
    private Strings str;
    private LinkedHashMap<String, HashMap> finalOutput;
    
    private LinkedHashMap<String, ArrayList> output;
    
    //TO create tree, create an array list of nodes
    
    private enum tokenFlags {
        NONE,
        IDENTIFIER,
        OPERAND,
        DotEq,
        IF_CONDITION,
        L_BRACK,
        R_BRACK,
        L_CURLY,
        R_CURLY,
        SEMI_COLOUMN,
        KEYWORD,
        comma
    };

    public Analyzer(String fileName) throws FileNotFoundException, IOException {
        this.finalOutput = new LinkedHashMap();
        this.output = new LinkedHashMap();
        str = new Strings();
        this.fileName = fileName;
        this.run(new BufferedReader(new FileReader(Constants.Location + this.fileName)));
    }

    private boolean checkDirectory() {
        File filecheck = new File(Constants.Location + this.fileName);
        boolean check = (filecheck.isFile()) ? true : false;
        return check;
    }

    public void run(BufferedReader br) throws IOException {
        int lineIterator = 0;
        if (this.checkDirectory()) {
            while ((row = br.readLine()) != null) {
                DFA(row,lineIterator);
                lineIterator++;
            }
        }
    }
    
    public void DFA(String row, int lineIterator) {
        tokenFlags tf = tokenFlags.NONE;
        ArrayList<token> lineData = new ArrayList<token>();
        String data = "";
        for (int i = 0; i < row.length(); i++) {    
            token _tObj = new token();
            if (this.isSpace(String.valueOf(row.charAt(i)))) {
                continue;
            } else if(this.isChar(String.valueOf(row.charAt(i)))) {
                switch (tf) {
                    case NONE :
                        data += String.valueOf(row.charAt(i));
                        tf = tokenFlags.IDENTIFIER;
                        break;
                    case IDENTIFIER : 
                        data += String.valueOf(row.charAt(i));
                        break;
                    default :
                        if(isKeyword(data))
                            tf = tokenFlags.KEYWORD;
                        _tObj.type = tf.toString();
                        _tObj.content = data;
                        lineData.add(_tObj);
                        data = String.valueOf(row.charAt(i));
                        tf = tokenFlags.IDENTIFIER;
                        break;
                }
            } else if (this.isBracket(String.valueOf(row.charAt(i)))) {
                if(isKeyword(data))
                    tf = tokenFlags.KEYWORD;
                _tObj.type = tf.toString();
                _tObj.content = data;
                lineData.add(_tObj);
                if(String.valueOf(row.charAt(i)).equals("(")) {
                    tf = tokenFlags.L_BRACK;
                } else if(String.valueOf(row.charAt(i)).equals(")")) {
                    tf = tokenFlags.R_BRACK;
                } else if(String.valueOf(row.charAt(i)).equals("{")) {
                    tf = tokenFlags.L_CURLY;
                } else if(String.valueOf(row.charAt(i)).equals("}")) {
                    tf = tokenFlags.R_CURLY;
                }
                data = String.valueOf(row.charAt(i));
            } else if (this.isOperand(String.valueOf(row.charAt(i)))) {
                if(isKeyword(data))
                    tf = tokenFlags.KEYWORD;
                _tObj.type = tf.toString();
                _tObj.content = data;
                data = String.valueOf(row.charAt(i));
                lineData.add(_tObj);
                tf = tokenFlags.OPERAND;
            } else if (this.isDotEq(String.valueOf(row.charAt(i)))) {
                if(isKeyword(data))
                    tf = tokenFlags.KEYWORD;
                _tObj.type = tf.toString();
                _tObj.content = data;
                if(String.valueOf(row.charAt(i)).equals(":")
                        && String.valueOf(row.charAt(i+1)).equals("=")) {
                   data = String.valueOf(row.charAt(i)) + String.valueOf(row.charAt(i+1)); 
                } else {
                    data = String.valueOf(row.charAt(i));
                }
                lineData.add(_tObj);
                tf = tokenFlags.DotEq;
                i++;
            }
        }
        if (data != "") {
            token _tObj = new token();
            _tObj.type = tf.toString();
            _tObj.content = data;
            lineData.add(_tObj);
        }
        output.put(String.valueOf(lineIterator), lineData);
        for (int i = 0; i < output.size(); i++) {
            ArrayList<token> tokens = output.get(String.valueOf(i));
            for (int j = 0; j < tokens.size(); j++) {
                System.out.println("CONTENT : " + tokens.get(j).content);
                System.out.println("TYPE : " + tokens.get(j).type);
                System.out.println();
            }
        }
        Parser parser = new Parser(output);
    }

    public boolean isChar(String str) {
        return str.matches("[A-Za-z0-9_]");
    }

    public boolean isInt(String str) {
        return str.matches("([0-9])+");
    }

    public boolean isDotEq(String str) {
        return str.matches("[:=]");
    }

    public boolean isBracket(String str) {
        return str.matches("[(/)/{/}/]");
    }
    
    public boolean isSpace(String str) {
        return str.matches(" ");
    }
    
    public boolean isOperand(String str) {
        return str.matches("[+-/*]");
    }

    public boolean isKeyword(String keyWord) {
        if (Constants.keyWords.contains(keyWord)) {
            return true;
        }
        return false;
    }

}
