package org.xtext.project.turn.tcolab.diagram;

import io.typefox.sprotty.api.SLabel;
import io.typefox.sprotty.server.xtext.tracing.Traceable;
import org.eclipse.xtend.lib.annotations.Accessors;

@Accessors
@SuppressWarnings("all")
public class TURNLabel extends SLabel implements Traceable {
  private String trace;
}
