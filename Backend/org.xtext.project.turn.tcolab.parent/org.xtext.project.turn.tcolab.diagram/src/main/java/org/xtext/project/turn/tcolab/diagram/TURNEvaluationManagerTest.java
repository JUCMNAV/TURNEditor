package mcgill.xtext.turn.diagram;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xtext.example.mydsl.tURN.Actor;
import org.xtext.example.mydsl.tURN.Contribution;
import org.xtext.example.mydsl.tURN.Decomposition;
import org.xtext.example.mydsl.tURN.DecompositionType;
import org.xtext.example.mydsl.tURN.Dependency;
import org.xtext.example.mydsl.tURN.ElementLink;
import org.xtext.example.mydsl.tURN.Evaluation;
import org.xtext.example.mydsl.tURN.EvaluationStrategy;
import org.xtext.example.mydsl.tURN.IntentionalElement;
import org.xtext.example.mydsl.tURN.IntentionalElementType;
import org.xtext.example.mydsl.tURN.LongName;
import org.xtext.example.mydsl.tURN.TURNFactory;
import org.xtext.example.mydsl.tURN.URNspec;
import org.xtext.example.mydsl.tURN.impl.TURNFactoryImpl;

public class TURNEvaluationManagerTest {

	private TURNFactory factory = new TURNFactoryImpl();
	private IntentionalElement elem1;
	private IntentionalElement elem2;
	private IntentionalElement elem3;
	private IntentionalElement elem4;
	private IntentionalElement elem5;
	private IntentionalElement elem6;
	private EvaluationStrategy strategy;
	private URNspec urnSpec;
	private Actor actor;
	private Actor actor2;

	@Before
	public void nullVariables() {
		elem1 = null;
		elem2 = null;
		elem3 = null;
		elem4 = null;
		elem5 = null;
		elem6 = null;
		strategy = null;
		urnSpec = null;
		actor = null;
		actor2 = null;
	}

	private void createFirstActorStrategyIntentionalElements1to2() {
		urnSpec = factory.createURNspec();
		urnSpec.setName("urnSpec1");
		
		actor = factory.createActor();
		actor.setName("actor1");
		urnSpec.getActors().add(actor);

		elem1 = factory.createIntentionalElement();
		elem1.setType(IntentionalElementType.SOFTGOAL);
		elem1.setName("elem1");
		actor.getElems().add(elem1); 
		
		elem2 = factory.createIntentionalElement();
		elem2.setType(IntentionalElementType.GOAL);
		elem2.setName("elem2");
		actor.getElems().add(elem2);
		
		strategy = factory.createEvaluationStrategy();
		strategy.setName("strategy1");
		urnSpec.getStrategies().add(strategy);
	}
	
	private void createFirstActorStrategyIntentionalElements1to4() {
		createFirstActorStrategyIntentionalElements1to2();

		elem3 = factory.createIntentionalElement();
		elem3.setType(IntentionalElementType.GOAL);
		elem3.setName("elem3");
		actor.getElems().add(elem3);
		
		elem4 = factory.createIntentionalElement();
		elem4.setType(IntentionalElementType.BELIEF);
		elem4.setName("elem4");
		actor.getElems().add(elem4);
	}

	private void createSecondActorIntentionalElements5to6() {
		actor2 = factory.createActor();
		actor2.setName("actor2");
		urnSpec.getActors().add(actor2);
		
		elem5 = factory.createIntentionalElement();
		elem5.setType(IntentionalElementType.INDICATOR);
		elem5.setName("elem5");
		actor2.getElems().add(elem5);

		elem6 = factory.createIntentionalElement();
		elem6.setType(IntentionalElementType.TASK);
		elem6.setName("elem6");
		actor2.getElems().add(elem6);
	}

	private void createFirstEvaluation() {
		Evaluation eval = factory.createEvaluation();
		eval.setIntElement(elem1);
		eval.setEvaluation(900);
		strategy.getEvaluations().add(eval);
	}

	private void createSecondEvaluation() {
		Evaluation eval = factory.createEvaluation();
		eval.setIntElement(elem2);
		eval.setEvaluation(500);
		strategy.getEvaluations().add(eval);
	}
	
	private void createThirdEvaluation() {
		Evaluation eval = factory.createEvaluation();
		eval.setIntElement(elem3);
		eval.setEvaluation(-850);
		strategy.getEvaluations().add(eval);
	}
	
	private void createFourthEvaluation() {
		Evaluation eval = factory.createEvaluation();
		eval.setIntElement(elem4);
		eval.setEvaluation(-75);
		strategy.getEvaluations().add(eval);
	}

