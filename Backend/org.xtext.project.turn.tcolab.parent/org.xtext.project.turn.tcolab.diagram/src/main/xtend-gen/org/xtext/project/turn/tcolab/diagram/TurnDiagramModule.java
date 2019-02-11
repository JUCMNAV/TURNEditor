/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.xtext.project.turn.tcolab.diagram;

import io.typefox.sprotty.api.IDiagramExpansionListener;
import io.typefox.sprotty.api.ILayoutEngine;
import io.typefox.sprotty.api.IPopupModelFactory;
import io.typefox.sprotty.server.xtext.IDiagramGenerator;
import io.typefox.sprotty.server.xtext.ide.IdeDiagramModule;
import io.typefox.sprotty.server.xtext.ide.IdeLanguageServerExtension;
import org.xtext.project.turn.tcolab.diagram.TurnDiagramExpansionListener;
import org.xtext.project.turn.tcolab.diagram.TurnDiagramGenerator;
import org.xtext.project.turn.tcolab.diagram.TurnLanguageServerExtension;
import org.xtext.project.turn.tcolab.diagram.TurnLayoutEngine;
import org.xtext.project.turn.tcolab.diagram.TurnPopupModelFactory;

@SuppressWarnings("all")
public class TurnDiagramModule extends IdeDiagramModule {
  public Class<? extends IdeLanguageServerExtension> bindIdeLanguageServerExtension() {
    return TurnLanguageServerExtension.class;
  }
  
  @Override
  public Class<? extends ILayoutEngine> bindILayoutEngine() {
    return TurnLayoutEngine.class;
  }
  
  public Class<? extends IDiagramGenerator> bindIDiagramGenerator() {
    return TurnDiagramGenerator.class;
  }
  
  @Override
  public Class<? extends IPopupModelFactory> bindIPopupModelFactory() {
    return TurnPopupModelFactory.class;
  }
  
  @Override
  public Class<? extends IDiagramExpansionListener> bindIDiagramExpansionListener() {
    return TurnDiagramExpansionListener.class;
  }
}