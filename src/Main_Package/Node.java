/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Package;

import java.util.ArrayList;

/**
 *
 * @author omarkrostom
 */
public class Node {
    public ArrayList<Node> children = new ArrayList<Node>();
    public Node parent;
    public String data;
    public boolean root;
    
    public Node (String data) {
        this.data = data;
    }
    
    public Node(String data, Node parent) {
        this.data = data;
        this.parent = parent;
    }
    
    public ArrayList<Node> getChildren() {
        return this.children;
    }
    
    public void addChild(String data) {
        Node node = new Node(data,this);
        this.children.add(node);
    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public boolean isRoot() {
        if(this.parent==null)
            return true;
        else
            return false;
    }
}
