package rationals.transformations;

import rationals.Automaton;

/**
 * A generic interface for binary operations between two automata.
 * 
 * @author nono
 * @version $Id: BinaryTransformation.java,v 1.1 2013/03/08 17:53:35 gesteban Exp $
 */
public interface BinaryTransformation {
  public Automaton transform(Automaton a , Automaton b) ;
}
