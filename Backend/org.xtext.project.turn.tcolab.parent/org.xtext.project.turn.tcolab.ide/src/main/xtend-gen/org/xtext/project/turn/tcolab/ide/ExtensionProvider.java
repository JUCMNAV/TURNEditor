package org.xtext.project.turn.tcolab.ide;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.xtext.project.turn.tcolab.ide.ExtensionClassPathProvider;
import org.xtext.project.turn.tcolab.ide.PreferenceValuesProvider;

@Log
@SuppressWarnings("all")
public class ExtensionProvider {
  @Data
  public static class Entry {
    private final String configuredValue;
    
    private final List<?> cachedExtensionObjects;
    
    public Entry(final String configuredValue, final List<?> cachedExtensionObjects) {
      super();
      this.configuredValue = configuredValue;
      this.cachedExtensionObjects = cachedExtensionObjects;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.configuredValue== null) ? 0 : this.configuredValue.hashCode());
      return prime * result + ((this.cachedExtensionObjects== null) ? 0 : this.cachedExtensionObjects.hashCode());
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
      ExtensionProvider.Entry other = (ExtensionProvider.Entry) obj;
      if (this.configuredValue == null) {
        if (other.configuredValue != null)
          return false;
      } else if (!this.configuredValue.equals(other.configuredValue))
        return false;
      if (this.cachedExtensionObjects == null) {
        if (other.cachedExtensionObjects != null)
          return false;
      } else if (!this.cachedExtensionObjects.equals(other.cachedExtensionObjects))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("configuredValue", this.configuredValue);
      b.add("cachedExtensionObjects", this.cachedExtensionObjects);
      return b.toString();
    }
    
    @Pure
    public String getConfiguredValue() {
      return this.configuredValue;
    }
    
    @Pure
    public List<?> getCachedExtensionObjects() {
      return this.cachedExtensionObjects;
    }
  }
  
  @Inject
  private ExtensionClassPathProvider classPathProvider;
  
  @Inject
  private PreferenceValuesProvider preferenceProvider;
  
  @Inject
  private Injector injector;
  
  private Map<String, ExtensionProvider.Entry> cache = CollectionLiterals.<String, ExtensionProvider.Entry>newHashMap();
  
  public <T extends Object> List<T> getExtensions(final PreferenceKey key, final Resource res, final Class<T> clazz) {
    final IPreferenceValues preferences = this.preferenceProvider.getPreferenceValues(res);
    final String value = preferences.getPreference(key);
    final ExtensionProvider.Entry previous = this.cache.get(key);
    if (((previous != null) && Objects.equal(previous.configuredValue, value))) {
      return ((List<T>) previous.cachedExtensionObjects);
    }
    final ArrayList<Object> result = CollectionLiterals.<Object>newArrayList();
    final ClassLoader classLoader = this.classPathProvider.getExtensionLoader(res);
    String[] _split = value.split(":");
    for (final String className : _split) {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(className);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        try {
          final Class<?> extensionClass = classLoader.loadClass(className);
          final Object extensionInstance = extensionClass.newInstance();
          this.injector.injectMembers(extensionInstance);
          result.add(extensionInstance);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            ExtensionProvider.LOG.error((("Could not load extension class \'" + className) + "\'"), e);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    String _id = key.getId();
    ExtensionProvider.Entry _entry = new ExtensionProvider.Entry(value, result);
    this.cache.put(_id, _entry);
    return ((List<T>) result);
  }
  
  private final static Logger LOG = Logger.getLogger(ExtensionProvider.class);
}
