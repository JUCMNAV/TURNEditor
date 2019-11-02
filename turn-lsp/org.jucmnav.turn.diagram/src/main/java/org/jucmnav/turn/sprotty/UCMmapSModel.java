package org.jucmnav.turn.sprotty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.jucmnav.turn.turn.ComponentRef;
import org.jucmnav.turn.turn.Path;
import org.jucmnav.turn.turn.UCMmap;
import io.typefox.sprotty.api.LayoutOptions;
import io.typefox.sprotty.api.SGraph;
import io.typefox.sprotty.api.SModelElement;

public class UCMmapSModel implements TurnSModel {

	private static Logger LOGGER = Logger.getLogger(UCMmapSModel.class);
	
	private static final String TYPE = "ucm";
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
			PathBodySModel pathBodySModel = new PathBodySModel(path.getStartPoint(), path.getPathBody());
			children.addAll(pathBodySModel.generateChildrenForSGraph());
		}
		for(ComponentRef compRef : ucmMap.getComponents()) {
			ComponentRefSModel compRefSModel = new ComponentRefSModel(compRef);
			children.add(compRefSModel.generate());
		}
		return children.stream().collect(Collectors.toMap(SModelElement::getId, s -> s, (s,v) -> s)).values().stream().collect(Collectors.toList());
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

	@Override
	public List<SModelElement> generateChildrenForSGraph() {
		// TODO Auto-generated method stub
		return null;
	}

}
