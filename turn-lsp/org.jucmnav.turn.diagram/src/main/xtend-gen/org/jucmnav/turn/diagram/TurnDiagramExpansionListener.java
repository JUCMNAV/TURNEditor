package org.jucmnav.turn.diagram;

import io.typefox.sprotty.api.Action;
import io.typefox.sprotty.api.IDiagramExpansionListener;
import io.typefox.sprotty.api.IDiagramServer;
import io.typefox.sprotty.server.xtext.DiagramLanguageServerExtension;
import io.typefox.sprotty.server.xtext.LanguageAwareDiagramServer;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public class TurnDiagramExpansionListener implements IDiagramExpansionListener {
  private static final Logger LOG = Logger.getLogger(TurnDiagramExpansionListener.class);
  
  @Override
  public void expansionChanged(final Action action, final IDiagramServer server) {
    String _name = server.getClass().getName();
    String _plus = ("expansionChanged(action, server) with server instance " + _name);
    TurnDiagramExpansionListener.LOG.info(_plus);
    if ((server instanceof LanguageAwareDiagramServer)) {
      final DiagramLanguageServerExtension languageServerExtension = ((LanguageAwareDiagramServer)server).getLanguageServerExtension();
      languageServerExtension.updateDiagram(((LanguageAwareDiagramServer)server));
    }
  }
}
