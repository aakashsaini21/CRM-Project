package org.eclipse.wb.swing;

import javax.swing.tree.DefaultMutableTreeNode;

public class TreeDemoo {
	
	public TreeDemoo(){
	DefaultMutableTreeNode top = new DefaultMutableTreeNode("OrderId");
	}
	public void createNodes(DefaultMutableTreeNode top){
		DefaultMutableTreeNode category = null;
	    DefaultMutableTreeNode book = null;
	    
	    category = new DefaultMutableTreeNode("Books for Java Programmers");
	    top.add(category);
	    
	    
	}
}


