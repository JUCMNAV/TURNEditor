package mcgill.xtext.turn.diagram;

import io.typefox.sprotty.api.SCompartment;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class MAPStartHeaderNode extends SCompartment {
  private String cssClass;
  
  @Pure
  public String getCssClass() {
    return this.cssClass;
  }
  
  public void setCssClass(final String cssClass) {
    this.cssClass = cssClass;
  }
}