	private void createSixthEvaluation() {
		Evaluation eval = factory.createEvaluation();
		eval.setIntElement(elem6);
		eval.setEvaluation(70);
		strategy.getEvaluations().add(eval);
	}

	private void create1Contribution() {
		Contribution contribution = factory.createContribution();
		contribution.setDest(elem2);
		contribution.setQuantitativeContribution(80);
		elem1.getLinksSrc().add(contribution);
	}

	private void create1Decomposition() {
		Decomposition decomposition = factory.createDecomposition();
		decomposition.setDest(elem2);
		decomposition.setDecompositionType(DecompositionType.AND);
		elem1.getLinksSrc().add(decomposition);
	}

	private void create1Dependency() {
		Dependency dependency1 = factory.createDependency();
		dependency1.setDest(elem2
				);
		elem1.getLinksSrc().add(dependency1);
	}

	private void create2Decomposition() {
		Decomposition decomposition1 = factory.createDecomposition();
		decomposition1.setDest(elem4);
		decomposition1.setDecompositionType(DecompositionType.OR);
		elem1.getLinksSrc().add(decomposition1);

		Decomposition decomposition2 = factory.createDecomposition();
		decomposition2.setDest(elem4);
		decomposition2.setDecompositionType(DecompositionType.OR);
		elem3.getLinksSrc().add(decomposition2);
	}

	private void create2Contribution() {
		Contribution contribution1 = factory.createContribution();
		contribution1.setDest(elem3);
		contribution1.setQuantitativeContribution(90);
		elem1.getLinksSrc().add(contribution1);

		Contribution contribution2 = factory.createContribution();
		contribution2.setDest(elem4);
		contribution2.setQuantitativeContribution(90);
		elem3.getLinksSrc().add(contribution2);
	}

	private void create2Dependency() {
		Dependency dependency1 = factory.createDependency();
		dependency1.setDest(elem2);
		elem1.getLinksSrc().add(dependency1);

		Dependency dependency2 = factory.createDependency();
		dependency2.setDest(elem4);
		elem3.getLinksSrc().add(dependency2);
	}

	private void create3Decomposition() {
		Decomposition decomposition = factory.createDecomposition();
		decomposition.setDest(elem3);
		decomposition.setDecompositionType(DecompositionType.OR);
		elem1.getLinksSrc().add(decomposition);

		Decomposition decomposition2 = factory.createDecomposition();
		decomposition2.setDest(elem3);
		decomposition2.setDecompositionType(DecompositionType.OR);
		elem2.getLinksSrc().add(decomposition2);

		Decomposition decomposition3 = factory.createDecomposition();
		decomposition3.setDest(elem4);
		decomposition3.setDecompositionType(DecompositionType.AND);
		elem3.getLinksSrc().add(decomposition3);
	}

	private void create3Contribution() {
		Contribution contribution1 = factory.createContribution();
		contribution1.setDest(elem2);
		contribution1.setQuantitativeContribution(80);
		elem1.getLinksSrc().add(contribution1);

		Contribution contribution2 = factory.createContribution();
		contribution2.setDest(elem3);
		contribution2.setQuantitativeContribution(90);
		elem2.getLinksSrc().add(contribution2);

		Contribution contribution3 = factory.createContribution();
		contribution3.setDest(elem4);
		contribution3.setQuantitativeContribution(60);
		elem2.getLinksSrc().add(contribution3);
	}

	private void create3Dependency() {
		Dependency dependency1 = factory.createDependency();
		dependency1.setDest(elem2);
		elem1.getLinksSrc().add(dependency1);

		Dependency dependency2 = factory.createDependency();
		dependency2.setDest(elem3);
		elem2.getLinksSrc().add(dependency2);

		Dependency dependency3 = factory.createDependency();
		dependency3.setDest(elem4);
		elem2.getLinksSrc().add(dependency3);
	}

	private void create4Decomposition() {
		Decomposition decomposition = factory.createDecomposition();
		decomposition.setDest(elem3);
		decomposition.setDecompositionType(DecompositionType.OR);
		elem1.getLinksSrc().add(decomposition);

		Decomposition decomposition2 = factory.createDecomposition();
		decomposition2.setDest(elem3);
		decomposition2.setDecompositionType(DecompositionType.OR);
		elem2.getLinksSrc().add(decomposition2);

		Decomposition decomposition5 = factory.createDecomposition();
		decomposition5.setDest(elem4);
		decomposition5.setDecompositionType(DecompositionType.AND);
		elem2.getLinksSrc().add(decomposition5);

		Decomposition decomposition3 = factory.createDecomposition();
		decomposition3.setDest(elem4);
		decomposition3.setDecompositionType(DecompositionType.AND);
		elem3.getLinksSrc().add(decomposition3);
	}

