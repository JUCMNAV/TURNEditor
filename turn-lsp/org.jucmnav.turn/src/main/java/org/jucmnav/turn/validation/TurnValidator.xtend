package org.jucmnav.turn.validation

import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.validation.Check
import org.jucmnav.turn.turn.AndFork
import org.jucmnav.turn.turn.URNspec
import org.jucmnav.turn.turn.TurnPackage
import org.jucmnav.turn.turn.Concern
import org.jucmnav.turn.turn.Actor
import org.jucmnav.turn.turn.IntentionalElement
import org.jucmnav.turn.turn.Contribution
import org.jucmnav.turn.turn.Decomposition
import org.jucmnav.turn.turn.Dependency
import org.jucmnav.turn.turn.StrategiesGroup
import org.jucmnav.turn.turn.EvaluationStrategy
import org.jucmnav.turn.turn.ContributionContextGroup
import org.jucmnav.turn.turn.ContributionContext
import org.jucmnav.turn.turn.LinearConversion
import org.jucmnav.turn.turn.QualToQMappings
import org.jucmnav.turn.turn.PathBodyNodes
import org.jucmnav.turn.turn.OrFork
import org.jucmnav.turn.turn.Stub
import org.jucmnav.turn.turn.ScenarioGroup
import org.jucmnav.turn.turn.UCMmap
import org.jucmnav.turn.turn.ScenarioDef
import org.jucmnav.turn.turn.Variable
import org.jucmnav.turn.turn.Initialization
import org.jucmnav.turn.turn.EndpointWithConnect
import org.jucmnav.turn.turn.RespRef
import org.jucmnav.turn.turn.OrJoin
import org.jucmnav.turn.turn.AndJoin
import org.jucmnav.turn.turn.FailurePoint
import org.jucmnav.turn.turn.PathBody

class TurnValidator extends AbstractTurnValidator {
	
	@Check
	def checkAndForkHasAtleastTwoPaths(AndFork andFork) {
		if(andFork.pathbody.size < 2) {
			error("And Fork must have at least two path bodies",TurnPackage.Literals.AND_FORK__PATHBODY)
		}
	}
	
