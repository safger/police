package com.sn.entity;

public class State {
	private Boolean opened;
	private Boolean selected;
	 
	public State(){
		opened=false;   
		selected=false; 
	}
	
	public Boolean getOpened() {
		return opened;
	}
	public void setOpened(Boolean opened) {
		this.opened = opened;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
}
