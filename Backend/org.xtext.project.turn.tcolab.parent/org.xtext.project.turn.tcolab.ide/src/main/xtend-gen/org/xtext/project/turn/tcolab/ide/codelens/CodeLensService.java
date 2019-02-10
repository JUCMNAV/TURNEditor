package org.xtext.project.turn.tcolab.ide.codelens;

import com.google.common.base.Objects;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.lsp4j.CodeLens;
import org.eclipse.lsp4j.CodeLensParams;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.ide.server.codelens.ICodeLensService;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class CodeLensService implements ICodeLensService {
  /* @FinalFieldsConstructor
   */public static class MyAcceptor implements IReferenceFinder.Acceptor {
    private final URI uri;
    
    /* @Accessors
     */private final Multimap<URI, Pair<URI, EReference>> references = HashMultimap.<URI, Pair<URI, EReference>>create();
    
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
  }
  
  public final static PreferenceKey CODE_LENS_ENABLED = new PreferenceKey("code-lenses", "on");
  
  @Inject
  private IReferenceFinder referenceFinder;
  
  @Inject
  private DocumentExtensions documentExtensions;
  
  @Inject
  private /* PreferenceValuesProvider */Object preferenceProvider;
  
  @Override
  public List<? extends CodeLens> computeCodeLenses(final Document document, final XtextResource resource, final CodeLensParams params, final CancelIndicator indicator) {
    throw new Error("Unresolved compilation problems:"
      + "\nActor cannot be resolved to a type."
      + "\nInvalid number of arguments. The constructor MyAcceptor() is not applicable for the arguments (URI)"
      + "\nThe field CodeLensService.preferenceProvider refers to the missing type PreferenceValuesProvider"
      + "\ngetPreferenceValues cannot be resolved"
      + "\ngetPreference cannot be resolved"
      + "\nequals cannot be resolved"
      + "\n! cannot be resolved");
  }
}
