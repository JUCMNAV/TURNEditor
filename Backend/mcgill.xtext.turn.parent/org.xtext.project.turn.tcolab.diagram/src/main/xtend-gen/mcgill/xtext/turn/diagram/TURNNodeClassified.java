package mcgill.xtext.turn.diagram;

import io.typefox.sprotty.api.SNode;
import io.typefox.sprotty.server.xtext.tracing.Traceable;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class TURNNodeClassified extends SNode implements Traceable {
  private String cssClass;
  
  private String trace;
  
  @Pure
  public String getCssClass() {
    return this.cssClass;
  }
  
  public void setCssClass(final String cssClass) {
    this.cssClass = cssClass;
  }
  
  @Pure
  public String getTrace() {
    return this.trace;
  }
  
  public void setTrace(final String trace) {
    this.trace = trace;
  }
}
