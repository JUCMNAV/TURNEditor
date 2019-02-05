package mcgill.xtext.turn.ide.symbols;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.Location;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class TURNDocumentSymbolService extends DocumentSymbolService {
  @Inject
  @Extension
  private DocumentExtensions _documentExtensions;
  
  @Inject
  private EObjectAtOffsetHelper helper;
  
  @Inject
  private ILocationInFileProvider locationProvider;
  
  @Override
  public List<? extends Location> getDefinitions(final XtextResource resource, final int offset, final IReferenceFinder.IResourceAccess resourceAccess, final CancelIndicator cancelIndicator) {
    TextRegion _textRegion = new TextRegion(offset, 0);
    final INode node = this.helper.getCrossReferenceNode(resource, _textRegion);
    if ((node != null)) {
      final EObject element = this.helper.getCrossReferencedElement(node);
      if ((element != null)) {
        Location _symbolFullLocation = this.getSymbolFullLocation(element);
        return Collections.<Location>unmodifiableList(CollectionLiterals.<Location>newArrayList(_symbolFullLocation));
      }
    }
    return CollectionLiterals.<Location>emptyList();
  }
  
  protected Location getSymbolFullLocation(final EObject object) {
    Location _xblockexpression = null;
    {
      final Resource resource = object.eResource();
      final ITextRegion fullRegion = this.locationProvider.getFullTextRegion(object);
      _xblockexpression = this._documentExtensions.newLocation(resource, fullRegion);
    }
    return _xblockexpression;
  }
}
