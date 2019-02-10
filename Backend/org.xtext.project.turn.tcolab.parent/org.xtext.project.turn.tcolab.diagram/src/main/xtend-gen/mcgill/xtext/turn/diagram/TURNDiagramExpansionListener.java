package mcgill.xtext.turn.diagram;

import io.typefox.sprotty.api.Action;
import io.typefox.sprotty.api.IDiagramExpansionListener;
import io.typefox.sprotty.api.IDiagramServer;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.server.xtext.DiagramLanguageServerExtension;
import io.typefox.sprotty.server.xtext.LanguageAwareDiagramServer;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public class TURNDiagramExpansionListener implements IDiagramExpansionListener {
  private final static Logger LOG = Logger.getLogger(TURNDiagramExpansionListener.class);
  
  @Override
  public void expansionChanged(final Action action, final IDiagramServer server) {
    TURNDiagramExpansionListener.LOG.info("I am outside TURNDiagramExpansionListener");
    if ((server instanceof LanguageAwareDiagramServer)) {
      String _sourceUri = ((LanguageAwareDiagramServer)server).getSourceUri();
      String _plus = ("I am inside TURNDiagramExpansionListener" + _sourceUri);
      String _plus_1 = (_plus + "root");
      SModelRoot _model = ((LanguageAwareDiagramServer)server).getModel();
      String _plus_2 = (_plus_1 + _model);
      TURNDiagramExpansionListener.LOG.info(_plus_2);
      final DiagramLanguageServerExtension languageServerExtension = ((LanguageAwareDiagramServer)server).getLanguageServerExtension();
      languageServerExtension.updateDiagram(((LanguageAwareDiagramServer)server));
    }
  }
}
