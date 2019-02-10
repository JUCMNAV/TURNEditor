/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package mcgill.xtext.turn.diagram;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import io.typefox.sprotty.api.Dimension;
import io.typefox.sprotty.api.IDiagramServer;
import io.typefox.sprotty.api.IDiagramState;
import io.typefox.sprotty.api.ILayoutEngine;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.api.ServerStatus;
import io.typefox.sprotty.server.xtext.DiagramLanguageServerExtension;
import io.typefox.sprotty.server.xtext.IDiagramGenerator;
import io.typefox.sprotty.server.xtext.ILanguageAwareDiagramServer;
import io.typefox.sprotty.server.xtext.LanguageAwareDiagramServer;
import io.typefox.sprotty.server.xtext.ide.IdeLanguageServerExtension;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@Singleton
@SuppressWarnings("all")
public class TURNLanguageServerExtension extends IdeLanguageServerExtension {
  @Inject
  private Provider<IDiagramGenerator> diagramGeneratorProvider;
  
  private Map<IDiagramServer, SModelRoot> elementIE = new HashMap<IDiagramServer, SModelRoot>();
  
  private ILayoutEngine layoutEngine = this.getLayoutEngine();
  
  private SModelRoot cm;
  
  private Object localK = null;
  
  private boolean flag = false;
  
  private Dimension nodeSZ = null;
  
  protected ILayoutEngine getLayoutEngine() {
    return this.layoutEngine;
  }
  
  @Override
  protected void initializeDiagramServer(final IDiagramServer server) {
    super.initializeDiagramServer(server);
    final LanguageAwareDiagramServer languageAware = ((LanguageAwareDiagramServer) server);
    languageAware.setNeedsServerLayout(true);
    languageAware.setNeedsClientLayout(true);
    String _clientId = server.getClientId();
    String _plus = ("Created diagram server for " + _clientId);
    DiagramLanguageServerExtension.LOG.info(_plus);
  }
  
  @Override
  protected void doUpdateDiagrams(final Collection<? extends URI> uris) {
    for (final URI uri : uris) {
      Collection<IDiagramServer> _values = this.getDiagramServers().values();
      for (final IDiagramServer d : _values) {
        {
          final Map<String, String> stateInfo = d.getOptions();
          final String stateURI = stateInfo.get("sourceUri");
          final String path = stateURI;
          final SModelRoot root = d.getModel();
          DiagramLanguageServerExtension.LOG.info(("so now i am in doUpdateDiagrams with ROOT " + root));
          final List<? extends ILanguageAwareDiagramServer> diagramServers = this.findDiagramServersByUri(path);
          int _size = diagramServers.size();
          String _plus = ("RECCCCO" + Integer.valueOf(_size));
          DiagramLanguageServerExtension.LOG.info(_plus);
          final ILanguageAwareDiagramServer first = diagramServers.get(0);
          DiagramLanguageServerExtension.LOG.info(((("so now i am in doUpdateDiagrams with path " + path) + "DIAGRAMSERVER") + diagramServers));
          this.doUpdateDiagrams(path, diagramServers);
        }
      }
    }
  }
  
  @Override
  public List<? extends ILanguageAwareDiagramServer> findDiagramServersByUri(final String uri) {
    List<ILanguageAwareDiagramServer> _xsynchronizedexpression = null;
    synchronized (this.getDiagramServers()) {
      List<ILanguageAwareDiagramServer> _xblockexpression = null;
      {
        DiagramLanguageServerExtension.LOG.info(("Inside ILanguageAwareDiagramServer URI" + uri));
        final Function1<ILanguageAwareDiagramServer, Boolean> _function = (ILanguageAwareDiagramServer it) -> {
          String _sourceUri = it.getSourceUri();
          return Boolean.valueOf(Objects.equal(_sourceUri, uri));
        };
        _xblockexpression = IterableExtensions.<ILanguageAwareDiagramServer>toList(IterableExtensions.<ILanguageAwareDiagramServer>filter(Iterables.<ILanguageAwareDiagramServer>filter(this.getDiagramServers().values(), ILanguageAwareDiagramServer.class), _function));
      }
      _xsynchronizedexpression = _xblockexpression;
    }
    return _xsynchronizedexpression;
  }
  
