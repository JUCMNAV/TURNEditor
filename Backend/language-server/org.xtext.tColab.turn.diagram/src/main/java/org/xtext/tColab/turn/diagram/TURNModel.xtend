package org.xtext.tColab.turn.diagram

import org.eclipse.sprotty.Layouting

import org.eclipse.sprotty.SNode

import org.eclipse.sprotty.SShapeElement
import org.eclipse.xtend.lib.annotations.Accessors



@Accessors
class TURNNode extends SNode {
	Boolean expanded
}

@Accessors
class TURNLabel extends SShapeElement implements Layouting {
		String layout
	
	new() {}
	new((TURNLabel)=>void initializer) {
		initializer.apply(this)
	}
}



@Accessors 
class TURNTag extends SShapeElement implements Layouting {
	String layout
	
	new() {}
	new((TURNTag)=>void initializer) {
		initializer.apply(this)
	}
}


@Accessors 
class MAPStartTag extends SShapeElement implements Layouting {
	String layout
	
	new() {}
	new((MAPStartTag)=>void initializer) {
		initializer.apply(this)
	}
}
