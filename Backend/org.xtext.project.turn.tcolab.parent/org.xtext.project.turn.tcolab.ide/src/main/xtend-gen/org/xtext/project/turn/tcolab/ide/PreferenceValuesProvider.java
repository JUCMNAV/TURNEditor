package org.xtext.project.turn.tcolab.ide;

import com.google.common.base.StandardSystemProperty;
import com.google.inject.Inject;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceValuesByLanguage;
import org.eclipse.xtext.util.IDisposable;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.xtext.project.turn.tcolab.ide.JsonFileBasedPreferenceValues;

/* @Log */@Singleton
@SuppressWarnings("all")
public class PreferenceValuesProvider implements IPreferenceValuesProvider {
  @Inject(optional = true)
  private IProjectConfigProvider configProvider;
  
  @Inject
  private LanguageInfo language;
  
  private List<Procedure2<? super IPreferenceValues, ? super Resource>> onChangeListeners = CollectionLiterals.<Procedure2<? super IPreferenceValues, ? super Resource>>newArrayList();
  
  @Override
  public IPreferenceValues getPreferenceValues(final Resource context) {
    if ((context == null)) {
      Map<String, String> _emptyMap = CollectionLiterals.<String, String>emptyMap();
      return new MapBasedPreferenceValues(_emptyMap);
    }
    PreferenceValuesByLanguage _elvis = null;
    PreferenceValuesByLanguage _findInEmfObject = PreferenceValuesByLanguage.findInEmfObject(context.getResourceSet());
    if (_findInEmfObject != null) {
      _elvis = _findInEmfObject;
    } else {
      PreferenceValuesByLanguage _preferenceValuesByLanguage = new PreferenceValuesByLanguage();
      final Procedure1<PreferenceValuesByLanguage> _function = (PreferenceValuesByLanguage it) -> {
        it.attachToEmfObject(context.getResourceSet());
      };
      PreferenceValuesByLanguage _doubleArrow = ObjectExtensions.<PreferenceValuesByLanguage>operator_doubleArrow(_preferenceValuesByLanguage, _function);
      _elvis = _doubleArrow;
    }
    final PreferenceValuesByLanguage valuesByLanguage = _elvis;
    IPreferenceValues _elvis_1 = null;
    IPreferenceValues _get = valuesByLanguage.get(this.language.getLanguageName());
    if (_get != null) {
      _elvis_1 = _get;
    } else {
      IPreferenceValues _createPreferenceValues = this.createPreferenceValues(context);
      _elvis_1 = _createPreferenceValues;
    }
    IPreferenceValues values = _elvis_1;
    valuesByLanguage.put(this.language.getLanguageName(), values);
    if ((values instanceof JsonFileBasedPreferenceValues)) {
      boolean _checkIsUpToDate = ((JsonFileBasedPreferenceValues)values).checkIsUpToDate();
      boolean _not = (!_checkIsUpToDate);
      if (_not) {
        for (final Procedure2<? super IPreferenceValues, ? super Resource> listener : this.onChangeListeners) {
          listener.apply(values, context);
        }
      }
    }
    return values;
  }
  
  protected IPreferenceValues createPreferenceValues(final Resource resource) {
    try {
      MapBasedPreferenceValues result = new MapBasedPreferenceValues(PreferenceValuesProvider.constantSettings);
      final Path userHome = Paths.get(StandardSystemProperty.USER_HOME.value());
      final Path userSettings = userHome.resolve(".turn").resolve("turn.settings");
      JsonFileBasedPreferenceValues _jsonFileBasedPreferenceValues = new JsonFileBasedPreferenceValues(userSettings, result);
      result = _jsonFileBasedPreferenceValues;
      if ((this.configProvider == null)) {
        return result;
      }
      final IProjectConfig config = this.configProvider.getProjectConfig(resource.getResourceSet());
      if ((config == null)) {
        return result;
      }
      URI _path = config.getPath();
      boolean _tripleNotEquals = (_path != null);
      if (_tripleNotEquals) {
        int _xifexpression = (int) 0;
        boolean _isEmpty = config.getPath().lastSegment().isEmpty();
        if (_isEmpty) {
          _xifexpression = 1;
        } else {
          _xifexpression = 0;
        }
        final int segmentsToRemove = _xifexpression;
        String _string = config.getPath().trimSegments((segmentsToRemove + 1)).toString();
        final java.net.URI workspaceDirectory = new java.net.URI(_string);
        final Path workspaceSettings = Paths.get(workspaceDirectory).resolve("turn.settings");
        JsonFileBasedPreferenceValues _jsonFileBasedPreferenceValues_1 = new JsonFileBasedPreferenceValues(workspaceSettings, result);
        result = _jsonFileBasedPreferenceValues_1;
        String _string_1 = config.getPath().trimSegments(segmentsToRemove).toString();
        final java.net.URI projectDirectory = new java.net.URI(_string_1);
        final Path projectSettings = Paths.get(projectDirectory).resolve("turn.settings");
        JsonFileBasedPreferenceValues _jsonFileBasedPreferenceValues_2 = new JsonFileBasedPreferenceValues(projectSettings, result);
        result = _jsonFileBasedPreferenceValues_2;
      }
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private final static Map<String, String> constantSettings = CollectionLiterals.<String, String>newHashMap();
  
  public IDisposable registerChangeListener(final Procedure2<? super IPreferenceValues, ? super Resource> callback) {
    this.onChangeListeners.add(callback);
    final IDisposable _function = () -> {
      this.onChangeListeners.remove(callback);
    };
    return _function;
  }
}
