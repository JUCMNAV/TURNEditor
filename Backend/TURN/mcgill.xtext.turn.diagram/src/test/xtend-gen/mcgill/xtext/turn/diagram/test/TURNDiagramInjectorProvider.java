package mcgill.xtext.turn.diagram.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import mcgill.xtext.turn.TURNRuntimeModule;
import mcgill.xtext.turn.TURNStandaloneSetup;
import mcgill.xtext.turn.diagram.TURNDiagramModule;
import mcgill.xtext.turn.ide.TURNIdeModule;
import org.eclipse.xtext.util.Modules2;
import org.xtext.example.mydsl.tests.TURNInjectorProvider;

@SuppressWarnings("all")
public class TURNDiagramInjectorProvider extends TURNInjectorProvider {
  @Override
  protected Injector internalCreateInjector() {
    return new TURNStandaloneSetup() {
      @Override
      public Injector createInjector() {
        TURNRuntimeModule _tURNRuntimeModule = new TURNRuntimeModule();
        TURNIdeModule _tURNIdeModule = new TURNIdeModule();
        TURNDiagramModule _tURNDiagramModule = new TURNDiagramModule();
        return Guice.createInjector(Modules2.mixin(_tURNRuntimeModule, _tURNIdeModule, _tURNDiagramModule));
      }
    }.createInjectorAndDoEMFRegistration();
  }
}
