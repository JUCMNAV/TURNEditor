/**
 * generated by Xtext 2.12.0
 */
package org.xtext.project.turn.tcolab.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.xtext.project.turn.TurnRuntimeModule;
import org.xtext.project.turn.TurnStandaloneSetup;
import org.xtext.project.turn.tcolab.ide.TURNIdeModule;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class TURNIdeSetup extends TurnStandaloneSetup {
  @Override
  public Injector createInjector() {
    TurnRuntimeModule _turnRuntimeModule = new TurnRuntimeModule();
    TURNIdeModule _tURNIdeModule = new TURNIdeModule();
    return Guice.createInjector(Modules2.mixin(((com.google.inject.Module) _turnRuntimeModule), _tURNIdeModule));
  }
}
