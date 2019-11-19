package org.jucmnav.turn.sprotty;

import java.util.AbstractMap.SimpleEntry;

import org.jucmnav.turn.turn.URNmodelElement;

public class PathPair extends SimpleEntry<URNmodelElement, URNmodelElement> {

	private static final long serialVersionUID = 6758353887777392967L;

	public PathPair(URNmodelElement source, URNmodelElement target) {
		super(source, target);
	}
	
	public URNmodelElement getSource() {
		return this.getKey();
	}
	
	public URNmodelElement getTarget() {
		return this.getValue();
	}
	
	@Override
	public String toString() {
		return "[" + this.getKey() + " -> " + this.getValue() + "]";
	}

}
