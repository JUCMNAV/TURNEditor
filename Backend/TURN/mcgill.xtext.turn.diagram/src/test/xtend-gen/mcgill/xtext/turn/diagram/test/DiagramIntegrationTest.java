package mcgill.xtext.turn.diagram.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import mcgill.xtext.turn.TURNRuntimeModule;
import mcgill.xtext.turn.diagram.TURNDiagramGenerator;
import mcgill.xtext.turn.diagram.TURNDiagramModule;
import mcgill.xtext.turn.diagram.test.TestDiagramState;
import mcgill.xtext.turn.ide.TURNIdeModule;
import mcgill.xtext.turn.ide.TURNIdeSetup;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@FinalFieldsConstructor
@RunWith(Parameterized.class)
@SuppressWarnings("all")
public class DiagramIntegrationTest {
  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> getFiles() {
    final ArrayList<Object[]> params = CollectionLiterals.<Object[]>newArrayList();
    File _file = new File("../mcgill.xtext.turn.ide/src/test/resources");
    final Procedure1<File> _function = (File it) -> {
      final Object[] arr = new Object[1];
      arr[0] = it;
      params.add(arr);
    };
    DiagramIntegrationTest.scanRecursively(_file, _function);
    return params;
  }
  
  private static Injector injector;
  
  private static IResourceDescriptions descriptions;
  
  @BeforeClass
  public static void beforeClass() {
    DiagramIntegrationTest.injector = new TURNIdeSetup() {
      @Override
      public Injector createInjector() {
        TURNRuntimeModule _tURNRuntimeModule = new TURNRuntimeModule();
        TURNIdeModule _tURNIdeModule = new TURNIdeModule();
        TURNDiagramModule _tURNDiagramModule = new TURNDiagramModule();
        return Guice.createInjector(Modules2.mixin(_tURNRuntimeModule, _tURNIdeModule, _tURNDiagramModule));
      }
    }.createInjectorAndDoEMFRegistration();
    final XtextResourceSet rs = DiagramIntegrationTest.injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
    File _file = new File("../mcgill.xtext.turn.ide/src/test/resources");
    final Procedure1<File> _function = (File it) -> {
      rs.getResource(URI.createFileURI(it.getAbsolutePath()), true);
    };
    DiagramIntegrationTest.scanRecursively(_file, _function);
    EcoreUtil.resolveAll(rs);
    DiagramIntegrationTest.descriptions = DiagramIntegrationTest.injector.<IResourceDescriptionsProvider>getInstance(IResourceDescriptionsProvider.class).getResourceDescriptions(rs);
  }
  
  public static void scanRecursively(final File file, final Procedure1<? super File> acceptor) {
    boolean _isDirectory = file.isDirectory();
    if (_isDirectory) {
      File[] _listFiles = file.listFiles();
      for (final File f : _listFiles) {
        DiagramIntegrationTest.scanRecursively(f, acceptor);
      }
    } else {
      boolean _endsWith = file.getName().endsWith(".turn");
      if (_endsWith) {
        acceptor.apply(file);
      }
    }
  }
  
  private final File file;
  
  @Test
  public void testDiagram() {
    final XtextResource resource = this.loadResources(URI.createFileURI(this.file.getAbsolutePath()));
    final TURNDiagramGenerator generator = DiagramIntegrationTest.injector.<TURNDiagramGenerator>getInstance(TURNDiagramGenerator.class);
    TestDiagramState _testDiagramState = new TestDiagramState(resource);
    generator.generate(resource, _testDiagramState, CancelIndicator.NullImpl);
  }
  
  private XtextResource loadResources(final URI uri) {
    final HashSet<URI> uris = CollectionLiterals.<URI>newHashSet();
    this.addReferencedURIs(uri, uris);
    final XtextResourceSet newRs = DiagramIntegrationTest.injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
    final Consumer<URI> _function = (URI it) -> {
      newRs.getResource(it, true);
    };
    uris.forEach(_function);
    EcoreUtil.resolveAll(newRs);
    Resource _resource = newRs.getResource(uri, false);
    final XtextResource xtextResource = ((XtextResource) _resource);
    boolean _isEmpty = xtextResource.getErrors().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      System.err.println(xtextResource.getParseResult().getRootNode().getText());
      final Function1<Resource.Diagnostic, String> _function_1 = (Resource.Diagnostic it) -> {
        return it.getMessage();
      };
      Assert.fail(IterableExtensions.join(ListExtensions.<Resource.Diagnostic, String>map(xtextResource.getErrors(), _function_1), "\n"));
    }
    return xtextResource;
  }
  
  private void addReferencedURIs(final URI uri, final Set<URI> uris) {
    boolean _add = uris.add(uri);
    if (_add) {
      final Consumer<IReferenceDescription> _function = (IReferenceDescription it) -> {
        this.addReferencedURIs(it.getTargetEObjectUri().trimFragment(), uris);
      };
      DiagramIntegrationTest.descriptions.getResourceDescription(uri).getReferenceDescriptions().forEach(_function);
    }
  }
  
  public DiagramIntegrationTest(final File file) {
    super();
    this.file = file;
  }
}
