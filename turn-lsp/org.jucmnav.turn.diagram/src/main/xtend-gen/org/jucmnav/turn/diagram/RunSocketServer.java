/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.jucmnav.turn.diagram;

import com.google.gson.GsonBuilder;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.typefox.sprotty.layout.ElkLayoutEngine;
import io.typefox.sprotty.server.json.ActionTypeAdapter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.log4j.Logger;
import org.eclipse.elk.alg.layered.options.LayeredMetaDataProvider;
import org.eclipse.elk.core.util.persistence.ElkGraphResourceFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.Modules2;
import org.jucmnav.turn.TurnRuntimeModule;
import org.jucmnav.turn.diagram.TurnDiagramModule;
import org.jucmnav.turn.ide.TurnIdeModule;
import org.jucmnav.turn.ide.TurnIdeSetup;

@SuppressWarnings("all")
public class RunSocketServer {
  private static final Logger LOG = Logger.getLogger(RunSocketServer.class);
  
  public static void main(final String[] args) throws Exception {
    LayeredMetaDataProvider _layeredMetaDataProvider = new LayeredMetaDataProvider();
    ElkLayoutEngine.initialize(_layeredMetaDataProvider);
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    ElkGraphResourceFactory _elkGraphResourceFactory = new ElkGraphResourceFactory();
    _extensionToFactoryMap.put("elkg", _elkGraphResourceFactory);
    new TurnIdeSetup() {
      @Override
      public Injector createInjector() {
        TurnRuntimeModule _turnRuntimeModule = new TurnRuntimeModule();
        TurnIdeModule _turnIdeModule = new TurnIdeModule();
        TurnDiagramModule _turnDiagramModule = new TurnDiagramModule();
        return Guice.createInjector(Modules2.mixin(_turnRuntimeModule, _turnIdeModule, _turnDiagramModule));
      }
    }.createInjectorAndDoEMFRegistration();
    ServerModule _serverModule = new ServerModule();
    final com.google.inject.Module _function = (Binder it) -> {
      it.<IResourceServiceProvider.Registry>bind(IResourceServiceProvider.Registry.class).toProvider(IResourceServiceProvider.Registry.RegistryProvider.class);
    };
    final Injector injector = Guice.createInjector(Modules2.mixin(_serverModule, _function));
    AsynchronousServerSocketChannel _open = AsynchronousServerSocketChannel.open();
    InetSocketAddress _inetSocketAddress = new InetSocketAddress("localhost", 5007);
    final AsynchronousServerSocketChannel serverSocket = _open.bind(_inetSocketAddress);
    final ExecutorService threadPool = Executors.newCachedThreadPool();
    while (true) {
      {
        final AsynchronousSocketChannel socketChannel = serverSocket.accept().get();
        final InputStream in = Channels.newInputStream(socketChannel);
        final OutputStream out = Channels.newOutputStream(socketChannel);
        final Consumer<GsonBuilder> _function_1 = (GsonBuilder gsonBuilder) -> {
          ActionTypeAdapter.configureGson(gsonBuilder);
        };
        final Consumer<GsonBuilder> configureGson = _function_1;
        final LanguageServerImpl languageServer = injector.<LanguageServerImpl>getInstance(LanguageServerImpl.class);
        final Function<MessageConsumer, MessageConsumer> _function_2 = (MessageConsumer it) -> {
          return it;
        };
        final Launcher<LanguageClient> launcher = Launcher.<LanguageClient>createIoLauncher(languageServer, LanguageClient.class, in, out, threadPool, _function_2, configureGson);
        languageServer.connect(launcher.getRemoteProxy());
        launcher.startListening();
        SocketAddress _remoteAddress = socketChannel.getRemoteAddress();
        String _plus = ("Started language server for client " + _remoteAddress);
        RunSocketServer.LOG.info(_plus);
      }
    }
  }
}
