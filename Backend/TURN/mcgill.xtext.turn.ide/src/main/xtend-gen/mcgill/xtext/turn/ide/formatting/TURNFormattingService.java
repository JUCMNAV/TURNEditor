package mcgill.xtext.turn.ide.formatting;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import java.util.HashMap;
import java.util.List;
import org.eclipse.lsp4j.FormattingOptions;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.formatting.FormattingService;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class TURNFormattingService extends FormattingService {
  @Inject
  private IIndentationInformation indentationInformation;
  
  @Override
  public List<TextEdit> format(final XtextResource resource, final Document document, final int offset, final int length, final FormattingOptions options) {
    String indent = this.indentationInformation.getIndentString();
    if ((options != null)) {
      boolean _isInsertSpaces = options.isInsertSpaces();
      if (_isInsertSpaces) {
        indent = Strings.padEnd("", options.getTabSize(), ' ');
      }
    }
    final HashMap<String, String> preferences = CollectionLiterals.<String, String>newHashMap();
    preferences.put("indentation", indent);
    TextRegion _textRegion = new TextRegion(offset, length);
    MapBasedPreferenceValues _mapBasedPreferenceValues = new MapBasedPreferenceValues(preferences);
    final List<ITextReplacement> replacements = this.format2(resource, _textRegion, _mapBasedPreferenceValues);
    final Function1<ITextReplacement, TextEdit> _function = (ITextReplacement r) -> {
      return this.toTextEdit(document, r.getReplacementText(), r.getOffset(), r.getLength());
    };
    return IterableExtensions.<TextEdit>toList(ListExtensions.<ITextReplacement, TextEdit>map(replacements, _function));
  }
}
