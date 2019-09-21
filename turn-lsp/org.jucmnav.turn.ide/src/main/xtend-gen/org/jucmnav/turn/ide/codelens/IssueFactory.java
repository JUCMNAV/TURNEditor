package org.jucmnav.turn.ide.codelens;

import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.LineAndColumn;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class IssueFactory {
  public static Issue createIssue(final EObject obj, final EStructuralFeature feature, final Severity severity, final String message, final String code) {
    final List<INode> nodes = NodeModelUtils.findNodesForFeature(obj, feature);
    final LineAndColumn lineAndOffset = NodeModelUtils.getLineAndColumn(IterableExtensions.<INode>head(nodes), IterableExtensions.<INode>head(nodes).getOffset());
    final Issue.IssueImpl result = new Issue.IssueImpl();
    result.setMessage(message);
    result.setCode(code);
    result.setLineNumber(Integer.valueOf(lineAndOffset.getLine()));
    result.setColumn(Integer.valueOf(lineAndOffset.getColumn()));
    final Function1<INode, Integer> _function = (INode it) -> {
      return Integer.valueOf(it.getLength());
    };
    final Function2<Integer, Integer, Integer> _function_1 = (Integer p1, Integer p2) -> {
      return Integer.valueOf(((p1).intValue() + (p2).intValue()));
    };
    result.setLength(IterableExtensions.<Integer>reduce(ListExtensions.<INode, Integer>map(nodes, _function), _function_1));
    result.setSeverity(severity);
    result.setUriToProblem(EcoreUtil.getURI(obj));
    return result;
  }
  
  public static Issue createIssue(final EObject obj, final EStructuralFeature feature, final String message, final String code) {
    return IssueFactory.createIssue(obj, feature, Severity.ERROR, message, code);
  }
}
