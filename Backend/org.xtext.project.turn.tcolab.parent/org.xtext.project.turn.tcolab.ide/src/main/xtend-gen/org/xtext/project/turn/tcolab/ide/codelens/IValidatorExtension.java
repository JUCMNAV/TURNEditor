package org.xtext.project.turn.tcolab.ide.codelens;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.xtext.project.turn.turn.URNspec;

@SuppressWarnings("all")
public interface IValidatorExtension {
  public abstract void validate(final URNspec module, final IAcceptor<Issue> issueAcceptor, final CancelIndicator cancelIndicator);
}
