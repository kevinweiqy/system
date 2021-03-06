package com.entor.model;

import java.util.List;
import java.util.Map;

public class QxInfoTree {
	private int id;
	private String text;
	private String url;
	private List<QxInfoTree> children;
	private Map<String ,Object> attributes;
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<QxInfoTree> getChildren() {
		return children;
	}
	public void setChildren(List<QxInfoTree> children) {
		this.children = children;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