	private void create4Contribution() {
		Contribution contribution1 = factory.createContribution();
		contribution1.setDest(elem2);
		contribution1.setQuantitativeContribution(80);
		elem1.getLinksSrc().add(contribution1);

		Contribution contribution2 = factory.createContribution();
		contribution2.setDest(elem3);
		contribution2.setQuantitativeContribution(40);
		elem2.getLinksSrc().add(contribution2);

		Contribution contribution3 = factory.createContribution();
		contribution3.setDest(elem4);
		contribution3.setQuantitativeContribution(60);
		elem2.getLinksSrc().add(contribution3);

		Contribution contribution4 = factory.createContribution();
		contribution4.setDest(elem4);
		contribution4.setQuantitativeContribution(70);
		elem3.getLinksSrc().add(contribution4);
	}
	
	private void create4Dependency() {
		Dependency dependency1 = factory.createDependency();
		dependency1.setDest(elem4);
		elem1.getLinksSrc().add(dependency1);

		Dependency dependency2 = factory.createDependency();
		dependency2.setDest(elem5);
		elem3.getLinksSrc().add(dependency2);

		Dependency dependency3 = factory.createDependency();
		dependency3.setDest(elem6);
		elem2.getLinksSrc().add(dependency3);

		Dependency dependency4 = factory.createDependency();
		dependency4.setDest(elem5);
		elem2.getLinksSrc().add(dependency4);
	}

	private void create2Contribution1Decomposition() {
		Contribution contribution1 = factory.createContribution();
		contribution1.setDest(elem2);
		contribution1.setQuantitativeContribution(80);
		elem1.getLinksSrc().add(contribution1);

		Contribution contribution2 = factory.createContribution();
		contribution2.setDest(elem4);
		contribution2.setQuantitativeContribution(70);
		elem1.getLinksSrc().add(contribution2);

		Decomposition decomposition = factory.createDecomposition();
		decomposition.setDest(elem3);
		decomposition.setDecompositionType(DecompositionType.XOR);
		elem2.getLinksSrc().add(decomposition);
	}

	private void create2Decomposition1Dependency() {
		Decomposition decomposition = factory.createDecomposition();
		decomposition.setDest(elem3);
		decomposition.setDecompositionType(DecompositionType.AND);
		elem1.getLinksSrc().add(decomposition);

		Decomposition decomposition2 = factory.createDecomposition();
		decomposition2.setDest(elem3);
		decomposition2.setDecompositionType(DecompositionType.AND);
		elem2.getLinksSrc().add(decomposition2);

		Dependency dependency = factory.createDependency();
		dependency.setDest(elem4);
		elem3.getLinksSrc().add(dependency);
	}

	private void create2Dependency1Contribution() {
		Dependency dependency1 = factory.createDependency();
		dependency1.setDest(elem2);
		elem1.getLinksSrc().add(dependency1);

		Dependency dependency2 = factory.createDependency();
		dependency2.setDest(elem4);
		elem3.getLinksSrc().add(dependency2);

		Contribution contribution1 = factory.createContribution();
		contribution1.setDest(elem2);
		contribution1.setQuantitativeContribution(95);
		elem4.getLinksSrc().add(contribution1);
	}

	private void create2Decomposition2Contribution2DependencySingleLevel() {
		Decomposition decomposition = factory.createDecomposition();
		decomposition.setDest(elem4);
		decomposition.setDecompositionType(DecompositionType.XOR);
		elem3.getLinksSrc().add(decomposition);

		Decomposition decomposition2 = factory.createDecomposition();
		decomposition2.setDest(elem4);
		decomposition2.setDecompositionType(DecompositionType.XOR);
		elem5.getLinksSrc().add(decomposition2);

		Contribution contribution = factory.createContribution();
		contribution.setDest(elem2);
		contribution.setQuantitativeContribution(65);
		elem1.getLinksSrc().add(contribution);

		Contribution contribution2 = factory.createContribution();
		contribution2.setDest(elem5);
		contribution2.setQuantitativeContribution(90);
		elem3.getLinksSrc().add(contribution2);

		Dependency dependency = factory.createDependency();
		dependency.setDest(elem4);
		elem2.getLinksSrc().add(dependency);

		Dependency dependency2 = factory.createDependency();
		dependency2.setDest(elem6);
		elem1.getLinksSrc().add(dependency);
	}

