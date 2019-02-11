package org.xtext.project.turn.tcolab.ide.codelens;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.inject.Singleton;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.InputOutput;

@Singleton
@SuppressWarnings("all")
public class IssueCodes extends ConfigurableIssueCodesProvider {
  /* @Data
   */public static class DocumentedPreferenceKey extends PreferenceKey {
    private String documentation;
  }
  
  private final static ImmutableMap.Builder<String, PreferenceKey> BUILDER = ImmutableMap.<String, PreferenceKey>builder();
  
  public final static String SUBSTATEMENT_CARDINALITY = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code that are entangled with cardinality problems of container statement\'s sub-statements.");
      _builder.newLine();
      String _error = IssueCodes.error("substatement-cardinality", _builder);
      return _error;
    }
  }.apply();
  
  public final static String UNEXPECTED_SUBSTATEMENT = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code indicating an invalid sub-statement inside its parent statement container.");
      _builder.newLine();
      String _error = IssueCodes.error("unexpected-statement", _builder);
      return _error;
    }
  }.apply();
  
  public final static String SUBSTATEMENT_ORDERING = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code for cases when a sub-statement incorrectly precedes another sub-statement.");
      _builder.newLine();
      String _error = IssueCodes.error("substatement-ordering", _builder);
      return _error;
    }
  }.apply();
  
  public final static String INCORRECT_VERSION = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issues code that is used when a module has anything but {@code \'1.1\'} version.");
      _builder.newLine();
      String _error = IssueCodes.error("incorrect-version", _builder);
      return _error;
    }
  }.apply();
  
  public final static String TYPE_ERROR = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Errors for types. Such as invalid type restriction, range error, fraction-digits issue.");
      _builder.newLine();
      String _error = IssueCodes.error("type-error", _builder);
      return _error;
    }
  }.apply();
  
  public final static String DUPLICATE_NAME = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("A duplicate local name.");
      _builder.newLine();
      String _error = IssueCodes.error("duplicate-name", _builder);
      return _error;
    }
  }.apply();
  
  public final static String MISSING_PREFIX = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      String _error = IssueCodes.error("missing-prefix", _builder);
      return _error;
    }
  }.apply();
  
  public final static String AMBIGUOUS_IMPORT = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Diagnostic that indicates a module import is ambiguous.");
      _builder.newLine();
      String _warn = IssueCodes.warn("ambiguous-import", _builder);
      return _warn;
    }
  }.apply();
  
  public final static String IMPORT_NOT_A_MODULE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Diagnostic indicating that an `import` statement is not pointing to a module.");
      _builder.newLine();
      String _error = IssueCodes.error("import-not-a-module", _builder);
      return _error;
    }
  }.apply();
  
  public final static String INCLUDE_NOT_A_SUB_MODULE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Diagnostic indicating that an `include` statement is not pointing to a submodule.");
      _builder.newLine();
      String _error = IssueCodes.error("include-not-a-submodule", _builder);
      return _error;
    }
  }.apply();
  
  public final static String INCLUDED_SUB_MODULE_BELONGS_TO_DIFFERENT_MODULE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Indicating that an included module belongs to a different module.");
      _builder.newLine();
      String _error = IssueCodes.error("included-submodule-belongs-to-different-module", _builder);
      return _error;
    }
  }.apply();
  
  public final static String INVALID_REVISION_FORMAT = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code when the revision date does not conform the \"YYYY-MM-DD\" format.");
      _builder.newLine();
      String _warn = IssueCodes.warn("invalid-revision-format", _builder);
      return _warn;
    }
  }.apply();
  
  public final static String REVISION_ORDER = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code that applies on a revision if that is not in a reverse chronological order.");
      _builder.newLine();
      String _warn = IssueCodes.warn("revision-order", _builder);
      return _warn;
    }
  }.apply();
  
  public final static String REVISION_MISMATCH = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code that applies when the leading revision does not match the revision in the file name.");
      _builder.newLine();
      String _warn = IssueCodes.warn("revision-mismatch", _builder);
      return _warn;
    }
  }.apply();
  
  public final static String BAD_TYPE_NAME = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code when the name of a type does not conform with the existing constraints.");
      _builder.newLine();
      _builder.append("For instance; the name contains any invalid characters, or equals to any YANG built-in type name.");
      _builder.newLine();
      String _error = IssueCodes.error("bad-type-name", _builder);
      return _error;
    }
  }.apply();
  
  public final static String BAD_INCLUDE_YANG_VERSION = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issues code when there is an inconsistency between a module\'s version and the version of the included modules.");
      _builder.newLine();
      String _error = IssueCodes.error("bad-include-turn-version", _builder);
      return _error;
    }
  }.apply();
  
  public final static String BAD_IMPORT_YANG_VERSION = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issues code when there is an inconsistency between a module\'s version and the version of the included modules.");
      _builder.newLine();
      String _error = IssueCodes.error("bad-import-turn-version", _builder);
      return _error;
    }
  }.apply();
  
  public final static String DUPLICATE_ENUMERABLE_NAME = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code indicating that all assigned names in an enumerable must be unique.");
      _builder.newLine();
      String _error = IssueCodes.error("duplicate-enumerable-name", _builder);
      return _error;
    }
  }.apply();
  
  public final static String DUPLICATE_ENUMERABLE_VALUE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code indicating that all assigned values in an enumerable must be unique.");
      _builder.newLine();
      String _error = IssueCodes.error("duplicate-enumerable-value", _builder);
      return _error;
    }
  }.apply();
  
  public final static String ENUMERABLE_RESTRICTION_NAME = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code indicating that an enumerable introduces a new name that is not declared among the parent restriction.");
      _builder.newLine();
      String _error = IssueCodes.error("enumerable-restriction-name", _builder);
      return _error;
    }
  }.apply();
  
  public final static String ENUMERABLE_RESTRICTION_VALUE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code indicating that an enumerable introduces a new value that is not declared among the parent restriction.");
      _builder.newLine();
      String _error = IssueCodes.error("enumerable-restriction-value", _builder);
      return _error;
    }
  }.apply();
  
  public final static String KEY_DUPLICATE_LEAF_NAME = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issues code for indicating a duplicate leaf node name in a key.");
      _builder.newLine();
      String _error = IssueCodes.error("key-duplicate-leaf-name", _builder);
      return _error;
    }
  }.apply();
  
  public final static String ORDINAL_VALUE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code when an ordinal value exceeds its limits.");
      _builder.newLine();
      String _error = IssueCodes.error("ordinal-value", _builder);
      return _error;
    }
  }.apply();
  
  public final static String INVALID_CONFIG = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code when a `config=true` is a child of a `config=false` (see https://tools.ietf.org/html/rfc7950#section-7.21.1)");
      _builder.newLine();
      String _error = IssueCodes.error("invalid-config", _builder);
      return _error;
    }
  }.apply();
  
  public final static String INVALID_AUGMENTATION = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code when an augmented node declares invalid sub-statements. For instance when an augmented leaf node has leaf nodes.");
      _builder.newLine();
      String _error = IssueCodes.error("invalid-augmentation", _builder);
      return _error;
    }
  }.apply();
  
  public final static String INVALID_DEFAULT = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code for cases when the a choice has default value and the mandatory sub-statement is \"true\".");
      _builder.newLine();
      String _error = IssueCodes.error("invalid-default", _builder);
      return _error;
    }
  }.apply();
  
  public final static String MANDATORY_AFTER_DEFAULT_CASE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code when any mandatory nodes are declared after the default case in a \"choice\".");
      _builder.newLine();
      String _error = IssueCodes.error("mandatory-after-default-case", _builder);
      return _error;
    }
  }.apply();
  
  public final static String INVALID_ANCESTOR = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code when an action (or notification) has a \"list\" ancestor node without a \"key\" statement.");
      _builder.newLine();
      _builder.append("Also applies, when an action (or notification) is declared within another action, rpc or notification.");
      _builder.newLine();
      String _error = IssueCodes.error("invalid-action-ancestor", _builder);
      return _error;
    }
  }.apply();
  
  public final static String IDENTITY_CYCLE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code when an identity references itself, either directly or indirectly through a chain of other identities.");
      _builder.newLine();
      String _error = IssueCodes.error("identity-cycle", _builder);
      return _error;
    }
  }.apply();
  
  public final static String LEAF_KEY_WITH_IF_FEATURE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("This issue code is used when a leaf node is declared as a list key and have any \"if-feature\" statements.");
      _builder.newLine();
      String _error = IssueCodes.error("leaf-key-with-if-feature", _builder);
      return _error;
    }
  }.apply();
  
  public final static String INVALID_TYPE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Invalid type in Xpath expression");
      _builder.newLine();
      String _error = IssueCodes.error("xpath-invalid-type", _builder);
      return _error;
    }
  }.apply();
  
  public final static String UNKNOWN_VARIABLE = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Xpath expressions in YANG don\'t have variables in context");
      _builder.newLine();
      String _error = IssueCodes.error("xpath-unknown-variable", _builder);
      return _error;
    }
  }.apply();
  
  public final static String UNKNOWN_FUNCTION = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("An unknown function is called");
      _builder.newLine();
      String _warn = IssueCodes.warn("xpath-unknown-function", _builder);
      return _warn;
    }
  }.apply();
  
  public final static String FUNCTION_ARITY = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Wrong argument arity for an Xpath function call.");
      _builder.newLine();
      String _error = IssueCodes.error("xpath-function-arity", _builder);
      return _error;
    }
  }.apply();
  
  public final static String XPATH_LINK_ERROR = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Diagnostic for unresolvable Xpath expressions.");
      _builder.newLine();
      String _ignore = IssueCodes.ignore("xpath-linking-error", _builder);
      return _ignore;
    }
  }.apply();
  
  private final static Map<String, PreferenceKey> CODES = IssueCodes.BUILDER.build();
  
  @Override
  public Map<String, PreferenceKey> getConfigurableIssueCodes() {
    return IssueCodes.CODES;
  }
  
  private static String error(final String code, final CharSequence doc) {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The constructor DocumentedPreferenceKey() is not applicable for the arguments (String,String,String)");
  }
  
  private static String warn(final String code, final CharSequence doc) {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The constructor DocumentedPreferenceKey() is not applicable for the arguments (String,String,String)");
  }
  
  private static String ignore(final String code, final CharSequence doc) {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The constructor DocumentedPreferenceKey() is not applicable for the arguments (String,String,String)");
  }
  
  public static void main(final String[] args) {
    final Consumer<IssueCodes.DocumentedPreferenceKey> _function = (IssueCodes.DocumentedPreferenceKey it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#### `");
      String _id = it.getId();
      _builder.append(_id);
      _builder.append("`");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append(it.documentation);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append(" ");
      _builder.append("(default severity: ");
      String _defaultValue = it.getDefaultValue();
      _builder.append(_defaultValue, " ");
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      InputOutput.<String>println(_builder.toString());
    };
    Iterables.<IssueCodes.DocumentedPreferenceKey>filter(IssueCodes.CODES.values(), IssueCodes.DocumentedPreferenceKey.class).forEach(_function);
  }
}
