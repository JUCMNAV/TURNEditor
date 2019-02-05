package mcgill.xtext.turn.diagram;

import io.typefox.sprotty.api.SLabel;
import io.typefox.sprotty.server.xtext.tracing.Traceable;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class MAPStartLabel extends SLabel implements Traceable {
  private String trace;
  
  @Pure
  public String getTrace() {
    return this.trace;
  }
  
  public void setTrace(final String trace) {
    this.trace = trace;
  }
}
