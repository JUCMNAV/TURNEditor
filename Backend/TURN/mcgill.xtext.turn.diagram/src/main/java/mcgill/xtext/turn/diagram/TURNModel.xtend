package mcgill.xtext.turn.diagram

import io.typefox.sprotty.api.SCompartment
import io.typefox.sprotty.api.SLabel
import io.typefox.sprotty.api.SNode
import io.typefox.sprotty.server.xtext.tracing.Traceable
import org.eclipse.xtend.lib.annotations.Accessors
import io.typefox.sprotty.api.SShapeElement
import io.typefox.sprotty.api.Layouting

@Accessors
class TURNNodeClassified extends SNode implements Traceable {
	String cssClass
	String trace
}

@Accessors
class TURNNode extends TURNNodeClassified {
	Boolean expanded
}

@Accessors
class MAPStartNode extends TURNNodeClassified {
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
class TURNLabel extends SLabel implements Traceable {
	String trace
}

@Accessors
class MAPStartLabel extends SLabel implements Traceable {
	String trace
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