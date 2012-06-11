/*
 */
package sim.tricycle.mapping;

import sim.tricycle.mapping.mapException.CaseMultipleObjetException;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class Piece extends AbstractObjet {

    public Piece(Case pos) {
        this.pos = pos;
        pos.setItem(this);
    }

    @Override
    public TypeCase whoIam() {
            return (TypeCase.piece);
        }
    
            public String toString(){
            return "P";
        }
    }
    