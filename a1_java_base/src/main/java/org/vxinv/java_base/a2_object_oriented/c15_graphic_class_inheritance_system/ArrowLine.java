package org.vxinv.java_base.a2_object_oriented.c15_graphic_class_inheritance_system;

// 4.1 基本概念
public class ArrowLine extends Line {

	private boolean startArrow;
	private boolean endArrow;

	public ArrowLine(Point start, Point end, String color,
			boolean startArrow, boolean endArrow) {
		super(start, end, color);
		this.startArrow = startArrow;
		this.endArrow = endArrow;
	}

	@Override
	public void draw() {
		super.draw();
		if(startArrow){
			System.out.println("draw start arrow");
		}
		if(endArrow){
			System.out.println("draw end arrow");
		}
	}
}


