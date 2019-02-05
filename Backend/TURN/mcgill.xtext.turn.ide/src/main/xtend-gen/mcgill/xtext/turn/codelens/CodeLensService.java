package mcgill.xtext.turn.codelens;

import com.google.common.base.Objects;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import mcgill.xtext.turn.settings.PreferenceValuesProvider;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.lsp4j.CodeLens;
import org.eclipse.lsp4j.CodeLensParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.ide.server.codelens.ICodeLensService;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.xtext.example.mydsl.tURN.Actor;

@SuppressWarnings("all")
public class CodeLensService implements ICodeLensService {
  @FinalFieldsConstructor
  public static class MyAcceptor implements IReferenceFinder.Acceptor {
    private final URI uri;
    
    @Accessors
    private final Multimap<URI, Pair<URI, EReference>> references = HashMultimap.<URI, Pair<URI, EReference>>create();
    
    @Override
    public void accept(final IReferenceDescription description) {
      URI _trimFragment = description.getTargetEObjectUri().trimFragment();
      boolean _equals = Objects.equal(_trimFragment, this.uri);
      if (_equals) {
        URI _targetEObjectUri = description.getTargetEObjectUri();
        URI _sourceEObjectUri = description.getSourceEObjectUri();
        EReference _eReference = description.getEReference();
        Pair<URI, EReference> _mappedTo = Pair.<URI, EReference>of(_sourceEObjectUri, _eReference);
        this.references.put(_targetEObjectUri, _mappedTo);
      }
    }
    
    @Override
    public void accept(final EObject source, final URI sourceURI, final EReference eReference, final int index, final EObject targetOrProxy, final URI targetURI) {
      URI _trimFragment = targetURI.trimFragment();
      boolean _equals = Objects.equal(_trimFragment, this.uri);
      if (_equals) {
        Pair<URI, EReference> _mappedTo = Pair.<URI, EReference>of(sourceURI, eReference);
        this.references.put(targetURI, _mappedTo);
      }
    }
    
    public MyAcceptor(final URI uri) {
      super();
      this.uri = uri;
    }
    
    @Pure
    public Multimap<URI, Pair<URI, EReference>> getReferences() {
      return this.references;
    }
  }
  
  public final static PreferenceKey CODE_LENS_ENABLED = new PreferenceKey("code-lenses", "on");
  
  @Inject
  private IReferenceFinder referenceFinder;
  
  @Inject
  private DocumentExtensions documentExtensions;
  
  @Inject
  private PreferenceValuesProvider preferenceProvider;
  
  @Override
  public List<? extends CodeLens> computeCodeLenses(final Document document, final XtextResource resource, final CodeLensParams params, final CancelIndicator indicator) {
    final String enabled = this.preferenceProvider.getPreferenceValues(resource).getPreference(CodeLensService.CODE_LENS_ENABLED);
    boolean _equals = enabled.equals("on");
    boolean _not = (!_equals);
    if (_not) {
      return CollectionLiterals.<CodeLens>emptyList();
    }
    URI _uRI = resource.getURI();
    final CodeLensService.MyAcceptor acceptor = new CodeLensService.MyAcceptor(_uRI);
    this.referenceFinder.findAllReferences(resource, acceptor, new NullProgressMonitor() {
      @Override
      public boolean isCanceled() {
        return indicator.isCanceled();
      }
    });
    final ChunkedResourceDescriptions index = ChunkedResourceDescriptions.findInEmfObject(resource.getResourceSet());
    if ((index != null)) {
      final Function1<IResourceDescription, Iterable<IReferenceDescription>> _function = (IResourceDescription it) -> {
        return it.getReferenceDescriptions();
      };
      final Consumer<Iterable<IReferenceDescription>> _function_1 = (Iterable<IReferenceDescription> it) -> {
        final Consumer<IReferenceDescription> _function_2 = (IReferenceDescription it_1) -> {
          acceptor.accept(it_1);
        };
        it.forEach(_function_2);
      };
      IterableExtensions.<IResourceDescription, Iterable<IReferenceDescription>>map(index.getAllResourceDescriptions(), _function).forEach(_function_1);
    }
    final ArrayList<CodeLens> result = CollectionLiterals.<CodeLens>newArrayList();
    Set<URI> _keySet = acceptor.references.keySet();
    for (final URI uri : _keySet) {
      URI _trimFragment = uri.trimFragment();
      URI _uRI_1 = resource.getURI();
      boolean _equals_1 = Objects.equal(_trimFragment, _uRI_1);
      if (_equals_1) {
        final EObject eObject = resource.getEObject(uri.fragment());
        if ((eObject instanceof Actor)) {
          final Function1<ILeafNode, Boolean> _function_2 = (ILeafNode it) -> {
            EObject _grammarElement = it.getGrammarElement();
            return Boolean.valueOf((_grammarElement instanceof Keyword));
          };
          final ILeafNode kwNode = IterableExtensions.<ILeafNode>head(IterableExtensions.<ILeafNode>filter(NodeModelUtils.findActualNodeFor(eObject).getLeafNodes(), _function_2));
          if ((kwNode != null)) {
            final Range range = this.documentExtensions.newRange(resource, kwNode.getTextRegion());
            final Function1<Pair<URI, EReference>, Location> _function_3 = (Pair<URI, EReference> refInfo) -> {
              final EObject eobj = resource.getResourceSet().getEObject(refInfo.getKey(), false);
              return this.documentExtensions.newLocation(eobj, refInfo.getValue(), (-1));
            };
            final List<Location> locations = IterableExtensions.<Location>toList(IterableExtensions.<Pair<URI, EReference>, Location>map(acceptor.references.get(uri), _function_3));
            CodeLens _codeLens = new CodeLens();
            final Procedure1<CodeLens> _function_4 = (CodeLens it) -> {
              it.setRange(range);
              Command _command = new Command();
              final Procedure1<Command> _function_5 = (Command it_1) -> {
                it_1.setCommand("yang.show.references");
                String _switchResult = null;
                int _size = acceptor.references.get(uri).size();
                final int count = _size;
                switch (count) {
                  case 1:
                    _switchResult = "1 reference";
                    break;
                  default:
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append(count);
                    _builder.append(" references");
                    _switchResult = _builder.toString();
                    break;
                }
                it_1.setTitle(_switchResult);
                it_1.setArguments(CollectionLiterals.<Object>newArrayList(
                  uri.trimFragment().toString(), 
                  range.getStart(), locations));
              };
              Command _doubleArrow = ObjectExtensions.<Command>operator_doubleArrow(_command, _function_5);
              it.setCommand(_doubleArrow);
            };
            CodeLens _doubleArrow = ObjectExtensions.<CodeLens>operator_doubleArrow(_codeLens, _function_4);
            result.add(_doubleArrow);
          }
        }
      }
    }
    return result;
  }
}
