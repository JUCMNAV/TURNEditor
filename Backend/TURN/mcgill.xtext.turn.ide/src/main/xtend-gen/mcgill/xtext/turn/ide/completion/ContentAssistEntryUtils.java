package mcgill.xtext.turn.ide.completion;

import java.util.Arrays;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Extension and utility methods for {@link ContentAssistEntry content assist entries}.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class ContentAssistEntryUtils {
  /**
   * Sets the source on the content assist entry argument and returns with it.
   * <p>
   * The source is retrieved from the current module of the CA context. If the current model
   * is {@code null}, then sets the containing resource as the source.
   * 
   * <p>
   * If the source is already set on the entry, this method has no side-effect.
   */
  public static ContentAssistEntry attachSourceIfAbsent(final ContentAssistEntry it, final ContentAssistContext context) {
    if (((it != null) && (it.getSource() == null))) {
      Notifier _elvis = null;
      EObject _currentModel = null;
      if (context!=null) {
        _currentModel=context.getCurrentModel();
      }
      if (_currentModel != null) {
        _elvis = _currentModel;
      } else {
        XtextResource _resource = null;
        if (context!=null) {
          _resource=context.getResource();
        }
        _elvis = _resource;
      }
      it.setSource(_elvis);
    }
    return it;
  }
  
  /**
   * Returns with the name of the container resource (without the file extension suffix)
   * from the  EObject (if any) which the entry argument has been created.
   */
  public static String getResourceName(final ContentAssistEntry it) {
    Object _source = null;
    if (it!=null) {
      _source=it.getSource();
    }
    return ContentAssistEntryUtils.doGetResourceName(_source);
  }
  
  private static String _doGetResourceName(final Void it) {
    return null;
  }
  
  private static String _doGetResourceName(final Object it) {
    return null;
  }
  
  private static String _doGetResourceName(final URI it) {
    String _lastSegment = it.lastSegment();
    int _length = it.lastSegment().length();
    int _length_1 = it.fileExtension().length();
    int _plus = (_length_1 + 1);
    int _minus = (_length - _plus);
    return _lastSegment.substring(0, _minus);
  }
  
  private static String _doGetResourceName(final Resource it) {
    return ContentAssistEntryUtils.doGetResourceName(it.getURI());
  }
  
  private static String _doGetResourceName(final EObject it) {
    return ContentAssistEntryUtils.doGetResourceName(it.eResource().getURI());
  }
  
  private static String _doGetResourceName(final IEObjectDescription it) {
    return ContentAssistEntryUtils.doGetResourceName(it.getEObjectOrProxy());
  }
  
  private static String doGetResourceName(final Object it) {
    if (it instanceof EObject) {
      return _doGetResourceName((EObject)it);
    } else if (it instanceof Resource) {
      return _doGetResourceName((Resource)it);
    } else if (it == null) {
      return _doGetResourceName((Void)null);
    } else if (it instanceof URI) {
      return _doGetResourceName((URI)it);
    } else if (it instanceof IEObjectDescription) {
      return _doGetResourceName((IEObjectDescription)it);
    } else if (it != null) {
      return _doGetResourceName(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
