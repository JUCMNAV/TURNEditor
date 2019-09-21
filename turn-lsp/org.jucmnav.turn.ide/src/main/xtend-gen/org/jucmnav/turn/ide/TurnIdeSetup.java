package org.jucmnav.turn.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.jucmnav.turn.TurnRuntimeModule;
import org.jucmnav.turn.TurnStandaloneSetup;
import org.jucmnav.turn.ide.TurnIdeModule;

@SuppressWarnings("all")
public class TurnIdeSetup extends TurnStandaloneSetup {
  @Override
  public Injector createInjector() {
    TurnRuntimeModule _turnRuntimeModule = new TurnRuntimeModule();
    TurnIdeModule _turnIdeModule = new TurnIdeModule();
    return Guice.createInjector(Modules2.mixin(((com.google.inject.Module) _turnRuntimeModule), _turnIdeModule));
  }
}
