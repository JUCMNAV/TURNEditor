/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package mcgill.xtext.turn.diagram;

import io.typefox.sprotty.api.IDiagramExpansionListener;
import io.typefox.sprotty.api.ILayoutEngine;
import io.typefox.sprotty.api.IPopupModelFactory;
import io.typefox.sprotty.server.xtext.IDiagramGenerator;
import io.typefox.sprotty.server.xtext.ide.IdeDiagramModule;
import io.typefox.sprotty.server.xtext.ide.IdeLanguageServerExtension;
import mcgill.xtext.turn.diagram.TURNDiagramExpansionListener;
import mcgill.xtext.turn.diagram.TURNDiagramGenerator;
import mcgill.xtext.turn.diagram.TURNLanguageServerExtension;
import mcgill.xtext.turn.diagram.TURNLayoutEngine;
import mcgill.xtext.turn.diagram.TURNPopupModelFactory;

@SuppressWarnings("all")
public class TURNDiagramModule extends IdeDiagramModule {
  public Class<? extends IdeLanguageServerExtension> bindIdeLanguageServerExtension() {
    return TURNLanguageServerExtension.class;
  }
  
  @Override
  public Class<? extends ILayoutEngine> bindILayoutEngine() {
    return TURNLayoutEngine.class;
  }
  
  public Class<? extends IDiagramGenerator> bindIDiagramGenerator() {
    return TURNDiagramGenerator.class;
  }
  
  @Override
  public Class<? extends IPopupModelFactory> bindIPopupModelFactory() {
    return TURNPopupModelFactory.class;
  }
  
  @Override
  public Class<? extends IDiagramExpansionListener> bindIDiagramExpansionListener() {
    return TURNDiagramExpansionListener.class;
  }
}
