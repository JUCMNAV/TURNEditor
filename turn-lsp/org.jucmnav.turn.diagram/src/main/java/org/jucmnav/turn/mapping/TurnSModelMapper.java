package org.jucmnav.turn.mapping;

import org.jucmnav.turn.diagram.TurnDiagramStateHandler;
import org.jucmnav.turn.diagram.TurnResourceHandler;
import org.jucmnav.turn.sprotty.ActorSModel;
import org.jucmnav.turn.sprotty.AndForkSModel;
import org.jucmnav.turn.sprotty.AndJoinSModel;
import org.jucmnav.turn.sprotty.ConnectingBodySModel;
import org.jucmnav.turn.sprotty.OrForkSModel;
import org.jucmnav.turn.sprotty.OrJoinSModel;
import org.jucmnav.turn.sprotty.RespRefSModel;
import org.jucmnav.turn.sprotty.StartPointSModel;
import org.jucmnav.turn.sprotty.StubSModel;
import org.jucmnav.turn.sprotty.TurnSModel;
import org.jucmnav.turn.sprotty.UCMmapSModel;
import org.jucmnav.turn.turn.Actor;
import org.jucmnav.turn.turn.AndFork;
import org.jucmnav.turn.turn.AndJoin;
import org.jucmnav.turn.turn.OrFork;
import org.jucmnav.turn.turn.OrJoin;
import org.jucmnav.turn.turn.PathBody;
import org.jucmnav.turn.turn.RespRef;
import org.jucmnav.turn.turn.StartPoint;
import org.jucmnav.turn.turn.Stub;
import org.jucmnav.turn.turn.UCMmap;
import org.jucmnav.turn.turn.URNmodelElement;

public class TurnSModelMapper {
	
	private TurnResourceHandler turnResourceHandler;
	private TurnDiagramStateHandler turnDiagramStateHandler;
	
	public TurnSModelMapper(TurnResourceHandler turnResourceHandler, TurnDiagramStateHandler turnDiagramStateHandler) {
		this.turnResourceHandler = turnResourceHandler;
		this.turnDiagramStateHandler = turnDiagramStateHandler;
	}
	
	public TurnSModel mapTurnSourceToSModel() {
		String sourceName = turnDiagramStateHandler.getSourceName();
		URNmodelElement urnModelElement = turnResourceHandler.getTurnElementFromName(sourceName);
		return mapURNmodelElementToSModelRoot(urnModelElement);
	}
	
	private TurnSModel mapURNmodelElementToSModelRoot(URNmodelElement urnModelElement) throws IllegalArgumentException {
		TurnSModel turnSModel = null;
		if(urnModelElement instanceof Actor) {
			turnSModel = new ActorSModel((Actor) urnModelElement);
		}else if(urnModelElement instanceof UCMmap) {
			turnSModel = new UCMmapSModel((UCMmap) urnModelElement);
		}else {
			throw new IllegalArgumentException("No corresponding SModelRoot for given URN element.");
		}
		return turnSModel;
	}
	
	public static TurnSModel mapURNmodelElementToSModel(URNmodelElement urnModelElement) throws IllegalArgumentException{
		TurnSModel turnSModel = null;
		if(urnModelElement instanceof RespRef) {
			turnSModel = new RespRefSModel((RespRef) urnModelElement);
		}else if(urnModelElement instanceof AndJoin) {
			turnSModel = new AndJoinSModel((AndJoin) urnModelElement);
		}else if(urnModelElement instanceof OrJoin) {
			turnSModel = new OrJoinSModel((OrJoin) urnModelElement);
		}else if(urnModelElement instanceof AndFork){
			turnSModel = new AndForkSModel((AndFork) urnModelElement);
		}else if(urnModelElement instanceof OrFork){
			turnSModel = new OrForkSModel((OrFork) urnModelElement);
		}else if(urnModelElement instanceof Stub){
			turnSModel = new StubSModel((Stub) urnModelElement);
		}else if(urnModelElement instanceof StartPoint){
			turnSModel = new StartPointSModel((StartPoint) urnModelElement);
		}else if(urnModelElement instanceof OrJoin){
			turnSModel = new OrJoinSModel((OrJoin) urnModelElement);
		}else if(urnModelElement instanceof PathBody){
			turnSModel = new ConnectingBodySModel((PathBody) urnModelElement);
		}else {
			throw new IllegalArgumentException("No corresponding SModel for given URN element");
		}
		return turnSModel;
	}
}
