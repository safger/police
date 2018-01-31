package com.sn.entity;

import java.util.ArrayList;
import java.util.List;

public class jsTree {
	private String id;
	private String text;
	private State state=new State();
	private List<jsTree> children=new ArrayList<jsTree>();
	private String parentid;
	private Integer layer;
	private String icon; 
	//private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id; 
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<jsTree> getChildren() {
		return children;
	}

	public void setChildren(List<jsTree> children) {
		this.children = children;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public Integer getLayer() {
		return layer;
	}

	public void setLayer(Integer layer) {
		this.layer = layer;
	}



	public String getIcon() {
		return icon;
	}
 
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
 