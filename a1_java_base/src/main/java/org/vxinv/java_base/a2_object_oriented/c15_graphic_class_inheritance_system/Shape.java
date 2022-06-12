package org.vxinv.java_base.a2_object_oriented.c15_graphic_class_inheritance_system;

public class Shape {
	private static final String DEFAULT_COLOR = "black";

	private String color;

	public Shape() {
		this(DEFAULT_COLOR);
	}

	public Shape(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void draw(){
		System.out.println("draw shape");
	}
}