	private void create3Contribution2Decomposition() {
		Decomposition decomposition = factory.createDecomposition();
		decomposition.setDest(elem3);
		decomposition.setDecompositionType(DecompositionType.OR);
		elem1.getLinksSrc().add(decomposition);

		Decomposition decomposition2 = factory.createDecomposition();
		decomposition2.setDest(elem3);
		decomposition2.setDecompositionType(DecompositionType.OR);
		elem2.getLinksSrc().add(decomposition2);

		Contribution contribution = factory.createContribution();
		contribution.setDest(elem4);
		contribution.setQuantitativeContribution(95);
		elem3.getLinksSrc().add(contribution);

		Contribution contribution2 = factory.createContribution();
		contribution2.setDest(elem5);
		contribution2.setQuantitativeContribution(87);
		elem4.getLinksSrc().add(contribution2);

		Contribution contribution3 = factory.createContribution();
		contribution3.setDest(elem6);
		contribution3.setQuantitativeContribution(73);
		elem5.getLinksSrc().add(contribution3);
	}

	private void create3Decomposition2Dependency() {
		Decomposition decomposition = factory.createDecomposition();
		decomposition.setDest(elem3);
		decomposition.setDecompositionType(DecompositionType.AND);
		elem1.getLinksSrc().add(decomposition);

		Decomposition decomposition2 = factory.createDecomposition();
		decomposition2.setDest(elem3);
		decomposition2.setDecompositionType(DecompositionType.AND);
		elem2.getLinksSrc().add(decomposition2);

		Dependency dependency1 = factory.createDependency();
		dependency1.setDest(elem6);
		elem3.getLinksSrc().add(dependency1);

		Decomposition decomposition3 = factory.createDecomposition();
		decomposition3.setDest(elem4);
		decomposition3.setDecompositionType(DecompositionType.OR);
		elem3.getLinksSrc().add(decomposition3);

		Dependency dependency2 = factory.createDependency();
		dependency2.setDest(elem5);
		elem2.getLinksSrc().add(dependency2);
	}

	private void create3Dependency2Contribution() {
		Dependency dependency1 = factory.createDependency();
		dependency1.setDest(elem6);
		elem1.getLinksSrc().add(dependency1);

		Contribution contribution1 = factory.createContribution();
		contribution1.setDest(elem3);
		contribution1.setQuantitativeContribution(95);
		elem2.getLinksSrc().add(contribution1);

		Contribution contribution2 = factory.createContribution();
		contribution2.setDest(elem4);
		contribution2.setQuantitativeContribution(66);
		elem2.getLinksSrc().add(contribution2);

		Dependency dependency2 = factory.createDependency();
		dependency2.setDest(elem5);
		elem3.getLinksSrc().add(dependency2);

		Dependency dependency3 = factory.createDependency();
		dependency3.setDest(elem4);
		elem5.getLinksSrc().add(dependency3);
	}
	
	private void create2Decomposition2Contribution2DependencyTwoLevels() {
		Decomposition decomposition = factory.createDecomposition();
		decomposition.setDest(elem4);
		decomposition.setDecompositionType(DecompositionType.XOR);
		elem2.getLinksSrc().add(decomposition);

		Decomposition decomposition2 = factory.createDecomposition();
		decomposition2.setDest(elem4);
		decomposition2.setDecompositionType(DecompositionType.XOR);
		elem3.getLinksSrc().add(decomposition2);

		Contribution contribution = factory.createContribution();
		contribution.setDest(elem2);
		contribution.setQuantitativeContribution(65);
		elem1.getLinksSrc().add(contribution);

		Contribution contribution2 = factory.createContribution();
		contribution2.setDest(elem3);
		contribution2.setQuantitativeContribution(90);
		elem1.getLinksSrc().add(contribution2);

		Dependency dependency = factory.createDependency();
		dependency.setDest(elem5);
		elem3.getLinksSrc().add(dependency);

		Dependency dependency2 = factory.createDependency();
		dependency2.setDest(elem6);
		elem5.getLinksSrc().add(dependency2);
	}

	@Test
	public void initialize() throws Throwable {
		createFirstActorStrategyIntentionalElements1to2();
		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(0, evalManager.getEvaluation(elem1));
		assertEquals(0, evalManager.getEvaluation(elem2));
	}

