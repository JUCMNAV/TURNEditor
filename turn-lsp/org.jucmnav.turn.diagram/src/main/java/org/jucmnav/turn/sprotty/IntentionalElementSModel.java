package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;
import org.jucmnav.turn.diagram.TURNNode;
import org.jucmnav.turn.turn.ImportanceType;
import org.jucmnav.turn.turn.IntentionalElement;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SCompartment;
import io.typefox.sprotty.api.SLabel;
import io.typefox.sprotty.api.SModelElement;

public class IntentionalElementSModel implements TurnSModel {

	private IntentionalElement intentionalElement;
	
	public IntentionalElementSModel(IntentionalElement intentionalElement) {
		this.intentionalElement = intentionalElement;
	}
	
	@Override
	public SModelElement generate() {
		TURNNode ieSElement = new TURNNode();
		ieSElement.setId(intentionalElement.getLongName().getLongname());
		ieSElement.setType("turnnode:" + intentionalElement.getType().toString());
		ieSElement.setLayout("hbox");
		ieSElement.setLayoutOptions(createLayoutOptions());		
		return ieSElement;
	}

	@Override
	public List<SModelElement> generateChildren() {
		
		List<SModelElement> children = new ArrayList<>();
		List<SModelElement> compChildren = new ArrayList<>();
		
		new SLabel(l -> {
			l.setId(intentionalElement.getLongName().getLongname() + "-label");
			l.setType("label:heading");
			l.setText(createImportanceHeadingString());
			compChildren.add(l);
		});
		
		new SCompartment(c -> {
			c.setId(intentionalElement.getLongName().getLongname() + "-heading");
			c.setType("comp:comp");
			c.setLayout("hbox");
			c.setChildren(compChildren);
			children.add(c);
		});
		
				
		return children;
	}
	
	private LayoutOptions createLayoutOptions() {
		return new LayoutOptions(options -> {
			options.setPaddingTop(10.0);
			options.setPaddingBottom(10.0);
			options.setPaddingLeft(10.0);
			options.setPaddingRight(10.0);
			options.setResizeContainer(true);
		});
	}
	
	private String createImportanceHeadingString() {
		String importance = "" + intentionalElement.getImportanceQuantitative();
		if(importance == "0" || intentionalElement.getImportance().getValue() == ImportanceType.NONE_VALUE) {
			importance = intentionalElement.getImportance().toString();
		}
		return intentionalElement.getLongName().getLongname() + " (" + importance + ")";
	}

}
