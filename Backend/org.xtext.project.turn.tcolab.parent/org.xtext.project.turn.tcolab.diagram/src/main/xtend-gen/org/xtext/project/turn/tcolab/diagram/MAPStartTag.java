package org.xtext.project.turn.tcolab.diagram;

import io.typefox.sprotty.api.Layouting;
import io.typefox.sprotty.api.SShapeElement;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public abstract class MAPStartTag extends SShapeElement implements Layouting {
  private String layout;
  
  public MAPStartTag() {
  }
  
  public MAPStartTag(final Procedure1<? super MAPStartTag> initializer) {
    initializer.apply(this);
  }
  
  @Pure
  public String getLayout() {
    return this.layout;
  }
  
  public void setLayout(final String layout) {
    this.layout = layout;
  }
}