	@Test
	public void singleContributionLink() {
		createFirstActorStrategyIntentionalElements1to2();
		create1Contribution();
		createFirstEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(900, evalManager.getEvaluation(elem1));
		assertEquals(100, evalManager.getEvaluation(elem2));
	}

	@Test
	public void singleDecompositionLink() {
		createFirstActorStrategyIntentionalElements1to2();
		create1Decomposition();
		createFirstEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(900, evalManager.getEvaluation(elem1));
		assertEquals(100, evalManager.getEvaluation(elem2));
	}

	@Test
	public void singleDependencyLink() {
		createFirstActorStrategyIntentionalElements1to2();
		create1Dependency();
		createFirstEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(900, evalManager.getEvaluation(elem1));
		assertEquals(0, evalManager.getEvaluation(elem2));
	}

	@Test
	public void allElementLinks() {
		createFirstActorStrategyIntentionalElements1to4();
		createSecondActorIntentionalElements5to6();
		create2Decomposition2Contribution2DependencySingleLevel();
		createFirstEvaluation();
		createThirdEvaluation();
		createSixthEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(52, evalManager.getEvaluation(elem2));
		assertEquals(85, evalManager.getEvaluation(elem3));
		assertEquals(85, evalManager.getEvaluation(elem4));
		assertEquals(76, evalManager.getEvaluation(elem5));
		assertEquals(70, evalManager.getEvaluation(elem6));
	}

	@Test
	public void multipleDecompositionLinks() {
		createFirstActorStrategyIntentionalElements1to4();
		create2Decomposition();
		createFirstEvaluation();
		createThirdEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(0, evalManager.getEvaluation(elem2));
		assertEquals(85, evalManager.getEvaluation(elem3));
		assertEquals(85, evalManager.getEvaluation(elem4));
	}

	@Test
	public void multipleContributionLinks() {
		createFirstActorStrategyIntentionalElements1to4();
		create2Contribution();
		createFirstEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(900, evalManager.getEvaluation(elem1));
		assertEquals(0, evalManager.getEvaluation(elem2));
		assertEquals(100, evalManager.getEvaluation(elem3));
		assertEquals(90, evalManager.getEvaluation(elem4));
	}

	@Test
	public void multipleDependencyLinks() {
		createFirstActorStrategyIntentionalElements1to4();
		create2Dependency();
		createSecondEvaluation();
		createThirdEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(0, evalManager.getEvaluation(elem1));
		assertEquals(500, evalManager.getEvaluation(elem2));
		assertEquals(-850, evalManager.getEvaluation(elem3));
		assertEquals(0, evalManager.getEvaluation(elem4));
	}

	@Test
	public void contributionDecompositionLinks() {
		createFirstActorStrategyIntentionalElements1to4();
		createFirstEvaluation();
		create2Contribution1Decomposition();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(64, evalManager.getEvaluation(elem2));
		assertEquals(64, evalManager.getEvaluation(elem3));
		assertEquals(56, evalManager.getEvaluation(elem4));
	}

	@Test
	public void decompositionDependencyLinks() {
		createFirstActorStrategyIntentionalElements1to4();
		create2Decomposition1Dependency();
		createFirstEvaluation();
		createSecondEvaluation();
		createFourthEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(50, evalManager.getEvaluation(elem2));
		assertEquals(-75, evalManager.getEvaluation(elem3));
		assertEquals(-75, evalManager.getEvaluation(elem4));
	}

	@Test
	public void dependencyContributionLinks() {
		createFirstActorStrategyIntentionalElements1to4();
		create2Dependency1Contribution();
		createFirstEvaluation();
		createFourthEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(-71, evalManager.getEvaluation(elem2));
		assertEquals(-75, evalManager.getEvaluation(elem3));
		assertEquals(-75, evalManager.getEvaluation(elem4));
	}

	@Test
	public void singleDecompositionLinksTwoLevels() {
		createFirstActorStrategyIntentionalElements1to4();
		createFirstEvaluation();
		createSecondEvaluation();
		create3Decomposition();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(50, evalManager.getEvaluation(elem2));
		assertEquals(80, evalManager.getEvaluation(elem3));
		assertEquals(80, evalManager.getEvaluation(elem4));
	}

	@Test
	public void singleContributionLinksTwoLevels() {
		createFirstActorStrategyIntentionalElements1to4();
		create3Contribution();
		createFirstEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(64, evalManager.getEvaluation(elem2));
		assertEquals(57, evalManager.getEvaluation(elem3));
		assertEquals(38, evalManager.getEvaluation(elem4));
	}

