package rationals.transformations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import rationals.Automaton;
import rationals.NoSuchStateException;
import rationals.State;
import rationals.Transition;

/**
 * Removes states that neither accessible nor coaccessible.
 * 
 * @author nono
 * @version $Id: Pruner.java,v 1.1 2013/03/08 17:53:35 gesteban Exp $
 */
public class Pruner implements UnaryTransformation {

  public Automaton transform(Automaton a) {
    Map conversion = new HashMap() ;
    Iterator i = a.accessibleAndCoAccessibleStates().iterator();
    Automaton b = new Automaton() ;
    while(i.hasNext()) {
      State e = (State) i.next() ;
      conversion.put(e , b.addState(e.isInitial() , e.isTerminal())) ;
    }
    i = a.delta().iterator();
    while(i.hasNext()) {
      Transition t = (Transition) i.next() ;
      State bs = (State) conversion.get(t.start()) ;
      State be = (State) conversion.get(t.end()) ;
      if(bs == null || be == null)
          continue;
      try {
        b.addTransition(new Transition(
          bs,
          t.label() ,
          be)) ;
      } catch (NoSuchStateException x) {}
    }
    return b ;
  }
}
  
