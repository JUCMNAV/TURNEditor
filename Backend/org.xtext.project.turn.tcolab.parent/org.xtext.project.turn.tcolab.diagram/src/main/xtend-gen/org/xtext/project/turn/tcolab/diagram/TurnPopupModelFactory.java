package org.xtext.project.turn.tcolab.diagram;

import com.google.inject.Inject;
import io.typefox.sprotty.api.HtmlRoot;
import io.typefox.sprotty.api.IDiagramServer;
import io.typefox.sprotty.api.IPopupModelFactory;
import io.typefox.sprotty.api.RequestPopupModelAction;
import io.typefox.sprotty.api.SModelElement;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.server.xtext.tracing.ITraceProvider;
import java.util.Arrays;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class TurnPopupModelFactory implements IPopupModelFactory {
  @Inject
  @Extension
  private ITraceProvider _iTraceProvider;
  
  @Override
  public SModelRoot createPopupModel(final SModelElement element, final RequestPopupModelAction request, final IDiagramServer server) {
    throw new Error("Unresolved compilation problems:"
      + "\nURNspec cannot be resolved to a type."
      + "\nThe method createPopup(URNspec, SModelElement, RequestPopupModelAction) from the type TurnPopupModelFactory refers to the missing type URNspec"
      + "\nThe method createPopup(URNspec, SModelElement, RequestPopupModelAction) from the type TurnPopupModelFactory refers to the missing type URNspec");
  }
  
  protected HtmlRoot createPopup(final /* URNspec */Object desc, final SModelElement element, final RequestPopupModelAction request) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createHtml(URNspec) from the type TurnPopupModelFactory refers to the missing type URNspec");
  }
  
  protected Pair<String, String> _createHtml(final /* URNspec */Object descriptionStmt) {
    throw new Error("Unresolved compilation problems:"
      + "\nname cannot be resolved");
  }
  
  protected Pair<String, String> createHtml(final URNspec descriptionStmt) {
    if (descriptionStmt != null) {
      return _createHtml(descriptionStmt); else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(descriptionStmt).toString());
      }
    }
  }
  