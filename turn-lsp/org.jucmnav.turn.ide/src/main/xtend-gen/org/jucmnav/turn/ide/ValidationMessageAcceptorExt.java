package org.jucmnav.turn.ide;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * Validation message acceptor extension that holds information whether an error has been
 * accepted by the wrapped delegate or not.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class ValidationMessageAcceptorExt implements ValidationMessageAcceptor {
  @Delegate
  private final ValidationMessageAcceptor delegate;
  
  private boolean errorFlag = false;
  
  /**
   * Wraps the delegate into an acceptor extension. If the delegate argument is already an
   * instance of an acceptor extension, then returns with the argument.
   */
  public static ValidationMessageAcceptorExt wrappedAcceptor(final ValidationMessageAcceptor delegate) {
    if ((delegate instanceof ValidationMessageAcceptorExt)) {
      return ((ValidationMessageAcceptorExt)delegate);
    }
    return new ValidationMessageAcceptorExt(delegate);
  }
  
  @Override
  public void acceptError(final String message, final EObject object, final EStructuralFeature feature, final int index, final String code, final String... issueData) {
    this.errorFlag = true;
    this.delegate.acceptError(message, object, feature, index, code, issueData);
  }
  
  @Override
  public void acceptError(final String message, final EObject object, final int offset, final int length, final String code, final String... issueData) {
    this.errorFlag = true;
    this.delegate.acceptError(message, object, offset, length, code, issueData);
  }
  
  /**
   * Returns {@code true} if at least one error has been accepted. If not, returns {@code false}.
   */
  public boolean hasError() {
    return this.errorFlag;
  }
  
  public ValidationMessageAcceptorExt(final ValidationMessageAcceptor delegate) {
    super();
    this.delegate = delegate;
  }
  
  public void acceptInfo(final String message, final EObject object, final EStructuralFeature feature, final int index, final String code, final String... issueData) {
    this.delegate.acceptInfo(message, object, feature, index, code, issueData);
  }
  
  public void acceptInfo(final String message, final EObject object, final int offset, final int length, final String code, final String... issueData) {
    this.delegate.acceptInfo(message, object, offset, length, code, issueData);
  }
  
  public void acceptWarning(final String message, final EObject object, final EStructuralFeature feature, final int index, final String code, final String... issueData) {
    this.delegate.acceptWarning(message, object, feature, index, code, issueData);
  }
  
  public void acceptWarning(final String message, final EObject object, final int offset, final int length, final String code, final String... issueData) {
    this.delegate.acceptWarning(message, object, offset, length, code, issueData);
  }
}
