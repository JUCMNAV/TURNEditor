package org.xtext.project.turn.tcolab.ide;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/* @Log */@SuppressWarnings("all")
public class JsonFileBasedPreferenceValues extends MapBasedPreferenceValues {
  private final Path path;
  
  private FileTime lastModification = null;
  
  public JsonFileBasedPreferenceValues(final Path path, final IPreferenceValues delegate) {
    super(delegate, CollectionLiterals.<String, String>newHashMap());
    this.path = path;
  }
  
  /**
   * reloads the preferences from disk if the file has changed.
   * @return whether
   */
  public boolean checkIsUpToDate() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field LOG is undefined"
      + "\nerror cannot be resolved");
  }
  
  public void read() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field LOG is undefined"
      + "\nerror cannot be resolved");
  }
  
  private void internalFillMap(final String prefix, final JsonObject object) {
    Set<Map.Entry<String, JsonElement>> _entrySet = object.entrySet();
    for (final Map.Entry<String, JsonElement> entry : _entrySet) {
      JsonElement _value = entry.getValue();
      final JsonElement v = _value;
      boolean _matched = false;
      if (v instanceof JsonObject) {
        _matched=true;
        JsonElement _value_1 = entry.getValue();
        this.internalFillMap(entry.getKey(), ((JsonObject) _value_1));
      }
      if (!_matched) {
        if (v instanceof JsonPrimitive) {
          _matched=true;
          String _xifexpression = null;
          if ((prefix != null)) {
            String _key = entry.getKey();
            _xifexpression = ((prefix + ".") + _key);
          } else {
            _xifexpression = entry.getKey();
          }
          final String key = _xifexpression;
          this.put(key, ((JsonPrimitive)v).getAsString().toString());
        }
      }
    }
  }
}
