package org.jucmnav.turn.ide.codelens;

import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.validation.Issue
import org.jucmnav.turn.turn.URNspec

interface IValidatorExtension {
	
	def void validate(URNspec module, IAcceptor<Issue> issueAcceptor, CancelIndicator cancelIndicator);
	
}