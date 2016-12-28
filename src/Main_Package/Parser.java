package Main_Package;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Stack;

/**
 *
 * @author ninja
 */
public class Parser {

    private LinkedHashMap<String, ArrayList> output;
    private int tokenIndex = 0;
    private Stack<String> stack;
    private String token;
    private String top;
    private Boolean flag = false; // this flag is used to break out of the loop and check for syntax eror 

    public Parser(LinkedHashMap output) {

        stack = new Stack<String>();
        this.output = output;
        addDollarSign();
        run();

    }

    private void addDollarSign() {
        token t = new token();
        t.content = "";
        t.type = "$";
        for (int i = 0; i < output.size(); i++) {
            ArrayList<token> tokens = output.get(String.valueOf(i));
            tokens.add(t);
            output.put(String.valueOf(i), tokens);
        }
    }

    private void run() {

        //push the head of the grammer in the stack
        this.stack.push(Constants.nonTerminals[0]);

        for (int i = 0; i < output.size(); i++) {
            ArrayList<token> tokens = output.get(String.valueOf(i));
            while (tokenIndex < tokens.size()) {

                token = tokens.get(tokenIndex).type;

                if (flag || this.stack.empty()) {
                    break;
                }

                top = this.stack.pop();

                //put the rule in the stack 
                if (isNonTerminal(top)) {
                    putRule(top, token);

                    /*put in tree here*/
                    
                    //there is a match 
                } else if (isTerminal(top)) {
                    tokenIndex++;
                }
            }

            if (flag) {
                System.out.println("syntax error");
            } else {
                System.out.println("accepted");
            }
        }
    }

    //check if the string is terminal string   
    private Boolean isTerminal(String top) {
        for (int i = 0; i < Constants.terminals.length; i++) {
            if (Constants.terminals[i].equals(top)) {
                return true;
            }
        }
        return false;
    }

    //check if the string is non terminal string
    private Boolean isNonTerminal(String top) {
        for (int i = 0; i < Constants.nonTerminals.length; i++) {
            if (Constants.nonTerminals[i].equals(top)) {
                return true;
            }
        }
        return false;
    }

//get the rule from the parsing table which intersect with non terminal string and terminal string  
    private void putRule(String nonTerminalString, String TerminalString) {

        int row = getNonTerminalIndex(nonTerminalString);
        int column = getTerminalIndex(TerminalString);

        String match = Constants.parsingTable[row][column];
        
        //match is null, means that we should break out of the loop
        if (match == null) {
            this.flag = true;
        } else {
            String[] matchedArry = match.split(" ");

            for (int i = 0; i < matchedArry.length; i++) {
                this.stack.push(matchedArry[matchedArry.length - 1 - i]);
            }
        }
    }

//return the index of a string in the terminal array
    private int getTerminalIndex(String ter) {
        for (int i = 0; i < Constants.terminals.length; i++) {
            if (Constants.terminals[i].equals(ter)) {
                return i;
            }
        }
        return 0;
    }

//return the index of a string in the non terminal array
    private int getNonTerminalIndex(String non) {
        for (int i = 0; i < Constants.nonTerminals.length; i++) {
            if (Constants.nonTerminals[i].equals(non)) {
                return i;
            }
        }
        return 0;
    }

}
