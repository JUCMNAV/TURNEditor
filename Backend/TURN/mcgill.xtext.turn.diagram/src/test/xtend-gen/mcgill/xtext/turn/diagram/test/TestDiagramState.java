package mcgill.xtext.turn.diagram.test;

import io.typefox.sprotty.api.IDiagramState;
import io.typefox.sprotty.api.SModelRoot;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class TestDiagramState implements IDiagramState {
  private final String clientId;
  
  private final SModelRoot currentModel = ObjectExtensions.<SModelRoot>operator_doubleArrow(new SModelRoot(), ((Procedure1<SModelRoot>) (SModelRoot it) -> {
    it.setType("NONE");
    it.setId("ROOT");
  }));
  
  private final HashSet<String> expandedElements = CollectionLiterals.<String>newHashSet();
  
  public TestDiagramState(final Resource resource) {
    this.clientId = resource.getURI().trimFileExtension().lastSegment();
  }
  
  @Override
  public Map<String, String> getOptions() {
    return CollectionLiterals.<String, String>emptyMap();
  }
  
  @Override
  public Set<String> getSelectedElements() {
    return CollectionLiterals.<String>emptySet();
  }
  
  @Pure
  public String getClientId() {
    return this.clientId;
  }
  
  @Pure
  public SModelRoot getCurrentModel() {
    return this.currentModel;
  }
  
  @Pure
  public Set<String> getExpandedElements() {
    return this.expandedElements;
  }
}
