package mcgill.xtext.turn.diagram;

import com.google.inject.Inject;
import io.typefox.sprotty.api.HtmlRoot;
import io.typefox.sprotty.api.IDiagramServer;
import io.typefox.sprotty.api.IPopupModelFactory;
import io.typefox.sprotty.api.PreRenderedElement;
import io.typefox.sprotty.api.RequestPopupModelAction;
import io.typefox.sprotty.api.SModelElement;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.server.xtext.ILanguageAwareDiagramServer;
import io.typefox.sprotty.server.xtext.tracing.ITraceProvider;
import io.typefox.sprotty.server.xtext.tracing.Traceable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;
import org.xtext.example.mydsl.tURN.URNspec;

@SuppressWarnings("all")
public class TURNPopupModelFactory implements IPopupModelFactory {
  @Inject
  @Extension
  private ITraceProvider _iTraceProvider;
  
  @Override
  public SModelRoot createPopupModel(final SModelElement element, final RequestPopupModelAction request, final IDiagramServer server) {
    try {
      HtmlRoot _xifexpression = null;
      if ((element instanceof Traceable)) {
        HtmlRoot _xblockexpression = null;
        {
          final BiFunction<EObject, ILanguageServerAccess.Context, HtmlRoot> _function = (EObject actor, ILanguageServerAccess.Context context) -> {
            HtmlRoot _xifexpression_1 = null;
            if ((actor instanceof URNspec)) {
              _xifexpression_1 = this.createPopup(((URNspec)actor), element, request);
            } else {
              _xifexpression_1 = null;
            }
            return _xifexpression_1;
          };
          final CompletableFuture<HtmlRoot> future = this._iTraceProvider.<HtmlRoot>withSource(((Traceable)element), ((ILanguageAwareDiagramServer) server), _function);
          _xblockexpression = future.get();
        }
        _xifexpression = _xblockexpression;
      } else {
        _xifexpression = null;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected HtmlRoot createPopup(final URNspec desc, final SModelElement element, final RequestPopupModelAction request) {
    HtmlRoot _xblockexpression = null;
    {
      String _id = element.getId();
      final String popupId = (_id + "-popup");
      final ArrayList<Pair<String, String>> infos = new ArrayList<Pair<String, String>>();
      final Pair<String, String> info1 = this.createHtml(desc);
      if ((info1 != null)) {
        infos.add(info1);
      }
      HtmlRoot _xifexpression = null;
      boolean _isEmpty = infos.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final Consumer<HtmlRoot> _function = (HtmlRoot it) -> {
          it.setType("html");
          it.setId(popupId);
          final Consumer<PreRenderedElement> _function_1 = (PreRenderedElement it_1) -> {
            it_1.setType("pre-rendered");
            it_1.setId((popupId + "-body"));
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("<div class=\"infoBlock\">");
            _builder.newLine();
            {
              for(final Pair<String, String> info : infos) {
                _builder.append("\t");
                _builder.append("<div class=\"sprotty-infoRow\">");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("<div class=\"sprotty-infoTitle\">");
                String _key = info.getKey();
                _builder.append(_key, "\t\t");
                _builder.append(":</div>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("<div class=\"sprotty-infoText\">");
                String _value = info.getValue();
                _builder.append(_value, "\t\t");
                _builder.append("</div>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("</div>");
                _builder.newLine();
              }
            }
            _builder.append("</div>");
            _builder.newLine();
            it_1.setCode(_builder.toString());
          };
          PreRenderedElement _preRenderedElement = new PreRenderedElement(_function_1);
          it.setChildren(Collections.<SModelElement>unmodifiableList(CollectionLiterals.<SModelElement>newArrayList(_preRenderedElement)));
          it.setCanvasBounds(request.getBounds());
        };
        _xifexpression = new HtmlRoot(_function);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected Pair<String, String> _createHtml(final URNspec descriptionStmt) {
    String _name = descriptionStmt.getName();
    return Pair.<String, String>of("actor", _name);
  }
  
  protected Pair<String, String> createHtml(final URNspec descriptionStmt) {
    return _createHtml(descriptionStmt);
  }
}
