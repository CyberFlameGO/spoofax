package org.metaborg.spoofax.core.unit;

import org.metaborg.core.messages.IMessage;
import org.spoofax.interpreter.terms.IStrategoTerm;

/**
 * Wraps a {@link Unit} and {@link ParseContrib} as {@link ISpoofaxParseUnit}.
 */
public class ParseUnit extends UnitWrapper implements ISpoofaxParseUnit {
    private final ParseContrib contrib;
    private final ISpoofaxInputUnit inputUnit;


    public ParseUnit(Unit unit, ParseContrib contrib, ISpoofaxInputUnit inputUnit) {
        super(unit);
        this.contrib = contrib;
        this.inputUnit = inputUnit;
    }


    @Override public boolean valid() {
        return contrib.valid;
    }

    @Override public boolean success() {
        return contrib.success;
    }

    @Override
    public boolean isAmbiguous() {
        return contrib.isAmbiguous();
    }

    @Override public IStrategoTerm ast() {
        return contrib.ast;
    }

    @Override public Iterable<IMessage> messages() {
        return contrib.messages;
    }

    @Override public ISpoofaxInputUnit input() {
        return inputUnit;
    }

    @Override public long duration() {
        return contrib.duration;
    }
}
