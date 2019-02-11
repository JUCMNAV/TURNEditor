package org.xtext.project.turn.tcolab.ide;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.inject.Inject;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ExtensionClassPathProvider {
  @EmfAdaptable
  @Accessors
  public static class ClassLoaderAdapter {
    public static class ClassLoaderAdapterAdapter extends AdapterImpl {
      private ExtensionClassPathProvider.ClassLoaderAdapter element;
      
      public ClassLoaderAdapterAdapter(final ExtensionClassPathProvider.ClassLoaderAdapter element) {
        this.element = element;
      }
      
      public ExtensionClassPathProvider.ClassLoaderAdapter get() {
        return this.element;
      }
      
      @Override
      public boolean isAdapterForType(final Object object) {
        return object == ExtensionClassPathProvider.ClassLoaderAdapter.class;
      }
    }
    
    private String classpath;
    
    private ClassLoader classLoader;
    
    public static ExtensionClassPathProvider.ClassLoaderAdapter findInEmfObject(final Notifier emfObject) {
      for (Adapter adapter : emfObject.eAdapters()) {
      	if (adapter instanceof ExtensionClassPathProvider.ClassLoaderAdapter.ClassLoaderAdapterAdapter) {
      		return ((ExtensionClassPathProvider.ClassLoaderAdapter.ClassLoaderAdapterAdapter) adapter).get();
      	}
      }
      return null;
    }
    
    public static ExtensionClassPathProvider.ClassLoaderAdapter removeFromEmfObject(final Notifier emfObject) {
      List<Adapter> adapters = emfObject.eAdapters();
      for(int i = 0, max = adapters.size(); i < max; i++) {
      	Adapter adapter = adapters.get(i);
      	if (adapter instanceof ExtensionClassPathProvider.ClassLoaderAdapter.ClassLoaderAdapterAdapter) {
      		emfObject.eAdapters().remove(i);
      		return ((ExtensionClassPathProvider.ClassLoaderAdapter.ClassLoaderAdapterAdapter) adapter).get();
      	}
      }
      return null;
    }
    
    public void attachToEmfObject(final Notifier emfObject) {
      ClassLoaderAdapter result = findInEmfObject(emfObject);
      if (result != null)
      	throw new IllegalStateException("The given EMF object already contains an adapter for ClassLoaderAdapter");
      ExtensionClassPathProvider.ClassLoaderAdapter.ClassLoaderAdapterAdapter adapter = new ExtensionClassPathProvider.ClassLoaderAdapter.ClassLoaderAdapterAdapter(this);
      emfObject.eAdapters().add(adapter);
    }
    
    @Pure
    public String getClasspath() {
      return this.classpath;
    }
    
    public void setClasspath(final String classpath) {
      this.classpath = classpath;
    }
    
    @Pure
    public ClassLoader getClassLoader() {
      return this.classLoader;
    }
    
    public void setClassLoader(final ClassLoader classLoader) {
      this.classLoader = classLoader;
    }
  }
  
  public final static PreferenceKey CLASS_PATH = new PreferenceKey("extension.classpath", "");
  
  @Inject
  private IPreferenceValuesProvider preferenceProvider;
  
  @Inject
  private IProjectConfigProvider projectConfigProvider;
  
  public ClassLoader getExtensionLoader(final Resource resource) {
    final IPreferenceValues prefs = this.preferenceProvider.getPreferenceValues(resource);
    final String classpath = prefs.getPreference(ExtensionClassPathProvider.CLASS_PATH);
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(classpath);
    if (_isNullOrEmpty) {
      return this.getClass().getClassLoader();
    }
    ExtensionClassPathProvider.ClassLoaderAdapter _elvis = null;
    ExtensionClassPathProvider.ClassLoaderAdapter _findInEmfObject = ExtensionClassPathProvider.ClassLoaderAdapter.findInEmfObject(resource.getResourceSet());
    if (_findInEmfObject != null) {
      _elvis = _findInEmfObject;
    } else {
      ExtensionClassPathProvider.ClassLoaderAdapter _classLoaderAdapter = new ExtensionClassPathProvider.ClassLoaderAdapter();
      final Procedure1<ExtensionClassPathProvider.ClassLoaderAdapter> _function = (ExtensionClassPathProvider.ClassLoaderAdapter it) -> {
        it.attachToEmfObject(resource.getResourceSet());
      };
      ExtensionClassPathProvider.ClassLoaderAdapter _doubleArrow = ObjectExtensions.<ExtensionClassPathProvider.ClassLoaderAdapter>operator_doubleArrow(_classLoaderAdapter, _function);
      _elvis = _doubleArrow;
    }
    final ExtensionClassPathProvider.ClassLoaderAdapter adapter = _elvis;
    boolean _notEquals = (!Objects.equal(adapter.classpath, classpath));
    if (_notEquals) {
      final IProjectConfig conf = this.projectConfigProvider.getProjectConfig(resource.getResourceSet());
      final Function1<String, URL> _function_1 = (String it) -> {
        try {
          String _string = conf.getPath().appendSegment(it).toString();
          return new URL(_string);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      final URL[] urls = IterableExtensions.<URL>toList(IterableExtensions.<String, URL>map(Splitter.on(":").split(classpath), _function_1)).<URL>toArray(new URL[0]);
      URLClassLoader _uRLClassLoader = new URLClassLoader(urls);
      adapter.classLoader = _uRLClassLoader;
      adapter.classpath = classpath;
    }
    return adapter.classLoader;
  }
}
