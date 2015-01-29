package rationals.properties;

import rationals.Automaton;
import rationals.State;

/**
 * Tests if an automaton is normalized.
 * 
 * @see rationals.transformations.Normalizer
 * @author nono
 * @version $Id: isNormalized.java,v 1.1 2013/03/08 17:53:36 gesteban Exp $
 */
public class isNormalized implements UnaryTest {
    public boolean test(Automaton a) {
        if (a.initials().size() != 1)
            return false;
        if (a.terminals().size() != 1)
            return false;
        State e = (State) a.initials().iterator().next();
        if (a.deltaMinusOne(e).size() > 0)
            return false;
        e = (State) a.terminals().iterator().next();
        if (a.delta(e).size() > 0)
            return false;
        return true;
    }
}