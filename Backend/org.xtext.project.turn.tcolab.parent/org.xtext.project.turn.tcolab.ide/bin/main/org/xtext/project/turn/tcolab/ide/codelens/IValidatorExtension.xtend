package org.xtext.project.turn.tcolab.ide.codelens

import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.validation.Issue
import org.xtext.project.turn.turn.URNspec

interface IValidatorExtension {
	
	def void validate(URNspec module, IAcceptor<Issue> issueAcceptor, CancelIndicator cancelIndicator);
}