	@Check
	def checkConcernHasUniqueName(Concern obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (Concern concern : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!concern.name.empty && concern.name == obj.name && concern != obj )	
					error("Concern name must be unique",TurnPackage.Literals.CONCERN__NAME)
				if(!concern.longName.longname.empty && concern.longName.longname.equals(obj.longName.longname) && concern != obj )	
					error("Concern longname must be unique",TurnPackage.Literals.CONCERN__LONG_NAME);
		}
	}
	
	@Check
	def checkActorHasUniqueName(Actor obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (Actor actor : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!actor.name.empty && actor.name == obj.name && actor != obj )	
					error("Actor name must be unique",TurnPackage.Literals.ACTOR__NAME)
				if(!actor.longName.longname.empty && actor.longName.longname.equals(obj.longName.longname) && actor != obj )	
					error("Actor longname must be unique",TurnPackage.Literals.ACTOR__LONG_NAME);
		}
	}
	
	@Check
	def checkIntElementHasUniqueName(IntentionalElement obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (IntentionalElement intElem : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!intElem.name.empty && intElem.name == obj.name && intElem != obj )	
					error("IntentionalElement name must be unique",TurnPackage.Literals.INTENTIONAL_ELEMENT__NAME)
				if(!intElem.longName.longname.empty && intElem.longName.longname.equals(obj.longName.longname) && intElem != obj )	
					error("IntentionalElement longname must be unique",TurnPackage.Literals.INTENTIONAL_ELEMENT__LONG_NAME);
		}
	}
	
	@Check
	def checkContributionHasUniqueName(Contribution obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (Contribution cont : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!cont.name.empty && cont.name == obj.name && cont != obj )	
					error("Contribution name must be unique",TurnPackage.Literals.CONTRIBUTION__NAME);
				if(!cont.longName.longname.empty && cont.longName.longname.equals(obj.longName.longname) && cont != obj )	
					error("Contribution longname must be unique",TurnPackage.Literals.CONTRIBUTION__LONG_NAME);
		}
	}
	
	@Check
	def checkDecompositionHasUniqueName(Decomposition obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (Decomposition decomp : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!decomp.name.empty && decomp.name == obj.name && decomp != obj )	
					error("Decomposition name must be unique",TurnPackage.Literals.DECOMPOSITION__NAME)
				if(!decomp.longName.longname.empty && decomp.longName.longname.equals(obj.longName.longname) && decomp != obj )	
					error("Decomposition longname must be unique",TurnPackage.Literals.DECOMPOSITION__LONG_NAME);
		}
	}
	
	@Check
	def checkDependencyHasUniqueName(Dependency obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (Dependency dep : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!dep.name.empty && dep.name == obj.name && dep != obj )	
					error("Dependency name must be unique",TurnPackage.Literals.DEPENDENCY__NAME)
				if(!dep.longName.longname.empty && dep.longName.longname.equals(obj.longName.longname) && dep != obj )	
					error("Dependency longname must be unique",TurnPackage.Literals.DEPENDENCY__LONG_NAME);
		}
	}
	
	@Check
	def checkStrategiesGroupHasUniqueName(StrategiesGroup obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (StrategiesGroup sg : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!sg.name.empty && sg.name == obj.name && sg != obj )	
					error("StrategiesGroup name must be unique",TurnPackage.Literals.STRATEGIES_GROUP__NAME)
				if(!sg.longName.longname.empty && sg.longName.longname.equals(obj.longName.longname) && sg != obj )	
					error("StrategiesGroup longname must be unique",TurnPackage.Literals.STRATEGIES_GROUP__LONG_NAME);
		}
	}
	
	@Check
	def checkStrategyHasUniqueName(EvaluationStrategy obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (EvaluationStrategy sg : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!sg.name.empty && sg.name == obj.name && sg != obj )	
					error("EvaluationStrategy name must be unique",TurnPackage.Literals.EVALUATION_STRATEGY__NAME)
				if(!sg.longName.longname.empty && sg.longName.longname.equals(obj.longName.longname) && sg != obj )	
					error("EvaluationStrategy longname must be unique",TurnPackage.Literals.EVALUATION_STRATEGY__LONG_NAME)
		}
	}
	
	@Check
	def checkContribContextGroupHasUniqueName(ContributionContextGroup obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (ContributionContextGroup sg : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!sg.name.empty && sg.name == obj.name && sg != obj )	
					error("ContributionContextGroup name must be unique",TurnPackage.Literals.CONTRIBUTION_CONTEXT_GROUP__NAME)
				if(!sg.longName.longname.empty && sg.longName.longname.equals(obj.longName.longname) && sg != obj )	
					error("ContributionContextGroup longname must be unique",TurnPackage.Literals.CONTRIBUTION_CONTEXT_GROUP__LONG_NAME);
		}
	}
	
	@Check
	def checkContribContextHasUniqueName(ContributionContext obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (ContributionContext cc : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!cc.name.empty && cc.name == obj.name && cc != obj )	
					error("ContributionContextGroup name must be unique",TurnPackage.Literals.CONTRIBUTION_CONTEXT__NAME)
				if(!cc.longName.longname.empty && cc.longName.longname.equals(obj.longName.longname) && cc != obj )	
					error("ContributionContextGroup longname must be unique",TurnPackage.Literals.CONTRIBUTION_CONTEXT__LONG_NAME);
		}
	}
	
	@Check
	def checkLinearConversionHasUniqueName(LinearConversion obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (LinearConversion lc : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!lc.name.empty && lc.name == obj.name && lc != obj )	
					error("LinearConversion name must be unique",TurnPackage.Literals.LINEAR_CONVERSION__NAME)
				if(!lc.longName.longname.empty && lc.longName.longname.equals(obj.longName.longname) && lc != obj )	
					error("LinearConversion longname must be unique",TurnPackage.Literals.LINEAR_CONVERSION__LONG_NAME);
		}
	}
	
	@Check
	def checkQualToQMappingsHasUniqueName(QualToQMappings obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (QualToQMappings mc : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
				if(!mc.name.empty && mc.name == obj.name && mc != obj )	
					error("QualToQMappings name must be unique",TurnPackage.Literals.QUAL_TO_QMAPPINGS__NAME)
				if(!mc.longName.longname.empty && mc.longName.longname.equals(obj.longName.longname) && mc != obj )	
					error("QualToQMappings longname must be unique",TurnPackage.Literals.QUAL_TO_QMAPPINGS__LONG_NAME);
		}
	}
	
	@Check
	def testOrder(PathBodyNodes mc) {
		if(mc.referencedStub !== null && mc.pathEnd !== null)
			error("Wrong order of reference",TurnPackage.Literals.PATH_BODY__REFERENCED_STUB);
		if(mc.referencedEnd !== null && mc.pathEnd !== null)
			error("Wrong order of reference",TurnPackage.Literals.PATH_BODY__REFERENCED_END);
		
	}
	
	@Check
	def testOrder2(PathBodyNodes mc) {
		val of=EcoreUtil2.getContainerOfType(mc,OrFork)
		val af=EcoreUtil2.getContainerOfType(mc,AndFork)
		val stub=EcoreUtil2.getContainerOfType(mc,Stub)
		if(mc.referencedStub === null && mc.pathEnd === null && mc.pathNodes.size == 0 && mc.referencedEnd === null){
			if(of === null && af === null && stub === null){
				error("Wrong order of reference",TurnPackage.Literals.PATH_BODY_NODES__PATH_NODES);}
		}
	}
	
	@Check
	def checkMapHasUniqueName(UCMmap obj) {
		val spec = obj.eContainer as URNspec;
		spec.ucmMaps.forEach[ map | 
			if(!map.name.empty && map.name == obj.name && map != obj ){
				error("Map name must be unique",TurnPackage.Literals.UC_MMAP__NAME);
			}
			if(!map.longName?.longname.nullOrEmpty && map.longName.longname.equals(obj.longName.longname) && map != obj){
				error("Map longname must be unique",TurnPackage.Literals.UC_MMAP__LONG_NAME);
			}
		];
	}
	
	@Check
	def checkScenarioGroupHasUniqueName(ScenarioGroup obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (ScenarioGroup group : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) { 
				if(!group.name.empty && group.name == obj.name && group != obj )	
					error("Scenario group name must be unique",TurnPackage.Literals.SCENARIO_GROUP__NAME)
				if(!group.longName.longname.empty && group.longName.longname.equals(obj.longName.longname) && group != obj )	
					error("Scenario group longname must be unique",TurnPackage.Literals.SCENARIO_GROUP__LONG_NAME);
		}
	}
	
	@Check
	def checkScenarioDefHasUniqueName(ScenarioDef obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (ScenarioDef definition : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) { 
				if(!definition.name.empty && definition.name == obj.name && definition != obj )	
					error("Scenario definition name must be unique",TurnPackage.Literals.SCENARIO_DEF__NAME)
				if(!definition.longName.longname.empty && definition.longName.longname.equals(obj.longName.longname) && definition != obj )	
					error("Scenario definition longname must be unique",TurnPackage.Literals.SCENARIO_DEF__LONG_NAME);
		}
	}
	
	@Check
	def checkVariableHasUniqueName(Variable obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (Variable variable : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) { 
				if(!variable.name.empty && variable.name == obj.name && !variable.equals(obj) )	
					error("Variable name must be unique",TurnPackage.Literals.VARIABLE__NAME)
		}
	}
	
	@Check
	def checkVariableHasUniqueInitialization(Initialization obj) {
		val scenariodef = EcoreUtil2.getContainerOfType(obj, ScenarioDef)
		for (Initialization init : scenariodef.initializations) { 
				if(!init.variable.equals(null) && init.variable.equals(obj.variable) && !init.equals(obj) )	
					error("Variable already initialized in scenario definition",TurnPackage.Literals.INITIALIZATION__VARIABLE)
		}
	}
	
	@Check
	def checkEnumLiteralInitializationValue(Initialization obj) {
		val literal = obj.value
		val enumType = obj.variable.enumerationType
		if(!enumType.values.contains(literal))
			error("Enum literal does not exist in variable's enumeration type",TurnPackage.Literals.INITIALIZATION__VALUE)
	}
	
	@Check
	def checkOrFork(OrFork orFork){
		if(orFork.getBody().regularBody.size < 2){
			
		}else{
			orFork.getBody().regularBody.forEach[ rof |
				hasPathBodyEnd(rof.pathBody);
			];
		}
		
	}
	
	def boolean hasPathBodyEnd(PathBody pathBody){
		var hasEnd = false;
		val pathEnd = pathBody.pathEnd;
		val referencedEnd = pathBody.referencedEnd;
		val referencedStub = pathBody.referencedStub;
		if(pathEnd !== null){
			if(pathEnd instanceof EndpointWithConnect){
				hasEnd = true;
			}else if(pathEnd instanceof AndFork){
				hasPathBodyEnd((pathEnd as AndFork).connectingAndBody);				
			}else if(pathEnd instanceof OrFork){
				hasPathBodyEnd((pathEnd as OrFork).connectingOrBody);
			}else if(pathEnd instanceof Stub){
				hasPathBodyEnd((pathEnd as Stub).connectingStubBody);
			}
		}else if(referencedEnd !== null){
			if(referencedEnd instanceof RespRef){
				
			}else if(referencedEnd instanceof OrJoin){
				
			}else if(referencedEnd instanceof Stub){
				
			}else if(referencedEnd instanceof AndJoin){
				
			}else if(referencedEnd instanceof FailurePoint){
				
			}
		}else if(referencedStub !== null){
			
		}else{
			return false;
		}
		return hasEnd;
	}
		
}
