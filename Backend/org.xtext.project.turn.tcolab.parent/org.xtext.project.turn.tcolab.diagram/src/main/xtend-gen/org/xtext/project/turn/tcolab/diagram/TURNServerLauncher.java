/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.xtext.project.turn.tcolab.diagram;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.io.PrintWriter;
import java.util.function.Function;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.MessageType;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.jsonrpc.messages.Message;
import org.eclipse.lsp4j.jsonrpc.validation.ReflectiveMessageValidator;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.LaunchArgs;
import org.eclipse.xtext.ide.server.ServerLauncher;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TURNServerLauncher extends ServerLauncher {
  /* @Data
   */public static class LanguageClientAppender extends AppenderSkeleton {
    private LanguageClient client;
    
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
  }
  
  public static void main(final String[] args) {
    throw new Error("Unresolved compilation problems:"
      + "\nTURNIdeSetup cannot be resolved."
      + "\nTURNRuntimeModule cannot be resolved."
      + "\nTURNIdeModule cannot be resolved."
      + "\nThe method createInjector() of type new Object(){} must override a superclass method."
      + "\ncreateInjectorAndDoEMFRegistration cannot be resolved");
  }
  
  @Inject
  private LanguageServerImpl languageServer;
  
  @Override
  public void start(final LaunchArgs args) {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The constructor LanguageClientAppender() is not applicable for the arguments (LanguageClient)");
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