  @Override
  protected CompletableFuture<Void> doUpdateDiagrams(final String path, final List<? extends ILanguageAwareDiagramServer> diagramServers) {
    boolean _isEmpty = diagramServers.isEmpty();
    if (_isEmpty) {
      return CompletableFuture.<Void>completedFuture(null);
    }
    final Function<ILanguageServerAccess.Context, List<Pair<ILanguageAwareDiagramServer, SModelRoot>>> _function = (ILanguageServerAccess.Context context) -> {
      final ServerStatus status = this.shouldGenerate(context.getResource(), context.getCancelChecker());
      final Function1<ILanguageAwareDiagramServer, Pair<ILanguageAwareDiagramServer, SModelRoot>> _function_1 = (ILanguageAwareDiagramServer server) -> {
        SModelRoot _xblockexpression = null;
        {
          server.setStatus(status);
          SModelRoot _xifexpression = null;
          ServerStatus.Severity _severity = status.getSeverity();
          boolean _tripleNotEquals = (_severity != ServerStatus.Severity.ERROR);
          if (_tripleNotEquals) {
            SModelRoot _xblockexpression_1 = null;
            {
              final IDiagramGenerator diagramGenerator = this.diagramGeneratorProvider.get();
              _xblockexpression_1 = diagramGenerator.generate(context.getResource(), server.getDiagramState(), context.getCancelChecker());
            }
            _xifexpression = _xblockexpression_1;
          } else {
            _xifexpression = null;
          }
          _xblockexpression = _xifexpression;
        }
        return Pair.<ILanguageAwareDiagramServer, SModelRoot>of(server, _xblockexpression);
      };
      return ListExtensions.map(diagramServers, _function_1);
    };
    final Consumer<List<Pair<ILanguageAwareDiagramServer, SModelRoot>>> _function_1 = (List<Pair<ILanguageAwareDiagramServer, SModelRoot>> resultList) -> {
      final Function1<Pair<ILanguageAwareDiagramServer, SModelRoot>, Boolean> _function_2 = (Pair<ILanguageAwareDiagramServer, SModelRoot> it) -> {
        SModelRoot _value = it.getValue();
        return Boolean.valueOf((_value != null));
      };
      final Consumer<Pair<ILanguageAwareDiagramServer, SModelRoot>> _function_3 = (Pair<ILanguageAwareDiagramServer, SModelRoot> it) -> {
        final IDiagramState state = it.getKey().getDiagramState();
        final SModelRoot currentM = state.getCurrentModel();
        SModelRoot _value = it.getValue();
        String _plus = ((("URIIIII" + currentM) + "Bahu") + _value);
        DiagramLanguageServerExtension.LOG.info(_plus);
        final SModelRoot x = it.getKey().getDiagramState().getCurrentModel();
        ILanguageAwareDiagramServer _key = it.getKey();
        _key.setModel(x);
        it.getKey().setModel(it.getValue());
        final SModelRoot currentM2 = state.getCurrentModel();
        SModelRoot _value_1 = it.getValue();
        String _plus_1 = ((("URIIIII2" + currentM2) + "Bahu2") + _value_1);
        DiagramLanguageServerExtension.LOG.info(_plus_1);
        this.elementIE.put(it.getKey(), currentM2);
        this.localK = currentM2;
      };
      IterableExtensions.<Pair<ILanguageAwareDiagramServer, SModelRoot>>filter(resultList, _function_2).forEach(_function_3);
    };
    final Function<Throwable, Void> _function_2 = (Throwable throwable) -> {
      DiagramLanguageServerExtension.LOG.error("Error while processing build results", throwable);
      return null;
    };
    return this.languageServerAccess.<List<Pair<ILanguageAwareDiagramServer, SModelRoot>>>doRead(path, _function).thenAccept(_function_1).exceptionally(_function_2);
  }
  
  @Override
  public void didClose(final String clientId) {
    super.didClose(clientId);
    DiagramLanguageServerExtension.LOG.info(("Removed diagram server for " + clientId));
  }
}
