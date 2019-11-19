package org.jucmnav.turn.diagram;

import org.jucmnav.turn.turn.AndFork;
import org.jucmnav.turn.turn.AndJoin;
import org.jucmnav.turn.turn.EndPoint;
import org.jucmnav.turn.turn.OrFork;
import org.jucmnav.turn.turn.OrJoin;
import org.jucmnav.turn.turn.PathBody;
import org.jucmnav.turn.turn.RespRef;
import org.jucmnav.turn.turn.StartPoint;
import org.jucmnav.turn.turn.Stub;
import org.jucmnav.turn.turn.URNmodelElement;
import io.typefox.sprotty.api.SEdge;
import io.typefox.sprotty.api.SModelElement;

public class ModelElementGenerator {
	
	private static final String STARTPOINT_TYPE = "turnnode:startpoint";
	private static final String RESPREF_TYPE = "turnnode:responsibility";
	private static final String ENDPOINT_TYPE = "turnnode:endpoint";
	private static final String EDGE_TYPE = "edge:connection";
	private static final String ANDFORK_TYPE = "turnnode:andFork";
	private static final String ORFORK_TYPE = "turnnode:orFork";
	private static final String ANDJOIN_TYPE = "turnnode:andJoin";
	private static final String ORJOIN_TYPE = "turnnode:orJoin";
	private static final String STUB_TYPE = "turnnode:stub";
	private static final String UNKNOWN_TYPE = "unknown";
	
	public static SModelElement createTurnNode(URNmodelElement urnElement) {
		return new TURNNode(t -> {
			t.setType(getModelElementTypeFromURNElement(urnElement));
			t.setId(Integer.toHexString(urnElement.hashCode()));
		});
	}
	
	public static SModelElement createTurnEdge(SModelElement source, SModelElement target) {
		return new SEdge(e -> {
			e.setType(EDGE_TYPE);
			e.setId(createEdgeId(source, target));
			e.setSourceId(source.getId());
			e.setTargetId(target.getId());
		});
	}
	
	public static String createEdgeId(SModelElement source, SModelElement target) {
		return String.format("edge-%s-to-%s", source.getId(), target.getId());
	}
	
	private static String getModelElementTypeFromURNElement(URNmodelElement urnElement) {		
		String type;		
		if(urnElement instanceof StartPoint) {
			type = STARTPOINT_TYPE;
		}else if(urnElement instanceof EndPoint) {
			type = ENDPOINT_TYPE;
		}else if(urnElement instanceof RespRef) {
			type = RESPREF_TYPE;
		}else if(urnElement instanceof AndFork) {
			type = ANDFORK_TYPE;
		}else if(urnElement instanceof OrFork) {
			type = ORFORK_TYPE;
		}else if(urnElement instanceof AndJoin || (urnElement instanceof PathBody && urnElement.eContainer() instanceof AndFork)) {
			type = ANDJOIN_TYPE;
		}else if(urnElement instanceof OrJoin || (urnElement instanceof PathBody && urnElement.eContainer() instanceof OrFork)) {
			type = ORJOIN_TYPE;
		}else if(urnElement instanceof Stub) {
			type = STUB_TYPE;
		}else {
			type = UNKNOWN_TYPE;
		}
		return type;
	}

}
