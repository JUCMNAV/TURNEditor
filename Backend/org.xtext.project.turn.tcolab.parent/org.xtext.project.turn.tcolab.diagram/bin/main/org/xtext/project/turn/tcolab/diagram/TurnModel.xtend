package org.xtext.project.turn.tcolab.diagram

import io.typefox.sprotty.api.SCompartment
import io.typefox.sprotty.api.SLabel
import io.typefox.sprotty.api.SNode
import io.typefox.sprotty.server.xtext.tracing.Traceable

import io.typefox.sprotty.api.SShapeElement
import io.typefox.sprotty.api.Layouting
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
abstract class TURNNodeClassified extends SNode implements Traceable {
	String cssClass
	String trace
}

@Accessors
abstract class TURNNode extends TURNNodeClassified {
	Boolean expanded
}

@Accessors
abstract class MAPStartNode extends TURNNodeClassified {
	Boolean expanded
}

@Accessors
class TURNHeaderNode extends SCompartment {
	String cssClass
}

@Accessors
class MAPStartHeaderNode extends SCompartment {
	String cssClass
}

@Accessors
abstract class TURNLabel extends SLabel implements Traceable {
	String trace
}

@Accessors
abstract class MAPStartLabel extends SLabel implements Traceable {
	String trace
}

@Accessors 
abstract class TURNTag extends SShapeElement implements Layouting {
	String layout
	
	new() {}
	new((TURNTag)=>void initializer) {
		initializer.apply(this)
	}
}


@Accessors 
abstract class MAPStartTag extends SShapeElement implements Layouting {
	String layout
	
	new() {}
	new((MAPStartTag)=>void initializer) {
		initializer.apply(this)
	}
}