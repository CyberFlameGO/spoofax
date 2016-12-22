package org.metaborg.spoofax.core.unit;

import javax.annotation.Nullable;

import org.metaborg.core.messages.IMessage;
import org.metaborg.core.unit.IUnitContrib;
import org.metaborg.util.iterators.Iterables2;
import org.spoofax.interpreter.terms.IStrategoTerm;

public class AnalyzeContrib implements IUnitContrib {
    public final boolean valid;
    public final boolean success;
    public final boolean hasAst;
    public final @Nullable IStrategoTerm ast;
    public final Iterable<IMessage> messages;
    public final long duration;


    public AnalyzeContrib(boolean valid, boolean success, boolean hasAst,
            @Nullable IStrategoTerm ast, Iterable<IMessage> messages, long duration) {
        this.valid = valid;
        this.success = success;
        this.hasAst = hasAst;
        this.ast = ast;
        this.messages = messages;
        this.duration = duration;
    }

    public AnalyzeContrib() {
        this(true, true, false, null, Iterables2.<IMessage>empty(), -1);
    }


    @Override public String id() {
        return "analyze";
    }
}
