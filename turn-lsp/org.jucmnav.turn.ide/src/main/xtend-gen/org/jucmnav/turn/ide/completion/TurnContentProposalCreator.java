package org.jucmnav.turn.ide.completion;

import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalCreator;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.jucmnav.turn.ide.completion.ContentAssistEntryUtils;

/**
 * Content proposal creator for TURN.
 * 
 * <p>
 * Sets the {@link ContentAssistEntry#getSource() source} EObject (based on the
 * {@link ContentAssistContext#getCurrentModel() current model} of the content
 * assist content) on the content assist entry to be able to reuse it for
 * temples. For instance to be able to get the name of the containing resource.
 */
@SuppressWarnings("all")
public class TurnContentProposalCreator extends IdeContentProposalCreator {
  /**
   * Besides doing exactly what described at {@link IdeContentProposalCreator} the super class,
   * it tries to set the source of the entry. If the current model of the content is not {@code null}
   * it sets on the entry. If the current module is {@code null} (consider an empty TURN file), then sets
   * the resource as the source.
   */
  @Override
  public ContentAssistEntry createProposal(final String proposal, final String prefix, final ContentAssistContext context, final String kind, final Procedure1<? super ContentAssistEntry> init) {
    return ContentAssistEntryUtils.attachSourceIfAbsent(super.createProposal(proposal, prefix, context, kind, init), context);
  }
}
