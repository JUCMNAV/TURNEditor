package org.xtext.project.turn.tcolab.ide.codelens;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.Issue;

@SuppressWarnings("all")
public interface IValidatorExtension {
  public abstract void validate(final /* URNspec */Object module, final IAcceptor<Issue> issueAcceptor, final CancelIndicator cancelIndicator);
}
