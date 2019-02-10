package mcgill.xtext.turn.diagram;

import mcgill.xtext.turn.diagram.TURNNodeClassified;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class MAPStartNode extends TURNNodeClassified {
  private Boolean expanded;
  
  @Pure
  public Boolean getExpanded() {
    return this.expanded;
  }
  
  public void setExpanded(final Boolean expanded) {
    this.expanded = expanded;
  }
}
