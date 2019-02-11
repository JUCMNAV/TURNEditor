/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.xtext.project.turn.tcolab.diagram;

import com.google.common.base.Objects;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import io.typefox.sprotty.server.json.ActionTypeAdapter;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.AsyncAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.MessageType;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.jsonrpc.messages.Message;
import org.eclipse.lsp4j.jsonrpc.validation.ReflectiveMessageValidator;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.LaunchArgs;
import org.eclipse.xtext.ide.server.ServerLauncher;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public class TurnServerLauncher extends ServerLauncher {
  @Data
  public static class LanguageClientAppender extends AppenderSkeleton {
    private final LanguageClient client;
    
    @Override
    protected void append(final LoggingEvent event) {
      MessageParams _messageParams = new MessageParams();
      final Procedure1<MessageParams> _function = (MessageParams it) -> {
        String _string = event.getMessage().toString();
        String _xifexpression = null;
        if (((event.getThrowableStrRep() != null) && (event.getThrowableStrRep().length > 0))) {
          String[] _throwableStrRep = event.getThrowableStrRep();
          String _join = null;
          if (((Iterable<?>)Conversions.doWrapArray(_throwableStrRep))!=null) {
            _join=IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_throwableStrRep)), "\n");
          }
          _xifexpression = (": " + _join);
        } else {
          _xifexpression = "";
        }
        String _plus = (_string + _xifexpression);
        it.setMessage(_plus);
        MessageType _switchResult = null;
        Level _level = event.getLevel();
        boolean _matched = false;
        if (Objects.equal(_level, Level.ERROR)) {
          _matched=true;
          _switchResult = MessageType.Error;
        }
        if (!_matched) {
          if (Objects.equal(_level, Level.INFO)) {
            _matched=true;
            _switchResult = MessageType.Info;
          }
        }
        if (!_matched) {
          if (Objects.equal(_level, Level.WARN)) {
            _matched=true;
            _switchResult = MessageType.Warning;
          }
        }
        if (!_matched) {
          _switchResult = MessageType.Log;
        }
        it.setType(_switchResult);
      };
      MessageParams _doubleArrow = ObjectExtensions.<MessageParams>operator_doubleArrow(_messageParams, _function);
      this.client.logMessage(_doubleArrow);
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public boolean requiresLayout() {
      return false;
    }
    
    public LanguageClientAppender(final LanguageClient client) {
      super();
      this.client = client;
    }
    
    @Override
    @Pure
    public int hashCode() {
      return 31 * 1 + ((this.client== null) ? 0 : this.client.hashCode());
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      TurnServerLauncher.LanguageClientAppender other = (TurnServerLauncher.LanguageClientAppender) obj;
      if (this.client == null) {
        if (other.client != null)
          return false;
      } else if (!this.client.equals(other.client))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      return new ToStringBuilder(this)
      	.addAllFields()
      	.toString();
    }
    
    @Pure
    public LanguageClient getClient() {
      return this.client;
    }
  }
  
  public static void main(final String[] args) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createInjectorAndDoEMFRegistration() is undefined for the type new TurnIdeSetup(){}"
      + "\nTurnRuntimeModule cannot be resolved.");
  }
  
  @Inject
  private LanguageServerImpl languageServer;
  
  @Override
  public void start(final LaunchArgs args) {
    try {
      final ExecutorService executorService = Executors.newCachedThreadPool();
      final Consumer<GsonBuilder> _function = (GsonBuilder gsonBuilder) -> {
        ActionTypeAdapter.configureGson(gsonBuilder);
      };
      final Consumer<GsonBuilder> configureGson = _function;
      final Launcher<LanguageClient> launcher = Launcher.<LanguageClient>createIoLauncher(this.languageServer, LanguageClient.class, args.getIn(), args.getOut(), executorService, 
        this.getWrapper(args), configureGson);
      final LanguageClient client = launcher.getRemoteProxy();
      this.languageServer.connect(client);
      Logger _rootLogger = Logger.getRootLogger();
      final Procedure1<Logger> _function_1 = (Logger it) -> {
        it.removeAllAppenders();
        AsyncAppender _asyncAppender = new AsyncAppender();
        final Procedure1<AsyncAppender> _function_2 = (AsyncAppender it_1) -> {
          TurnServerLauncher.LanguageClientAppender _languageClientAppender = new TurnServerLauncher.LanguageClientAppender(client);
          it_1.addAppender(_languageClientAppender);
        };
        AsyncAppender _doubleArrow = ObjectExtensions.<AsyncAppender>operator_doubleArrow(_asyncAppender, _function_2);
        it.addAppender(_doubleArrow);
      };
      ObjectExtensions.<Logger>operator_doubleArrow(_rootLogger, _function_1);
      final Future<Void> future = launcher.startListening();
      while ((!future.isDone())) {
        Thread.sleep(10_000l);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private Function<MessageConsumer, MessageConsumer> getWrapper(final LaunchArgs args) {
    final Function<MessageConsumer, MessageConsumer> _function = (MessageConsumer consumer) -> {
      MessageConsumer result = consumer;
      PrintWriter _trace = args.getTrace();
      boolean _tripleNotEquals = (_trace != null);
      if (_tripleNotEquals) {
        final MessageConsumer _function_1 = (Message message) -> {
          args.getTrace().println(message);
          args.getTrace().flush();
          consumer.consume(message);
        };
        result = _function_1;
      }
      boolean _isValidate = args.isValidate();
      if (_isValidate) {
        ReflectiveMessageValidator _reflectiveMessageValidator = new ReflectiveMessageValidator(result);
        result = _reflectiveMessageValidator;
      }
      return result;
    };
    return _function;
  }
}
