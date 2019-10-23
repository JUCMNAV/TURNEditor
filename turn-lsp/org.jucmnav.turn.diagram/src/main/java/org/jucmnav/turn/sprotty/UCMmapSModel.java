package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.jucmnav.turn.turn.ComponentRef;
import org.jucmnav.turn.turn.Path;
import org.jucmnav.turn.turn.UCMmap;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SGraph;
import io.typefox.sprotty.api.SModelElement;

public class UCMmapSModel implements TurnSModel {

	private static Logger LOGGER = Logger.getLogger(UCMmapSModel.class);
	
	private static final String TYPE = "graph";
	private UCMmap ucmMap;
	
	public UCMmapSModel(UCMmap ucmMap) {
		this.ucmMap = ucmMap;
	}
	
	@Override
	public SModelElement generate() {
		return new SGraph(g -> {
			g.setType(TYPE);
			g.setId(ucmMap.getLongName().getLongname());
			g.setLayoutOptions(getRootLayoutOptions());
			g.setChildren(generateChildren());
		});
	}

	@Override
	public List<SModelElement> generateChildren() {		
		List<SModelElement> children = new ArrayList<>();	
		for(Path path : ucmMap.getPaths()) {
			PathSModel pathSModel = new PathSModel(path);
			children.add(pathSModel.generate());
		}
		for(ComponentRef compRef : ucmMap.getComponents()) {
			ComponentRefSModel compRefSModel = new ComponentRefSModel(compRef);
			children.add(compRefSModel.generate());
		}
		return children;
	}
	
	private LayoutOptions getRootLayoutOptions() {
		return new LayoutOptions(options -> {
			options.setHAlign("left");
			options.setHGap(0.0);
			options.setVGap(10.0);
			options.setPaddingLeft(0.0);
			options.setPaddingRight(0.0);
			options.setPaddingTop(0.0);
			options.setPaddingBottom(0.0);
		});
	}

}
