package org.jucmnav.turn.sprotty;

import org.jucmnav.turn.diagram.MapNavigator;
import org.jucmnav.turn.diagram.ModelElementManager;
import org.jucmnav.turn.turn.UCMmap;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SGraph;
import io.typefox.sprotty.api.SModelElement;

public class UCMmapSModel implements TurnSModel {
	
	private static final String TYPE = "ucm";
	private UCMmap ucmMap;
	
	public UCMmapSModel(UCMmap ucmMap) {
		this.ucmMap = ucmMap;
	}
	
	@Override
	public SModelElement generate() {
		MapNavigator navigator = new MapNavigator(ucmMap);
		ModelElementManager manager = new ModelElementManager(navigator);
		return new SGraph(g -> {
			g.setType(TYPE);
			g.setId(ucmMap.getLongName().getLongname());
			g.setLayoutOptions(getRootLayoutOptions());
			g.setChildren(manager.createSModelElements());
		});
	}
	
	private LayoutOptions getRootLayoutOptions() {
		return new LayoutOptions(options -> {
			options.setHAlign("center");
			options.setHGap(0.0);
			options.setVGap(0.0);
			options.setPaddingLeft(0.0);
			options.setPaddingRight(0.0);
			options.setPaddingTop(0.0);
			options.setPaddingBottom(0.0);
		});
	}

}
