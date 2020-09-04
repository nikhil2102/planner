package com.kronos.sprint.planner.entity.sprint;

public class EpicField{
	private String renderer;
	private String epicKey;
	private boolean editable;
	private String id;
	private String label;
	private String epicColor;
	private String text;
	private boolean canRemoveEpic;

	public String getRenderer(){
		return renderer;
	}

	public String getEpicKey(){
		return epicKey;
	}

	public boolean isEditable(){
		return editable;
	}

	public String getId(){
		return id;
	}

	public String getLabel(){
		return label;
	}

	public String getEpicColor(){
		return epicColor;
	}

	public String getText(){
		return text;
	}

	public boolean isCanRemoveEpic(){
		return canRemoveEpic;
	}
}