	@Test
	public void singleDependencyLinksTwoLevels() {
		createFirstActorStrategyIntentionalElements1to4();
		create3Dependency();
		createFourthEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(-75, evalManager.getEvaluation(elem1));
		assertEquals(-75, evalManager.getEvaluation(elem2));
		assertEquals(0, evalManager.getEvaluation(elem3));
		assertEquals(-75, evalManager.getEvaluation(elem4));
	}

	@Test
	public void multipleDecompositionLinksTwoLevels() {
		createFirstActorStrategyIntentionalElements1to4();
		createFirstEvaluation();
		createSecondEvaluation();
		create4Decomposition();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(50, evalManager.getEvaluation(elem2));
		assertEquals(80, evalManager.getEvaluation(elem3));
		assertEquals(50, evalManager.getEvaluation(elem4));
	}

	@Test
	public void multipleContributionLinksTwoLevels() {
		createFirstActorStrategyIntentionalElements1to4();
		create4Contribution();
		createFirstEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(64, evalManager.getEvaluation(elem2));
		assertEquals(25, evalManager.getEvaluation(elem3));
		assertEquals(55, evalManager.getEvaluation(elem4));
	}

	@Test
	public void multipleDependencyLinksTwoLevels() {
		createFirstActorStrategyIntentionalElements1to4();
		createSecondActorIntentionalElements5to6();
		create4Dependency();
		createFirstEvaluation();
		createThirdEvaluation();
		createFourthEvaluation();
		createSixthEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(0, evalManager.getEvaluation(elem2));
		assertEquals(85, evalManager.getEvaluation(elem3));
		assertEquals(-75, evalManager.getEvaluation(elem4));
		assertEquals(0, evalManager.getEvaluation(elem5));
		assertEquals(70, evalManager.getEvaluation(elem6));
	}

	@Test
	public void contibutionDecompositionLinksTwoLevels() {
		createFirstActorStrategyIntentionalElements1to4();
		createSecondActorIntentionalElements5to6();
		create3Contribution2Decomposition();
		createFirstEvaluation();
		createSecondEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(50, evalManager.getEvaluation(elem2));
		assertEquals(80, evalManager.getEvaluation(elem3));
		assertEquals(76, evalManager.getEvaluation(elem4));
		assertEquals(66, evalManager.getEvaluation(elem5));
		assertEquals(48, evalManager.getEvaluation(elem6));
	}

	@Test
	public void decompositionDependencyLinksTwoLevels() {
		createFirstActorStrategyIntentionalElements1to4();
		createSecondActorIntentionalElements5to6();
		create3Decomposition2Dependency();
		createFirstEvaluation();
		createFourthEvaluation();
		createSixthEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(0, evalManager.getEvaluation(elem2));
		assertEquals(0, evalManager.getEvaluation(elem3));
		assertEquals(-75, evalManager.getEvaluation(elem4));
		assertEquals(0, evalManager.getEvaluation(elem5));
		assertEquals(70, evalManager.getEvaluation(elem6));
	}

	@Test
	public void dependencyContributionLinksTwoLevels() {
		createFirstActorStrategyIntentionalElements1to4();
		createSecondActorIntentionalElements5to6();
		create3Dependency2Contribution();
		createSecondEvaluation();
		createSixthEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(0, evalManager.getEvaluation(elem1));
		assertEquals(50, evalManager.getEvaluation(elem2));
		assertEquals(0, evalManager.getEvaluation(elem3));
		assertEquals(33, evalManager.getEvaluation(elem4));
		assertEquals(0, evalManager.getEvaluation(elem5));
		assertEquals(70, evalManager.getEvaluation(elem6));
	}

	@Test
	public void mixedElementLinksTwoLevels() {
		createFirstActorStrategyIntentionalElements1to4();
		createSecondActorIntentionalElements5to6();
		create2Decomposition2Contribution2DependencyTwoLevels();
		createFirstEvaluation();
		createSixthEvaluation();

		TURNEvaluationManager evalManager = new TURNEvaluationManager(strategy);

		assertEquals(80, evalManager.getEvaluation(elem1));
		assertEquals(52, evalManager.getEvaluation(elem2));
		assertEquals(0, evalManager.getEvaluation(elem3));
		assertEquals(52, evalManager.getEvaluation(elem4));
		assertEquals(0, evalManager.getEvaluation(elem5));
		assertEquals(70, evalManager.getEvaluation(elem6));
	}
}
