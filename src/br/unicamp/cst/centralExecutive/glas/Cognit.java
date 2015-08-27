/**
 * 
 */
package br.unicamp.cst.centralExecutive.glas;

import br.unicamp.cst.core.entities.CodeRack;
import br.unicamp.cst.core.entities.RawMemory;
import br.unicamp.cst.memory.WorkingStorage;

/**
 * Cognit is the implementation of GLAS - Gated Learning Action Selection - algorithm inside LibreCog cognitive architecture.
 * It is composed by three integrated codelets:
 * - ActionSelectionCodelet: Selects the most appropriate action based on sequence of events and a known solution tree
 * - SequenceBuilderCodelet: Builds a sequence of events in memory based on stimuli, selected action and received reward
 * - LearnerCodelet: Learns an optimized solution tree given a sequence of events 
 * 
 * @author klaus
 *
 */
public class Cognit 
{
	private ActionSelectionCodelet action_selection_codelet;
	private SequenceBuilderCodelet sequence_builder_codelet;
	private LearnerCodelet learner_codelet;

	private RawMemory rawMemory;
	
	private CodeRack codeRack;

	public Cognit(int nStimuli, int nActions,CodeRack codeRack,RawMemory rawMemory, WorkingStorage ws)
	{
		this.codeRack = codeRack;
		this.rawMemory = rawMemory;
		//GLAS Codelets
		action_selection_codelet = new ActionSelectionCodelet(rawMemory,ws);
		if(codeRack!=null)
			codeRack.insertCodelet(action_selection_codelet);				
		sequence_builder_codelet = new SequenceBuilderCodelet(rawMemory,ws);
		if(codeRack!=null)
			codeRack.insertCodelet(sequence_builder_codelet);
		learner_codelet = new LearnerCodelet(nStimuli, nActions,rawMemory,ws);
		if(codeRack!=null)
			codeRack.insertCodelet(learner_codelet);
	}
	

	/**
	 * @return the action_selection_codelet
	 */
	public ActionSelectionCodelet getActionSelectionCodelet() {
		return action_selection_codelet;
	}


	/**
	 * @return the sequence_builder_codelet
	 */
	public SequenceBuilderCodelet getSequenceBuilderCodelet() {
		return sequence_builder_codelet;
	}


	/**
	 * @return the learner_codelet
	 */
	public LearnerCodelet getLearnerCodelet() {
		return learner_codelet;
	}
	
}
